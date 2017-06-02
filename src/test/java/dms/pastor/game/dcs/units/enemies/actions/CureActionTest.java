package dms.pastor.game.dcs.units.enemies.actions;

import dms.pastor.game.dcs.conditions.Condition;
import dms.pastor.game.dcs.spells.CureSpell;
import dms.pastor.game.dcs.units.Unit;
import org.junit.Test;

import static dms.pastor.game.dcs.conditions.ConditionType.BLIND;
import static dms.pastor.game.dcs.units.UnitBuilder.unitBuilder;
import static org.assertj.core.api.Assertions.assertThat;

public final class CureActionTest {

    @Test
    public void performShouldCastCureSpellOnUnitItself() {
        // given
        CureAction cureAction = new CureAction();

        Condition condition = new Condition();
        condition.add(BLIND);
        final Unit unit = unitBuilder()
                .condition(condition)
                .elements(new CureSpell().getElements())
                .build();

        // when
        cureAction.perform(unit, unit);

        // then
        assertThat(unit.getCondition().getConditions().isEmpty()).isTrue();

    }
}