package dms.pastor.tasks.paint.acceptance;

import dms.pastor.tasks.paint.CommandLineUI;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;

/**
 * Author Dominik Symonowicz
 * Created 12/07/2017
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 * <p>
 * This is a progressive acceptance test as example shows an example steps .This follows these steps
 */
@SuppressWarnings("SpellCheckingInspection") //off as test contains lots text as graphic elements
@ExtendWith(MockitoExtension.class)
public class AcceptanceTests {

    private static final String EMPTY_CANVAS = "----------------------" + System.lineSeparator() +
            "|                    |" + System.lineSeparator() +
            "|                    |" + System.lineSeparator() +
            "|                    |" + System.lineSeparator() +
            "|                    |" + System.lineSeparator() +
            "----------------------";

    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private PrintStream printStream;

    @Mock
    private Scanner scanner;

    @BeforeEach
    public void setUp() {
        printStream = System.out;
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(printStream);
    }

    @Test
    public void createNewCanvasAcceptanceTest() {
        // given
        CommandLineUI commandLineUI = new CommandLineUI(scanner);
        when(scanner.nextLine())
                .thenReturn("C 20 4")
                .thenReturn("Q");

        // when
        commandLineUI.runApplication();

        // then
        assertThat(outputStream.toString()).contains(System.lineSeparator() +
                EMPTY_CANVAS);
    }

    @Test
    public void createNewLineAcceptanceTest() {
        // given
        CommandLineUI commandLineUI = new CommandLineUI(scanner);
        when(scanner.nextLine())
                .thenReturn("C 20 4")
                .thenReturn("L 1 2 6 2")
                .thenReturn("L 6 3 6 4")
                .thenReturn("Q");
        // when
        commandLineUI.runApplication();

        // then
        assertThat(outputStream.toString()).contains(
                "----------------------" + System.lineSeparator() +
                        "|                    |" + System.lineSeparator() +
                        "|xxxxxx              |" + System.lineSeparator() +
                        "|     x              |" + System.lineSeparator() +
                        "|     x              |" + System.lineSeparator() +
                        "----------------------" + System.lineSeparator());
    }

    @Test
    public void createNewRectangleAcceptanceTest() {
        // given
        CommandLineUI commandLineUI = new CommandLineUI(scanner);
        when(scanner.nextLine())
                .thenReturn("C 20 4")
                .thenReturn("L 1 2 6 2")
                .thenReturn("L 6 3 6 4")
                .thenReturn("R 16 1 20 3")
                .thenReturn("Q");

        // when
        commandLineUI.runApplication();

        // then
        assertThat(outputStream.toString()).contains(
                "----------------------" + System.lineSeparator() +
                        "|               xxxxx|" + System.lineSeparator() +
                        "|xxxxxx         x   x|" + System.lineSeparator() +
                        "|     x         xxxxx|" + System.lineSeparator() +
                        "|     x              |" + System.lineSeparator() +
                        "----------------------" + System.lineSeparator());
    }

    @Test
    public void fillEntireAreaAcceptanceTest() {
        // given
        CommandLineUI commandLineUI = new CommandLineUI(scanner);
        when(scanner.nextLine())
                .thenReturn("C 20 4")
                .thenReturn("L 1 2 6 2")
                .thenReturn("L 6 3 6 4")
                .thenReturn("R 16 1 20 3")
                .thenReturn("B 10 3 o")
                .thenReturn("Q");

        // when
        commandLineUI.runApplication();

        // then
        assertThat(outputStream.toString()).contains(
                "----------------------" + System.lineSeparator() +
                        "|oooooooooooooooxxxxx|" + System.lineSeparator() +
                        "|xxxxxxooooooooox   x|" + System.lineSeparator() +
                        "|     xoooooooooxxxxx|" + System.lineSeparator() +
                        "|     xoooooooooooooo|" + System.lineSeparator() +
                        "----------------------");
    }

    @Test
    public void quitProgramAcceptanceTest() {
        // given
        CommandLineUI commandLineUI = new CommandLineUI(scanner);
        given(scanner.nextLine()).willReturn("Q");

        // when
        commandLineUI.runApplication();

        // then
        assertThat(outputStream.toString()).contains("Enter command:");
    }

    @Test
    public void fillOnAlreadyFilledRectangleAcceptanceTest() {
        // given
        CommandLineUI commandLineUI = new CommandLineUI(scanner);
        when(scanner.nextLine())
                .thenReturn("C 20 4")
                .thenReturn("R 2 2 10 3")
                .thenReturn("B 2 2 o")
                .thenReturn("Q");

        // when
        commandLineUI.runApplication();

        // then
        assertThat(outputStream.toString()).contains("----------------------" + System.lineSeparator() +
                "|                    |" + System.lineSeparator() +
                "| ooooooooo          |" + System.lineSeparator() +
                "| ooooooooo          |" + System.lineSeparator() +
                "|                    |" + System.lineSeparator() +
                "----------------------" + System.lineSeparator());
    }

    @Test
    public void clearCanvasAcceptanceTest() {
        // given
        CommandLineUI commandLineUI = new CommandLineUI(scanner);
        when(scanner.nextLine())
                .thenReturn("C 20 4")
                .thenReturn("R 2 2 10 3")
                .thenReturn("C")
                .thenReturn("Q");

        // when
        commandLineUI.runApplication();

        // then
        assertThat(outputStream.toString()).contains("Enter command:Q" + System.lineSeparator() + EMPTY_CANVAS);
    }

    @Test
    public void shouldExecuteUndoCommand() {

        // given
        CommandLineUI commandLineUI = new CommandLineUI(scanner);
        when(scanner.nextLine())
                .thenReturn("C 20 4")
                .thenReturn("L 1 1 3 1")
                .thenReturn("L 2 2 4 2")
                .thenReturn("R 2 2 4 4")
                .thenReturn("U")
                .thenReturn("Q");

        // when
        commandLineUI.runApplication();

        // then
        assertThat(outputStream.toString()).contains("Enter command:Q" + System.lineSeparator() +
                "----------------------" + System.lineSeparator() +
                "|xxx                 |" + System.lineSeparator() +
                "| xxx                |" + System.lineSeparator() +
                "|                    |" + System.lineSeparator() +
                "|                    |" + System.lineSeparator() +
                "----------------------" + System.lineSeparator()
        );

    }

    @Test
    public void shouldExecuteRedoCommand() {

        // given
        CommandLineUI commandLineUI = new CommandLineUI(scanner);
        when(scanner.nextLine())
                .thenReturn("C 20 4")
                .thenReturn("L 1 1 3 1")
                .thenReturn("U")
                .thenReturn("R")
                .thenReturn("L 2 2 4 2")
                .thenReturn("U")
                .thenReturn("R")
                .thenReturn("R 2 2 4 4")
                .thenReturn("U")
                .thenReturn("U")
                .thenReturn("R")
                .thenReturn("R")
                .thenReturn("Q");

        // when
        commandLineUI.runApplication();

        // then
        assertThat(outputStream.toString()).contains("Enter command:Q" + System.lineSeparator() +
                "----------------------" + System.lineSeparator() +
                "|xxx                 |" + System.lineSeparator() +
                "| xxx                |" + System.lineSeparator() +
                "| x x                |" + System.lineSeparator() +
                "| xxx                |" + System.lineSeparator() +
                "----------------------" + System.lineSeparator()
        );

    }

}
