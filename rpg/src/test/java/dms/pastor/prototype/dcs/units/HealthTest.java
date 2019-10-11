package dms.pastor.prototype.dcs.units;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HealthTest {

    @Test
    public void getDefaultHealthShouldReturnWithSameHealthAndMaxHealth() {

        // given
        final int health = 10;

        // when
        final Health result = Health.getDefaultHealth(health);

        // then
        assertThat(result.getHp()).isEqualTo(health);
        assertThat(result.getMaxHp()).isEqualTo(health);
        assertThat(result.getArm()).isZero();
        assertThat(result.getHpRegenRate()).isOne();
    }
}