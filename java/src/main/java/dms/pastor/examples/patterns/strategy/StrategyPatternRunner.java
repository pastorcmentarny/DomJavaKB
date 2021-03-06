package dms.pastor.examples.patterns.strategy;

import dms.pastor.examples.patterns.PatternInformation;

import java.util.UUID;

public class StrategyPatternRunner {

    private final PatternInformation patternInformation = PatternInformation.builder()
            .name("Strategy")
            .type("Behavioral")
            .description("It lets the algorithm vary independently from client that uses it. It defines a family of algorithms, encapsulate eac one, and make them interchangeable. It is good for reduce conditions,avoid duplicate code but it will increase number of classes.")
            .example("Collections.sort()")
            .build();


    public void example2() {
        ShoppingCart shoppingCart = new ShoppingCart();

        Item item1 = new Item(UUID.randomUUID(), "12345", 100);
        Item item2 = new Item(UUID.randomUUID(), "50000", 125);
        Item item3 = new Item(UUID.randomUUID(), "90000", 112);

        shoppingCart.addItem(item1);
        shoppingCart.addItem(item2);
        shoppingCart.addItem(item3);

        shoppingCart.pay(new PaypalStrategy("a@b.c", "***"));
        shoppingCart.pay(new CreditCardStrategy("Dom", "1111222233334444", "465", "tmrw"));


    }

}
