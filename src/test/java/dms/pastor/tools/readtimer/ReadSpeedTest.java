package dms.pastor.tools.readtimer;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static dms.pastor.tools.readtimer.ReadSpeed.ADULT_SLOW;
import static dms.pastor.tools.readtimer.ReadSpeed.getSpeedAsStringFor;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author Dominik Symonowicz
 * Created 18/03/2017
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class ReadSpeedTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void shouldReturnSpeedAsString() {
        // given
        final String expectedSpeedAsString = "130";

        // when
        final String speed = getSpeedAsStringFor(ADULT_SLOW);

        // then
        assertThat(speed).isEqualTo(expectedSpeedAsString);
    }

    @Test
    public void getSpeedAsStringForShouldReturnAdultAverageIfValueNull() {

        // when
        final String defaultSpeed = getSpeedAsStringFor(null);

        // then
        assertThat(defaultSpeed).isEqualTo("250");

    }

}