package dms.pastor.game.rpg.armor;


public class TShirt extends Armor {

    public TShirt() {
        setName("T-Shirt");
        setDescription("A piece of cloth.It has some fashion value but no protection value.");
        type = ArmorType.CHEST;
        armorPoints = 0;
        durability = Integer.MAX_VALUE / 2;
    }
}
