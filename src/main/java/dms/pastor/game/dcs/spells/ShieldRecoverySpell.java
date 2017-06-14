package dms.pastor.game.dcs.spells;

import dms.pastor.game.dcs.Config;
import dms.pastor.game.dcs.Elements;
import dms.pastor.game.dcs.units.Unit;

/**
 * Author Dominik Symonowicz
 * Created 2015-07-29
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class ShieldRecoverySpell extends Spell {
    public ShieldRecoverySpell() {
        super();
        name = "Strengthening shield";
        setElements(new Elements(2, 1, 1, 1));
    }

    @Override
    public void castSpell(Unit attacker, Unit defender) {
        System.out.println(attacker.getName() + " casting " + name);
        if (attacker.isShielded()) {
            attacker.increaseShieldBy(Config.SHIELD_HEAL);
            System.out.println("Shield increased by" + Config.SHIELD_HEAL);
        } else {
            System.out.println("You need have to magic shield");
        }
    }
}
