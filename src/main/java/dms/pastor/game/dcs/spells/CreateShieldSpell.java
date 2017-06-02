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
public class CreateShieldSpell extends Spell {
    public CreateShieldSpell() {
        super();
        name = "Create a shield";
        setElements(new Elements(0, 1, 0, 1, 3, 0));
    }

    @Override
    public void castSpell(Unit attacker, Unit defender) {
        System.out.println(attacker.getName() + " casting " + name);
        if (attacker.hasMagicShield()) {
            System.out.println("You are  have to magic shield");
        } else {
            attacker.createShield(Config.INITIAL_SHIELD_POINTS);
        }
    }
}
