package dms.pastor.game.rpg.items.potions;

import dms.pastor.game.rpg.commons.Result;
import dms.pastor.game.rpg.units.Unit;
import dms.pastor.game.rpg.*;
import dms.pastor.game.rpg.cfg.Config;
import dms.pastor.game.rpg.characteristics.Attribute;

import java.util.ArrayList;

/**
 * @author dominiksymonowicz
 */
public class AntitodePotion extends Potion {

    public AntitodePotion(PotionSize size) {
        super(size);
        name = "Antitode";
        description = "A potion that solves problems with any poison";
        value = Money.getValueChangedByPercent(size.pricePercent(), Config.PRICE_HEAL_POTION);
    }

    public Result use() {
        heal(hero.nativeAttributes);
        return new Result(true, name + " cured from poison.");
    }

    @Override
    public Result useInBattle(Unit unit) {
        heal(hero.currentAttributes);
        return new Result(true, name + " cured from poison.");
    }

    private boolean heal(ArrayList<Attribute> attrs) {
        attrs.remove(Attribute.POISONED);
        return true; //TODO it should be 85% that it works
    }
}
