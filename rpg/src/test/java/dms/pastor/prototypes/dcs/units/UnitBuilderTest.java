package dms.pastor.prototypes.dcs.units;

import dms.pastor.prototypes.dcs.Config;
import dms.pastor.prototypes.dcs.units.enemies.builders.UnitBuilder;
import org.junit.jupiter.api.Test;

import static dms.pastor.utils.randoms.RandomDataGenerator.randomNegativeInteger;
import static dms.pastor.utils.randoms.RandomDataGenerator.randomPositiveInteger;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author Dominik Symonowicz
 * Created 28/05/2017
 * WWW:	<a href="https://dominiksymonowicz.com/">HOME PAGE</a>
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class UnitBuilderTest {

    @Test
    public void buildShouldReturnUnitWithoutShieldIfLastModificationWasWithoutShield() {
        // when
        final Unit unit = UnitBuilder.unitBuilder()
                .sp(10)
                .withoutShield()
                .build();

        // then
        assertThat(unit.isShielded()).isFalse();
        assertThat(unit.getSp()).isZero();
    }

    @Test
    public void buildShouldReturnUnitShieldedIfLastStepIsShieldedIsSetToTrue() {
        // when
        final Unit unit = UnitBuilder.unitBuilder()
                .sp(randomNegativeInteger())
                .shielded()
                .build();

        // then
        assertThat(unit.isShielded()).isTrue();
        assertThat(unit.getSp()).isEqualTo(Config.INITIAL_SHIELD_POINTS);
    }

    @Test
    public void buildShouldReturnUnitWithoutShieldIfSpIsEqualOrLessZeroEvenShieldedIsSetToTrue() {
        // when
        final Unit unit = UnitBuilder.unitBuilder()
                .sp(randomPositiveInteger())
                .withoutShield()
                .build();

        // then
        assertThat(unit.isShielded()).isFalse();
        assertThat(unit.getSp()).isZero();
    }

}