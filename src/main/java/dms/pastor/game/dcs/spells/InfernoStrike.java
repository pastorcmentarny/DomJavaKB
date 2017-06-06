package dms.pastor.game.dcs.spells;

import dms.pastor.game.dcs.Config;
import dms.pastor.game.dcs.Elements;
import dms.pastor.game.dcs.units.Unit;

import java.util.Random;

/**
 * Author Dominik Symonowicz
 * Created 2015-07-27
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
public class InfernoStrike extends Spell {
    private final Random random = new Random();

    public InfernoStrike() {
        super();
        name = "Inferno Strike";
        setElements(new Elements(1, 2, 2, 0, 0, 0));
    }

    @Override
    public void castSpell(Unit attacker, Unit defender) {
        System.out.println(attacker.getName() + " casting meteor strike.. " + defender.getName());
        for (int i = 1; i <= Config.INFERNO_STRIKE_NO; i++) {
            int r = random.nextInt(100);
            if (r >= 60) {
                System.out.println("It hits " + defender.getName());
                defender.doesDamage(Config.INFERNO_STRIKE__DMG, attacker);
            } else {
                System.out.println("IT hit" + attacker.getName());
                attacker.doesDamage(Config.INFERNO_STRIKE__DMG, attacker);
            }
        }
    }
}