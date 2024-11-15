package dms.pastor.tasks.paint;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.Appender;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

/**
 * Author Dominik Symonowicz
 * Created 13/07/2017
 * WWW:	<a href="https://dominiksymonowicz.com/">HOME PAGE</a>
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 * tag-test-log
 */
// auto closable not essential
@ExtendWith(MockitoExtension.class)
public class MainTest {

    @SuppressWarnings("StaticFieldReferencedViaSubclass") // used for testing
    private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME);

    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private PrintStream printStream;

    @Mock
    private Appender<ILoggingEvent> mockAppender;

    @Mock
    private Scanner scanner;

    @Captor
    private ArgumentCaptor<ILoggingEvent> captorLoggingEvent;

    @BeforeEach
    public void setUp() {
        printStream = System.out;
        System.setOut(new PrintStream(outputStream));
        LOGGER.addAppender(mockAppender);
    }

    @AfterEach
    public void tearDown() {
        LOGGER.detachAppender(mockAppender);
        System.setOut(printStream);
    }

    @Test
    public void mainShouldRunApplication() {
        // given
        Main main = new Main();
        given(scanner.nextLine()).willReturn("Q");
        main.setScanner(scanner);

        // when
        main.application();

        // then
        assertThat(outputStream.toString()).startsWith("Starting application");
        assertThat(outputStream.toString()).contains("Have a nice day!");

    }

    @Test
    public void testThatLogsWorks() {
        // given
        Main main = new Main();
        given(scanner.nextLine()).willReturn("Q");
        main.setScanner(scanner);

        // when
        main.application();

        // then assert logs
        verify(mockAppender).doAppend(captorLoggingEvent.capture());
        final ILoggingEvent loggingEvent = captorLoggingEvent.getValue();
        assertThat(loggingEvent.getLevel()).isEqualTo(Level.INFO);
        assertThat(loggingEvent.getFormattedMessage()).isEqualTo("Starting application ...");
    }

}
