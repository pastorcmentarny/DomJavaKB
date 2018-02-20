package dms.pastor.examples.scheduletask;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.Appender;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;

/**
 * Author Dominik Symonowicz
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
@RunWith(MockitoJUnitRunner.class)
public class ScheduleTaskExampleRunnerTest {

    private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME);

    @Mock
    private Appender<ILoggingEvent> mockAppender;

    @Captor
    private ArgumentCaptor<ILoggingEvent> captorLoggingEvent;

    @Before
    public void setUp() throws Exception {
        LOGGER.addAppender(mockAppender);
    }

    @After
    public void tearDown() throws Exception {
        LOGGER.detachAppender(mockAppender);
    }

    @Test
    public void runScheduleTaskExample() throws Exception {
        // given
        final String name = "Dominik";

        // when
        ScheduleTaskExampleRunner.runScheduleTaskExample(name);

        // then get logs
        verify(mockAppender, atLeastOnce()).doAppend(captorLoggingEvent.capture());
        final List<ILoggingEvent> allLoggingEvents = captorLoggingEvent.getAllValues();
        final int firstLog = 0;
        final int taskLog = 1;
        final int lastLog = allLoggingEvents.size() - 1;

        // then check first log
        assertThat(allLoggingEvents.get(firstLog).getLevel()).isEqualTo(Level.DEBUG);
        assertThat(allLoggingEvents.get(firstLog).getFormattedMessage()).endsWith("Running ScheduleTask Example");

        // then check task log
        assertThat(allLoggingEvents.get(taskLog).getLevel()).isEqualTo(Level.INFO);
        assertThat(allLoggingEvents.get(taskLog).getFormattedMessage()).endsWith(" running " +
                name + " at " +
                LocalDate.now() + ".");

        // then check last log
        assertThat(allLoggingEvents.get(lastLog).getLevel()).isEqualTo(Level.DEBUG);
        assertThat(allLoggingEvents.get(lastLog).getFormattedMessage()).endsWith("End of ScheduleTask Example");

    }

}
