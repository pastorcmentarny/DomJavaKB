package dms.pastor.game.dcs.spells;

import dms.pastor.game.dcs.Elements;
import dms.pastor.game.dcs.units.Unit;

import static dms.pastor.game.dcs.Config.POISON_TURNS;
import static dms.pastor.game.dcs.conditions.ConditionType.POISONED;
import static dms.pastor.game.dcs.conditions.ConditionType.POISON_IMMUNITY;

/**
 * Author Dominik Symonowicz
 * Created 2015-07-31
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
public class PoisonSpell extends Spell {
    public PoisonSpell() {
        super();
        name = "Poison";
        setElements(new Elements(0, 1, 0, 1, 0, 2));
    }

    @Override
    public void castSpell(Unit attacker, Unit defender) {
        System.out.println(attacker.getName() + " casting poison spell.");
        if (defender.getConditions().hasNot(POISON_IMMUNITY)) {
            defender.getConditions().add(POISONED, POISON_TURNS);
            System.out.println(defender.getName() + " got poisoned for " + POISON_TURNS + " turns.");
        } else {
            System.out.println(defender.getName() + " resists against poison.");
        }
    }
}
