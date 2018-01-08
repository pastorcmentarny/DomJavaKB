package dms.pastor.tools.nanobackup.backup;

import java.util.Calendar;
//

/**
 * Statistic.java
 * this class shows time statistic
 *
 * @author dominik symonowicz
 * <p>
 * Created on 2010-02-17, 01:36:09
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

    /**
     * starts stopwatch for backup task
     */
    public void start() {
        taskFinish = 0;
        sizeCopied = 0;
        taskStart = Calendar.getInstance().getTimeInMillis();
    }

    /**
     * calucates total time spent on backup
     *
     * @return time
     */
    public long calcTotalTime() {
        return taskFinish - taskStart;
    }

    /**
     * stops stopwatch for backup task
     */
    public void stop() {
        taskFinish = Calendar.getInstance().getTimeInMillis();
    }

    /**
     * Displays results
     *
     * @return results text
     */
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
        result.append("\nErros: ").append(error);
        if (!backupSize.equals("")) {
            result.append("\nBackup size: ").append(backupSize);
        }
        if (!errorMsgList.equalsIgnoreCase("")) {
            result.append("\n\nError messages:\n\n").append(errorMsgList).append("\n\nPlease:\n\t- Use\" clear non existing files\" from menu to solve above erros \n\t- Check do you have access/permissions to resources");
        }
        return result.toString();
    }

    /**
     * add
     *
     * @param filesNumber
     */
    public void addFileCopied(int filesNumber) {
        fileCopied += filesNumber;
    }

    /**
     * adds error message ' to error messages list '
     *
     * @param errormsg
     */
    public void addErrorCount(String errormsg) {
        error++;
        errorMsgList += errormsg;
    }

    /**
     * resets counter for backup
     */
    public void resetStats() {
        fileCopied = 0;
        sizeCopied = 0;
        error = 0;
        taskStart = 0;
        taskFinish = 0;
        errorMsgList = "";
        backupSize = "";
    }

    /**
     * adds size of backup to result message
     *
     * @param backupSize
     */
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