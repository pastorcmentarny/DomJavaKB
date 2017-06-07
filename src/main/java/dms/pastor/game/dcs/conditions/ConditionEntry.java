package dms.pastor.game.dcs.conditions;

import java.util.Objects;

import static java.lang.String.format;

/**
 * Author Dominik Symonowicz
 * Created 2015-07-27
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
public class ConditionEntry {
    private final ConditionType condition;
    private int turnsLeft = 0;


    public ConditionEntry(ConditionType condition, int turns) {
        this.condition = condition;
        this.turnsLeft = turns;
    }

    public ConditionType getConditionType() {
        return condition;
    }

    public int getTurnsLeft() {
        return turnsLeft;
    }

    public void updateTurnsLeft(int turns) {
        if (turns > turnsLeft) {
            turnsLeft = turns;
        }
    }

    public void reduceTurn() {
        turnsLeft--;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ConditionEntry)) return false;
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
}
