package dms.pastor.game.dcs.spells;

import dms.pastor.game.dcs.Config;
import dms.pastor.game.dcs.Elements;
import dms.pastor.game.dcs.conditions.ElementType;
import dms.pastor.game.dcs.units.Unit;

import static dms.pastor.game.dcs.Config.FREEZING_TURNS;
import static dms.pastor.game.dcs.conditions.ConditionEntry.createTemporaryCondition;
import static dms.pastor.game.dcs.conditions.ConditionType.FROZEN;

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
        super();
        name = "Freezing Spell";
        setElements(new Elements(1, 0, 0, 2));
    }

    @Override
    public void castSpell(Unit attacker, Unit defender) {
        castSpellMessage(attacker.getName(), name, defender.getName());
        defender.doesDamageTo(attacker, Config.FREEZING_DAMAGE);
        if (defender.getConditions().isNotImmuneTo(ElementType.WATER)) {
            defender.getConditions().add(createTemporaryCondition(FROZEN, FREEZING_TURNS));
        } else {
            System.out.println(defender + " resists spell");
        }

    }
}
