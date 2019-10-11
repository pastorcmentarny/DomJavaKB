package dms.pastor.prototype.dcs.actions;

import dms.pastor.prototype.dcs.conditions.Condition;
import dms.pastor.prototype.dcs.spells.CureSpell;
import dms.pastor.prototype.dcs.units.Unit;
import org.junit.Test;

import static dms.pastor.prototype.dcs.conditions.ConditionEntry.createTemporaryConditionWithDefaultDuration;
import static dms.pastor.prototype.dcs.conditions.ConditionType.BLIND;
import static dms.pastor.prototype.dcs.units.enemies.builders.UnitBuilder.unitBuilder;
import static org.assertj.core.api.Assertions.assertThat;

public final class CureActionTest {

    @Test
    public void performShouldCastCureSpellOnUnitItself() {
        // given
        Action cureAction = new CureAction();

        Condition condition = new Condition();
        condition.add(createTemporaryConditionWithDefaultDuration(BLIND));
        final Unit unit = unitBuilder()
            .condition(condition)
            .elements(new CureSpell().getElements())
            .build();

        // when
        cureAction.perform(unit, unit);

        // then
        assertThat(unit.getConditions().getConditions().isEmpty()).isTrue();

    }
}