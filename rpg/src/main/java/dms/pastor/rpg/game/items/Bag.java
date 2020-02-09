package dms.pastor.rpg.game.items;

import dms.pastor.domain.Result;

import java.util.ArrayList;


class Bag extends Item {
    private final ArrayList<Item> bagItems;
    private final int maxSize = 9;

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
