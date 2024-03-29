package dms.pastor.examples.java14;

import java.util.Objects;

/**
 * Author Dominik Symonowicz
 * WWW:	<a href="https://dominiksymonowicz.com/welcome">...</a>
 * IT BLOG:	<a href="https://dominiksymonowicz.blogspot.co.uk">...</a>
 * GitHub:	<a href="https://github.com/pastorcmentarny">...</a>
 * Google Play:	<a href="https://play.google.com/store/apps/developer?id=Dominik+Symonowicz">...</a>
 * LinkedIn: <a href="https://www.linkedin.com/in/dominik-symonowicz">...</a>
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
