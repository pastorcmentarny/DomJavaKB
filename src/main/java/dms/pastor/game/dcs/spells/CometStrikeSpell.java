package dms.pastor.game.dcs.spells;

import dms.pastor.game.dcs.Elements;
import dms.pastor.game.dcs.units.Unit;

import static dms.pastor.game.dcs.Config.COMMENT_DAMAGE;
import static dms.pastor.game.dcs.Config.FREEZING_TURNS;
import static dms.pastor.game.dcs.conditions.ConditionEntry.createTemporaryCondition;
import static dms.pastor.game.dcs.conditions.ConditionType.FROZEN;
import static dms.pastor.game.dcs.conditions.ConditionType.POISONED;
import static dms.pastor.game.dcs.utils.random.InGameRandomUtils.HALF;
import static dms.pastor.game.dcs.utils.random.InGameRandomUtils.TWO_THIRD;

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
            defender.getConditions().add(createTemporaryCondition(FROZEN, FREEZING_TURNS));
        }
        if (randomUtils.isWillHappenWithProbabilityOf(HALF)) {
            defender.getConditions().add(createTemporaryCondition(POISONED, FREEZING_TURNS));
        }
    }
}
