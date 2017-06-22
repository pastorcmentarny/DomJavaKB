package dms.pastor.utils;

import dms.pastor.domain.ShutdownHook;
import dms.pastor.domain.exception.SomethingWentTerribleWrongError;
import dms.pastor.domain.exception.SomethingWentWrongException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;
import java.util.Arrays;
import java.util.List;

import static java.lang.Runtime.getRuntime;

/**
 * Author Dominik Symonowicz
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public final class FileTools {

    private static final Logger LOGGER = LoggerFactory.getLogger(FileTools.class);
    private static final char NEW_LINE = '\n';
    private static FileChannel channel;
    private static FileLock lockFile;
    private static File file;

    static boolean isFilesExists(String[] filesPath) {
        if (filesPath == null || filesPath.length == 0) {
            return false;
        }
        for (String aFilesPath : filesPath) {
            if (!new File(aFilesPath).exists()) {
                return false;
            }
        }
        return true;
    }

    @SuppressWarnings("BooleanMethodNameMustStartWithQuestion")
    static boolean saveListToFile(List<String> content, String file) {
        StringBuilder list = new StringBuilder();
        for (String line : content) {
            list.append(line);
            list.append(NEW_LINE);
        }

        try (FileWriter fileWriter = new FileWriter(file);
             BufferedWriter out = new BufferedWriter(fileWriter)) {
            out.write(list.toString());
        } catch (IOException e) {
            LOGGER.error("Unable to save source list to file: " + file);
            return false;
        }
        return true;
    }

    @SuppressWarnings("BooleanMethodNameMustStartWithQuestion") //as method action is to save
    public static boolean saveListToFile(String[] content, String file) {
        return saveListToFile(Arrays.asList(content), file);
    }

    //TODO replace with better method or find other that do the same job
    @SuppressWarnings("BooleanMethodNameMustStartWithQuestion")
    public static boolean saveTextToFile(String text, String path2file) {
        LOGGER.debug("Saving text to file: " + path2file);
        file = new File(path2file);

        if (file.exists()) {
            boolean result = file.delete();
            if (!result) {
                LOGGER.info("Program was unable to delete old text file!");
            }
        } else {
            try {
                if (!file.createNewFile()) {
                    return false;
                }
            } catch (IOException ex) {
                return false;
            }
        }

        try (PrintWriter out = new PrintWriter(new FileWriter(path2file))) {
            out.print(text);
            //System.out.println("File saved.");
        } catch (IOException ex) {
            LOGGER.error("Unable to create ");
            //TODO Generate error message
            //JOptionPane.showMessageDialog(null, , msg.getMsg("error.createFile"), JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    /*
     * Lock program,so it can be run once per time.
     */
    static void lock() {
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
        try {
            if (lockFile != null) {
                lockFile.release();
                channel.close();
                boolean pass = file.delete();
                if (!pass) {
                    LOGGER.warn("Unable to unlock program.It cans cause problem with running program.\nProgram should work after restart of your computer.");
                }
            }
        } catch (IOException e) {
            LOGGER.warn("Unable to unlock program.It cans cause problem with running program.\nProgram should work after restart of your computer.");
        }
    }

    public static boolean isFileValid(String filePath) {
        if (filePath == null || filePath.isEmpty()) {
            return false;
        }
        File file = new File(filePath);
        return file.exists() && file.canRead();
    }

    //example try-with-resources
    public static String readRawData(File filePath) {
        if (filePath == null || !filePath.exists() || !filePath.canRead()) {
            throw new IllegalArgumentException("File doesn't exist or cannot be read");
        }

        StringBuilder sb = new StringBuilder("");
        try (FileInputStream fis = new FileInputStream(filePath);
             InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
             BufferedReader br = new BufferedReader(isr)) {

            String strLine;
            while ((strLine = br.readLine()) != null) {
                sb.append(strLine);
            }

        } catch (IOException e) {
            throw new SomethingWentTerribleWrongError(e.getMessage());
        }
        return sb.toString();
    }
}