package dms.pastor.game.dcs.spells;

import dms.pastor.game.dcs.Config;
import dms.pastor.game.dcs.Elements;
import dms.pastor.game.dcs.conditions.ElementType;
import dms.pastor.game.dcs.units.Unit;

/**
 * Author Dominik Symonowicz
 * Created 2015-07-23
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
public class FireBall extends Spell {
    public FireBall() {
        super();
        name = "Fireball";
        setElements(new Elements(0, 0, 3, 0, 0, 0));
    }

    @Override
    public void castSpell(Unit attacker, Unit defender) {
        System.out.println(attacker.getName() + " casting fireball.. " + defender.getName());
        if (defender.getCondition().isNotImmuneTo(ElementType.FIRE)) {
            defender.doesDamage(Config.FIREBALL_DMG, attacker);
        } else {
            System.out.println(defender + " resists spell");
        }
    }

}
