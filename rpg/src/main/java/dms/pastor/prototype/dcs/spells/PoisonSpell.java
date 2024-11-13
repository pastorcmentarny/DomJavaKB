package dms.pastor.prototype.dcs.spells;


import dms.pastor.prototypes.dcs.Elements;
import dms.pastor.prototypes.dcs.conditions.ConditionEntry;
import dms.pastor.prototypes.dcs.conditions.ConditionType;
import dms.pastor.prototypes.dcs.spells.Spell;
import dms.pastor.prototypes.dcs.units.Unit;

import static dms.pastor.prototypes.dcs.Config.POISON_TURNS;

/**
 * Author Dominik Symonowicz
 * Created 2015-07-31
 * WWW:	<a href="https://dominiksymonowicz.com/">HOME PAGE</a>
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class PoisonSpell extends Spell {

    public PoisonSpell() {
        setName("Poison");
        setElements(new Elements(0, 2, 0, 1));
    }

    @Override
    public void castSpell(Unit attacker, Unit defender) {
        castSpellMessage(attacker.getName(), getName(), defender.getName());
        if (defender.getConditions().hasNot(ConditionType.POISON_IMMUNITY)) {
            defender.getConditions().add(ConditionEntry.createTemporaryCondition(ConditionType.POISONED, POISON_TURNS));
            System.out.println(defender.getName() + " got poisoned for " + POISON_TURNS + " turns.");
        } else {
            System.out.println(defender.getName() + " resists against poison.");
        }
    }
}
