package dms.pastor.game.dcs.units.enemies;

import dms.pastor.game.dcs.Elements;
import dms.pastor.game.dcs.ElementsType;
import dms.pastor.game.dcs.spells.AntiShieldPiercingSpell;
import dms.pastor.game.dcs.spells.FireBallSpell;
import dms.pastor.game.dcs.units.Unit;

import static dms.pastor.game.dcs.ElementsType.AIR;
import static dms.pastor.game.dcs.ElementsType.EARTH;

/**
 * Author Dominik Symonowicz
 * Created 2015-07-24
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class FireElement extends Unit {

    public FireElement() {
        super();
        setName("Fire element");
        setShielded(true);
        setElements(new Elements(10));
        setSp(36);
    }

    @Override
    public void turn(Unit unit) {
        if (getElements().getWater() > 0) {
            int dmg = getElements().getWater() * 2;
            doesDamageTo(this, dmg);
            System.out.println("Water elements  cause " + dmg + " dmg to " + getName());
            if (isDead()) {
                return;
            }
            getElements().setWater(0);
        }

        if (unit.getSp() > 0 && (getElements().getAir() >= 1 && getElements().getFire() >= 1)) {
            AntiShieldPiercingSpell spell = new AntiShieldPiercingSpell();
            spell.castSpell(this, unit);
            getElements().setFire(getElements().getAir() - 1);
            getElements().setFire(getElements().getFire() - 1);
        }

        while (getElements().getFire() >= 1) {
            System.out.println(getName() + " will attack!");
            FireBallSpell fireBallSpell = new FireBallSpell();
            fireBallSpell.castSpell(this, unit);
            getElements().setFire(getElements().getFire() - 1); // Fireball takes only half
        }

        convertToFireElementsFromOtherElements();

    }

    private void convertToFireElementsFromOtherElements() {
        convertToFireElementFrom(EARTH);
        convertToFireElementFrom(AIR);
    }

    private void convertToFireElementFrom(ElementsType type) {
        final int elementsNeeded = 3;
        if (getElementsFor(type) >= elementsNeeded) {
            int elementToAdd = getElementsFor(type) / elementsNeeded;
            System.out.println("Morphing " + type.name().toLowerCase() + " elements into " + elementToAdd + " fire elements.");
            setElementsFor(type, getElementsFor(type) % elementsNeeded);
        }
    }
}
