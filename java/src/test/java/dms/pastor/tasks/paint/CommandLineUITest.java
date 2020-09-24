package dms.pastor.tasks.paint;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static dms.pastor.utils.RegexUtils.countOccurrencesOf;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;

/**
 * Author Dominik Symonowicz
 * Created 14/07/2017
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 * tag-junit-timeout
 */
@RunWith(MockitoJUnitRunner.class)
public class CommandLineUITest {
    private static final int TEST_TIMEOUT = 2000; //used in case if command stuck with input
    private static final String ENTER_COMMAND_MESSAGE = "Enter command:";

    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    private PrintStream printStream;

    @Mock
    private Scanner scanner;

    @Before
    public void setUp() {
        printStream = System.out;
        System.setOut(new PrintStream(outputStream));
    }

    @After
    public void tearDown() {
        System.setOut(printStream);
    }

    @Test(timeout = TEST_TIMEOUT) // time out for this test only
    public void runApplicationShouldQuitIfUserTypeQuitCommand() {
        // given
        CommandLineUI commandLineUI = new CommandLineUI(scanner);
        given(scanner.nextLine()).willReturn("Q");

        // when
        commandLineUI.runApplication();

        // then
        assertThat(outputStream.toString()).contains(ENTER_COMMAND_MESSAGE);
    }

    @Test(timeout = TEST_TIMEOUT)
    public void shouldDisplayEnterCommandMessageIfUserDidNotTypeQuitCommand() {
        // given
        CommandLineUI commandLineUI = new CommandLineUI(scanner);
        when(scanner.nextLine()).thenReturn("X").thenReturn("Q");

        // when
        commandLineUI.runApplication();

        // then
        final int counter = countOccurrencesOf(ENTER_COMMAND_MESSAGE, outputStream.toString());
        assertThat(counter).isEqualTo(2);
    }

    @Test // example when it will use global time out
    public void shouldDisplayErrorMessageIfExecuteCommandThrowException() {
        // given
        CommandLineUI commandLineUI = new CommandLineUI(scanner);
        when(scanner.nextLine())
                .thenReturn("C 10 4")
                .thenReturn("L 1 0 3 0")
                .thenReturn("Q");

        // when
        commandLineUI.runApplication();

        // then
        assertThat(outputStream.toString()).contains("Invalid Syntax because");
    }

}
