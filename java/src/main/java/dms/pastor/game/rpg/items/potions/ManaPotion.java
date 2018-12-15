package dms.pastor.game.rpg.items.potions;

import dms.pastor.game.rpg.Money;
import dms.pastor.game.rpg.cfg.Config;
import dms.pastor.game.rpg.characteristics.Stats;
import dms.pastor.game.rpg.commons.Result;
import dms.pastor.game.rpg.units.Unit;

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
        return new Result(true, name + " restore mana by " + (size.pecent() * mana) + " mp.");
    }

    @Override
    public Result useInBattle(Unit unit) {
        heal(hero.battleStats);
        return new Result(true, name + " restore mana by " + (size.pecent() * mana) + " mp.");
    }


    private void heal(Stats stats) {
        stats.addHealth(size.pecent() * mana);
    }
}
