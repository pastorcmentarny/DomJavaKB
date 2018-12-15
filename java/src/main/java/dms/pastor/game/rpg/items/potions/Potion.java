package dms.pastor.game.rpg.items.potions;

import dms.pastor.game.rpg.items.Item;
import dms.pastor.game.rpg.units.Hero;

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
