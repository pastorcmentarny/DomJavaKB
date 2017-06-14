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
public class AntiShieldPiercingSpell extends Spell {

    public AntiShieldPiercingSpell() {
        super();
        name = "Anti shield piercing spell";
        setElements(new Elements(1, 1, 1, 1, 0, 0));
    }


    @Override
    public void castSpell(Unit attacker, Unit defender) {
        System.out.println(attacker.getName() + " casting  " + name + " on" + defender.getName());
        if (defender.hasMagicShield()) {
            defender.doesShieldDamage(Config.ASP_DMG);
        } else {
            System.out.println("magic bounced from " + defender.getName() + " and hit" + attacker.getName());
            attacker.doesDirectDamage(Config.PENALTY_DMG);
        }

    }


}
