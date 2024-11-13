package dms.pastor.tools.trips.overground;

import dms.pastor.tools.trips.common.options.Status;
import dms.pastor.tools.trips.common.station.Station;
import dms.pastor.tools.trips.common.station.Stations;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static dms.pastor.tools.trips.tube.builders.StationBuilder.stationBuilder;
import static dms.pastor.utils.randoms.RandomDataGenerator.generateString;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
/**
 * Author Dominik Symonowicz
 * WWW:	<a href="https://dominiksymonowicz.com/">HOME PAGE</a>
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
@ExtendWith(MockitoExtension.class)
class OvergroundCLITest {

    private static final String WATFORD_JUNCTION_VALID_STATION = "Watford Junction";


    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream original = System.out;

    private OvergroundCLI cli = null;

    @Mock
    private Scanner scanner;

    @BeforeEach
    public void setUpStreams() {
        cli = new OvergroundCLI(generateStations(), scanner);
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    public void cleanUpStreams() throws IOException {
        outputStream.close();
        System.setOut(original);
    }

    @Test
    public void shouldDisplayMenu() {
        // given
        final String expectedFirstLine = "0. Stats";
        final String expectedLastLine = "9. Exit" + System.lineSeparator();
        given(scanner.nextInt()).willReturn(9);

        // when
        cli.mainMenu();

        // then
        assertThat(outputStream.toString()).startsWith(expectedFirstLine);
        assertThat(outputStream.toString()).endsWith(expectedLastLine);
    }

    @Test
    public void shouldDisplayAllStationStats() {
        // given
        when(scanner.nextInt()).thenReturn(13)
                .thenReturn(9);

        // when
        cli.mainMenu();

        // then
        assertThat(outputStream.toString()).contains("North Wembley" + System.lineSeparator() +
                "Wembley Central" + System.lineSeparator() +
                WATFORD_JUNCTION_VALID_STATION + System.lineSeparator());
    }


    @Test
    public void shouldDisplayStatusForAllStations() {
        // given
        when(scanner.nextInt()).thenReturn(11)
                .thenReturn(9);

        // when
        cli.mainMenu();

        // then
        assertThat(outputStream.toString()).contains("North Wembley was visited at " + LocalDate.now() + System.lineSeparator() +
                "Wembley Central was passed at " + LocalDate.now() + System.lineSeparator() +
                "Watford Junction was not visited" + System.lineSeparator());
    }

    @Test
    public void findStationShouldDisplayInfoAboutWembleyPark() {
        // given
        when(scanner.nextInt()).thenReturn(12)
                .thenReturn(9);
        when(scanner.next()).thenReturn("North Wembley");

        // when
        cli.mainMenu();

        // then
        assertThat(outputStream.toString()).contains("North Wembley was visited");

    }

    @Test
    public void updateStationStatusToPassedShouldDisplayErrorMessageIfStationCannotBeFound() {
        // given
        final String invalidStationName = generateString(10);
        when(scanner.nextInt()).thenReturn(21).thenReturn(12)
                .thenReturn(9);
        when(scanner.next()).thenReturn(invalidStationName);

        // when
        cli.mainMenu();

        // then
        assertThat(outputStream.toString()).contains("Station " + invalidStationName + " not found");
    }

    @Test
    public void updateStationStatusToPassedShouldUpdateNotVisitedStationToPassed() {
        // given
        when(scanner.nextInt()).thenReturn(21).thenReturn(12)
                .thenReturn(9);
        when(scanner.next()).thenReturn(WATFORD_JUNCTION_VALID_STATION);
        when(scanner.nextLine()).thenReturn(WATFORD_JUNCTION_VALID_STATION);

        // when
        cli.mainMenu();

        // then
        assertThat(outputStream.toString()).contains("You set Watford Junction status to passed");
        assertThat(outputStream.toString()).contains("Watford Junction was passed");

    }

    @Test
    public void updateStationStatusToVisitedShouldDisplayErrorMessageIfStationCannotBeFound() {
        // given
        final String invalidStationName = generateString(10);
        when(scanner.nextInt()).thenReturn(22).thenReturn(12)
                .thenReturn(9);
        when(scanner.next()).thenReturn(invalidStationName);

        // when
        cli.mainMenu();

        // then
        assertThat(outputStream.toString()).contains("Station " + invalidStationName + " not found");
    }

    @Test
    public void updateStationStatusToVisitedShouldUpdateNotVisitedStationToVisited() {
        // given
        when(scanner.nextInt()).thenReturn(22).thenReturn(12)
                .thenReturn(9);
        when(scanner.next()).thenReturn(WATFORD_JUNCTION_VALID_STATION);
        when(scanner.nextLine()).thenReturn(WATFORD_JUNCTION_VALID_STATION);

        // when
        cli.mainMenu();

        // then
        assertThat(outputStream.toString()).contains("You set Watford Junction status to visited");
        assertThat(outputStream.toString()).contains("Watford Junction was visited");

    }

    private Stations generateStations() {
        List<Station> stationList = new ArrayList<>();
        stationList.add(stationBuilder().name("North Wembley").status(Status.VISITED).build());
        stationList.add(Station.passed("Wembley Central", LocalDate.now()));
        stationList.add(Station.notVisited(WATFORD_JUNCTION_VALID_STATION));
        return new Stations(stationList);
    }
}