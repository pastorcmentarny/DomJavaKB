package dms.pastor.prototypes.dcs.spells;

import dms.pastor.prototypes.dcs.Elements;
import dms.pastor.prototypes.dcs.conditions.ConditionEntry;
import dms.pastor.prototypes.dcs.conditions.ConditionType;
import dms.pastor.prototypes.dcs.units.Unit;

import static dms.pastor.prototypes.dcs.Config.MAGIC_STONE_DMG;
import static dms.pastor.prototypes.dcs.utils.random.InGameRandomUtils.THREE_QUARTERS;

/**
 * Author Dominik Symonowicz
 * Created 2015-07-26
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class MagicStoneSpell extends Spell {

    public MagicStoneSpell() {
        setName("Magic Stone");
        setElements(new Elements(0, 2, 0, 0));
    }

    @Override
    public void castSpell(Unit attacker, Unit defender) {
        castSpellMessage(attacker.getName(), getName(), defender.getName());
        if (defender.getConditions().has(ConditionType.EARTH_IMMUNE)) {
            System.out.println(defender.getName() + " is immune to " + getName());
        } else {
            defender.doesDamageTo(attacker, MAGIC_STONE_DMG);
            if (randomUtils.isWillHappenWithProbabilityOf(THREE_QUARTERS)) {
                if (defender.isStrongShield()) {
                    System.out.println("StrongShield  protect " + defender.getName() + " from being stunned.");
                } else {
                    System.out.println(defender.getName() + "  is stunned after being hit by stone.");
                    defender.getConditions().add(ConditionEntry.createTemporaryCondition(ConditionType.STUNNED, 1));
                }
            }
        }
    }
}
