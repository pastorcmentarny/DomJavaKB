package dms.pastor.tools.nanobackup;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.util.Properties;

import static ch.qos.logback.core.util.OptionHelper.isEmpty;

/**
 * @author Pastor
 * <p>
 * It responds for load and display messages  to user
 */
public class Messenger {

    public static final String PATH = "data" + System.getProperty("file.separator") + "\\message.properties";
    public static final String CREATING_BACKUP_DIR = "Creating backup folder...";
    public static final String COPIED = "Copied file/folder : ";
    public static final String COPING = "Coping ";
    public static final String UNABLED_TO_COPY = "It was a problem with copy file/folder from : ";
    public static final String BACKUP_IN_PROGRESS = "Backup in progress...\n";
    public static final String ITEM_COUNTING = "Calculating total item copied...";
    public static final String BACKUP_SIZE = "Calculating total size of backup...";
    public static final String PRECHECK = "Doing precheck... ";
    public static final String REMOVE_DUPLICATES = "(Removing duplicate entries)";
    public static final String REMOVE_NONEXIST_ITEMS = "(Removing non exist items))";
    public static final String DESTINATION_PATH_CHECK = "(Checking is destination path exists)";
    public static final String ENOUGH_SPACE_CHECK = "(Check is it enough space for backup)";
    private static final Logger LOGGER = LoggerFactory.getLogger(Messenger.class);
    public static String PRECHECK_COMPLETED = "Precheck is completed.";
    private Properties properties = new Properties();
    private boolean missingMessageFile = false;

    /**
     * Default constructor (for default language)
     */
    public Messenger() {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(PATH);
            properties.load(fis);
            missingMessageFile = false;
        } catch (Exception ex) {
            LOGGER.debug("It was problem with message.properties because " + ex.getMessage());
            missingMessageFile = true;
        } finally {
            IOUtils.closeQuietly(fis);
        }
    }

    /**
     * Generates error message that is added to log
     *
     * @param what name of method/task where error occured
     * @param e    exception type
     * @return error message
     */
    public static String errorMessage(String what, String message, Throwable e) {
        String error = what + " encountered an error: '" + message + "'\n\tCause: '" + e.getCause()
                + "'\n\tError message: '" + e.getMessage() + "'\n Exception message:\n\n ";
        //+ ExceptionUtils.getStackTrace(e) + "\n\n";
        LOGGER.warn(error, e);
        return error;
    }

    /**
     * It used for test purpose only.
     *
     * @param key  - key (for example error.unableToDelete)
     * @param msg- message (Program was unable to delete)
     * @return true if message was set, false if message.properties doesn't exist)
     */
    public boolean setMsg(String key, String msg) {
        if (missingMessageFile) {
            return false;
        } else {
            properties.setProperty(key, msg);
            return true;
        }
    }

    /**
     * Gets message
     *
     * @param type of message requested to display
     * @return message
     */
    public String getMsg(String type) {
        if (missingMessageFile || isEmpty(properties.getProperty(type))) {
            return "Error message cannot be displayed,because\n1. error message is not defined yet\n2. it seems like one of program's file \"message.properties\" is missing.Copy this file into program folder from nanoBackup.zip";
        } else {
            return properties.getProperty(type);
        }
    }
}
