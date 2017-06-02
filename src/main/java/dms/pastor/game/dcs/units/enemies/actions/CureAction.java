package dms.pastor.game.dcs.units.enemies.actions;

import dms.pastor.game.dcs.conditions.ConditionType;
import dms.pastor.game.dcs.spells.CureSpell;
import dms.pastor.game.dcs.units.Unit;

public class CureAction implements Action {

    public void perform(Unit caster, Unit target) {
        if (target.getCondition().has(ConditionType.BLIND) || target.getCondition().has(ConditionType.POISONED) || target.getCondition().has(ConditionType.WEAKNESS)) {
            CureSpell cureSpell = new CureSpell();
            if (cureSpell.hasEnoughElementsToCovertToSpell(caster.getElements())) {
                cureSpell.castSpell(caster, target);
                caster.getElements().useElements(cureSpell.getElements());
            }
        }
    }
}
