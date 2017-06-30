package dms.pastor.game.dcs.events;

import dms.pastor.game.dcs.conditions.ElementType;
import dms.pastor.game.dcs.units.Unit;

import static dms.pastor.game.dcs.conditions.ConditionType.FIRE_SENSITIVE;

/**
 * Author Dominik Symonowicz
 * Created 2015-07-26
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class FireElementEvent extends Event {

    @Override
    public String makeItHappen(Unit player1, Unit player2) {
        return performFireEvent(getRandomUnit(player1, player2));
    }

    @Override
    boolean canHaveEvent(Unit unit) {
        return unit.getConditions().hasNot(FIRE_SENSITIVE);
    }

    private String performFireEvent(Unit player) {
        if (canHaveEvent(player)) {
            player.getElements().addElement(ElementType.FIRE);
            return player.getName() + " found " + ElementType.FIRE.name().toLowerCase();
        } else {
            final int penaltyDmg = 3;
            player.doesDirectDamage(penaltyDmg);
            return "Unstable fire element causes minor damage " + penaltyDmg + " to " + player.getName();
        }
    }

}
