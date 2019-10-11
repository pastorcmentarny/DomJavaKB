package dms.pastor.prototype.dcs.spells;

import dms.pastor.prototype.dcs.units.Unit;
import dms.pastor.prototype.dcs.units.enemies.builders.UnitBuilder;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author Dominik Symonowicz
 * Created 03/06/2017
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class LightingBoltSpellTest {

    @Test
    public void castLightBoltSpellShouldCauseDamageToUnit() {
        // given
        LightingBoltSpell lightingBoltSpell = new LightingBoltSpell();

        // when
        final Unit unit = UnitBuilder.unitBuilder()
            .withoutShield()
            .hp(10)
            .build();
        lightingBoltSpell.castSpell(unit, unit);

        // then
        assertThat(unit.getHp()).isEqualTo(4);
    }
}