package dms.pastor.game.dcs.conditions;

import org.junit.Test;

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

    private static final ConditionType CONDITION_TYPE = ConditionType.POISONED;
    private static final int INITIAL_TURNS_LEFT = 3;
    private final ConditionEntry conditionEntry = new ConditionEntry(CONDITION_TYPE, INITIAL_TURNS_LEFT);

    @Test
    public void updateTurnsLeftShouldUpdateTurnsIsHigherThanTurnsLeft() throws Exception {
        // given
        final int newTurnsLeft = 4;

        // when
        conditionEntry.updateTurnsLeft(newTurnsLeft);

        // then
        assertThat(conditionEntry.getTurnsLeft()).isEqualTo(newTurnsLeft);
    }

    @Test
    public void updateTurnsLeftShouldNotUpdateTurnsIsLowerThanTurnsLeft() throws Exception {
        // given
        final int newTurnsLeft = 2;

        // when
        conditionEntry.updateTurnsLeft(newTurnsLeft);

        // then
        assertThat(conditionEntry.getTurnsLeft()).isEqualTo(INITIAL_TURNS_LEFT);
    }

    @Test
    public void reduceTurnShouldReduceTurnLeftByOne() throws Exception {

        // when
        conditionEntry.reduceTurn();

        // then
        assertThat(conditionEntry.getTurnsLeft()).isEqualTo(2);

    }
}