package dms.pastor.game.dcs.spells;

import dms.pastor.game.dcs.Config;
import dms.pastor.game.dcs.Elements;
import dms.pastor.game.dcs.conditions.ConditionType;
import dms.pastor.game.dcs.conditions.ElementType;
import dms.pastor.game.dcs.units.Unit;

/**
 * Author Dominik Symonowicz
 * Created 2015-08-01
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
public class FrozenSpell extends Spell {

    public FrozenSpell() {
        super();
        name = "Freezing Spell";
        setElements(new Elements(1, 0, 0, 2, 0, 0));
    }


    @Override
    public void castSpell(Unit attacker, Unit defender) {
        System.out.println(attacker.getName() + " casting freezing spell on.. " + defender.getName());
        defender.doesDamage(Config.FREEZING_DAMAGE, attacker);
        if (defender.getCondition().isNotImmuneTo(ElementType.WATER)) {
            defender.getCondition().add(ConditionType.FROZEN, Config.FREEZING_TURNS);
        } else {
            System.out.println(defender + " resists spell");
        }


    }
}