package dms.pastor.prototypes.dcs.units.enemies;

import dms.pastor.prototypes.dcs.conditions.ConditionEntry;
import dms.pastor.prototypes.dcs.conditions.ConditionType;
import dms.pastor.prototypes.dcs.spells.*;
import dms.pastor.prototypes.dcs.units.Unit;
import dms.pastor.prototypes.dcs.utils.Names;

public class Witch extends Unit {

    private static final int INITIAL_HP = 200;

    public Witch() {
        setName(Names.getRandomMummyName());
        getHealth().setHp(INITIAL_HP);
        setSp(0);
        getHealth().setArm(1);
        getConditions().add(ConditionEntry.createPersistentCondition(ConditionType.FIRE_SENSITIVE));
        getConditions().add(ConditionEntry.createPersistentCondition(ConditionType.MINDLESS));
    }

    @Override
    public void turn(Unit enemy) {
        WeaknessSpell weaknessSpell = new WeaknessSpell();
        RegenSpell regenSpell = new RegenSpell();
        PoisonSpell poisonSpell = new PoisonSpell();
        DeathRaySpell deathRaySpell = new DeathRaySpell();
        MagneticDrainSpell magneticDrainSpell = new MagneticDrainSpell();
        weaknessSpell.castSpell(this, enemy);

        if (getHealth().isHealthLow() && regenSpell.hasEnoughElementsToCovertToSpell(getElements())) {
            regenSpell.castSpell(this, this);
            getElements().useElements(regenSpell.getElements());
        }

        if (enemy.getConditions().hasNot(ConditionType.POISONED) && regenSpell.hasEnoughElementsToCovertToSpell(getElements())) {
            poisonSpell.castSpell(this, enemy);
            getElements().useElements(regenSpell.getElements());
        }

        if (deathRaySpell.hasEnoughElementsToCovertToSpell(getElements())) {
            deathRaySpell.castSpell(this, enemy);
            getElements().useElements(deathRaySpell.getElements());
        }

        if (magneticDrainSpell.hasEnoughElementsToCovertToSpell(getElements())) {
            magneticDrainSpell.castSpell(this, enemy);
            getElements().useElements(magneticDrainSpell.getElements());
        }

    }


}
