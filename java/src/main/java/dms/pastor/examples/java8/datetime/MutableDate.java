package dms.pastor.kb.java8.datetime;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

final class MutableDate {

    private static final int SECOND_IN_MILLISECONDS = 1000;
    private static final int MINUTE = 60 * SECOND_IN_MILLISECONDS;
    private static final String POLAND = "Europe/Warsaw";
    private static final String UK = "Europe/London";
    private static final String CHINA = "Asia/Shanghai";
    private static final String AUSTRALIA = "Australia/Sydney";

    public static void main(String[] args) {
        MutableDate oldDate = new MutableDate();
        //oldDate.mutabilityMadnessExample();

        oldDate.runExamples();
    }

    private void mutabilityMadnessExample() {
        Date now = new Date();
        System.out.println(now);
        System.out.println(addOneMinute(now));
        System.out.println(now); //now was .....changed but it shouldn't.
    }

    private Date addOneMinute(Date date) {
        date.setTime(date.getTime() + MINUTE);
        return date;
    }

    private void runExamples() {
        Instant instant = Instant.now();
        System.out.println(instant);
        ZonedDateTime dateTime = ZonedDateTime.ofInstant(instant, ZoneId.of(UK));
        System.out.println(dateTime);
        ZonedDateTime wroclawZonedDateTime = ZonedDateTime.ofInstant(instant, ZoneId.of(POLAND));
        System.out.println(wroclawZonedDateTime);
        ZonedDateTime tianjinZonedDateTime = ZonedDateTime.ofInstant(instant, ZoneId.of(CHINA));
        System.out.println(tianjinZonedDateTime);

        System.out.println("=== - ==");
        calendarMisconceptions();
    }

    private void calendarMisconceptions() {
        //given date and time
        LocalDate localDate = LocalDate.of(2016, Month.AUGUST,5);
        LocalTime localTime = LocalTime.of(10,22);
        LocalDateTime localDateTime = LocalDateTime.of(localDate,localTime);
        System.out.println("Local Date and Time is: " + localDateTime);

        //set date and time in Warsaw and Sydney
        ZonedDateTime warsaw = ZonedDateTime.of(localDateTime, ZoneId.of(POLAND));
        System.out.println("Warsaw's Date and Time is: " + warsaw);
        ZonedDateTime sydney = ZonedDateTime.of(localDateTime, ZoneId.of(AUSTRALIA));
        System.out.println("Sydney's Date and Time is: " + sydney);
        System.out.println("Time difference :"  );

        //move date to February
        localDateTime = localDateTime.minusMonths(6);
        System.out.println("Local Date and Time is: " + localDateTime);
        warsaw = ZonedDateTime.of(localDateTime, ZoneId.of(POLAND));
        sydney = ZonedDateTime.of(localDateTime, ZoneId.of(AUSTRALIA));
        System.out.println("Warsaw's Date and Time is: " + warsaw);
        System.out.println("Sydney's Date and Time is: " + sydney);
    }
}
