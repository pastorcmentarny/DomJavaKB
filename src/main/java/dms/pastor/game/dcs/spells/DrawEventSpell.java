package dms.pastor.game.dcs.spells;

import dms.pastor.game.dcs.Elements;
import dms.pastor.game.dcs.events.EventGenerator;
import dms.pastor.game.dcs.units.Unit;

/**
 * Author Dominik Symonowicz
 * Created 2015-07-29
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
public class DrawEventSpell extends Spell {
    public DrawEventSpell() {
        super();
        name = "Draw an event";
        setElements(new Elements(0, 0, 0, 3, 1, 0));
    }

    @Override
    public void castSpell(Unit attacker, Unit defender) {
        System.out.println("Casting " + name + " spell.");
        EventGenerator.event(attacker, attacker);
        EventGenerator.event(attacker, attacker);
        EventGenerator.event(attacker, attacker);
    }
}
