package dms.pastor.game.dcs.units.enemies;

import dms.pastor.game.dcs.Config;
import dms.pastor.game.dcs.spells.*;
import dms.pastor.game.dcs.units.Unit;

import static dms.pastor.game.dcs.conditions.ConditionEntry.createPersistentCondition;
import static dms.pastor.game.dcs.conditions.ConditionType.*;

public class Wizard extends Unit {
    private boolean hasInfoAboutEnemy = false;

    public Wizard() {
        setSp(Config.INITIAL_SHIELD_POINTS * 3);
        getConditions().add(createPersistentCondition(AIR_RESISTANT));
        getConditions().add(createPersistentCondition(EARTH_RESISTANT));
        getConditions().add(createPersistentCondition(FIRE_RESISTANT));
        getConditions().add(createPersistentCondition(WATER_SENSITIVE));
    }

    @Override
    public void turn(Unit enemy) {

        if (this.getConditions().hasNegativeCondition()) {
            new CureSpell().castSpellIfHasEnoughElements(this, this);
        }
        new MagneticDrainSpell().castSpellIfHasEnoughElements(this, enemy);
        new DeathRaySpell().castSpell(this, enemy);
        new BubbleShieldSpell().castSpell(this, this);

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
                new VampireDrainSpell().castSpellIfHasEnoughElements(this, enemy);
            }

        } else {
            if (new InfoSpell().hasEnoughElementsToCovertToSpell(getElements())) {
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
