package dms.pastor.examples.java14;


import org.junit.jupiter.api.Test;

import static dms.pastor.examples.java14.SwitchExpressionExample.ERROR_MESSAGE;
import static dms.pastor.examples.java14.SwitchExpressionExample.getDayType;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author Dominik Symonowicz
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
class SwitchExpressionExampleTest {
    static final String WEEKDAY = "Weekday";
    static final String WEEKEND = "Weekend";

    @Test
    public void shouldReturnWeekdayForMondayTest() {
        // when
        var result = getDayType("Monday");

        // then
        assertThat(result).isEqualTo(WEEKDAY);
    }

    @Test
    public void shouldReturnWeekendForSaturdayTest() {
        // when
        var result = getDayType("Saturday");

        // then
        assertThat(result).isEqualTo(WEEKEND);
    }

    @Test
    public void shouldReturnErrorForInvalidDayInputTest() {
        // when
        final String input = "Wtorek";
        var result = getDayType(input);

        // then
        assertThat(result).isEqualTo("Can't determined day type as input was invalid (input :" + input + ").");
    }

    @Test
    public void shouldReturnErrorMessageWhenInputIsEmptyTest() {
        // when
        var result = getDayType("");

        // then
        assertThat(result).isEqualTo(ERROR_MESSAGE);
    }

    @Test
    public void shouldReturnErrorMessageWhenInputIsNullTest() {
        // when
        var result = getDayType(null);

        // then
        assertThat(result).isEqualTo(ERROR_MESSAGE);
    }
}