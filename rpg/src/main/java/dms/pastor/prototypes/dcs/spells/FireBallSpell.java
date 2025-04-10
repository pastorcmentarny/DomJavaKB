package dms.pastor.prototypes.dcs.spells;

import dms.pastor.prototypes.dcs.Config;
import dms.pastor.prototypes.dcs.Elements;
import dms.pastor.prototypes.dcs.conditions.ConditionType;
import dms.pastor.prototypes.dcs.conditions.ElementType;
import dms.pastor.prototypes.dcs.units.Unit;

/**
 * Author Dominik Symonowicz
 * Created 2015-07-23
 * WWW:	<a href="https://dominiksymonowicz.com/">HOME PAGE</a>
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class FireBallSpell extends Spell {

    public FireBallSpell() {
        setName("Fireball");
        setElements(new Elements(0, 0, 3, 0));
    }

    @Override
    public void castSpell(Unit attacker, Unit defender) {
        Spell.castSpellMessage(attacker.getName(), getName(), defender.getName());
        if (defender.getConditions().isNotImmuneTo(ElementType.FIRE)) {
            attacker.doesDamageTo(defender, Config.FIREBALL_DMG);
        } else {
            if (defender.getConditions().has(ConditionType.FIRE_IMMUNE)) {
                final int heal = Config.FIREBALL_DMG / 2;
                System.out.println(defender + " was heal " + heal + " points by " + getName());
                defender.addHP(heal);
            }
            System.out.println(defender + " resists spell.");
        }
    }

}
