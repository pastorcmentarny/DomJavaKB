package dms.pastor.rpg.game.items.potions;

import dms.pastor.rpg.game.Money;
import dms.pastor.rpg.game.cfg.Config;

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
