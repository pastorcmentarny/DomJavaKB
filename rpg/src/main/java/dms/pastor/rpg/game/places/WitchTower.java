package dms.pastor.rpg.game.places;

import dms.pastor.rpg.game.Game;
import dms.pastor.rpg.game.events.BattleManual;
import dms.pastor.rpg.game.events.Chat;
import dms.pastor.rpg.game.quests.QuestMonitor;
import dms.pastor.rpg.game.units.enemies.Enemy;
import dms.pastor.rpg.game.units.enemies.bosses.OlaZ;

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
                    case 1 -> visitQueen();
                    case 2 -> visitBarracks();
                    case 3 -> CommonPlaces.vendingMachine(random.nextBoolean());
                    case 4 -> {
                        Chat chat = new Chat();
                        chat.withPolyesterKnights().talk();
                    }
                    case 0 -> {
                        stay = false;
                        System.out.println("You left city...");
                    }
                }
            } catch (InputMismatchException ime) {
                System.out.println("You get lost at university .Shame on you!I understand as if you study tourist management as for your trip at uni is trip of your life ,but otherwise ..COME ON ... press number!");
            }
        }
    }

    @Override
    public void description() {
        System.out.println("Prison and place where are polyester knights has their barracks ");
    }


    private void visitQueen() {
        /*
        if(story.winWithOlaAtTower.equals(QuestState.AVAILABLE) || story.winWithOlaAtTower.equals(QuestState.IN_PROGRESS)){
            System.out.println("You ha");
            
        }
        */
        Game game = Game.getGame();
        Enemy enemy = new OlaZ(1);
        game.increaseBattleCounter();
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
