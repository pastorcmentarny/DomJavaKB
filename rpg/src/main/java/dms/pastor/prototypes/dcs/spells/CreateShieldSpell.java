package dms.pastor.prototypes.dcs.spells;

import dms.pastor.prototypes.dcs.Elements;
import dms.pastor.prototypes.dcs.units.Unit;

import static dms.pastor.prototypes.dcs.Config.INITIAL_SHIELD_POINTS;

/**
 * Author Dominik Symonowicz
 * Created 2015-07-29
 * WWW:	<a href="https://dominiksymonowicz.com/">HOME PAGE</a>
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class CreateShieldSpell extends Spell {

    public CreateShieldSpell() {
        setName("Create a shield");
        setElements(new Elements(0, 2, 0, 2));
    }

    @Override
    public void castSpell(Unit attacker, Unit defender) {
        castSpellMessage(attacker.getName(), getName(), attacker.getName());
        if (attacker.isShielded()) {
            System.out.println("You have magic shield already.");
        } else {
            attacker.createShield(INITIAL_SHIELD_POINTS);
        }
    }
}
