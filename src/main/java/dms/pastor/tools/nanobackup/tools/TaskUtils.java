package dms.pastor.tools.nanobackup.tools;

import dms.pastor.tools.nanobackup.Settings;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Properties;

/**
 * It contains extra tasks that will be perform and
 *
 * @author Dominik Symonowicz
 */
public class TaskUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(TaskUtils.class);
    private Settings settings = Settings.getSettings();


    /**
     * Removes duplicate lines from list of items
     *
     * @param lineslist list of items
     * @return list of items without duplicates
     */
    public static String[] removeDuplicateLines(String[] lineslist) {
        LOGGER.debug("Removing duplicate lines from list ...");
        ArrayList<String> singles = new ArrayList<String>();
        for (int i = 0; i < lineslist.length; i++) {
            if (!singles.contains(lineslist[i])) {
                singles.add(lineslist[i]);
            }
        }
        LOGGER.debug("Duplicate lines from list was removed.");
        return singles.toArray(new String[singles.size()]);
    }

    /**
     * Clears source list from non existing entries (folder / file )
     *
     * @param sources
     * @return clean list of files/folder that exists.
     */
    public static String[] removeNonExistsItems(String[] sources) {
        LOGGER.debug("Cleaning items list from non exists elements...");
        ArrayList<String> clearedList = new ArrayList<String>();
        for (String source : sources) {
            if (new File(source).exists()) {
                clearedList.add(source);
            }
        }
        if (clearedList.isEmpty()) {
            return new String[0];
        }
        LOGGER.debug("...List is cleaned from non exists elements.");
        return clearedList.toArray(new String[clearedList.size()]);
    }

    /**
     * Deletes Source After Backup
     *
     * @param sources - list of source items
     * @return true if everything was deleted successfully
     */
    public static boolean deleteSourceAferBackup(String[] sources) {
        LOGGER.debug("deleting source's file/folders after backup...");
        for (int i = 0; i < sources.length; i++) {
            if (FileTools.isAFile(sources[i]) || FileTools.isADirectory(sources[i])) {
                FileTools.delete(sources[i]);
            } else {
                LOGGER.debug("Unable to delete all/some source's file/folders.");
                return false;
            }
        }
        LOGGER.debug("source's file/folders deleted.");
        return true;
    }

    /**
     * Performs some tasks
     *
     * @param jobsPath
     * @return
     */
    public static boolean doJob(String jobsPath) {
        Properties job = new Properties();
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(jobsPath);
            job.load(fis);
            int size = Integer.parseInt(job.getProperty("tasks.size"));
            for (int i = 1; i <= size; i++) {
                System.out.println(i);
                String type = job.getProperty("task." + i + ".name");
                if (type.equals("replace")) {
                    FileTools.replace(job.getProperty("task." + i + ".what"), job.getProperty("task." + i + ".with"), job.getProperty("task." + i + ".file"));
                } else if (type.equals("copyFile")) {
                    FileTools.copyFile(job.getProperty("task." + i + ".from"), job.getProperty("task." + i + ".to"), null);
                } else if (type.equals("copyFolder")) {
                    FileTools.copyFolder(new File(job.getProperty("task." + i + ".from")), new File(job.getProperty("task." + i + ".to")), null);
                } else if (type.equals("delete")) {
                    FileTools.delete(job.getProperty("task." + i + ".path"));
                } else {
                    LOGGER.warn("Job: " + type + " is not implemented or you made childish typo error.");
                }
            }
        } catch (Exception e) {
            LOGGER.error("Something went wrong.\n" + e.getCause() + "\n" + e.getMessage());
            return false;
        } finally {
            IOUtils.closeQuietly(fis);
        }
        return true;
    }
}