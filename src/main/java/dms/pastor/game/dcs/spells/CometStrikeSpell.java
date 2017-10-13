package dms.pastor.game.dcs.spells;

import dms.pastor.game.dcs.Elements;
import dms.pastor.game.dcs.units.Unit;

import java.util.Random;

import static dms.pastor.game.dcs.Config.COMMENT_DAMAGE;
import static dms.pastor.game.dcs.Config.FREEZING_TURNS;
import static dms.pastor.game.dcs.conditions.ConditionEntry.createTemporaryCondition;
import static dms.pastor.game.dcs.conditions.ConditionType.FROZEN;
import static dms.pastor.game.dcs.conditions.ConditionType.POISONED;

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
        name = "Comet Spell";
        setElements(new Elements(0, 3, 0, 1));
    }

    @Override
    public void castSpell(Unit attacker, Unit defender) {
        castSpellMessage(attacker.getName(), name, defender.getName());
        attacker.doesDamageTo(defender, COMMENT_DAMAGE);
        if (new Random().nextInt(100) > 66) {
            defender.getConditions().add(createTemporaryCondition(FROZEN, FREEZING_TURNS));
        }
        if (new Random().nextInt(100) > 50) {
            defender.getConditions().add(createTemporaryCondition(POISONED, FREEZING_TURNS));
        }
    }
}
