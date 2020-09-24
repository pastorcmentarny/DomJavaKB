package dms.pastor.prototypes.dcs.conditions;

import static dms.pastor.prototypes.dcs.Config.DEFAULT_CONDITION_DURATION;
import static dms.pastor.prototypes.dcs.Config.INFINITIVE_TURNS_LEFT;
import static dms.pastor.prototypes.dcs.conditions.ConditionType.UNKNOWN;
import static java.lang.String.format;
import static java.util.Objects.hash;

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
    private final boolean persistent;
    private int turnsLeft;

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

    public static ConditionEntry unknown() {
        return new ConditionEntry(UNKNOWN, 0, false);
    }

    static boolean isEmpty(ConditionEntry[] conditionEntries) {
        return conditionEntries == null || conditionEntries.length == 0;
    }

    ConditionType getConditionType() {
        return condition;
    }

    int getTurnsLeft() {
        return turnsLeft;
    }

    boolean isPersistent() {
        return persistent;
    }

    boolean isTemporary() {
        return !persistent;
    }

    void updateTurnsLeft(int turns) {
        if (isNotPersistent() && turns > turnsLeft) {
            turnsLeft = turns;
        }
    }

    void reduceTurn() {
        if (isNotPersistent()) {
            turnsLeft--;
        }
    }

    private boolean isNotPersistent() {
        return !persistent;
    }

    @Override
    public boolean equals(Object otherConditionEntry) {
        if (this == otherConditionEntry) return true;
        if (!(otherConditionEntry instanceof ConditionEntry)) return false;
        ConditionEntry conditionEntry = (ConditionEntry) otherConditionEntry;
        return getTurnsLeft() == conditionEntry.getTurnsLeft() &&
                isPersistent() == conditionEntry.isPersistent() &&
                condition == conditionEntry.condition;
    }

    @Override
    public int hashCode() {
        return hash(condition, getTurnsLeft(), isPersistent());
    }

    @Override
    public String toString() {
        return format("ConditionEntry{condition=%s, turnsLeft=%d, persistent=%s}", condition, turnsLeft, persistent);
    }
}
