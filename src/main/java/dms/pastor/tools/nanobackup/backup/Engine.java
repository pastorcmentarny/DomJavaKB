package dms.pastor.tools.nanobackup.backup;

import dms.pastor.tools.nanobackup.History;
import dms.pastor.tools.nanobackup.Settings;
import dms.pastor.tools.nanobackup.tools.AbstractTools;
import dms.pastor.tools.nanobackup.tools.FileTools;
import dms.pastor.tools.nanobackup.tools.TaskUtils;
import dms.pastor.tools.nanobackup.tools.Tools;
import dms.pastor.utils.StringUtils;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Author Dominik Symonowicz
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class Engine extends AbstractTools {

    private static final Logger LOGGER = LoggerFactory.getLogger(Engine.class);
    private final History history = History.getHistoryGUI();

    public boolean activateQuickBackupMode(JTextField sourceField) {
        LOGGER.debug("Activating quick backup mode.");
        settings.setNonQuickPath(sourceField.getText());
        if (!FileTools.createAFile(Settings.QUICKMODE_FILENAME)) {
            return false;
        }
        sourceField.setText(new File(Settings.QUICKMODE_FILENAME).getAbsolutePath());
        return true;
    }

    public void deactivateQuickBackupMode(JTextField sourceField) {
        LOGGER.debug("Deactivating quick backup mode.");
        settings.setNonQuickPath(null);
        if (StringUtils.isStringEmpty(sourceField.getText())) {
            FileTools.delete("quickmode.nbd");
            if (sourceField != null) {
                sourceField.setText(settings.getNonQuickPath());
            } else {
                sourceField.setText("");
            }
        }

    }

    public String[] swapDestFolderPaths(String[] paths, String what, String with) {
        List<String> swappedPaths = new ArrayList<>();
        for (String path : paths) {
            if (path.equals(what)) {
                swappedPaths.add(with);
            } else {
                swappedPaths.add(path);
            }
        }
        return swappedPaths.toArray(new String[swappedPaths.size()]);
    }

    public String[] updateRecentFolderPaths(String[] paths, String newPath) {
        if (checkIfNewPathExistInList(paths, newPath)) {
            return paths;
        } else {
            if (paths.length >= 5) {
                for (int i = 0; i < paths.length - 1; i++) {
                    paths[i] = paths[i + 1];
                }
                paths[paths.length - 1] = newPath;
                return paths;
            } else {
                ArrayList<String> newPaths = new ArrayList<>(Arrays.asList(paths));
                newPaths.add(newPath);
                return newPaths.toArray(new String[newPaths.size()]);
            }
        }

    }

    private boolean checkIfNewPathExistInList(String[] paths, String newPath) {
        for (int i = 0; i < paths.length - 1; i++) {
            if (paths[i].equals(newPath)) {
                return true;
            }
        }
        return false;
    }

    public String chooseFiletoLoad() {
        LOGGER.debug("select file to Load");
        String path;
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        TextFileFilter textFileFilter = new TextFileFilter();
        fileChooser.setFileFilter(textFileFilter);

        int returnVal = fileChooser.showOpenDialog(null);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            path = file.getPath();
        } else {
            path = null;
        }
        return path;
    }

    public String[] itselfHealthScan() {
        ArrayList<String> result = new ArrayList<>();
        result.add(0, "OK");
        if (!FileTools.isDirectoryExists("data")) {
            result.add("Data folder doesn't exist!");
            result.set(0, "ERROR");
        }
        if (!FileTools.isFileExists(Settings.DATAPATH + "settings.properties")) {
            if (!settings.createDefaultSettings()) {
                result.add("Unable to create settings.properties");
                result.set(0, "ERROR");
            }
        }
        if (!FileTools.isFileExists(Settings.DATAPATH + "changelog.txt")) {
            result.add("Non important file changelog.txt doesn't exist. ");
            Tools.changeToYelloStatus(result);
        }
        if (!FileTools.isFileExists(Settings.DATAPATH + "message.properties")) {
            result.add("Important file message.properties doesn't exist.");
            Tools.changeToYelloStatus(result);
        }
        if (!FileTools.isFileExists(Settings.DATAPATH + "eula.txt")) {
            result.add("Important file (for law  reasons) eula.txt doesn't exist. ");
            Tools.changeToYelloStatus(result);

        }
        return result.toArray(new String[result.size()]);
    }


    //TODO temporary implementation

    public String[] makeList(String source) {
        File file = new File(source);
        if (!file.exists()) {
            return new String[0];
        }
        ArrayList<String> itemsList = new ArrayList<>();
        BufferedReader reader = null;
        String text;
        try {
            reader = new BufferedReader(new FileReader(file));
            while ((text = reader.readLine()) != null) {
                itemsList.add(text);
            }
            String temp[] = new String[itemsList.size()];

            for (int i = 0; i < itemsList.size(); i++) {
                temp[i] = itemsList.get(i).toString();
            }
            return temp;
        } catch (FileNotFoundException ex) {
            LOGGER.warn(ex.getCause() + " occured with messaged" + ex.getMessage());
            return new String[0];
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, msg.getMsg("error.IOerror"), "Woops", JOptionPane.ERROR_MESSAGE);
            LOGGER.error("IOException happen. " + ex.getCause() + "\n" + ex.getMessage());
            return new String[0];
        } finally {
            IOUtils.closeQuietly(reader);
        }
    }

    public String[] merge2Source(final String[] srcList) {
        final List<String> temp = new ArrayList<>();
        final String[] tempSource = FileTools.chooseFilestoLoad();
        if (tempSource != null && tempSource.length != 0) {
            String[] itemsList;
            for (String aTempSource : tempSource) {
                if (FileTools.isFileExists(aTempSource)) {
                    itemsList = makeList(aTempSource);
                    itemsList = TaskUtils.removeNonExistsItems(itemsList);
                    temp.addAll(Arrays.asList(itemsList));
                    //itemsList = null;
                }
            }
            temp.addAll(Arrays.asList(srcList));
            return temp.toArray(new String[temp.size()]);
        } else {
            return null;
        }
    }

    public String[] removeItemsFromList(String[] srcList, JList sourceList) {
        Object[] itemsToDelete;
        ArrayList<String> toDeleteList = new ArrayList<>();
        ArrayList<String> newList = new ArrayList<>();
        if (!sourceList.isSelectionEmpty()) {
            try {
                itemsToDelete = sourceList.getSelectedValues();
                for (Object anItemsToDelete : itemsToDelete) {
                    toDeleteList.add(anItemsToDelete.toString());
                }
            } catch (NullPointerException e) {
                return srcList; //TODO return orginal list or null ?
            }
            if (!toDeleteList.isEmpty()) {
                for (String aSrcList : srcList) {
                    if (!toDeleteList.contains(aSrcList)) {
                        newList.add(aSrcList);
                    }
                }
            }
        }
        return newList.toArray(new String[newList.size()]);
    }


    public JLabel setInfoLabel(Color color, String message, JLabel infoLabel) {
        infoLabel.setForeground(color);
        infoLabel.setText(message);
        history.addMessage(message);
        return infoLabel;
    }

    //TODO improve confirm on exit,because currect is temporary solution only

    public boolean shutdown(final String reason) {
        if (settings.isConfirmOnExit()) {
            if (!"alreadyRun".equals(reason)) {
                if (JOptionPane.showConfirmDialog(null, msg.getMsg("q.RUSure"), "Nooo.... YOU WANT EXIT.. why? why?", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE) == JOptionPane.NO_OPTION) {
                    return false;
                }
            }
        }
        LOGGER.debug("Shutting down program....");
        if ("alreadyRun".equalsIgnoreCase(reason)) {
            LOGGER.debug("due another istance of program is running already.");
        } else if ("exitAfterBackup".equalsIgnoreCase(reason)) {
            LOGGER.info("due exit after finished backup.");
        } else if ("disaster".equalsIgnoreCase(reason)) {
            LOGGER.warn("due unrecoverable error that cause massive disaster.");
        } else if ("exitByUser".equalsIgnoreCase(reason)) {
            LOGGER.debug("due user fus");
        } else {
            LOGGER.debug("is time to eat and sleep.");
        }
        settings.saveProperties();
        if (settings.isQuickBackup() && !"alreadyRun".equalsIgnoreCase(reason)) {
            deactivateQuickBackupMode(new JTextField());
        }
        FileTools.unlockFile();
        System.exit(0);
        return true;
    }

    public boolean deleteSourceAfterBackup(final String[] sourcesPath) {
        boolean success;
        for (String aSourcesPath : sourcesPath) {
            success = FileTools.delete(aSourcesPath);
            if (!success) {
                return false;
            }
        }
        return true;
    }

    public String[] addItemsToItemsList(String[] srcList, final JTextField sourceField, final String pathType) {
        String[] newSource;
        final ArrayList<String> temp = new ArrayList<>(Arrays.asList(srcList));
        if ("item".equalsIgnoreCase(pathType)) {
            newSource = FileTools.chooseItemsToLoad();
        } else if ("file".equalsIgnoreCase(pathType)) {
            newSource = FileTools.chooseFilestoLoad();
        } else if ("folder".equalsIgnoreCase(pathType)) {
            newSource = FileTools.chooseDirsToLoad();
        } else {
            return null;
        }

        if (newSource != null) {
            temp.addAll(Arrays.asList(newSource));
            srcList = new String[temp.size()];
            for (int i = 0; i < temp.size(); i++) {
                srcList[i] = temp.get(i).toString();
            }
            FileTools.saveListToFile(srcList, sourceField.getText());
        } else {
            return null;
        }
        return srcList;
    }

    private static class TextFileFilter extends javax.swing.filechooser.FileFilter {

        public boolean accept(File file) {
            return file.getName().toLowerCase().endsWith(".txt") || file.isDirectory();
        }

        @Override
        public String getDescription() {
            return "text file only";
        }
    }
}