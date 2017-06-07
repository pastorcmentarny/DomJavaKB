package dms.pastor.game.dcs.spells;

import dms.pastor.game.dcs.Config;
import dms.pastor.game.dcs.Elements;
import dms.pastor.game.dcs.units.Unit;

/**
 * Author Dominik Symonowicz
 * Created 2015-08-07
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
public class DeathRaySpell extends Spell {
    public DeathRaySpell() {
        super();
        name = "Death ray";
        setElements(new Elements(0, 1, 1, 1, 0, 3));
    }

    @Override
    public void castSpell(Unit attacker, Unit defender) {
        System.out.println(attacker.getName() + " casting death's touch.. " + defender.getName());
        defender.doesDirectDamage(Config.DEATH_RAY_DMG);
        System.out.println(name + " does " + Config.DEATH_RAY_DMG + " dmg.");
    }
}
