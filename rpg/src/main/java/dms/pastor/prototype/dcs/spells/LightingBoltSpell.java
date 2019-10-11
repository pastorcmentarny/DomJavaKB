package dms.pastor.prototype.dcs.spells;

import dms.pastor.prototype.dcs.Config;
import dms.pastor.prototype.dcs.Elements;
import dms.pastor.prototype.dcs.conditions.ConditionEntry;
import dms.pastor.prototype.dcs.conditions.ConditionType;
import dms.pastor.prototype.dcs.units.Unit;

import static dms.pastor.prototype.dcs.utils.random.InGameRandomUtils.HALF;

/**
 * Author Dominik Symonowicz
 * Created 2015-07-27
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
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
