package dms.pastor.game.dcs.units.enemies;

import dms.pastor.game.dcs.spells.*;
import dms.pastor.game.dcs.units.Unit;

import static dms.pastor.game.dcs.conditions.ConditionEntry.createPersistentCondition;
import static dms.pastor.game.dcs.conditions.ConditionType.*;
import static dms.pastor.game.dcs.utils.Names.getRandomMummyName;

public class Witch extends Unit {

    private static final int INITIAL_HP = 200;
    private static final double QUARTER = 0.25;

    public Witch() {
        setName(getRandomMummyName());
        setHp(INITIAL_HP);
        setSp(0);
        getConditions().add(createPersistentCondition(FIRE_SENSITIVE));
        getConditions().add(createPersistentCondition(MINDLESS));
    }

    @Override
    public void turn(Unit enemy) {
        WeaknessSpell weaknessSpell = new WeaknessSpell();
        RegenSpell regenSpell = new RegenSpell();
        PoisonSpell poisonSpell = new PoisonSpell();
        DeathRaySpell deathRaySpell = new DeathRaySpell();
        MagneticDrainSpell magneticDrainSpell = new MagneticDrainSpell();
        weaknessSpell.castSpell(this, enemy);

        if (isHealthLow() && regenSpell.hasEnoughElementsToCovertToSpell(getElements())) {
            regenSpell.castSpell(this, this);
            getElements().useElements(regenSpell.getElements());
        }

        if (enemy.getConditions().hasNot(POISONED) && regenSpell.hasEnoughElementsToCovertToSpell(getElements())) {
            poisonSpell.castSpell(this, enemy);
            getElements().useElements(regenSpell.getElements());
        }

        if(deathRaySpell.hasEnoughElementsToCovertToSpell(getElements())){
            deathRaySpell.castSpell(this, enemy);
            getElements().useElements(deathRaySpell.getElements());
        }

        if(magneticDrainSpell.hasEnoughElementsToCovertToSpell(getElements())){
            magneticDrainSpell.castSpell(this,enemy);
            getElements().useElements(magneticDrainSpell.getElements());
        }

    }

    private boolean isHealthLow() {
        return getHp() < QUARTER * getMaxHp();
    }
}
