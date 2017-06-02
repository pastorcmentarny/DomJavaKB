package dms.pastor.game.dcs.spells;

import dms.pastor.game.dcs.Elements;
import dms.pastor.game.dcs.cards.Card;
import dms.pastor.game.dcs.cards.CardType;
import dms.pastor.game.dcs.units.Unit;

/**
 * Author Dominik Symonowicz
 * Created 2015-07-23
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
public abstract class Spell extends Card {
    private Elements elements;
    private final CardType cardType = CardType.SPELL;

    public CardType getCardType() {
        return cardType;
    }

    public boolean hasEnoughElementsToCovertToSpell(Elements elements) {
        return this.elements.hasEnough(elements);
    }

    public abstract void castSpell(Unit attacker, Unit defender);

    void setElements(Elements elements) {
        this.elements = elements;
    }

    public Elements getElements() {
        return elements;
    }

    public boolean isASpell(Elements elements) {
        return this.elements.hasExactly(elements);
    }
}
