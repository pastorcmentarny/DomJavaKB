package dms.pastor.game.dcs.spells;

import dms.pastor.game.dcs.Elements;
import dms.pastor.game.dcs.units.Unit;

import java.util.Random;

import static dms.pastor.game.dcs.conditions.ConditionType.WEAKNESS;

/**
 * Author Dominik Symonowicz
 * Created 2015-07-29
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
public class WeaknessSpell extends Spell {
    public WeaknessSpell() {
        super();
        name = "Weakness Spell";
        setElements(new Elements(0, 1, 0, 0, 0, 1));
    }

    @Override
    public void castSpell(Unit attacker, Unit defender) {
        System.out.println(attacker.getName() + " casting weakness.. " + defender.getName());
        if (new Random().nextInt(100) > 75) {
            final int turns = 2;
            defender.getConditions().add(WEAKNESS, turns);
            System.out.println(defender.getName() + " is weak for " + turns + " turns.");
        } else {
            System.out.println(defender.getName() + " resits.");
        }
    }
}
