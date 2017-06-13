package dms.pastor.game.dcs.spells;

import dms.pastor.game.dcs.Elements;
import dms.pastor.game.dcs.units.Unit;

import static dms.pastor.game.dcs.Config.HEAL;

/**
 * Author Dominik Symonowicz
 * Created 2015-07-24
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
public class HealSpell extends Spell {

    public HealSpell() {
        super();
        name = "Heal";
        setElements(new Elements(0, 0, 0, 0, 3, 0));
    }

    @Override
    public void castSpell(Unit attacker, Unit defender) {
        System.out.println("Casting heal.. on " + attacker.getName());
        attacker.addHP(HEAL);
    }

}
