package dms.pastor.game.dcs.spells;

import dms.pastor.game.dcs.Elements;
import dms.pastor.game.dcs.conditions.ConditionEntry;
import dms.pastor.game.dcs.units.Unit;

import static dms.pastor.game.dcs.conditions.ConditionType.BUBBLE_SHIELD;

/**
 * Author Dominik Symonowicz
 * Created 04/08/2017
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class BubbleShieldSpell extends Spell {

    public BubbleShieldSpell() {
        name = "Bubble shield";
        setElements(new Elements(3, 1, 1, 1));
    }

    @Override
    public void castSpell(Unit attacker, Unit defender) {
        castSpellMessage(attacker.getName(), name, defender.getName());
        attacker.getConditions().add(ConditionEntry.createTemporaryCondition(BUBBLE_SHIELD, 20));
    }
}
