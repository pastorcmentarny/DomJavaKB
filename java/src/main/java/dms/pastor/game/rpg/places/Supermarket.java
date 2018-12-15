package dms.pastor.game.rpg.places;

import dms.pastor.game.rpg.commons.Msg;
import dms.pastor.game.rpg.commons.Result;
import dms.pastor.game.rpg.items.EmpBomb;
import dms.pastor.game.rpg.items.weapons.BaseballBat;

/**
 * @author dominiksymonowicz
 */
public class Supermarket extends Place {


    private Result r;

    public Supermarket() {
        setName("Supermarket");
        setDescription("?");
    }

    @Override
    public void goToPlace() {
        boolean stay = true;
        while (stay) {
            System.out.println(Msg.sayHelloDependsOnHour());
            System.out.println("1.Emp bomb");
            System.out.println("2.buy baseball");
            System.out.println("0.Exit");

            try {
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        buyEmpBomb();
                        break;
                    case 2:
                        buyBaseball();
                        break;
                    case 0:
                        System.out.println("Goodbye and see you next time and remember READ MORE BOOKS.");//reference to wil whiton
                        stay = false;
                        break;
                    default:
                        System.out.println("*sigh*");
                        stay = false;
                        break;
                }
            } catch (Exception e) {
                System.out.println("You went to book shop .You saw books and then got panic attack You start sweating and start trouble breathing and then you  start scream, cry and then run away from this place. ");
                stay = false;
            }
        }
    }

    @Override
    public void description() {
        System.out.println(getDescription());
    }

    private void buyEmpBomb() {
        EmpBomb bomb = new EmpBomb();
        if (hero.money.hasEnoughMoney(bomb.getValue())) {
            hero.inventory.addItem(bomb);
            System.out.println("You bought an emp bomb");
        } else {
            System.out.println("You are too poor to buy this.");
        }
    }

    private void buyBaseball() {
        BaseballBat bb = new BaseballBat();
        r = hero.pay(bb.value, bb);
        System.out.println(r.getMessage());

    }
}
