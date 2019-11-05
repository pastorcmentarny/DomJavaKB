package dms.pastor.prototypes.dcs.conditions;

import org.junit.Test;

import static dms.pastor.prototypes.dcs.Config.DEFAULT_CONDITION_DURATION;
import static dms.pastor.prototypes.dcs.Config.INFINITIVE_TURNS_LEFT;
import static dms.pastor.prototypes.dcs.conditions.ConditionEntry.*;
import static dms.pastor.prototypes.dcs.conditions.ConditionType.POISONED;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author Dominik Symonowicz
 * Created 28/05/2017
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class ConditionEntryTest {

    private static final ConditionType CONDITION_TYPE = POISONED;
    private static final int INITIAL_TURNS_LEFT = 3;
    private final ConditionEntry temporaryCondition = createTemporaryCondition(CONDITION_TYPE, INITIAL_TURNS_LEFT);
    private final ConditionEntry persistentCondition = createPersistentCondition(CONDITION_TYPE);

    @Test
    public void updateTurnsLeftShouldUpdateTurnsIsHigherThanTurnsLeft() {
        // given
        final int newTurnsLeft = 4;

        // when
        temporaryCondition.updateTurnsLeft(newTurnsLeft);

        // then
        assertThat(temporaryCondition.getTurnsLeft()).isEqualTo(newTurnsLeft);
    }

    @Test
    public void updateTurnsLeftShouldNotUpdateTurnsIsLowerThanTurnsLeft() {
        // given
        final int newTurnsLeft = 2;

        // when
        temporaryCondition.updateTurnsLeft(newTurnsLeft);

        // then
        assertThat(temporaryCondition.getTurnsLeft()).isEqualTo(INITIAL_TURNS_LEFT);
    }

    @Test
    public void reduceTurnShouldReduceTurnLeftByOne() {

        // when
        temporaryCondition.reduceTurn();

        // then
        assertThat(temporaryCondition.getTurnsLeft()).isEqualTo(2);
    }

    @Test
    public void createPersistentConditionShouldReturnConditionWithPersistentTrue() {
        // given
        ConditionEntry expectedCondition = new ConditionEntry(CONDITION_TYPE, INFINITIVE_TURNS_LEFT, true);

        // when
        final ConditionEntry persistentConditionResult = createPersistentCondition(CONDITION_TYPE);

        // then
        assertThat(persistentConditionResult).isEqualTo(expectedCondition);
    }

    @Test
    public void createTemporaryConditionShouldReturnWithConditionWithPersistentFalse() {
        // given
        ConditionEntry expectedCondition = new ConditionEntry(CONDITION_TYPE, INITIAL_TURNS_LEFT, false);

        // when
        final ConditionEntry persistentConditionResult = createTemporaryCondition(CONDITION_TYPE, INITIAL_TURNS_LEFT);

        // then
        assertThat(persistentConditionResult).isEqualTo(expectedCondition);
    }

    @Test
    public void createTemporaryConditionWithDefaultDurationShouldReturnTemporaryConditionWithDefaultTurnsLef() {
        // when
        final ConditionEntry conditionEntry = createTemporaryConditionWithDefaultDuration(CONDITION_TYPE);

        // then
        assertThat(conditionEntry.getTurnsLeft()).isEqualTo(DEFAULT_CONDITION_DURATION);
    }

    @Test
    public void reduceTurnShouldNotBeShouldChangeTurnsLeftForPersistentCondition() {
        // when
        persistentCondition.reduceTurn();

        // then
        assertThat(persistentCondition.getTurnsLeft()).isEqualTo(INFINITIVE_TURNS_LEFT);
    }

    @Test
    public void updateTurnsLeftShouldNotBeShouldChangeTurnsLeftForPersistentCondition() {
        // when
        persistentCondition.updateTurnsLeft(INFINITIVE_TURNS_LEFT + 1);

        // then
        assertThat(persistentCondition.getTurnsLeft()).isEqualTo(INFINITIVE_TURNS_LEFT);
    }

}
