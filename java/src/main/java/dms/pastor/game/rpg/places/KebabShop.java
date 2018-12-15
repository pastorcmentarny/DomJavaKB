package dms.pastor.game.rpg.places;

import dms.pastor.game.rpg.HygieneRating;
import dms.pastor.game.rpg.cfg.Config;
import dms.pastor.game.rpg.items.food.Kebab;
import dms.pastor.game.rpg.units.Hero;

import java.util.Scanner;


public class KebabShop extends Place {

    private final HygieneRating rating;
    private final int priceBand;
    private final Scanner scanner = new Scanner(System.in);
    private final Hero hero;

    public KebabShop(Hero hero, String name, HygieneRating rating, int priceBand) {
        setName(name);
        this.hero = hero;
        this.rating = rating;
        this.priceBand = priceBand;
    }

    @Override
    public void goToPlace() {
        boolean goToMenu = true;
        while (goToMenu) {
            System.out.println("KebabMan gently said \"What do you want ?\n");
            System.out.println("1.Kebab\n2.Fish and Chips.\n3.Super Duper Burger\n4.Fizzy drink\n0.Exit");
            try {
                int selection = scanner.nextInt();
                switch (selection) {
                    case 1:
                        buyKebab();
                        break;
                    case 2:
                        //TODO implement it buyFishAndChips();
                        System.out.println("Sorry! we are run out of Fish and Chips for today");
                        break;
                    case 3:
                        //buyBurger();
                        System.out.println("Sorry! we are run out of Burgers for today");
                        break;
                    case 4:
                        //buyDrink();
                        System.out.println("Sorry! we are not allowed to sell drink at the moment");
                        break;
                    case 0:
                        goToMenu = false;
                        break;
                    default:
                        //FIXME log.debug("There is no action for input" + selection);
                        System.out.println("You look on menu and get so confused that you decided to exit,because you don't know what you want and you did you do in this place");
                        goToMenu = false;
                }
            } catch (Exception e) {
                //FIXME log.debug("Invalid input.");
                System.out.println("You look on menu and get so confused that you decided to exit,because you don't know what you want and you did you do in this place");
                goToMenu = false;
            }
        }
    }

    @Override
    public void description() {
        System.out.println(getName() + " {\n\t" + getDescription() + "\n\tRating:" + rating.info());
    }

    private void buyKebab() {
        Kebab kebab = new Kebab(40, rating.poisonChance() + 10, Config.PRICE_KEBAB);
        if (hero.money.hasEnoughMoney(kebab.getValue())) {
            hero.inventory.addItem(kebab);
            System.out.println("You bought a kebab");
        } else {
            System.out.println("You are too poor to buy this.");
        }
    }

    private void buyFishAndChips() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void buyBurger() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void buyDrink() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}
