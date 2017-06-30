package dms.pastor.game.dcs.units.enemies;

import dms.pastor.game.dcs.spells.CometStrikeSpell;
import dms.pastor.game.dcs.spells.FireBallSpell;
import dms.pastor.game.dcs.spells.LightingBoltSpell;
import dms.pastor.game.dcs.spells.MagicStoneSpell;
import dms.pastor.game.dcs.units.Unit;

import java.util.Random;

import static dms.pastor.game.dcs.conditions.ConditionEntry.createPersistentCondition;
import static dms.pastor.game.dcs.conditions.ConditionType.EARTH_IMMUNE;
import static dms.pastor.game.dcs.conditions.ElementType.EARTH;

public class Golem extends Unit {

    private static final int maxGolemNumber = 1_000_000;
    private static Random random = new Random();
    private static CometStrikeSpell cometStrikeSpell = new CometStrikeSpell();
    private static MagicStoneSpell magicStoneSpell = new MagicStoneSpell();

    public Golem() {
        super();
        setName("Golem Id:" + random.nextInt(maxGolemNumber));
        setHp(50);
        setArm(2);
        getConditions().add(createPersistentCondition(EARTH_IMMUNE));
    }

    @Override
    public void turn(Unit enemy) {
        System.out.println("Throwing stone on " + enemy.getName());
        magicStoneSpell.castSpell(this, enemy);
        final int penaltyDmg = magicStoneSpell.getElements().countElements() - enemy.getArm();
        this.doesDirectDamage(penaltyDmg);
        System.out.println("Throwing stone caused also damage to " + this.getName());

        if (this.isDead()) {
            return;
        }

        while (cometStrikeSpell.hasEnoughElementsToCovertToSpell(getElements())) {
            getElements().useElements(cometStrikeSpell.getElements());
            System.out.println(getName() + " will attack!");
            cometStrikeSpell.castSpell(this, enemy);

            mayCastMagicStone(enemy);
        }

        FireBallSpell fireBallSpell = new FireBallSpell();
        fireBallSpell.castSpell(this, enemy);

        LightingBoltSpell lightingBoltSpell = new LightingBoltSpell();
        lightingBoltSpell.castSpellIfHasEnoughElements(this, enemy);
    }

    private void mayCastMagicStone(Unit unit) {
        if (random.nextInt(100) > 63) {
            System.out.println("Comet spur magic stone and hit " + unit.getName() + " and add earth element to " + this.getName());
            magicStoneSpell.castSpell(this, unit);
            this.getElements().addElement(EARTH);
        }
    }
}
