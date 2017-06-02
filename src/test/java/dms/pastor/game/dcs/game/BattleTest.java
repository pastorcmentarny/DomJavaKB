package dms.pastor.game.dcs.game;

import dms.pastor.game.dcs.conditions.Condition;
import dms.pastor.game.dcs.conditions.ConditionEntry;
import dms.pastor.game.dcs.conditions.ConditionEntryBuilder;
import dms.pastor.game.dcs.conditions.ConditionType;
import dms.pastor.game.dcs.units.Unit;
import org.junit.Test;

import static dms.pastor.game.dcs.units.UnitBuilder.unitBuilder;
import static org.assertj.core.api.Assertions.assertThat;

public final class BattleTest {

    @Test
    public void isInFightShouldReturnFalseIfBothUnitsAreDeath() {
        // given
        final Unit deathUnit = unitBuilder().buildDeathUnit();
        Battle battle = new Battle(deathUnit, deathUnit);

        // when
        final boolean result = battle.isInFight();

        // then
        assertThat(result).isFalse();
    }

    @Test
    public void isInFightShouldReturnFalseIfAnyUnitsAreDeath() {
        // given
        final Unit deathUnit = unitBuilder().buildDeathUnit();
        final Unit aliveUnit = unitBuilder()
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
                .condition(ConditionType.POISONED)
                .build();
        final ConditionEntry regenerationCondition = ConditionEntryBuilder.conditionEntryBuilder()
                .condition(ConditionType.REGENERATION)
                .build();
        final ConditionEntry stunnedCondtion = ConditionEntryBuilder.conditionEntryBuilder()
                .condition(ConditionType.STUNNED)
                .turnsLeft(1)
                .build();
        Condition condition = new Condition();
        condition.add(poisonCondition);
        condition.add(regenerationCondition);
        condition.add(stunnedCondtion);

        final Unit aliveUnit = unitBuilder()
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