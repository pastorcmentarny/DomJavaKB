package dms.pastor.rpg.armor;

/**
 * Author Dominik Symonowicz
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class SportTrousers extends Armor {
    public SportTrousers() {
        setName("Sport Trousers");
        setDescription("A piece of cloth.It has some fashion value but no protection value.");
        type = ArmorType.LEGS;
        armorPoints = 2;
        durability = Integer.MAX_VALUE / 2;
    }
}
