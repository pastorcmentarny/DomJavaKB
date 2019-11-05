package dms.pastor.prototypes.dcs.units.enemies;

import dms.pastor.prototypes.dcs.conditions.ConditionEntry;
import dms.pastor.prototypes.dcs.conditions.ConditionType;
import dms.pastor.prototypes.dcs.spells.FireBallSpell;
import dms.pastor.prototypes.dcs.spells.IceBoltSpell;
import dms.pastor.prototypes.dcs.spells.LightingBoltSpell;
import dms.pastor.prototypes.dcs.spells.MagicStoneSpell;
import dms.pastor.prototypes.dcs.units.Unit;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

import static dms.pastor.prototypes.dcs.Config.DEFAULT_HEALTH_POINTS;
import static dms.pastor.prototypes.dcs.Config.INITIAL_SHIELD_POINTS;

public class Dragon extends Unit {
    private static final List<String> COLORS = new ArrayList<>();

    static {
        COLORS.add("Black");
        COLORS.add("White");
        COLORS.add("Pink");
        COLORS.add("Green");
        COLORS.add("Red");
    }

    public Dragon() {
        setName(getRandomColor() + " Dragon");
        getHealth().setHp(100 * DEFAULT_HEALTH_POINTS);
        getHealth().setMaxHp(100 * DEFAULT_HEALTH_POINTS);
        setSp(100 * INITIAL_SHIELD_POINTS);
        getHealth().setArm(2);
        getConditions().add(ConditionEntry.createPersistentCondition(ConditionType.AIR_RESISTANT));
        getConditions().add(ConditionEntry.createPersistentCondition(ConditionType.EARTH_RESISTANT));
        getConditions().add(ConditionEntry.createPersistentCondition(ConditionType.FIRE_RESISTANT));
        getConditions().add(ConditionEntry.createPersistentCondition(ConditionType.WATER_RESISTANT));
    }

    @Override
    public void turn(Unit enemy) {
        LightingBoltSpell lightingBoltSpell = new LightingBoltSpell();
        if (enemy.getConditions().hasNot(ConditionType.AIR_IMMUNE)) {
            IntStream.range(0, 2).forEach(counter -> lightingBoltSpell.castSpell(this, enemy));
        }

        FireBallSpell fireBallSpell = new FireBallSpell();
        if (enemy.getConditions().hasNot(ConditionType.FIRE_IMMUNE)) {
            IntStream.range(0, 3).forEach(counter -> fireBallSpell.castSpell(this, enemy));
        }

        MagicStoneSpell magicStoneSpell = new MagicStoneSpell();
        if (enemy.getConditions().hasNot(ConditionType.EARTH_IMMUNE)) {
            IntStream.range(0, 5).forEach(counter -> magicStoneSpell.castSpell(this, enemy));
        }

        IceBoltSpell iceBoltSpell = new IceBoltSpell();
        if (enemy.getConditions().hasNot(ConditionType.WATER_IMMUNE)) {
            IntStream.range(0, 3).forEach(counter -> iceBoltSpell.castSpell(this, enemy));
        }

        doDamageForAllMana();

    }

    private void doDamageForAllMana() {
        final int elementsCount = getElements().countElements();
        if (elementsCount > 0) {
            System.out.println(String.format("Mana hurts %s and caused %d dmg.", getName(), elementsCount));
            doesDirectDamage(elementsCount);
            getElements().setToZero();
        }
    }

    private String getRandomColor() {
        return COLORS.get(new Random().nextInt(COLORS.size()));
    }
}
