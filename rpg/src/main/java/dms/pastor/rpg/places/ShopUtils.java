package dms.pastor.rpg.places;

import dms.pastor.rpg.commons.Errors;
import dms.pastor.rpg.items.Item;
import dms.pastor.rpg.units.Hero;


class ShopUtils {

    public static void buy(Item item) {
        buy(item, 1);
    }

    private static void buy(Item item, int amount) {
        buy(item, item.getValue(), amount);
    }

    private static void buy(Item item, int price, int amount) {
        Hero hero = Hero.getHero();
        if (hero.money.hasEnoughMoney(price * amount)) {
            hero.inventory.addItems(item, amount);
        } else {
            System.out.println(Errors.getNotEnoughMoney());
        }
    }

}
