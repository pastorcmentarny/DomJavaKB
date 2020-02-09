package dms.pastor.rpg.game.items.potions;

import dms.pastor.rpg.game.Money;
import dms.pastor.rpg.game.cfg.Config;
import dms.pastor.rpg.game.characteristics.Stats;
import dms.pastor.domain.Result;
import dms.pastor.rpg.game.units.Unit;

/**
 * @author dominiksymonowicz
 */
public class ManaPotion extends Potion {
    private final int mana = 1000;

    public ManaPotion(PotionSize size) {
        super(size);
        name = "Mana";
        description = "A potion that restore your mana level";
        value = Money.getValueChangedByPercent(size.pricePercent(), Config.PRICE_MANA_POTION);
    }

    public Result use() {
        heal(hero.plainStats);
        return new Result(true, name + " restore mana by " + (size.percent() * mana) + " mp.");
    }

    @Override
    public Result useInBattle(Unit unit) {
        heal(hero.battleStats);
        return new Result(true, name + " restore mana by " + (size.percent() * mana) + " mp.");
    }


    private void heal(Stats stats) {
        stats.addHealth(size.percent() * mana);
    }
}
