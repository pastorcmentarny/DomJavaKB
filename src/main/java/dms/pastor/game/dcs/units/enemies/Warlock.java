package dms.pastor.game.dcs.units.enemies;

import dms.pastor.game.dcs.spells.*;
import dms.pastor.game.dcs.units.Unit;

import static dms.pastor.game.dcs.conditions.ConditionEntry.createPersistentCondition;
import static dms.pastor.game.dcs.conditions.ConditionType.*;

public class Warlock extends Unit {

    private boolean hasInfoAboutEnemy = false;

    public Warlock() {
        setSp(48);
        setArm(2);
        getConditions().add(createPersistentCondition(FIRE_RESISTANT));
        getConditions().add(createPersistentCondition(EARTH_RESISTANT));
    }

    @Override
    public void turn(Unit enemy) {

        InfoSpell infoSpell = new InfoSpell();

        if (hasInfoAboutEnemy) {
            if (enemy.getConditions().has(AIR_SENSITIVE)) {
                new LightingBoltSpell().castSpellAsLongAsItHasEnoughElements(this, enemy);
            }
            if (enemy.getConditions().has(EARTH_SENSITIVE)) {
                new MagicStoneSpell().castSpellAsLongAsItHasEnoughElements(this, enemy);
            }
            if (enemy.getConditions().has(FIRE_SENSITIVE)) {
                new FireBallSpell().castSpellAsLongAsItHasEnoughElements(this, enemy);
            }
            if (enemy.getConditions().has(WATER_SENSITIVE)) {
                new IceBoltSpell().castSpellIfHasEnoughElements(this, enemy);
            }

            if (random.nextBoolean()) {
                new MagneticDrainSpell().castSpellIfHasEnoughElements(this, enemy);
            } else if (random.nextBoolean() && random.nextBoolean()) {
                new VampireDrainSpell().castSpellIfHasEnoughElements(this, enemy);
            }

        } else {
            if (infoSpell.hasEnoughElementsToCovertToSpell(getElements())) {
                hasInfoAboutEnemy = true;
            }
            new BubbleShieldSpell().castSpellIfHasEnoughElements(this, enemy);
        }

        if (!isStrongShield()) {
            new ShieldRecoverySpell().castSpellIfHasEnoughElements(this, enemy);
        }

        if (getHealth().isHealthLow()) {
            new HealSpell().castSpellIfHasEnoughElements(this, enemy);
        }

    }
}

