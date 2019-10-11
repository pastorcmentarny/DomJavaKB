package dms.pastor.prototype.dcs.game;

import dms.pastor.prototype.dcs.Config;
import dms.pastor.prototype.dcs.conditions.ConditionType;
import dms.pastor.prototype.dcs.events.EventGenerator;
import dms.pastor.prototype.dcs.units.Unit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static dms.pastor.prototype.dcs.Config.REGEN_SP_PER_TURN;

/**
 * Author Dominik Symonowicz
 * Created 2015-07-23
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
class Battle {

    private static final Logger LOGGER = LoggerFactory.getLogger(Battle.class);

    private final Unit player1;
    private final Unit player2;
    private int round = 0;

    Battle(Unit player1, Unit player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    private void setup() {
        System.out.println("Preparing to battle between " + player1.getName() + " and " + player2.getName());
        System.out.println(player2.getDescription());
    }

    //TODO improve it
    boolean isInFight() {
        System.out.println("Battle starting..");
        setup();
        while (isAllPlayersAlive()) {
            preRound();
            if (isAllPlayersAlive()) {
                round();
            } else {
                return false;
            }
            postRound();
        }
        return false;
    }

    private void preRound() {
        LOGGER.debug("Performing pre round stage...");
        if (round > Config.EXHAUSTION_START_ROUND) {
            int dmg = getDamageForExhaustion();
            System.out.println("Exhaustion damage .." + dmg + " dmg.");
            player1.doesDamageTo(player1, dmg);
            player2.doesDamageTo(player2, dmg);
        }
        EventGenerator.event(player1, player2);
        player1.getElements().addRandomElements(Config.ADD_CARD_PER_TURN);
        player1.displayStats();
        player1.getElements().displayElements();
        player2.getElements().addRandomElements(Config.ADD_CARD_PER_TURN);
        if (player1.getConditions().has(ConditionType.REGENERATION)) {
            player1.addHP(Config.REGEN_RATE);
        }
        if (player2.getConditions().has(ConditionType.REGENERATION)) {
            player2.addHP(Config.REGEN_RATE);
        }
        if (player1.getConditions().has(ConditionType.POISONED)) {
            player1.doesDirectDamage(Config.POISON_DAMAGE);
        }
        if (player2.getConditions().has(ConditionType.POISONED)) {
            player2.doesDirectDamage(Config.POISON_DAMAGE);
        }
        LOGGER.debug("Pre round stage completed.");
    }

    private int getDamageForExhaustion() {
        return round - Config.EXHAUSTION_START_ROUND;
    }

    private void round() {
        System.out.println("Round: " + ++round);
        doRoundFor(player1, player2);

        if (player2.isAlive()) {
            doRoundFor(player2, player1);
        }
        System.out.println("End of round: " + round);
    }

    private void doRoundFor(Unit unit, Unit enemy) {
        if (unit.getConditions().has(ConditionType.STUNNED)) {
            displayUnitIsStunnedMessageFor(unit.getName());
        } else {
            unit.turn(enemy);
        }
    }

    private void displayUnitIsStunnedMessageFor(String name) {
        System.out.println(name + " is Stunned.");
    }

    private void postRound() {
        LOGGER.debug("Performing post round stage...");
        if (isAllPlayersAlive()) {
            System.out.println("End of turn.\n");

            player1.shieldRegen(REGEN_SP_PER_TURN);
            player2.shieldRegen(REGEN_SP_PER_TURN);
            player1.getConditions().reduceByOneTurn();
            player2.getConditions().reduceByOneTurn();
        } else {
            resolveWhoWonBattle();
        }
        LOGGER.debug(player1.toString());
        LOGGER.debug(player2.toString());
        LOGGER.debug("Pre round stage completed.");
    }

    private void resolveWhoWonBattle() {
        if (player1.isAlive() && player2.isDead()) {
            System.out.println(player1.getName() + " WON!");
        } else if (player2.isAlive() && player1.isDead()) {
            System.out.println(player2.getName() + " WON!");
        } else {
            System.out.println("DOUBLE KO");
        }
    }

    private boolean isAllPlayersAlive() {
        return player1.isAlive() && player2.isAlive();
    }

}
