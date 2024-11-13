package dms.pastor.prototypes.dcs.spells;

import dms.pastor.prototypes.dcs.Elements;
import dms.pastor.prototypes.dcs.units.Unit;

/**
 * Author Dominik Symonowicz
 * Created 2015-08-05
 * WWW:	<a href="https://dominiksymonowicz.com/">HOME PAGE</a>
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class CursedElementSpell extends Spell {
    public CursedElementSpell() {
        setName("Cursed Element Missile");
        setElements(new Elements(2, 2, 1, 2));
    }

    @Override
    public void castSpell(Unit attacker, Unit defender) {
        castSpellMessage(attacker.getName(), getName(), defender.getName());
        defender.getElements().getAndUseRandomElements();
        final int dmg = defender.getElements().getAndUseRandomElements();
        attacker.doesDamageTo(defender, dmg);
    }
}
