package dms.pastor.prototype.dcs.spells;

import dms.pastor.prototype.dcs.Config;
import dms.pastor.prototype.dcs.Elements;
import dms.pastor.prototype.dcs.conditions.ConditionEntry;
import dms.pastor.prototype.dcs.conditions.ConditionType;
import dms.pastor.prototype.dcs.conditions.ElementType;
import dms.pastor.prototype.dcs.units.Unit;

import static dms.pastor.prototype.dcs.Config.FREEZING_TURNS;

/**
 * Author Dominik Symonowicz
 * Created 2015-08-01
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
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
