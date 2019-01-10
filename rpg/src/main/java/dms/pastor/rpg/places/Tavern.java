package dms.pastor.rpg.places;

import dms.pastor.rpg.commons.Msg;
import dms.pastor.rpg.quests.QuestMonitor;
import dms.pastor.rpg.quests.QuestState;
import dms.pastor.rpg.quests.ZombieQuest;

import java.util.Scanner;

/**
 * ---snoring  ----
 *
 * You went for party and u start drink wit capo. u end up in the hall where u are about to sleep but then u hear someday r doing*beeep*
 * 1.ignore (event will be repeat)
 * 2. say shut up i am trying to sleep
 * 3. wait and do *beep*
 * 4. try to find person and punch it
 *
 *
 * if u do 1. it will be repeat 100 and it is 5% that something willhappen
 * a. somebody will.punch person 50% , b. somebody will punch 20% .
 *
 * 2. has 10% to success , 66% hit u or nothing (however it do from 3 to 10 steps to progress
 * UNSORTED IDEAS
 *
 *
 * Very rare quest as reference to Top Gear (3 middle age man)
 * football fields is capo camp where event from my times in Capoeira . Not part of the Campaign
 * naughty herbs are drugs
 * ---- Pub talks ----
 * When it rains, why don't sheep shrink?
 * Why is abbreviation such a long word?
 * How does a fish sleep?
 *
 * Why is abbreviation such a long word?
 * How does a fish sleep?
 * http://www.fun-stuff-to-do.com/rhetorical_questions.html
 *
 * quest at pub
 * if you allow Barry meet Natalie then
 * Natalie + Barry = ginger love -> przywoluje fenixa, who saves you from death,cure all bad diseases and give double health.
 *
 */
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
                        if (qm.zombie.equals(QuestState.IN_PROGRESS)) {
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
