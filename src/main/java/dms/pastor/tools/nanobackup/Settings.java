package dms.pastor.tools.nanobackup;

import dms.pastor.tools.nanobackup.tools.FileTools;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @author Dominik Symonowicz
 * <p>
 * Settings managment.
 * <p>
 * <p>
 * To add new setting you need: * Create variable * add setters , getters and
 * set default method * add below code to validate and save properties * add
 * below code to set settings * (optional) add display current settings
 */
public final class Settings {

    //private internalVariables
    public static final String DATAPATH = "data" + System.getProperty("file.separator");
    public static final String DEFAULTPATH = System.getProperty("user.dir") + System.getProperty("file.separator");
    public static final String SETTINGSPATH = DATAPATH + "settings.properties";
    public static final String RECENT_SRC_PATHS_FILE = DATAPATH + "recentSrcPaths.nbd";
    public static final String RECENT_DEST_PATHS_FILE = DATAPATH + "recentDestPaths.nbd";
    public static final String QUICKMODE_FILENAME = "quickmode.nbd";
    public static final String SRC_FILE_ENDING = ".txt";
    public static final String SETTINGS_FILE_ENDING = ".properties";
    private static final Logger LOGGER = LoggerFactory.getLogger(Settings.class);
    public static String PROPETIES_FILE_ENDING;
    public static String AUTHOR = "made by nanoBackup by Pastor Cmentarny (\"http://pastor.ovh.org).\n";
    private static Settings settings;
    /**
     * improve code below and use instead of int ,so it will be meaningful
     * <p>
     * public static enum PriorityName{
     * MAX(2),MIN(0),NORMAL(1);
     * private final int x;
     * PriorityName(int x){
     * this.x = x;
     * }
     * <p>
     * public int getCode() {
     * return x;
     * }
     * }
     */


    //GUI settings
    private static Dimension hisotryOfMessageGUI = new Dimension(425, 550);
    private static Dimension backupGUI = new Dimension(500, 200);
    private static String beforeBackupJobPath = null;
    private static String afterBackupJobPath = null;
    private Properties properties = new Properties();
    //settings
    private boolean confirmOnExit;
    private boolean exitAfterBackup;
    private boolean deleteSourceAfterBackup;
    private boolean quickBackup;
    private boolean happyMode;
    private String nonQuickPath;//
    private boolean saveAsZip;
    private boolean saveResultsToFile;
    private boolean checkFreeSpaceBeforeBackup;
    private boolean shutdownAfterBackup = false; //TODO remove = false ,when feature will be implemented
    private boolean speedLightMode;
    private boolean crypted;
    private int cpuPriority = Integer.MAX_VALUE;
    //domMode settings
    private boolean domJob;
    private String sourceFilePath;// = null;
    private String destinationFolderPath;// = null;

    private Settings() {
        //loadSettings();
    }

    public static Dimension getDimensionFor(String what) {
        switch (what) {
            case "hisotryOfMessageGUI":
                return hisotryOfMessageGUI;
            case "backupGUI":
                return backupGUI;
            default:
                return null; //TODO NoDimension object

        }
    }

    public static String getDomJob(int number) {
        switch (number) {
            case 1:
                return beforeBackupJobPath;
            case 2:
                return afterBackupJobPath;
            default:
                return null;
        }
    }

    /**
     * @return
     */
    public static synchronized Settings getSettings() {
        if (settings == null) {
            settings = new Settings();
        }
        return settings;
    }

    public void setDomJobs(String beforeBackupJobPath, String afterBackupJobPath) {
        Settings.beforeBackupJobPath = beforeBackupJobPath;
        Settings.afterBackupJobPath = afterBackupJobPath;
        System.out.println(":::" + Settings.beforeBackupJobPath + "\n" + Settings.afterBackupJobPath);
    }

    public void setDefaultSaveResultsToFile() {
        saveResultsToFile = false;
    }

    public boolean isSaveResultsToFile() {
        return saveResultsToFile;
    }

    public void setSaveResultsToFile(boolean saveResultsToFile) {
        this.saveResultsToFile = saveResultsToFile;
    }

    /**
     * @return
     */
    public boolean isSaveAsZip() {
        return saveAsZip;
    }

    /**
     * Sets setting save as zip
     *
     * @param saveAsZip true
     */
    public void setSaveAsZip(boolean saveAsZip) {
        this.saveAsZip = saveAsZip;
    }

    /**
     * Sets default setting "about save as zip"
     */
    public void setDefaultSaveAsZip() {
        setSaveAsZip(false);
    }

    /**
     * @return
     */
    public String getNonQuickPath() {
        if (nonQuickPath == null) {
            return getSourceFilePath();
        } else {
            return nonQuickPath;
        }

    }

    /**
     * @param nonQuickPath
     */
    public void setNonQuickPath(String nonQuickPath) {
        this.nonQuickPath = nonQuickPath;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

    /**
     * @return
     */
    public boolean isConfirmOnExit() {
        return confirmOnExit;
    }

    /**
     * @param confirmOnExit true if dialog will appear to confirm to exit
     */
    public void setConfirmOnExit(boolean confirmOnExit) {
        this.confirmOnExit = confirmOnExit;
    }


    /**
     *
     */
    public void setDefaultConfirmOnExit() {
        setConfirmOnExit(false);
    }

    /**
     * @return true, if program exits after backup.False,otherwise.
     */
    public boolean isExitAfterBackup() {
        return exitAfterBackup;
    }

    /**
     * @param exitAfterBackup true if program will exits after backup,false
     *                        otherwise
     */
    public void setExitAfterBackup(boolean exitAfterBackup) {
        this.exitAfterBackup = exitAfterBackup;
        //saveSettings();
    }

    /**
     *
     */
    public void setDefaultExitAfterBackup() {
        setExitAfterBackup(false);
    }

    /**
     * @return true if source file will be deleted after backup
     */
    public boolean isDeleteSourceAfterBackup() {
        return deleteSourceAfterBackup;
    }

    /**
     * @param deleteSourceAfterBackup Deletes source
     */
    public void setDeleteSourceAfterBackup(boolean deleteSourceAfterBackup) {
        this.deleteSourceAfterBackup = deleteSourceAfterBackup;
    }

    /**
     *
     */
    public void setDefaultDeleteSourceAfterBackup() {
        setDeleteSourceAfterBackup(false);
    }

    /**
     * @return true if quick backup mode is actived
     */
    public boolean isQuickBackup() {
        return quickBackup;
    }

    /**
     * @param quickBackup true/false if quick backup will be
     *                    activated/deactivated
     */
    public void setQuickBackup(boolean quickBackup) {
        this.quickBackup = quickBackup;

    }

    /**
     * Sets default quick backup
     */
    public void setDefaultQuickBackup() {
        setQuickBackup(false);
    }

    /**
     * @return path to destination folder
     */
    public String getDestinationFolderPath() {
        return destinationFolderPath;
    }

    /**
     * @param destinationFolderPath path to destination folder
     */
    public void setDestinationFolderPath(String destinationFolderPath) {
        this.destinationFolderPath = destinationFolderPath;
    }

    /**
     *
     */
    public void setDefaultDestinationFolderPath() {
        setDestinationFolderPath(DEFAULTPATH + "Backupfolder");
    }

    /**
     * Gets source file
     *
     * @return path to source file
     */
    public String getSourceFilePath() {
        return sourceFilePath;
    }

    /**
     * Sets source file
     *
     * @param sourceFilePath
     */
    public void setSourceFilePath(String sourceFilePath) {
        this.sourceFilePath = sourceFilePath;
    }

    /**
     * Sets default source file
     */
    public void setDefaultSourceFilePath() {
        setSourceFilePath(DEFAULTPATH + "filesToBackup.txt");
    }

    /**
     * Check,if happy mode is sets
     *
     * @return
     */
    public boolean isHappyMode() {
        return happyMode;
    }

    /**
     * Sets happy mode
     *
     * @param happyMode
     */
    public void setHappyMode(boolean happyMode) {
        this.happyMode = happyMode;
    }

    /**
     * Sets default happy mode
     */
    public void setDefaultHappyMode() {
        happyMode = true;
    }

    /**
     * Saves settings to file.
     *
     * @return true if settings was saved, false if was any problem.
     */
    public boolean saveProperties() {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(SETTINGSPATH);
            properties.store(fos, "Settings for nanoBackup");
            return true;
        } catch (IOException ex) {
            LOGGER.warn("Unable to save config file\n" + ex.getCause() + "\n\n" + ex.getMessage());
            return false;
        } finally {
            IOUtils.closeQuietly(fos);
        }
    }

    /**
     * Saves settings to file.
     *
     * @return true if settings was saved, false if was any problem.
     */
    public boolean saveSettings() {

        if (!FileTools.isFileExists(SETTINGSPATH)) {
            createDefaultSettings();
        }
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(SETTINGSPATH);
            properties.load(fis);
        } catch (Exception ex) {
            LOGGER.debug(ex.getCause() + "\n" + ex.getMessage());
            return false;
        } finally {
            IOUtils.closeQuietly(fis);
        }
        setSettings();
        return true;
    }

    /**
     * Saves settings to file.
     *
     * @return true if settings was saved, false if was any problem.
     */
    public String saveSettingsWithDestSelection() {
        String path = FileTools.createSourceFile(Settings.SETTINGS_FILE_ENDING);
        if (!FileTools.isFileExists(path)) {
            createDefaultSettings();
        }
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(path);
            properties.store(fos, "Settings for nanoBackup");
        } catch (Exception ex) {
            LOGGER.debug(ex.getCause() + "\n" + ex.getMessage());
            return null;
        } finally {
            IOUtils.closeQuietly(fos);
        }
        return path;
    }

    /**
     * Reads settings from file.
     *
     * @param withValidateAndSave it will validate settings and autosave corrected version
     * @return true if settings was loaded, false if was any problem.
     */
    public boolean loadSettings(boolean withValidateAndSave) {
        return loadSettings(SETTINGSPATH, withValidateAndSave);
    }

    /**
     * Reads settings from file.
     *
     * @param withValidateAndSave it will validate settings and autosave corrected version
     * @return true if settings was loaded, false if was any problem.
     */
    public boolean loadSettings(String path, boolean withValidateAndSave) {

        if (!FileTools.isFileExists(path)) {
            createDefaultSettings();
        }
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(path);
            properties.load(fis);
            setSettings();
            if (withValidateAndSave) {
                validateProperties(withValidateAndSave);
            }
        } catch (Exception ex) {
            LOGGER.debug(ex.getCause() + "\n" + ex.getMessage());
            return false;
        } finally {
            IOUtils.closeQuietly(fis);
        }
        return true;
    }

    /**
     * sets and saves settings to settings file
     */
    public void setProperties(boolean withSave) {
        properties.setProperty("settings.confirmOnExit", String.valueOf(isConfirmOnExit()));
        properties.setProperty("settings.exitAfterBackup", String.valueOf(isExitAfterBackup()));
        properties.setProperty("settings.deleteSourceAfterBackup", String.valueOf(isDeleteSourceAfterBackup()));
        properties.setProperty("settings.quickBackup", String.valueOf(isQuickBackup()));
        properties.setProperty("source.file", String.valueOf(getSourceFilePath()));
        properties.setProperty("destination.folder", String.valueOf(getDestinationFolderPath()));
        properties.setProperty("settings.happyMode", String.valueOf(isHappyMode()));
        properties.setProperty("settings.saveAsZip", String.valueOf(isSaveAsZip()));
        properties.setProperty("settings.checkFreeSpaceBeforeBackup", String.valueOf(isCheckFreeSpaceBeforeBackup()));
        properties.setProperty("settings.saveResultsToFile", String.valueOf(isSaveResultsToFile()));
        properties.setProperty("settings.speedLightMode", String.valueOf(isSpeedLightMode()));
        properties.setProperty("settings.saveAsCrypted", String.valueOf(isSaveAsCrypted()));
        properties.setProperty("settings.cpuPriority", String.valueOf(getCpuPriority()));
        if (withSave) {
            saveProperties();
        }
    }

    /**
     * sets settings in program read from file
     */
    public void setSettings() {
        setConfirmOnExit(Boolean.parseBoolean(properties.getProperty("settings.confirmOnExit")));
        setDeleteSourceAfterBackup(Boolean.parseBoolean(properties.getProperty("settings.deleteSourceAfterBackup")));
        setQuickBackup(Boolean.parseBoolean(properties.getProperty("settings.quickBackup")));
        setExitAfterBackup(Boolean.parseBoolean(properties.getProperty("settings.exitAfterBackup")));
        setQuickBackup(Boolean.parseBoolean(properties.getProperty("settings.quickBackup")));
        setSourceFilePath(properties.getProperty("source.file"));
        setDestinationFolderPath(properties.getProperty("destination.folder"));
        setHappyMode(Boolean.parseBoolean(properties.getProperty("settings.happyMode")));
        setSaveAsZip(Boolean.parseBoolean(properties.getProperty("settings.saveAsZip")));
        setSaveResultsToFile(Boolean.parseBoolean(properties.getProperty("settings.saveResultsToFile")));
        setCheckFreeSpaceBeforeBackup(Boolean.parseBoolean(properties.getProperty("settings.checkFreeSpaceBeforeBackup")));
        setSpeedLightMode(Boolean.parseBoolean(properties.getProperty("settings.speedLightMode")));
        setSaveAsCrypted(Boolean.parseBoolean(properties.getProperty("settings.saveAsCrypted")));
        setCpuPriority(Integer.parseInt(properties.getProperty("settings.cpuPriority")));
    }

    /**
     * @param where
     * @return
     */
    public String displayCurrentSettings(String where) {
        StringBuilder displaySettingsStatus = new StringBuilder();
        displaySettingsStatus.append("\n~~~~Settings Status~~~~\n").append(SETTINGSPATH);
        displaySettingsStatus.append("\n-=--=- ").append(where).append(" -=--=-");
        displaySettingsStatus.append("\nConfirmOnExit: ").append(isConfirmOnExit());
        displaySettingsStatus.append("\nDeleteSourceAfterBackup: ").append(isDeleteSourceAfterBackup());
        displaySettingsStatus.append("\nExitAfterBackup: ").append(isExitAfterBackup());
        displaySettingsStatus.append("\nQuickBackup: ").append(isQuickBackup());
        displaySettingsStatus.append("\nSourceFilePath: ").append(getSourceFilePath());
        displaySettingsStatus.append("\nDestinationFolderPath: ").append(getDestinationFolderPath());
        displaySettingsStatus.append("\nHappyMode:").append(isHappyMode());
        displaySettingsStatus.append("\nSave Backup as zip:").append(isSaveAsZip());
        displaySettingsStatus.append("\nSave paranoid encrypted zip Backup :").append(isSaveAsCrypted());
        displaySettingsStatus.append("\nSave results to file:").append(isSaveResultsToFile());
        displaySettingsStatus.append("\nCheck free space before backup:").append(isCheckFreeSpaceBeforeBackup());
        displaySettingsStatus.append("\nLight Speed Mode:").append(isSpeedLightMode());
        displaySettingsStatus.append("\nPriority:").append(getCpuPriority());
        return displaySettingsStatus.toString();
    }

    /**
     * Creates default settings from scratch
     *
     * @return true if settings are created without problems.False if it was
     * impossible to create file with settings
     */
    public boolean createDefaultSettings() {
        LOGGER.debug("creating new settings file");
        //recreate settings.properties 
        if (FileTools.isFileExists(SETTINGSPATH)) {
            FileTools.delete(SETTINGSPATH);
        }

        if (FileTools.createAFile(SETTINGSPATH)) {
        } else {
            return false;
        }

        setDefaultSourceFilePath();
        setDefaultDestinationFolderPath();
        FileTools.createAFile(getSourceFilePath());
        FileTools.createADirectory(getDestinationFolderPath());
        setDefaultConfirmOnExit();
        setDefaultExitAfterBackup();
        setDefaultDeleteSourceAfterBackup();
        setDefaultQuickBackup();
        setDefaultHappyMode();
        setDefaultSaveAsZip();
        setDefaultSaveResultsToFile();
        setDefaultCheckFreeSpaceBeforeBackup();
        setDefaultSpeedLightMode();
        setDefaultSaveAsCrypted();
        setDefaultCpuPriority();
        saveProperties();
        return true;
    }

    /**
     * Validates settings and set defaults if are not valid and saves settings
     * in the end
     */
    public void validateProperties(boolean withSave) {
        String temp;

        temp = properties.getProperty("settings.confirmOnExit");
        if (temp == null) {
            setDefaultConfirmOnExit();
            properties.setProperty("settings.confirmOnExit", String.valueOf(isConfirmOnExit()));
        }

        temp = properties.getProperty("settings.exitAfterBackup");
        if (temp == null) {
            setDefaultExitAfterBackup();
            properties.setProperty("settings.exitAfterBackup", String.valueOf(isExitAfterBackup()));
        }

        temp = properties.getProperty("settings.deleteSourceAfterBackup");
        if (temp == null) {
            setDefaultDeleteSourceAfterBackup();
            properties.setProperty("settings.deleteSourceAfterBackup", String.valueOf(isDeleteSourceAfterBackup()));
        }

        temp = properties.getProperty("settings.quickBackup");
        if (temp == null) {
            setDefaultQuickBackup();
            properties.setProperty("settings.quickBackup", String.valueOf(isQuickBackup()));
        }


        temp = properties.getProperty("source.file");
        if (temp == null) {
            setDefaultQuickBackup();
            properties.setProperty("source.file", String.valueOf(getSourceFilePath()));
        }

        temp = properties.getProperty("destination.folder");
        if (temp == null) {
            setDefaultQuickBackup();
            properties.setProperty("destination.folder", String.valueOf(getDestinationFolderPath()));
        }

        temp = properties.getProperty("settings.happyMode");
        if (temp == null) {
            setDefaultHappyMode();
            properties.setProperty("settings.happyMode", String.valueOf(isHappyMode()));
        }

        temp = properties.getProperty("settings.saveResultsToFile");
        if (temp == null) {
            setDefaultSaveResultsToFile();
            properties.setProperty("settings.saveResultsToFile", String.valueOf(isSaveResultsToFile()));
        }

        temp = properties.getProperty("settings.saveAsZip");
        if (temp == null) {
            setDefaultQuickBackup();
            properties.setProperty("settings.saveAsZip", String.valueOf(isSaveAsZip()));
        }

        temp = properties.getProperty("settings.checkFreeSpaceBeforeBackup");
        if (temp == null) {
            setDefaultCheckFreeSpaceBeforeBackup();
            properties.setProperty("settings.checkFreeSpaceBeforeBackup", String.valueOf(isCheckFreeSpaceBeforeBackup()));
        }

        temp = properties.getProperty("settings.saveAsCrypted");
        if (temp == null) {
            setDefaultSaveAsCrypted();
            properties.setProperty("settings.saveAsCrypted", String.valueOf(isSaveAsCrypted()));
        }

        temp = properties.getProperty("settings.cpuPriority");
        if (temp == null) {
            setDefaultCpuPriority();
            properties.setProperty("settings.cpuPriority", String.valueOf(getCpuPriority()));
        }

        setProperties(withSave);

    }

    public boolean isCheckFreeSpaceBeforeBackup() {
        return checkFreeSpaceBeforeBackup;
    }

    public void setCheckFreeSpaceBeforeBackup(boolean checkFreeSpaceBeforeBackup) {
        this.checkFreeSpaceBeforeBackup = checkFreeSpaceBeforeBackup;
    }

    public void setDefaultCheckFreeSpaceBeforeBackup() {
        setCheckFreeSpaceBeforeBackup(true);
    }

    //TODO implement is shutdownAfterBackup

    /**
     * NOT IMPLEMENT YET
     *
     * @return false, because is not implement yet.
     */
    public boolean isShutdownAfterBackup() {
        return shutdownAfterBackup;
    }

    public boolean isSpeedLightMode() {
        return speedLightMode;
    }

    public void setSpeedLightMode(boolean speedLightMode) {
        this.speedLightMode = speedLightMode;
    }

    public void setDefaultSpeedLightMode() {
        setSpeedLightMode(false);
    }


    public boolean isSaveAsCrypted() {
        return crypted;

    }

    public void setSaveAsCrypted(boolean crypted) {
        this.crypted = crypted;
    }

    public void setDefaultSaveAsCrypted() {
        setSaveAsCrypted(false);
    }

    public int getCpuPriority() {
        return cpuPriority;
    }

    public void setCpuPriority(int cpuPriority) {
        this.cpuPriority = cpuPriority;
    }

    /**
     * @return priority for backup (normal priority if number is odd
     */
    public int getPriorityForBackup() {

        switch (cpuPriority) {
            case 0:
                return Thread.MIN_PRIORITY;
            case 1:
                return Thread.NORM_PRIORITY;
            case 2:
                return Thread.MAX_PRIORITY;
            default:
                return Thread.NORM_PRIORITY;
        }
    }

    public void setDefaultCpuPriority() {
        setCpuPriority(1);
    }

}
