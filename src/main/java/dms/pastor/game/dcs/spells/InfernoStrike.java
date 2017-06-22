package dms.pastor.game.dcs.spells;

import dms.pastor.game.dcs.Config;
import dms.pastor.game.dcs.Elements;
import dms.pastor.game.dcs.units.Unit;

import java.util.Random;

/**
 * Author Dominik Symonowicz
 * Created 2015-07-27
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class InfernoStrike extends Spell {

    private static final String HIT_MESSAGE = "It hits ";
    private final Random random = new Random();

    public InfernoStrike() {
        super();
        name = "Inferno Strike";
        setElements(new Elements(1, 2, 2, 0));
    }

    @Override
    public void castSpell(Unit attacker, Unit defender) {
        castSpellMessage(attacker.getName(), name, defender.getName());
        for (int i = 1; i <= Config.INFERNO_STRIKE_NO; i++) {
            int r = random.nextInt(100);
            if (r >= 60) {
                System.out.println(HIT_MESSAGE + defender.getName());
                attacker.doesDamageTo(defender, Config.INFERNO_STRIKE_DMG);
            } else {
                System.out.println(HIT_MESSAGE + attacker.getName());
                attacker.doesDamageTo(attacker, Config.INFERNO_STRIKE_DMG);
            }
        }
    }
}
