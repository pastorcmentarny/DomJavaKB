package dms.pastor.exercises.readtimer;

import org.junit.Test;

import static dms.pastor.exercises.readtimer.ReadSpeed.ADULT_AVERAGE;
import static dms.pastor.exercises.readtimer.ReadSpeed.getSpeedAsStringFor;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author Dominik Symonowicz
 * Created 18/03/2017
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
public class ReadSpeedTest {

    @Test
    public void shouldReturnSpeedAsString() throws Exception {
        // given
        final String expectedSpeedAsString = "250";

        // when
        final String speed = getSpeedAsStringFor(ADULT_AVERAGE);

        // then
        assertThat(speed).isEqualTo(expectedSpeedAsString);
    }
}