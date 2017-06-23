package dms.pastor.utils;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.util.Date;
import java.util.LinkedHashSet;

import static dms.pastor.utils.ValidatorUtils.validateIfNotNull;
import static dms.pastor.utils.ValidatorUtils.validateMinValueIsSmallerThanMaxValue;
import static java.time.ZoneId.getAvailableZoneIds;
import static java.time.temporal.ChronoUnit.DAYS;
import static java.util.stream.Collectors.joining;

/**
 * Author Dominik Symonowicz
 * Created 2015-10-31
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public final class DateUtils {

    private static final int SECOND = 1;
    public static final int MINUTE = 60 * SECOND;
    public static final int HOUR = 60 * MINUTE;

    private DateUtils() {
        //Utility class
    }

    static String displayTimeZoneList() {
        LinkedHashSet<String> allTimeZones = new LinkedHashSet<>(getAvailableZoneIds());
        return allTimeZones.stream().collect(joining());
    }

    private static boolean isInRange(int value, int max) {
        return value >= 0 && value <= max;
    }

    public static boolean isInHoursRange(int value) {
        return isInRange(value, 24);
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
        if (month == null) {
            throw new IllegalArgumentException(message);
        }
        for (Month m : Month.values()) {
            if (m.name().toLowerCase().startsWith(month.toLowerCase())) {
                return m.getValue();
            }
        }
        throw new IllegalArgumentException(message);
    }

    public static LocalDate toJavaDate(org.joda.time.LocalDate jodaDate) {
        return LocalDate.of(jodaDate.getYear(), jodaDate.getMonthOfYear(), jodaDate.getDayOfMonth());
    }

    static long getDayOfTheYearFor(LocalDate localDate) {
        validateIfNotNull(localDate, "Date");
        return DAYS.between(LocalDate.of(localDate.getYear(), 1, 1), localDate) + 1;
    }

    static long countLeapYearBetween(LocalDate start, LocalDate end) {
        validateIfNotNull(start, "Start date");
        validateIfNotNull(end, "End date");
        validateMinValueIsSmallerThanMaxValue(start.getYear(), end.getYear());

        int counter = 0;
        for (int i = start.getYear(); i <= end.getYear(); i++) {
            if (LocalDate.of(i, 1, 1).isLeapYear()) {
                counter++;
            }
        }
        return counter;
    }

    /*

    Convert java.util.Date to java.time.Instant class using Instant.ofEpochMilli
    Convert java.time.Instant to java.time.LocalDateTime using System's default timezone.
    Convert java.time.LocalDateTime to java.time.LocalDate in Java using ofInstant
    Instant is also an instant in time scale but it doesn't care about time zone but LocalDatetime class uses local Timezone.
    That's why when you convert an Instant to LocalDateTime, it needed a timezone.
    Read more: http://javarevisited.blogspot.com/2016/10/how-to-convert-javautildate-to-LocalDate-java8.html#ixzz4XA6cCz3M

    About "time zone" in java.util.Date does not store any time zone.
    When you create it via new Date()  (It used System.currentTimeMillis() method which based on default time zone)
    So when you print it will add the system default time zone will be displayed together.

    It is f.. confusing and thanks for Java 8 time.
     */
    @SuppressWarnings("UseOfObsoleteDateTimeApi") //it is used for conversion purposes
    public static LocalDate convertDateToLocalDate(Date date) {
        return LocalDateTime.ofInstant(Instant.ofEpochMilli(date.getTime()), ZoneId.systemDefault()).toLocalDate();
    }
}
