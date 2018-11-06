package dms.pastor.game.rpg.items.potions;

import dms.pastor.game.rpg.commons.Result;
import dms.pastor.game.rpg.units.Hero;
import dms.pastor.game.rpg.units.Unit;
import dms.pastor.game.rpg.*;
import dms.pastor.game.rpg.cfg.Config;
import dms.pastor.game.rpg.characteristics.Stats;

/**
 * @author dominiksymonowicz
 */
public class HealingPotion extends Potion {
    Hero hero = Hero.getHero();
    PotionSize size;
    int heal = 4000;

    public HealingPotion(PotionSize size) {
        super(size);
        name = "Heal";
        description = "It heals wounds and gives your some hp";
        value = Money.getValueChangedByPercent(size.pricePercent(), Config.PRICE_HEAL_POTION);
    }

    public Result use() {
        heal(hero.plainStats);
        return new Result(true, name + " was healed by " + (size.pecent() * heal) + " hp.");
    }

    @Override
    public Result useInBattle(Unit unit) {
        heal(hero.battleStats);
        return new Result(true, name + " was healed by " + (size.pecent() * heal) + " hp.");
    }


    private void heal(Stats stats) {
        stats.addHealth(size.pecent() * heal);
    }
}
