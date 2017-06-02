package dms.pastor.game.dcs.spells;

import dms.pastor.game.dcs.Elements;
import dms.pastor.game.dcs.units.Unit;

/**
 * Author Dominik Symonowicz
 * Created 2015-08-03
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
public class MagicDeathScythe extends Spell {
    public MagicDeathScythe() {
        super();
        name = "Touch of Death's Scythe";
        setElements(new Elements(0, 0, 0, 0, 0, 1));
    }

    @Override
    public void castSpell(Unit attacker, Unit defender) {
        System.out.println(attacker.getName() + " casting death's touch.. " + defender.getName());
        defender.doesDirectDamage(200);
    }
}
