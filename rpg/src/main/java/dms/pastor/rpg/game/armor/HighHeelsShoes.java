package dms.pastor.rpg.game.armor;

import dms.pastor.rpg.game.characteristics.Stats;

/**
 * Author Dominik Symonowicz
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */

class HighHeelsShoes extends Armor {

    public HighHeelsShoes() {
        setName("High Heel Shoes");
        setDescription("In theory.");
        type = ArmorType.FEET;
        armorPoints = -5;
        durability = 100;
        bonusStats = new Stats(0, 0, -10, -50, 0, 0, 0, 0, 0, 0, 0, 0);
    }


}
