package dms.pastor.prototypes.dcs.units.enemies;

import dms.pastor.prototypes.dcs.Config;
import dms.pastor.prototypes.dcs.conditions.ConditionEntry;
import dms.pastor.prototypes.dcs.conditions.ConditionType;
import dms.pastor.prototypes.dcs.spells.*;
import dms.pastor.prototypes.dcs.units.Unit;

public class Wizard extends Unit {
    private boolean hasInfoAboutEnemy = false;

    public Wizard() {
        setSp(Config.INITIAL_SHIELD_POINTS * 3);
        getConditions().add(ConditionEntry.createPersistentCondition(ConditionType.AIR_RESISTANT));
        getConditions().add(ConditionEntry.createPersistentCondition(ConditionType.EARTH_RESISTANT));
        getConditions().add(ConditionEntry.createPersistentCondition(ConditionType.FIRE_RESISTANT));
        getConditions().add(ConditionEntry.createPersistentCondition(ConditionType.WATER_SENSITIVE));
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
            CommonTurnActions.castElementSensitiveSpellOnEnemy(this, enemy);
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
