package dms.pastor.rpg.game.armor;


/**
 * Author Dominik Symonowicz
 * WWW:	<a href="https://dominiksymonowicz.com/">HOME PAGE</a>
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class TShirt extends Armor {

    public TShirt() {
        setName("T-Shirt");
        setDescription("A piece of cloth.It has some fashion value but no protection value.");
        type = ArmorType.CHEST;
        armorPoints = 0;
        durability = Integer.MAX_VALUE / 2;
    }
}
