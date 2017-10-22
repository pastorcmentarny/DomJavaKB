package dms.pastor.tasks.berlinclock.clocks.berlinclock;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.time.LocalTime;

import static dms.pastor.utils.StringUtils.EMPTY_STRING;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;

/**
 * Author Dominik Symonowicz
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class BerlinClockTest {

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    private ClockInterface clock;

    @Before
    public void setUp() throws Exception {
        clock = new BerlinClock();
    }

    @Test
    public void berlinClockTask() throws Exception {
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
    public void testShowTime() throws Exception {
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
    public void shouldShow1103001() throws Exception {
        final String answer = "11::03:01";
        final String result = clock.getTimeAsString(11, 3, 1);
        Assert.assertThat(result, is(answer));
    }

    @Test
    public void shouldShow23456() throws Exception {
        final String answer = "02::34:56";
        final String result = clock.getTimeAsString(2, 34, 56);
        Assert.assertThat(result, is(answer));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldNotValidateIfForNegativeInput() throws Exception {
        final String result = clock.getTimeAsString(-2, -34, -56);
        System.out.println(result);
    }

    @Test
    public void shouldValidate110301() throws Exception {
        String time = "11::03:01";
        String answer = "11:03:01";
        Assert.assertThat(clock.validateTime(time).toString(), is(answer));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowsExceptionForTextAsInput() throws Exception {
        clock.validateTime("abc");
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionForNullInput() throws Exception {
        clock.validateTime(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionForEmptyInput() throws Exception {
        clock.validateTime(EMPTY_STRING);
    }

    @Test
    public void convertToHourShouldThrowIllegalArgumentExceptionIfHourHasInvalidHourSeparatorFormat() {
        // expect
        exception.expect(IllegalArgumentException.class);

        // given
        final String timeWithInvalidHour = "AA--00:11";

        // when
        clock.validateTime(timeWithInvalidHour);
    }

    @Test
    public void convertToHourShouldThrowIllegalArgumentExceptionIfHourIsNotInRangeFormat() {
        // expect
        exception.expect(IllegalArgumentException.class);

        // given
        final String timeWithInvalidHour = "99::00:11";

        // when
        clock.validateTime(timeWithInvalidHour);
    }

    @Test
    public void convertToHourShouldThrowIllegalArgumentExceptionIfMinuteIsNotInRangeFormat() {
        // expect
        exception.expect(IllegalArgumentException.class);

        // given
        final String timeWithInvalidHour = "10::99:11";

        // when
        clock.validateTime(timeWithInvalidHour);
    }

    @Test
    public void convertToHourShouldThrowIllegalArgumentExceptionIfSecondIsNotInRangeFormat() {
        // expect
        exception.expect(IllegalArgumentException.class);

        // given
        final String timeWithInvalidHour = "11::00:99";

        // when
        clock.validateTime(timeWithInvalidHour);
    }

    @Test
    public void convertToHourShouldThrowIllegalArgumentExceptionIfHourHasInvalidMinuteFormat() {
        // expect
        exception.expect(IllegalArgumentException.class);

        // given
        final String timeWithInvalidHour = "AA::00::11";

        // when
        clock.validateTime(timeWithInvalidHour);
    }
}