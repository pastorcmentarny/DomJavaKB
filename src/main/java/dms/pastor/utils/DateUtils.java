package dms.pastor.utils;

import java.time.*;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.stream.Collectors;

/**
 * Author Dominik Symonowicz
 * Created 2015-10-31
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
public class DateUtils {

    public static final int HOUR = 3600;
    public static final int MINUTE = 60;

    private DateUtils() {
        //Utility class
    }

    static String displayTimeZoneList() {
        LinkedHashSet<String> allTimeZones = new LinkedHashSet<>(ZoneId.getAvailableZoneIds());
        return allTimeZones.stream().collect(Collectors.joining());
    }

    private static boolean inRange(int value, int max) {
        return value >= 0 && value <= max;
    }

    public static boolean inHoursRange(int value) {
        return inRange(value, 24);
    }

    public static boolean inMinutesRange(int value) {
        return in0to59Range(value);
    }

    public static boolean inSecondsRange(int value) {
        return in0to59Range(value);
    }

    private static boolean in0to59Range(int value) {
        return inRange(value, 59);
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
