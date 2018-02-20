package dms.pastor.tools.nanobackup.backup;


import dms.pastor.domain.exception.NotImplementYetException;
import dms.pastor.tools.nanobackup.Messenger;
import dms.pastor.tools.nanobackup.Settings;
import dms.pastor.tools.nanobackup.tools.AbstractTools;
import dms.pastor.tools.nanobackup.tools.FileTools;
import dms.pastor.tools.nanobackup.tools.TaskUtils;
import dms.pastor.tools.nanobackup.tools.Tools;
import dms.pastor.utils.StringUtils;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.util.Collection;
import java.util.concurrent.*;

import static java.awt.Color.DARK_GRAY;

/**
 * Author Dominik Symonowicz
 * Created: 08.11'2011
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public final class Backup extends AbstractTools {

    private static final Logger LOGGER = LoggerFactory.getLogger(Backup.class);
    private static Backup backup;

    private final Engine utilities = new Engine();
    private JFrame BackupTaskFrame;
    private boolean inProgress = false;
    private Thread backupThread;
    private UpdateInfo updateInfo;
    private StringBuilder results;
    private ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    private final Statistic stats = new Statistic();
    private String destinationDir;

    private Backup() {
        //loadSettings();
    }

    public static synchronized Backup getBackup() {
        if (backup == null) {
            backup = new Backup();
        }
        return backup;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        LOGGER.error("Unable to clone Backup class");
        throw new CloneNotSupportedException("Unable to clone Backup class");
    }

    public boolean isInProgress() {
        return inProgress;
    }

    public void backupGUI(final String[] sources, final String destination, final JFrame GUIFrame) {

        GUIFrame.setVisible(false);

        BackupTaskFrame = new JFrame("Backup");

        JPanel innerPanel = new JPanel();
        innerPanel.setSize(Settings.getDimensionFor("backupGUI"));
        final JProgressBar progressBar = new JProgressBar();
        progressBar.setIndeterminate(false);
        progressBar.setSize(500, 80);
        progressBar.addMouseListener(new ShowStatusMouseAdapter());
        BackupTaskFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        BackupTaskFrame.setTitle("Backup Task");
        BackupTaskFrame.setSize(500, 240);
        BackupTaskFrame.setResizable(false);
        final JTextArea infoTextArea = new JTextArea();
        infoTextArea.setAutoscrolls(true);
        infoTextArea.setFont(new java.awt.Font("Tahoma", 0, 14));
        infoTextArea.setForeground(Color.BLUE);
        infoTextArea.setEditable(false);
        infoTextArea.setSize(470, 100);
        infoTextArea.setWrapStyleWord(true);
        infoTextArea.setLineWrap(true);
        infoTextArea.setRows(4);
        JScrollPane scrollPanel = new JScrollPane(infoTextArea);
        scrollPanel.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        innerPanel.add(scrollPanel);
        BackupTaskFrame.add(progressBar, BorderLayout.CENTER);
        BackupTaskFrame.add(innerPanel, BorderLayout.SOUTH);
        BackupTaskFrame.setVisible(true);
        progressBar.setIndeterminate(true);
        backupThread = new Thread(new BackupTask(sources, destination, GUIFrame, infoTextArea, progressBar), "backup");

        try {
            backupThread.setPriority(settings.getPriorityForBackup());
        } catch (IllegalArgumentException iae) {
            Messenger.errorMessage("Setting priority for backup", "Priority is not in the range.(Please check your setting)", iae);
        } catch (SecurityException se) {
            Messenger.errorMessage("Setting priority for backup", "You cannot modify thread priority.(You quite likely need permission for that)\n", se);
            infoTextArea.setText(infoTextArea.getText() + "Sorry.User's priority cannot be set for this backup(No perrmision?).Program will use default priority instead.");

        }

        WindowListener windowListener = new WindowListener() {

            public void windowOpened(WindowEvent e) {
            }

            public void windowClosing(WindowEvent e) {
                //TODO improve this method 
                if (inProgress) {
                    deleteCopiedAlready();
                }
                GUIFrame.setVisible(true);
                killBackupThread();
                inProgress = false;
            }

            public void windowClosed(WindowEvent windowEvent) {
            }

            public void windowIconified(WindowEvent e) {
            }

            public void windowDeiconified(WindowEvent e) {
            }

            public void windowActivated(WindowEvent e) {
            }

            public void windowDeactivated(WindowEvent e) {
            }

            //TODO improve below code,because it not working ...
            private void deleteCopiedAlready() {
                if (isInProgress()) {
                    LOGGER.debug("Stooping backup...");
                    killBackupThread();
                    infoTextArea.setForeground(Color.ORANGE);
                    updateInfoText(infoTextArea, "Stooping backup...");
                    if (inProgress) {
                        if (JOptionPane.showConfirmDialog(null, msg.getMsg("q.RUSure"), "Do you want delete,what was copied already?", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE) == JOptionPane.YES_OPTION) {
                            infoTextArea.setForeground(Color.RED);
                            infoTextArea.setText("Deleting what was already copied.Program may freeze for while");
                            LOGGER.debug("deleting already copied files to backup...");
                            if (!StringUtils.isStringBlank(destinationDir)) {
                                if (FileTools.isADirectory(destinationDir) || FileTools.isAFile(destinationDir)) {
                                    FileTools.delete(destinationDir);
                                } else {
                                    updateAll(infoTextArea, false, true, "Unable to delete,because destination zipped/folder doesn't exist.");
                                }

                            } else {
                                updateAll(infoTextArea, false, true, "Unable to delete,because destination path is invalid.");
                            }
                        }
                    } else {
                        LOGGER.debug("Closing backup's GUI");
                    }
                    BackupTaskFrame.dispose();
                    inProgress = false;
                }
            }
        };
        BackupTaskFrame.addWindowListener(windowListener);

        backupThread.start();
    }

    public String doCLIBackup(String source, String destination) {
        LOGGER.debug("performing backup(CLI)");
        Engine engine = new Engine();
        String[] srcList = engine.makeList(source);
        return doClassicBackup(srcList, destination, null);
    }

    public String doClassicBackup(String[] sources, String destination, JTextArea info) {
        LOGGER.info("performing backup(plain)");
        updateInfoText(info, "Start performing backup");
        boolean result;
        inProgress = true;
        results = new StringBuilder();

        stats.setBackupType("Uncompressed");
        stats.start();
        updateInfoText(info, Messenger.BACKUP_IN_PROGRESS + Messenger.CREATING_BACKUP_DIR);
        LOGGER.debug(Messenger.CREATING_BACKUP_DIR);

        destinationDir = FileTools.createABackupDirectory(destination);
        if (destinationDir == null) {
            updateAll(info, false, true, "Backup: Program was unable to create a Backup folder.");
            return msg.getMsg("error.createBackupFolder");
        } else {
            updateInfoText(info, "Backup folder created.");
            LOGGER.debug("Backup folder created.");
        }

        for (String source : sources) {
            updateInfoText(info, "Coping file:" + source);
            FileTools.copy(source, destinationDir + System.getProperty("file.separator") + new File(source).getName(), stats);
           /*
            if (FileTools.isAFile(sources[i])) {
                result = FileTools.copyFile(sources[i], destinationDir + System.getProperty("file.separator") + new File(sources[i]).getName(), stats);
                if (result) {
                    String infoMsg = Messenger.COPIED + sources[i];
                    updateInfoText(info, infoMsg);
                    results.append("\n").append(infoMsg);
                    log.debug(infoMsg);
                } else {
                    String infoMsg = Messenger.UNABLE_TO_COPY + sources[i];
                    updateInfoText(info, infoMsg);
                    results.append("\n").append(infoMsg);
                    log.debug(infoMsg);
                }

            } else if (FileTools.isADirectory(sources[i])) {
                result = FileTools.copyFolder(new File(sources[i]), new File(destinationDir), stats);
                if (result) {
                    String infoMsg = Messenger.COPIED + sources[i];
                    updateInfoText(info, infoMsg);
                    results.append("\n").append(infoMsg);
                    log.debug(infoMsg);
                } else {
                    String infoMsg = Messenger.UNABLE_TO_COPY + sources[i];
                    updateInfoText(info, infoMsg);
                    results.append("\n").append(infoMsg);
                    log.debug(infoMsg);
                }

            } else {
                log.warn("Unable to copy:" + sources[i] + ".\n");
                stats.addErrorCount(msg.getMsg("error.unableToCopy") + sources[i] + "!\n");
            }*/
        }
        stats.stop();
        results.append("\nEverything was copied to ").append(destinationDir);
        LOGGER.info("\nEverything was copied to " + destinationDir);

        LOGGER.debug(Messenger.ITEM_COUNTING);
        updateInfoText(info, Messenger.ITEM_COUNTING);
        countItemsCopied();

        updateAll(info, false, false, Messenger.BACKUP_SIZE);
        stats.addSizeOfBackup(stats.getBackupSize());

        return results.append("\n").append(stats.display()).toString();
    }

    private void killBackupThread() {
        killHappyModeThread();

        LOGGER.debug("killing backup thread...");
        if (BackupTaskFrame != null) {
            BackupTaskFrame.dispose();
        }
        if (backupThread != null) {
            try {
                backupThread.interrupt();
            } catch (SecurityException se) {
                Messenger.errorMessage("kill Backup thread", "killing problem", se);
            }

            backupThread = null;
        }

    }

    private void killHappyModeThread() {
        LOGGER.debug("killing happy mode thread...");
        if (scheduler != null) {
            try {
                scheduler.shutdown();
                scheduler.shutdownNow();
            } catch (SecurityException se) {
                Messenger.errorMessage("HappyMode", "killing process", se);
            }
            scheduler = null;
        }
        updateInfo = null;
    }

    private boolean preCheck(String[] sources, String destination, JFrame BackupTaskFrame, JTextArea info) {
        LOGGER.info("performing preCheck ...");
        LOGGER.debug("preCheck: check sources ...");
        updateInfoText(info, Messenger.PRE_CHECK + Messenger.REMOVE_DUPLICATES);
        sources = TaskUtils.removeDuplicateLines(sources);

        updateInfoText(info, Messenger.PRE_CHECK + Messenger.REMOVING_NON_EXIST_ITEMS);
        sources = TaskUtils.removeNonExistsItems(sources);

        if (sources == null) {
            JOptionPane.showConfirmDialog(null, "Nothing to backup!\n\nWHAT HAPPEN?\n\tIt means that list of file/folder contains waste products of digital metabolism but not list of files or folders to backup.\nWHAT TO DO?\n\tAre you using right file with list of items?\n\tDo you have access to your resources?", "WHOOPS", JOptionPane.OK_OPTION, JOptionPane.ERROR_MESSAGE);
            killBackupThread();
            LOGGER.info("Not enough space on device where destination folder is");
            return false;
        }
        LOGGER.debug("preCheck: Sources check completed.");


        LOGGER.debug("preCheck: check destination folder ...");
        updateInfoText(info, Messenger.PRE_CHECK + Messenger.DESTINATION_PATH_CHECK);
        if (!FileTools.isADirectory(destination)) {
            JOptionPane.showConfirmDialog(null, "Destination path is not a folder.Please correct it.!", "WHOOPS", JOptionPane.OK_OPTION, JOptionPane.ERROR_MESSAGE);
            LOGGER.info("Path to destination folder is incorrect");
            killBackupThread();
            return false;
        } else {
            LOGGER.debug("preCheck:destination folder  check completed.");
        }


        if (settings.isCheckFreeSpaceBeforeBackup() || !settings.isSpeedLightMode()) {
            updateInfoText(info, Messenger.PRE_CHECK + Messenger.ENOUGH_SPACE_CHECK);
            LOGGER.debug("preCheck: check is it enough space for backup...");
            if (!FileTools.checkEnoughSpace(stats, sources, destination)) {
                JOptionPane.showConfirmDialog(null, "The is not enough space on device where destination folder is :(.", "WHOOPS", JOptionPane.OK_OPTION, JOptionPane.ERROR_MESSAGE);
                killBackupThread();
                LOGGER.info("Not enough space on device where destination folder is");
                return false;
            } else {
                LOGGER.debug("preCheck: enough space for backup check completed.");

            }
        } else {
            LOGGER.debug("Free space check skipped.");
        }
        updateAll(info, false, false, Messenger.PRE_CHECK_COMPLETED);
        return true;
    }

    private void updateAll(JTextArea info, boolean addToResult, boolean isErrorMessage, String message) {
        LOGGER.debug(message);

        if (info != null) {
            info.setText(info.getText() + "\n" + message + "\n");
        }

        if (isErrorMessage) {
            stats.addErrorCount(message);
        }

        if (addToResult) {//&& results != null) {
            results.append(message);
        }

    }

    /**
     * Below code cause a big problem as throws...
     * "Exception in thread "backup" java.lang.Error: Interrupted attempt to acquire write lock"
     * I have a solution in place,but it suggest that my code doing crap thing ,so i need improve my swing skills
     * TODO solve below problem by http://www.kauss.org/Stephan/swing/index.html
     * http://weblogs.java.net/blog/kgh/archive/2004/10/multithreaded_t.html
     * <p>
     * Quote: "
     */

    private void updateInfoText(JTextArea info, String message) {
        if (info != null) {

            //TODO test this solution
            if (backupThread != null) {
                info.setText(info.getText() + "\n" + message);
            }

        }
    }

    private void countItemsCopied() {
        if (!settings.isSpeedLightMode()) {
            Collection<File> counter = FileUtils.listFiles(new File(destinationDir), null, true);//TODO add throw exception
            int filesNumber = counter.size();
            LOGGER.debug("\nItems copied: " + filesNumber);
            stats.addFileCopied(filesNumber);
        }
    }

    private static class ShowStatusMouseAdapter extends java.awt.event.MouseAdapter {

        @Override
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            Tools.showStatus(new String[0]);
        }
    }

    private class BackupTask implements Runnable {

        private final String dest;
        private final JFrame BackupTaskFrame;
        private final JTextArea info;
        private final JProgressBar bar;
        private final String[] src;

        BackupTask(String[] sources, String destination, JFrame BackupTaskFrame, JTextArea info, JProgressBar bar) {
            src = sources;
            dest = destination;
            this.BackupTaskFrame = BackupTaskFrame;
            this.bar = bar;
            this.info = info;
        }

        public void run() {
            info.setForeground(Color.BLUE);
            LOGGER.info("Perform backup task....");
            stats.resetStats();
            info.setText("Doing preCheck...");
            try {


                if (preCheck(src, dest, BackupTaskFrame, info)) {
                    processBackup();
                } else {
                    LOGGER.info("Pre-check failed,backup cancelled.");
                }
            } catch (Exception e) {
                String error = "Backup throw unexpected error: '" + e.getCause() + "' with error message: '" + e.getMessage() + "'\n Exception message:\n " + "\n\n";
                JOptionPane.showMessageDialog(null, error, "WHOOPS!", JOptionPane.ERROR_MESSAGE);
                LOGGER.warn(error);
            }
            BackupTaskFrame.toBack();
            //killBackupThread();
            //TODO improve this code 
                /*
             * } else { if (FileTools.checkEnoughSpace(src, dest)) {
             * processBackup(); } else { info.setForeground(Color.RED);
             * info.setText("Unable to do Backup due lack of free space on
             * destination drive."); log.debug("Unable to do Backup due lack of
             * free space on destination drive."); bar.setIndeterminate(false);
             * bar.setSize(500, 10); } } } else { info.setForeground(new
             * Color(200, 100, 21)); info.setText("(Backup in progress) I hope
             * you are DAMN SURE that you have enough space,without checking by
             * program."); processBackup(); }
             */

        }

        private boolean processBackup() {
            LOGGER.debug("BACKUP. Processing backup started.");
            info.setForeground(Color.BLUE);
            info.setText("(Backup in progress)  Please wait with patience.\n to cancel backup, simply close this window.");

            activateHappyModeForBackup();
            String domJobTemp = null;

            String results = "";
            try {
                results = performBackup();

            } catch (NotImplementYetException exception) {
                JOptionPane.showConfirmDialog(null, exception.getMessage(), "WHOOPS", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);
            } finally {
                inProgress = false;
            }

            deleteSourceAfterBackup();

            saveResultsToFile(results);
            bar.setIndeterminate(false);

            Tools.exitProgramOnRequest();

            try {
                if (!scheduler.isShutdown() && scheduler != null) {
                    scheduler.shutdown();
                }
            } catch (Exception e) {
                LOGGER.debug("Random problem with shutdown scheduler caused by:" + e.getMessage());
            } finally {
                scheduler = null;
                updateInfo = null;
            }

            info.setForeground(DARK_GRAY);
            updateInfoText(info, results);

            return true; //TODO reimplement rhi
        }

        private String performBackup() {
            if (settings.isSaveAsEncrypted()) {
                throw new NotImplementYetException();
            } else if (settings.isSaveAsZip()) {
                throw new NotImplementYetException();
            } else {
                return doClassicBackup(src, dest, info);
            }
        }

        private void deleteSourceAfterBackup() {

            if (settings.isDeleteSourceAfterBackup()) {
                LOGGER.debug("Deleting source(s) ... after backup");
                updateInfoText(info, "Deleting source(s) ... after backup");
                if (settings.isExitAfterBackup()) {
                    if (TaskUtils.deleteSourceAfterBackup(src)) {
                        utilities.shutdown("exitAfterBackup");
                    } else {
                        utilities.shutdown("disaster");
                    }

                } else if (JOptionPane.showConfirmDialog(null, msg.getMsg("q.RUSure"), "WARNING", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE) == JOptionPane.YES_OPTION) {
                    TaskUtils.deleteSourceAfterBackup(src);
                }
            }
        }

        private void activateHappyModeForBackup() {
            if (settings.isHappyMode() && !settings.isSpeedLightMode()) {
                LOGGER.debug("HappyMode is active");
                try {
                    scheduler = Executors.newScheduledThreadPool(1);
                    updateInfo = new UpdateInfo(info, null);//TODO this wil crash app!
                    final ScheduledFuture<?> scheduleChecking = scheduler.scheduleAtFixedRate(updateInfo, 0, 30, TimeUnit.SECONDS);
                    scheduler.schedule(() -> {
                        scheduleChecking.cancel(true);
                    }, Integer.MAX_VALUE, TimeUnit.DAYS);

                } catch (RejectedExecutionException ree) {
                    LOGGER.debug("Problem with RejectedExecutionException during backup." + ree.getMessage());
                    killHappyModeThread();
                }
            } else {
                LOGGER.debug("HappyMode is NOT active");
            }
        }

        private void saveResultsToFile(String results) {
            if (!inProgress && settings.isSaveResultsToFile()) {
                LOGGER.debug("saving  results to file");
                String sr2f = Settings.DATA_PATH + Tools.getCurrentDateWithTime() + ".txt";
                updateInfoText(info, "Saving results to file:" + sr2f);
                FileTools.saveTextToFile(results, sr2f);
            }
        }
    }
}
