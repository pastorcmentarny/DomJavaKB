package dms.pastor.game.rpg.places;

import dms.pastor.game.rpg.commons.Msg;
import dms.pastor.game.rpg.exceptions.GameOverException;
import dms.pastor.game.rpg.units.Hero;
import dms.pastor.game.rpg.utils.MathUtils;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;


public class Bank extends Place {

    private static Bank bank = null;
    private final Hero hero = Hero.getHero();
    int deposit = 1;
    int loan = 306552;
    int loanLimit = 15000;
    int borrowCharge = 249;
    int transactionCharge = 49;
    int maxLoanLimit = 10000;
    double interestRate = 1.8; //economic students +1
    double loanRate = 2.2; //economic students -1
    int lastVisit = 0;
    Scanner scanner = new Scanner(System.in);
    //===//
    String transactionChargeError = "Transaction Charge is higher that amount money you want to pay back.";
    //===//

    private Bank() {
    }

    public static synchronized Bank getBank() {

        if (bank == null) {
            bank = new Bank();
        }
        return bank;
    }

    @SuppressWarnings("CloneDoesntCallSuperClone")
    @Override
    public final Object clone() throws CloneNotSupportedException {
        //FIXME log.error("Clone not supported exception!");
        throw new CloneNotSupportedException();
    }

    @Override
    public void goToPlace() {
        boolean stay = true;
        while (stay) {
            System.out.println("What do you want to do ?");
            System.out.println("1.Add money to Savings\n2. Withdraw money from Savings");
            System.out.println("3.Borrow money from Bank\n4.Pay loan");
            System.out.println("5.Check balance");
            System.out.println("0.Exit");
            System.out.println("Smallprint: We charge  small fee (" + transactionCharge + ") for each transaction (add/remove/borrow pay back).");

            try {
                int choice = scanner.nextInt();
                int amount = 0;
                switch (choice) {
                    case 1:
                        addMoneyToSaving();
                        break;
                    case 2:
                        takeMoneyFromSavings();
                        break;
                    case 3:
                        System.out.println("Due system glitch,we are unable to process any loan application.\n" + Msg.apologize());
                        //TODO implement borrowing
                        break;
                    case 4:
                        if (loan > 0) {
                            payBackLoan();
                        } else {
                            System.out.println("Are you drunk?You don't have loan.Be good students ,waste your money on alkocholic beverages !");
                        }
                        break;
                    case 5:
                        displayBalance();
                        break;
                    case 0:
                        stay = false;
                        System.out.println("You left city...");
                }
            } catch (InputMismatchException ime) {
                System.out.println("You get lost in the city ... press number!");
            }
        }
    }

    @Override
    public void description() {
        System.out.println("Bank ");
    }

    public void updateDataSinceLastVisit(int today) {
        for (int i = lastVisit; i < today; i++) {
            if (i % 10 == 0) {
                System.out.println("Before status: SAVINGS=" + deposit + " :LOAN=" + loan);
                deposit = MathUtils.increaseByPercent(deposit, interestRate);
                loan = MathUtils.increaseByPercent(loan, loanRate);
                System.out.println("After status: SAVINGS=" + deposit + " :LOAN=" + loan);
            }
            if (i % 31 == 0) {
                int pocketMoneyBonus = new Random().nextInt(250);
                System.out.println("Parents sent some pocket money.You got " + pocketMoneyBonus + " coins more on your account.");
                deposit += pocketMoneyBonus;
            }
        }
        lastVisit = today;

    }

    public int addLoad(int value) throws GameOverException {
        loan += value;
        if (loan > maxLoanLimit) {
            throw new GameOverException("You debt are too high.You got to jail to fraud money");
        }
        System.out.println("You borrow");
        return loan;
    }

    private void displayBalance() {
        System.out.println("====BANK's MONEY MANAGMENT SYSTEM====");
        System.out.println("You have: " + hero.money.showMoney() + "\nYour Saving balance is: " + deposit + "(Interest rate:" + interestRate + "%)\nYour loan balance is: " + loan + "(Loan Interest rate:" + loanRate + "%)");
        System.out.println("====================================");
    }

    private void addMoneyToSaving() {
        System.out.println("How much you want to put on your saving account?");
        try {
            int amount = scanner.nextInt();
            if (amount <= transactionCharge) {
                System.out.println(transactionChargeError);
                return;
            }
            if (hero.money.hasEnoughMoney(amount)) {
                hero.money.takeMoney(amount);
                amount -= transactionCharge;
                deposit += amount;

                System.out.println("You transfer " + amount + " to your saving account.(We charged " + transactionCharge + "for this transaction.");
            } else {
                System.out.println("Poor thing... you need have that amount money in order to transfer .");
            }
        } catch (Exception e) {
            //FIXME log.warn("Invalid input from user or other shit happens while adding money to savings. " + e.getMessage());
            System.out.println("Nice junk,but we are bank not srapyard.");
        }
    }

    private void takeMoneyFromSavings() {
        System.out.println("How much you want take from your saving account?");

        try {
            int amount = scanner.nextInt();

            if (amount < transactionCharge) {
                System.out.println(transactionChargeError);
                return;
            }

            if (amount <= deposit) {
                deposit -= amount;
                amount -= transactionCharge;
                hero.money.addMoney(amount);
                System.out.println("You transfer " + amount + " from your saving account.(We charged " + transactionCharge + "for this transaction.");
            } else {
                System.out.println("Poor thing... you need have that amount money on your Savings in order to transfer .");
            }
        } catch (Exception e) {
            //FIXME log.warn("Invalid input from user or other shit happens while adding money to savings. " + e.getMessage());
            System.out.println("Nice junk,but we are bank not srapyard.");
        }
    }

    private void payBackLoan() {
        System.out.println("How much you want to pay back ?");
        try {
            int amount = scanner.nextInt();
            if (amount < transactionCharge) {
                System.out.println("Transaction Charge is higher that amount money you want to pay back.");
                return;
            }
            if (hero.money.hasEnoughMoney(amount)) {
                amount -= transactionCharge;
                loan -= hero.money.takeMoney(amount);
                int charity = 0;
                if (loan < 0) {
                    charity = Math.abs(loan);
                    loan = 0;
                }
                System.out.println("You returned " + amount + "." + "You have " + loan + "left,so be quick. (We charged " + transactionCharge + "for this transaction.");
                if (charity > 0) {
                    System.out.println("As you pay more than you should,we will send change to charity. PoorStudentsCharity says thank you.");
                    hero.plainStats.addKarma(1);
                }

            } else {
                System.out.println("Poor thing... you need have that amount money in order to transfer .");
            }
        } catch (Exception e) {
            //FIXME log.warn("Invalid input from user or other shit happens while adding money to savings. " + e.getMessage());
            System.out.println("Nice junk,but we are bank not srapyard.");
        }
    }

}
