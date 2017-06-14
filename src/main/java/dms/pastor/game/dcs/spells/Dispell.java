package dms.pastor.game.dcs.spells;

import dms.pastor.game.dcs.Elements;
import dms.pastor.game.dcs.units.Unit;

/**
 * Author Dominik Symonowicz
 * Created 2015-07-31
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class Dispell extends Spell {
    public Dispell() {
        name = "Dispell";
        setElements(new Elements(2, 0, 1, 0));
    }

    @Override
    public void castSpell(Unit attacker, Unit defender) {
        attacker.getConditions().removeAll();
    }
}
