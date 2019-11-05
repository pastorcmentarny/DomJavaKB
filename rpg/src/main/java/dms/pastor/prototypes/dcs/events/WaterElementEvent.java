package dms.pastor.prototypes.dcs.events;

import dms.pastor.prototypes.dcs.conditions.ConditionEntry;
import dms.pastor.prototypes.dcs.conditions.ConditionType;
import dms.pastor.prototypes.dcs.conditions.ElementType;
import dms.pastor.prototypes.dcs.units.Unit;

/**
 * Author Dominik Symonowicz
 * Created 2015-07-26
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class WaterElementEvent extends Event {

    @Override
    public String makeItHappen(Unit player1, Unit player2) {
        return addElementOrFroze(getRandomUnit(player1, player2));
    }

    @Override
    boolean canHaveEvent(Unit unit) {
        return unit.getConditions().hasNot(ConditionType.WATER_SENSITIVE);
    }

    private String addElementOrFroze(Unit unit) {
        if (canHaveEvent(unit)) {
            unit.getElements().addElement(ElementType.WATER);
            return unit.getName() + " found " + ElementType.WATER.name().toLowerCase();
        } else {
            unit.getConditions().add(ConditionEntry.createTemporaryCondition(ConditionType.FROZEN, 1));
            return unit.getName() + " is frozen.";
        }
    }
}
