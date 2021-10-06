package dms.pastor.prototypes.dcs.events;

import dms.pastor.prototypes.dcs.cards.Card;
import dms.pastor.prototypes.dcs.units.Unit;

import java.util.Random;

import static dms.pastor.prototypes.dcs.cards.CardType.EVENT;
import static dms.pastor.prototypes.dcs.events.Rarity.COMMON;

/**
 * Author Dominik Symonowicz
 * Created 2015-07-23
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
abstract class Event extends Card {

    Rarity rarity = COMMON;

    Event() {
        setCardType(EVENT);
    }

    Rarity getRarity() {
        return rarity;
    }

    boolean canHaveEvent(Unit unit) {
        return true;
    }

    public abstract String makeItHappen(Unit player1, Unit player2);

    Unit getRandomUnit(Unit... units) {
        return units[new Random().nextInt(units.length)];
    }
}
