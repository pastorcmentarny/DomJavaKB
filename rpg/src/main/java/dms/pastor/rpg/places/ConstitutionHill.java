package dms.pastor.rpg.places;

import dms.pastor.rpg.Game;
import dms.pastor.rpg.commons.Msg;
import dms.pastor.rpg.items.AnesthesiaFlower;
import dms.pastor.rpg.items.HealingHerbs;
import dms.pastor.rpg.quests.QuestMonitor;
import dms.pastor.rpg.quests.QuestState;
import dms.pastor.rpg.units.Hero;
import dms.pastor.rpg.units.npc.Daria;
import dms.pastor.rpg.events.BattleManual;
import dms.pastor.rpg.events.SeagullEvent;
import dms.pastor.rpg.units.enemies.Enemy;
import dms.pastor.rpg.units.enemies.animals.Seagull;
import dms.pastor.rpg.units.enemies.animals.Sheep;
import dms.pastor.rpg.units.enemies.undead.CuteBunny;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;


class ConstitutionHill extends Place {

    private final Scanner scanner = new Scanner(System.in);
    private final Random random = new Random();
    private final Hero hero = Hero.getHero();
    private final Game game;
    private final QuestMonitor sp = QuestMonitor.getQuestMonitor();

    public ConstitutionHill(Game game) {
        setName("Constitution Hill");
        setDescription("It is famous for Cliff Railway and Victorian 'Luna Park");
        this.game = game;
    }

    @Override
    public void description() {
        System.out.println(getDescription());
    }

    @Override
    public void goToPlace() {
        boolean stay = true;
        while (stay) {
            System.out.println("You can:\n 1.Go to Darian Luna Park\n"
                + "2. Use Cliff Railway\n"
                + "3.Walk around\n"
                + "0.Back\n");
            try {
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        Daria daria = new Daria();
                        if (daria.atHome()) {
                            daria.talk();
                        } else {
                            Msg.notAtHome(daria.getName());
                        }
                        break;
                    case 2:
                        System.out.println("Cliff Railway is closed." + Msg.apologize());
                        break;
                    case 3:
                        walkAround();
                        break;
                    case 0:
                        stay = false;
                        System.out.println("You left city...");
                        break;
                    default:
                        System.out.println("You walk to road that is dead end... you go back and choose ..");
                        break;
                }
            } catch (InputMismatchException ime) {
                System.out.println("You get lost in the city ... press number!");
            }
        }

    }

    private void walkAround() {
        System.out.println("You just walk around " + getName());
        int event = random.nextInt(100);
        if (event % 17 == 0 && !sp.sleepingMonika.equals(QuestState.COMPLETED)) {
            System.out.println("You found a flower."); //TODO write story about it.
            hero.inventory.addItem(new AnesthesiaFlower());
        }

        if (event % 13 == 0) {
            System.out.println("You found a healing  herbs."); //TODO write story about it.
            hero.inventory.addItem(new HealingHerbs());
        }

        if (event % 11 == 0) {
            sheepEvent();
        }
        if (event % 3 == 0) {
            bunnyEvent();
        }

        if (event % 7 == 0) {
            seagullEvent();
        }
        game.addDistance(1);
    }

    private void seagullEvent() {
        Seagull seagull = new Seagull(random.nextInt(10) + 2);
        SeagullEvent se = new SeagullEvent(hero, seagull);
        se.doEvent();
        SeagullEvent.EVENT_Result reward = se.gerResult();
        switch (reward) {
            case NOTHING:
                break;
            case FLEW_AWAY:
                //bonus
                break;
            case ATTACK:
                game.increaseBattleCounter();
                System.out.println("Battle no." + game.getBattleNo());
                BattleManual seagullBattle = new BattleManual(hero, seagull);
                seagullBattle.begin();
                game.addEnemyExp(seagull.exp);
                if (hero.isAlive()) {
                    game.addRandomDistance(1, 4);
                } else {
                    game.gameOver("died in Battle");
                }
            case DAMAGE:
                int v = hero.plainStats.getHP() / 5;
                int damage = random.nextInt(v);
                if (hero.plainStats.getHP() - v <= 0) {
                    System.out.println("Shit didn't cause any damage to you.");
                } else {
                    System.out.println("Shit causes " + damage + " damage.");
                }
            case DESTROY_ARMOR:
                //TODO implement when Armor will be implement
                System.out.println("Shit didn't cause any damage to you.");
                break;
            case LUCKY_SHIT:
                hero.bonusPerLevelStats.AddRandomPointToStats(hero.psycho);
                break;
            case QUEEN_ATTACK:
                //TODO implement when Armor will be implement
                break;
        }
    }

    private void sheepEvent() {
        Enemy enemy = new Sheep(game.getEnemyLevel());
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


    private void bunnyEvent() {
        Enemy enemy = new CuteBunny(game.getEnemyLevel());
        game.increaseBattleCounter();
        System.out.println("Battle no." + game.getBattleNo());
        BattleManual battle = new BattleManual(hero, enemy);
        battle.begin();

        game.addEnemyExp(enemy.exp);
        if (hero.isAlive()) {
            game.addRandomDistance(3, 4);
        } else {
            game.gameOver("died shamefully in Battle with cute little bunny");
        }
    }

}
