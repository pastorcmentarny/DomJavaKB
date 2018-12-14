package dms.pastor.game.rpg.quests;

import dms.pastor.game.rpg.Bonus;
import dms.pastor.game.rpg.items.Item;
import dms.pastor.game.rpg.items.weapons.YamatoGun;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;


public class Day9Quests extends Quest {
    QuestMonitor progress = QuestMonitor.getQuestMonitor();

    Scanner scanner = new Scanner(System.in);
    String[] tutorials = {"This is a RPG game", "About buttons", "How to configure  character", "Warnings and other small prints"};

    //==//
    String startOfTutorialText = "In today's episode...";
    //==//

    public void talk() {
        boolean stay = true;
        System.out.println("Welcome to Day[9] when we learn to be A BETTER GAMER.What can I do today ?");
        while (stay) {
            System.out.println("What do you want to do ?");
            System.out.println("1.Tutorial");
            System.out.println("2. Tell me more about your show..");
            if (progress.kittenQuestState.equals(QuestState.AVALIABLE)) {
                System.out.println("3. Where are kittens?");
            } else if (progress.kittenQuestState.equals(QuestState.INPROGRESS)) {
                System.out.println("3. I have some news about your kittens.");
            }

            if (progress.mutaSpiderQuestState.equals(QuestState.AVALIABLE)) {
                System.out.println("3. I can tell you story");
            } else if (progress.mutaSpiderQuestState.equals(QuestState.INPROGRESS)) {
                System.out.println("3. I have some news about mutaspider.");
            }
            System.out.println("4.What's  day today?");
            System.out.println("0.Exit");

            try {
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        runNextTutorial();
                        break;
                    case 2:
                        aboutDay9();
                        break;
                    case 3:
                        if (progress.mutaSpiderQuestState.equals(QuestState.AVALIABLE)) {
                            System.out.println("3. Where are kittens?");
                        } else if (progress.mutaSpiderQuestState.equals(QuestState.INPROGRESS)) {
                            System.out.println("3. I have some news about your kittens.");
                        }

                        if (progress.mutaSpiderQuestState.equals(QuestState.AVALIABLE)) {
                            System.out.println("3. I can tell you story");
                        } else if (progress.mutaSpiderQuestState.equals(QuestState.INPROGRESS)) {
                            System.out.println("3. I have some news about mutaspider.");
                        }
                        break;
                    case 4:
                        System.out.println("It's Day 9,KABOOM");
                        break;
                    case 0:
                        stay = false;
                        System.out.println("You left city...");
                }
            } catch (InputMismatchException ime) {
                //FIXME log.info("user type something weird ... " + ime.getMessage());
                System.out.println("You get lost in the city ... press number!");
            }
        }
    }

    //TODO implement tutorial,when will be ready
    public void runTutorial(int chapter) {
        System.out.println(tutorials[chapter]);
    }

    @Override
    public Bonus getReward() {
        ArrayList<Item> items = new ArrayList<>();
        items.add(new YamatoGun());
        return new Bonus(items);
    }

    @Override
    public boolean canQuestBeActivated() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateQuestState() {
        if (progress.kittenQuestState.equals(QuestState.COMPLETED) && progress.mutaSpiderQuestState.equals(QuestState.NOT_AVALIABLE)) {
            progress.mutaSpiderQuestState = QuestState.AVALIABLE;
        }

    }

    //TODO temporary pseudo implementation
    private void runNextTutorial() {
        runTutorial(new Random().nextInt(tutorials.length));
    }

    private void aboutDay9() {
        System.out.println("The Day[9] Daily is an internet television show streamed live by USA over Twitch.TV few days at week. The host of the show, Day[9], offers Day9's personal reflections about e-sport (mostly blizzard games like Starcraft and Hearthstone) and Day9 day offs and my favorite show Mostly Walking.");
    }

    @Override
    public void startAQuest() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
