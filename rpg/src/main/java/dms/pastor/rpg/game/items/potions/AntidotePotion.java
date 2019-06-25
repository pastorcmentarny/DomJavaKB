package dms.pastor.rpg.game.items.potions;

import dms.pastor.rpg.game.Money;
import dms.pastor.rpg.game.cfg.Config;
import dms.pastor.rpg.game.characteristics.Attribute;
import dms.pastor.rpg.game.commons.Result;
import dms.pastor.rpg.game.units.Unit;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author dominiksymonowicz
 */
public class AntidotePotion extends Potion {

    public AntidotePotion(PotionSize size) {
        super(size);
        name = "Antidote";
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
        if (new Random().nextInt(100) > 15) {
            attrs.remove(Attribute.POISONED);
            return true;
        } else {
            return false;
        }


    }
}
