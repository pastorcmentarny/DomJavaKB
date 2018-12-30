package dms.pastor.rpg.places;

import dms.pastor.rpg.HygieneRating;
import dms.pastor.rpg.units.Hero;
import dms.pastor.rpg.events.Chat;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * . "No-one told us there would be fish in the water. The children were scared."
 * "Although the brochure said that there was a fully equipped kitchen, there was no egg-slicer in the drawers."
 *  "On my holiday to Goa in India, I was disgusted to find that almost every restaurant served curry. I don't like spicy food."
 *   "We found the sand was not like the sand in the brochure. Your brochure shows the sand as white but it was more yellow."
 *   "I was bitten by a mosquito. The brochure did not mention mosquitoes."
 *
 *   Xmas event between 24 and 26 Remember
 * xmas tree in aber is ugiliest tree in UK.
 */
class Aberystwyth {

    private final Scanner scanner = new Scanner(System.in);
    private final TrainStation station = new TrainStation();
    private boolean stationVisited = false;
    private final Hero hero = Hero.getHero();

    public Aberystwyth() {
    }

    public void goToPlace(int steps) {
        boolean stay = true;
        while (stay) {
            System.out.println("What do you want to do ?");
            System.out.println("1.Go to Kebab Shop\n2.Go to Bank\n3.Go for clubbing\n4.Talk to somebody");
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

    private static void getImprovementWorksMessage(){
        //Many roads will be closed due to improvements work and characters will complain about how lazy developer is to do this game
    }
}
