package dms.pastor.game.rpg.places;

import dms.pastor.game.rpg.Game;
import dms.pastor.game.rpg.commons.Msg;
import dms.pastor.game.rpg.events.BattleManual;
import dms.pastor.game.rpg.events.Chat;
import dms.pastor.game.rpg.quests.QuestMonitor;
import dms.pastor.game.rpg.units.Hero;
import dms.pastor.game.rpg.units.npc.Day9;
import dms.pastor.game.rpg.units.nylonKnights.Dresiarz;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;


public class University extends Place {

    private final Hero hero = Hero.getHero();
    private final Game game = Game.getGame();
    private final Scanner scanner = new Scanner(System.in);

    public University() {
    }

    private void uni() {
        boolean stay = true;
        while (stay) {
            System.out.println("What do you want to do ?");
            System.out.println("1.Go to Offices\n2.Go to Maze(Interpol)\n3.Go Witch Tower\n4.UFO landing site\n5. Vending machine");
            System.out.println("8.Go for clubing\n9.Talk to somebody");
            System.out.println("0.Exit");

            try {
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        Office office = new Office(hero);
                        office.description();
                        office.goToPlace();
                        break;
                    case 2:
                        Maze maze = new Maze();
                        maze.description();
                        maze.goToPlace();
                        break;
                    case 3:
                        WitchTower witchTower = new WitchTower();
                        witchTower.description();
                        witchTower.goToPlace();
                        break;
                    case 4:
                        if (QuestMonitor.getQuestMonitor().isAlienQuestAvailable()) {

                        } else {
                            System.out.println("Art centre is closed today." + Msg.apologize());
                        }
                    case 5:
                        if (new Random().nextInt(100) > 2) {
                            CommonPlaces.vendingMachine(new Random().nextBoolean());
                        } else {
                            Day9.displayCoffeeStory();
                        }

                        break;
                    case 9:

                        if (random.nextInt(101) > 20) {
                            Dresiarz dresiarz = new Dresiarz(game.getEnemyLevel());
                            game.increaceBattleCounter();
                            System.out.println("Battle no." + game.getBattleNo());
                            BattleManual battle = new BattleManual(hero, dresiarz);
                            battle.begin();
                            game.addEnemyExp(dresiarz.exp);
                            if (hero.isAlive()) {
                                game.addRandomDistance(1, 6);
                            } else {
                                game.gameOver("died in Battle");
                            }
                        } else {
                            Chat chat = new Chat();
                            chat.doEvent();
                        }
                        break;
                    case 8:
                        Clubbing club = new Clubbing(hero);
                        club.description();
                        club.goToPlace();
                        break;
                    case 0:
                        stay = false;
                        System.out.println("You left city...");
                }
            } catch (InputMismatchException ime) {
                System.out.println("You get lost at university .Shame on you!I understand as if you study tourist managament as for your trip at uni is trip of your life ,but otherwise ..COME ON ... press number!");
                stay = false;
            }
        }
    }

    public void goToPlace() {
        uni();
    }

    @Override
    public void description() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
