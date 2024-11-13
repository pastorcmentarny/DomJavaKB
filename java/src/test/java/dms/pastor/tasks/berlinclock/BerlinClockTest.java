package dms.pastor.tasks.berlinclock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;

import static dms.pastor.utils.StringUtils.EMPTY_STRING;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Author Dominik Symonowicz
 * WWW:	<a href="https://dominiksymonowicz.com/">HOME PAGE</a>
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class BerlinClockTest {
    private ClockInterface clock;

    @BeforeEach
    public void setUp() {
        clock = new BerlinClock();
    }

    @Test
    public void berlinClockTask() {
        // given
        ClockInterface berlinClock = new BerlinClock();
        LocalTime today = LocalTime.now();
        int hour = today.getHour();
        int minutes = today.getMinute();
        int seconds = today.getSecond();

        // when
        final String actualTime = berlinClock.showTime(berlinClock.getTimeAsString(hour, minutes, seconds));

        // then
        assertThat(actualTime).contains(String.valueOf(hour));
        assertThat(actualTime).contains(String.valueOf(minutes));
        assertThat(actualTime).contains(String.valueOf(seconds));

    }

    @Test
    public void testShowTime() {
        // given
        final LocalTime today = LocalTime.now();
        final int hour = today.getHour();
        final int minutes = today.getMinute();
        final int seconds = today.getSecond();

        // when
        final String currentTime = clock.showTime(clock.getTimeAsString(hour, minutes, seconds));

        // then
        assertThat(currentTime).contains(String.valueOf(hour));
        assertThat(currentTime).contains(String.valueOf(minutes));
        assertThat(currentTime).contains(String.valueOf(seconds));

    }

    @Test
    public void shouldShow1103001() {
        // given
        final String answer = "11::03:01";

        // when
        final String result = clock.getTimeAsString(11, 3, 1);

        // then
        assertThat(result).isEqualTo(answer);
    }

    @Test
    public void shouldShow23456() {
        // given
        final String answer = "02::34:56";

        // when
        final String result = clock.getTimeAsString(2, 34, 56);

        // then
        assertThat(result).isEqualTo(answer);
    }

    @Test()
    public void shouldNotValidateIfForNegativeInput() {
        assertThrows(IllegalArgumentException.class, () -> clock.getTimeAsString(-2, -34, -56));

    }

    @Test
    public void shouldValidate110301() {
        String time = "11::03:01";
        String answer = "11:03:01";
        assertThat(clock.validateTime(time).toString()).isEqualTo(answer);
    }

    @Test()
    public void shouldThrowsExceptionForTextAsInput() {
        assertThrows(IllegalArgumentException.class, () -> clock.validateTime("abc"));
    }

    @Test()
    public void shouldThrowExceptionForNullInput() {
        assertThrows(IllegalArgumentException.class, () -> clock.validateTime(null));
    }

    @Test()
    public void shouldThrowExceptionForEmptyInput() {
        assertThrows(IllegalArgumentException.class, () -> clock.validateTime(EMPTY_STRING));
    }

    @Test()
    public void convertToHourShouldThrowIllegalArgumentExceptionIfHourHasInvalidHourSeparatorFormat() {
        // given
        final String timeWithInvalidHour = "AA--00:11";

        // when
        assertThrows(IllegalArgumentException.class, () -> clock.validateTime(timeWithInvalidHour));
    }

    @Test()
    public void convertToHourShouldThrowIllegalArgumentExceptionIfHourIsNotInRangeFormat() {
        // given
        final String timeWithInvalidHour = "99::00:11";

        // when
        assertThrows(IllegalArgumentException.class, () -> clock.validateTime(timeWithInvalidHour));
    }

    @Test()
    public void convertToHourShouldThrowIllegalArgumentExceptionIfMinuteIsNotInRangeFormat() {
        // given
        final String timeWithInvalidHour = "10::99:11";

        // when
        assertThrows(IllegalArgumentException.class, () -> clock.validateTime(timeWithInvalidHour));
    }

    @Test()
    public void convertToHourShouldThrowIllegalArgumentExceptionIfSecondIsNotInRangeFormat() {
        // given
        final String timeWithInvalidHour = "11::00:99";

        // when
        assertThrows(IllegalArgumentException.class, () -> clock.validateTime(timeWithInvalidHour));
    }

    @Test()
    public void convertToHourShouldThrowIllegalArgumentExceptionIfHourHasInvalidMinuteFormat() {
        // given
        final String timeWithInvalidHour = "AA::00::11";

        // when
        assertThrows(IllegalArgumentException.class, () -> clock.validateTime(timeWithInvalidHour));
    }
}