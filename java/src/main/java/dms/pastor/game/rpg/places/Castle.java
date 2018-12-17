package dms.pastor.game.rpg.places;

import dms.pastor.game.rpg.Game;
import dms.pastor.game.rpg.units.Hero;

import java.util.Scanner;


public class Castle extends Place {
    private final Scanner scanner = new Scanner(System.in);
    private final Hero hero = Hero.getHero();
    private final int saidNo = 0;

    @Override
    public void description() {
        throw new UnsupportedOperationException("You stayed in front of Edward I's late 13th century castles. Castle ."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void goToPlace() {
        if (hasPermissionForEntrance()) {
            goToMainSquare();
        } else {
            System.out.println();
            if (saidNo == 2) {
                //battle with royal knight lvl 80. heavy armored
            }
            if (saidNo >= 3) {
                Game.gameOver("Jail", hero.getName());
            }
        }
    }

    private boolean hasPermissionForEntrance() {
        return hero.hasCastlePermission();
    }

    private void goToMainSquare() {
        boolean displayMenu = true;
        while (displayMenu) {
            System.out.println("You are in main square.Where do you want to go ?");
            System.out.println("1.Visit a king");
            System.out.println("2.Visit an advisory");
            System.out.println("9.Go to vending machine");
            System.out.println("0.Leave a castle");
            int choice = scanner.nextInt();
            switch (choice) {
                case 9:
                    CommonPlaces.vendingMachine(true);
                    break;
                case 1:
                    if (isKingInTheCastle()) {

                    } else {
                        System.out.println("You came to the door,but you saw to overmuscled knights who said friendly.. GO AWAY PEASANT! NO ENTRY!");
                    }
                    break;
                case 2:
                    if (isAnybodyInAdvisory()) {

                    } else {
                        System.out.println("You arrived to advisory room,but you see note:\n\t\"There is no advisory today.\n\tFor any enquiry please come here again when we are actually inside.\n\nFAQ:\n\tWhen is next meeting?\n\tSoon.\"\n*Sigh*");
                    }
                    break;
                case 0:
                    displayMenu = false;
                    System.out.println("You leave castle.");
                    break;
                default:
                    displayMenu = false;
                    System.out.println("You was kick out from castle as you just walk like chicken without head,so it looks too suspicious for guards");
                    break;

            }
        }

    }

    private boolean isKingInTheCastle() {
        return false; //TODO implement king story
    }

    private boolean isAnybodyInAdvisory() {
        return false; //TODO Implement advisory
    }
}