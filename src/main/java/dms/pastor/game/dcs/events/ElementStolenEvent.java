package dms.pastor.game.dcs.events;

import dms.pastor.game.dcs.units.Unit;

import java.util.Random;

import static dms.pastor.game.dcs.Config.REMOVE_RANDOM_ELEMENTS_NUMBER;

/**
 * Author Dominik Symonowicz
 * Created 2015-07-30
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
public class ElementStolenEvent extends Event {
    Random random = new Random();

    @Override
    public String makeItHappen(Unit attacker, Unit defender) {
        defender.getElements().removeRandomElements(REMOVE_RANDOM_ELEMENTS_NUMBER);
        return defender.getName() + " lost " + REMOVE_RANDOM_ELEMENTS_NUMBER + " elements.";
    }
}