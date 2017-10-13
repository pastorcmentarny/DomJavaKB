package dms.pastor.game.dcs.spells;

import dms.pastor.game.dcs.Elements;
import dms.pastor.game.dcs.units.Unit;

import static dms.pastor.game.dcs.Config.POISON_TURNS;
import static dms.pastor.game.dcs.conditions.ConditionEntry.createTemporaryCondition;
import static dms.pastor.game.dcs.conditions.ConditionType.POISONED;
import static dms.pastor.game.dcs.conditions.ConditionType.POISON_IMMUNITY;

/**
 * Author Dominik Symonowicz
 * Created 2015-07-31
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class PoisonSpell extends Spell {

    public PoisonSpell() {
        name = "Poison";
        setElements(new Elements(0, 2, 0, 1));
    }

    @Override
    public void castSpell(Unit attacker, Unit defender) {
        castSpellMessage(attacker.getName(), name, defender.getName());
        if (defender.getConditions().hasNot(POISON_IMMUNITY)) {
            defender.getConditions().add(createTemporaryCondition(POISONED, POISON_TURNS));
            System.out.println(defender.getName() + " got poisoned for " + POISON_TURNS + " turns.");
        } else {
            System.out.println(defender.getName() + " resists against poison.");
        }
    }
}
