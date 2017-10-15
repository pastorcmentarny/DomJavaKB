package dms.pastor.game.dcs;

import org.junit.Test;

import static dms.pastor.game.dcs.Config.getRandomShieldRegenerationRate;
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
