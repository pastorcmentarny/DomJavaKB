package dms.pastor.rpg.game.items.potions;

import dms.pastor.rpg.game.items.Item;
import dms.pastor.rpg.game.units.Hero;

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
