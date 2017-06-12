package dms.pastor.game.dcs.spells;

import dms.pastor.game.dcs.units.Unit;
import dms.pastor.game.dcs.units.UnitBuilder;
import org.junit.Test;

import static dms.pastor.utils.randoms.RandomDataGenerator.MAX_SMALL_VALUE;
import static dms.pastor.utils.randoms.RandomDataGenerator.generateString;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author Dominik Symonowicz
 * Created 12/06/2017
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
public class InfernoStrikeTest {
    private InfernoStrike infernoStrike = new InfernoStrike();

    @Test
    public void castInfernoStrikeShouldDoesDamage() throws Exception {
        // given
        final int initHp = 100;
        final Unit unit = UnitBuilder.unitBuilder()
                .name(generateString(MAX_SMALL_VALUE))
                .hp(initHp)
                .build();
        // when
        infernoStrike.castSpell(unit, unit);

        // then
        assertThat(unit.getHp()).isLessThan(initHp);
    }

    @Test
    public void castInfernoStrikeShouldHitBothUnits() throws Exception {
        // given
        final int initHp = 200;
        final UnitBuilder unitBuilder = UnitBuilder.unitBuilder()
                .name(generateString(MAX_SMALL_VALUE))
                .hp(initHp);
        final Unit unit1 = unitBuilder.name("One").build();
        final Unit unit2 = unitBuilder.name("Two").build();
        boolean isUnitOneHit = false;
        boolean isUnitTwoHit = false;

        // when
        for (int i = 0; i < 10; i++) {
            infernoStrike.castSpell(unit1, unit2);
            if (unit1.getHp() < 200) {
                isUnitOneHit = true;
            }
            if (unit2.getHp() < 200) {
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