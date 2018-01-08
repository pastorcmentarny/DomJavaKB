package dms.pastor.game.dcs.conditions;

import dms.pastor.domain.exception.SomethingWentWrongException;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Set;

import static dms.pastor.game.dcs.Config.DEFAULT_CONDITION_DURATION;
import static dms.pastor.game.dcs.Config.INFINITIVE_TURNS_LEFT;
import static dms.pastor.game.dcs.conditions.Condition.createCondition;
import static dms.pastor.game.dcs.conditions.ConditionEntry.*;
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
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class ConditionTest {

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    private final ConditionEntry temporaryConditionEntry = conditionEntryBuilder()
            .condition(STUNNED)
            .buildTemporaryCondition();
    private final ConditionEntry persistentCondition = createPersistentCondition(STUNNED);
    private Condition conditions;

    @Before
    public void setUp() throws Exception {
        conditions = new Condition();
    }

    @After
    public void tearDown() throws Exception {
        conditions.clear();
    }

    @Test
    public void addShouldThrowSomethingWentWrongExceptionIfConditionEntryIsNull() {
        // expect
        exception.expect(SomethingWentWrongException.class);

        // when
        conditions.add(null);
    }

    @Test
    public void addShouldAddNewConditionWithSpecifiedTurnLeft() throws Exception {
        // given
        final ConditionEntry conditionEntry = conditionEntryBuilder()
                .condition(STUNNED)
                .turnsLeft(2)
                .build();

        // when
        conditions.add(conditionEntry);

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
                .nonPersistent()
                .build();

        // when
        conditions.add(conditionEntry);

        // then
        final Set<ConditionEntry> allConditions = this.conditions.getConditions();
        assertThat(allConditions).contains(conditionEntry);
        assertThat(allConditions.
                stream()
                .map(thisCondition -> thisCondition.equals(createTemporaryCondition(STUNNED, DEFAULT_CONDITION_DURATION)))
                .findFirst()
                .orElse(false)
        ).isTrue();
        assertThat(allConditions).hasSize(1);
    }

    @Test
    public void addShouldAddNotConditionIfExistButShouldUpdateTurnLeft() throws Exception {
        // given
        final ConditionEntry originalConditionEntry = createTemporaryCondition(STUNNED, 2);
        final ConditionEntry newConditionEntry = createTemporaryCondition(STUNNED, 3);

        // when
        conditions.add(originalConditionEntry);
        conditions.add(newConditionEntry);

        // then
        assertThat(conditions.getConditions()).contains(newConditionEntry);
        assertThat(conditions.getConditions()).hasSize(1);
    }

    @Test
    public void removeShouldRemoveConditionFromConditions() throws Exception {
        // given
        final ConditionEntry condition = createTemporaryConditionWithDefaultDuration(POISONED);
        final ConditionEntry conditionThatWillBeDeleted = createTemporaryConditionWithDefaultDuration(STUNNED);

        conditions.add(condition);
        conditions.add(conditionThatWillBeDeleted);

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

        conditions.add(condition);
        conditions.add(conditionTwo);

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
        conditions.add(conditionEntry);

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
        conditions.add(conditionEntry);

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
        conditions.add(conditionEntry);

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
        conditions.add(conditionEntry);

        // when
        final boolean result = conditions.hasNot(POISONED);

        // then
        assertThat(result).isTrue();
    }

    @Test
    public void reduceByOneTurnShouldReduceConditionByOneTurn() throws Exception {
        // given
        final ConditionEntry condition = conditionEntryBuilder()
                .condition(STUNNED)
                .turnsLeft(2)
                .nonPersistent()
                .build();
        conditions.add(condition);
        assertThat(conditions.getConditionEntry(STUNNED).getTurnsLeft() == 2).isTrue();

        // when
        conditions.reduceByOneTurn();

        // then
        assertThat(conditions.getConditionEntry(STUNNED).getTurnsLeft() == 1).isTrue();
    }

    @Test
    public void reduceByOneTurnShouldRemoveTemporaryConditionIfTurnsLeftIsZero() throws Exception {
        // given
        final ConditionEntry condition = conditionEntryBuilder()
                .condition(STUNNED)
                .turnsLeft(1)
                .nonPersistent()
                .build();
        conditions.add(condition);
        assertThat(conditions.getConditionEntry(STUNNED).getTurnsLeft() == 1).isTrue();

        // when
        conditions.reduceByOneTurn();

        // then
        assertThat(conditions.has(STUNNED)).isFalse();
    }

    @Test
    public void reduceByOneTurnShouldRemoveTemporaryConditionIfTurnsLeftBelowZero() throws Exception {
        // given
        final ConditionEntry condition = conditionEntryBuilder()
                .condition(STUNNED)
                .turnsLeft(-1)
                .nonPersistent()
                .build();
        conditions.add(condition);

        // when
        conditions.reduceByOneTurn();

        // then
        assertThat(conditions.has(STUNNED)).isFalse();
    }

    @Test
    public void getConditionEntryShouldReturnConditionForGivenType() throws Exception {
        // given
        final ConditionEntry condition = conditionEntryBuilder()
                .condition(POISONED)
                .turnsLeft(2)
                .build();
        conditions.add(condition);

        // when
        final ConditionEntry conditionEntryResult = conditions.getConditionEntry(POISONED);

        // then
        assertThat(conditionEntryResult).isEqualTo(condition);
    }

    @SuppressWarnings("SuspiciousMethodCalls") //used for test
    @Test
    public void getConditionEntryShouldReturnUnknownConditionForNull() {
        // when
        conditions.getConditionEntry(null);

        // then
        assertThat(conditions.getConditions().contains(UNKNOWN));
    }

    @Test
    public void removeAllTemporaryConditionsShouldRemoveTemporaryConditions() throws Exception {
        // given
        final ConditionEntry condition = conditionEntryBuilder()
                .condition(POISONED)
                .nonPersistent()
                .build();

        final ConditionEntry conditionTwo = createTemporaryCondition(STUNNED, 1);
        final ConditionEntry conditionThree = createTemporaryConditionWithDefaultDuration(AIR_IMMUNE);

        conditions.add(condition);
        conditions.add(conditionTwo);
        conditions.add(conditionThree);

        // when
        conditions.removeAllTemporaryConditions();

        // then
        assertThat(conditions.getConditions()).isEmpty();
    }

    @Test
    public void isImmuneReturnsTrueIfHasAirImmuneToAir() throws Exception {
        // given
        final ConditionEntry airImmuneCondition = createPersistentCondition(AIR_IMMUNE);
        conditions.add(airImmuneCondition);

        // when
        final boolean result = conditions.isImmuneTo(ElementType.AIR);

        // then
        assertThat(result).isTrue();
    }

    @Test
    public void isImmuneReturnsTrueIfHasEarthImmuneToEarth() throws Exception {
        // given
        final ConditionEntry earthImmuneCondition = createPersistentCondition(EARTH_IMMUNE);
        conditions.add(earthImmuneCondition);

        // when
        final boolean result = conditions.isImmuneTo(ElementType.EARTH);

        // then
        assertThat(result).isTrue();
    }

    @Test
    public void isImmuneReturnsTrueIfHasFireImmuneToFire() throws Exception {
        // given
        final ConditionEntry fireImmuneCondition = createPersistentCondition(FIRE_IMMUNE);
        conditions.add(fireImmuneCondition);

        // when
        final boolean result = conditions.isImmuneTo(ElementType.FIRE);

        // then
        assertThat(result).isTrue();
    }

    @Test
    public void isImmuneReturnsTrueIfHasWaterImmuneToWater() throws Exception {
        // given
        final ConditionEntry waterImmuneCondition = createPersistentCondition(WATER_IMMUNE);
        conditions.add(waterImmuneCondition);

        // when
        final boolean result = conditions.isImmuneTo(ElementType.WATER);

        // then
        assertThat(result).isTrue();
    }

    @Test
    public void isImmuneReturnsTrueIfHasNotAirImmuneToAir() throws Exception {
        // given
        final ConditionEntry fireImmuneCondition = createPersistentCondition(FIRE_IMMUNE);
        conditions.add(fireImmuneCondition);

        // when
        final boolean result = conditions.isImmuneTo(AIR);

        // then
        assertThat(result).isFalse();
    }

    @Test
    public void isNotImmuneReturnsFalseIfHasAirImmuneToAir() throws Exception {
        // given
        final ConditionEntry airImmuneCondition = createPersistentCondition(AIR_IMMUNE);
        conditions.add(airImmuneCondition);

        // when
        final boolean result = conditions.isNotImmuneTo(ElementType.AIR);

        // then
        assertThat(result).isFalse();
    }

    @Test
    public void isNotImmuneReturnsTrueIfHasNotAirImmuneToAir() throws Exception {
        // given
        final ConditionEntry fireImmuneCondition = createPersistentCondition(FIRE_IMMUNE);
        conditions.add(fireImmuneCondition);

        // when
        final boolean result = conditions.isNotImmuneTo(AIR);

        // then
        assertThat(result).isTrue();
    }

    @Test
    public void isImmuneReturnsFalseIfElementTypeIsNull() throws Exception {

        // when
        final boolean result = conditions.isImmuneTo(null);

        // then
        assertThat(result).isFalse();
    }

    @Test
    public void sizeShouldReturn0IfConditionsNull() {
        // given
        conditions.removeAllConditions();
        // when
        final int size = conditions.size();

        // then
        assertThat(size).isZero();
    }

    @Test
    public void sizeShouldReturn2For2Conditions() {
        // given
        final ConditionEntry fireSensitiveCondition = createPersistentCondition(FIRE_SENSITIVE);
        conditions.add(fireSensitiveCondition);
        final ConditionEntry airSensitiveCondition = createPersistentCondition(AIR_SENSITIVE);
        conditions.add(airSensitiveCondition);

        // when
        final int size = conditions.size();

        // then
        assertThat(size).isEqualTo(2);
    }

    @Test
    public void addShouldReplaceTemporaryConditionWithPersistentCondition() throws Exception {
        // when
        conditions.add(temporaryConditionEntry);
        conditions.add(persistentCondition);

        // then
        checkIfConditionsHasOnlyPersistentStunnedCondition();
    }

    @Test
    public void addShouldNotReplacePersistentConditionWithTemporaryCondition() throws Exception {
        // when
        conditions.add(persistentCondition);
        conditions.add(temporaryConditionEntry);

        // then
        checkIfConditionsHasOnlyPersistentStunnedCondition();
    }

    @Test
    public void reduceByOneTurnShouldNotChangeTurnsLeftForPersistentCondition() {
        // given
        conditions.add(persistentCondition);

        // when
        conditions.reduceByOneTurn();

        // then
        final ConditionEntry conditionEntry = conditions.getConditionEntry(persistentCondition.getConditionType());
        assertThat(conditionEntry.getTurnsLeft()).isEqualTo(INFINITIVE_TURNS_LEFT);
    }

    @Test
    public void removeAllConditionsShouldRemoveAllConditionsIncludingPersistentConditions() {
        // given
        final ConditionEntry condition = conditionEntryBuilder()
                .condition(POISONED)
                .build();
        final ConditionEntry conditionTwo = createPersistentCondition(AIR_IMMUNE);
        final ConditionEntry conditionThree = createTemporaryConditionWithDefaultDuration(STUNNED);

        conditions.add(condition);
        conditions.add(conditionTwo);
        conditions.add(conditionThree);

        // when
        conditions.removeAllConditions();

        // then
        assertThat(conditions.getConditions()).isEmpty();

    }

    @SuppressWarnings("CastToConcreteClass")
    @Test //single var args will cause NPE since casting
    public void createConditionWithNullArrayShouldContainsEmptyCondition() {
        // when
        final Condition condition = createCondition((ConditionEntry[]) null);

        // then
        assertThat(condition.size()).isZero();
    }

    @Test
    public void createConditionShouldCreateConditionWithListConditions() {
        // given
        final ConditionEntry conditionOne = conditionEntryBuilder()
                .condition(POISONED)
                .build();
        final ConditionEntry conditionTwo = createPersistentCondition(AIR_IMMUNE);
        final ConditionEntry conditionThree = createTemporaryConditionWithDefaultDuration(STUNNED);

        // when
        final Condition condition = createCondition(conditionOne, conditionTwo, conditionThree);

        // then
        assertThat(condition.size()).isEqualTo(3);
    }


    @Test
    public void hasNegativeConditionShouldReturnTrueForNegativeCondition() {
        // given
        final Condition condition = createCondition(createPersistentCondition(STUNNED));

        // when
        final boolean result = condition.hasNegativeCondition();

        // then
        assertThat(result).isTrue();
    }

    @Test
    public void hasNegativeConditionShouldReturnFalseForNeutralCondition() {
        // given
        final Condition condition = createCondition(createPersistentCondition(MINDLESS));

        // when
        final boolean result = condition.hasNegativeCondition();

        // then
        assertThat(result).isFalse();
    }

    @Test
    public void hasNegativeConditionShouldReturnFalseForPositiveCondition() {
        // given
        final Condition condition = createCondition(createPersistentCondition(BUBBLE_SHIELD));

        // when
        final boolean result = condition.hasNegativeCondition();

        // then
        assertThat(result).isFalse();
    }

    private void checkIfConditionsHasOnlyPersistentStunnedCondition() {
        assertThat(conditions.getConditions()).contains(persistentCondition);
        assertThat(conditions.getConditions()).hasSize(1);
        assertThat(conditions.getConditionEntry(STUNNED).isPersistent());
    }

}
