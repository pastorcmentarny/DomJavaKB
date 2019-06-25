package dms.pastor.rpg.game.items;

import dms.pastor.rpg.game.armor.TShirt;
import dms.pastor.rpg.game.items.rings.Ring;

import java.util.Random;


public class Items {

    public static Item generateItem() {
        return new Ring();
    }

    public static Item generateRareItem() {
        return new Ring("Rare Ring", 1000);
    }

    public static Item generateRubbishItem() {
        //BASED on odd things found in public transport
        switch (new Random().nextInt(3)) {
            case 0:
                return new RubbishItem("Socks", "An unused socks", 5);
            case 1:
                return new TShirt();
            case 2:
                return new RubbishItem("basketball player's trainers", "A basketball player's size-17 trainers found in Zombie's bag that you killed.", 25);
            case 3:
                return new RubbishItem("Umbrella", "An umbrella", 4);
            case 4:
                return new RubbishItem("A stuffed fish", "A stuffed puff fish", 9);
            case 5:
                return new RubbishItem("False teeth", "It belongs to Zombie", 9);

            default:
                return new Ring("Plastic Ring", 1);
        }
    }

}
