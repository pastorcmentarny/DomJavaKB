package dms.pastor.tools;

import java.util.Calendar;

/**
 * Author: Pastor cmentarny
 * #Created:        16.11.2012
 * #WWW:			http://pastor.ovh.org
 * #Github:		https://github.com/pastorcmentarny
 * #Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * #LinkedIn: 		uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 * #Email: 		email can be found on my website
 */
class StopWatch {
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
        StringBuilder result = new StringBuilder("");
        long time = calcTotalTime();
        time /= 1000L;
        days = (int) (time / 86400L);
        time -= (days * 86400L);
        hours = (int) (time / 3600L);
        time -= (hours * 3600L);
        minutes = (int) (time / 60L);
        time -= (minutes * 60L);
        seconds = (int) time;
        result.append("Time needed: ").append(days).append(" days, ");
        result.append(hours).append(" hours, ").append(minutes);
        result.append(" minutes and ").append(seconds).append(" seconds.");
        return result.toString();
    }

    public String getResultTimeAsString() {
        int sec = (int) calcTotalTime() / 1000;
        int dot = (int) calcTotalTime() % 1000;
        return String.valueOf(sec) + '.' + String.valueOf(dot) + "s.";
    }

}
