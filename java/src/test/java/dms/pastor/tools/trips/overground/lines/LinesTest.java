package dms.pastor.tools.trips.overground.lines;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * Author Dominik Symonowicz
 * Created 08/06/2018
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class LinesTest {

    @Test
    public void getLinesShouldReturnAllLines() {
        // when
        final var lines = AllOvergroundLines.getLines();

        // then
        assertThat(lines).hasSize(1);
    }
}