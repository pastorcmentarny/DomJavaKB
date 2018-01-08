package dms.pastor.game.dcs.conditions;

import dms.pastor.domain.exception.SomethingWentWrongException;

import static dms.pastor.game.dcs.conditions.ConditionGroup.*;

/**
 * Author Dominik Symonowicz
 * Created 2015-07-27
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public enum ConditionType {
    STUNNED(NEGATIVE), POISONED(NEGATIVE), BLIND(NEGATIVE), WEAKNESS(NEGATIVE),
    TRIPLE(POSITIVE), REGENERATION(POSITIVE), FROZEN(POSITIVE), BLOODLUST(POSITIVE),
    AIR_RESISTANT(POSITIVE), AIR_IMMUNE(POSITIVE), AIR_SENSITIVE(NEGATIVE),
    EARTH_RESISTANT(POSITIVE), EARTH_IMMUNE(POSITIVE), EARTH_SENSITIVE(NEGATIVE),
    FIRE_RESISTANT(POSITIVE), FIRE_IMMUNE(POSITIVE), FIRE_SENSITIVE(NEGATIVE),
    WATER_RESISTANT(POSITIVE), WATER_IMMUNE(POSITIVE), WATER_SENSITIVE(POSITIVE),
    MINDLESS(NEUTREAL), BUBBLE_SHIELD(POSITIVE),
    POISON_IMMUNITY(POSITIVE), UNKNOWN(NEUTREAL);

    private final ConditionGroup group;

    ConditionType(ConditionGroup group) {
        this.group = group;
    }

    public ConditionGroup group() {
        return group;
    }

    public static String getText(ConditionType conditionType) {
        throwExceptionIfNull(conditionType);
        return conditionType.name().replaceAll("_", " ").toLowerCase();
    }

    private static void throwExceptionIfNull(ConditionType conditionType) {
        if (conditionType == null) {
            throw new SomethingWentWrongException();
        }
    }
}
