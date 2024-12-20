package dms.pastor.prototypes.dcs.spells;

import dms.pastor.prototypes.dcs.Elements;
import dms.pastor.prototypes.dcs.units.Unit;

import static dms.pastor.prototypes.dcs.Config.SHIELD_HEAL;

/**
 * Author Dominik Symonowicz
 * Created 2015-07-29
 * WWW:	<a href="https://dominiksymonowicz.com/">HOME PAGE</a>
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class ShieldRecoverySpell extends Spell {

    public ShieldRecoverySpell() {
        setName("Strengthening shield");
        setElements(new Elements(2, 1, 1, 2));
    }

    @Override
    public void castSpell(Unit attacker, Unit defender) {
        castSpellMessage(attacker.getName(), getName(), defender.getName());
        if (attacker.isShielded()) {
            attacker.increaseShieldBy(SHIELD_HEAL);
            System.out.println("Shield increased by" + SHIELD_HEAL);
        } else {
            System.out.println("What I waste of mana! You need to have to magic shield first.");
        }
    }
}
