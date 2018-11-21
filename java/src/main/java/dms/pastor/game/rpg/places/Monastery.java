package dms.pastor.game.rpg.places;

import dms.pastor.game.rpg.Game;
import dms.pastor.game.rpg.Money;
import dms.pastor.game.rpg.cfg.Config;
import dms.pastor.game.rpg.characteristics.Attribute;
import dms.pastor.game.rpg.commons.Result;
import dms.pastor.game.rpg.exceptions.NoEnoughMoneyException;
import dms.pastor.game.rpg.items.potions.*;
import dms.pastor.game.rpg.units.Hero;

/**
 * @author dominiksymonowicz
 */
public class Monastery extends Place {
    Hero hero = Hero.getHero();

    public Monastery() {
        name = "Monastery";
        description = "This is brand new Monastery .Old one called Natural Human Society was famous for endless queue,treatment. In short,if you go there ,you will never back healthy again.  ";
    }

    @Override
    public void description() {
        System.out.println("It is a brand new monastery ");//TODO write description
    }

    @Override
    public void goToPlace() {
        System.out.println("Warm welcome to " + name + "!.Would you like to make voluntary donation?");
        boolean stay = true;
        while (stay) {
            System.out.println("1. Pay donatation (Cost:" + calcFee() + ")");
            System.out.println("2. Ignore zakonnice and enter into " + name);
            System.out.println("3. Start argue about ,why donation is so expensive..");
            System.out.println("0. Exit");

            try {
                int selection = scanner.nextInt();
                switch (selection) {
                    case 1:
                        stay = payFee();
                        break;
                    case 2:
                        attemptToEnter();
                        break;
                    case 3:
                        diplomacy();
                        break;
                    case 0:
                        System.out.println("It was nice to see you and we hope to see you again.");
                        stay = false;
                        break;
                }
            } catch (Exception e) {
                System.out.println("You trying to explain what you want but you sounds like homeless ,so they gave you a bread and kindly say they are FULL and they can't acept any more homeless student at the moment ." + e.getMessage());
            }
        }
    }

    public int calcFee() {
        int fee = hero.lvl * 10;
        if (hero.nativeAttributes.contains(Attribute.ECONOMICS)) {
            fee = Money.getDisccountedPrice(fee, 25);
        }
        return fee;
    }

    private boolean payFee() {
        if (hero.money.hasEnoughMoney(calcFee())) {
            try {
                hero.money.takeMoney(calcFee());
                enterToMonastery();
                return false;
            } catch (NoEnoughMoneyException ex) {
                System.out.println("You don't have enough money :(" + ex.getMessage());
            }
        } else {
            System.out.println("You don't have enough money :(");
        }
        return true;
    }

    private void attemptToEnter() {
        //TODO implement 
        System.out.println("You tried to get to place by you was strike by lighting");
        hero.plainStats.doesDirectDMGtoHP(10 * hero.lvl);
        System.out.println("It does " + 10 * hero.lvl + "dmg.");
        if (hero.isAlive()) {
            System.out.println("It hurts you,but it didn't kill you ...yet.");
        } else {
            System.out.println("... which killed you.");
            Game.gameOver("upset GOD with you bad behave", hero.getName());
        }
    }

    private void diplomacy() {
        if (hero.nativeAttributes.contains(Attribute.DIPLOMACY)) {
            if (random.nextInt(101) > 40) {
                enterToMonastery();
            }
        }
        if ((2 * hero.skills.getCharisma()) + hero.skills.getIntelligence() >= 20) {
            if (random.nextInt(101) >= 60) {
                enterToMonastery();
            }

        }
    }

    private void enterToMonastery() {
        boolean stay = true;
        while (stay) {
            System.out.println("1.Pray (Free)");
            System.out.println("2. Heal & Cure (" + calcTreatmentFee() + ")");
            System.out.println("3. Shop");
            System.out.println("4. Talk");
            System.out.println("0. Exit");
            try {
                int selection = scanner.nextInt();
                switch (selection) {
                    case 1:
                        pray();
                        break;
                    case 2:
                        treatment();
                        break;
                    case 3:
                        shop();
                        break;
                    case 4:
                        talk();
                        break;
                    case 0:
                        stay = false;
                        break;
                    default:
                        System.out.println("You couldn't decide what you want,so you leave monastey.");
                }
            } catch (Exception e) {
                System.out.println("You couldn't decide what you want,so you leave monastey." + e.getMessage());
            }
        }
    }

    private void pray() {
        System.out.println("You prayed for hours.I hope you feel better now.");
    }

    private int calcTreatmentFee() {
        int price = 100;
        if (hero.state.isCursed()) {
            price += 75;
        }
        if (hero.state.isWeak()) {
            price += 25;
        }
        if (hero.state.hasDisease()) {
            price += 150;
        }
        if (hero.nativeAttributes.contains(Attribute.ECONOMICS)) {
            price = Money.getDisccountedPrice(price, Config.DEFAULT_DISCOUNT * 2);
        }
        return price;
    }

    private String treatment() {
        if (hero.money.hasEnoughMoney(calcTreatmentFee())) {
            hero.state.clearAllNegativeStates();
            hero.plainStats.restoreAll();
            return "Treatment completed.You are fully recovered";
        } else {
            return "No money.No treatment.";
        }

    }

    private void shop() {
        boolean stay = true;
        while (stay) {

            //TODO implement , show prices
            System.out.println("What you would like to buy?\n");
            System.out.println("1.Buy healing potion\n2.Buy mana potion.");
            System.out.println("3.Buy Anitode \n4.buy cure potion");
            System.out.println("5.Make donation\n0.Exit");
            try {
                int selection = scanner.nextInt();
                switch (selection) {
                    case 1:
                        buyHealingPotion();
                        break;
                    case 2:
                        buyManaPotion();
                        break;
                    case 3:
                        buyAnitodePotion();
                        break;
                    case 4:
                        buyCurePotion();
                        break;
                    case 5:
                        donation();
                        break;
                    case 0:
                        stay = false;
                        break;
                    default:
                        //FIXME log.debug("There is no action for input" + selection);
                        System.out.println("You look on menu and get so confused that you decided to exit,because you don't know what you want and you did you do in this place");
                        stay = false;
                }
            } catch (Exception e) {
                //FIXME log.debug("Invalid input.");
                System.out.println("You look on menu and get so confused that you decided to exit,because you don't know what you want and you did you do in this place");
                stay = false;
            }
        }
    }

    private void donation() {
        int donation = random.nextInt(100) + 1;
        if (hero.money.hasEnoughMoney(donation)) {
            System.out.println("You donate " + donation + " .It will go to good causes.");
        }
    }

    private void buyHealingPotion() {
        Result r = hero.pay(Config.PRICE_HEAL_POTION, new HealingPotion(PotionSize.MINOR));
        System.out.println(r.getMessage());
    }

    private void buyManaPotion() {
        Result r = hero.pay(Config.PRICE_MANA_POTION, new ManaPotion(PotionSize.MINOR));
        System.out.println(r.getMessage());
    }

    private void buyAnitodePotion() {
        Result r = hero.pay(Config.PRICE_ANTIDOTE_POTION, new AntidotePotion(PotionSize.MINOR));
        System.out.println(r.getMessage());
    }

    private void buyCurePotion() {
        Result r = hero.pay(Config.PRICE_CURE_POTION, new CurePotion(PotionSize.MINOR));
        System.out.println(r.getMessage());
    }

    private void talk() {
        System.out.println("Zakonnice seems to be busy");
        //TODO Kamila will gives you a free heal if you have a very good karma
        //TODO Beata selling a magical rings
    }
}
