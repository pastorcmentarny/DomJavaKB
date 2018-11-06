package dms.pastor.game.rpg.places;

import dms.pastor.game.rpg.HygieneRating;
import dms.pastor.game.rpg.events.Chat;
import dms.pastor.game.rpg.units.Hero;

import java.util.InputMismatchException;
import java.util.Scanner;


public class Aberystwyth {

    Scanner scanner = new Scanner(System.in);
    //---
    TrainStation station = new TrainStation();
    //---
    boolean stationVisited = false;
    private Hero hero = Hero.getHero();

    public Aberystwyth() {
    }

    public void goToPlace(int steps) {
        boolean stay = true;
        while (stay) {
            System.out.println("What do you want to do ?");
            System.out.println("1.Go to Kebab Shop\n2.Go to Bank\n3.Go for clubing\n4.Talk to somebody");
            System.out.println("5.Go to train station\n6.Go to BookShop.7.Go to Jewelery Shop\n8.Go to supermarket");
            System.out.println("0.Exit");

            try {
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        KebabShop kebab = new KebabShop(hero, "Licking Taste", HygieneRating.TWO, 2);
                        kebab.description();
                        kebab.goToPlace();
                        break;
                    case 2:
                        Bank bank = Bank.getBank();
                        bank.updateDataSinceLastVisit(steps);
                        bank.description();
                        bank.goToPlace();
                        break;
                    case 3:
                        System.out.println("Pier is closed.");
                        break;
                    case 4:
                        Chat chat = new Chat();
                        chat.doEvent();
                        break;
                    case 5:
                        if (stationVisited) {
                            System.out.println("You are too young to die,to go to this hell again.");
                        } else {
                            station.description();
                            station.goToPlace();
                            stationVisited = true;
                        }
                        break;
                    case 6:
                        BookShop book = new BookShop();
                        book.goToPlace();
                        break;
                    case 7:
                        JeweleryShop jewelery = new JeweleryShop();
                        jewelery.goToPlace();
                        break;
                    case 8:
                        Supermarket shop = new Supermarket();
                        shop.goToPlace();
                        break;
                    case 0:
                        stay = false;
                        System.out.println("You left city...");
                        break;
                    default:
                        System.out.println("You walk to road that is dead end... you go back and choose ..");
                        break;
                }
            } catch (InputMismatchException ime) {
                System.out.println("You get lost in the city ... press number!");
            }
        }
    }
}
