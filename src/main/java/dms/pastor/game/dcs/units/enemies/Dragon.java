package dms.pastor.game.dcs.units.enemies;

import dms.pastor.game.dcs.spells.FireBallSpell;
import dms.pastor.game.dcs.spells.IceBoltSpell;
import dms.pastor.game.dcs.spells.LightingBoltSpell;
import dms.pastor.game.dcs.spells.MagicStoneSpell;
import dms.pastor.game.dcs.units.Unit;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

import static dms.pastor.game.dcs.conditions.ConditionEntry.createPersistentCondition;
import static dms.pastor.game.dcs.conditions.ConditionType.*;

public class Dragon extends Unit {
    private static final List<String> colors = new ArrayList<>();

    static {
        colors.add("Black");
        colors.add("White");
        colors.add("Pink");
        colors.add("Green");
        colors.add("Red");
    }

    public Dragon() {
        setName(getRandomColor() + " Dragon");
        setHp(1024);
        setMaxHp(1024);
        setSp(2048);
        setArm(2);
        getConditions().add(createPersistentCondition(AIR_RESISTANT));
        getConditions().add(createPersistentCondition(EARTH_RESISTANT));
        getConditions().add(createPersistentCondition(FIRE_RESISTANT));
        getConditions().add(createPersistentCondition(WATER_RESISTANT));
    }

    @Override
    public void turn(Unit enemy) {
        LightingBoltSpell lightingBoltSpell = new LightingBoltSpell();
        if (enemy.getConditions().hasNot(AIR_IMMUNE)) {
            IntStream.range(0, 2).forEach(x -> lightingBoltSpell.castSpell(this, enemy));
        }

        FireBallSpell fireBallSpell = new FireBallSpell();
        if (enemy.getConditions().hasNot(FIRE_IMMUNE)) {
            IntStream.range(0, 3).forEach(x -> fireBallSpell.castSpell(this, enemy));
        }

        MagicStoneSpell magicStoneSpell = new MagicStoneSpell();
        if (enemy.getConditions().hasNot(EARTH_IMMUNE)) {
            IntStream.range(0, 5).forEach(x -> magicStoneSpell.castSpell(this, enemy));
        }

        IceBoltSpell iceBoltSpell = new IceBoltSpell();
        if (enemy.getConditions().hasNot(WATER_IMMUNE)) {
            IntStream.range(0, 3).forEach(x -> iceBoltSpell.castSpell(this, enemy));
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
        return colors.get(new Random().nextInt(colors.size()));
    }
}
