package dms.pastor.prototypes.dcs.utils;

import dms.pastor.utils.randoms.RandomDataGenerator;
import org.junit.jupiter.api.Test;

import static dms.pastor.prototypes.dcs.utils.UnitUtils.doubleDamageFor;
import static org.assertj.core.api.Assertions.assertThat;

public class UnitUtilsTest {

    @Test
    public void doubleDamageShouldMultiplyBy2() {
        // given
        final int dmg = 3;
        // when
        final int result = doubleDamageFor(dmg);

        // then
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void doubleDamageShouldReturnZeroForNegativeDamage() {
        // given
        final int dmg = RandomDataGenerator.randomNegativeInteger();
        // when
        final int result = doubleDamageFor(dmg);

        // then
        assertThat(result).isZero();
    }


}