package dms.pastor.prototypes.dcs.events;

import dms.pastor.prototypes.dcs.conditions.ElementType;
import dms.pastor.prototypes.dcs.units.Unit;

/**
 * Author Dominik Symonowicz
 * Created 2015-07-26
 * WWW:	<a href="https://dominiksymonowicz.com/">HOME PAGE</a>
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class EarthElementEvent extends Event {

    @Override
    public String makeItHappen(Unit player1, Unit player2) {
        Unit unit = getRandomUnit(player1, player2);
        unit.getElements().addElement(ElementType.EARTH);
        return unit.getName() + " found " + ElementType.EARTH.name().toLowerCase();
    }
}
