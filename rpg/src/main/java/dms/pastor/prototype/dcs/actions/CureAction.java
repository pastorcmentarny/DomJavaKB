package dms.pastor.prototype.dcs.actions;

import dms.pastor.prototype.dcs.conditions.ConditionType;
import dms.pastor.prototype.dcs.spells.CureSpell;
import dms.pastor.prototype.dcs.units.Unit;

public class CureAction implements Action {

    public void perform(Unit caster, Unit target) {
        if (target.getConditions().has(ConditionType.BLIND) || target.getConditions().has(ConditionType.POISONED) || target.getConditions().has(ConditionType.WEAKNESS)) {
            CureSpell cureSpell = new CureSpell();
            cureSpell.castSpellIfHasEnoughElements(caster, target);
        }
    }
}
