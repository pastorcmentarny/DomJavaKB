package dms.pastor.rpg.items.potions;

import dms.pastor.rpg.units.Hero;
import dms.pastor.rpg.items.Item;

/**
 * @author dominiksymonowicz
 */
abstract class Potion extends Item {
    final PotionSize size;
    final Hero hero = Hero.getHero();

    Potion(PotionSize size) {
        this.size = size;
        isUsableInBattle = true;
    }

}
