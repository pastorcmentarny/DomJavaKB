package dms.pastor.game.dcs.spells;

import dms.pastor.game.dcs.units.Unit;
import dms.pastor.game.dcs.units.UnitBuilder;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author Dominik Symonowicz
 * Created 03/06/2017
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
public class LightingBoltTest {


    @Test
    public void castLightBoltSpellShouldCauseDamageToUnit() throws Exception {
        // given
        LightingBolt lightingBolt = new LightingBolt();

        // when
        final Unit unit = UnitBuilder.unitBuilder()
                .withoutShield()
                .hp(10)
                .build();
        lightingBolt.castSpell(unit, unit);

        // then
        assertThat(unit.getHp()).isEqualTo(4);
    }
}