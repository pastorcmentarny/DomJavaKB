package dms.pastor.examples.java8.time;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Set;

final class TimeBasics {

    public static void main(String[] args) {
        getCurrentTimeAsString();
        gettingCurrentDateTimeInJava();
        displayTimeInLondonWroclawBeijing();
        getCurrentTimeWithOffset();
        displayAllTimeZone(false);
    }

    private static void displayAllTimeZone(boolean display) {
        if (display) {
            final Set<String> availableZoneIds = ZoneId.getAvailableZoneIds();
            availableZoneIds.stream().sorted().forEach(System.out::println);
        }
    }

    private static void displayTimeInLondonWroclawBeijing() {

        ZoneId wroclawZone = ZoneId.of("Europe/Warsaw");
        ZoneId londonZone = ZoneId.of("Europe/London");
        ZoneId tianjinZone = ZoneId.of("Asia/Shanghai");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime wroclaw = LocalTime.now(wroclawZone);
        LocalTime london = LocalTime.now(londonZone);
        LocalTime tianjin = LocalTime.now(tianjinZone);
        String wroclawTime = wroclaw.format(timeFormatter);
        String londonTime = london.format(timeFormatter);
        String tianjinTime = tianjin.format(timeFormatter);
        System.out.println("Time: [London " + londonTime + " ][ Wroclaw " + wroclawTime + " ][ Tianjin " + tianjinTime + " ]");
    }

    private static String getCurrentTimeAsString() {
        LocalDate currentTime = LocalDate.now();
        final String result = String.format("Current time is %s", currentTime);
        System.out.println(result);
        return result;
    }

    private static void gettingCurrentDateTimeInJava() {
        LocalDate todayDate = LocalDate.now();
        System.out.println(todayDate);
        LocalTime todayTime = LocalTime.now();
        System.out.println(todayTime);
    }

    private static void getCurrentTimeWithOffset() {
        ZoneOffset zoneOffset = ZoneOffset.of("-08:00");
        ZoneId offsetZoneId = ZoneId.ofOffset("UTC", zoneOffset);
        LocalTime time = LocalTime.now(offsetZoneId);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("hh:mm a");
        String formattedTime = time.format(dateTimeFormatter);
        System.out.println("Current time of the day with offset " + zoneOffset.toString() + " is " + formattedTime);

    }
}
