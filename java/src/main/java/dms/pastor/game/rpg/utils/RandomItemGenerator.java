package dms.pastor.game.rpg.utils;

import dms.pastor.game.rpg.items.Item;
import dms.pastor.game.rpg.items.rings.Ring;
import dms.pastor.game.rpg.items.weapons.Hands;
import dms.pastor.game.rpg.items.weapons.legendary.DomSocksSword;

import java.util.Random;

/**
 * @author Pastor
 * Created Feb 20, 2015 at 10:13:57 PM
 */
public class RandomItemGenerator {
    Random random = new Random();

    int common = 278;
    int rare = 19;
    int legendary = 3;
    //COMMON(278),RARE(19),LEGENDARY(3)

    public Item getRandomItem() {
        int itemNo = random.nextInt(common + rare + legendary + 1);
        if (itemNo > legendary + rare) {
            return getRandomCommonItem();
        } else if (itemNo > legendary) {
            return getRandomRareItem();
        } else {
            return getRandomLegendaryItem();
        }
    }

    public Item getRandomCommonItem() {
        return new Ring("Valualbe Ring", random.nextInt(1000) + 1);//TODO implement it
    }

    public Item getRandomRareItem() {
        return new Ring("Very valuable Ring", random.nextInt(25000) + 1000);//TODO implement it
    }

    public Item getRandomLegendaryItem() {
        return new DomSocksSword(Hands.RIGHT);//TODO implement it
    }
}