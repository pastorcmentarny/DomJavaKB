package dms.pastor.prototypes.dcs.spells;

import dms.pastor.prototypes.dcs.conditions.Condition;
import dms.pastor.prototypes.dcs.conditions.ConditionEntry;
import dms.pastor.prototypes.dcs.units.Unit;
import org.junit.jupiter.api.Test;

import static dms.pastor.prototypes.dcs.conditions.ConditionType.*;
import static dms.pastor.prototypes.dcs.units.enemies.builders.UnitBuilder.unitBuilder;
import static org.assertj.core.api.Assertions.assertThat;

public final class DispellTest {

    @Test
    public void castDispellShouldRemoveAllConditionOnUnit() {
        // given
        final Dispell dispell = new Dispell();
        final ConditionEntry conditionEntry1 = ConditionEntry.createTemporaryCondition(EARTH_IMMUNE, 3);
        final ConditionEntry conditionEntry2 = ConditionEntry.createTemporaryConditionWithDefaultDuration(FIRE_IMMUNE);
        final ConditionEntry conditionEntry3 = ConditionEntry.createPersistentCondition(AIR_IMMUNE);

        Condition condition = new Condition();
        condition.add(conditionEntry1);
        condition.add(conditionEntry2);
        condition.add(conditionEntry3);
        final Unit unit = unitBuilder()
                .condition(condition)
                .build();

        assertThat(unit.getConditions().size()).isEqualTo(3);
        // when
        dispell.castSpell(unit, unit);

        // then
        assertThat(unit.getConditions().size()).isEqualTo(1);
    }
}