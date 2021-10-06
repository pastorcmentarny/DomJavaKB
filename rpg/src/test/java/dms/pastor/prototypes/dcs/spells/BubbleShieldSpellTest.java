package dms.pastor.prototypes.dcs.spells;

import dms.pastor.prototypes.dcs.units.Unit;
import org.junit.jupiter.api.Test;

import static dms.pastor.prototypes.dcs.conditions.ConditionType.BUBBLE_SHIELD;
import static dms.pastor.prototypes.dcs.units.enemies.builders.UnitBuilder.unitBuilder;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author Dominik Symonowicz
 * Created 04/08/2017
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class BubbleShieldSpellTest {

    @Test
    public void castBubbleShieldSpellShouldAddBBubbleShieldToPlayer() {
        // given
        final Spell bubbleShieldSpell = new BubbleShieldSpell();
        final Unit unit = unitBuilder()
                .build();
        // when
        bubbleShieldSpell.castSpell(unit, unit);

        // then
        assertThat(unit.getConditions().has(BUBBLE_SHIELD)).isTrue();
    }

}
