package dms.pastor.game.rpg.items.potions;

import dms.pastor.game.rpg.units.Hero;
import dms.pastor.game.rpg.items.Item;

/**
 * @author dominiksymonowicz
 */
public abstract class Potion extends Item {
    public PotionSize size;
    public Hero hero = Hero.getHero();

    public Potion(PotionSize size) {
        this.size = size;
        isUsableInBattle = true;
    }

}
