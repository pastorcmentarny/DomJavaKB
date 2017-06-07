package dms.pastor.game.dcs.conditions;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;

import static dms.pastor.game.dcs.Config.DEFAULT_CONDITION_DURATION;
import static dms.pastor.game.dcs.conditions.ConditionEntryBuilder.conditionEntryBuilder;
import static dms.pastor.game.dcs.conditions.ConditionType.*;
import static dms.pastor.game.dcs.conditions.ElementType.AIR;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author Dominik Symonowicz
 * Created 2015-07-27
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
public class ConditionTest {
    private Condition conditions;

    @Before
    public void setUp() throws Exception {
        conditions = new Condition();
    }

    @After
    public void tearDown() throws Exception {
        conditions.getConditions().clear();
    }

    @Test
    public void addShouldAddNewConditionWithSpecifiedTurnLeft() throws Exception {
        // given
        final ConditionEntry conditionEntry = conditionEntryBuilder()
                .condition(STUNNED)
                .turnsLeft(2)
                .build();

        // when
        conditions.add(conditionEntry.getConditionType(), conditionEntry.getTurnsLeft());

        // then
        assertThat(conditions.getConditions()).contains(conditionEntry);
        assertThat(conditions.getConditions()).hasSize(1);
    }

    @Test
    public void addWithoutSpecifiedTurnsShouldAddNewConditionWithDefaultTurnLeft() throws Exception {
        // given
        final ConditionEntry conditionEntry = conditionEntryBuilder()
                .condition(STUNNED)
                .turnsLeft(DEFAULT_CONDITION_DURATION)
                .build();

        // when
        conditions.add(conditionEntry.getConditionType());

        // then
        final HashSet<ConditionEntry> allConditions = this.conditions.getConditions();
        assertThat(allConditions).contains(conditionEntry);
        assertThat(allConditions.
                stream()
                .map(thisCondition -> thisCondition.equals(new ConditionEntry(STUNNED, DEFAULT_CONDITION_DURATION)))
                .findFirst()
                .orElse(false)
        ).isTrue();
        assertThat(allConditions).hasSize(1);
    }

    @Test
    public void addShouldAddNotConditionIfExistButShouldUpdateTurnLeft() throws Exception {
        // given
        final ConditionEntry originalConditionEntry = conditionEntryBuilder()
                .condition(STUNNED)
                .turnsLeft(2)
                .build();
        final ConditionEntry newConditionEntry = conditionEntryBuilder()
                .condition(STUNNED)
                .turnsLeft(3)
                .build();

        // when
        conditions.add(originalConditionEntry.getConditionType(), originalConditionEntry.getTurnsLeft());
        conditions.add(newConditionEntry.getConditionType(), newConditionEntry.getTurnsLeft());

        // then
        assertThat(conditions.getConditions()).contains(newConditionEntry);
        assertThat(conditions.getConditions()).hasSize(1);
    }

    @Test
    public void removeShouldRemoveConditionFromConditions() throws Exception {
        // given
        final ConditionEntry condition = conditionEntryBuilder()
                .condition(POISONED)
                .build();
        final ConditionEntry conditionThatWillBeDeleted = conditionEntryBuilder()
                .condition(STUNNED)
                .build();
        conditions.add(condition.getConditionType(), condition.getTurnsLeft());
        conditions.add(conditionThatWillBeDeleted.getConditionType(), conditionThatWillBeDeleted.getTurnsLeft());

        // when
        conditions.removeByConditionName(conditionThatWillBeDeleted.getConditionType());

        // then
        assertThat(conditions.getConditions()).hasSize(1);
        assertThat(conditions.getConditions()).contains(condition);
        assertThat(conditions.getConditions()).doesNotContain(conditionThatWillBeDeleted);
    }

    @Test
    public void removeShouldNotRemoveAnythingFromListFromConditions() throws Exception {
        // given
        final ConditionEntry condition = conditionEntryBuilder()
                .condition(POISONED)
                .build();
        final ConditionEntry conditionTwo = conditionEntryBuilder()
                .condition(STUNNED)
                .build();
        final ConditionEntry nonExistingCondition = conditionEntryBuilder()
                .condition(AIR_IMMUNE)
                .build();

        conditions.add(condition.getConditionType(), condition.getTurnsLeft());
        conditions.add(conditionTwo.getConditionType(), conditionTwo.getTurnsLeft());

        // when
        conditions.removeByConditionName(nonExistingCondition.getConditionType());

        // then
        assertThat(conditions.getConditions()).hasSize(2);
        assertThat(conditions.getConditions()).contains(condition);
        assertThat(conditions.getConditions()).contains(conditionTwo);
    }


    @Test
    public void hasShouldReturnTrueConditionIsOnList() throws Exception {
        // given
        final ConditionEntry conditionEntry = conditionEntryBuilder()
                .condition(STUNNED)
                .build();
        conditions.add(conditionEntry.getConditionType(), conditionEntry.getTurnsLeft());

        // when
        final boolean result = conditions.has(conditionEntry.getConditionType());
        // then
        assertThat(result).isTrue();
    }

    @Test
    public void hasShouldReturnFalseConditionIsNotOnList() throws Exception {
        // given
        final ConditionEntry conditionEntry = conditionEntryBuilder()
                .condition(STUNNED)
                .build();
        conditions.add(conditionEntry.getConditionType(), conditionEntry.getTurnsLeft());

        // when
        final boolean result = conditions.has(POISONED);
        // then
        assertThat(result).isFalse();
    }

    @Test
    public void hasNotShouldReturnFalseConditionIsOnList() throws Exception {
        // given
        final ConditionEntry conditionEntry = conditionEntryBuilder()
                .condition(STUNNED)
                .build();
        conditions.add(conditionEntry.getConditionType(), conditionEntry.getTurnsLeft());

        // when
        final boolean result = conditions.hasNot(conditionEntry.getConditionType());

        // then
        assertThat(result).isFalse();
    }

    @Test
    public void hasNotShouldReturnTrueConditionIsNotOnList() throws Exception {
        // given
        final ConditionEntry conditionEntry = conditionEntryBuilder()
                .condition(STUNNED)
                .build();
        conditions.add(conditionEntry.getConditionType(), conditionEntry.getTurnsLeft());

        // when
        final boolean result = conditions.hasNot(POISONED);

        // then
        assertThat(result).isTrue();
    }

    @Test
    public void reduceByOneTurnShouldReduceConditionByOneTurn() throws Exception {
        // given
        ConditionType type = STUNNED;
        int turns = 2;
        conditions.add(type, turns);
        assertThat(conditions.getConditionEntry(type).getTurnsLeft() == 2).isTrue();

        // when
        conditions.reduceByOneTurn();

        // then
        assertThat(conditions.getConditionEntry(type).getTurnsLeft() == 1).isTrue();
    }

    @Test
    public void getConditionEntryShouldReturnConditionForGivenType() throws Exception {
        // given
        final ConditionEntry condition = conditionEntryBuilder()
                .condition(POISONED)
                .turnsLeft(2)
                .build();
        conditions.add(condition.getConditionType(), condition.getTurnsLeft());

        // when
        final ConditionEntry conditionEntryResult = conditions.getConditionEntry(POISONED);

        // then
        assertThat(conditionEntryResult).isEqualTo(condition);

    }

    @Test
    public void removeAllShouldClearAllConditions() throws Exception {
        // given
        final ConditionEntry condition = conditionEntryBuilder()
                .condition(POISONED)
                .build();
        final ConditionEntry conditionTwo = conditionEntryBuilder()
                .condition(STUNNED)
                .build();
        final ConditionEntry conditionThree = conditionEntryBuilder()
                .condition(AIR_IMMUNE)
                .build();

        conditions.add(condition.getConditionType(), condition.getTurnsLeft());
        conditions.add(conditionTwo.getConditionType(), conditionTwo.getTurnsLeft());
        conditions.add(conditionThree.getConditionType(), conditionThree.getTurnsLeft());

        // when
        conditions.removeAll();

        // then
        assertThat(conditions.getConditions()).isEmpty();
    }

    @Test
    public void isImmuneReturnsTrueIfHasAirImmuneToAir() throws Exception {
        // given
        conditions.add(AIR_IMMUNE, 1);

        // when
        final boolean result = conditions.isImmuneTo(ElementType.AIR);

        // then
        assertThat(result).isTrue();
    }

    @Test
    public void isImmuneReturnsTrueIfHasEarthImmuneToEarth() throws Exception {
        // given
        conditions.add(EARTH_IMMUNE, 1);

        // when
        final boolean result = conditions.isImmuneTo(ElementType.EARTH);

        // then
        assertThat(result).isTrue();
    }

    @Test
    public void isImmuneReturnsTrueIfHasFireImmuneToFire() throws Exception {
        // given
        conditions.add(FIRE_IMMUNE, 1);

        // when
        final boolean result = conditions.isImmuneTo(ElementType.FIRE);

        // then
        assertThat(result).isTrue();
    }

    @Test
    public void isImmuneReturnsTrueIfHasWaterImmuneToWater() throws Exception {
        // given
        conditions.add(WATER_IMMUNE, 1);

        // when
        final boolean result = conditions.isImmuneTo(ElementType.WATER);

        // then
        assertThat(result).isTrue();
    }

    @Test
    public void isImmuneReturnsTrueIfHasNotAirImmuneToAir() throws Exception {
        // given
        conditions.add(FIRE_IMMUNE, 1);

        // when
        final boolean result = conditions.isImmuneTo(AIR);

        // then
        assertThat(result).isFalse();
    }

    @Test
    public void isNotImmuneReturnsFalseIfHasAirImmuneToAir() throws Exception {
        // given
        conditions.add(AIR_IMMUNE, 1);

        // when
        final boolean result = conditions.isNotImmuneTo(ElementType.AIR);

        // then
        assertThat(result).isFalse();
    }

    @Test
    public void isNotImmuneReturnsTrueIfHasNotAirImmuneToAir() throws Exception {
        // given
        conditions.add(FIRE_IMMUNE, 1);

        // when
        final boolean result = conditions.isNotImmuneTo(AIR);

        // then
        assertThat(result).isTrue();
    }

    @Test
    public void sizeShouldReturn2For2Conditions() {
        // given
        conditions.add(FIRE_SENSITIVE);
        conditions.add(AIR_SENSITIVE);
        // when
        final int size = conditions.size();

        // then
        assertThat(size).isEqualTo(2);

    }
}