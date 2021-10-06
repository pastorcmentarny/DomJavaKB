package dms.pastor.rpg.game.armor;

/**
 * Author Dominik Symonowicz
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */

public class CrocodileArmor extends Armor {

    public CrocodileArmor() {
        setName("Crocodile Armor");
        setDescription("WARNING! It is not suitable for vegetarian, animal lovers and people who suffer similar allergy");
        type = ArmorType.CHEST;
        armorPoints = 50;
        durability = 10000;
    }

}
