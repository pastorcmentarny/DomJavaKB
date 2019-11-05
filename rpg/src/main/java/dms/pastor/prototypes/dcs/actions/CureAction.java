package dms.pastor.prototypes.dcs.actions;

import dms.pastor.prototypes.dcs.conditions.ConditionType;
import dms.pastor.prototypes.dcs.spells.CureSpell;
import dms.pastor.prototypes.dcs.units.Unit;

public class CureAction implements Action {

    public void perform(Unit caster, Unit target) {
        if (target.getConditions().has(ConditionType.BLIND) || target.getConditions().has(ConditionType.POISONED) || target.getConditions().has(ConditionType.WEAKNESS)) {
            CureSpell cureSpell = new CureSpell();
            cureSpell.castSpellIfHasEnoughElements(caster, target);
        }
    }
}
