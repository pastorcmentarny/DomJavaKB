package dms.pastor.examples.java8.time;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author Dominik Symonowicz
 * Created 27/04/2019
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
public class TimeBasicsAcceptanceTest {


    @Test
    public void displayAllTimeZoneAcceptanceTest() {
        // when
        TimeBasics.displayAllTimeZone(false);

        // then shouldn't crash and display
    }

    @Test
    public void getTimeInLondonWroclawBeijing() {
        // when
        final var result = TimeBasics.getTimeInLondonWroclawBeijing();

        // debug
        System.out.println(result);

        // then
        assertThat(result).isNotBlank();
    }

    @Test
    public void getCurrentTimeAsStringAcceptanceTest() {
        // when
        final var result = TimeBasics.getCurrentTimeAsString();

        // debug
        System.out.println(result);

        // then
        assertThat(result).isNotBlank();
    }

    @Test
    public void gettingCurrentDateTimeInJavaAcceptanceTest() {
        // when
        final var result = TimeBasics.gettingCurrentDateTimeInJava();

        // debug
        System.out.println(result);

        // then
        assertThat(result).isNotBlank();
    }

    @Test
    public void getCurrentTimeWithOffsetAcceptanceTest() {
        // when
        final var result = TimeBasics.getCurrentTimeWithOffset();

        // debug
        System.out.println(result);

        // then
        assertThat(result).isNotBlank();
    }
}