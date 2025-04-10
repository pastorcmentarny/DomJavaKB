package dms.pastor.prototypes.dcs.spells;

import dms.pastor.prototypes.dcs.Elements;
import dms.pastor.prototypes.dcs.cards.Card;
import dms.pastor.prototypes.dcs.units.Unit;
import dms.pastor.prototypes.dcs.utils.random.InGameRandomUtils;
import dms.pastor.prototypes.dcs.utils.random.RandomUtils;

import java.util.Random;

import static dms.pastor.prototypes.dcs.cards.CardType.SPELL;

/**
 * Author Dominik Symonowicz
 * Created 2015-07-23
 * WWW:	<a href="https://dominiksymonowicz.com/">HOME PAGE</a>
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public abstract class Spell extends Card {

    final RandomUtils randomUtils = new InGameRandomUtils();
    final Random random = new Random();
    private Elements elements;

    public Spell() {
        setCardType(SPELL);
    }

    protected static void castSpellMessage(String attackerName, String spellName, String defenderName) {
        System.out.println(attackerName + " casting " + spellName + " on " + defenderName);
    }

    public boolean hasEnoughElementsToCovertToSpell(Elements elements) {
        return this.elements.hasEnough(elements);
    }

    public abstract void castSpell(Unit attacker, Unit defender);

    public void castSpellIfHasEnoughElements(Unit attacker, Unit defender) {
        if (hasEnoughElementsToCovertToSpell(attacker.getElements())) {
            castSpell(attacker, defender);
            attacker.getElements().useElements(elements);
        }
    }

    public void castSpellAsLongAsItHasEnoughElements(Unit attacker, Unit defender) {
        while (hasEnoughElementsToCovertToSpell(attacker.getElements())) {
            castSpell(attacker, defender);
            attacker.getElements().useElements(elements);
        }

    }

    public Elements getElements() {
        return elements;
    }

    public void setElements(Elements elements) {
        this.elements = elements;
    }

}
