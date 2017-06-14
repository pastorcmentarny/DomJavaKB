package dms.pastor.game.dcs.spells;

import dms.pastor.game.dcs.Config;
import dms.pastor.game.dcs.Elements;
import dms.pastor.game.dcs.conditions.ElementType;
import dms.pastor.game.dcs.units.Unit;

/**
 * Author Dominik Symonowicz
 * Created 2015-07-23
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class FireBall extends Spell {
    public FireBall() {
        super();
        name = "Fireball";
        setElements(new Elements(0, 0, 3, 0, 0, 0));
    }

    @Override
    public void castSpell(Unit attacker, Unit defender) {
        System.out.println(attacker.getName() + " casting fireball.. " + defender.getName());
        if (defender.getConditions().isNotImmuneTo(ElementType.FIRE)) {
            attacker.doesDamageTo(defender, Config.FIREBALL_DMG);
        } else {
            System.out.println(defender + " resists spell.");
        }
    }

}
