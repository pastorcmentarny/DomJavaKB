package dms.pastor.tools.trips.tube.options;


import dms.pastor.tools.trips.common.options.LoadStationOption;
import dms.pastor.tools.trips.common.options.Option;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import static dms.pastor.tools.trips.common.station.StationType.TUBE;
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
public class LoadOvergroundStationNameOptionTest {
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
    public void shouldLoadStationsFromFile() {
        // given
        final Option loadStationOption = new LoadStationOption();

        // when
        loadStationOption.choose(stationsBuilder().build(),TUBE);

        // then
        assertThat(outputStream.toString()).endsWith("Data loaded." + System.lineSeparator());

    }
}