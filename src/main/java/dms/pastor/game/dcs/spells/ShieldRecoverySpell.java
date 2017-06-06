package dms.pastor.game.dcs.spells;

import dms.pastor.game.dcs.Config;
import dms.pastor.game.dcs.Elements;
import dms.pastor.game.dcs.units.Unit;

/**
 * Author Dominik Symonowicz
 * Created 2015-07-29
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
public class ShieldRecoverySpell extends Spell {
    public ShieldRecoverySpell() {
        super();
        name = "Stregthing shield";
        setElements(new Elements(1, 0, 0, 0, 2, 0));
    }

    @Override
    public void castSpell(Unit attacker, Unit defender) {
        System.out.println(attacker.getName() + " casting " + name);
        if (attacker.hasMagicShield()) {
            attacker.increaseShieldBy(Config.SHIELD_HEAL);
            System.out.println("Shield increased by" + Config.SHIELD_HEAL);
        } else {
            System.out.println("You need have to magic shield");
        }
    }
}