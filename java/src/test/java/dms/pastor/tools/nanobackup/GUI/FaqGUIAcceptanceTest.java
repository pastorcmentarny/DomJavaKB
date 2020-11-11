package dms.pastor.tools.nanobackup.GUI;

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

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.verify;

/**
 * Author Dominik Symonowicz
 * Created 26/06/2018
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
@ExtendWith(MockitoExtension.class)
public class FaqGUIAcceptanceTest {
    @SuppressWarnings("StaticFieldReferencedViaSubclass") // used for testing
    private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME);

    @Mock
    private Appender<ILoggingEvent> mockAppender;

    @Captor
    private ArgumentCaptor<ILoggingEvent> captorLoggingEvent;

    @BeforeEach
    public void setup() {
        LOGGER.addAppender(mockAppender);
    }

    @AfterEach
    public void teardown() {
        LOGGER.detachAppender(mockAppender);
    }

    @Test
    public void shouldDisplayFaqGui() {
        // when
        final FaqGUI aboutGui = new FaqGUI();
        aboutGui.setVisible(true);
        aboutGui.closeWindow();
        // then
        verify(mockAppender, atLeast(2)).doAppend(captorLoggingEvent.capture());
        final ILoggingEvent loggingEvent = captorLoggingEvent.getValue();
        assertThat(loggingEvent.getLevel()).isEqualTo(Level.DEBUG);
        assertThat(loggingEvent.getFormattedMessage()).isEqualTo("FAQ GUI displayed.");

    }
}