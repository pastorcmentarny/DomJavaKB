package dms.pastor.tools.nanobackup.tools;

import dms.pastor.tools.nanobackup.backup.Statistic;
import dms.pastor.utils.StringUtils;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.io.*;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Calendar;

import static dms.pastor.utils.FileUtils.isDirectoryExists;
import static dms.pastor.utils.StringUtils.EMPTY_STRING;
import static dms.pastor.utils.ValidatorUtils.validateIfNotNull;
import static java.util.Objects.nonNull;

/**
 * Author Dominik Symonowicz
 * Created: 09-Jan-2012 10:49:45
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public final class FileTools {

    private static final long FILE_COPY_BUFFER_SIZE = 1024 * 1024 * 12;//12 megabyte
    private static final Logger LOGGER = LoggerFactory.getLogger(FileTools.class);
    private static File file;

    private FileTools() {
    }
    // --Commented out by Inspection (21/02/2018 14:14):private final Messenger msg = new Messenger();

// --Commented out by Inspection START (21/02/2018 14:14):
//    public static String displaySize(String path) {
//        String sizeMsg = StringUtils.EMPTY_STRING;
//        file = new File(path);
//        if (file.isFile()) {
//            sizeMsg = FileUtils.sizeOf(file) + " bytes.";
//        } else if (file.isDirectory()) {
//            sizeMsg = FileUtils.sizeOfDirectory(file) + " bytes.";
//        } else {
//            LOGGER.warn("N/A");
//        }
//        return sizeMsg;
//    }
// --Commented out by Inspection STOP (21/02/2018 14:14)

// --Commented out by Inspection START (21/02/2018 14:14):
//    public static long calcSize(String path) {
//        long size = 0;
//        file = new File(path);
//        if (file.isFile()) {
//            size = FileUtils.sizeOf(file);
//        } else if (file.isDirectory()) {
//            size = FileUtils.sizeOfDirectory(file);
//        } else {
//            LOGGER.warn("N/A");
//        }
//        return size;
//    }
// --Commented out by Inspection STOP (21/02/2018 14:14)

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
        return getFreeSpace(destination) - srcSize > 0;
    }

    private static long getFreeSpace(String path) {
        return new File(path).getFreeSpace();
    }

    public static String chooseFileToLoad() {
        LOGGER.debug("select file to Load");
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
            return path.toArray(new String[0]);
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

// --Commented out by Inspection START (21/02/2018 14:27):
//    public static void copyFile(String sourceFile, String destinationFile, Statistic stats) {
//        LOGGER.debug("copy file from: " + sourceFile + " to " + destinationFile);
//        try {
//            FileUtils.copyFile(new File(sourceFile), new File(destinationFile));
//        } catch (IOException ex) {
//            if (!(stats == null)) {
//                stats.addErrorCount("Program was unable to copy from" + sourceFile + " to " + destinationFile + "during unexpected problem!PLEASE TRY AGAIN\n\n" + ex.getMessage());
//            }
//        }
//    }
// --Commented out by Inspection STOP (21/02/2018 14:27)

    private static void doCopyFile(File srcFile, File destFile, Statistic stats) {
        LOGGER.debug("copy file from: " + srcFile + " to " + destFile);
        if (isDirectoryExists(destFile.getAbsolutePath())) {
            addDestinationErrorCount(stats, "Destination '" + destFile + "' exists but is a directory");
            return;
        }

        try (
                FileInputStream fis = new FileInputStream(srcFile);
                FileOutputStream fos = new FileOutputStream(destFile);
                FileChannel input = fis.getChannel();
                FileChannel output = fos.getChannel()
        ) {
            transferFile(input.size(), input, output);
        } catch (FileNotFoundException ex) {
            addDestinationErrorCount(stats, "Unable to copy file.Source file '" + srcFile + "' not found.(network problem?device disconnected?)");
        } catch (IOException ex) {
            addDestinationErrorCount(stats, "Unable to copy file.IO error during coping file.\nPossible reasons:\nNetwork problem?Device disconnected?)");
        }

        addDestinationErrorCountIfSrcAndDestAreDifferentLength(srcFile, destFile, stats);
    }

    private static void transferFile(long size, FileChannel input, FileChannel output) throws IOException {
        long pos = 0;
        long count;
        while (pos < size) {
            count = size - pos > FILE_COPY_BUFFER_SIZE ? FILE_COPY_BUFFER_SIZE : size - pos;

            pos += output.transferFrom(input, pos, count);
        }
    }

    private static void addDestinationErrorCountIfSrcAndDestAreDifferentLength(File srcFile, File destFile, Statistic stats) {
        if (nonNull(stats) && srcFile.length() != destFile.length()) {
            stats.addErrorCount("Something went wrong. Source and Destination files has different sizes.\n Source: '" + srcFile + "' has " + srcFile.length() + " Destination: '" + destFile + "' has " + destFile.length());
        }
    }

    private static void addDestinationErrorCount(Statistic stats, String errors) {
        if (stats != null) {
            stats.addErrorCount(errors);
        }
    }

    private static void doCopyDirectory(File srcDir, File destDir, Statistic stats) {
        // recurse
        File[] srcFiles = srcDir.listFiles();
        if (addErrorCountIfSourceIsInvalid(stats, srcFiles)) return;

        if (destDir.exists()) {
            if (!destDir.isDirectory()) {
                addDestinationErrorCount(stats, "Destination '" + destDir + "' exists but is not a directory");
            }
        } else {
            if (addErrorCountIfDestinationFolderCannotBeCreated(destDir, stats)) return;
        }
        addErrorCountIfCannotWriteToDestinationFolder(destDir, stats);
        copyAll(destDir, stats, srcFiles);
    }

    private static boolean addErrorCountIfDestinationFolderCannotBeCreated(File destDir, Statistic stats) {
        if (!destDir.mkdirs() && !destDir.isDirectory()) {
            if (stats != null) {
                stats.addErrorCount("Destination '" + destDir + "' directory cannot be created");
                return true;
            }
        }
        return false;
    }

    private static void addErrorCountIfCannotWriteToDestinationFolder(File destDir, Statistic stats) {
        if (!destDir.canWrite()) {
            addDestinationErrorCount(stats, "Destination '" + destDir + "' cannot be written to");
        }
    }

    private static boolean addErrorCountIfSourceIsInvalid(Statistic stats, File[] srcFiles) {
        if (srcFiles == null) {
            if (stats != null) {
                stats.addErrorCount("Source path is not valid Directory(Folder).[list of files is null]");
                return true;
            }
        }
        return false;
    }

    private static void copyAll(File destDir, Statistic stats, File[] srcFiles) {
        if (nonNull(srcFiles)) {
            for (File srcFile : srcFiles) {
                File dstFile = new File(destDir, srcFile.getName());
                if (srcFile.isDirectory()) {
                    doCopyDirectory(srcFile, dstFile, stats);
                } else {
                    doCopyFile(srcFile, dstFile, stats);
                }

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
        validateIfNotNull(src, "Source file");
        validateIfNotNull(dest, "Destination file");

        if (src.isDirectory()) {
            doCopyDirectory(src, dest, stats);
        } else if (src.isFile()) {
            doCopyFile(src, dest, stats);
        } else {
            stats.addErrorCount("Src is not a file and no");
        }

    }

// --Commented out by Inspection START (21/02/2018 14:14):
//    public static void copyFileToDirectory(File srcFile, File destDir, Statistic stats) {
//        if (destDir == null) {
//            throw new NullPointerException("Destination must not be null");
//        }
//        if (destDir.exists() && !destDir.isDirectory()) {
//            throw new IllegalArgumentException("Destination '" + destDir + "' is not a directory");
//        }
//        File destFile = new File(destDir, srcFile.getName());
//        doCopyFile(srcFile, destFile, stats);
//    }
// --Commented out by Inspection STOP (21/02/2018 14:14)

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

    public static String createABackupDirectory(String path) {
        LOGGER.debug("create backup folder" + path);
        int year = Calendar.getInstance().get(Calendar.YEAR);
        int month = Calendar.getInstance().get(Calendar.MONTH) + 1;
        int day = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);

        path = createPath(path, year);
        path = createPath(path, month);
        path = createPath(path, day);
        path += File.separator + Tools.getCurrentTime();

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
            path += File.separator + unitOfTime;
            createADirectory(path);
        } else {
            path += File.separator + unitOfTime;
        }
        return path;
    }

    public static void createADirectory(String filePath) {
        file = new File(filePath);
        final boolean created = file.mkdir();
        LOGGER.debug(String.format("Directory was %s created.", created ? EMPTY_STRING : "not"));
    }


    public static void delete(String filePath) {
        file = new File(filePath);
        try {
            FileUtils.forceDelete(file);
        } catch (Exception ex) {
            LOGGER.error(String.format("Unable to delete file due %s", ex.getMessage()));
        }
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
        } else if (FileTools.createAFile(path + File.separator + fileName + ending)) {
            return path + File.separator + fileName + ending;
        } else {
            return null;
        }
    }

}
