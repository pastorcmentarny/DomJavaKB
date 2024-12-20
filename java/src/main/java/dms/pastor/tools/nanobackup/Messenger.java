package dms.pastor.tools.nanobackup;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.util.Properties;

import static ch.qos.logback.core.util.OptionHelper.isEmpty;
import static dms.pastor.tools.nanobackup.Constants.MESSAGE_PATH;

/**
 * Author Dominik Symonowicz
 * WWW:	<a href="https://dominiksymonowicz.com/">HOME PAGE</a>
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 * <p>
 * This is my first project after graduation in 2010. Do not expect too much :)
 */
public class Messenger {

    public static final String PRE_CHECK = "Doing pre-check... ";
    public static final String CREATING_BACKUP_DIR = "Creating backup folder...";
    public static final String BACKUP_IN_PROGRESS = "Backup in progress...\n";
    public static final String ITEM_COUNTING = "Calculating total item copied...";
    public static final String BACKUP_SIZE = "Calculating total size of backup...";
    public static final String REMOVING_NON_EXIST_ITEMS = "(Removing non exist items))";
    public static final String REMOVE_DUPLICATES = "(Removing duplicate entries)";
    public static final String DESTINATION_PATH_CHECK = "(Checking is destination path exists)";
    public static final String ENOUGH_SPACE_CHECK = "(Check is it enough space for backup)";
    public static final String PRE_CHECK_COMPLETED = "Pre-check is completed.";
    private static final Logger LOGGER = LoggerFactory.getLogger(Messenger.class);
    private final Properties properties = new Properties();
    private boolean missingMessageFile;

    public Messenger() {
        try (FileInputStream fileInputStream = new FileInputStream(MESSAGE_PATH)) {
            properties.load(fileInputStream);
            missingMessageFile = false;
        } catch (Exception exception) {
            LOGGER.debug("It was problem with message.properties because " + exception.getMessage());
            missingMessageFile = true;
        }
    }


    public static void errorMessage(String what, String message, Throwable exception) {
        String error = what + " encountered an error: '" + message + "'\n\tCause: '" + exception.getCause()
                + "'\n\tError message: '" + exception.getMessage() + "'\n Exception message:\n\n ";
        LOGGER.warn(error, exception);
    }

    public String getMsg(String type) {
        if (missingMessageFile || isEmpty(properties.getProperty(type))) {
            return "Error message cannot be displayed,because\n1. error message is not defined yet\n2. it seems like one of program's file \"message.properties\" is missing.Copy this file into program folder from nanoBackup.zip";
        } else {
            return properties.getProperty(type);
        }
    }
}
