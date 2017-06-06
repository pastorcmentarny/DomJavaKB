package dms.pastor.game.dcs.events;

import dms.pastor.game.dcs.cards.Card;
import dms.pastor.game.dcs.units.Unit;

import java.util.Random;

import static dms.pastor.game.dcs.cards.CardType.EVENT;

/**
 * Author Dominik Symonowicz
 * Created 2015-07-23
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
abstract class Event extends Card {

    Event() {
        setCardType(EVENT);
    }

    boolean canHaveEvent(Unit unit) {
        return true;
    }

    public abstract String makeItHappen(Unit player1, Unit player2);

    Unit getRandomUnit(Unit... units) {
        return units[new Random().nextInt(units.length)];
    }
}