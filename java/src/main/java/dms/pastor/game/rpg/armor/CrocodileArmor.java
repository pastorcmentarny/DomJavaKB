package dms.pastor.game.rpg.armor;


public class CrocodileArmor extends Armor {

    public CrocodileArmor() {
        setName("Crocodile Armor");
        setDescription("WARNING! It is not suitable for vegetarian, animal lovers and people who suffer similar allergy");
        type = ArmorType.CHEST;
        armorPoints = 50;
        durability = 10000;
    }

}
