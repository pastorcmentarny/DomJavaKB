package dms.pastor.utils.file;

import dms.pastor.domain.ShutdownHook;
import dms.pastor.domain.exception.SomethingWentTerribleWrongError;
import dms.pastor.domain.exception.SomethingWentWrongException;
import dms.pastor.utils.ValidatorUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;
import java.nio.charset.StandardCharsets;

import static dms.pastor.utils.StringUtils.EMPTY_STRING;
import static dms.pastor.utils.ValidatorUtils.*;
import static java.lang.Runtime.getRuntime;

/**
 * Author Dominik Symonowicz
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 * tag-try-with-resources
 */
public final class FileUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(FileUtils.class);
    private static FileChannel channel;
    private static FileLock lockFile;
    private static File file;

    private FileUtils() {
    }

    public static boolean isFilesExists(String[] filesPath) {
        if (filesPath == null || filesPath.length == 0) {
            return false;
        }
        for (String aFilesPath : filesPath) {
            if (!new File(aFilesPath).exists()) {
                System.out.println("Invalid path:" + aFilesPath);
                return false;
            }
        }
        return true;
    }

    public static File getFileIfPathExists(String filePath) {
        validateIfFileIsAccessible(filePath);
        return new File(filePath);
    }

    @SuppressWarnings("ConstantConditions") //resource is check for null before
    public static File getPathToResource(String pathToResource) {
        validateIfNotEmpty(pathToResource, "path");
        final var resource = FileUtils.class.getClassLoader().getResource(pathToResource);
        validateIfObjectValueIsNotNull(resource, "path");
        return new File(resource.getPath());
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

    /**
     * Lock program,so it can be run once per time.
     */
    public static void lock() {
        file = new File("program.lock");
        try (RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw")) {
            if (file.exists() && !file.delete()) {
                LOGGER.info("It seems like another instance of program is run ");
            }
            channel = randomAccessFile.getChannel();
            lockFile = channel.tryLock();
            if (lockFile == null) {
                channel.close();
                throw new SomethingWentWrongException("Two instance cant run at a time.");
            }
            ShutdownHook shutdownHook = new ShutdownHook();
            getRuntime().addShutdownHook(shutdownHook);
        } catch (OverlappingFileLockException e) {
            LOGGER.error("Lock already acquired by this program!");
        } catch (IOException e) {
            final String message = "Could not start process.";
            LOGGER.error(message, e);
            throw new SomethingWentWrongException(message, e);
        }
    }

    public static void unlockFile() {
        if (file != null) {
            throwExceptionIfDeleteUnsuccessful(file);
        }
        try {
            if (lockFile != null) {
                lockFile.release();
                channel.close();
                if (file.exists()) {
                    throwExceptionIfDeleteUnsuccessful(file);
                }
            }
        } catch (IOException e) {
            LOGGER.warn("Unable to unlock program.It cans cause problem with running program.\nProgram should work after restart of your computer.");
        }
    }

    private static void throwExceptionIfDeleteUnsuccessful(File file) {
        ValidatorUtils.validateIfObjectValueIsNotNull(file);
        ValidatorUtils.validateIfFileIsAccessible(file.getAbsolutePath());
        final var result = file.delete();
        if (!result) {
            LOGGER.warn("Unable to delete lock file. Delete this file: " + file.getAbsolutePath() + " and restart program.");
            throw new SomethingWentWrongException("Unable to delete this file :( " + file.getAbsolutePath());
        }
    }


    //example try-with-resources
    public static String readRawData(String filePath) {
        validateIfFileIsAccessible(filePath);
        File file = new File(filePath);

        StringBuilder sb = new StringBuilder(EMPTY_STRING);
        try (FileInputStream fis = new FileInputStream(file);
             InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
             BufferedReader br = new BufferedReader(isr)) {

            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }

        } catch (IOException exception) {
            throw new SomethingWentTerribleWrongError(exception.getMessage());
        }
        return sb.toString();
    }

    public static boolean isFileExists(String file) {
        return isFilesExists(new String[]{file});
    }

    public static boolean isFileNotExists(String path) {
        return !isFilesExists(new String[]{path});
    }

    public static boolean isDirectoryExists(String pathToDirectory) {
        return new File(pathToDirectory).isDirectory();
    }

    public static boolean isDirectoryNotExists(String pathToDirectory) {
        return !isDirectoryExists(pathToDirectory);
    }
}