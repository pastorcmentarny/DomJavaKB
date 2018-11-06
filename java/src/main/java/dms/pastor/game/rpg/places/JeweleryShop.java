package dms.pastor.game.rpg.places;

import dms.pastor.game.rpg.units.Hero;
import dms.pastor.game.rpg.commons.Msg;
import dms.pastor.game.rpg.items.Item;

import java.util.ArrayList;
import java.util.Scanner;


public class JeweleryShop extends Place {

    Scanner scanner = new Scanner(System.in);

    public JeweleryShop() {
        setName("Julian's Shop");
        setDescription("?");
    }

    @Override
    public void description() {
        System.out.println("Jewelry Shop");//TODO add description
    }

    @Override
    public void goToPlace() {
        boolean stay = true;
        while (stay) {
            System.out.println(Msg.sayHelloDependsOnHour());
            System.out.println("1.Buy Rings");
            System.out.println("2.Sell Rings");
            System.out.println("0.Exit");

            try {
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        //TODO implement it
                        System.out.println("You look through display shelfs you didn't find any interesting ring as they are not too magical.");
                        break;
                    case 2:
                        System.out.println("I will be extremly happy to buy all of them");
                        ArrayList<Item> items = Hero.getHero().inventory.getAllInventoryItems();
                        ArrayList<Item> itemsToDelete = new ArrayList<>();
                        int cashBack = 0;
                        for (Item item : items) {
                            if (item.getClass().getSimpleName().contains("Ring")) {
                                itemsToDelete.add(item);
                                cashBack += (item.getValue() / 5);
                            }
                        }
                        Hero.getHero().inventory.getAllInventoryItems().removeAll(itemsToDelete);
                        Hero.getHero().money.addMoney(cashBack);
                        System.out.println("You sold your books for:");
                        break;
                    case 0:
                        System.out.println("Goodbye and see you next time and remember READ MORE BOOKS.");//reference to wil whiton
                        stay = false;
                        break;
                    default:
                        System.out.println("*sigh*");
                        break;
                }
            } catch (Exception e) {
                System.out.println("You went to book shop .You saw books and then got panic attack You start sweating and start trouble breathing and then you  start scream, cry and then run away from this place. ");
                stay = false;
            }
        }
    }

}
