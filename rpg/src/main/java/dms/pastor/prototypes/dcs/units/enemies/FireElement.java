package dms.pastor.prototypes.dcs.units.enemies;

import dms.pastor.prototypes.dcs.Elements;
import dms.pastor.prototypes.dcs.conditions.ElementType;
import dms.pastor.prototypes.dcs.spells.AntiShieldPiercingSpell;
import dms.pastor.prototypes.dcs.spells.FireBallSpell;
import dms.pastor.prototypes.dcs.units.Unit;

import static dms.pastor.prototypes.dcs.Config.INITIAL_SHIELD_POINTS;

/**
 * Author Dominik Symonowicz
 * Created 2015-07-24
 * WWW:	<a href="https://dominiksymonowicz.com/">HOME PAGE</a>
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class FireElement extends Unit {

    public FireElement() {
        setName("Fire element");
        setShielded(true);
        setElements(new Elements(10));
        setSp(2 * INITIAL_SHIELD_POINTS);
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
        convertToFireElementFrom(ElementType.EARTH);
        convertToFireElementFrom(ElementType.AIR);
    }

    private void convertToFireElementFrom(ElementType type) {
        final int elementsNeeded = 3;
        final int elements = getElements().getElementsFor(type);
        if (elements >= elementsNeeded) {
            int elementToAdd = elements / elementsNeeded;
            System.out.println("Morphing " + type.name().toLowerCase() + " elements into " + elementToAdd + " fire elements.");
            getElements().setElementsFor(type, elements % elementsNeeded);
        }
    }
}
