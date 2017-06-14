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
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class HealSpell extends Spell {

    public HealSpell() {
        super();
        name = "Heal";
        setElements(new Elements(2, 0, 0, 1));
    }

    @Override
    public void castSpell(Unit attacker, Unit defender) {
        System.out.println("Casting heal.. on " + attacker.getName());
        attacker.addHP(HEAL);
    }

}
