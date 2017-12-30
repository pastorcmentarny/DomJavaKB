package dms.pastor.tools.tube.options;


import dms.pastor.tools.tube.station.Stations;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.time.LocalDate;

import static dms.pastor.tools.tube.builders.StationsBuilder.stationsBuilder;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author Dominik Symonowicz
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class DisplayStatusForAllStationsOptionTest {
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
    public void shouldDisplayStatusForAllStations() {
        // given
        final DisplayStatusForAllStationsOption displayStatusForAllStationsOption = new DisplayStatusForAllStationsOption();
        final Stations stations = stationsBuilder().build();

        // when
        displayStatusForAllStationsOption.choose(stations);

        // then
        assertThat(outputStream.toString()).contains("Wembley Park was visited at " + LocalDate.now() + System.lineSeparator() +
                "Green Park was passed at " + LocalDate.now() + System.lineSeparator() +
                "Elm Park was not visited");

    }

}
