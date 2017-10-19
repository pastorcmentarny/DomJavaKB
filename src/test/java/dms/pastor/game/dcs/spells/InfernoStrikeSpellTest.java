package dms.pastor.game.dcs.spells;

import dms.pastor.game.dcs.units.Unit;
import dms.pastor.game.dcs.units.UnitBuilder;
import org.junit.Test;

import static dms.pastor.utils.randoms.RandomDataGenerator.MAX_SMALL_VALUE_RANGE;
import static dms.pastor.utils.randoms.RandomDataGenerator.generateString;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author Dominik Symonowicz
 * Created 12/06/2017
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class InfernoStrikeSpellTest {

    private final InfernoStrikeSpell infernoStrikeSpell = new InfernoStrikeSpell();

    @Test
    public void castInfernoStrikeShouldDoesDamage() throws Exception {
        // given
        final int initHp = 100;
        final Unit unit = UnitBuilder.unitBuilder()
                .name(generateString(MAX_SMALL_VALUE_RANGE))
                .hp(initHp)
                .build();
        // when
        infernoStrikeSpell.castSpell(unit, unit);

        // then
        assertThat(unit.getHp()).isLessThan(initHp);
    }

    @Test
    public void castInfernoStrikeShouldHitBothUnits() throws Exception {
        // given
        final int initHp = 200;
        final UnitBuilder unitBuilder = UnitBuilder.unitBuilder()
                .name(generateString(MAX_SMALL_VALUE_RANGE))
                .hp(initHp);
        final Unit unit1 = unitBuilder.name("One").build();
        final Unit unit2 = unitBuilder.name("Two").build();
        boolean isUnitOneHit = false;
        boolean isUnitTwoHit = false;

        // when
        for (int i = 0; i < 10; i++) {
            infernoStrikeSpell.castSpell(unit1, unit2);
            if (unit1.getHp() < initHp) {
                isUnitOneHit = true;
            }
            if (unit2.getHp() < initHp) {
                isUnitTwoHit = true;
            }

            if (isUnitOneHit && isUnitTwoHit) {
                break;
            }
        }

        // then
        assertThat(isUnitOneHit).isTrue();
        assertThat(isUnitTwoHit).isTrue();
    }
}
