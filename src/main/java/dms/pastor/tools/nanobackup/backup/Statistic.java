package dms.pastor.tools.nanobackup.backup;

import java.util.Calendar;


/**
 * Author Dominik Symonowicz
 * Created: 2010-02-17 at 01:36:09
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class Statistic {

    //private static final Logger LOGGER = LoggerFactory.getLogger( log = Logger.getLogger(Statistic.class);

    private int fileCopied = 0;
    private long sizeCopied = 0;
    private int error = 0;
    private long taskStart = 0;
    private long taskFinish = 0;
    private String errorMsgList = "";
    private String backupSize = "";
    private String backupType;

    public void start() {
        taskFinish = 0;
        sizeCopied = 0;
        taskStart = Calendar.getInstance().getTimeInMillis();
    }

    public long calcTotalTime() {
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
        days = (int) (time / 86400L);
        time -= (days * 86400L);
        hours = (int) (time / 3600L);
        time -= (hours * 3600L);
        minutes = (int) (time / 60L);
        time -= (minutes * 60L);
        seconds = (int) time;
        result.append("--------\nSummary.\n--------\nTime needed: ").append(days).append(" days, ");
        result.append(hours).append(" hours, ").append(minutes);
        result.append(" minutes and ").append(seconds).append(" seconds.");
        result.append("\nBackupType: ").append(backupType);
        result.append("\nFiles copied: ").append(fileCopied);
        result.append("\nErrors: ").append(error);
        if (backupSize != null && !backupSize.isEmpty()) {
            result.append("\nBackup size: ").append(backupSize);
        }
        if (!"".equalsIgnoreCase(errorMsgList)) {
            result.append("\n\nError messages:\n\n").append(errorMsgList).append("\n\nPlease:\n\t- Use\" clear non existing files\" from menu to solve above erros \n\t- Check do you have access/permissions to resources");
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
        sizeCopied = 0;
        error = 0;
        taskStart = 0;
        taskFinish = 0;
        errorMsgList = "";
        backupSize = "";
    }

    public void addSizeOfBackup(String backupSize) {
        this.backupSize = backupSize;
    }

    public String getBackupType() {
        return backupType;
    }

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

    public void setError(int error) {
        this.error = error;
    }

    public String getErrorMsgList() {
        return errorMsgList;
    }

    public void setErrorMsgList(String errorMsgList) {
        this.errorMsgList = errorMsgList;
    }

    public int getFileCopied() {
        return fileCopied;
    }

    public void setFileCopied(int fileCopied) {
        this.fileCopied = fileCopied;
    }

    public long getFinish() {
        return taskFinish;
    }

    public void setFinish(long finish) {
        this.taskFinish = finish;
    }

    public long getStart() {
        return taskStart;
    }

    public void setStart(long start) {
        this.taskStart = start;
    }
}