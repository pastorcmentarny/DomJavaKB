package dms.pastor.prototypes.dcs.spells;

import dms.pastor.prototypes.dcs.Elements;
import dms.pastor.prototypes.dcs.units.Unit;

import static dms.pastor.prototypes.dcs.Config.DEATH_RAY_DMG;

/**
 * Author Dominik Symonowicz
 * Created 2015-08-07
 * WWW:	<a href="https://dominiksymonowicz.com/">HOME PAGE</a>
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class DeathRaySpell extends Spell {
    public DeathRaySpell() {
        setName("Death ray");
        setElements(new Elements(2, 4, 1, 0));
    }

    @Override
    public void castSpell(Unit attacker, Unit defender) {
        castSpellMessage(attacker.getName(), getName(), defender.getName());
        defender.doesDirectDamage(DEATH_RAY_DMG);
        System.out.println(getName() + " does " + DEATH_RAY_DMG + " dmg.");
    }
}
