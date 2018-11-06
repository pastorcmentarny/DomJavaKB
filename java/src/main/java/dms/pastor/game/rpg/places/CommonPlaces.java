package dms.pastor.game.rpg.places;

import dms.pastor.game.rpg.units.Hero;
import dms.pastor.game.rpg.commons.Errors;
import dms.pastor.game.rpg.exceptions.NoEnoughMoneyException;

import java.util.Random;
import java.util.Scanner;


public class CommonPlaces {

    public static void vendingMachine(boolean isWorks) {
        Hero hero = Hero.getHero();
        if (!isWorks) {
            System.out.println("Out of order. Error code:" + Errors.getRandomCode());
            return;
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("You arrived to vending machine.What do you want to do?");
        System.out.println("1. Buy coffee");
        System.out.println("2. Buy health potion");
        System.out.println("3. Buy mana potion");
        System.out.println("0. Exit");

        boolean displayMenu = true;
        while (displayMenu) {
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    try {
                        buyCoffee();
                    } catch (InterruptedException ex) {
                        hero.gotInjured("Vending machine exploded");
                    }
                    break;
                case 2:
                    buyHealthPotion();
                    break;
                case 3:
                    buyManaPotion();
                    break;
                case 0:
                    displayMenu = false;
                    System.out.println("Vending machine displays message ... goodbye");
                default:

            }
        }

    }

    private static void buyCoffee() throws InterruptedException {
        String[] failureReasons = {"coffee machine did give cup so coffe went to stink", "coffee machine didn't give change", "cofffee machine gave only hot water"};
        Hero hero = Hero.getHero();
        if (hero.money.hasEnoughMoney(50)) {
            try {
                hero.money.takeMoney(50);
            } catch (NoEnoughMoneyException ex) {
                System.out.println(Errors.getNotEnoughMoney());
            }
            System.out.println("You inserted money");
            Thread.sleep(500);
            System.out.println("You select coffee");
            Thread.sleep(500);
            System.out.println(" .. and then ... ufortunately .." + failureReasons[new Random().nextInt(failureReasons.length)]);
            System.out.println("It seems this bloody mechanical toys must be cursed.");
        } else {
            System.out.println("F*** You! - You said fondly to vending machine ,you have enough money,but coins are not accepting some of your coins.Bloody technology.");
        }
    }

    private static void buyHealthPotion() {
        //TODO implment it
        Errors.outOfStock();
    }

    private static void buyManaPotion() {
        //TODO implment it
        Errors.outOfStock();
    }


    static String getCommentAboutWeather() {
        return "It's raining again...";
    }
}
