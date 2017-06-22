package dms.pastor.game.dcs.conditions;

import java.util.Objects;

import static dms.pastor.game.dcs.Config.DEFAULT_CONDITION_DURATION;
import static dms.pastor.game.dcs.Config.INFINITIVE_TURNS_LEFT;
import static java.lang.String.format;

/**
 * Author Dominik Symonowicz
 * Created 2015-07-27
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class ConditionEntry {

    private final ConditionType condition;
    private int turnsLeft = 0;
    private boolean persistent;

    ConditionEntry(ConditionType condition, int turns, boolean persistent) {
        this.condition = condition;
        this.turnsLeft = turns;
        this.persistent = persistent;
    }

    public static ConditionEntry createPersistentCondition(ConditionType conditionType) {
        return new ConditionEntry(conditionType, INFINITIVE_TURNS_LEFT, true);
    }

    public static ConditionEntry createTemporaryCondition(ConditionType conditionType, int initialTurnsLeft) {
        return new ConditionEntry(conditionType, initialTurnsLeft, false);
    }

    public static ConditionEntry createTemporaryConditionWithDefaultDuration(ConditionType conditionType) {
        return new ConditionEntry(conditionType, DEFAULT_CONDITION_DURATION, false);
    }

    public ConditionType getConditionType() {
        return condition;
    }

    public int getTurnsLeft() {
        return turnsLeft;
    }

    public boolean isPersistent() {
        return persistent;
    }

    public boolean isTemporary() {
        return !persistent;
    }

    public void updateTurnsLeft(int turns) {
        if (isNotPersistent() && turns > turnsLeft) {
            turnsLeft = turns;
        }
    }

    public void reduceTurn() {
        if (isNotPersistent()) {
            turnsLeft--;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ConditionEntry)) {
            return false;
        }
        ConditionEntry that = (ConditionEntry) o;
        return getTurnsLeft() == that.getTurnsLeft() &&
                condition == that.condition;
    }

    @Override
    public int hashCode() {
        return Objects.hash(condition, getTurnsLeft());
    }

    @Override
    public String toString() {
        return format("ConditionEntry{condition=%s, turnsLeft=%d}", condition, turnsLeft);
    }

    private boolean isNotPersistent() {
        return !persistent;
    }
}
