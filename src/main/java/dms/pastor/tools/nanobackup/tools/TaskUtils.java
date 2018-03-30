package dms.pastor.tools.nanobackup.tools;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.ArrayList;


public final class TaskUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(TaskUtils.class);

    private TaskUtils() {
    }
    // --Commented out by Inspection (21/02/2018 14:14):private Settings settings = Settings.getSettings();

    public static String[] removeDuplicateLines(String[] linesList) {
        LOGGER.debug("Removing duplicate lines from list ...");
        ArrayList<String> singles = new ArrayList<>();
        for (String line : linesList) {
            if (!singles.contains(line)) {
                singles.add(line);
            }
        }
        LOGGER.debug("Duplicate lines from list was removed.");
        return singles.toArray(new String[0]);
    }

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
        return clearedList.toArray(new String[0]);
    }

    public static boolean deleteSourceAfterBackup(String[] sources) {
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

// --Commented out by Inspection START (21/02/2018 14:14):
//    public static boolean doJob(String jobsPath) {
//        Properties job = new Properties();
//        try (FileInputStream fis = new FileInputStream(jobsPath)) {
//            job.load(fis);
//            int size = Integer.parseInt(job.getProperty("tasks.size"));
//            for (int i = 1; i <= size; i++) {
//                System.out.println(i);
//                String type = job.getProperty("task." + i + ".name");
//                switch (type) {
//                    case "replace":
//                        FileTools.replace(job.getProperty("task." + i + ".what"), job.getProperty("task." + i + ".with"), job.getProperty("task." + i + ".file"));
//                        break;
//                    case "copyFile":
//                        FileTools.copyFile(job.getProperty("task." + i + ".from"), job.getProperty("task." + i + ".to"), null);
//                        break;
//                    case "copyFolder":
//                        FileTools.copyFolder(new File(job.getProperty("task." + i + ".from")), new File(job.getProperty("task." + i + ".to")), null);
//                        break;
//                    case "delete":
//                        FileTools.delete(job.getProperty("task." + i + ".path"));
//                        break;
//                    default:
//                        LOGGER.warn("Job: " + type + " is not implemented or you made childish typo error.");
//                        break;
//                }
//            }
//        } catch (Exception e) {
//            LOGGER.error("Something went wrong.\n" + e.getCause() + "\n" + e.getMessage());
//            return false;
//        }
//        return true;
//    }
// --Commented out by Inspection STOP (21/02/2018 14:14)
}
