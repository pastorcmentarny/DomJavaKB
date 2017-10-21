package dms.pastor.game.dcs.spells;

import dms.pastor.game.dcs.Config;
import dms.pastor.game.dcs.Elements;
import dms.pastor.game.dcs.units.Unit;

import static dms.pastor.game.dcs.conditions.ConditionEntry.createTemporaryCondition;
import static dms.pastor.game.dcs.conditions.ConditionType.STUNNED;
import static dms.pastor.game.dcs.utils.random.InGameRandomUtils.HALF;

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
        name = "Lighting Bolt";
        setElements(new Elements(4, 0, 0, 0));
    }

    @Override
    public void castSpell(Unit attacker, Unit defender) {
        castSpellMessage(attacker.getName(), name, defender.getName());
        defender.doesDamageTo(attacker, Config.LIGHTING_BOLT_DAMAGE);
        if (randomUtils.isWillHappenWithProbabilityOf(HALF)) {
            System.out.println(defender.getName() + "  is stunned after being hit by lighting.");
            defender.getConditions().add(createTemporaryCondition(STUNNED, 2));
        }
    }
}
