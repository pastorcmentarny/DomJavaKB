package dms.pastor.tools.nanobackup;

import dms.pastor.tools.nanobackup.tools.FileTools;
import dms.pastor.utils.FileUtils;
import dms.pastor.utils.ValidatorUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import static dms.pastor.tools.nanobackup.Constants.DEFAULT_PATH;
import static dms.pastor.tools.nanobackup.Constants.SETTINGS_PATH;
import static dms.pastor.utils.ValidatorUtils.validateIfObjectValueIsNotNull;
import static java.lang.String.format;

/**
 * Author Dominik Symonowicz
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
@SuppressWarnings({"ClassWithTooManyFields", "OverlyComplexClass", "ClassWithTooManyMethods"}) //because is settings
public final class Settings {

    public static final String SRC_FILE_ENDING = ".txt";
    private static final String SETTINGS_FILE_ENDING = ".properties";
    private static final Logger LOGGER = LoggerFactory.getLogger(Constants.class);
    private static final Dimension NO_DIMENSION = new Dimension(0, 0);
    //GUI settings
    private static final Dimension MESSAGE_HISTORY_DIMENSION = new Dimension(425, 550);
    private static final Dimension BACKUP_GUI_DIMENSION = new Dimension(500, 200);
    private static Settings settings;
    private static String beforeBackupJobPath = null;
    private static String afterBackupJobPath = null;
    private final Properties properties = new Properties();
    //settings
    private boolean confirmOnExit;
    private boolean exitAfterBackup;
    private boolean deleteSourceAfterBackup;
    private boolean quickBackup;
    private boolean happyMode;
    private String nonQuickPath;
    private boolean saveAsZip;
    private boolean saveResultsToFile;
    private boolean checkFreeSpaceBeforeBackup;
    private boolean speedLightMode;
    private boolean encrypted;
    private int cpuPriority = Integer.MAX_VALUE;
    private String sourceFilePath;
    private String destinationFolderPath;

    private Settings() {
        //loadSettings();
    }

    public static Dimension getDimensionFor(String what) {
        switch (what) {
            case "MESSAGE_HISTORY_DIMENSION":
                return MESSAGE_HISTORY_DIMENSION;
            case "backupGui":
                return BACKUP_GUI_DIMENSION;
            default:
                return NO_DIMENSION;
        }
    }

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

    private void setDefaultSaveResultsToFile() {
        saveResultsToFile = false;
    }

    public boolean isSaveResultsToFile() {
        return saveResultsToFile;
    }

    public void setSaveResultsToFile(boolean saveResultsToFile) {
        this.saveResultsToFile = saveResultsToFile;
    }


    public boolean isSaveAsZip() {
        return saveAsZip;
    }

    public void setSaveAsZip(boolean saveAsZip) {
        this.saveAsZip = saveAsZip;
    }

    private void setDefaultSaveAsZip() {
        setSaveAsZip(false);
    }


    public String getNonQuickPath() {
        if (nonQuickPath == null) {
            return getSourceFilePath();
        } else {
            return nonQuickPath;
        }

    }

    public void setNonQuickPath(String nonQuickPath) {
        this.nonQuickPath = nonQuickPath;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

    public boolean isConfirmOnExit() {
        return confirmOnExit;
    }

    public void setConfirmOnExit(boolean confirmOnExit) {
        this.confirmOnExit = confirmOnExit;
    }

    private void setDefaultConfirmOnExit() {
        setConfirmOnExit(false);
    }


    public boolean isExitAfterBackup() {
        return exitAfterBackup;
    }


    public void setExitAfterBackup(boolean exitAfterBackup) {
        this.exitAfterBackup = exitAfterBackup;
        //saveSettings();
    }

    private void setDefaultExitAfterBackup() {
        setExitAfterBackup(false);
    }

    public boolean isDeleteSourceAfterBackup() {
        return deleteSourceAfterBackup;
    }

    public void setDeleteSourceAfterBackup(boolean deleteSourceAfterBackup) {
        this.deleteSourceAfterBackup = deleteSourceAfterBackup;
    }

    private void setDefaultDeleteSourceAfterBackup() {
        setDeleteSourceAfterBackup(false);
    }

    public boolean isQuickBackup() {
        return quickBackup;
    }


    public void setQuickBackup(boolean quickBackup) {
        this.quickBackup = quickBackup;

    }

    /**
     * Sets default quick backup
     */
    private void setDefaultQuickBackup() {
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


    private void setDefaultDestinationFolderPath() {
        setDestinationFolderPath(DEFAULT_PATH + "BackupFolder");
    }

    public String getSourceFilePath() {
        return sourceFilePath;
    }

    public void setSourceFilePath(String sourceFilePath) {
        this.sourceFilePath = sourceFilePath;
    }

    private void setDefaultSourceFilePath() {
        setSourceFilePath(DEFAULT_PATH + "filesToBackup.txt");
    }

    public boolean isHappyMode() {
        return happyMode;
    }

    public void setHappyMode(boolean happyMode) {
        this.happyMode = happyMode;
    }

    private void setDefaultHappyMode() {
        happyMode = true;
    }

    public void saveProperties() {
        try (FileOutputStream fos = new FileOutputStream(SETTINGS_PATH)) {
            properties.store(fos, "Settings for nanoBackup");
        } catch (IOException ex) {
            LOGGER.warn("Unable to save config file\n" + ex.getCause() + "\n\n" + ex.getMessage());
        }
    }

    public String saveSettingsWithDestSelection() {
        String path = FileTools.createSourceFile(SETTINGS_FILE_ENDING);
        validateIfObjectValueIsNotNull(path, "Path to file");
        if (FileUtils.isFileNotExists(path)) {
            createDefaultSettings();
        }
        ValidatorUtils.validateIfNotEmpty(path);
        try (FileOutputStream fos = new FileOutputStream(path)) {
            properties.store(fos, "Settings for nanoBackup");
        } catch (Exception ex) {
            LOGGER.debug(ex.getCause() + "\n" + ex.getMessage());
            return null;
        }
        return path;
    }

    public boolean loadSettings(boolean withValidateAndSave) {
        return loadSettings(SETTINGS_PATH, withValidateAndSave);
    }

    public boolean loadSettings(String path, boolean withValidateAndSave) {

        if (FileUtils.isFileNotExists(path)) {
            createDefaultSettings();
        }
        try (FileInputStream fis = new FileInputStream(path)) {
            properties.load(fis);
            setSettings();
            if (withValidateAndSave) {
                validateProperties(true);
            }
        } catch (Exception ex) {
            LOGGER.debug(ex.getCause() + "\n" + ex.getMessage());
            return false;
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
        properties.setProperty("settings.saveAsEncrypted", String.valueOf(isSaveAsEncrypted()));
        properties.setProperty("settings.cpuPriority", String.valueOf(getCpuPriority()));
        if (withSave) {
            saveProperties();
        }
    }

    private void setSettings() {
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
        setSaveAsEncrypted(Boolean.parseBoolean(properties.getProperty("settings.saveAsEncrypted")));
        setCpuPriority(Integer.parseInt(properties.getProperty("settings.cpuPriority")));
    }

    public String displayCurrentSettings(String where) {
        return format("\n~~~~Settings Status~~~~\n%s\n-=--=- %s -=--=-\nConfirmOnExit: %s\n" +
                "DeleteSourceAfterBackup: %s\nExitAfterBackup: %s\nQuickBackup: %s\n" +
                "SourceFilePath: %s\nDestinationFolderPath: %s\nHappyMode:%s\n" +
                "Save Backup as zip:%s\nSave paranoid encrypted zip Backup :%s\n" +
                "Save results to file:%s\nCheck free space before backup:%s\nLight Speed Mode:%s\n" +
                "Priority:%d",
            SETTINGS_PATH, where, isConfirmOnExit(), isDeleteSourceAfterBackup(), isExitAfterBackup(),
            isQuickBackup(), getSourceFilePath(), getDestinationFolderPath(), isHappyMode(), isSaveAsZip(),
            isSaveAsEncrypted(), isSaveResultsToFile(), isCheckFreeSpaceBeforeBackup(), isSpeedLightMode(),
            getCpuPriority());
    }

    public boolean createDefaultSettings() {
        LOGGER.debug("creating new settings file");
        //recreate settings.properties 
        if (FileUtils.isFileExists(SETTINGS_PATH)) {
            FileTools.delete(SETTINGS_PATH);
        }

        if (!FileTools.createAFile(SETTINGS_PATH)) {
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
        setDefaultSaveAsEncrypted();
        setDefaultCpuPriority();
        saveProperties();
        return true;
    }

    public void validateProperties(boolean withSave) {

        validateConfirmOnExit();
        validateExistAfterBackup();
        validateDeleteSrcAfterBackupProperty();
        validateQuickBackupProperty("settings.quickBackup", String.valueOf(isQuickBackup()));
        validateSourceFileProperty("source.file", String.valueOf(getSourceFilePath()));
        validateDestinationFolderProperty("destination.folder", String.valueOf(getDestinationFolderPath()));

        validateHappyModeProperty();

        validateSaveResultToFileProperty();

        validateSaveAsZipProperty();
        validateCheckFreeSpaceProperty();

        validateSaveEncryptedProperty();

        validateCpuPriorityProperty();

        setProperties(withSave);

    }

    private void validateDeleteSrcAfterBackupProperty() {
        String temp;
        temp = properties.getProperty("settings.deleteSourceAfterBackup");
        if (temp == null) {
            setDefaultDeleteSourceAfterBackup();
            properties.setProperty("settings.deleteSourceAfterBackup", String.valueOf(isDeleteSourceAfterBackup()));
        }
    }

    private void validateQuickBackupProperty(String key, String value) {
        String temp;
        temp = properties.getProperty(key);
        if (temp == null) {
            setDefaultQuickBackup();
            properties.setProperty(key, value);
        }
    }

    private void validateSourceFileProperty(String key, String value) {
        validateQuickBackupProperty(key, value);
    }

    private void validateDestinationFolderProperty(String key, String value) {
        validateSourceFileProperty(key, value);
    }

    private void validateHappyModeProperty() {
        String temp;
        temp = properties.getProperty("settings.happyMode");
        if (temp == null) {
            setDefaultHappyMode();
            properties.setProperty("settings.happyMode", String.valueOf(isHappyMode()));
        }
    }

    private void validateSaveResultToFileProperty() {
        String temp;
        temp = properties.getProperty("settings.saveResultsToFile");
        if (temp == null) {
            setDefaultSaveResultsToFile();
            properties.setProperty("settings.saveResultsToFile", String.valueOf(isSaveResultsToFile()));
        }
    }

    private void validateSaveAsZipProperty() {
        validateDestinationFolderProperty("settings.saveAsZip", String.valueOf(isSaveAsZip()));
    }

    private void validateCheckFreeSpaceProperty() {
        String temp;
        temp = properties.getProperty("settings.checkFreeSpaceBeforeBackup");
        if (temp == null) {
            setDefaultCheckFreeSpaceBeforeBackup();
            properties.setProperty("settings.checkFreeSpaceBeforeBackup", String.valueOf(isCheckFreeSpaceBeforeBackup()));
        }
    }

    private void validateSaveEncryptedProperty() {
        String temp;
        temp = properties.getProperty("settings.saveAsEncrypted");
        if (temp == null) {
            setDefaultSaveAsEncrypted();
            properties.setProperty("settings.saveAsEncrypted", String.valueOf(isSaveAsEncrypted()));
        }
    }

    private void validateCpuPriorityProperty() {
        String temp;
        temp = properties.getProperty("settings.cpuPriority");
        if (temp == null) {
            setDefaultCpuPriority();
            properties.setProperty("settings.cpuPriority", String.valueOf(getCpuPriority()));
        }
    }

    private void validateExistAfterBackup() {
        String temp;
        temp = properties.getProperty("settings.exitAfterBackup");
        if (temp == null) {
            setDefaultExitAfterBackup();
            properties.setProperty("settings.exitAfterBackup", String.valueOf(isExitAfterBackup()));
        }
    }

    private void validateConfirmOnExit() {
        String temp;
        temp = properties.getProperty("settings.confirmOnExit");
        if (temp == null) {
            setDefaultConfirmOnExit();
            properties.setProperty("settings.confirmOnExit", String.valueOf(isConfirmOnExit()));
        }
    }

    public boolean isCheckFreeSpaceBeforeBackup() {
        return checkFreeSpaceBeforeBackup;
    }

    public void setCheckFreeSpaceBeforeBackup(boolean checkFreeSpaceBeforeBackup) {
        this.checkFreeSpaceBeforeBackup = checkFreeSpaceBeforeBackup;
    }

    private void setDefaultCheckFreeSpaceBeforeBackup() {
        setCheckFreeSpaceBeforeBackup(true);
    }

    public boolean isSpeedLightMode() {
        return speedLightMode;
    }

    public void setSpeedLightMode(boolean speedLightMode) {
        this.speedLightMode = speedLightMode;
    }

    private void setDefaultSpeedLightMode() {
        setSpeedLightMode(false);
    }

    public boolean isSaveAsEncrypted() {
        return encrypted;
    }

    public void setSaveAsEncrypted(boolean encrypted) {
        this.encrypted = encrypted;
    }

    private void setDefaultSaveAsEncrypted() {
        setSaveAsEncrypted(false);
    }

    public int getCpuPriority() {
        return cpuPriority;
    }

    public void setCpuPriority(int cpuPriority) {
        this.cpuPriority = cpuPriority;
    }

    public int getPriorityForBackup() {

        switch (cpuPriority) {
            case 0:
                return Thread.MIN_PRIORITY;
            case 2:
                return Thread.MAX_PRIORITY;
            default:
                return Thread.NORM_PRIORITY;
        }
    }

    private void setDefaultCpuPriority() {
        setCpuPriority(1);
    }

}
