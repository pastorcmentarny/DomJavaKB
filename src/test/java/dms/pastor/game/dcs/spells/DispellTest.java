package dms.pastor.game.dcs.spells;

import dms.pastor.game.dcs.conditions.Condition;
import dms.pastor.game.dcs.conditions.ConditionEntry;
import dms.pastor.game.dcs.units.Unit;
import org.junit.Test;

import static dms.pastor.game.dcs.conditions.ConditionEntryBuilder.conditionEntryBuilder;
import static dms.pastor.game.dcs.conditions.ConditionType.EARTH_IMMUNE;
import static dms.pastor.game.dcs.conditions.ConditionType.EARTH_RESISTANT;
import static dms.pastor.game.dcs.units.UnitBuilder.unitBuilder;
import static org.assertj.core.api.Assertions.assertThat;

public final class DispellTest {

    @Test
    public void castDispellShouldRemoveAllConditionOnUnit() {
        // given
        final Dispell dispell = new Dispell();
        final ConditionEntry conditionEntry1 = conditionEntryBuilder().condition(EARTH_IMMUNE).build();
        final ConditionEntry conditionEntry2 = conditionEntryBuilder().condition(EARTH_RESISTANT).build();
        Condition condition = new Condition();
        condition.add(conditionEntry1);
        condition.add(conditionEntry2);
        final Unit unit = unitBuilder()
                .condition(condition)
                .build();

        assertThat(unit.getConditions().size()).isEqualTo(2);

        // when
        dispell.castSpell(unit, unit);

        // then
        assertThat(unit.getConditions().size()).isZero();
    }
}