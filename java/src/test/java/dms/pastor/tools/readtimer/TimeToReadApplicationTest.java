package dms.pastor.tools.readtimer;

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

import java.util.List;

import static dms.pastor.utils.randoms.RandomDataGenerator.generateString;
import static dms.pastor.utils.randoms.RandomDataGenerator.randomPositiveInteger;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;

/**
 * Author Dominik Symonowicz
 * Created 25/12/2016
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
@RunWith(MockitoJUnitRunner.class)
public class TimeToReadApplicationTest {

    @SuppressWarnings("StaticFieldReferencedViaSubclass") // used for testing
    private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME);

    @Mock
    private Appender<ILoggingEvent> mockAppender;

    @Captor
    private ArgumentCaptor<ILoggingEvent> captorLoggingEvent;

    @Before
    public void setUp() {
        LOGGER.addAppender(mockAppender);
    }

    @After
    public void tearDown() {
        LOGGER.detachAppender(mockAppender);
    }

    @Test
    public void shouldRunDemoWhenRunningWithoutArgumentsAcceptanceTest() {
        // given
        final String[] args = {generateString(), String.valueOf(randomPositiveInteger())};

        // when
        TimeToReadApplication.main(args);

        // then assert logs
        verify(mockAppender, atLeastOnce()).doAppend(captorLoggingEvent.capture());
        final List<ILoggingEvent> loggingEvents = captorLoggingEvent.getAllValues();
        assertThat(loggingEvents.get(0).getLevel()).isEqualTo(Level.INFO);
        assertThat(loggingEvents.get(1).getLevel()).isEqualTo(Level.INFO);
        assertThat(loggingEvents.get(2).getLevel()).isEqualTo(Level.DEBUG);
        assertThat(loggingEvents.get(3).getLevel()).isEqualTo(Level.INFO);
        assertThat(loggingEvents.get(0).getFormattedMessage()).contains("Starting application..");
        assertThat(loggingEvents.get(2).getFormattedMessage()).contains("Words:1");
        assertThat(loggingEvents.get(3).getFormattedMessage()).contains("RIP .. at ");
    }

}