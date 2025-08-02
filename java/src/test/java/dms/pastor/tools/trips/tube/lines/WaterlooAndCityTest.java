package dms.pastor.tools.trips.tube.lines;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author Dominik Symonowicz
 * Created 08/06/2018
* Website: <a href="https://dominiksymonowicz.com/">Home Page</a>
* LinkedIn: <a href="https://www.linkedin.com/in/dominik-symonowicz">LinkedIn</a>
* GitHub: <a href="https://github.com/pastorcmentarny">GitHub</a>
 */
public class WaterlooAndCityTest {
    private final WaterlooAndCity line = new WaterlooAndCity();

    @Test
    public void getSizeShouldReturn2() {
        assertThat(line.getSize()).isEqualTo(2);
    }
}