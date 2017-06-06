package dms.pastor.game.dcs.spells;

import dms.pastor.game.dcs.Config;
import dms.pastor.game.dcs.Elements;
import dms.pastor.game.dcs.conditions.ConditionType;
import dms.pastor.game.dcs.units.Unit;

import java.util.Random;

/**
 * Author Dominik Symonowicz
 * Created 2015-07-26
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
public class MagicStone extends Spell {

    public MagicStone() {
        super();
        name = "Magic Stone";
        setElements(new Elements(1, 1, 0, 0, 0, 0));
    }

    @Override
    public void castSpell(Unit attacker, Unit defender) {
        System.out.println(attacker.getName() + " casting magic stone.. " + defender.getName());
        defender.doesDamage(Config.MAGIC_STONE_DMG, attacker);
        Random random = new Random();
        if (15 >= random.nextInt(100)) {
            if (defender.isStrongShield()) {
                System.out.println("StrongShield  protect " + defender.getName() + " from being stunned.");
            } else {
                System.out.println(defender.getName() + "  is stunned after being hit by stone.");
                defender.getCondition().add(ConditionType.STUNNED, 1);
            }

        }
    }
}