package dms.pastor.game.dcs.events;

import dms.pastor.game.dcs.units.Unit;

import static dms.pastor.game.dcs.ElementsType.WATER;
import static dms.pastor.game.dcs.conditions.ConditionType.FROZEN;
import static dms.pastor.game.dcs.conditions.ConditionType.WATER_SENSITIVE;

/**
 * Author Dominik Symonowicz
 * Created 2015-07-26
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
public class WaterElementEvent extends Event {

    @Override
    public String makeItHappen(Unit player1, Unit player2) {
        return addElementOrFroze(getRandomUnit(player1, player2));
    }

    @Override
    boolean canHaveEvent(Unit unit) {
        return unit.getConditions().hasNot(WATER_SENSITIVE);
    }

    //TODO refactor this with better name
    private String addElementOrFroze(Unit unit) {
        if (canHaveEvent(unit)) {
            unit.getElements().addElement(WATER);
            return unit.getName() + " found " + WATER.name().toLowerCase();
        } else {
            unit.getConditions().add(FROZEN, 1);
            return unit.getName() + " is frozen.";
        }
    }
}
