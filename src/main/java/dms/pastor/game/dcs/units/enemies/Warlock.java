package dms.pastor.game.dcs.units.enemies;

import dms.pastor.game.dcs.spells.*;
import dms.pastor.game.dcs.units.Unit;

import static dms.pastor.game.dcs.Config.INITIAL_SHIELD_POINTS;
import static dms.pastor.game.dcs.conditions.ConditionEntry.createPersistentCondition;
import static dms.pastor.game.dcs.conditions.ConditionType.EARTH_RESISTANT;
import static dms.pastor.game.dcs.conditions.ConditionType.FIRE_RESISTANT;

public class Warlock extends Unit {

    private boolean hasInfoAboutEnemy = false;

    public Warlock() {
        setSp(3 * INITIAL_SHIELD_POINTS);
        setArm(2);
        getConditions().add(createPersistentCondition(FIRE_RESISTANT));
        getConditions().add(createPersistentCondition(EARTH_RESISTANT));
    }

    @Override
    public void turn(Unit enemy) {

        InfoSpell infoSpell = new InfoSpell();

        if (hasInfoAboutEnemy) {
            CommonTurnActions.castElementSensitveSpellOnEnemy(this, enemy);

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

