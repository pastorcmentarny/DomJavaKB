package dms.pastor.prototypes.dcs.game;

import dms.pastor.prototypes.dcs.conditions.Condition;
import dms.pastor.prototypes.dcs.conditions.ConditionEntry;
import dms.pastor.prototypes.dcs.conditions.ConditionEntryBuilder;
import dms.pastor.prototypes.dcs.units.Unit;
import dms.pastor.prototypes.dcs.units.enemies.builders.UnitBuilder;
import org.junit.jupiter.api.Test;

import static dms.pastor.prototypes.dcs.conditions.ConditionType.*;
import static org.assertj.core.api.Assertions.assertThat;

public final class BattleTest {

    @Test
    public void isInFightShouldReturnFalseIfBothUnitsAreDeath() {
        // given
        final Unit deathUnit = UnitBuilder.unitBuilder().buildDeathUnit();
        Battle battle = new Battle(deathUnit, deathUnit);
        // when
        final boolean result = battle.isInFight();

        // then
        assertThat(result).isFalse();
    }

    @Test
    public void isInFightShouldReturnFalseIfAnyUnitsAreDeath() {
        // given
        final Unit deathUnit = UnitBuilder.unitBuilder().buildDeathUnit();
        final Unit aliveUnit = UnitBuilder.unitBuilder()
                .name("Alive")
                .build();

        Battle battle = new Battle(aliveUnit, deathUnit);
        // when
        final boolean result = battle.isInFight();

        // then
        assertThat(result).isFalse();
    }

    @Test
    public void isInFightShouldReturnFalseIfAllUnitsAreAlive() {
        // given
        final ConditionEntry poisonCondition = ConditionEntryBuilder.conditionEntryBuilder()
                .condition(POISONED)
                .build();
        final ConditionEntry regenerationCondition = ConditionEntryBuilder.conditionEntryBuilder()
                .condition(REGENERATION)
                .build();
        final ConditionEntry stunnedCondition = ConditionEntryBuilder.conditionEntryBuilder()
                .condition(STUNNED)
                .turnsLeft(1)
                .build();
        Condition condition = new Condition();
        condition.add(poisonCondition);
        condition.add(regenerationCondition);
        condition.add(stunnedCondition);

        final Unit aliveUnit = UnitBuilder.unitBuilder()
                .condition(condition)
                .name("Alive")
                .build();

        Battle battle = new Battle(aliveUnit, aliveUnit);
        // when
        final boolean result = battle.isInFight();

        // then
        assertThat(result).isFalse();
    }
}
