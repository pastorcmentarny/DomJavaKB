package dms.pastor.game.dcs.spells;

import dms.pastor.game.dcs.Elements;
import dms.pastor.game.dcs.events.EventGenerator;
import dms.pastor.game.dcs.units.Unit;

/**
 * Author Dominik Symonowicz
 * Created 2015-07-30
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
public class CursedEventSpell extends Spell {
    public CursedEventSpell() {
        super();
        name = "Draw an event";
        setElements(new Elements(2, 0, 2, 0, 0, 1));
    }

    @Override
    public void castSpell(Unit attacker, Unit defender) {
        EventGenerator.badEvent(defender);
    }
}
