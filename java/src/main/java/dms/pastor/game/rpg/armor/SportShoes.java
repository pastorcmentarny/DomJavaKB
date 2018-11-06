package dms.pastor.game.rpg.armor;

/**
 * @author Pastor
 * Created Mar 14, 2015 at 11:22:09 PM
 */
public class SportShoes extends Armor {
    public SportShoes() {
        setName("Sport Shoes");
        setDescription("A piece of cloth.It has some fashion value but no protection value.");
        type = ArmorType.LEGS;
        armorPoints = 1;
        durability = Integer.MAX_VALUE / 2;
    }
}
