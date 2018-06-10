package dms.pastor.tools.trips.tube.station;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author Dominik Symonowicz
 * Created 08/06/2018
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class StationTest {

    @Test
    public void hasShouldReturnTrueForExistingStation() {
        assertThat(Station.has("Wembley Park")).isTrue();
    }

    @Test
    public void hasShouldReturnFalseForNonExistingStation() {
        assertThat(Station.has("London Park")).isFalse();
    }
}