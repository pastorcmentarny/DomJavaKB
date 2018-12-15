package dms.pastor.game.rpg.armor;

import dms.pastor.game.rpg.characteristics.Skills;
import dms.pastor.game.rpg.characteristics.Stats;
import dms.pastor.game.rpg.items.Action;
import dms.pastor.game.rpg.items.Item;

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
