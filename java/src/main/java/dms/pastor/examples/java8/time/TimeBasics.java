package dms.pastor.examples.java8.time;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Set;

final class TimeBasics {


    static void displayAllTimeZone(boolean display) {
        if (display) {
            final Set<String> availableZoneIds = ZoneId.getAvailableZoneIds();
            availableZoneIds.stream().sorted().forEach(System.out::println);
        }
    }

    static String getTimeInLondonWroclawBeijing() {

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
        return "Time: [London " + londonTime + " ][ Wroclaw " + wroclawTime + " ][ Tianjin " + tianjinTime + " ]";
    }

    static String getCurrentTimeAsString() {
        LocalDate currentTime = LocalDate.now();
        final String result = String.format("Current time is %s", currentTime);
        System.out.println(result);
        return result;
    }

    static String gettingCurrentDateTimeInJava() {
        LocalDate todayDate = LocalDate.now();
        System.out.println(todayDate);
        LocalTime todayTime = LocalTime.now();
        System.out.println(todayTime);
        return todayTime.toString();
    }

    static String getCurrentTimeWithOffset() {
        ZoneOffset zoneOffset = ZoneOffset.of("-08:00");
        ZoneId offsetZoneId = ZoneId.ofOffset("UTC", zoneOffset);
        LocalTime time = LocalTime.now(offsetZoneId);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("hh:mm a");
        String formattedTime = time.format(dateTimeFormatter);
        return "Current time of the day with offset " + zoneOffset + " is " + formattedTime;

    }
}
