package dms.pastor.rpg.quests;

import dms.pastor.rpg.Bonus;
import dms.pastor.rpg.items.Item;
import dms.pastor.rpg.items.weapons.YamatoGun;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;


public class Day9Quests extends Quest {
    private final QuestMonitor progress = QuestMonitor.getQuestMonitor();

    private final Scanner scanner = new Scanner(System.in);
    private final String[] tutorials = {"This is a RPG game", "About buttons", "How to configure  character", "Warnings and other small prints"};

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
            if (progress.kittenQuestState.equals(QuestState.AVAILABLE)) {
                System.out.println("3. Where are kittens?");
            } else if (progress.kittenQuestState.equals(QuestState.IN_PROGRESS)) {
                System.out.println("3. I have some news about your kittens.");
            }

            if (progress.mutaSpiderQuestState.equals(QuestState.AVAILABLE)) {
                System.out.println("3. I can tell you story");
            } else if (progress.mutaSpiderQuestState.equals(QuestState.IN_PROGRESS)) {
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
                        if (progress.mutaSpiderQuestState.equals(QuestState.AVAILABLE)) {
                            System.out.println("3. Where are kittens?");
                        } else if (progress.mutaSpiderQuestState.equals(QuestState.IN_PROGRESS)) {
                            System.out.println("3. I have some news about your kittens.");
                        }

                        if (progress.mutaSpiderQuestState.equals(QuestState.AVAILABLE)) {
                            System.out.println("3. I can tell you story");
                        } else if (progress.mutaSpiderQuestState.equals(QuestState.IN_PROGRESS)) {
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
    private void runTutorial(int chapter) {
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
        if (progress.kittenQuestState.equals(QuestState.COMPLETED) && progress.mutaSpiderQuestState.equals(QuestState.NOT_AVAILABLE)) {
            progress.mutaSpiderQuestState = QuestState.AVAILABLE;
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
