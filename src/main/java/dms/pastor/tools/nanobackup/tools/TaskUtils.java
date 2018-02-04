package dms.pastor.tools.nanobackup.tools;

import dms.pastor.tools.nanobackup.Settings;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Properties;


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
        ArrayList<String> singles = new ArrayList<>();
        for (String aLineslist : lineslist) {
            if (!singles.contains(aLineslist)) {
                singles.add(aLineslist);
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
        ArrayList<String> clearedList = new ArrayList<>();
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
        for (String source : sources) {
            if (FileTools.isAFile(source) || FileTools.isADirectory(source)) {
                FileTools.delete(source);
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
                switch (type) {
                    case "replace":
                        FileTools.replace(job.getProperty("task." + i + ".what"), job.getProperty("task." + i + ".with"), job.getProperty("task." + i + ".file"));
                        break;
                    case "copyFile":
                        FileTools.copyFile(job.getProperty("task." + i + ".from"), job.getProperty("task." + i + ".to"), null);
                        break;
                    case "copyFolder":
                        FileTools.copyFolder(new File(job.getProperty("task." + i + ".from")), new File(job.getProperty("task." + i + ".to")), null);
                        break;
                    case "delete":
                        FileTools.delete(job.getProperty("task." + i + ".path"));
                        break;
                    default:
                        LOGGER.warn("Job: " + type + " is not implemented or you made childish typo error.");
                        break;
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