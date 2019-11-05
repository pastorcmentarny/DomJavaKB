package dms.pastor.prototypes.dcs.units.enemies;

import dms.pastor.prototypes.dcs.conditions.ConditionEntry;
import dms.pastor.prototypes.dcs.conditions.ConditionType;
import dms.pastor.prototypes.dcs.spells.CometStrikeSpell;
import dms.pastor.prototypes.dcs.spells.FireBallSpell;
import dms.pastor.prototypes.dcs.spells.LightingBoltSpell;
import dms.pastor.prototypes.dcs.units.Unit;
import dms.pastor.utils.randoms.PersonalDataGenerator;

import static dms.pastor.prototypes.dcs.Config.DEFAULT_HEALTH_POINTS;

public class Clairvoyant extends Unit {

    public Clairvoyant() {
        setName(PersonalDataGenerator.generateFirstName() + " a Clairvoyant");
        getHealth().setHp(2 * DEFAULT_HEALTH_POINTS);
        getConditions().add(ConditionEntry.createPersistentCondition(ConditionType.EARTH_RESISTANT));
        getConditions().add(ConditionEntry.createPersistentCondition(ConditionType.FIRE_RESISTANT));
        getConditions().add(ConditionEntry.createPersistentCondition(ConditionType.AIR_RESISTANT));
    }

    @Override
    public void turn(Unit enemy) {

        LightingBoltSpell lightingBoltSpell = new LightingBoltSpell();
        lightingBoltSpell.castSpellIfHasEnoughElements(this, enemy);

        FireBallSpell fireBallSpell = new FireBallSpell();
        fireBallSpell.castSpellIfHasEnoughElements(this, enemy);

        CometStrikeSpell cometStrikeSpell = new CometStrikeSpell();
        cometStrikeSpell.castSpellIfHasEnoughElements(this, enemy);

        final int elementsToDraw = random.nextInt(10) + 1;
        System.out.println(getName() + " saw in his vision where he saw elements to collect");
        for (int i = 0; i < elementsToDraw; i++) {
            getElements().addRandomElements(1);
        }

    }
}
