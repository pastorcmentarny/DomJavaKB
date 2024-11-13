package dms.pastor.utils.file;

import dms.pastor.domain.exception.SomethingWentWrongException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

import static dms.pastor.utils.ValidatorUtils.validateIfFileIsAccessible;

/**
 * Author Dominik Symonowicz
 * WWW:	<a href="https://dominiksymonowicz.com/">HOME PAGE</a>
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 * tag-try-with-resources
 */
public final class FileUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(FileUtils.class);


    private FileUtils() {
    }


    public static File getFileIfPathExists(String filePath) {
        validateIfFileIsAccessible(filePath);
        return new File(filePath);
    }



    public static void recreateFileIfExists(String filePath) {
        File file = getFileIfPathExists(filePath);
        if (file.exists()) {
            boolean result = file.delete();
            if (!result) {
                LOGGER.info("Program was unable to delete old text file!");
                throw new SomethingWentWrongException();
            }
        } else {
            try {
                if (!file.createNewFile()) {
                    throw new SomethingWentWrongException();
                }
            } catch (IOException ex) {
                throw new SomethingWentWrongException();
            }
        }
    }



    public static boolean isDirectoryExists(String pathToDirectory) {
        return new File(pathToDirectory).isDirectory();
    }

}