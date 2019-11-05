package dms.pastor.prototypes.dcs.spells;

import dms.pastor.prototypes.dcs.Elements;
import dms.pastor.prototypes.dcs.conditions.ConditionEntry;
import dms.pastor.prototypes.dcs.units.Unit;

import static dms.pastor.prototypes.dcs.Config.POISON_TURNS;
import static dms.pastor.prototypes.dcs.conditions.ConditionType.POISONED;
import static dms.pastor.prototypes.dcs.conditions.ConditionType.POISON_IMMUNITY;

public class PoisonSpell extends Spell {
    public PoisonSpell() {
        super();
        name = "Poison";
        setElements(new Elements(0, 2, 0, 1));
    }

    @Override
    public void castSpell(Unit attacker, Unit defender) {
        System.out.println(attacker.getName() + " casting poison spell.");
        if (defender.getConditions().hasNot(POISON_IMMUNITY)) {
            defender.getConditions().add(ConditionEntry.createTemporaryCondition(POISONED, POISON_TURNS));
            System.out.println(defender.getName() + " got poisoned for " + POISON_TURNS + " turns.");
        } else {
            System.out.println(defender.getName() + " resists against poison.");
        }
    }
}
