package dms.pastor.game.dcs.spells;

import dms.pastor.game.dcs.Elements;
import dms.pastor.game.dcs.units.Unit;

import static dms.pastor.game.dcs.Config.ICE_BOLT_DMG;
import static dms.pastor.game.dcs.conditions.ConditionType.FROZEN;
import static dms.pastor.game.dcs.conditions.ElementType.WATER;

/**
 * Author Dominik Symonowicz
 * Created 2015-08-02
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class IceBoltSpell extends Spell {

    public IceBoltSpell() {
        super();
        name = "Ice Bolt";
        setElements(new Elements(0, 0, 0, 3));
    }

    @Override
    public void castSpell(Unit attacker, Unit defender) {
        castSpellMessage(attacker.getName(), name, defender.getName());
        if (defender.getConditions().isNotImmuneTo(WATER)) {
            if (defender.getConditions().has(FROZEN)) {
                System.out.println(defender.getName() + " will get double damage as it is frozen.");
                defender.doesDamageTo(attacker, doubleDamageFor(ICE_BOLT_DMG));
            } else {
                defender.doesDamageTo(attacker, ICE_BOLT_DMG);
            }
        } else {
            System.out.println(defender + " resists spell.");
        }
    }

    private int doubleDamageFor(int dmg) {
        return 2 * dmg;
    }
}
