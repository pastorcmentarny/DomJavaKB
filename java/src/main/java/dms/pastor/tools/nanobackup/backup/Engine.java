package dms.pastor.tools.nanobackup.backup;

import dms.pastor.tools.nanobackup.History;
import dms.pastor.tools.nanobackup.tools.AbstractTools;
import dms.pastor.tools.nanobackup.tools.FileTools;
import dms.pastor.tools.nanobackup.tools.TaskUtils;
import dms.pastor.tools.nanobackup.tools.Tools;
import dms.pastor.utils.FileUtils;
import dms.pastor.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static dms.pastor.tools.nanobackup.Constants.DATA_PATH;
import static dms.pastor.tools.nanobackup.Constants.QUICK_MODE_FILENAME;
import static dms.pastor.utils.StringUtils.EMPTY_STRING;

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

    public void activateQuickBackupMode(JTextField sourceField) {
        LOGGER.debug("Activating quick backup mode.");
        settings.setNonQuickPath(sourceField.getText());
        if (!FileTools.createAFile(QUICK_MODE_FILENAME)) {
            LOGGER.warn("Unable to activate Quick backup mode.");
            return;
        }
        sourceField.setText(new File(QUICK_MODE_FILENAME).getAbsolutePath());
    }

    public void deactivateQuickBackupMode(JTextField sourceField) {
        LOGGER.debug("Deactivating quick backup mode.");
        settings.setNonQuickPath(null);
        if (StringUtils.isStringEmpty(sourceField.getText())) {
            FileTools.delete("quickMode.nbd");
            sourceField.setText(settings.getNonQuickPath());
        }

    }

    //TODO figure out what this mysterious method does
    public void swapDestFolderPaths(String[] paths, String what, String with) {
        List<String> swappedPaths = new ArrayList<>();
        for (String path : paths) {
            if (path.equals(what)) {
                swappedPaths.add(with);
            } else {
                swappedPaths.add(path);
            }
        }
        swappedPaths.toArray(new String[0]);
    }

    public String[] updateRecentFolderPaths(String[] paths, String newPath) {
        if (checkIfNewPathExistInList(paths, newPath)) {
            return paths;
        } else {
            if (paths.length >= 5) {
                System.arraycopy(paths, 1, paths, 0, paths.length - 1);
                paths[paths.length - 1] = newPath;
                return paths;
            } else {
                ArrayList<String> newPaths = new ArrayList<>(Arrays.asList(paths));
                newPaths.add(newPath);
                return newPaths.toArray(new String[0]);
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

    public String chooseFileToLoad() {
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
            path = EMPTY_STRING;
        }
        return path;
    }

    public String[] itselfHealthScan() {
        ArrayList<String> result = new ArrayList<>();
        result.add(0, "OK");
        checkIfDataFolderExists(result);
        checkIfSettingsFileIsValid(result);
        checkIfFileExistsFor(result, DATA_PATH + "changelog.txt", "Non important file changelog.txt doesn't exist. ");
        checkIfFileExistsFor(result, DATA_PATH + "message.properties", "Important file message.properties doesn't exist.");
        checkIfFileExistsFor(result, DATA_PATH + "eula.txt", "Important file (for law  reasons) eula.txt doesn't exist. ");
        return result.toArray(new String[0]);
    }

    private void checkIfFileExistsFor(ArrayList<String> result, String filePath, String errorMessage) {
        if (FileUtils.isFileNotExists(filePath)) {
            result.add(errorMessage);
            Tools.changeToYellowStatus(result);
        }
    }

    private void checkIfSettingsFileIsValid(ArrayList<String> result) {
        if (FileUtils.isFileNotExists(DATA_PATH + "settings.properties")) {
            if (!settings.createDefaultSettings()) {
                result.add("Unable to create settings.properties");
                result.set(0, "ERROR");
            }
        }
    }

    private void checkIfDataFolderExists(ArrayList<String> result) {
        if (FileUtils.isDirectoryNotExists(DATA_PATH)) {
            result.add("Data folder doesn't exist!");
            result.set(0, "ERROR");
        }
    }


    //TODO temporary implementation
    public String[] makeList(String source) {
        File file = new File(source);
        if (!file.exists()) {
            return new String[0];
        }
        ArrayList<String> itemsList = new ArrayList<>();
        String text;
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            while ((text = reader.readLine()) != null) {
                itemsList.add(text);
            }
            String temp[] = new String[itemsList.size()];

            for (int i = 0; i < itemsList.size(); i++) {
                temp[i] = itemsList.get(i);
            }
            return temp;
        } catch (FileNotFoundException ex) {
            LOGGER.warn(ex.getCause() + " occurred with messaged" + ex.getMessage());
            return new String[0];
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, msg.getMsg("error.IOError"), "Whoops", JOptionPane.ERROR_MESSAGE);
            LOGGER.error("IOException happen. " + ex.getCause() + "\n" + ex.getMessage());
            return new String[0];
        }
    }

    public String[] merge2Source(final String[] srcList) {
        final List<String> temp = new ArrayList<>();
        final String[] tempSource = FileTools.chooseFilesToLoad();
        if (tempSource != null && tempSource.length != 0) {
            String[] itemsList;
            for (String aTempSource : tempSource) {
                if (FileUtils.isFileNotExists(aTempSource)) {
                    itemsList = makeList(aTempSource);
                    itemsList = TaskUtils.removeNonExistsItems(itemsList);
                    temp.addAll(Arrays.asList(itemsList));
                    //itemsList = null;
                }
            }
            temp.addAll(Arrays.asList(srcList));
            return temp.toArray(new String[0]);
        } else {
            return new String[0];
        }
    }

    public String[] removeItemsFromList(String[] srcList, JList sourceList) {
        ArrayList<String> toDeleteList = new ArrayList<>();
        ArrayList<String> newList = new ArrayList<>();
        if (Objects.isNull(sourceList)) {
            return new String[0];
        }
        if (!sourceList.isSelectionEmpty()) {
            final List itemsToDelete = sourceList.getSelectedValuesList();
            for (Object anItemsToDelete : itemsToDelete) {
                toDeleteList.add(anItemsToDelete.toString());
            }

            if (!toDeleteList.isEmpty()) {
                for (String aSrcList : srcList) {
                    if (!toDeleteList.contains(aSrcList)) {
                        newList.add(aSrcList);
                    }
                }
            }
        }
        return newList.toArray(new String[0]);
    }


    public void setInfoLabel(Color color, String message, JLabel infoLabel) {
        infoLabel.setForeground(color);
        infoLabel.setText(message);
        history.addMessage(message);
    }

    //TODO improve confirm on exit,because current is temporary solution only

    public void shutdown(final String reason) {
        if (settings.isConfirmOnExit()) {
            if (!"alreadyRun".equals(reason)) {
                if (JOptionPane.showConfirmDialog(null, msg.getMsg("q.RUSure"), "Nooo.... YOU WANT EXIT.. why? why?", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE) == JOptionPane.NO_OPTION) {
                    return;
                }
            }
        }
        LOGGER.debug("Shutting down program....");
        if ("alreadyRun".equalsIgnoreCase(reason)) {
            LOGGER.debug("due another instance of program is running already.");
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
        FileUtils.unlockFile();
        System.exit(0);
    }

// --Commented out by Inspection START (21/02/2018 14:14):
//    public boolean deleteSourceAfterBackup(final String[] sourcesPath) {
//        boolean success;
//        for (String aSourcesPath : sourcesPath) {
//            success = FileTools.delete(aSourcesPath);
//            if (!success) {
//                return false;
//            }
//        }
//        return true;
//    }
// --Commented out by Inspection STOP (21/02/2018 14:14)

    public String[] addItemsToItemsList(String[] srcList, final JTextField sourceField, final String pathType) {
        String[] newSource;
        final ArrayList<String> temp = new ArrayList<>(Arrays.asList(srcList));
        if ("item".equalsIgnoreCase(pathType)) {
            newSource = FileTools.chooseItemsToLoad();
        } else if ("file".equalsIgnoreCase(pathType)) {
            newSource = FileTools.chooseFilesToLoad();
        } else if ("folder".equalsIgnoreCase(pathType)) {
            newSource = FileTools.chooseDirsToLoad();
        } else {
            return new String[0];
        }

        if (newSource != null) {
            temp.addAll(Arrays.asList(newSource));
            srcList = new String[temp.size()];
            for (int i = 0; i < temp.size(); i++) {
                srcList[i] = temp.get(i);
            }
            FileUtils.saveListToFile(srcList, sourceField.getText());
        } else {
            return new String[0];
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