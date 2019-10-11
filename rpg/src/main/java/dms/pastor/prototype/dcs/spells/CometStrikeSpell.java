package dms.pastor.prototype.dcs.spells;

import dms.pastor.prototype.dcs.Elements;
import dms.pastor.prototype.dcs.conditions.ConditionEntry;
import dms.pastor.prototype.dcs.conditions.ConditionType;
import dms.pastor.prototype.dcs.units.Unit;

import static dms.pastor.prototype.dcs.Config.COMMENT_DAMAGE;
import static dms.pastor.prototype.dcs.Config.FREEZING_TURNS;
import static dms.pastor.prototype.dcs.utils.random.InGameRandomUtils.HALF;
import static dms.pastor.prototype.dcs.utils.random.InGameRandomUtils.TWO_THIRD;

/**
 * Author Dominik Symonowicz
 * Created 2015-08-02
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class CometStrikeSpell extends Spell {

    public CometStrikeSpell() {
        setName("Comet Spell");
        setElements(new Elements(0, 3, 0, 1));
    }

    @Override
    public void castSpell(Unit attacker, Unit defender) {
        castSpellMessage(attacker.getName(), getName(), defender.getName());
        attacker.doesDamageTo(defender, COMMENT_DAMAGE);
        if (randomUtils.isWillHappenWithProbabilityOf(TWO_THIRD)) {
            defender.getConditions().add(ConditionEntry.createTemporaryCondition(ConditionType.FROZEN, FREEZING_TURNS));
        }
        if (randomUtils.isWillHappenWithProbabilityOf(HALF)) {
            defender.getConditions().add(ConditionEntry.createTemporaryCondition(ConditionType.POISONED, FREEZING_TURNS));
        }
    }
}
