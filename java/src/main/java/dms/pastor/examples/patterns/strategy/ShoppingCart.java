package dms.pastor.examples.patterns.strategy;

import java.util.ArrayList;
import java.util.List;
//TODO have one work-like example and one train like
public class ShoppingCart {

    private List<Item> items;

    public ShoppingCart() {
        this.items = new ArrayList<>();
    }

    public void addItem(Item item){
        this.items.add(item);
    }

    public void removeItem(Item item){
        this.items.remove(item);
    }

    public int calculateTotal() {
        return items.stream()
                .mapToInt(Item::getPrice)
                .sum();
    }

    public void pay(PaymentStrategy paymentStrategy){
        paymentStrategy.pay(calculateTotal());
    }
}
