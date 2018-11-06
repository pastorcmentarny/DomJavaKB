package dms.pastor.game.rpg.places;

import dms.pastor.game.rpg.commons.Errors;
import dms.pastor.game.rpg.items.Item;
import dms.pastor.game.rpg.units.Hero;


public class ShopUtils {

    public static void buy(Item item) {
        buy(item, 1);
    }

    public static void buy(Item item, int amount) {
        buy(item, item.getValue(), amount);
    }

    public static void buy(Item item, int price, int amount) {
        Hero hero = Hero.getHero();
        if (hero.money.hasEnoughMoney(price * amount)) {
            hero.inventory.addItems(item, amount);
        } else {
            System.out.println(Errors.getNotEnoughMoney());
        }
    }

}
