package dms.pastor.prototype.dcs.spells;

import dms.pastor.prototype.dcs.Elements;
import dms.pastor.prototype.dcs.conditions.ConditionEntry;
import dms.pastor.prototype.dcs.conditions.ConditionType;
import dms.pastor.prototype.dcs.units.Unit;

import static dms.pastor.prototype.dcs.Config.DEFAULT_CONDITION_DURATION;
import static dms.pastor.prototype.dcs.utils.random.InGameRandomUtils.THREE_QUARTERS;

/**
 * Author Dominik Symonowicz
 * Created 2015-07-29
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class WeaknessSpell extends Spell {

    public WeaknessSpell() {
        setName("Weakness Spell");
        setElements(new Elements(0, 1, 0, 0));
    }

    @Override
    public void castSpell(Unit attacker, Unit defender) {
        castSpellMessage(attacker.getName(), getName(), defender.getName());
        if (randomUtils.isWillHappenWithProbabilityOf(THREE_QUARTERS)) {
            defender.getConditions().add(ConditionEntry.createTemporaryConditionWithDefaultDuration(ConditionType.WEAKNESS));
            System.out.println(defender.getName() + " is weak for " + DEFAULT_CONDITION_DURATION + " turns.");
        } else {
            System.out.println(defender.getName() + " resits.");
        }
    }
}
