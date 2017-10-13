package dms.pastor.game.dcs.spells;

import dms.pastor.game.dcs.Elements;
import dms.pastor.game.dcs.units.Unit;

import static dms.pastor.game.dcs.Config.BLOODLUST_TURNS;
import static dms.pastor.game.dcs.conditions.ConditionEntry.createTemporaryCondition;
import static dms.pastor.game.dcs.conditions.ConditionType.BLOODLUST;

/**
 * Author Dominik Symonowicz
 * Created 2015-07-28
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class BloodlustSpell extends Spell {

    public BloodlustSpell() {
        name = "Bloodlust";
        setElements(new Elements(0, 0, 0, 4));
    }

    @Override
    public void castSpell(Unit attacker, Unit defender) {
        castSpellMessage(attacker.getName(), name, attacker.getName());
        attacker.getConditions().add(createTemporaryCondition(BLOODLUST, BLOODLUST_TURNS));
    }
}
