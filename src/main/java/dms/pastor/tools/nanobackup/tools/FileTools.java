package dms.pastor.tools.nanobackup.tools;

import dms.pastor.domain.ShutdownHook;
import dms.pastor.tools.nanobackup.Messenger;
import dms.pastor.tools.nanobackup.backup.Statistic;
import dms.pastor.utils.StringUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.io.*;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @author Dominik Symonowicz
 */
public class FileTools {

    private static final long FILE_COPY_BUFFER_SIZE = 1024 * 1024 * 12;//12 megabyte
    private static final Logger LOGGER = LoggerFactory.getLogger(FileTools.class);
    private static File f;
    private static FileChannel channel;
    private static FileLock lockFile;
    private static File file;
    private final Messenger msg = new Messenger();

    /**
     * Calculates size of path (file/folder (with subdir(s)))
     *
     * @param path
     * @return size of path
     */
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

    /**
     * Calculates size of path (file/folder (with subdir(s)))
     *
     * @param path
     * @return size of path
     */
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

    /**
     * Checks if is enough space of device where desitnation folder will be
     * stored
     *
     * @param sources     list of items
     * @param destination folder
     * @return true if is enough space,false otherwise
     */
    public static boolean checkEnoughSpace(Statistic stats, String[] sources, String destination) {
        long srcSize = 0;
        for (int i = 0; i < sources.length; i++) {
            file = new File(sources[i]);
            if (file.exists()) {
                srcSize += FileUtils.sizeOf(new File(sources[i]));
                if (stats != null) {
                    stats.setBackupSize(String.valueOf(srcSize));
                }
            }
        }
        return checkFreeSpace(destination) - srcSize > 0;
    }

    /**
     * Checks size of free space on partition where is file/folder
     *
     * @param path
     * @return free space ...size ? sounds weird .. is it ?
     */
    public static long checkFreeSpace(String path) {
        return new File(path).getFreeSpace();
    }

    /**
     * @return list of file(s) selected by user
     */
    public static String chooseFiletoLoad() {
        LOGGER.debug("select file to Load");
        ArrayList<String> path = new ArrayList<String>();
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
        //TODO solve below line issue
        //return (String[]) (path != null? (path.toArray(new String[path.size()])):  path);
    }

    /**
     * @return list of file(s) selected by user
     */
    public static String[] chooseFilestoLoad() {
        LOGGER.debug("select file to Load");
        ArrayList<String> path = new ArrayList<String>();
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setMultiSelectionEnabled(true);
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int returnVal = fileChooser.showOpenDialog(null);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File[] files = fileChooser.getSelectedFiles();
            for (int i = 0; i < files.length; i++) {
                path.add(files[i].getPath());
            }
            return path.toArray(new String[path.size()]);
        } else {
            return null;
        }
        //TODO solve below line issue
        //return (String[]) (path != null? (path.toArray(new String[path.size()])):  path);
    }

    /**
     * @return
     */
    public static String chooseDirtoLoad() {
        LOGGER.debug("select folder to Load");
        String path;
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            file = fileChooser.getSelectedFile();
            path = file.getPath();
        } else {
            path = null;
            LOGGER.debug("File was not selected");
        }
        return path;
    }

    /**
     * Choose directories.
     *
     * @return list of paths to directories that was selected by user.
     */
    public static String[] chooseDirsToLoad() {
        LOGGER.debug("select folder to Load");
        ArrayList<String> path = new ArrayList<String>();
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        fileChooser.setMultiSelectionEnabled(true);
        int returnVal = fileChooser.showOpenDialog(null);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File[] files = fileChooser.getSelectedFiles();
            for (int i = 0; i < files.length; i++) {
                path.add(files[i].getPath());
            }
        } else {
            return null;
        }

        String results[] = new String[path.size()];

        for (int i = 0; i < path.size(); i++) {
            results[i] = path.get(i).toString();
        }
        return results;
    }

    /**
     * Choose file(s)/folder(s) by GUI
     *
     * @return list of file(s)/folder(s)
     */
    public static String[] chooseItemsToLoad() {
        ArrayList<String> path = new ArrayList<String>();
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setMultiSelectionEnabled(true);
        fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        int returnVal = fileChooser.showOpenDialog(null);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File[] files = fileChooser.getSelectedFiles();
            for (int i = 0; i < files.length; i++) {
                path.add(files[i].getPath());
            }
        } else {
            return null;
        }

        String results[] = new String[path.size()];

        for (int i = 0; i < path.size(); i++) {
            results[i] = path.get(i).toString();
        }
        return results;
    }

    /**
     * Copy file from one place to another
     *
     * @param sourceFile      as String
     * @param destinationFile as String
     * @param stats           responds for add information about result that will be
     *                        displayed as summary
     * @return true if file was copied.false otherwise
     */
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

    /**
     * 1121	* Internal copy file method. 1122	* 1123
     *
     * @param srcFile  the validated source file, must not be {@code null} 1124
     * @param destFile the validated destination file, must not be {@code null}
     *                 1125
     * @throws IOException if an error occurs 1127
     */
    private static void doCopyFile(File srcFile, File destFile, Statistic stats) {
        LOGGER.debug("copy file from: " + srcFile + " to " + destFile);
        if (destFile.exists() && destFile.isDirectory()) {
            if (stats != null) {
                stats.addErrorCount("Destination '" + destFile + "' exists but is a directory");
            }
            return;
        }

        FileInputStream fis = null;
        FileOutputStream fos = null;
        FileChannel input = null;
        FileChannel output = null;
        long size = -1;
        try {

            fis = new FileInputStream(srcFile);

            fos = new FileOutputStream(destFile);
            input = fis.getChannel();
            output = fos.getChannel();

            size = input.size();

            long pos = 0;
            long count = 0;
            while (pos < size) {
                count = size - pos > FILE_COPY_BUFFER_SIZE ? FILE_COPY_BUFFER_SIZE : size - pos;
                try {
                    pos += output.transferFrom(input, pos, count);
                } catch (IOException ex) {
                    java.util.logging.Logger.getLogger(FileTools.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (FileNotFoundException ex) {
            if (stats != null) {
                stats.addErrorCount("Unable to copy file.Source file '" + srcFile + "' not found.(network problem?device disconnected?)");
            }
        } catch (IOException ex) {
            if (stats != null) {
                stats.addErrorCount("Unable to copy file.IO error during coping file.\nPossible reasons:\nNetwork problem?Device disconnected?)");
            }
        } finally {
            IOUtils.closeQuietly(output);
            IOUtils.closeQuietly(fos);
            IOUtils.closeQuietly(input);
            IOUtils.closeQuietly(fis);
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
            if (destDir.isDirectory() == false) {
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
        if (destDir.canWrite() == false) {
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

    /**
     * Copies folder from one place to another
     *
     * @param sourceFolder      from path
     * @param destinationFolder to path
     * @param stats             responds for add information about result that will be
     *                          displayed as summary
     * @return true if folder was copied.false otherwise
     */
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

    public static void copyFileToDirectory(File srcFile, File destDir, Statistic stats) throws IOException {
        if (destDir == null) {
            throw new NullPointerException("Destination must not be null");
        }
        if (destDir.exists() && destDir.isDirectory() == false) {
            throw new IllegalArgumentException("Destination '" + destDir + "' is not a directory");
        }
        File destFile = new File(destDir, srcFile.getName());
        doCopyFile(srcFile, destFile, stats);
    }

    /**
     * Creates a file
     *
     * @param filePath
     * @return true, if file was created ,false otherwise
     */
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

    /**
     * Creates path where zip file will be created.
     *
     * @param path path to backup folder
     * @return path to zip file
     */
    public static String createABackupZipPath(String path) {
        LOGGER.debug("creating path for backup(copressed in zip)");
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

    /**
     * Creates a backup directory
     *
     * @param path place where
     * @return path where directory was created.
     */
    public static String createABackupDirectory(String path) {
        LOGGER.debug("create backup folder" + path);
        int year = Calendar.getInstance().get(Calendar.YEAR);
        int month = Calendar.getInstance().get(Calendar.MONTH) + 1;
        int day = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);

        path = createPath(path, year);
        path = createPath(path, month);
        path = createPath(path, day);
        path += System.getProperty("file.separator") + Tools.getCurrentTime();

        File dir = new File(path); // //FileUtils.forceMkdir(dir); i should use this one instead ???
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

    /**
     * @param filePath
     * @return
     */
    public static boolean createADirectory(String filePath) {
        file = new File(filePath);
        return file.mkdir();
    }

    /**
     * @param filePath
     * @return
     */
    public static boolean delete(String filePath) {
        file = new File(filePath);
        try {
            FileUtils.forceDelete(file);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    /**
     * @param path
     * @return
     */
    public static boolean isAFile(String path) {
        if (isFileExists(path)) {
            try {
                file = new File(path);
            } catch (NullPointerException e) {
                return false;
            }
            return file.isFile();
        } else {
            return false;
        }
    }

    /**
     * @param path
     * @return
     */
    public static boolean isADirectory(String path) {
        if (isDirectoryExists(path)) {
            try {
                file = new File(path);
            } catch (NullPointerException e) {
                return false;
            }
            return file.isDirectory();
        } else {
            return false;
        }
    }

    //TODO refactor this method
    static boolean isFilesExists(String[] filesPath) {
        try {
            for (int i = 0; i < filesPath.length; i++) {
                if (!new File(filesPath[i]).exists()) {
                    return false;
                }
            }
        } catch (NullPointerException e) {
            return false;
        }
        return true;
    }

    //TODO refactor this method    

    /**
     * @param filePath
     * @return
     */
    public static boolean isFileExists(String filePath) {
        try {
            file = new File(filePath);
        } catch (NullPointerException e) {
            return false;
        }
        return file.isFile();
    }

    /**
     * @param filePath
     * @return
     */
    public static boolean isDirectoryExists(String filePath) {
        try {
            file = new File(filePath);
        } catch (NullPointerException e) {
            return false;
        }
        return file.isDirectory();
    }

    /**
     * @param content
     * @param file
     * @return
     */
    public static boolean saveListToFile(String[] content, String file) {
        BufferedWriter out = null;
        StringBuilder list = new StringBuilder();
        for (int i = 0; i < content.length; i++) {
            if (i == content.length - 1) {
                list.append(content[i]);
            } else {
                list.append(content[i]);
                list.append("\n");
            }
        }
        try {
            FileWriter fstream = new FileWriter(file);
            out = new BufferedWriter(fstream);
            out.write(list.toString());
        } catch (IOException e) {
            LOGGER.error("Unable to save source list to file: " + file);
            return false;
        } finally {
            IOUtils.closeQuietly(out);
        }
        return true;
    }

    /**
     * Save text to file Based on version 1 from package
     * dstools.file.saveStringToFile;
     *
     * @param text
     * @param path2file
     */
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

    /**
     * @param whatPath
     * @param fromPath
     * @param file
     * @return
     */
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

    /**
     * Lock program,so it can be run once per time.
     */
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

    /*
     *
     * Unlocking
     */

    /**
     *
     */
    public static void unlockFile() {
        try {
            if (lockFile != null) {
                lockFile.release();
                channel.close();
                boolean pass = f.delete();
                if (!pass) {
                    LOGGER.warn("Unable to unlock program.It cans cause problem with running program.\nProgram shoulds work afrer restar of your computer.");
                }
            }
        } catch (IOException e) {
            LOGGER.warn("Unable to unlock program.It cans cause problem with running program.\nProgram shoulds work afrer restar of your computer.");
        }
    }

    //TODO IMPROVE THIS GARBAGE this method doesn't need a return ?

    /**
     * @param folderPath
     * @param out
     * @param results
     * @param stats
     * @return
     */
    public static boolean zipFolder(String[] folderPath, ZipOutputStream out, StringBuilder results, Statistic stats) {
        if (folderPath == null) {
            stats.addErrorCount("Problem source file/folder found.Backup cancelled.");
            return false;
        }
        stats.addFileCopied(1);
        for (int i = 0; i < folderPath.length; i++) {
            if (isADirectory(folderPath[i])) {
                String[] x = new File(folderPath[i]).list();
                String[] listInDir = new String[x.length];
                for (int ix = 0; ix < x.length; ix++) {
                    listInDir[ix] = folderPath[i] + System.getProperty("file.separator") + x[ix];
                }
                zipFolder(listInDir, out, results, stats);
            } else {
                zipFile(folderPath[i], out, stats);
            }
        }
        return true;
    }

    /**
     * @param path
     * @param zos
     * @param stats
     * @return
     */
    public static boolean zipFile(String path, ZipOutputStream zos, Statistic stats) {
        try {
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(new File(path)), 2048);
            byte[] data = new byte[2048];
            ZipEntry entry = new ZipEntry(new File(path).getAbsolutePath());
            zos.putNextEntry(entry);
            int count;
            while ((count = bis.read(data, 0, 2048)) != -1) {
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

    /**
     * Creates source file
     *
     * @return path to source file (or null if any problems occur
     */
    public static String createSourceFile(String ending) {
        LOGGER.debug("creating source file");
        String fileName = JOptionPane.showInputDialog(null, "Name of file:", "Create new source file", JOptionPane.INFORMATION_MESSAGE);
        if (StringUtils.isStringBlank(fileName)) {
            return null;
        }
        String path = FileTools.chooseDirtoLoad();
        if (StringUtils.isStringBlank(fileName) || StringUtils.isStringBlank(path)) {
            return null;
        } else if (FileTools.createAFile(path + System.getProperty("file.separator") + fileName + ending)) {
            return path + System.getProperty("file.separator") + fileName + ending;
        } else {
            return null;
        }
    }
}
