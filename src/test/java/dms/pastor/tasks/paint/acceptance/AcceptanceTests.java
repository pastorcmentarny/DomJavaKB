package dms.pastor.tasks.paint.acceptance;

import dms.pastor.tasks.paint.CommandLineUI;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

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
@RunWith(MockitoJUnitRunner.class)
public class AcceptanceTests {

    private static final String EMPTY_CANVAS = "----------------------\n" +
            "|                    |\n" +
            "|                    |\n" +
            "|                    |\n" +
            "|                    |\n" +
            "----------------------";

    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private PrintStream printStream;

    @Mock
    private Scanner scanner;

    @Before
    public void setUp() throws Exception {
        printStream = System.out;
        System.setOut(new PrintStream(outputStream));
    }

    @After
    public void tearDown() throws Exception {
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

        //then
        assertThat(outputStream.toString()).contains("\r\n" +
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

        //then
        assertThat(outputStream.toString()).contains(
                "----------------------\n" +
                        "|                    |\n" +
                        "|xxxxxx              |\n" +
                        "|     x              |\n" +
                        "|     x              |\n" +
                        "----------------------\n");
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

        //then
        assertThat(outputStream.toString()).contains(
                "----------------------\n" +
                        "|               xxxxx|\n" +
                        "|xxxxxx         x   x|\n" +
                        "|     x         xxxxx|\n" +
                        "|     x              |\n" +
                        "----------------------\n");
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
        //then
        assertThat(outputStream.toString()).contains(
                "----------------------\n" +
                        "|oooooooooooooooxxxxx|\n" +
                        "|xxxxxxooooooooox   x|\n" +
                        "|     xoooooooooxxxxx|\n" +
                        "|     xoooooooooooooo|\n" +
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
        assertThat(outputStream.toString()).contains("----------------------\n" +
                "|                    |\n" +
                "| ooooooooo          |\n" +
                "| ooooooooo          |\n" +
                "|                    |\n" +
                "----------------------\n");
    }

    @Test //TODO test will work on Windows only :(
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
        assertThat(outputStream.toString()).contains("Enter command:Q\r\n" + EMPTY_CANVAS);
    }

}
