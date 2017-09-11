package dms.pastor.game.dcs.spells;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.Appender;
import dms.pastor.game.dcs.Elements;
import dms.pastor.game.dcs.units.Unit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.slf4j.LoggerFactory;

import java.io.*;

import static dms.pastor.game.dcs.Elements.noElements;
import static dms.pastor.game.dcs.ElementsBuilder.elementsBuilder;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public final class NoSpellTest {
    public static final Unit UNUSED_UNIT = null;
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
    public void getInstanceShouldReturnSingleInstanceOfNoSpell() {
        // given
        final NoSpell instanceOne = NoSpell.getInstance();

        // when
        final NoSpell instanceTwo = NoSpell.getInstance();

        // then
        assertThat(instanceOne.hashCode()).isEqualTo(instanceTwo.hashCode());
    }

    @Test
    public void noSpellSerializationTest() throws Exception {
        // given
        final NoSpell instanceOne = NoSpell.getInstance();
        final String tmpFileName = "noSpell.serialized";

        ObjectOutput objectToSerialize = new ObjectOutputStream(new FileOutputStream(
                tmpFileName));
        objectToSerialize.writeObject(instanceOne);
        objectToSerialize.close();

        // when
        ObjectInput in = new ObjectInputStream(new FileInputStream(
                tmpFileName));
        NoSpell instanceTwo = (NoSpell) in.readObject();
        in.close();

        // then
        assertThat(instanceOne.hashCode()).isEqualTo(instanceTwo.hashCode());

        // after
        new File(tmpFileName).deleteOnExit();
    }

    @Test
    public void isASpellShouldReturnFalseForNoSpell() throws Exception {
        // when
        final boolean result = NoSpell.getInstance().isASpell(elementsBuilder().build());

        //then
        assertThat(result).isFalse();
    }


    @Test
    public void hasEnoughElementsToCovertToSpellShouldReturnFalseForNoSpell() throws Exception {
        // when
        final boolean result = NoSpell.getInstance().hasEnoughElementsToCovertToSpell(elementsBuilder().build());

        //then
        assertThat(result).isFalse();
    }

    @Test
    public void getElementsShouldReturnNoElementsForNoSpell() throws Exception {
        // when
        final Elements result = NoSpell.getInstance().getElements();

        //then
        assertThat(result).isEqualTo(noElements());
    }

    @Test
    public void castSpellShouldLogMessage() throws Exception {
        // when
        NoSpell.getInstance().castSpell(UNUSED_UNIT, UNUSED_UNIT);

        // then assert logs
        verify(mockAppender).doAppend(captorLoggingEvent.capture());
        final ILoggingEvent loggingEvent = captorLoggingEvent.getValue();
        assertThat(loggingEvent.getLevel()).isEqualTo(Level.WARN);
        assertThat(loggingEvent.getFormattedMessage()).isEqualTo("Nothing happen. (Bug? Casting spell for No Spell???)");
    }

    @Test
    public void setElementsShouldLogWarnMessage() throws Exception {
        // when
        NoSpell.getInstance().setElements(elementsBuilder().build());

        // then assert logs
        verify(mockAppender).doAppend(captorLoggingEvent.capture());
        final ILoggingEvent loggingEvent = captorLoggingEvent.getValue();
        assertThat(loggingEvent.getLevel()).isEqualTo(Level.WARN);
        assertThat(loggingEvent.getFormattedMessage()).isEqualTo("Bug detected! Something trying to set elements on NoSpell.");
    }

}
