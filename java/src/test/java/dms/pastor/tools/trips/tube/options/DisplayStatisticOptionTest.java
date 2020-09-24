package dms.pastor.tools.trips.tube.options;


import dms.pastor.tools.trips.tube.station.Stations;
import dms.pastor.tools.trips.tube.station.TubeStation;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.List;

import static dms.pastor.tools.trips.tube.builders.StationBuilder.stationBuilder;
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
        assertThat(outputStream.toString()).contains("You visited 1 station(s) this year. (33%)" + System.lineSeparator() +
                "You visited 1 station(s). (33%)" + System.lineSeparator() +
                "You passed 2 station(s). (66%)");

    }

    @Test
    public void shouldDisplayInfoAboutBloggedStation() {
        // given
        final DisplayStatisticOption displayStatisticOption = new DisplayStatisticOption();
        final TubeStation station1 = stationBuilder().blogged(true).build();
        final TubeStation station2 = stationBuilder().blogged(false).build();
        final TubeStation station3 = stationBuilder().blogged(false).build();
        final TubeStation station4 = stationBuilder().blogged(false).build();
        final List<TubeStation> tubeStationList = List.of(station1, station2, station3, station4);
        final Stations stations = stationsBuilder().stationList(tubeStationList).build();

        // when
        displayStatisticOption.choose(stations);

        // then
        assertThat(outputStream.toString()).contains(" (Total station blogged: 25%)");

    }


}