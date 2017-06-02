package dms.pastor.game.dcs;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public final class ConfigTest {

    @Test
    public void getRandomShieldRegenerationShouldReturnRandomValue() {
        // when
        final int randomShieldRegenerationRate = Config.getRandomShieldRegenerationRate();

        // then
        assertThat(randomShieldRegenerationRate).isBetween(0, 5);
    }
}
