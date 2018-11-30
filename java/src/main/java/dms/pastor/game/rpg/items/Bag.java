package dms.pastor.game.rpg.items;

import dms.pastor.game.rpg.commons.Result;

import java.util.ArrayList;


public class Bag extends Item {
    private final ArrayList<Item> bagItems;
    private int maxSize = 9;

    public Bag() {
        bagItems = new ArrayList<>(maxSize);
        setName("Bag");
        setDescription("A Bag which can be empty or have some treasure");
    }


    public Result putItem(Item item) {
        if (bagItems.size() >= maxSize) {
            return new Result(false, "Bag is full");
        } else {
            bagItems.add(item);
            return new Result(true, item.getName() + " was added to bag");
        }
    }

    //
}