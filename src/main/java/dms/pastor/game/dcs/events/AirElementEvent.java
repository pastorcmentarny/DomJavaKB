package dms.pastor.game.dcs.events;

import dms.pastor.game.dcs.units.Unit;

import static dms.pastor.game.dcs.ElementsType.AIR;

/**
 * Author Dominik Symonowicz
 * Created 2015-07-26
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class AirElementEvent extends Event {

    @Override
    public String makeItHappen(Unit player1, Unit player2) {
        Unit unit = getRandomUnit(player1, player2);
        unit.getElements().addElement(AIR);
        return unit.getName() + " found " + AIR.name().toLowerCase();
    }
}
