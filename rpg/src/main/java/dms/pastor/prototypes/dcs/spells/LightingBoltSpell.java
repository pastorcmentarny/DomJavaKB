package dms.pastor.prototypes.dcs.spells;

import dms.pastor.prototypes.dcs.Config;
import dms.pastor.prototypes.dcs.Elements;
import dms.pastor.prototypes.dcs.conditions.ConditionEntry;
import dms.pastor.prototypes.dcs.conditions.ConditionType;
import dms.pastor.prototypes.dcs.units.Unit;

import static dms.pastor.prototypes.dcs.utils.random.InGameRandomUtils.HALF;

/**
 * Author Dominik Symonowicz
 * Created 2015-07-27
 * WWW:	<a href="https://dominiksymonowicz.com/">HOME PAGE</a>
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class LightingBoltSpell extends Spell {

    public LightingBoltSpell() {
        setName("Lighting Bolt");
        setElements(new Elements(4, 0, 0, 0));
    }

    @Override
    public void castSpell(Unit attacker, Unit defender) {
        castSpellMessage(attacker.getName(), getName(), defender.getName());
        defender.doesDamageTo(attacker, Config.LIGHTING_BOLT_DAMAGE);
        if (randomUtils.isWillHappenWithProbabilityOf(HALF)) {
            System.out.println(defender.getName() + "  is stunned after being hit by lighting.");
            defender.getConditions().add(ConditionEntry.createTemporaryCondition(ConditionType.STUNNED, 2));
        }
    }
}
