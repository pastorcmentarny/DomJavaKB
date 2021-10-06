package dms.pastor.prototypes.dcs.spells;

import dms.pastor.prototypes.dcs.Elements;
import dms.pastor.prototypes.dcs.conditions.ConditionEntry;
import dms.pastor.prototypes.dcs.conditions.ConditionType;
import dms.pastor.prototypes.dcs.units.Unit;

import static dms.pastor.prototypes.dcs.Config.DEFAULT_CONDITION_DURATION;
import static dms.pastor.prototypes.dcs.utils.random.InGameRandomUtils.THREE_QUARTERS;

/**
 * Author Dominik Symonowicz
 * Created 2015-07-29
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
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
