package dms.pastor.tools.nanobackup;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.util.Properties;

import static ch.qos.logback.core.util.OptionHelper.isEmpty;

/**
 * Author Dominik Symonowicz
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class Messenger {

    public static final String PRE_CHECK = "Doing pre-check... ";

    public static final String PATH = "data" + System.getProperty("file.separator") + "\\message.properties";
    public static final String CREATING_BACKUP_DIR = "Creating backup folder...";
    public static final String BACKUP_IN_PROGRESS = "Backup in progress...\n";
    public static final String ITEM_COUNTING = "Calculating total item copied...";
    public static final String BACKUP_SIZE = "Calculating total size of backup...";
    public static final String REMOVING_NON_EXIST_ITEMS = "(Removing non exist items))";
    public static final String REMOVE_DUPLICATES = "(Removing duplicate entries)";
    private static final Logger LOGGER = LoggerFactory.getLogger(Messenger.class);
    public static final String DESTINATION_PATH_CHECK = "(Checking is destination path exists)";
    public static final String ENOUGH_SPACE_CHECK = "(Check is it enough space for backup)";
    public static String PRE_CHECK_COMPLETED = "Pre-check is completed.";
    private Properties properties = new Properties();
    private boolean missingMessageFile = false;

    public Messenger() {
        try (FileInputStream fis = new FileInputStream(PATH)) {
            properties.load(fis);
            missingMessageFile = false;
        } catch (Exception ex) {
            LOGGER.debug("It was problem with message.properties because " + ex.getMessage());
            missingMessageFile = true;
        }
    }


    public static String errorMessage(String what, String message, Throwable e) {
        String error = what + " encountered an error: '" + message + "'\n\tCause: '" + e.getCause()
                + "'\n\tError message: '" + e.getMessage() + "'\n Exception message:\n\n ";
        //+ ExceptionUtils.getStackTrace(e) + "\n\n";
        LOGGER.warn(error, e);
        return error;
    }

    public String getMsg(String type) {
        if (missingMessageFile || isEmpty(properties.getProperty(type))) {
            return "Error message cannot be displayed,because\n1. error message is not defined yet\n2. it seems like one of program's file \"message.properties\" is missing.Copy this file into program folder from nanoBackup.zip";
        } else {
            return properties.getProperty(type);
        }
    }
}
