package dms.pastor.rpg.game.events;

import dms.pastor.rpg.game.commons.Msg;
import dms.pastor.domain.Result;
import dms.pastor.rpg.game.units.Hero;
import dms.pastor.rpg.game.units.enemies.animals.Seagull;

import java.util.Random;
import java.util.Scanner;

/**
 * @author Pastor Created Jan 18, 2015 at 2:09:36 AM
 */
public class SeagullEvent implements EventInterface {

    private EVENT_Result result = EVENT_Result.NOTHING;
    private final Hero hero;
    int reward = 0; //1 - luckily shit ,it gives you +1karma +**%
    private final Seagull seagull;
    private final Scanner scanner = new Scanner(System.in);
    private final Random random = new Random();

    public SeagullEvent(Hero hero, Seagull seagull) {
        this.hero = hero;
        this.seagull = seagull;
    }

    @Override
    public Result getReward() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void doEvent() {
        System.out.println("Seagull attempting to shit on you..");

        int number = new Random().nextInt(101);
        if (seagull.plainStats.getAccuracy() > number) {
            System.out.println("Shit hits you.");
            Seagull.shitAttack(Hero.getHero());
            boolean notAnswered = true;
            while (notAnswered) {
                System.out.println("What do you want to do?\n 1.Throw a stone in revenge.\n2.Do nothing.");
                try {
                    System.out.println("Type number  on keyboard..");
                    int guess = scanner.nextInt();
                    if (guess == 1) {
                        System.out.println("You threw a stone..");
                        throwStone();
                        notAnswered = false;
                    } else if (guess == 2) {
                        System.out.println("You just ignore it.");
                        ignoreIt();
                        notAnswered = false;
                    } else {
                        System.out.println("Try again");
                    }
                } catch (Exception e) {
                    System.out.println("Try again");
                }
            }
        } else {
            System.out.print(".. but it misses and flew away,before you react.");
        }

    }
//you can throw stone
//poo can double your luck

    public EVENT_Result gerResult() {
        return result;
    }

    private void throwStone() {
        int chance = random.nextInt(101);
        System.out.println("You get angry and you threw a stone ..");
        if (chance > 66 - hero.skills.getDexterity()) {
            System.out.print(".. but you missed.");
            chance = random.nextInt(101);
            if (chance > 80) {
                System.out.println("Seagull just flew away");
                result = EVENT_Result.FLEW_AWAY;
            } else {
                System.out.println("Seagull spotted your stone and shit on you again and that;");
                Seagull.shitAttack(Hero.getHero());
                result = EVENT_Result.DAMAGE;
            }
        } else {
            System.out.print(".. and you hit it.");
            if (chance == 100) {
                System.out.println("Good news is that seagull flew away. Bad news is Seagull Queen came to fight with you ");
                result = EVENT_Result.QUEEN_ATTACK;
            }
            if (chance > 75) {
                System.out.println("Seagull get angry and attack you.");
                result = EVENT_Result.ATTACK;
            } else {
                int bonus = hero.lvl + seagull.lvl;
                System.out.println("Seagull just flew away.You got " + bonus + " experience for hit");
                hero.exp += bonus;
                result = EVENT_Result.FLEW_AWAY;
            }

        }

    }

    private void ignoreIt() {
        int chance = random.nextInt(101);
        if (chance == 100) {
            System.out.println("Shit happens but after  ");
            result = EVENT_Result.LUCKY_SHIT;
        }
        if (chance > 90) {
            System.out.println("Shit was radioactive and destroyed your armor");
            result = EVENT_Result.DESTROY_ARMOR;
        } else if (chance > 70) {
            System.out.println("Shit was radioactive and it hurts your and  poisoned you.");
            result = EVENT_Result.FLEW_AWAY;
        } else {
            System.out.println("You just clean shit and carry on.");
            result = EVENT_Result.NOTHING;

        }

    }

    @Override
    public void help() {
        Msg.noHelp();
    }

    public enum EVENT_Result {

        NOTHING, ATTACK, FLEW_AWAY, QUEEN_ATTACK, LUCKY_SHIT, DAMAGE, DESTROY_ARMOR
    }

}
