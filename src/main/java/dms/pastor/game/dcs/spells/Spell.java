package dms.pastor.game.dcs.spells;

import dms.pastor.game.dcs.Elements;
import dms.pastor.game.dcs.cards.Card;
import dms.pastor.game.dcs.cards.CardType;
import dms.pastor.game.dcs.units.Unit;

/**
 * Author Dominik Symonowicz
 * Created 2015-07-23
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public abstract class Spell extends Card {

    private final CardType cardType = CardType.SPELL;
    private Elements elements;

    public static void castSpellMessage(String attackerName, String spellName, String defenderName) {
        System.out.println(attackerName + " casting " + spellName + " on " + defenderName);
    }

    public CardType getCardType() {
        return cardType;
    }

    public boolean hasEnoughElementsToCovertToSpell(Elements elements) {
        return this.elements.hasEnough(elements);
    }

    public abstract void castSpell(Unit attacker, Unit defender);

    public Elements getElements() {
        return elements;
    }

    void setElements(Elements elements) {
        this.elements = elements;
    }

    public boolean isASpell(Elements elements) {
        return this.elements.hasExactly(elements);
    }
}
