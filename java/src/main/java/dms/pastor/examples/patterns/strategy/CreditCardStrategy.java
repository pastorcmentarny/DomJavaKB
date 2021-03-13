package dms.pastor.examples.patterns.strategy;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CreditCardStrategy implements PaymentStrategy {
    private final String name;
    private final String cardNumber;
    private final String cvv;
    private final String dateOfExpiry;


    @Override
    public void pay(int amount) {
        System.out.println("Payment of " + amount + " was taken from CreditCard");
    }
}
