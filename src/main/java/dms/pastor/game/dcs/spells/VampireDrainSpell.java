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
public class VampireDrainSpell extends Spell {
    public VampireDrainSpell() {
        super();
        name = "Vampire Drain";
        setElements(new Elements(1, 0, 0, 0, 1, 1));
    }


    @Override
    public void castSpell(Unit attacker, Unit defender) {
        System.out.println(attacker.getName() + " casting .. " + name + " on " + defender.getName());
        int dmg = attacker.doesDamageTo(defender, Config.VAMPIRE_DRAIN_DMG);
        if (dmg >= 3) {
            attacker.addHP(Config.VAMPIRE_DRAIN_HEAL_HP);
            System.out.println("Vampiring drain does " + dmg + " to " + defender.getName() + " abd " + attacker.getName() + " got " + Config.VAMPIRE_DRAIN_HEAL_HP);
        }
    }
}
