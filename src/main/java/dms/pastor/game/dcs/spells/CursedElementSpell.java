package dms.pastor.game.dcs.spells;

import dms.pastor.game.dcs.Elements;
import dms.pastor.game.dcs.units.Unit;

import static dms.pastor.game.dcs.Config.FIREBALL_DMG;

/**
 * Author Dominik Symonowicz
 * Created 2015-08-05
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class CursedElementSpell extends Spell {
    public CursedElementSpell() {
        super();
        name = "Cursed Element Missile";
        setElements(new Elements(0, 0, 0, 1));
    }


    @Override
    public void castSpell(Unit attacker, Unit defender) {
        System.out.println(attacker.getName() + " casting .. " + name + " on " + defender.getName());
        defender.getElements().getAndUseRandomElements();
        defender.doesDamageTo(attacker, FIREBALL_DMG);
    }
}
