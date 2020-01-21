package dms.pastor.examples;

import dms.pastor.utils.PrintOutUtils;

import java.time.*;
import java.time.format.TextStyle;
import java.util.*;

import static dms.pastor.utils.DateUtils.getWeekDaysAsList;
import static java.time.Month.JANUARY;

public class RotateListExample {

    public static String example(){
        var wednesday = LocalDate.of(2020, JANUARY,22).getDayOfWeek().getDisplayName(TextStyle.FULL_STANDALONE, Locale.ENGLISH);
        List<String> allDays = getWeekDaysAsList();
        int index = allDays.indexOf(wednesday);
        Collections.rotate(allDays,-index);
        return String.format("Rotate by %d day(s). Start: %s Last day: %s",index,allDays.get(0), allDays.get(6));
    }

}
