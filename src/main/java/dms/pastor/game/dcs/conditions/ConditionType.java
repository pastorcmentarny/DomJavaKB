package dms.pastor.game.dcs.conditions;

import dms.pastor.domain.exception.SomethingWentWrongException;

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
    STUNNED, POISONED, BLIND, WEAKNESS,
    TRIPLE, REGENERATION, FROZEN, BLOODLUST,
    AIR_RESISTANT, AIR_IMMUNE, AIR_SENSITIVE,
    EARTH_RESISTANT, EARTH_IMMUNE, EARTH_SENSITIVE,
    FIRE_RESISTANT, FIRE_IMMUNE, FIRE_SENSITIVE,
    WATER_RESISTANT, WATER_IMMUNE, WATER_SENSITIVE,
    MINDLESS, BUBBLE_SHIELD,
    POISON_IMMUNITY, UNKNOWN;

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
