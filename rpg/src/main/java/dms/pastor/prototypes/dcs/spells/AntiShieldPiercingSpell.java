package dms.pastor.prototypes.dcs.spells;

import dms.pastor.prototypes.dcs.Config;
import dms.pastor.prototypes.dcs.Elements;
import dms.pastor.prototypes.dcs.units.Unit;

/**
 * Author Dominik Symonowicz
 * Created 2015-07-29
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class AntiShieldPiercingSpell extends Spell {

    public AntiShieldPiercingSpell() {
        setName("Anti shield piercing spell");
        setElements(new Elements(2, 1, 1, 1));
    }

    @Override
    public void castSpell(Unit attacker, Unit defender) {
        castSpellMessage(attacker.getName(), getName(), defender.getName());
        if (defender.isNotShielded()) {
            defender.doesShieldDamage(Config.ASP_DMG);
        } else {
            System.out.println("magic bounced from " + defender.getName() + " and hit" + attacker.getName());
            attacker.doesDirectDamage(Config.PENALTY_DMG);
        }

    }

}
