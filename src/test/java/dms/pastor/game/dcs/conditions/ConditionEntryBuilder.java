package dms.pastor.game.dcs.conditions;

import static dms.pastor.game.dcs.conditions.ConditionEntry.createPersistentCondition;
import static dms.pastor.game.dcs.conditions.ConditionEntry.createTemporaryCondition;
import static dms.pastor.utils.randoms.RandomDataGenerator.generateRandomBoolean;
import static dms.pastor.utils.randoms.RandomDataGenerator.randomPositiveInteger;

/**
 * Author Dominik Symonowicz
 * Created 29/05/2017
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class ConditionEntryBuilder {

    private ConditionType condition = ConditionType.POISONED;
    private int turnsLeft = randomPositiveInteger(10);
    private boolean persistent = generateRandomBoolean();

    private ConditionEntryBuilder() {
    }

    public static ConditionEntryBuilder conditionEntryBuilder() {
        return new ConditionEntryBuilder();
    }

    public ConditionEntry build() {
        return new ConditionEntry(condition, turnsLeft, persistent);
    }

    public ConditionEntry buildPersistentCondition() {
        return createPersistentCondition(condition);
    }

    public ConditionEntry buildTemporaryCondition() {
        return createTemporaryCondition(condition, turnsLeft);
    }

    public ConditionEntryBuilder condition(ConditionType condition) {
        this.condition = condition;
        return this;
    }

    public ConditionEntryBuilder turnsLeft(int turnsLeft) {
        this.turnsLeft = turnsLeft;
        return this;
    }

    public ConditionEntryBuilder persistent(boolean persistent) {
        this.persistent = persistent;
        return this;
    }

}
