package dms.pastor.prototypes.dcs.spells;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.Appender;
import dms.pastor.prototypes.dcs.Elements;
import dms.pastor.prototypes.dcs.units.Unit;
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

import static dms.pastor.prototypes.dcs.Elements.noElements;
import static dms.pastor.prototypes.dcs.ElementsBuilder.elementsBuilder;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public final class NoSpellTest {
    private static final Unit UNUSED_UNIT = null;

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
    public void getInstanceShouldReturnSingleInstanceOfNoSpell() {
        // given
        final NoSpell instanceOne = NoSpell.getInstance();

        // when
        final NoSpell instanceTwo = NoSpell.getInstance();

        // then
        assertThat(instanceOne.hashCode()).isEqualTo(instanceTwo.hashCode());
    }

    @SuppressWarnings({"CastToConcreteClass", "resource"})
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
    public void isASpellShouldReturnFalseForNoSpell() {
        // when
        final boolean result = NoSpell.getInstance().isASpell(elementsBuilder().build());

        // then
        assertThat(result).isFalse();
    }


    @Test
    public void hasEnoughElementsToCovertToSpellShouldReturnFalseForNoSpell() {
        // when
        final boolean result = NoSpell.getInstance().hasEnoughElementsToCovertToSpell(elementsBuilder().build());

        // then
        assertThat(result).isFalse();
    }

    @Test
    public void getElementsShouldReturnNoElementsForNoSpell() {
        // when
        final Elements result = NoSpell.getInstance().getElements();

        // then
        assertThat(result).isEqualTo(noElements());
    }

    @Test
    public void castSpellShouldLogMessage() {
        // when
        NoSpell.getInstance().castSpell(UNUSED_UNIT, UNUSED_UNIT);

        // then assert logs
        verify(mockAppender).doAppend(captorLoggingEvent.capture());
        verify(mockAppender).doAppend(captorLoggingEvent.capture());
        final ILoggingEvent loggingEvent = captorLoggingEvent.getValue();
        assertThat(loggingEvent.getLevel()).isEqualTo(Level.WARN);
        assertThat(loggingEvent.getFormattedMessage()).isEqualTo("Nothing happen. (Bug? Casting spell for No Spell???)");
    }

    @Test
    public void setElementsShouldLogWarnMessage() {
        // when
        NoSpell.getInstance().setElements(elementsBuilder().build());

        // then assert logs
        verify(mockAppender).doAppend(captorLoggingEvent.capture());
        final ILoggingEvent loggingEvent = captorLoggingEvent.getValue();
        assertThat(loggingEvent.getLevel()).isEqualTo(Level.WARN);
        assertThat(loggingEvent.getFormattedMessage()).isEqualTo("Bug detected! Something trying to set elements on NoSpell.");
    }

}
