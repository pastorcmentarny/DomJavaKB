package dms.pastor.tools.nanobackup.GUI;

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

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.verify;

/**
 * Author Dominik Symonowicz
 * Created 27/06/2018
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
@RunWith(MockitoJUnitRunner.class)
public class AboutAcceptanceTest {
    @SuppressWarnings("StaticFieldReferencedViaSubclass") // used for testing
    private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME);

    @Mock
    private Appender<ILoggingEvent> mockAppender;

    @Captor
    private ArgumentCaptor<ILoggingEvent> captorLoggingEvent;

    @Before
    public void setup() {
        LOGGER.addAppender(mockAppender);
    }

    @After
    public void teardown() {
        LOGGER.detachAppender(mockAppender);
    }

    @SuppressWarnings("AccessStaticViaInstance")
    @Test
    public void shouldGui() {
        // when
        final About aboutGui = new About();
        aboutGui.setVisible(true);
        aboutGui.closeWindow();
        // then
        verify(mockAppender, atLeast(2)).doAppend(captorLoggingEvent.capture());
        final ILoggingEvent loggingEvent = captorLoggingEvent.getValue();
        assertThat(loggingEvent.getLevel()).isEqualTo(Level.DEBUG);
        assertThat(loggingEvent.getFormattedMessage()).isEqualTo("About GUI displayed.");

    }
}