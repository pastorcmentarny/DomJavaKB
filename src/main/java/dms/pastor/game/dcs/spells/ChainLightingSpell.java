package dms.pastor.game.dcs.spells;

import dms.pastor.game.dcs.Elements;
import dms.pastor.game.dcs.units.Unit;

/**
 * Author Dominik Symonowicz
 * Created 2015-07-27
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
public class ChainLightingSpell extends Spell {
    public ChainLightingSpell() {
        super();
        name = "Chain Lighting";
        setElements(new Elements(3, 0, 1, 0, 0, 0));
    }

    @Override
    public void castSpell(Unit attacker, Unit defender) {
        System.out.println(attacker.getName() + " casting " + name);
        attacker.doesDamage(4, defender);
        attacker.doesDamage(2, defender);
        attacker.doesDamage(1, defender);
    }
}