package dms.pastor.game.rpg.items.weapons.legendary;

import dms.pastor.game.rpg.characteristics.Attribute;
import dms.pastor.game.rpg.items.weapons.Hands;
import dms.pastor.game.rpg.items.weapons.Weapon;

import java.util.ArrayList;

/**
 * @author Pastor
 * Created Feb 20, 2015 at 10:19:42 PM
 */
public class DomSocksSword extends Weapon {

    public DomSocksSword(Hands hand) {
        super(hand);
        name = " Dom's socks";
        description = "Nothing stinks more than Dom's socks.";
        minDMG = 13678;
        maxDMG = 13678;
        accuracy = 75;
        evasion = 50;
        attributes = new ArrayList<>();
        attributes.add(Attribute.LEGENDARY);
        attributes.add(Attribute.MELEE_WEAPON);
        attributes.add(Attribute.WEAPON);
    }

}
