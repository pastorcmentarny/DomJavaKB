package dms.pastor.game.dcs.spells;

import dms.pastor.game.dcs.Config;
import dms.pastor.game.dcs.Elements;
import dms.pastor.game.dcs.conditions.ElementType;
import dms.pastor.game.dcs.units.Unit;

/**
 * Author Dominik Symonowicz
 * Created 2015-08-02
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
public class IceBoltSpell extends Spell {
    public IceBoltSpell() {
        super();
        name = "Ice Bolt";
        setElements(new Elements(0, 0, 0, 3, 0, 0));
    }

    @Override
    public void castSpell(Unit attacker, Unit defender) {
        System.out.println(attacker.getName() + " casting ice bolt.. " + defender.getName());
        if (defender.getConditions().isNotImmuneTo(ElementType.WATER)) {
            defender.doesDamage(Config.ICE_BOLT_DMG, attacker);
        } else {
            System.out.println(defender + " resists spell");
        }
    }
}
