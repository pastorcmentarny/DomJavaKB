package dms.pastor.prototype.dcs.spells;

import dms.pastor.prototype.dcs.Elements;
import dms.pastor.prototype.dcs.conditions.ConditionEntry;
import dms.pastor.prototype.dcs.conditions.ConditionType;
import dms.pastor.prototype.dcs.units.Unit;

import static dms.pastor.prototype.dcs.Config.REGEN_TURNS;

/**
 * Author Dominik Symonowicz
 * Created 2015-07-27
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
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
