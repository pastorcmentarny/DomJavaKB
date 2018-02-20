package dms.pastor.tools.nanobackup.tools;

import dms.pastor.domain.ShutdownHook;
import dms.pastor.tools.nanobackup.Messenger;
import dms.pastor.tools.nanobackup.backup.Statistic;
import dms.pastor.utils.StringUtils;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.io.*;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Objects;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import static dms.pastor.utils.StringUtils.EMPTY_STRING;

/**
 * Author Dominik Symonowicz
 * Created: 09-Jan-2012 10:49:45
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class FileTools {

    private static final long FILE_COPY_BUFFER_SIZE = 1024 * 1024 * 12;//12 megabyte
    private static final Logger LOGGER = LoggerFactory.getLogger(FileTools.class);
    private static final int BUFFER_SIZE = 2048;
    private static File f;
    private static FileChannel channel;
    private static FileLock lockFile;
    private static File file;
    private final Messenger msg = new Messenger();

    public static String displaySize(String path) {
        String sizeMsg = "";
        file = new File(path);
        if (file.isFile()) {
            sizeMsg = FileUtils.sizeOf(file) + " bytes.";
        } else if (file.isDirectory()) {
            sizeMsg = FileUtils.sizeOfDirectory(file) + " bytes.";
        } else {
            LOGGER.warn("N/A");
        }
        return sizeMsg;
    }

    public static long calcSize(String path) {
        long size = 0;
        file = new File(path);
        if (file.isFile()) {
            size = FileUtils.sizeOf(file);
        } else if (file.isDirectory()) {
            size = FileUtils.sizeOfDirectory(file);
        } else {
            LOGGER.warn("N/A");
        }
        return size;
    }

    public static boolean checkEnoughSpace(Statistic stats, String[] sources, String destination) {
        long srcSize = 0;
        for (String source : sources) {
            file = new File(source);
            if (file.exists()) {
                srcSize += FileUtils.sizeOf(new File(source));
                if (stats != null) {
                    stats.setBackupSize(String.valueOf(srcSize));
                }
            }
        }
        return checkFreeSpace(destination) - srcSize > 0;
    }

    private static long checkFreeSpace(String path) {
        return new File(path).getFreeSpace();
    }

    public static String chooseFileToLoad() {
        LOGGER.debug("select file to Load");
        ArrayList<String> path = new ArrayList<>();
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setMultiSelectionEnabled(false);
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int returnVal = fileChooser.showOpenDialog(null);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            return file.getAbsolutePath();
        } else {
            return null;
        }
    }

    public static String[] chooseFilesToLoad() {
        LOGGER.debug("select file to Load");
        ArrayList<String> path = new ArrayList<>();
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setMultiSelectionEnabled(true);
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int returnVal = fileChooser.showOpenDialog(null);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File[] files = fileChooser.getSelectedFiles();
            for (File file1 : files) {
                path.add(file1.getPath());
            }
            return path.toArray(new String[path.size()]);
        } else {
            return null;
        }
        //TODO solve below line issue
        //return (String[]) (path != null? (path.toArray(new String[path.size()])):  path);
    }

    public static String chooseDirToLoad() {
        LOGGER.debug("select folder to Load");
        String path;
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            file = fileChooser.getSelectedFile();
            path = file.getPath();
        } else {
            path = EMPTY_STRING;
            LOGGER.debug("File was not selected");
        }
        return path;
    }

    public static String[] chooseDirsToLoad() {
        LOGGER.debug("select folder to Load");
        ArrayList<String> path = new ArrayList<>();
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        fileChooser.setMultiSelectionEnabled(true);
        int returnVal = fileChooser.showOpenDialog(null);

        if (addPaths(path, fileChooser, returnVal)) return null;

        String results[] = new String[path.size()];

        for (int i = 0; i < path.size(); i++) {
            results[i] = path.get(i);
        }
        return results;
    }

    public static String[] chooseItemsToLoad() {
        ArrayList<String> path = new ArrayList<>();
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setMultiSelectionEnabled(true);
        fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        int returnVal = fileChooser.showOpenDialog(null);

        if (addPaths(path, fileChooser, returnVal)) return null;

        String results[] = new String[path.size()];

        for (int i = 0; i < path.size(); i++) {
            results[i] = path.get(i);
        }
        return results;
    }

    private static boolean addPaths(ArrayList<String> path, JFileChooser fileChooser, int returnVal) {
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File[] files = fileChooser.getSelectedFiles();
            for (File file1 : files) {
                path.add(file1.getPath());
            }
        } else {
            return true;
        }
        return false;
    }

    public static boolean copyFile(String sourceFile, String destinationFile, Statistic stats) {
        LOGGER.debug("copy file from: " + sourceFile + " to " + destinationFile);
        try {
            FileUtils.copyFile(new File(sourceFile), new File(destinationFile));
            return true;
        } catch (IOException ex) {
            if (!(stats == null)) {
                stats.addErrorCount("Program was unable to copy from" + sourceFile + " to " + destinationFile + "during unexpected problem!PLEASE TRY AGAIN\n\n" + ex.getMessage());
            }
            return false;
        }
    }

    private static void doCopyFile(File srcFile, File destFile, Statistic stats) {
        LOGGER.debug("copy file from: " + srcFile + " to " + destFile);
        if (destFile.exists() && destFile.isDirectory()) {
            if (stats != null) {
                stats.addErrorCount("Destination '" + destFile + "' exists but is a directory");
            }
            return;
        }

        long size = -1;
        try (
                FileInputStream fis = new FileInputStream(srcFile);

                FileOutputStream fos = new FileOutputStream(destFile);
                FileChannel input = fis.getChannel();
                FileChannel output = fos.getChannel()
        ) {

            size = input.size();

            long pos = 0;
            long count = 0;
            while (pos < size) {
                count = size - pos > FILE_COPY_BUFFER_SIZE ? FILE_COPY_BUFFER_SIZE : size - pos;

                pos += output.transferFrom(input, pos, count);
            }
        } catch (FileNotFoundException ex) {
            if (stats != null) {
                stats.addErrorCount("Unable to copy file.Source file '" + srcFile + "' not found.(network problem?device disconnected?)");
            }
        } catch (IOException ex) {
            if (stats != null) {
                stats.addErrorCount("Unable to copy file.IO error during coping file.\nPossible reasons:\nNetwork problem?Device disconnected?)");
            }
        }

        if (srcFile.length() != destFile.length()) {
            stats.addErrorCount("Something went wrong. Source and Destination files has different sizes.\n Source: '" + srcFile + "' has " + srcFile.length() + " Destination: '" + destFile + "' has " + destFile.length());
        }
    }


    private static void doCopyDirectory(File srcDir, File destDir, Statistic stats) {
        // recurse
        File[] srcFiles = srcDir.listFiles();
        if (srcFiles == null) {
            if (stats != null) {
                stats.addErrorCount("Source path is not valid Directory(Folder).[list of files is null]");
                return;
            }
        }

        if (destDir.exists()) {
            if (!destDir.isDirectory()) {
                if (stats != null) {
                    stats.addErrorCount("Destination '" + destDir + "' exists but is not a directory");
                }
            }
        } else {
            if (!destDir.mkdirs() && !destDir.isDirectory()) {
                if (stats != null) {
                    stats.addErrorCount("Destination '" + destDir + "' directory cannot be created");
                    return;
                }
            }
        }
        if (!destDir.canWrite()) {
            if (stats != null) {
                stats.addErrorCount("Destination '" + destDir + "' cannot be written to");
            }
        }
        for (File srcFile : srcFiles) {
            File dstFile = new File(destDir, srcFile.getName());
            if (srcFile.isDirectory()) {
                doCopyDirectory(srcFile, dstFile, stats);
            } else {
                doCopyFile(srcFile, dstFile, stats);
            }

        }
    }

    public static boolean copyFolder(File sourceFolder, File destinationFolder, Statistic stats) {
        LOGGER.debug("copying folder from: " + sourceFolder + " to " + destinationFolder);
        try {
            FileUtils.copyDirectoryToDirectory(sourceFolder, destinationFolder);
            return true;
        } catch (IOException ex) {
            if (stats != null) {
                LOGGER.info("Program was unable to copy from" + sourceFolder.getAbsolutePath() + " to " + destinationFolder.getAbsolutePath() + "during unexpected problem!\n\n" + ex.getMessage());
                stats.addErrorCount("Program was unable to copy from" + sourceFolder.getAbsolutePath() + " to " + destinationFolder.getAbsolutePath() + "during unexpected problem!\n\n" + ex.getMessage());
            }
            return false;
        }
    }

    public static void copy(String source, String destinationFolder, Statistic stats) {
        System.out.println(source + " <|>" + destinationFolder);
        File src, dest;
        src = new File(source);
        dest = new File(destinationFolder);
        if (src == null) {
            throw new NullPointerException("Source must not be null");
        }
        if (dest == null) {
            throw new NullPointerException("Destination must not be null");
        }

        if (src.isDirectory()) {
            doCopyDirectory(src, dest, stats);
        } else if (src.isFile()) {
            doCopyFile(src, dest, stats);
        } else {
            stats.addErrorCount("Src is not a file and no");
        }

    }

    public static void copyFileToDirectory(File srcFile, File destDir, Statistic stats) {
        if (destDir == null) {
            throw new NullPointerException("Destination must not be null");
        }
        if (destDir.exists() && !destDir.isDirectory()) {
            throw new IllegalArgumentException("Destination '" + destDir + "' is not a directory");
        }
        File destFile = new File(destDir, srcFile.getName());
        doCopyFile(srcFile, destFile, stats);
    }

    public static boolean createAFile(String filePath) {
        LOGGER.debug("create file in path:" + filePath);
        file = new File(filePath);
        try {
            return file.createNewFile();
        } catch (IOException ex) {
            LOGGER.warn("Program was unable to create file:" + filePath + "Error Message: " + ex.getMessage());
            return false;
        }
    }

    //TODO improve this method

    public static String createABackupZipPath(String path) {
        LOGGER.debug("creating path for backup(compressed in zip)");
        int year = Calendar.getInstance().get(Calendar.YEAR);
        int month = Calendar.getInstance().get(Calendar.MONTH) + 1;
        int day = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
        path = createPath(path, year);
        path = createPath(path, month);
        path = createPath(path, day);


        file = new File(path + System.getProperty("file.separator") + "Backup_" + Tools.getCurrentDateWithTime() + ".zip");
        int next = 1;
        while (file.exists()) {
            file = new File(path + System.getProperty("file.separator") + "Backup_" + Tools.getCurrentDateWithTime() + "_" + next + ".zip");
            if (next == 1000) {
                LOGGER.warn("More than 1000 attempts to created file failed.It is quite likely something when terrible wrong");
                return null;
            }
        }
        return file.getAbsolutePath();
    }

    public static String createABackupDirectory(String path) {
        LOGGER.debug("create backup folder" + path);
        int year = Calendar.getInstance().get(Calendar.YEAR);
        int month = Calendar.getInstance().get(Calendar.MONTH) + 1;
        int day = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);

        path = createPath(path, year);
        path = createPath(path, month);
        path = createPath(path, day);
        path += System.getProperty("file.separator") + Tools.getCurrentTime();

        File dir = new File(path);
        int next = 1;
        boolean test = true;
        while (test) {
            if (dir.exists()) {
                dir = new File(path + "_" + next);
                next++;
            } else {
                test = false;
                createADirectory(path);
            }
        }

        return dir.getPath();

    }

    private static String createPath(String path, int unitOfTime) {
        if (!new File(path + unitOfTime).exists()) {
            path += System.getProperty("file.separator") + unitOfTime;
            createADirectory(path);
        } else {
            path += System.getProperty("file.separator") + unitOfTime;
        }
        return path;
    }

    public static boolean createADirectory(String filePath) {
        file = new File(filePath);
        return file.mkdir();
    }


    public static boolean delete(String filePath) {
        file = new File(filePath);
        try {
            FileUtils.forceDelete(file);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    //TODO remove it
    public static boolean isAFile(String path) {
        return isFileExists(path);
    }

    //TODO remove it
    public static boolean isADirectory(String path) {
        return isDirectoryExists(path);
    }

    public static boolean isFileExists(String filePath) {
        return Objects.nonNull(filePath) && file.isFile();
    }

    public static boolean isDirectoryExists(String filePath) {
        return Objects.nonNull(filePath) && file.isDirectory();
    }

    public static boolean saveListToFile(String[] content, String file) {
        StringBuilder list = new StringBuilder();
        for (int i = 0; i < content.length; i++) {
            if (i == content.length - 1) {
                list.append(content[i]);
            } else {
                list.append(content[i]);
                list.append("\n");
            }
        }
        try (FileWriter fileWriter = new FileWriter(file);
             BufferedWriter out = new BufferedWriter(fileWriter)
        ) {
            out.write(list.toString());
        } catch (IOException e) {
            LOGGER.error("Unable to save source list to file: " + file);
            return false;
        }
        return true;
    }

    public static boolean saveTextToFile(String text, String path2file) {
        LOGGER.debug("Saving text to file: " + path2file);
        file = new File(path2file);
        PrintWriter out = null;
        if (file.exists()) {
            boolean result = file.delete();
            if (!result) {
                LOGGER.info("Failed. (Program was unable to delete old text file!)");
            }
        } else {
            try {
                if (!file.createNewFile()) {
                    LOGGER.debug("Failed. (Program was unable to create file.)");
                    return false;
                } else {
                    LOGGER.debug("File created. Saving date into file...");
                }
            } catch (IOException ex) {
                LOGGER.info("Failed. (Program was unable to delete old text file.(Network problem?Device disconnected?not enough free space?)" + ex.getMessage());//TODO move message to message properties!
                return false;
            }
        }

        try {
            out = new PrintWriter(new FileWriter(path2file));
            out.print(text);

        } catch (IOException ex) {
            LOGGER.info("Failed. (Program was unable to delete old text file.(Network problem?Device disconnected?not enough free space?)" + ex.getMessage());//TODO move message to message properties!
            return false;
        } finally {
            if (out != null) {
                out.close();
            }
        }
        LOGGER.debug("Success! Text saved to file.");
        return true;
    }

    public static boolean replace(String whatPath, String fromPath, String file) {
        if (file != null) {
            delete(whatPath + System.getProperty("file.separator") + file);
        } else {
            delete(whatPath);
        }
        try {
            if (file == null) {
                FileUtils.copyDirectory(new File(fromPath), new File(whatPath));
            } else {
                FileUtils.copyFile(new File(fromPath + System.getProperty("file.separator") + file), new File(whatPath + System.getProperty("file.separator") + file));
            }
        } catch (IOException ex) {
            //TODO create a error message
            LOGGER.info("Unable to replace file" + ex.getCause() + "\n" + ex.getMessage());
            return false;
        }
        return true;
    }

    //TODO improve this method by better error messages and etc

    public static void lock() {
        try {
            f = new File("program.lock");
            if (f.exists() && !f.delete()) {
                LOGGER.info("It seems like another instance of program is run ");

            }
            channel = new RandomAccessFile(f, "rw").getChannel();
            lockFile = channel.tryLock();
            if (lockFile == null) {
                channel.close();
                throw new RuntimeException("Two instance cant run at a time.");
            }
            ShutdownHook shutdownHook = new ShutdownHook();
            Runtime.getRuntime().addShutdownHook(shutdownHook);
        } catch (IOException e) {
            throw new RuntimeException("Could not start process.", e);
        }
    }

    public static void unlockFile() {
        try {
            if (lockFile != null) {
                lockFile.release();
                channel.close();
                boolean pass = f.delete();
                if (!pass) {
                    LOGGER.warn("Unable to unlock program.It cans cause problem with running program.\nProgram should work after restart of your computer.");
                }
            }
        } catch (IOException e) {
            LOGGER.warn("Unable to unlock program.It cans cause problem with running program.\nProgram should work after restart of your computer.");
        }
    }

    //TODO IMPROVE THIS GARBAGE this method doesn't need a return ?

    private static boolean zipFolder(String[] folderPath, ZipOutputStream out, StringBuilder results, Statistic stats) {
        if (folderPath == null) {
            stats.addErrorCount("Problem source file/folder found.Backup cancelled.");
            return false;
        }
        stats.addFileCopied(1);
        for (String aFolderPath : folderPath) {
            if (isADirectory(aFolderPath)) {
                String[] x = new File(aFolderPath).list();
                String[] listInDir = new String[x.length];
                for (int ix = 0; ix < x.length; ix++) {
                    listInDir[ix] = aFolderPath + System.getProperty("file.separator") + x[ix];
                }
                zipFolder(listInDir, out, results, stats);
            } else {
                zipFile(aFolderPath, out, stats);
            }
        }
        return true;
    }

    private static boolean zipFile(String path, ZipOutputStream zos, Statistic stats) {
        try {
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(new File(path)), BUFFER_SIZE);
            byte[] data = new byte[BUFFER_SIZE];
            ZipEntry entry = new ZipEntry(new File(path).getAbsolutePath());
            zos.putNextEntry(entry);
            int count;
            while ((count = bis.read(data, 0, BUFFER_SIZE)) != -1) {
                zos.write(data, 0, count);
            }
            stats.addFileCopied(1);
        } catch (Exception e) {
            LOGGER.warn("Fail to save:" + path + " because: " + e.getMessage());
            stats.addErrorCount("Failed to save:" + path);
            return false;
        }
        return true;
    }

    public static String createSourceFile(String ending) {
        LOGGER.debug("creating source file");
        String fileName = JOptionPane.showInputDialog(null, "Name of file:", "Create new source file", JOptionPane.INFORMATION_MESSAGE);
        if (StringUtils.isStringBlank(fileName)) {
            return null;
        }
        String path = FileTools.chooseDirToLoad();
        if (StringUtils.isStringBlank(fileName) || StringUtils.isStringBlank(path)) {
            return null;
        } else if (FileTools.createAFile(path + System.getProperty("file.separator") + fileName + ending)) {
            return path + System.getProperty("file.separator") + fileName + ending;
        } else {
            return null;
        }
    }
}
