package dms.pastor.game.dcs.conditions;

import dms.pastor.domain.exception.SomethingWentWrongException;
import dms.pastor.game.dcs.utils.random.InGameRandomUtils;
import dms.pastor.game.dcs.utils.random.RandomUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

import static dms.pastor.game.dcs.conditions.ConditionEntry.isEmpty;
import static dms.pastor.game.dcs.conditions.ConditionEntry.unknown;
import static dms.pastor.game.dcs.conditions.ConditionGroup.NEGATIVE;
import static dms.pastor.game.dcs.conditions.ConditionType.*;
import static java.lang.String.format;
import static java.util.Collections.unmodifiableSet;
import static java.util.stream.Collectors.toCollection;

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

    private static final int IMMUNITY_PERCENTAGE = 50;
    private static final Logger LOGGER = LoggerFactory.getLogger(Condition.class);
    private final RandomUtils randomUtils = new InGameRandomUtils();
    private Set<ConditionEntry> conditions = new HashSet<>();

    static Condition createCondition(ConditionEntry... conditionEntries) {
        Condition condition = new Condition();
        if (isEmpty(conditionEntries)) {
            return condition;
        }

        addAllConditionsEntries(condition, conditionEntries);
        return condition;
    }

    private static void addAllConditionsEntries(Condition condition, ConditionEntry[] conditionEntries) {
        for (ConditionEntry entry : conditionEntries) {
            condition.add(entry);
        }
    }

    public Set<ConditionEntry> getConditions() {
        return unmodifiableSet(conditions);
    }

    public void add(ConditionEntry condition) {
        if (Objects.isNull(condition)) {
            final String errorMessage = "Cock-up detected. Passing null instead condition.";
            LOGGER.error(errorMessage);
            throw new SomethingWentWrongException(errorMessage);
        }

        LOGGER.debug("You are influence of " + ConditionType.getText(condition.getConditionType()));
        if (has(condition.getConditionType())) {
            if (getConditionEntry(condition.getConditionType()).isTemporary() && condition.isPersistent()) {
                conditions.remove(getConditionEntry(condition.getConditionType()));
                conditions.add(condition);
            } else {
                getConditionEntry(condition.getConditionType()).updateTurnsLeft(condition.getTurnsLeft());
            }
            return;
        }
        conditions.add(condition);
    }

    public void removeByConditionName(ConditionType conditionType) {
        ConditionEntry conditionEntryToDelete = null;
        for (ConditionEntry conditionEntry : conditions) {
            if (conditionEntry.getConditionType() == conditionType) {
                conditionEntryToDelete = conditionEntry;
            }
        }
        conditions.remove(conditionEntryToDelete);
    }

    public boolean has(ConditionType condition) {
        for (ConditionEntry conditionEntry : conditions) {
            if (conditionEntry.getConditionType() == condition) {
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
                if (conditions.size() == 1) {
                    conditions.clear();
                } else {
                    iterator.remove();
                }
            }
        }
    }

    ConditionEntry getConditionEntry(ConditionType type) {
        for (ConditionEntry element : conditions) {
            if (element.getConditionType() == type) {
                return element;
            }
        }
        return unknown();
    }

    public void removeAllTemporaryConditions() {
        LOGGER.debug("Removing all temporary conditions.");
        if (!conditions.isEmpty()) {
            conditions.forEach(this::displayConditionsToBeRemoved);
            conditions = conditions.stream().filter(ConditionEntry::isPersistent).collect(toCollection(HashSet::new));

        }
    }

    private void displayConditionsToBeRemoved(ConditionEntry condition) {
        if (condition.isTemporary()) {
            System.out.println(condition.getConditionType() + " will be removed.");
        }
    }

    void removeAllConditions() {
        LOGGER.debug("Clearing up all conditions");
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

    boolean isImmuneTo(ElementType type) {
        if (Objects.isNull(type)) {
            LOGGER.error("Bug detected. Null passed as element type.");
            return false;
        }
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

    private boolean isImmuneTo(ConditionType conditionType, ConditionType resistCondition) {
        return has(conditionType) || has(resistCondition) && randomUtils.isWillHappenWithProbabilityOf(IMMUNITY_PERCENTAGE);
    }

    public int size() {
        return conditions.size();
    }

    public void clear() {
        conditions.clear();
    }

    @Override
    public String toString() {
        return format("Condition{conditions=%s, randomUtils=%s}", conditions, randomUtils);
    }

    public boolean hasNegativeCondition() {
        return conditions.stream().anyMatch(conditionEntry -> conditionEntry.getConditionType().group() == NEGATIVE);

    }
}
