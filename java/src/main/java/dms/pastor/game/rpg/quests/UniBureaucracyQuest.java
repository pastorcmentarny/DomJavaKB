package dms.pastor.game.rpg.quests;

import dms.pastor.game.rpg.Bonus;
import dms.pastor.game.rpg.Game;
import dms.pastor.game.rpg.places.Castle;
import dms.pastor.game.rpg.units.Hero;

import java.util.Scanner;

/**
 * @author Pastor Created Jan 18, 2015 at 7:35:47 PM
 * rules
 * - you need fulfill 10 appplication
 * - if you go to wrong room 3 times,you application will be refused
 * - if you say that you are international student then you need do 2 extra task .. one in chinese.another one in polish
 */
public class UniBureaucracyQuest extends Quest {

    private static String[] locked = {"Door is locked.", "Knock,knock... no response", "There is message on door that said .I will back in 5 minutes.. After 1 hour of waiting you notice few skeleton siting on chair next to room.You abaddon idea to go to this room."};
    String[] stories = {"You pass room and you saw few skeletons .It was some students still waiting for resonse from univesristy regards (...)", "You met a pissed off student.You asked ... what happen? She responsed: I went to wrong rooms 3 times and now i must do my application again!", " "};
    private final Scanner scanner = new Scanner(System.in);
    int floor = 0;

    @Override
    public void startAQuest() {
        System.out.println("You arrived to Old college beautiful place that is full of evil people");
        boolean stay = true;
        while (stay) {
            System.out.println("Where do you want go ?");
            System.out.println("1.Go to floor 1");
            System.out.println("2.Go to floor 2");
            System.out.println("3.Go to floor 3");
            System.out.println("4.Go to floor 4");
            System.out.println("5.Go to floor 5");
            System.out.println("6.Go to Reception");
            if (QuestMonitor.getQuestMonitor().isToiletLevelAvaliable()) {
                System.out.println("1337. Go to toilet");
            }
            System.out.println("0.Exit");
            stay = false;
            try {
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        Castle castle = new Castle();
                        castle.goToPlace();
                        break;

                    case 1337:
                        if (isToiletLevelAvaliable()) {
                            toilet();
                        } else {
                            System.out.println("You see sign \'NO ENTRY!\' Are you sure, you want enter? ");
                            System.out.println("YES");//implement decision
                            System.out.println("You see more NO ENTRY and DANGER OF DEATH sings on corridors , are you really sure?");
                            System.out.println("YES");//implement decision
                            System.out.println("You was tempted to go to this small corridor that with stars  going down ... you saw warnings.. \'Don't use these toilets - out of order\' , \'Danger! You can be killed! NO ENTRY\' , but you ignored these signs and go downstairs and enter into darkness ... then you feel strange pulling sensetion ... you was sucked by liquid into pipes and drop into sewer where you was devoured by mystirious monster. You last though was 'I wish I read with understanding and follow these instructions ");
                            Game.gameOver("sucked by toilet", Hero.getHero().getName());
                        }

                }
            } catch (Exception e) {
                System.out.println("You went to dead-end corridor..");
            }
        }

    }

    @Override
    public Bonus getReward() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean canQuestBeActivated() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    //TODO  Application form will starts  from shortcut  Wtf015 wta Fo100  Będzie 20 zadań  Each application will be 10 simple question

    @Override
    public void updateQuestState() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private boolean isToiletLevelAvaliable() {
        return false;// TODO implement wc-level
    }

    private void toilet() {
        //toilet with tressures and hidden passage to cave where lochness monster lives
    }

    public void floor(int floor) {
        System.out.println("You are on " + floor + " floor.Where do you want go?");
        boolean stay = true;
        while (stay) {
            for (int i = 1; i <= 20; i++) {
                System.out.println("1.Check room " + floor + (i > 11 ? i : "0" + i));
            }

            if (QuestMonitor.getQuestMonitor().isToiletLevelAvaliable()) {
                System.out.println("1337. Go to toilet");
            }
            System.out.println("0.Exit");

            try {
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        Castle castle = new Castle();
                        castle.goToPlace();
                        break;
                    case 0:
                        System.out.println("Back to main hall");
                        stay = false;
                }
            } catch (Exception e) {
                System.out.println("?");
            }
        }
    }


}
