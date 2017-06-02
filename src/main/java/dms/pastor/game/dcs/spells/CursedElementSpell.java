package dms.pastor.game.dcs.spells;

import dms.pastor.game.dcs.Elements;
import dms.pastor.game.dcs.units.Unit;

import static dms.pastor.game.dcs.Config.FIREBALL_DMG;

/**
 * Author Dominik Symonowicz
 * Created 2015-08-05
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
public class CursedElementSpell extends Spell {
    public CursedElementSpell() {
        super();
        name = "Cursed Element Missile";
        setElements(new Elements(0, 0, 0, 1, 0, 2));
    }


    @Override
    public void castSpell(Unit attacker, Unit defender) {
        System.out.println(attacker.getName() + " casting .. " + name + " on " + defender.getName());
        defender.getElements().getAndUseRandomElements();
        defender.doesDamage(FIREBALL_DMG, attacker);
    }
}
