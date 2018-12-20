package dms.pastor.rpg.places;

import dms.pastor.rpg.commons.Msg;
import dms.pastor.rpg.quests.QuestMonitor;
import dms.pastor.rpg.quests.QuestState;
import dms.pastor.rpg.quests.ZombieQuest;

import java.util.Scanner;


public class Tavern extends Place {

    private final Scanner scanner = new Scanner(System.in);
    private final QuestMonitor qm = QuestMonitor.getQuestMonitor();

    public Tavern() {
        setName("Roland's Tavern");
        setDescription("Typical tavern in the middle of nowhere. Cheap alcoholic beverages, action packed fights between locals and tourist  and legend  ");
    }

    @Override
    public void description() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void goToPlace() {
        /*
         1. Buy drink (+1 charisma/verbal -2 intelligence)
         2. Buy food
         3. Stay at hotel
         4. Play a game 
         5. Talk
         0. Exit
         */
        boolean stay = true;
        while (stay) {
            System.out.println("You arrived to " + getName() + "\t" + getDescription());
            System.out.println("1. Buy drink\n");
            System.out.println("2. Eat something\n");
            System.out.println("3. Stay at hotel over night");
            System.out.println("4.Play a game");
            System.out.println("5.Talk to somebody");
            if (qm.isZombieQuestStarted()) {
                System.out.println("3. Go to underground butchery ");
            }
            System.out.println("0.Exit");

            try {
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        break;
                    case 2:
                        Msg.getRandomPubStory();
                        break;
                    case 3:
                        if (qm.isZombieKilled()) {
                            if (qm.isZombieQuestNotStarted()) {
                                zombieTalk();
                            } else {
                                ZombieQuest zq = new ZombieQuest();

                            }

                        }
                        break;
                    case 5:
                        if (qm.zombie.equals(QuestState.INPROGRESS)) {
                            ZombieQuest zq = new ZombieQuest();
                            zq.resumeQuest();
                        }
                    case 0:
                        stay = false;
                        break;
                    default:
                        break;
                }
            } catch (Exception e) {
                System.out.println(Msg.getDEEM() + e.getMessage());
                stay = false;

            }

        }

    }

    public void talk() {
        boolean stay = true;
        while (stay) {
            System.out.println("What do you want to do ?");
            System.out.println("1. Ask about news\n");
            System.out.println("2. Listen to local stories\n");
            if (qm.isZombieKilled() && qm.isZombieQuestNotStarted()) {
                System.out.println("3. Ask for zombie\n");
            } else if (qm.isZombieQuestStarted()) {
                System.out.println("3. Go to underground ");
            }
            System.out.println("0.Exit");

            try {
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        break;
                    case 2:
                        Msg.getRandomPubStory();
                        break;
                    case 3:
                        if (qm.isZombieKilled()) {
                            if (qm.isZombieQuestNotStarted()) {
                                zombieTalk();
                            } else {
                                ZombieQuest zq = new ZombieQuest();

                            }

                        }
                        break;
                    case 0:
                        stay = false;
                        break;
                    default:
                        break;
                }
            } catch (Exception e) {
                System.out.println(Msg.getDEEM() + e.getMessage());
                stay = false;

            }

        }

    }

    private void zombieTalk() {
        //TODO zombie chat
        QuestMonitor.getQuestMonitor().passZombieTalk();
    }
/*
    8#00004
    00000##
    ##000#4
    4###4#0  0 mine does35% damage
    0#0###0  # path
    0##0800  4  death mine
    00#0000  8 secret teleporter to chest with evil monster(Cyhyraeth a death spirit)
    */
}
