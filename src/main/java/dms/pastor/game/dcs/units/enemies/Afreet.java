package dms.pastor.game.dcs.units.enemies;

import dms.pastor.game.dcs.Elements;
import dms.pastor.game.dcs.conditions.ConditionEntry;
import dms.pastor.game.dcs.spells.FireBallSpell;
import dms.pastor.game.dcs.spells.InfernoStrikeSpell;
import dms.pastor.game.dcs.units.Unit;

import static dms.pastor.game.dcs.conditions.ConditionType.AIR_SENSITIVE;
import static dms.pastor.game.dcs.conditions.ConditionType.FIRE_IMMUNE;
import static dms.pastor.game.dcs.conditions.ConditionType.WATER_SENSITIVE;
import static dms.pastor.game.dcs.conditions.ElementType.FIRE;

/*
Afreet based on Efreet
 */
public class Afreet extends Unit {

    public Afreet() {
        super();
        setName("Afreet");
        setElements(new Elements(10));
        setSp(225);
        getConditions().add(ConditionEntry.createPersistentCondition(FIRE_IMMUNE));
        getConditions().add(ConditionEntry.createPersistentCondition(WATER_SENSITIVE));
        getConditions().add(ConditionEntry.createPersistentCondition(AIR_SENSITIVE));
    }

    @Override
    public void turn(Unit enemy) {
        if (getElements().getWater() > 0) {
            int dmg = getElements().getWater() * 5;
            doesDamageTo(this, dmg);
            System.out.println("Water elements  cause " + dmg + " dmg to " + getName());
            if (isDead()) {
                return;
            }
            getElements().setWater(0);
        }
        while (getElements().getFire() >= 2) {
            InfernoStrikeSpell infernoStrikeSpell = new InfernoStrikeSpell();
            infernoStrikeSpell.castSpell(this, enemy);
            getElements().useElement(FIRE, 2);
        }

        getElements().addElement(FIRE, getElements().getEarth());
        getElements().setEarth(0);

        while (getElements().getFire() >= 1) {
            System.out.println(getName() + " will attack!");
            FireBallSpell fireBallSpell = new FireBallSpell();
            fireBallSpell.castSpellIfHasEnoughElements(this, enemy);
        }

        getElements().addElement(FIRE, 3);
    }
}
