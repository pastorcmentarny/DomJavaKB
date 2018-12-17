package dms.pastor.game.rpg.items.potions;

import dms.pastor.game.rpg.Money;
import dms.pastor.game.rpg.cfg.Config;
import dms.pastor.game.rpg.characteristics.Stats;
import dms.pastor.game.rpg.commons.Result;
import dms.pastor.game.rpg.units.Hero;
import dms.pastor.game.rpg.units.Unit;

/**
 * @author dominiksymonowicz
 */
public class HealingPotion extends Potion {
    private final Hero hero = Hero.getHero();
    private PotionSize size;
    private final int heal = 4000;

    public HealingPotion(PotionSize size) {
        super(size);
        name = "Heal";
        description = "It heals wounds and gives your some hp";
        value = Money.getValueChangedByPercent(size.pricePercent(), Config.PRICE_HEAL_POTION);
    }

    public Result use() {
        heal(hero.plainStats);
        return new Result(true, name + " was healed by " + (size.percent() * heal) + " hp.");
    }

    @Override
    public Result useInBattle(Unit unit) {
        heal(hero.battleStats);
        return new Result(true, name + " was healed by " + (size.percent() * heal) + " hp.");
    }


    private void heal(Stats stats) {
        stats.addHealth(size.percent() * heal);
    }
}
