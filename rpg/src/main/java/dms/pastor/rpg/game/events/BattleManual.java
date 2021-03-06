package dms.pastor.rpg.game.events;

import dms.pastor.rpg.game.Bonus;
import dms.pastor.rpg.game.Game;
import dms.pastor.rpg.game.actions.BattleAction;
import dms.pastor.rpg.game.commons.Msg;
import dms.pastor.rpg.game.units.Hero;
import dms.pastor.rpg.game.units.Unit;
import dms.pastor.rpg.game.units.enemies.Enemy;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;


public class BattleManual implements BattleAction {


    private final Random random = new Random();
    private final Scanner scanner = new Scanner(System.in);

    private final Hero hero;
    private Enemy enemy;
    private int round = 1;

    public BattleManual(Hero hero, Enemy enemy) {
        this.hero = hero;
        this.enemy = enemy;
        hero.generateBattleStats();
        enemy.generateBattleStats();
    }

    public static int getChance(Unit one, Unit two) {
        int chance = one.battleStats.getAccuracy() - two.battleStats.getEvasion();
        if (chance < 1) {
            System.out.println(two.getName() + "has lucky 2% chance.");
            return 2;
        } else {
            return chance;
        }
    }

    private void attack(Unit one, Unit two) {
        if (!one.canAttack()) {
            //log.debug(one + "can't attack.");
            return;
        }
        //log.info(one.getName() + " attacks " + two.getName());
        if (getChance(one, two) > random.nextInt(101)) {
            int dmg;
            if (one.isCriticalChance()) {
                dmg = one.battleStats.getMaxDMG() * one.criticalMultiplayer;
                System.out.println("-- CRITICAL CHANCE -- " + dmg + " dmg!");
            } else {
                dmg = one.battleStats.getRandomDmg() - two.battleStats.getARM();
                if (dmg < 0) {
                    dmg = 1; //
                }
            }
            if (!one.isPlayer) {
                enemy.exp += dmg / 20;
            }
            two.battleStats.setHP(two.battleStats.getHP() - dmg);
            System.out.println(one.getName() + " does " + dmg + " damage to " + two.getName() + ". " + two.getName() + (two.battleStats.getHP() > 0 ? " has " + two.battleStats.getHP() + "/" + two.battleStats.getMaxHP() + "HP left." : " is dead."));
        } else {
            System.out.println(one.getName() + " missed.");
        }
    }

    private boolean isBattleEnded() {
        return isDead(hero) || isDead(enemy);
    }

    private boolean isDead(Unit u) {
        return u.battleStats.getHP() <= 0;
    }

    private boolean isAlive(Unit u) {
        return u.battleStats.getHP() > 0;
    }

    public void setEnemy(Enemy unit) {
        this.enemy = unit;
        enemy.generateBattleStats();
    }

    private void selectAction() {
        System.out.println("You can:\n");
        if (hero.canAttack()) {
            System.out.println("1.Attack");
        }
        if (hero.canCastSpell()) {
            System.out.println("2.Cast spell");
        }
        if (hero.canUseItem()) {
            System.out.println("3.Use item");
        }
        if (hero.canUseSpecial()) {
            System.out.println("4.Special");
        }
        System.out.println("0.Skip turn");
        try {
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    if (hero.canAttack()) {
                        attack(hero, enemy);
                    } else {
                        Msg.cant("attack");
                    }
                    break;
                case 2:
                    if (hero.canCastSpell()) {
                        hero.castSpell();
                    } else {
                        Msg.cant("cast spell");
                    }
                    break;
                case 3:
                    if (hero.canUseItem()) {
                        hero.useItem(enemy);
                    } else {
                        Msg.cant("use item");
                    }
                    break;
                case 4:
                    if (hero.canUseSpecial()) {
                        hero.specialAttack(null);
                    }
                case 0:
                    System.out.println("You did nothing ...");
                    break;
                default:
                    System.out.println("You tried do something.. You did nothing ...");
                    break;
            }
        } catch (InputMismatchException ime) {
            System.out.println("You tried do something.. You did nothing ... " + ime.getMessage());
        }

    }

    private boolean fight() {
        Unit[] units;
        //while (isAllAlive()) {
        units = getUnitsSortedByInitiative();
        if (units[0].isPlayer) {
            selectAction();
        } else {
            attack(units[0], units[1]);
        }
        if (isAlive(units[1])) {
            if (units[1].isPlayer) {
                selectAction();
            } else {
                attack(units[1], units[0]);
            }
            if (isDead(units[0])) {
                System.out.println(units[1].getName() + " killed " + units[0].getName());
                return true;
            }
        } else {
            System.out.println(units[0].getName() + " killed " + units[1].getName());
            return true;
        }


        return false;
    }

    private boolean isAllAlive() {
        return isAlive(hero) && isAlive(enemy);
    }

    public void begin() {
        System.out.println("Battle begins...");
        if (hero.wantFight()) {
            battle();
            System.out.println("End of battle.");
        } else {
            if (enemy.avoidFightDiplomacy(hero)) {
                int expBonus = enemy.lvl + enemy.lvl / 2 + enemy.lvl / 3 + enemy.lvl / 4 + enemy.lvl / 5;
                System.out.println("You avoided battle. You will get " + expBonus + " exp for it.");
                hero.exp += expBonus;
            } else {
                enemy.exp += enemy.lvl * 3;
                battle();
            }

        }

    }

    private void battle() {
        beforeBattle();
        while (isAllAlive()) {
            round();
        }
        afterBattle();

    }

    private void round() {
        beforeTurnEvents();
        turn();
        afterTurnEvents();
    }

    private void beforeTurnEvents() {
        round++;
        System.out.println("Turn:" + round);
        enemy.exp += (Math.max(round / 2, 1));
        hero.beforeTurn();
        enemy.beforeTurn();

    }

    private void turn() {
        fight();
    }

    private void afterTurnEvents() {
        System.out.println("End of turn.");
        hero.afterTurn();
        enemy.afterTurn();
    }

    @Override
    public void beforeBattle() {
        System.out.println("HERO:" + hero.displayShortInfo(true));
        System.out.println(" - VS - ");
        System.out.println("ENEMY:" + enemy.displayShortInfo(true));
    }

    @Override
    public void afterBattle() {
        System.out.println("After battle ...");
        if (hero.battleStats.isAlive()) {
            hero.afterBattle();
            hero.addBonus(new Bonus(new Unit[]{enemy})); //TODO when multi enemies are implement you need change that.
        } else {
            Game.gameOver("died in battle", hero.getName());
        }
    }


    private Unit[] getUnitsSortedByInitiative() {
        String msg = "Checking who will be first to start round..";
        if ((hero.skills.getInitiative() > enemy.skills.getInitiative())) {
            return new Unit[]{hero, enemy};
        } else if ((hero.skills.getInitiative() < enemy.skills.getInitiative())) {
            return new Unit[]{enemy, hero};
        } else {
            if (random.nextBoolean()) {
                return new Unit[]{hero, enemy};
            } else {
                return new Unit[]{enemy, hero};
            }
        }
    }

    @Override
    public void beforeTurn() {
        hero.beforeTurn();
        enemy.beforeTurn();
    }

    @Override
    public void afterTurn() {
        hero.afterTurn();
        enemy.afterTurn();
    }

    @Override
    public void specialAttack(Unit unit) {
        //?
    }


}
