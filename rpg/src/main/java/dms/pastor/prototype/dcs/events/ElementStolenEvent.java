package dms.pastor.prototype.dcs.events;

import dms.pastor.prototype.dcs.units.Unit;

import static dms.pastor.prototype.dcs.Config.REMOVE_RANDOM_ELEMENTS_NUMBER;

/**
 * Author Dominik Symonowicz
 * Created 2015-07-30
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class ElementStolenEvent extends Event {

    @Override
    public String makeItHappen(Unit attacker, Unit defender) {
        defender.getElements().removeRandomElements(REMOVE_RANDOM_ELEMENTS_NUMBER);
        return defender.getName() + " lost " + REMOVE_RANDOM_ELEMENTS_NUMBER + " elements.";
    }
}