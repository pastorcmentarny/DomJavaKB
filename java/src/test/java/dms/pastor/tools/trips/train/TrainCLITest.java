package dms.pastor.tools.trips.train;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class TrainCLITest {

    private static final String ABERYSTYWTH_VALID_STATION = "Aberystywth";


    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream original = System.out;

    private TrainCLI cli = null;

    @Mock
    private Scanner scanner;

    @BeforeEach
    public void setUpStreams() {
        cli = new TrainCLI(scanner);
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
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