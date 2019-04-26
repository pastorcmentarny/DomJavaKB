package dms.pastor.tools.trips.train;

import dms.pastor.tools.trips.train.station.TrainStation;
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
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class TrainCLITest {

    private static final String ABERYSTYWTH_VALID_STATION = "Aberystywth";
    @Rule
    public final ExpectedException exception = ExpectedException.none();

    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream original = System.out;

    private TrainCLI cli = null;

    @Mock
    private Scanner scanner;

    @Before
    public void setUpStreams() {
        cli = new TrainCLI(new TrainStation(ABERYSTYWTH_VALID_STATION), scanner);
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

}