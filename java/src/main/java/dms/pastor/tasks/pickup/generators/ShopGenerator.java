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

    public static Shop alwaysClosed() {
        return new Shop(3, "Closed down shop", WeeklyOpenCloseTimesGenerator.getClosed24HoursPerDay7DaysAWeek());
    }

    public static Shop mixedOpenClosedTimes() {
        return new Shop(4, "Open 24 Hour at Fridays, Saturdays and closed on the Sunday", WeeklyOpenCloseTimesGenerator.getMixedOpeningTimes());
    }
}
