package dms.pastor.prototypes.dcs.spells;

import dms.pastor.prototypes.dcs.Elements;
import dms.pastor.prototypes.dcs.conditions.ConditionEntry;
import dms.pastor.prototypes.dcs.conditions.ConditionType;
import dms.pastor.prototypes.dcs.units.Unit;

import static dms.pastor.prototypes.dcs.Config.REGEN_TURNS;

/**
 * Author Dominik Symonowicz
 * Created 2015-07-27
 * WWW:	<a href="https://dominiksymonowicz.com/">HOME PAGE</a>
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class RegenSpell extends Spell {
    public RegenSpell() {
        setName("Regeneration");
        setElements(new Elements(2, 0, 0, 2));
    }

    @Override
    public void castSpell(Unit attacker, Unit defender) {
        castSpellMessage(attacker.getName(), getName(), attacker.getName());
        attacker.getConditions().add(ConditionEntry.createTemporaryCondition(ConditionType.REGENERATION, REGEN_TURNS));
    }
}
