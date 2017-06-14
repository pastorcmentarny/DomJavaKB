package dms.pastor.tools;

import java.util.Calendar;

import static dms.pastor.utils.StringUtils.EMPTY_STRING;

/**
 * Author: Dominik Symonowicz
 * #Created:        16.11.2012
 * #WWW:			http://pastor.ovh.org
 * #Github:		https://github.com/pastorcmentarny
 * #Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * #LinkedIn: 		https://www.linkedin.com/in/dominik-symonowicz
 * #Email: 		email can be found on my website
 */
public class StopWatch {

    private static final long MINUTE = 60L;
    private static final long HOUR = 60L * MINUTE;
    private static final long DAY = 24 * HOUR * MINUTE;
    private static final int SECOND_IN_MILLISECONDS = 1000;

    private long start;
    private long finish;

    public void setStart(long start) {
        this.start = start;
    }

    public void setFinish(long finish) {
        this.finish = finish;
    }


    public long getStart() {
        return start;
    }

    public long getFinish() {
        return finish;
    }

    public void start() {
        finish = 0;
        start = Calendar.getInstance().getTimeInMillis();
    }

    public long calcTotalTime() {
        return finish - start;
    }

    public long calcCurrentTime() {
        return Calendar.getInstance().getTimeInMillis() - start;
    }

    public void stop() {
        finish = Calendar.getInstance().getTimeInMillis();
    }

    public void resetTimer() {
        start = 0;
        finish = 0;
    }

    public String displayTime() {
        int days;
        int hours;
        int minutes;
        int seconds;
        StringBuilder result = new StringBuilder(EMPTY_STRING);
        long time = calcTotalTime();
        time /= SECOND_IN_MILLISECONDS;
        days = (int) (time / DAY);
        time -= (days * DAY);
        hours = (int) (time / HOUR);
        time -= (hours * HOUR);
        minutes = (int) (time / MINUTE);
        time -= (minutes * MINUTE);
        seconds = (int) time;
        result.append("Time needed: ").append(days).append(" days, ");
        result.append(hours).append(" hours, ").append(minutes);
        result.append(" minutes and ").append(seconds).append(" seconds.");
        return result.toString();
    }

    public String getResultTimeAsString() {
        int sec = (int) calcTotalTime() / SECOND_IN_MILLISECONDS;
        int dot = (int) calcTotalTime() % SECOND_IN_MILLISECONDS;
        return String.valueOf(sec) + '.' + String.valueOf(dot) + "s.";
    }

}
