package dms.pastor.tools.trips.tube.options;


import dms.pastor.tools.trips.tube.station.Stations;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import static dms.pastor.tools.trips.tube.builders.StationsBuilder.stationsBuilder;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author Dominik Symonowicz
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class DisplayStatisticOptionTest {
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream original = System.out;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outputStream));
    }

    @After
    public void cleanUpStreams() throws IOException {
        outputStream.close();
        System.setOut(original);
    }

    @Test
    public void shouldDisplayStatistic() {
        // given
        final DisplayStatisticOption displayStatisticOption = new DisplayStatisticOption();
        final Stations stations = stationsBuilder().build();

        // when
        displayStatisticOption.choose(stations);

        // then
        assertThat(outputStream.toString()).contains("You visited 1 station(s). (33%)" + System.lineSeparator() +
                "You passed 1 station(s). (33%)");

    }

}