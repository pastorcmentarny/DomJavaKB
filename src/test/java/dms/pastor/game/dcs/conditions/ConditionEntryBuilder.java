package dms.pastor.game.dcs.conditions;

import static dms.pastor.utils.randoms.RandomDataGenerator.randomPositiveInteger;

/**
 * Author Dominik Symonowicz
 * Created 29/05/2017
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
public class ConditionEntryBuilder {
    private ConditionType condition = ConditionType.POISONED;
    private int turnsLeft = randomPositiveInteger(10);

    private ConditionEntryBuilder() {
    }

    public static ConditionEntryBuilder conditionEntryBuilder() {
        return new ConditionEntryBuilder();
    }

    public ConditionEntry build() {
        return new ConditionEntry(condition, turnsLeft);
    }

    public ConditionEntryBuilder condition(ConditionType condition) {
        this.condition = condition;
        return this;
    }

    public ConditionEntryBuilder turnsLeft(int turnsLeft) {
        this.turnsLeft = turnsLeft;
        return this;
    }
}