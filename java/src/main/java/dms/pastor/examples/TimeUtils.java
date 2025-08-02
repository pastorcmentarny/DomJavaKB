package dms.pastor.examples;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class TimeUtils {

    public static long get() {
        LocalDateTime landingTime = LocalDateTime.of(2026, 1, 23, 17, 55);
        return LocalDateTime.now().until(landingTime, ChronoUnit.MINUTES);
    }

    public static void main(String[] args) {
        System.out.println(get());
    }
}
