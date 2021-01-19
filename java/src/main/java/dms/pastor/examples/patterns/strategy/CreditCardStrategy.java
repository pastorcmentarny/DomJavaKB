package dms.pastor.examples.patterns.strategy;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CreditCardStrategy implements PaymentStrategy {
    private String name;
    private String cardNumber;
    private String cvv;
    private String dateOfExpiry;


    @Override
    public void pay(int amount) {
        System.out.println("Payment of " + amount + " was taken from CreditCard");
    }
}
