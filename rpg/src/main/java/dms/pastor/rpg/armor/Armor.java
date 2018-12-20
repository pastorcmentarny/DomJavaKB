package dms.pastor.rpg.armor;

import dms.pastor.rpg.items.Action;
import dms.pastor.rpg.items.Item;
import dms.pastor.rpg.characteristics.Skills;
import dms.pastor.rpg.characteristics.Stats;

/**
 * @author domhome
 * //TODO change to abstract when finish implementing full version of armor
 */
public class Armor extends Item {
    ArmorType type;
    public int armorPoints;
    int durability;
    Stats bonusStats;
    protected Skills bonusSkills;

    Armor() {
        actions = Action.armor;
    }

    public ArmorType getType() {
        return type;
    }

    public int getArmorPoints() {
        return armorPoints;
    }

    public int getDurability() {
        return durability;
    }

}
