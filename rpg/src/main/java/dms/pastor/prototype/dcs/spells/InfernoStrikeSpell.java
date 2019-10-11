package dms.pastor.prototype.dcs.spells;

import dms.pastor.prototype.dcs.Config;
import dms.pastor.prototype.dcs.Elements;
import dms.pastor.prototype.dcs.units.Unit;

import static dms.pastor.prototype.dcs.Config.INFERNO_STRIKE_DMG;
import static dms.pastor.prototype.dcs.utils.random.InGameRandomUtils.TWO_THIRD;

/**
 * Author Dominik Symonowicz
 * Created 2015-07-27
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class InfernoStrikeSpell extends Spell {

    private static final String HIT_MESSAGE = "It hits ";

    public InfernoStrikeSpell() {
        setName("Inferno Strike");
        setElements(new Elements(1, 2, 2, 0));
    }

    @Override
    public void castSpell(Unit attacker, Unit defender) {
        castSpellMessage(attacker.getName(), getName(), defender.getName());
        for (int i = 1; i <= Config.INFERNO_STRIKE_NO; i++) {
            if (randomUtils.isWillHappenWithProbabilityOf(TWO_THIRD)) {
                System.out.println(HIT_MESSAGE + defender.getName());
                attacker.doesDamageTo(defender, INFERNO_STRIKE_DMG);
            } else {
                System.out.println(HIT_MESSAGE + attacker.getName());
                attacker.doesDamageTo(attacker, INFERNO_STRIKE_DMG);
            }
        }
    }
}
