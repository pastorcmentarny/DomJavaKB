package dms.pastor.rpg;


import dms.pastor.rpg.cfg.Config;
import dms.pastor.rpg.events.*;
import dms.pastor.rpg.menu.InventoryMenu;
import dms.pastor.rpg.units.Hero;
import dms.pastor.rpg.units.RandomUnit;
import dms.pastor.rpg.commons.Msg;
import dms.pastor.rpg.commons.Result;
import dms.pastor.rpg.places.World;
import dms.pastor.rpg.quests.QuestSelector;
import dms.pastor.rpg.units.enemies.Enemy;
import dms.pastor.rpg.units.enemies.animals.Seagull;

import java.util.Random;
import java.util.Scanner;

public class Game {


    private static Game game;
    private final Hero hero;
    private final Random random = new Random();
    private final Scanner scanner = new Scanner(System.in);
    private int enemyExp;
    private int enemyNextLvlExp;
    private int enemyLvl;
    private int distance;
    private int battleNo = 0;


    private Game() {
        //TODO move to separate method
        //FIXME log.setLevel(Config.//FIXME log.LEVEL);
        hero = Hero.getHero();
        distance = 0;
        enemyLvl = 1;
        enemyNextLvlExp = Config.DEFAULT_FIRST_NEXT_LEVEL_EXP;
    }

    public static synchronized Game getGame() {

        if (game == null) {
            game = new Game();
        }
        return game;
    }

    public static void gameOver(String reason, String heroName) {
        System.out.println("\n\n" + Config.GAME_OVER_SPLIT + "\n\tGAME OVER!\n" + heroName + " " + reason + ".\n" + Config.GAME_OVER_SPLIT);
        System.exit(1);
    }

    @Override
    public final Object clone() throws CloneNotSupportedException {
        //FIXME log.error("Clone not supported exception!");
        throw new CloneNotSupportedException();
    }

    private boolean nextEvent(Events event) {
        switch (event) {
            case BATTLE:
                Enemy enemy = RandomUnit.generateRandomUnit(enemyLvl);
                battleNo++;
                System.out.println("Battle no." + battleNo);
                BattleManual battle = new BattleManual(hero, enemy);
                battle.begin();

                addEnemyExp(enemy.exp);
                if (hero.isAlive()) {
                    addRandomDistance(1, 6);
                    return true;
                } else {
                    return gameOver("died in Battle");
                }
            case GUESS_NUMBER:
                GuessNumberEvent gne = new GuessNumberEvent(0, 9, 3);
                gne.doEvent();
                if (gne.isAnswered()) {
                    Result result = gne.getReward();
                    if (result.isSuccess()) {
                        try {
                            Integer i = (Integer) result.getData();
                            hero.exp += i;
                        } catch (Exception e) {
                            //FIXME log.error("Unexpected reward ... bug?" + e.getMessage() + "\n");
                        }
                    } else {
                        //FIXME log.warn(result.getMessage());
                    }

                } else {
                    addEnemyExp(100);
                }
                return true;
            case SEAGULL:
                Seagull seagull = new Seagull(enemyLvl);
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
                        battleNo++;
                        System.out.println("Battle no." + battleNo);
                        BattleManual seagullBattle = new BattleManual(hero, seagull);
                        seagullBattle.begin();
                        addEnemyExp(seagull.exp);
                        if (hero.isAlive()) {
                            addRandomDistance(1, 6);
                            return true;
                        } else {
                            return gameOver("died in Battle");
                        }
                    case DAMAGE:
                        int v = hero.plainStats.getHP() / 5;
                        int damage = random.nextInt(v);
                        if (hero.plainStats.getHP() - v <= 0) {
                            System.out.println("Shit didn't cause any damage to you.");
                        } else {
                            System.out.println("Shit causes " + damage + " damage.");
                        }
                        return true;
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
                return true;
            case BAG:
                BagFoundEvent bagFound = new BagFoundEvent(hero);
                bagFound.doEvent();
                System.out.println(bagFound.getReward().getMessage());
                return true;
            case QUEST:
                QuestSelector qs = new QuestSelector();
                qs.menu(this);
                return true;
            case NONE:
                addRandomDistance(1, 6);
                addEnemyExp(new Random().nextInt(50) + 1);
                return true;
            default:
                System.err.println("Unknown event selected for new event in Game");
                return false;
        }

    }

    //TODO implement normal and rare event (95/5)
    public boolean play() {
        //FIXME log.info("Playing new game");
        while (hero.isAlive() && isNotReachDestination()) {

            System.out.println("What do you want to do ?");
            System.out.println("1. Go to Map");
            System.out.println("2. Just walk around ..");
            if (hero.psycho) {
                System.out.println("3. Cast spell");
            }
            System.out.println("9.Check inventory");
            System.out.println("0.Display Hero's status");
            System.out.println("11. Go to Fight Club Arena.");
            System.out.println("12. Change attitude of Hero to fight.");
            //try {
            switch (scanner.nextInt()) {
                case 1:
                    World world = new World(this);
                    world.map();
                    //break; No break
                case 2:
                    if (nextEvent(Events.getRandomEvent())) {
                        System.out.println("End of event.");
                    } else {
                        return false;
                    }
                    break;
                case 3:
                    if (hero.psycho) {
                        // cast spell
                    } else {
                        System.out.println(Msg.selectionNotAllowed());
                    }
                case 9:
                    InventoryMenu inventoryMenu = new InventoryMenu(hero.inventory);
                    inventoryMenu.displayMenu();
                    break;
                case 11:
                    Enemy enemy = RandomUnit.generateRandomUnit(enemyLvl);
                    battleNo++;
                    System.out.println("Battle no." + battleNo);
                    BattleManual battle = new BattleManual(hero, enemy);
                    battle.begin();

                    enemyExp += enemy.exp;
                    if (hero.isAlive()) {
                        addRandomDistance(1, 6);
                        break;
                    } else {
                        System.out.println(hero.displayShortInfo(false));
                        Game.gameOver("died in random battle.", Hero.getHero().name);
                    }
                    break;
                case 12:
                    hero.setAlwaysFight(!hero.wantFight());
                    System.out.println("Hero mood is:" + hero.getFightMood());
                    break;
                case 0:
                    System.out.println(hero.displayShortInfo(false));
                    break;
            }

            //  } catch (Exception e) {
            //  System.out.println("ee? what?? FOCUS! select what you want to do.. don't be a moody girl who doesn't know what she want!\n" + e.getMessage());
            //enemyExp += random.nextInt(250);
            //}
            levelUpCheckUp();
            if (isReachDestination()) {

                System.out.println(Config.GAME_OVER_SPLIT + "\n{  ( [YOU GET INTO DESTINATION!] )  }\n" + Config.GAME_OVER_SPLIT);
            }
        }
        return false;
    }

    public boolean gameOver(String reason) {
        System.out.println("\n\n" + Config.GAME_OVER_SPLIT + "\n\tGAME OVER!\n" + hero.getName() + " " + reason + ".\nYou walked " + distance + "/" + Config.DESTINATION_DISTANCE + ".\n" + Config.GAME_OVER_SPLIT);
        return false;
    }

    private boolean isReachDestination() {
        return distance >= Config.DESTINATION_DISTANCE;
    }

    private boolean isNotReachDestination() {
        return !isReachDestination();
    }

    public void addRandomDistance(int min, int max) {
        if (min > 0 && max > 0 && max > min) {
            int walk = random.nextInt(max - min) + min;
            addDistance(walk);
            System.out.println("You walked " + walk + " steps. You have " + (Config.DESTINATION_DISTANCE - distance) + " steps left.");

        } else {
            System.err.print("You can't walk backward in this game :)");
        }
    }

    private void enemyLevelUp() {
        enemyLvl += 1;
        System.out.println("\n~~~~~~~~\n!BAD NEWS!\n\tENEMY is leveling up to level:" + enemyLvl + "\n~~~~ ~~~~~~~~");
        enemyNextLvlExp = Config.getExpNeededForEnemyLevel(enemyLvl);

    }

    public void levelUpCheckUp() {
        while (hero.exp > hero.nextLvlExp) {
            hero.levelUp();
        }

        while (enemyExp > enemyNextLvlExp) {
            enemyLevelUp();
        }

        System.out.println(Config.LINE_SEPARATOR_BEFORE);
        System.out.println(hero.getName() + " has " + hero.exp + " exp. Next level at: " + hero.nextLvlExp);
        System.out.println("Enemies  has " + enemyExp + " exp. They will be at next level at: " + enemyNextLvlExp);
        System.out.println(Config.LINE_SEPARATOR_AFTER);
    }

    public int getBattleNo() {
        return battleNo;
    }

    public int increaseBattleCounter() {
        battleNo++;
        return battleNo;
    }

    public int getEnemyLevel() {
        return enemyLvl;
    }

    public void addDistance(int i) {
        distance += i;
        enemyExp += (3 * i);
        walkFewSteps(i);
    }

    public void addEnemyExp(int exp) {
        //FIXME log.debug("Enemy experience increased by  " + exp);
        enemyExp += exp;
        if (enemyExp > enemyNextLvlExp) {
            enemyLevelUp();
        }
    }

    public int getSteps() {
        return distance;
    }

    private void step() {
        hero.state.afterStep();
    }

    private void walkFewSteps(int steps) {
        for (int i = 1; i <= steps; i++) {
            step();
        }
    }
}
