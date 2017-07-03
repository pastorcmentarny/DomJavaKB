package dms.pastor.game.dcs.units.enemies.actions;

import dms.pastor.game.dcs.conditions.ConditionType;
import dms.pastor.game.dcs.spells.CureSpell;
import dms.pastor.game.dcs.units.Unit;

public class CureAction implements Action {

    public void perform(Unit caster, Unit target) {
        if (target.getConditions().has(ConditionType.BLIND) || target.getConditions().has(ConditionType.POISONED) || target.getConditions().has(ConditionType.WEAKNESS)) {
            CureSpell cureSpell = new CureSpell();
            cureSpell.castSpellIfHasEnoughElements(caster, target);
        }
    }
}
