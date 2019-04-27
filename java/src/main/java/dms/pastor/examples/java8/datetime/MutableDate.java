package dms.pastor.examples.java8.datetime;

import java.time.*;
import java.util.Date;

final class MutableDate {

    private static final int SECOND_IN_MILLISECONDS = 1000;
    private static final int MINUTE = 60 * SECOND_IN_MILLISECONDS;
     static final String POLAND = "Europe/Warsaw";
     static final String UK = "Europe/London";
     static final String CHINA = "Asia/Shanghai";
     static final String AUSTRALIA = "Australia/Sydney";

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


     void calendarMisconceptions() {
        //given date and time
        LocalDate localDate = LocalDate.of(2016, Month.AUGUST, 5);
        LocalTime localTime = LocalTime.of(10, 22);
        LocalDateTime localDateTime = LocalDateTime.of(localDate, localTime);
        System.out.println("Local Date and Time is: " + localDateTime);

        //set date and time in Warsaw and Sydney
        ZonedDateTime warsaw = ZonedDateTime.of(localDateTime, ZoneId.of(POLAND));
        System.out.println("Warsaw's Date and Time is: " + warsaw);
        ZonedDateTime sydney = ZonedDateTime.of(localDateTime, ZoneId.of(AUSTRALIA));
        System.out.println("Sydney's Date and Time is: " + sydney);
        System.out.println("Time difference :");

        //move date to February
        localDateTime = localDateTime.minusMonths(6);
        System.out.println("Local Date and Time is: " + localDateTime);
        warsaw = ZonedDateTime.of(localDateTime, ZoneId.of(POLAND));
        sydney = ZonedDateTime.of(localDateTime, ZoneId.of(AUSTRALIA));
        System.out.println("Warsaw's Date and Time is: " + warsaw);
        System.out.println("Sydney's Date and Time is: " + sydney);
    }
}
