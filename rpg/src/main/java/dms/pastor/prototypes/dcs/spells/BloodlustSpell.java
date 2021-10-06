package dms.pastor.prototypes.dcs.spells;

import dms.pastor.prototypes.dcs.Elements;
import dms.pastor.prototypes.dcs.conditions.ConditionEntry;
import dms.pastor.prototypes.dcs.conditions.ConditionType;
import dms.pastor.prototypes.dcs.units.Unit;

import static dms.pastor.prototypes.dcs.Config.BLOODLUST_TURNS;

/**
 * Author Dominik Symonowicz
 * Created 2015-07-28
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class BloodlustSpell extends Spell {

    public BloodlustSpell() {
        setName("Bloodlust");
        setElements(new Elements(0, 0, 0, 4));
    }

    @Override
    public void castSpell(Unit attacker, Unit defender) {
        castSpellMessage(attacker.getName(), getName(), attacker.getName());
        attacker.getConditions().add(ConditionEntry.createTemporaryCondition(ConditionType.BLOODLUST, BLOODLUST_TURNS));
    }
}
