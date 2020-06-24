package dms.pastor.prototypes.dcs.units;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.Appender;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.slf4j.LoggerFactory;

import static dms.pastor.prototypes.dcs.units.HealthBuilder.healthBuilder;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class HealthBuilderTest {

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
    public void buildShouldGenerateHealthWithCustomerValue() {

        // given
        final int maxHp = 5;
        final int hp = 4;
        final int arm = 1;
        final int hpRegenRate = 3;

        final Health expectedHealth = new Health();
        expectedHealth.setHp(hp);
        expectedHealth.setMaxHp(maxHp);
        expectedHealth.setArm(arm);
        expectedHealth.setHpRegenRate(hpRegenRate);

        // when
        final Health result = healthBuilder()
            .hp(hp)
            .maxHp(maxHp)
            .arm(arm)
            .hpRegenRate(hpRegenRate)
            .build();

        // then
        assertThat(result).isEqualTo(expectedHealth);
    }

    @Test
    public void hpMethodShouldDisplayWarningInLogIfHpValueIsHigherThanMaxValue() {
        // given
        final int hp = 5;
        final int tooLowMaxHp = 4;

        // when
        final Health result = healthBuilder()
            .maxHp(tooLowMaxHp)
            .hp(hp)
            .build();

        // then
        assertThat(result.getMaxHp()).isEqualTo(hp);
        assertThat(result.getMaxHp()).isNotEqualTo(tooLowMaxHp);

        verify(mockAppender).doAppend(captorLoggingEvent.capture());
        final ILoggingEvent loggingEvent = captorLoggingEvent.getValue();
        assertThat(loggingEvent.getLevel()).isEqualTo(Level.WARN);
        assertThat(loggingEvent.getFormattedMessage()).isEqualTo("Overriding maxHp because hp " + hp + " is higher than maxHp " + tooLowMaxHp + ".");

    }
}