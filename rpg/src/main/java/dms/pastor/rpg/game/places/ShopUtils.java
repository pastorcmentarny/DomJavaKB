package dms.pastor.rpg.game.places;

import dms.pastor.rpg.game.commons.Errors;
import dms.pastor.rpg.game.items.Item;
import dms.pastor.rpg.game.units.Hero;


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
            hero.inventory.addItems();
        } else {
            System.out.println(Errors.getNotEnoughMoney());
        }
    }

}
