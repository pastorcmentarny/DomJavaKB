package dms.pastor.game.dcs.spells;

import dms.pastor.game.dcs.Elements;
import dms.pastor.game.dcs.units.Unit;

import static dms.pastor.game.dcs.Config.DEFAULT_CONDITION_DURATION;
import static dms.pastor.game.dcs.conditions.ConditionEntry.createTemporaryConditionWithDefaultDuration;
import static dms.pastor.game.dcs.conditions.ConditionType.WEAKNESS;
import static dms.pastor.game.dcs.utils.random.InGameRandomUtils.THREE_QUATER;

/**
 * Author Dominik Symonowicz
 * Created 2015-07-29
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class WeaknessSpell extends Spell {

    public WeaknessSpell() {
        name = "Weakness Spell";
        setElements(new Elements(0, 1, 0, 0));
    }

    @Override
    public void castSpell(Unit attacker, Unit defender) {
        castSpellMessage(attacker.getName(), name, defender.getName());
        if (randomUtils.isWillHappenWithProbabilityOf(THREE_QUATER)) {
            defender.getConditions().add(createTemporaryConditionWithDefaultDuration(WEAKNESS));
            System.out.println(defender.getName() + " is weak for " + DEFAULT_CONDITION_DURATION + " turns.");
        } else {
            System.out.println(defender.getName() + " resits.");
        }
    }
}
