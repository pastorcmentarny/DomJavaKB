package dms.pastor.game.dcs.units.enemies;

import dms.pastor.game.dcs.spells.CometStrikeSpell;
import dms.pastor.game.dcs.spells.FireBallSpell;
import dms.pastor.game.dcs.spells.LightingBoltSpell;
import dms.pastor.game.dcs.spells.MagicStoneSpell;
import dms.pastor.game.dcs.units.Unit;

import java.util.Random;

import static dms.pastor.game.dcs.conditions.ConditionEntry.createPersistentCondition;
import static dms.pastor.game.dcs.conditions.ConditionType.*;
import static dms.pastor.utils.randoms.PersonalDataGenerator.generateFirstName;

public class Clairvoyant extends Unit {

    private static Random random = new Random();
    private static CometStrikeSpell cometStrikeSpell = new CometStrikeSpell();
    private static MagicStoneSpell magicStoneSpell = new MagicStoneSpell();

    public Clairvoyant() {
        super();
        setName(generateFirstName() + " a Clairvoyant");
        setHp(50);
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
