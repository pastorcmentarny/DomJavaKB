package dms.pastor.game.dcs.spells;

import dms.pastor.game.dcs.Elements;
import dms.pastor.game.dcs.units.Unit;

import java.util.Random;

import static dms.pastor.game.dcs.Config.MAGIC_STONE_DMG;
import static dms.pastor.game.dcs.conditions.ConditionType.EARTH_IMMUNE;
import static dms.pastor.game.dcs.conditions.ConditionType.STUNNED;

/**
 * Author Dominik Symonowicz
 * Created 2015-07-26
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class MagicStoneSpell extends Spell {

    public MagicStoneSpell() {
        super();
        name = "Magic Stone";
        setElements(new Elements(0, 2, 0, 0));
    }

    @Override
    public void castSpell(Unit attacker, Unit defender) {
        System.out.println(attacker.getName() + " casting magic stone.. " + defender.getName());
        if (defender.getConditions().has(EARTH_IMMUNE)) {
            System.out.println(defender.getName() + " is immune to " + getName());
        } else {
            defender.doesDamageTo(attacker, MAGIC_STONE_DMG);
            Random random = new Random();
            if (random.nextInt(100) > 40) {
                if (defender.isStrongShield()) {
                    System.out.println("StrongShield  protect " + defender.getName() + " from being stunned.");
                } else {
                    System.out.println(defender.getName() + "  is stunned after being hit by stone.");
                    defender.getConditions().add(STUNNED, 1);
                }
            }
        }
    }
}
