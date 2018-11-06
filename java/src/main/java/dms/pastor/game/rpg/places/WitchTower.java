package dms.pastor.game.rpg.places;

import dms.pastor.game.rpg.Game;
import dms.pastor.game.rpg.events.BattleManual;
import dms.pastor.game.rpg.events.Chat;
import dms.pastor.game.rpg.quests.QuestMonitor;
import dms.pastor.game.rpg.units.enemies.Enemy;
import dms.pastor.game.rpg.units.enemies.bosses.OlaZ;

import java.util.InputMismatchException;


public class WitchTower extends Place {
    QuestMonitor story = QuestMonitor.getQuestMonitor();

    @Override
    public void goToPlace() {
        boolean stay = true;
        while (stay) {
            System.out.println("What do you want to do ?");
            System.out.println("1.Visit Queen \n2.Visit Barracks");
            System.out.println("3. Vending machine\n4.Talk to somebody");
            System.out.println("0.Exit");

            try {
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        visitQueen();
                        break;
                    case 2:
                        visitBarracks();
                        break;
                    case 3:
                        CommonPlaces.vendingMachine(random.nextBoolean());
                        break;
                    case 4:
                        Chat chat = new Chat();
                        chat.withPolysterKnights().talk();
                        break;
                    case 0:
                        stay = false;
                        System.out.println("You left city...");
                }
            } catch (InputMismatchException ime) {
                System.out.println("You get lost at university .Shame on you!I understand as if you study tourist managament as for your trip at uni is trip of your life ,but otherwise ..COME ON ... press number!");
            }
        }
    }

    @Override
    public void description() {
        System.out.println("Prison and place where are polyester knights has their barracks ");
    }


    private void visitQueen() {
        /*
        if(story.winWithOlaAtTower.equals(QuestState.AVALIABLE) || story.winWithOlaAtTower.equals(QuestState.INPROGRESS)){
            System.out.println("You ha");
            
        }
        */
        Game game = Game.getGame();
        Enemy enemy = new OlaZ(1);
        game.increaceBattleCounter();
        System.out.println("Battle no." + game.getBattleNo());
        BattleManual battle = new BattleManual(hero, enemy);
        battle.begin();

        game.addEnemyExp(enemy.exp);
        if (hero.isAlive()) {
            game.addRandomDistance(3, 4);
        } else {
            game.gameOver("died in Battle");
        }

    }

    private void visitBarracks() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
