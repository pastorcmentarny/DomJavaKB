package dms.pastor.rpg.armor;

/**
 * @author Pastor
 * Created Mar 14, 2015 at 11:11:08 PM
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
