package dms.pastor.game.dcs.spells;

import dms.pastor.game.dcs.units.Unit;
import org.junit.Test;

import static dms.pastor.game.dcs.conditions.ConditionType.BUBBLE_SHIELD;
import static dms.pastor.game.dcs.units.UnitBuilder.unitBuilder;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author Dominik Symonowicz
 * Created 04/08/2017
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class BubbleShieldSpellTest {

    @Test
    public void castBubbleShieldSpellShouldAddBBubbleShieldToPlayer() throws Exception {
        // given
        final BubbleShieldSpell bubbleShieldSpell = new BubbleShieldSpell();
        final Unit unit = unitBuilder()
                .build();

        // when
        bubbleShieldSpell.castSpell(unit, unit);

        // then
        assertThat(unit.getConditions().has(BUBBLE_SHIELD)).isTrue();
    }

}
