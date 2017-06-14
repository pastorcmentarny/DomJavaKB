package dms.pastor.game.dcs.spells;

import dms.pastor.game.dcs.Config;
import dms.pastor.game.dcs.Elements;
import dms.pastor.game.dcs.conditions.ConditionType;
import dms.pastor.game.dcs.units.Unit;

import java.util.Random;

/**
 * Author Dominik Symonowicz
 * Created 2015-07-26
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class MagicStone extends Spell {

    public MagicStone() {
        super();
        name = "Magic Stone";
        setElements(new Elements(1, 1, 0, 0));
    }

    @Override
    public void castSpell(Unit attacker, Unit defender) {
        System.out.println(attacker.getName() + " casting magic stone.. " + defender.getName());
        defender.doesDamageTo(attacker, Config.MAGIC_STONE_DMG);
        Random random = new Random();
        if (15 >= random.nextInt(100)) {
            if (defender.isStrongShield()) {
                System.out.println("StrongShield  protect " + defender.getName() + " from being stunned.");
            } else {
                System.out.println(defender.getName() + "  is stunned after being hit by stone.");
                defender.getConditions().add(ConditionType.STUNNED, 1);
            }

        }
    }
}
