package dms.pastor.rpg.armor;

import dms.pastor.rpg.characteristics.Skills;
import dms.pastor.rpg.characteristics.Stats;
import dms.pastor.rpg.items.Action;
import dms.pastor.rpg.items.Item;

/**
 * Author Dominik Symonowicz
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 *
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
