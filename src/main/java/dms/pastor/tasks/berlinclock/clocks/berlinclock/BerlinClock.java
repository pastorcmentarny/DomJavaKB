package dms.pastor.tasks.berlinclock.clocks.berlinclock;

import dms.pastor.tasks.berlinclock.data.Time;
import dms.pastor.utils.DateUtils;

import static java.lang.String.valueOf;

/**
 * Author Dominik Symonowicz
 * Created 2013-07-24
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
public class BerlinClock implements ClockInterface {

    private static final String HOUR_SEPARATOR = "::";
    private static final char MINUTES_SEPARATOR = ':';

    @Override
    public String showTime(String givenTime) {
        StringBuilder timeBuilder = new StringBuilder("");
        Time time = validateTime(givenTime);
        RowsGenerator rowsGenerator = new RowsGenerator(time);
        timeBuilder.append(time.toString()).append('\n');
        timeBuilder.append(rowsGenerator.generateRows());
        return timeBuilder.toString();
    }

    /**
     * In The Berlin Clock description is written that Berlin Clock for a given
     * time (hh::mm:ss), I am not sure is :: in your description is typo and
     * should be : or not If is them i should use time.split(":") method,if not
     * I should use regex expression. but well at least it makes more tricky
     *
     * @param time a time in format (hh::mm:ss)
     * @return array of hours,minutes and second .//TODO use TIME object that
     * will contains hh,mm,ss
     */
    public Time validateTime(String time) {
        String invalidInput = "Input is invalid. Please check your input, correct it and try again";
        if (time == null || time.isEmpty()) {
            throw new IllegalArgumentException(invalidInput);
        }
        String hh, mm, ss;
        int h, m, s;
        String[] tmpHours;
        String[] tmpMinutesAndSeconds;
        try {
            tmpHours = time.split(HOUR_SEPARATOR);
            tmpMinutesAndSeconds = tmpHours[1].split(valueOf(MINUTES_SEPARATOR));
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new IllegalArgumentException(invalidInput, e);
        }

        if (tmpHours.length != 2 && tmpMinutesAndSeconds.length != 2) {
            throw new IllegalArgumentException(invalidInput);
        } else {
            for (char character : time.toCharArray()) {
                if (!(Character.isDigit(character) || character == MINUTES_SEPARATOR)) {
                    throw new IllegalArgumentException(invalidInput);
                }
            }
        }
        hh = tmpHours[0];
        mm = tmpMinutesAndSeconds[0];
        ss = tmpMinutesAndSeconds[1];
        h = Integer.parseInt(hh);
        m = Integer.parseInt(mm);
        s = Integer.parseInt(ss);
        if (!(DateUtils.isInHoursRange(h) && DateUtils.isInMinutesRange(m) && DateUtils.isInSecondsRange(s))) {
            throw new IllegalArgumentException(invalidInput);
        }
        return new Time(h, m, s);
    }

    public String getTimeAsString(int hour, int minutes, int seconds) {
        String time = asDoubleDigit(hour) + HOUR_SEPARATOR + asDoubleDigit(minutes) + MINUTES_SEPARATOR + asDoubleDigit(seconds);
        validateTime(time);
        return time;
    }

    private String asDoubleDigit(int value) {
        return value > 10 ? valueOf(value) : "0" + value;
    }
}
