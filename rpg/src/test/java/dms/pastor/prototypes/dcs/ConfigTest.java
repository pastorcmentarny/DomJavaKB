package dms.pastor.prototypes.dcs;

import org.junit.jupiter.api.Test;

import static dms.pastor.prototypes.dcs.Config.getRandomShieldRegenerationRate;
import static org.assertj.core.api.Assertions.assertThat;

public final class ConfigTest {

    @Test
    public void getRandomShieldRegenerationShouldReturnRandomValue() {
        // when
        final int randomShieldRegenerationRate = getRandomShieldRegenerationRate();

        // then
        assertThat(randomShieldRegenerationRate).isBetween(0, 5);
    }
}
