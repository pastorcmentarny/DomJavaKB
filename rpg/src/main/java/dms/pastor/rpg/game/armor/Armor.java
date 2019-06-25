package dms.pastor.rpg.game.armor;

import dms.pastor.rpg.game.characteristics.Stats;
import dms.pastor.rpg.game.items.Action;
import dms.pastor.rpg.game.items.Item;

/**
 * Author Dominik Symonowicz
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 * <p>
 */
public class Armor extends Item {
    ArmorType type;
    public int armorPoints;
    int durability;
    Stats bonusStats;

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
