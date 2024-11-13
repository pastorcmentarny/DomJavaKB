package dms.pastor.tools.nanobackup.backup;

import java.util.Calendar;

import static dms.pastor.utils.StringUtils.EMPTY_STRING;


/**
 * Author Dominik Symonowicz
 * Created: 2010-02-17 at 01:36:09
 * WWW:	<a href="https://dominiksymonowicz.com/">HOME PAGE</a>
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 * This is my first project after graduation in 2010. Do not expect too much :)
 */
@SuppressWarnings("MagicNumber") //TOO OLD PROJECT  TO TAKE CARE OF MAGIC NUMBERS
public class Statistic {
    private static final long MINUTE_IN_SECONDS = 60L;
    private static final long HOUR_IN_SECONDS = 3600L;
    private static final long DAY_IN_SECONDS = 86400L;

    private int fileCopied = 0;
    private int error = 0;
    private long taskStart = 0;
    private long taskFinish = 0;
    private String errorMsgList = EMPTY_STRING;
    private String backupSize = EMPTY_STRING;
    private String backupType;

    public void start() {
        taskFinish = 0;
        taskStart = Calendar.getInstance().getTimeInMillis();
    }

    private long calcTotalTime() {
        return taskFinish - taskStart;
    }

    public void stop() {
        taskFinish = Calendar.getInstance().getTimeInMillis();
    }

    public String display() {
        int days;
        int hours;
        int minutes;
        int seconds;
        StringBuilder result = new StringBuilder();
        long time = calcTotalTime();
        time /= 1000L;
        days = (int) (time / DAY_IN_SECONDS);
        time -= (days * DAY_IN_SECONDS);
        hours = (int) (time / HOUR_IN_SECONDS);
        time -= (hours * HOUR_IN_SECONDS);
        minutes = (int) (time / MINUTE_IN_SECONDS);
        time -= (minutes * MINUTE_IN_SECONDS);
        seconds = (int) time;
        result.append("--------\nSummary.\n--------\nTime needed: ").append(days).append(" days, ");
        result.append(hours).append(" hours, ").append(minutes);
        result.append(" minutes and ").append(seconds).append(" seconds.");
        result.append("\nBackupType: ").append(backupType);
        result.append("\nFiles copied: ").append(getFileCopied());
        result.append("\nErrors: ").append(error);
        if (backupSize != null && !backupSize.isEmpty()) {
            result.append("\nBackup size: ").append(backupSize);
        }
        if (!EMPTY_STRING.equalsIgnoreCase(errorMsgList)) {
            result.append("\n\nError messages:\n\n").append(errorMsgList).append("\n\nPlease:\n\t- Use\" clear non existing files\" from menu to solve above errors \n\t- Check do you have access/permissions to resources");
        }
        return result.toString();
    }

    public void addFileCopied(int filesNumber) {
        fileCopied += filesNumber;
    }

    public void addErrorCount(String errors) {
        error++;
        errorMsgList += errors;
    }

    public void resetStats() {
        fileCopied = 0;
        error = 0;
        taskStart = 0;
        taskFinish = 0;
        errorMsgList = EMPTY_STRING;
        backupSize = EMPTY_STRING;
    }

    public void addSizeOfBackup(String backupSize) {
        this.backupSize = backupSize;
    }

// --Commented out by Inspection START (21/02/2018 14:14):
//    public String getBackupType() {
//        return backupType;
//    }
// --Commented out by Inspection STOP (21/02/2018 14:14)

    public void setBackupType(String backupType) {
        this.backupType = backupType;
    }

    public String getBackupSize() {
        return backupSize;
    }

    public void setBackupSize(String backupSize) {
        this.backupSize = backupSize;
    }

    public int getError() {
        return error;
    }

    public String getErrorMsgList() {
        return errorMsgList;
    }

// --Commented out by Inspection START (21/02/2018 14:14):
//    public void setErrorMsgList(String errorMsgList) {
//        this.errorMsgList = errorMsgList;
//    }
// --Commented out by Inspection STOP (21/02/2018 14:14)

    public int getFileCopied() {
        return fileCopied;
    }

// --Commented out by Inspection START (21/02/2018 14:14):
//    public void setFileCopied(int fileCopied) {
//        this.fileCopied = fileCopied;
//    }
// --Commented out by Inspection STOP (21/02/2018 14:14)

// --Commented out by Inspection START (21/02/2018 14:14):
//    public long getFinish() {
//        return taskFinish;
//    }
// --Commented out by Inspection STOP (21/02/2018 14:14)

// --Commented out by Inspection START (21/02/2018 14:14):
//    public void setFinish(long finish) {
//        this.taskFinish = finish;
//    }
// --Commented out by Inspection STOP (21/02/2018 14:14)

// --Commented out by Inspection START (21/02/2018 14:14):
//    public long getStart() {
//        return taskStart;
//    }
// --Commented out by Inspection STOP (21/02/2018 14:14)

// --Commented out by Inspection START (21/02/2018 14:14):
//    public void setStart(long start) {
//        this.taskStart = start;
//    }
// --Commented out by Inspection STOP (21/02/2018 14:14)
}