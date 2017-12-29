package dms.pastor.game.dcs.events;

import dms.pastor.game.dcs.conditions.Condition;
import dms.pastor.game.dcs.conditions.ConditionEntry;
import dms.pastor.game.dcs.units.Unit;
import org.junit.Test;

import static dms.pastor.game.dcs.ElementsBuilder.elementsBuilder;
import static dms.pastor.game.dcs.conditions.ConditionEntryBuilder.conditionEntryBuilder;
import static dms.pastor.game.dcs.conditions.ConditionType.FROZEN;
import static dms.pastor.game.dcs.conditions.ConditionType.WATER_SENSITIVE;
import static dms.pastor.game.dcs.units.enemies.builders.UnitBuilder.unitBuilder;
import static org.assertj.core.api.Assertions.assertThat;

public final class WaterElementEventTest {

    @Test
    public void addElementOrFrozeShouldFrozeUnitIfCanHaveEventReturnFalse() {
        // given
        WaterElementEvent waterElementEvent = new WaterElementEvent();
        final ConditionEntry conditionEntry = conditionEntryBuilder()
                .condition(WATER_SENSITIVE)
                .build();
        Condition condition = new Condition();
        condition.add(conditionEntry);
        final Unit unit = unitBuilder()
                .condition(condition)
                .build();

        // when
        final String result = waterElementEvent.makeItHappen(unit, unit);
        System.out.println(result);

        // then
        assertThat(unit.getConditions().has(FROZEN)).isTrue();
    }

    @Test
    public void addElementOrFrozeShouldAddWaterIfUnitDoNotHaveWaterSensitive() {
        // given
        WaterElementEvent waterElementEvent = new WaterElementEvent();
        final Unit unit = unitBuilder()
                .elements(elementsBuilder()
                        .setToOneForAllElements()
                        .build())
                .build();

        // when
        final String result = waterElementEvent.makeItHappen(unit, unit);
        System.out.println(result);

        // then
        assertThat(unit.getElements().getWater()).isGreaterThan(1);
    }
}
