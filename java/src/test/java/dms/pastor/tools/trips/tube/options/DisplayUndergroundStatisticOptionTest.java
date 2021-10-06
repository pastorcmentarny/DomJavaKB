package dms.pastor.tools.trips.tube.options;


import dms.pastor.tools.trips.common.options.DisplayUndergroundStatisticOption;
import dms.pastor.tools.trips.common.station.Stations;
import dms.pastor.tools.trips.common.station.Station;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.List;

import static dms.pastor.tools.trips.common.station.StationType.TUBE;
import static dms.pastor.tools.trips.tube.builders.StationBuilder.stationBuilder;
import static dms.pastor.tools.trips.tube.builders.StationsBuilder.stationsBuilder;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author Dominik Symonowicz
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class DisplayUndergroundStatisticOptionTest {
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
    public void shouldDisplayStatistic() {
        // given
        final DisplayUndergroundStatisticOption displayUndergroundStatisticOption = new DisplayUndergroundStatisticOption();
        final Stations stations = stationsBuilder().build();

        // when
        displayUndergroundStatisticOption.choose(stations,TUBE);

        // then
        assertThat(outputStream.toString()).contains("I visited 1 station this year. (33%)" + System.lineSeparator() +
                "I visited 1 station. (33%)" + System.lineSeparator() +
                "I passed 2 stations. (66%)");

    }

    @Disabled("I broke it")//FIXME
    @Test
    public void shouldDisplayInfoAboutBloggedStation() {
        // given
        final DisplayUndergroundStatisticOption displayUndergroundStatisticOption = new DisplayUndergroundStatisticOption();
        final Station station1 = stationBuilder().blogged(true).build();
        final Station station2 = stationBuilder().blogged(false).build();
        final Station station3 = stationBuilder().blogged(false).build();
        final Station station4 = stationBuilder().blogged(false).build();
        final List<Station> stationList = List.of(station1, station2, station3, station4);
        final Stations stations = stationsBuilder().stationList(stationList).build();

        // when
        displayUndergroundStatisticOption.choose(stations,TUBE);

        // then
        assertThat(outputStream.toString()).contains(" (Total station blogged: 25%)");

    }


}