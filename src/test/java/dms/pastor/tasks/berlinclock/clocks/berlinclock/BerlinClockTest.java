package dms.pastor.tasks.berlinclock.clocks.berlinclock;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

import static org.hamcrest.CoreMatchers.is;

/**
 * Author Dominik Symonowicz
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
public class BerlinClockTest {
    private ClockInterface clock;

    @Before
    public void setUp() throws Exception {
        clock = new BerlinClock();
    }

    @Test
    public void berlinClockTask() throws Exception {
        System.out.println("Running a Berlin clock... ");
        BerlinClock clock = new BerlinClock();
        Date date = new Date();   // given date
        Calendar calendar = Calendar.getInstance(); // creates a new calendar instance
        calendar.setTime(date);   // assigns calendar to given date
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minutes = calendar.get(Calendar.MINUTE);
        int seconds = calendar.get(Calendar.SECOND);
        System.out.println(clock.showTime(clock.getTimeAsString(hour, minutes, seconds)));

        System.out.println("End of program.\nGoodbye ! ");

    }


    @Test
    public void testShowTime() throws Exception {

        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);   // assigns calendar to given date
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minutes = calendar.get(Calendar.MINUTE);
        int seconds = calendar.get(Calendar.SECOND);

        clock.showTime(clock.getTimeAsString(hour, minutes, seconds));
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
        clock.validateTime("");
    }

}