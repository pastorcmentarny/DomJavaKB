package dms.pastor.game.rpg.items.potions;

import dms.pastor.game.rpg.Money;
import dms.pastor.game.rpg.cfg.Config;
import dms.pastor.game.rpg.characteristics.Attribute;
import dms.pastor.game.rpg.commons.Result;
import dms.pastor.game.rpg.units.Unit;

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
            //TODO display antidote didn't work
            return false;
        }


    }
}
