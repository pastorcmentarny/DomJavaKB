package dms.pastor.game.dcs.conditions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;

import static dms.pastor.game.dcs.Config.DEFAULT_CONDITION_DURATION;

/**
 * Author Dominik Symonowicz
 * Created 2015-07-27
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
public class Condition {

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
                if (has(ConditionType.AIR_IMMUNE)) {
                    return true;
                }
                if (has(ConditionType.AIR_RESISTANT)) {
                    return random.nextInt(100) > 50;
                }
                return false;
            case EARTH:
                if (has(ConditionType.EARTH_IMMUNE)) {
                    return true;
                }
                if (has(ConditionType.EARTH_RESISTANT)) {
                    return random.nextInt(100) > 50;
                }
                return false;
            case FIRE:
                if (has(ConditionType.FIRE_IMMUNE)) {
                    return true;
                }
                if (has(ConditionType.FIRE_RESISTANT)) {
                    return random.nextInt(100) > 50;
                } else {
                    return false;
                }
            case WATER:
                if (has(ConditionType.WATER_IMMUNE)) {
                    return true;
                }
                if (has(ConditionType.WATER_RESISTANT)) {
                    return random.nextInt(100) > 50;
                } else {
                    return false;
                }
            default:
                System.out.println("Default: No immune for" + type.name());
                return false;
        }
    }

}
