package dms.pastor.prototypes.dcs.spells;

import dms.pastor.prototypes.dcs.Config;
import dms.pastor.prototypes.dcs.Elements;
import dms.pastor.prototypes.dcs.conditions.ConditionEntry;
import dms.pastor.prototypes.dcs.conditions.ConditionType;
import dms.pastor.prototypes.dcs.conditions.ElementType;
import dms.pastor.prototypes.dcs.units.Unit;

import static dms.pastor.prototypes.dcs.Config.FREEZING_TURNS;

/**
 * Author Dominik Symonowicz
 * Created 2015-08-01
 * WWW:	<a href="https://dominiksymonowicz.com/">HOME PAGE</a>
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class FrozenSpell extends Spell {

    public FrozenSpell() {
        setName("Freezing Spell");
        setElements(new Elements(1, 0, 0, 2));
    }

    @Override
    public void castSpell(Unit attacker, Unit defender) {
        castSpellMessage(attacker.getName(), getName(), defender.getName());
        defender.doesDamageTo(attacker, Config.FREEZING_DAMAGE);
        if (defender.isStrongShield()) {
            System.out.println("StrongShield  protect " + defender.getName() + " from being frozen.");
        } else {
            if (defender.getConditions().isNotImmuneTo(ElementType.WATER)) {
                defender.getConditions().add(ConditionEntry.createTemporaryCondition(ConditionType.FROZEN, FREEZING_TURNS));
            } else {
                System.out.println(defender + " resists spell");
            }

        }
    }
}
