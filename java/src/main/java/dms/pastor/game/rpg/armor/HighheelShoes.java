package dms.pastor.game.rpg.armor;

import dms.pastor.game.rpg.characteristics.Stats;


public class HighheelShoes extends Armor {

    public HighheelShoes() {
        setName("High Heel Shoes");
        setDescription("In theory.");
        type = ArmorType.FEET;
        armorPoints = -5;
        durability = 100;
        bonusStats = new Stats(0, 0, -10, -50, 0, 0, 0, 0, 0, 0, 0, 0);
    }


}
