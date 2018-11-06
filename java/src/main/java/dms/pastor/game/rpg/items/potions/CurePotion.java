package dms.pastor.game.rpg.items.potions;

import dms.pastor.game.rpg.Money;
import dms.pastor.game.rpg.cfg.Config;

/**
 * @author dominiksymonowicz
 */
public class CurePotion extends Potion {
    public CurePotion(PotionSize size) {
        super(size);
        name = "Cure";
        description = "It cures you from all bad effects";
        value = Money.getValueChangedByPercent(size.pricePercent(), Config.PRICE_HEAL_POTION);
    }
}
