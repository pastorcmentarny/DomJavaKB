package dms.pastor.prototypes.dcs.units.enemies;

import dms.pastor.prototypes.dcs.conditions.ConditionEntry;
import dms.pastor.prototypes.dcs.conditions.ConditionType;
import dms.pastor.prototypes.dcs.spells.*;
import dms.pastor.prototypes.dcs.units.Unit;

import static dms.pastor.prototypes.dcs.Config.INITIAL_SHIELD_POINTS;

public class Warlock extends Unit {

    private boolean hasInfoAboutEnemy = false;

    public Warlock() {
        setSp(3 * INITIAL_SHIELD_POINTS);
        setArm(2);
        getConditions().add(ConditionEntry.createPersistentCondition(ConditionType.FIRE_RESISTANT));
        getConditions().add(ConditionEntry.createPersistentCondition(ConditionType.EARTH_RESISTANT));
    }

    @Override
    public void turn(Unit enemy) {

        InfoSpell infoSpell = new InfoSpell();

        if (hasInfoAboutEnemy) {
            CommonTurnActions.castElementSensitiveSpellOnEnemy(this, enemy);

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

