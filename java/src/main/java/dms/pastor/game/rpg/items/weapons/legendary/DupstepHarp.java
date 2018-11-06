package dms.pastor.game.rpg.items.weapons.legendary;

import dms.pastor.game.rpg.characteristics.Attribute;
import dms.pastor.game.rpg.items.weapons.Hands;
import dms.pastor.game.rpg.items.weapons.Weapon;

import java.util.ArrayList;


public class DupstepHarp extends Weapon {

    public DupstepHarp() {
        super(Hands.RIGHT);
        setName("Dupstep harp");
        setDescription("The harp is a stringed musical instrument which has a number of individual strings running at an angle to its soundboard, which are plucked with the fingers.It helps as well in fighting with undead");//TODO improve it
        minDMG = 0;
        maxDMG = 1;
        accuracy = 100;
        evasion = 100;
        attributes = new ArrayList<>();
        attributes.add(Attribute.LEGENDARY);
        attributes.add(Attribute.UNDEAD_KILLER);
        attributes.add(Attribute.WEAPON);
    }

}
