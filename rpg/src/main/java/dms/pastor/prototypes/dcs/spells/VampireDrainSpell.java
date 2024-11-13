package dms.pastor.prototypes.dcs.spells;

import dms.pastor.prototypes.dcs.Elements;
import dms.pastor.prototypes.dcs.units.Unit;

import static dms.pastor.prototypes.dcs.Config.VAMPIRE_DRAIN_DMG;
import static dms.pastor.prototypes.dcs.Config.VAMPIRE_DRAIN_HEAL_HP;

/**
 * Author Dominik Symonowicz
 * Created 2015-07-29
 * WWW:	<a href="https://dominiksymonowicz.com/">HOME PAGE</a>
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class VampireDrainSpell extends Spell {

    public VampireDrainSpell() {
        setName("Vampire Drain");
        setElements(new Elements(2, 2, 2, 0));
    }

    @Override
    public void castSpell(Unit attacker, Unit defender) {
        castSpellMessage(attacker.getName(), getName(), defender.getName());
        int dmg = attacker.doesDamageTo(defender, VAMPIRE_DRAIN_DMG);
        if (dmg >= 5 && !defender.isStrongShield()) {
            attacker.addHP(VAMPIRE_DRAIN_HEAL_HP);
            System.out.println("Vampire drain does " + dmg + " dmg to " + defender.getName() + " and " + attacker.getName() + " drain " + VAMPIRE_DRAIN_HEAL_HP + " dmg.");
        }
    }
}
