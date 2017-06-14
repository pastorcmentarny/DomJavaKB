package dms.pastor.game.dcs.spells;

import dms.pastor.game.dcs.conditions.Condition;
import dms.pastor.game.dcs.units.Unit;
import org.junit.Test;

import static dms.pastor.game.dcs.conditions.ConditionEntryBuilder.conditionEntryBuilder;
import static dms.pastor.game.dcs.conditions.ConditionType.POISONED;
import static dms.pastor.game.dcs.conditions.ConditionType.POISON_IMMUNITY;
import static dms.pastor.game.dcs.units.UnitBuilder.unitBuilder;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author Dominik Symonowicz
 * Created 11/06/2017
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class PoisonSpellTest {

    @Test
    public void castSpellShouldPoisonUnit() throws Exception {
        // given
        PoisonSpell poisonSpell = new PoisonSpell();
        Unit unit = unitBuilder().build();

        // when
        poisonSpell.castSpell(unit, unit);

        // then
        assertThat(unit.getConditions().has(POISONED)).isTrue();
    }


    @Test
    public void castSpellShouldNotPoisonUnitIfIsImmuneToPoison() throws Exception {
        // given
        PoisonSpell poisonSpell = new PoisonSpell();
        Condition condition = new Condition();
        condition.add(conditionEntryBuilder()
                .condition(POISON_IMMUNITY)
                .build());

        Unit unit = unitBuilder()
                .condition(condition)
                .build();

        // when
        poisonSpell.castSpell(unit, unit);

        // then
        assertThat(unit.getConditions().has(POISONED)).isFalse();
    }

}
