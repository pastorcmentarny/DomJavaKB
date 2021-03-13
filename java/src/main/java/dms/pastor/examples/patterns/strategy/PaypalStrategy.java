package dms.pastor.examples.patterns.strategy;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PaypalStrategy implements PaymentStrategy {
    private String email;
    private String password;

    @Override
    public void pay(int amount) {
        System.out.println(amount + " paid using Paypal.");
    }
}
