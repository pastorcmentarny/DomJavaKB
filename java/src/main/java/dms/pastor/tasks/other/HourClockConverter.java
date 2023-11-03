package dms.pastor.tasks.other;

import dms.pastor.domain.exception.SomethingWentWrongException;
import dms.pastor.utils.StringUtils;

public class HourClockConverter {
    public static String to12Hour(String from24hour) {
        validate12Hour(from24hour);
        String[] data = from24hour.split(":");
        throwExceptionIfLenghIncorrectForSplittedData(data);

        String hourText = data[0];
        int hour = Integer.parseInt(hourText);
        String apm = hour >= 12 ? "PM" : "AM";
        if (apm.equals("AM") && hour == 0) {
            hour = 12;
        } else {
            hour = hour > 12 ? hour - 12 : hour;
        }


        String minutes = data[1];

        return String.format("%02d:%s %s", hour, minutes, apm);
    }

    public static String to24Hour(String from12hour) {
        validate12Hour(from12hour);
        String[] data = from12hour.split(":");
        throwExceptionIfLenghIncorrectForSplittedData(data);
        String hourAsString = data[0];

        data = data[1].split(" ");
        throwExceptionIfLenghIncorrectForSplittedData(data);
        String minutes = data[0];
        String apm = data[1];

        int hour = Integer.parseInt(hourAsString);

        if ("PM".equals(apm) && hour != 0 && hour != 12) {
            hour = hour + 12;
        } else if ("AM".equals(apm) && hour == 12) {
            hour = 0;
        }
        return String.format("%02d:%s", hour, minutes);
    }

    private static void throwExceptionIfLenghIncorrectForSplittedData(String[] data) {
        if (data.length != 2) {
            throwException();
        }
    }

    private static void throwException() {
        throw new SomethingWentWrongException("Gibberish input");
    }

    private static void validate12Hour(String from12hour) {
        if (StringUtils.isStringBlank(from12hour)) {
            throwException();
        }
    }
}
