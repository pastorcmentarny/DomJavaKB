package dms.pastor.game.dcs.spells;

import dms.pastor.game.dcs.Elements;
import dms.pastor.game.dcs.events.EventGenerator;
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
public class DrawEventSpell extends Spell {

    public DrawEventSpell() {
        name = "Draw an event";
        setElements(new Elements(1, 0, 1, 1));
    }

    @Override
    public void castSpell(Unit attacker, Unit defender) {
        castSpellMessage(attacker.getName(), name, defender.getName());
        EventGenerator.event(attacker, attacker);
        EventGenerator.event(attacker, attacker);
        EventGenerator.event(attacker, attacker);
    }
}
