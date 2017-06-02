package dms.pastor.game.dcs.spells;

import dms.pastor.game.dcs.Config;
import dms.pastor.game.dcs.Elements;
import dms.pastor.game.dcs.units.Unit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Author Dominik Symonowicz
 * Created 2015-07-29
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
public class BackstabSpell extends Spell {
    private static final Logger LOGGER = LoggerFactory.getLogger(BackstabSpell.class);

    public BackstabSpell() {
        super();
        name = "Backstab spell";
        setElements(new Elements(0, 2, 0, 0, 0, 1));
    }

    @Override
    public void castSpell(Unit attacker, Unit defender) {
        LOGGER.debug(attacker.getName() + " casting " + name + " on " + defender.getName());
        defender.doesDirectDamage(Config.BACKSTAB_DMG);
    }
}
