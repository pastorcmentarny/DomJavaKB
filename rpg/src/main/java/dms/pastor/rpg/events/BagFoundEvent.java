package dms.pastor.rpg.events;

import dms.pastor.rpg.commons.Msg;
import dms.pastor.rpg.commons.Result;
import dms.pastor.rpg.items.Items;
import dms.pastor.rpg.units.Hero;

import java.util.Random;
import java.util.Scanner;


public class BagFoundEvent implements EventInterface {
    static //FIXME log.er //FIXME log.= //FIXME log.er.get//FIXME log.er(RPGLauncher.class);

            Scanner scanner = new Scanner(System.in);

    private Result result = new Result(false);
    private final Hero hero;

    public BagFoundEvent(Hero hero) {
        this.hero = hero;
    }


    @Override
    public void doEvent() {
        System.out.println("Interesting.You found a bag.");
        int number = new Random().nextInt(13);
        switch (number) {
            case 0:
                WalletStory();
                break;
            case 1:
            case 2:
                KarmaStory();
                break;
            case 3:
            case 4:
            case 5:
            case 6:
            case 8:
                WomanBagStory();
            default:
                result = new Result(false, "Unfortunately,Bag was empty");
                break;
        }

        
            /*
        //60% nothing
        //1% rare item
        //14% item
        //25% money
    */


    }

    @Override
    public Result getReward() {
        return result;
    }

    private void WalletStory() {
        System.out.println("You found a wallet on the road with some coins inside as it didn't look ");
        result = new Result(true, "You found money", new Random().nextInt(hero.lvl * 13 + 1));
    }

    private void KarmaStory() {
               /* TODO
        "You found a bag.
        1. Trying to identify owner
            1.1 if successful,you will get karma +1
            1.2 if unsuccessful ,then take stuff
        2. Take stuff (-5 karma)
        
        */
        int number = new Random().nextInt(101);

        if (number == 100) {
            result = new Result(true, "You found a rare item", Items.generateRareItem());
        } else if (number > 85) {
            result = new Result(true, "You found a item", Items.generateRareItem());
        } else if (number > 60) {
            result = new Result(true, "You found money", new Random().nextInt(hero.lvl * 13 + 1));
        } else {
            result = new Result(false, "It was an empty bag");
        }

    }

    //TODO improve it
    private void WomanBagStory() {
        System.out.println("Woman bags always contains black hole that sucks all things that women believes they really needs.. You spent ages to find anything ,but you didn't find anything valuable or useful... ");
        result = new Result(true, "You found 1 coin", 1);
    }

    @Override
    public void help() {
        Msg.noHelp();
    }


}
