package dms.pastor.tools.trips.tube.options;

import dms.pastor.tools.trips.tube.station.Stations;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import static dms.pastor.tools.trips.tube.builders.StationBuilder.stationBuilder;
import static dms.pastor.tools.trips.tube.builders.StationsBuilder.stationsBuilder;
import static java.util.Collections.singletonList;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author Dominik Symonowicz
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class DisplayAllStationsNameOptionTest {
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
    public void shouldDisplayAllStationsName() {
        // given
        final DisplayAllStationsNameOption displayAllStationsNameOption = new DisplayAllStationsNameOption();
        final Stations stations = stationsBuilder().build();

        // when
        displayAllStationsNameOption.choose(stations);

        // then
        assertThat(outputStream.toString()).contains("Wembley Park" + System.lineSeparator() +
                "Green Park" + System.lineSeparator() +
                "Elm Park");

    }

    @Test
    public void shouldDisplayWarningIfListDoNotHaveEnoughStationInList() {
        // given
        final DisplayAllStationsNameOption displayAllStationsNameOption = new DisplayAllStationsNameOption();
        final Stations stations = stationsBuilder()
                .stationList(singletonList(stationBuilder().build()))
                .build();

        // when
        displayAllStationsNameOption.choose(stations);

        // then
        assertThat(outputStream.toString()).contains("WARNING! Total number should be 269 but file contains only 1");

    }

}