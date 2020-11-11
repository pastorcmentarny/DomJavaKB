package dms.pastor.prototypes.dcs.spells;

import dms.pastor.prototypes.dcs.conditions.Condition;
import dms.pastor.prototypes.dcs.conditions.ConditionEntryBuilder;
import dms.pastor.prototypes.dcs.units.Unit;
import org.junit.jupiter.api.Test;

import static dms.pastor.prototypes.dcs.conditions.ConditionType.POISONED;
import static dms.pastor.prototypes.dcs.conditions.ConditionType.POISON_IMMUNITY;
import static dms.pastor.prototypes.dcs.units.enemies.builders.UnitBuilder.unitBuilder;
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
    public void castSpellShouldPoisonUnit() {
        // given
        PoisonSpell poisonSpell = new PoisonSpell();
        Unit unit = unitBuilder().build();
        // when
        poisonSpell.castSpell(unit, unit);

        // then
        assertThat(unit.getConditions().has(POISONED)).isTrue();
    }

    @Test
    public void castSpellShouldNotPoisonUnitIfIsImmuneToPoison() {
        // given
        PoisonSpell poisonSpell = new PoisonSpell();
        Condition condition = new Condition();
        condition.add(ConditionEntryBuilder.conditionEntryBuilder()
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
