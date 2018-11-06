package dms.pastor.game.rpg;

import dms.pastor.game.rpg.exceptions.NoEnoughMoneyException;


public class Money {

    private int money;

    public Money(int initMoney) {
        this.money = initMoney;
    }

    public static int getValueChangedByPercent(int pricePercent, int value) {
        double newValue = (pricePercent / 100) * value;
        return (int) newValue;
    }

    public static int getDisccountedPrice(int value, int discountInPercent) {
        if (value <= 0) {
            throw new IllegalArgumentException("value must be positive");
        }
        if (discountInPercent > 100) {
            throw new IllegalArgumentException("It can be in range 1-100");
        }
        return value * ((100 - discountInPercent) / 100);

    }

    public void addMoney(int cash) {
        money += cash;
    }

    public int takeMoney(int value) throws NoEnoughMoneyException {
        if (money - value < 0) {
            throw new NoEnoughMoneyException("You don't have enough money to perform this operation");
        }
        money -= value;
        return value;
    }

    public boolean hasEnoughMoney(int value) {
        return money - value >= 0;
    }

    public String showMoney() {
        return String.valueOf(money);
    }

    void lostAllMoney() {
        money = 0;
    }

}
