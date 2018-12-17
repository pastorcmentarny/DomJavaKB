package dms.pastor.game.rpg.armor;

import dms.pastor.game.rpg.characteristics.Stats;


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
