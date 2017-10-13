package dms.pastor.game.dcs.spells;

import dms.pastor.game.dcs.Elements;
import dms.pastor.game.dcs.units.Unit;

import static dms.pastor.game.dcs.Config.DEATH_RAY_DMG;

/**
 * Author Dominik Symonowicz
 * Created 2015-08-07
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class DeathRaySpell extends Spell {

    public DeathRaySpell() {
        name = "Death ray";
        setElements(new Elements(2, 4, 1, 0));
    }

    @Override
    public void castSpell(Unit attacker, Unit defender) {
        castSpellMessage(attacker.getName(), name, defender.getName());
        defender.doesDirectDamage(DEATH_RAY_DMG);
        System.out.println(name + " does " + DEATH_RAY_DMG + " dmg.");
    }
}
