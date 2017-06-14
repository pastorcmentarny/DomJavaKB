package dms.pastor.game.dcs.conditions;

import dms.pastor.game.dcs.utils.random.InGameRandomiserUtils;
import dms.pastor.game.dcs.utils.random.RandomiserUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;

import static dms.pastor.game.dcs.Config.DEFAULT_CONDITION_DURATION;
import static dms.pastor.game.dcs.conditions.ConditionType.*;

/**
 * Author Dominik Symonowicz
 * Created 2015-07-27
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class Condition {

    static final int IMMUNITY_PERCENTAGE = 50;
    private RandomiserUtils randomiserUtils = new InGameRandomiserUtils();

    private static final Logger LOGGER = LoggerFactory.getLogger(Condition.class);
    private final Random random = new Random();
    private final HashSet<ConditionEntry> conditions = new HashSet<>();

    public HashSet<ConditionEntry> getConditions() {
        return conditions;
    }

    public void add(ConditionType condition, int turns) {
        LOGGER.debug("You are " + condition.name().toLowerCase());
        for (ConditionEntry conditionEntry : conditions) {
            if (conditionEntry.getConditionType().equals(condition)) {
                conditionEntry.updateTurnsLeft(turns);
                return;
            }
        }
        conditions.add(new ConditionEntry(condition, turns));
    }

    public void add(ConditionType condition) {
        LOGGER.debug("You are " + condition.name().toLowerCase());
        add(condition, DEFAULT_CONDITION_DURATION);
    }

    public void add(ConditionEntry condition) {
        LOGGER.debug("You are " + condition.getConditionType().name().toLowerCase());
        for (ConditionEntry conditionEntry : conditions) {
            if (conditionEntry.equals(condition)) {
                conditionEntry.updateTurnsLeft(condition.getTurnsLeft());
                return;
            }
        }
        conditions.add(condition);
    }

    public void removeByConditionName(ConditionType conditionType) {
        ConditionEntry conditionEntryToDelete = null;
        for (ConditionEntry conditionEntry : conditions) {
            if (conditionEntry.getConditionType().equals(conditionType)) {
                conditionEntryToDelete = conditionEntry;
            }
        }
        conditions.remove(conditionEntryToDelete);
    }

    public boolean has(ConditionType condition) {
        for (ConditionEntry conditionEntry : conditions) {
            if (conditionEntry.getConditionType().equals(condition)) {
                return true;
            }
        }
        return false;
    }

    public boolean hasNot(ConditionType condition) {
        return !has(condition);
    }

    public void reduceByOneTurn() {
        Iterator<ConditionEntry> iterator = conditions.iterator();
        while (iterator.hasNext()) {
            ConditionEntry element = iterator.next();
            element.reduceTurn();
            if (element.getTurnsLeft() <= 0) {
                System.out.println("You are NOT LONGER " + element.getConditionType().name().toLowerCase());
                iterator.remove();
            }
        }
    }

    public ConditionEntry getConditionEntry(ConditionType type) {
        for (ConditionEntry element : conditions) {
            if (element.getConditionType().equals(type)) {
                return element;
            }
        }
        return null;
    }

    public void removeAll() {
        if (!conditions.isEmpty()) {
            for (ConditionEntry conditionEntry : conditions) {
                System.out.println(conditionEntry.getConditionType() + " is removed");
            }
            conditions.clear();
        }
    }

    public boolean isNotImmuneTo(ElementType type) {
        return !isImmuneTo(type);
    }

    public boolean isImmuneTo(ElementType type) {
        switch (type) {
            case AIR:
                return isImmuneTo(AIR_IMMUNE, AIR_RESISTANT);
            case EARTH:
                return isImmuneTo(EARTH_IMMUNE, EARTH_RESISTANT);
            case FIRE:
                return isImmuneTo(FIRE_IMMUNE, FIRE_RESISTANT);
            case WATER:
                return isImmuneTo(WATER_IMMUNE, WATER_RESISTANT);
            default:
                LOGGER.warn("Default: No immune for" + type.name());
                return false;
        }
    }

    public boolean isImmuneTo(ConditionType airImmune, ConditionType airResistant) {
        return has(airImmune) || has(airResistant) && randomiserUtils.isWillHappenWithProbabilityOf(IMMUNITY_PERCENTAGE);
    }

    public int size() {
        return conditions.size();
    }
}
