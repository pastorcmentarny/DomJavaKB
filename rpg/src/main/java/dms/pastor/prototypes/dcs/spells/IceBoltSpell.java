package dms.pastor.prototypes.dcs.spells;

import dms.pastor.prototypes.dcs.Elements;
import dms.pastor.prototypes.dcs.conditions.ConditionType;
import dms.pastor.prototypes.dcs.conditions.ElementType;
import dms.pastor.prototypes.dcs.units.Unit;
import dms.pastor.prototypes.dcs.utils.UnitUtils;

import static dms.pastor.prototypes.dcs.Config.ICE_BOLT_DMG;

/**
 * Author Dominik Symonowicz
 * Created 2015-08-02
 * WWW:	<a href="https://dominiksymonowicz.com/">HOME PAGE</a>
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class IceBoltSpell extends Spell {

    public IceBoltSpell() {
        setName("Ice Bolt");
        setElements(new Elements(0, 0, 0, 3));
    }

    @Override
    public void castSpell(Unit attacker, Unit defender) {
        castSpellMessage(attacker.getName(), getName(), defender.getName());
        if (defender.getConditions().isNotImmuneTo(ElementType.WATER)) {
            if (defender.getConditions().has(ConditionType.FROZEN)) {
                System.out.println(defender.getName() + " will get double damage as it is frozen.");
                defender.doesDamageTo(attacker, UnitUtils.doubleDamageFor(ICE_BOLT_DMG));
            } else {
                defender.doesDamageTo(attacker, ICE_BOLT_DMG);
            }
        } else {
            System.out.println(defender + " resists spell.");
        }
    }
}
