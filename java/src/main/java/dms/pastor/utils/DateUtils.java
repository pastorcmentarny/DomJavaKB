package dms.pastor.utils;

import java.time.*;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoUnit;
import java.util.*;

import static dms.pastor.utils.StringUtils.EMPTY_STRING;
import static dms.pastor.utils.ValidatorUtils.validateIfObjectValueIsNotNull;
import static dms.pastor.utils.ValidatorUtils.validateValueIsSmallerOrEqualsThatOtherValue;
import static java.time.ZoneId.getAvailableZoneIds;
import static java.time.temporal.ChronoUnit.DAYS;

/**
 * Author Dominik Symonowicz
 * Created 2015-10-31
 * WWW:	<a href="https://dominiksymonowicz.com/">HOME PAGE</a>
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public final class DateUtils {

    private static final int SECOND = 1;
    public static final int MINUTE = 60 * SECOND;
    public static final int HOUR = 60 * MINUTE;
    private static final int HOURS_PER_DAY = 24;
    public static final String TIME_DIVIDER = ":";

    private DateUtils() {
        //Utility class
    }

    static String displayTimeZoneList() {
        LinkedHashSet<String> allTimeZones = new LinkedHashSet<>(getAvailableZoneIds());
        return String.join(EMPTY_STRING, allTimeZones);
    }

    private static boolean isInRange(int value, int max) {
        return value >= 0 && value <= max;
    }

    public static boolean isInHoursRange(int value) {
        return isInRange(value, HOURS_PER_DAY);
    }

    public static boolean isInMinutesRange(int value) {
        return isIn0to59Range(value);
    }

    public static boolean isInSecondsRange(int value) {
        return isIn0to59Range(value);
    }

    private static boolean isIn0to59Range(int value) {
        return isInRange(value, 59);
    }

    public static int getMonthNumberFromShortedName(String month) {
        final String message = "Invalid shortcut for month";
        validateIfObjectValueIsNotNull(month, message);

        for (Month thisMonth : Month.values()) {
            if (isMonthNameTheSame(month, thisMonth)) {
                return thisMonth.getValue();
            }
        }
        throw new IllegalArgumentException(message);
    }

    private static boolean isMonthNameTheSame(String month, Month thisMonth) {
        return thisMonth.name().toLowerCase().startsWith(month.toLowerCase());
    }


    static long getDayOfTheYearFor(LocalDate localDate) {
        validateIfObjectValueIsNotNull(localDate, "Date");
        return DAYS.between(LocalDate.of(localDate.getYear(), 1, 1), localDate) + 1;
    }

    static long countLeapYearBetween(LocalDate start, LocalDate end) {
        validateIfObjectValueIsNotNull(start, "Start date");
        validateIfObjectValueIsNotNull(end, "End date");
        validateValueIsSmallerOrEqualsThatOtherValue(start.getYear(), end.getYear());

        int counter = 0;
        for (int i = start.getYear(); i <= end.getYear(); i++) {
            if (LocalDate.of(i, 1, 1).isLeapYear()) {
                counter++;
            }
        }
        return counter;
    }

    /* //TODO check it

    Convert java.util.Date to java.time.Instant class using Instant.ofEpochMilli
    Convert java.time.Instant to java.time.LocalDateTime using System's default timezone.
    Convert java.time.LocalDateTime to java.time.LocalDate in Java using ofInstant
    Instant is also an instant in time scale but it doesn't care about time zone but LocalDatetime class uses local Timezone.
    That's why when you convert an Instant to LocalDateTime, it needed a timezone.
    Read more: http://javarevisited.blogspot.com/2016/10/how-to-convert-javautildate-to-LocalDate-java8.html#ixzz4XA6cCz3M

    About "time zone" in java.util.Date does not store any time zone.
    When you create it via new Date()  (It used System.currentTimeMillis() method which based on default time zone)
    So when you print it will add the system default time zone will be displayed together.

    It is f.. confusing and thanks for Java 8 time that based on great Joda library
     */
    @SuppressWarnings("UseOfObsoleteDateTimeApi") //it is used for conversion purposes
    static LocalDate convertDateToLocalDate(Date date) {
        return LocalDateTime.ofInstant(Instant.ofEpochMilli(date.getTime()), ZoneId.systemDefault()).toLocalDate();
    }

    public static int getMonthBetweenNowAnd(LocalDate date) {
        return Math.toIntExact(ChronoUnit.MONTHS.between(date, LocalDate.now()));
    }


    public static LocalTime getLocalTimeFrom12HourClockString(String time) {
        if (Objects.isNull(time)) return null;
        String divider = ".";
        if (time.contains(TIME_DIVIDER)) {
            divider = TIME_DIVIDER;
        }
        return LocalTime.parse(time.toLowerCase(), new DateTimeFormatterBuilder().appendPattern("h" + divider + "mma").toFormatter());
    }

    public static List<String> getWeekDaysAsList() {
        List<String> days = new ArrayList<>();
        days.add("Monday");
        days.add("Tuesday");
        days.add("Wednesday");
        days.add("Thursday");
        days.add("Friday");
        days.add("Saturday");
        days.add("Sunday");
        return days;
    }

    public static boolean isLeapYear(int year) {
        if (year % 4 != 0) {
            return false;
        } else if (year % 100 != 0) {
            return true;
        } else return year % 400 == 0;
    }
}
