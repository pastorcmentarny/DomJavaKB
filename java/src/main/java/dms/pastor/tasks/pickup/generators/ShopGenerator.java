package dms.pastor.tasks.pickup.generators;

import dms.pastor.tasks.pickup.Shop;

public class ShopGenerator {
    private ShopGenerator() {
    }

    ;

    public static Shop getTypicalShop() {
        return new Shop(1, "Normal Shop", WeeklyOpenCloseTimesGenerator.getTypicalWeeklyOpenCloseTimes());
    }

    public static Shop getShopOpenOnlyOnWeekdays() {
        return new Shop(2, "Weekdays only Shop", WeeklyOpenCloseTimesGenerator.getWeekOnlyOpenCloseTimes());
    }
}
