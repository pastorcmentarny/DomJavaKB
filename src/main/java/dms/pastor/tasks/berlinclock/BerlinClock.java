package dms.pastor.tasks.berlinclock;

import dms.pastor.tasks.berlinclock.data.Time;
import dms.pastor.utils.DateUtils;

import static dms.pastor.utils.StringUtils.EMPTY_STRING;
import static dms.pastor.utils.ValidatorUtils.validateIfNotEmpty;
import static java.lang.Integer.parseInt;

/**
 * Author Dominik Symonowicz
 * Created 2013-07-24
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class BerlinClock implements ClockInterface {

    private static final String INVALID_INPUT = "Input is invalid. Please check your input, correct it and try again";
    private static final String HOUR_SEPARATOR = "::";
    private static final char MINUTES_SEPARATOR = ':';

    @Override
    public String showTime(String givenTime) {
        StringBuilder timeBuilder = new StringBuilder(EMPTY_STRING);
        Time time = getTimeFromString(givenTime);
        RowsGenerator rowsGenerator = new RowsGenerator(time);
        timeBuilder.append(time.toString())
                .append('\n')
                .append(rowsGenerator.generateRows());
        return timeBuilder.toString();
    }

    /**
     * In The Berlin Clock description is written that Berlin Clock for a given
     * time (hh::mm:ss), I am not sure is :: in your description is typo and
     * should be : or not If is them i should use time.split(":") method,if not
     * I should use regex expression. but well at least it makes more tricky
     *
     * @param time a time in format (hh::mm:ss)
     * @return array of hours,minutes and second .
     * will contains hh,mm,ss
     */
    public Time validateTime(String time) {
        validateIfNotEmpty(time);

        String hour, minutes, seconds;

        String[] tmpHours = time.split(HOUR_SEPARATOR);
        String[] tmpMinutesAndSeconds = convertToMinutesAndSecond(tmpHours);

        if (tmpHours.length != 2 && tmpMinutesAndSeconds.length != 2) {
            throw new IllegalArgumentException(INVALID_INPUT);
        } else {
            for (char character : time.toCharArray()) {
                if (!(Character.isDigit(character) || character == MINUTES_SEPARATOR)) {
                    throw new IllegalArgumentException(INVALID_INPUT);
                }
            }
        }
        hour = tmpHours[0];
        minutes = tmpMinutesAndSeconds[0];
        seconds = tmpMinutesAndSeconds[1];
        validateIfTimeIsInRange(parseInt(hour), parseInt(minutes), parseInt(seconds));
        return new Time(parseInt(hour), parseInt(minutes), parseInt(seconds));
    }

    private void validateIfTimeIsInRange(int h, int m, int s) {
        if (!(DateUtils.isInHoursRange(h) && DateUtils.isInMinutesRange(m) && DateUtils.isInSecondsRange(s))) {
            throw new IllegalArgumentException(INVALID_INPUT);
        }
    }

    public String getTimeAsString(int hour, int minutes, int seconds) {
        String time = asDoubleDigit(hour) + HOUR_SEPARATOR + asDoubleDigit(minutes) + MINUTES_SEPARATOR + asDoubleDigit(seconds);
        validateTime(time);
        return time;
    }

    @SuppressWarnings("ProhibitedExceptionCaught") // exception is rethrown with better error message
    private String[] convertToMinutesAndSecond(String[] tmpHours) {
        String[] tmpMinutesAndSeconds;
        try {
            tmpMinutesAndSeconds = tmpHours[1].split(String.valueOf(MINUTES_SEPARATOR));
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new IllegalArgumentException(INVALID_INPUT, e);
        }
        return tmpMinutesAndSeconds;
    }

    private Time getTimeFromString(String time) {
        return validateTime(time);
    }

    private String asDoubleDigit(int value) {
        return value > 10 ? String.valueOf(value) : "0" + value;
    }
}
