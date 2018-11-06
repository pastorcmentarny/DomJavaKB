package dms.pastor.tools.trips.tube;

import dms.pastor.tools.trips.tube.station.Stations;
import dms.pastor.tools.trips.tube.station.Status;
import dms.pastor.tools.trips.tube.station.TubeStation;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

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
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
@SuppressWarnings("resource")
@RunWith(MockitoJUnitRunner.class)
public class TubeCLITest {

    private static final String ELM_PARK_VALID_STATION = "Elm Park";
    @Rule
    public final ExpectedException exception = ExpectedException.none();

    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream original = System.out;

    private TubeCLI cli = null;

    @Mock
    private Scanner scanner;

    @Before
    public void setUpStreams() {
        cli = new TubeCLI(generateStations(), scanner);
        System.setOut(new PrintStream(outputStream));
    }

    @After
    public void cleanUpStreams() throws IOException {
        outputStream.close();
        System.setOut(original);
    }

    @Test
    public void shouldDisplayMenu() {
        //given
        final String expectedFirstLine = "0. Stats";
        final String expectedLastLine = "9. Exit" + System.lineSeparator();
        given(scanner.nextInt()).willReturn(9);

        //when
        cli.mainMenu();

        //then
        assertThat(outputStream.toString()).startsWith(expectedFirstLine);
        assertThat(outputStream.toString()).endsWith(expectedLastLine);
    }

    @Test
    public void shouldDisplayAllStationStats() {
        //given
        when(scanner.nextInt()).thenReturn(8)
                .thenReturn(9);

        //when
        cli.mainMenu();

        //then
        assertThat(outputStream.toString()).contains("Wembley Park" + System.lineSeparator() +
                "Green Park" + System.lineSeparator() +
                ELM_PARK_VALID_STATION + System.lineSeparator());
    }

    @Test
    public void shouldDisplayStatusForAllStations() {
        //given
        when(scanner.nextInt()).thenReturn(1)
                .thenReturn(9);

        //when
        cli.mainMenu();

        //then
        assertThat(outputStream.toString()).contains("Wembley Park was visited at " + LocalDate.now() + System.lineSeparator() +
                "Green Park was passed at " + LocalDate.now() + System.lineSeparator() +
                "Elm Park was not visited" + System.lineSeparator());
    }

    @Test
    public void findStationShouldDisplayInfoAboutWembleyPark() {
        //given
        when(scanner.nextInt()).thenReturn(2)
                .thenReturn(9);
        when(scanner.next()).thenReturn("Wembley Park");

        //when
        cli.mainMenu();

        //then
        assertThat(outputStream.toString()).contains("Wembley Park was visited");

    }

    @Test
    public void updateStationStatusToPassedShouldDisplayErrorMessageIfStationCannotBeFound() {
        // given
        final String invalidStationName = generateString(10);
        when(scanner.nextInt()).thenReturn(3).thenReturn(2)
                .thenReturn(9);
        when(scanner.next()).thenReturn(invalidStationName);

        //when
        cli.mainMenu();

        // then
        assertThat(outputStream.toString()).contains("TubeStation " + invalidStationName + " not found");
    }

    @Test
    public void updateStationStatusToPassedShouldUpdateNotVisitedStationToPassed() {
        // given
        when(scanner.nextInt()).thenReturn(3).thenReturn(2)
                .thenReturn(9);
        when(scanner.next()).thenReturn(ELM_PARK_VALID_STATION);
        when(scanner.nextLine()).thenReturn(ELM_PARK_VALID_STATION);

        //when
        cli.mainMenu();

        // then
        assertThat(outputStream.toString()).contains("You set Elm Park status to passed");
        assertThat(outputStream.toString()).contains("Elm Park was passed");

    }

    @Test
    public void updateStationStatusToVisitedShouldDisplayErrorMessageIfStationCannotBeFound() {
        // given
        final String invalidStationName = generateString(10);
        when(scanner.nextInt()).thenReturn(4).thenReturn(2)
                .thenReturn(9);
        when(scanner.next()).thenReturn(invalidStationName);

        //when
        cli.mainMenu();

        // then
        assertThat(outputStream.toString()).contains("TubeStation " + invalidStationName + " not found");
    }

    @Test
    public void updateStationStatusToVisitedShouldUpdateNotVisitedStationToVisited() {
        // given
        when(scanner.nextInt()).thenReturn(4).thenReturn(2)
                .thenReturn(9);
        when(scanner.next()).thenReturn(ELM_PARK_VALID_STATION);
        when(scanner.nextLine()).thenReturn(ELM_PARK_VALID_STATION);

        //when
        cli.mainMenu();

        // then
        assertThat(outputStream.toString()).contains("You set Elm Park status to visited");
        assertThat(outputStream.toString()).contains("Elm Park was visited");

    }

    private Stations generateStations() {
        List<TubeStation> tubeStationList = new ArrayList<>();
        tubeStationList.add(stationBuilder().name("Wembley Park").status(Status.VISITED).build());
        tubeStationList.add(TubeStation.passed("Green Park", LocalDate.now()));
        tubeStationList.add(TubeStation.notVisited(ELM_PARK_VALID_STATION));
        return new Stations(tubeStationList);
    }

}
