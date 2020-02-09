package dms.pastor.rpg.game.items.potions;

import dms.pastor.rpg.game.Money;
import dms.pastor.rpg.game.cfg.Config;
import dms.pastor.rpg.game.characteristics.Stats;
import dms.pastor.domain.Result;
import dms.pastor.rpg.game.units.Hero;
import dms.pastor.rpg.game.units.Unit;

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
