package dms.pastor.tools.tube;

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
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static dms.pastor.tools.tube.Line.noLine;
import static dms.pastor.utils.randoms.RandomDataGenerator.generateString;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TubeCLITest {
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
        final String expectedFirstLine = "0. Stats.";
        final String expectedLastLine = "9. Exit." + System.lineSeparator();
        given(scanner.nextInt()).willReturn(9);

        //when
        cli.main();

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
        cli.main();

        //then
        assertThat(outputStream.toString()).contains("Wembley Park" + System.lineSeparator() +
                "Green Park" + System.lineSeparator() +
                "Elm Park" + System.lineSeparator());
    }

    @Test
    public void shouldDisplayStatusForAllStations() {
        //given
        when(scanner.nextInt()).thenReturn(1)
                .thenReturn(9);

        //when
        cli.main();

        //then
        assertThat(outputStream.toString()).contains("Wembley Park was visited" + System.lineSeparator() +
                "Green Park was passed" + System.lineSeparator() +
                "Elm Park was not visited" + System.lineSeparator());
    }

    @Test
    public void findStationShouldDisplayInfoAboutWembleyPark() {
        //given
        when(scanner.nextInt()).thenReturn(2)
                .thenReturn(9);
        when(scanner.next()).thenReturn("Wembley Park");

        //when
        cli.main();

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
        cli.main();

        // then
        assertThat(outputStream.toString()).contains("Station " + invalidStationName + " not found");
    }

    @Test
    public void updateStationStatusToPassedShouldUpdateNotVisitedStationToPassed() {
        // given
        when(scanner.nextInt()).thenReturn(3).thenReturn(2)
                .thenReturn(9);
        when(scanner.next()).thenReturn("Elm Park");

        //when
        cli.main();

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
        cli.main();

        // then
        assertThat(outputStream.toString()).contains("Station " + invalidStationName + " not found");
    }


    @Test
    public void updateStationStatusToVisitedShouldUpdateNotVisitedStationToVisited() {
        // given
        when(scanner.nextInt()).thenReturn(4).thenReturn(2)
                .thenReturn(9);
        when(scanner.next()).thenReturn("Elm Park");

        //when
        cli.main();

        // then
        assertThat(outputStream.toString()).contains("You set Elm Park status to visited");
        assertThat(outputStream.toString()).contains("Elm Park was visited");

    }

    private Stations generateStations() {
        List<Station> stationList = new ArrayList<>();
        stationList.add(new Station("Wembley Park", Status.VISITED, noLine()));
        stationList.add(new Station("Green Park", Status.PASSED, noLine()));
        stationList.add(new Station("Elm Park", Status.NOT_VISITED, noLine()));
        return new Stations(stationList);
    }

}
