package dms.pastor.game.dcs.spells;

import dms.pastor.game.dcs.units.Unit;
import org.junit.Test;

import static dms.pastor.game.dcs.conditions.ConditionType.BLOODLUST;
import static dms.pastor.game.dcs.units.UnitBuilder.unitBuilder;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author Dominik Symonowicz
 * Created 28/05/2017
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
public class BloodlustTest {

    private static final Unit UNUSED_UNIT = null;

    @Test
    public void castBloodlustShouldAddBloodlustToPlayer() throws Exception {
        // given
        final Bloodlust bloodlust = new Bloodlust();
        final Unit unit = unitBuilder()
                .build();

        // when
        bloodlust.castSpell(unit, UNUSED_UNIT);


        // then
        assertThat(unit.getConditions().has(BLOODLUST)).isTrue();
    }
}