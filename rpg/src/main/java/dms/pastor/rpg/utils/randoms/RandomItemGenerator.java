package dms.pastor.rpg.utils.randoms;

import dms.pastor.rpg.game.items.Item;
import dms.pastor.rpg.game.items.rings.Ring;
import dms.pastor.rpg.game.items.weapons.Hands;
import dms.pastor.rpg.game.items.weapons.legendary.DomSocksSword;

import java.util.Random;

/**
 * Author Dominik Symonowicz
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
class RandomItemGenerator {
    private final Random random = new Random();

    private final int common = 278;
    private final int rare = 19;
    private final int legendary = 3;
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

    private Item getRandomCommonItem() {
        return new Ring("Valuable Ring", random.nextInt(1000) + 1);//TODO implement it
    }

    private Item getRandomRareItem() {
        return new Ring("Very valuable Ring", random.nextInt(25000) + 1000);//TODO implement it
    }

    private Item getRandomLegendaryItem() {
        return new DomSocksSword(Hands.RIGHT);//TODO implement it
    }
}
