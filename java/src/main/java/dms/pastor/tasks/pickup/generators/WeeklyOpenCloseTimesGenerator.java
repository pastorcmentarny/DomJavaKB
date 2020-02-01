package dms.pastor.tasks.pickup.generators;

import dms.pastor.tasks.pickup.OpenCloseTime;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import static dms.pastor.tasks.pickup.OpenCloseTime.getClosedOn;
import static dms.pastor.tasks.pickup.OpenCloseTime.getOpen24HoursOn;

public class WeeklyOpenCloseTimesGenerator {

    public static final List<String> ALL_DAYS_IN_THE_WEEK = List.of("MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY", "SATURDAY", "SUNDAY");

    private WeeklyOpenCloseTimesGenerator() {
    }

    public static List<OpenCloseTime> getTypicalWeeklyOpenCloseTimes() {
        List<OpenCloseTime> week = new ArrayList<>(getAllWeekDaysTypicalOpenClose());
        week.add(getNormalOpenCloseHoursForSaturday());
        week.add(getNormalOpenCloseHoursForSunday());
        return week;
    }

    public static List<OpenCloseTime> getWeekOnlyOpenCloseTimes() {
        List<OpenCloseTime> week = new ArrayList<>(getAllWeekDaysTypicalOpenClose());
        week.add(getClosedOn("SATURDAY"));
        week.add(getClosedOn("SUNDAY"));
        return week;
    }

    public static List<OpenCloseTime> getOpen24HoursPerDay7DaysAWeek() {
        var week = new ArrayList<OpenCloseTime>();
        for (String day : ALL_DAYS_IN_THE_WEEK) {
            week.add(getOpen24HoursOn(day));
        }
        return week;
    }

    public static List<OpenCloseTime> getClosed24HoursPerDay7DaysAWeek() {
        var week = new ArrayList<OpenCloseTime>();
        for (String day : ALL_DAYS_IN_THE_WEEK) {
            week.add(getClosedOn(day));
        }
        return week;
    }


    private static List<OpenCloseTime> getAllWeekDaysTypicalOpenClose() {
        return List.of(getNormalOpenCloseHoursFor("Monday"),
                getNormalOpenCloseHoursFor("Tuesday"),
                getNormalOpenCloseHoursFor("Wednesday"),
                getNormalOpenCloseHoursFor("Thursday"),
                getNormalOpenCloseHoursFor("Friday"));
    }

    public static OpenCloseTime getNormalOpenCloseHoursFor(String day) {
        return new OpenCloseTime(day, LocalTime.of(9, 0), LocalTime.of(19, 30));
    }

    public static OpenCloseTime getNormalOpenCloseHoursForSaturday() {
        return new OpenCloseTime("Saturday", LocalTime.of(8, 0), LocalTime.of(16, 45));
    }

    public static OpenCloseTime getNormalOpenCloseHoursForSunday() {
        return new OpenCloseTime("Sunday", LocalTime.of(10, 30), LocalTime.of(16, 30));
    }

    public static List<OpenCloseTime> getMixedOpeningTimes() {
        var week = new ArrayList<OpenCloseTime>();
        week.add(getNormalOpenCloseHoursFor("Monday"));
        week.add(getNormalOpenCloseHoursFor("Tuesday"));
        week.add(getNormalOpenCloseHoursFor("Wednesday"));
        week.add(getNormalOpenCloseHoursFor("Thursday"));
        week.add(getOpen24HoursOn("Friday"));
        week.add(getOpen24HoursOn("Saturday"));
        week.add(getClosedOn("Sunday"));
        return week;
    }
}
