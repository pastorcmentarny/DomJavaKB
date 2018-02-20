package dms.pastor.game.dcs.units.enemies;

import dms.pastor.game.dcs.spells.CometStrikeSpell;
import dms.pastor.game.dcs.spells.FireBallSpell;
import dms.pastor.game.dcs.spells.LightingBoltSpell;
import dms.pastor.game.dcs.units.Unit;

import static dms.pastor.game.dcs.Config.DEFAULT_HEALTH_POINTS;
import static dms.pastor.game.dcs.conditions.ConditionEntry.createPersistentCondition;
import static dms.pastor.game.dcs.conditions.ConditionType.*;
import static dms.pastor.utils.randoms.PersonalDataGenerator.generateFirstName;

public class Clairvoyant extends Unit {

    public Clairvoyant() {
        setName(generateFirstName() + " a Clairvoyant");
        getHealth().setHp(2 * DEFAULT_HEALTH_POINTS);
        getConditions().add(createPersistentCondition(EARTH_RESISTANT));
        getConditions().add(createPersistentCondition(FIRE_RESISTANT));
        getConditions().add(createPersistentCondition(AIR_RESISTANT));
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
