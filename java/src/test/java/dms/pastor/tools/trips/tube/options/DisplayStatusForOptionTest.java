package dms.pastor.tools.trips.tube.options;

import dms.pastor.tools.trips.tube.station.Stations;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.time.LocalDate;
import java.util.Scanner;

import static dms.pastor.tools.trips.tube.builders.StationsBuilder.stationsBuilder;
import static dms.pastor.utils.randoms.RandomDataGenerator.generateString;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

/**
 * Author Dominik Symonowicz
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
@RunWith(MockitoJUnitRunner.class)
public class DisplayStatusForOptionTest {
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream original = System.out;

    @Mock
    private Scanner scanner;
    @InjectMocks
    private DisplayStatusForOption displayStatusForAllStationsOption;

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
    public void shouldDisplayStatusForSpecifiedStation() {
        // given
        final Stations stations = stationsBuilder().build();
        given(scanner.next()).willReturn("Wembley Park");

        // when
        displayStatusForAllStationsOption.choose(stations);

        // then
        assertThat(outputStream.toString()).contains("Wembley Park was visited at " + LocalDate.now());
    }

    @Test
    public void chooseDisplayStatusForSpecifiedStationShouldDisplayErrorMessageIfRequestedStationCannotBeFound() {
        // given
        final Stations stations = stationsBuilder().build();
        final String invalidStationName = generateString(32, 64);
        given(scanner.next()).willReturn(invalidStationName);

        // when
        displayStatusForAllStationsOption.choose(stations);

        // then
        assertThat(outputStream.toString()).contains("TubeStation " + invalidStationName + " not found.");
    }
}