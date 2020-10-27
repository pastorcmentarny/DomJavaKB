package dms.pastor.examples.java14;

import java.util.Objects;

/**
 * Author Dominik Symonowicz
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class SwitchExpressionExample {

    public static final String ERROR_MESSAGE = "Can't determined day type as day is not provided";

    public static String getDayType(String day) {
        if (Objects.isNull(day)) {
            return ERROR_MESSAGE;
        }
        return switch (day) {
            case "Monday", "Tuesday", "Wednesday", "Thursday", "Friday" -> "Weekday";
            case "Saturday", "Sunday" -> "Weekend";
            default -> {
                if (day.isEmpty()) {
                    yield ERROR_MESSAGE;
                } else {
                    yield "Can't determined day type as input was invalid (input :" + day + ").";
                }
            }

        };
    }
}
