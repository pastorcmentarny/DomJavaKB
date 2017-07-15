package dms.pastor.game.dcs.units.enemies;

import dms.pastor.game.dcs.Elements;
import dms.pastor.game.dcs.spells.FireBallSpell;
import dms.pastor.game.dcs.spells.InfernoStrikeSpell;
import dms.pastor.game.dcs.units.Unit;

import java.util.Random;

import static dms.pastor.game.dcs.conditions.ConditionEntry.createPersistentCondition;
import static dms.pastor.game.dcs.conditions.ConditionType.*;
import static dms.pastor.game.dcs.conditions.ElementType.FIRE;

/**
 * Author Dominik Symonowicz
 * Created 2017-06-30
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 *
 * Afreet based on Efreet which is a creature that exists in some Middle Eastern stories.
 */
public class Afreet extends Unit {

    public Afreet() {
        super();
        setName("Afreet");
        setElements(new Elements(10));
        setSp(225);
        getConditions().add(createPersistentCondition(FIRE_IMMUNE));
        getConditions().add(createPersistentCondition(WATER_SENSITIVE));
        getConditions().add(createPersistentCondition(AIR_SENSITIVE));
    }

    @Override
    public void turn(Unit enemy) {
        FireBallSpell fireBallSpell = new FireBallSpell();
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

        transformEarthToFire();

        getElements().addElement(FIRE, 3);
        castTripleFireballIfLucky(enemy, fireBallSpell);
    }

    private void transformEarthToFire() {
        System.out.println("Transforming Earth elements and ");
        getElements().addElement(FIRE, getElements().getEarth());
        getElements().setEarth(0);
    }

    private void castTripleFireballIfLucky(Unit enemy, FireBallSpell fireBallSpell) {
        if (new Random().nextInt(100) > 80) {
            System.out.println("Triple fire ball strikes " + enemy.getName());
            for (int i = 1; i <= 3; i++) {
                fireBallSpell.castSpell(this, enemy);
            }
        }
    }
}
