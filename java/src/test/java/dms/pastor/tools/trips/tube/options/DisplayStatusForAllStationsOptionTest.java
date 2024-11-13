package dms.pastor.tools.trips.tube.options;


import dms.pastor.tools.trips.common.options.DisplayStatusForAllStationsOption;
import dms.pastor.tools.trips.common.station.Stations;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.time.LocalDate;

import static dms.pastor.tools.trips.common.station.StationType.TUBE;
import static dms.pastor.tools.trips.tube.builders.StationsBuilder.stationsBuilder;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author Dominik Symonowicz
 * WWW:	<a href="https://dominiksymonowicz.com/">HOME PAGE</a>
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class DisplayStatusForAllStationsOptionTest {
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream original = System.out;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
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
        displayStatusForAllStationsOption.choose(stations,TUBE);

        // then
        assertThat(outputStream.toString()).contains("Wembley Park was visited at " + LocalDate.now() + System.lineSeparator() +
                "Green Park was passed at " + LocalDate.now() + System.lineSeparator() +
                "Elm Park was not visited");

    }

}
