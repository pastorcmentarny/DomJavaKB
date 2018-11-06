package dms.pastor.game.rpg.items.weapons;

/**
 * @author dominiksymonowicz
 */
public class CarbonFiberBaseballBat extends Weapon {
    public CarbonFiberBaseballBat() {
        super(Hands.RIGHT);
        name = "Alumini Baseball bat";
        description = "It is a smooth wooden  club used in the sport of baseball to hit the ball.However Nylon Knights change rules of game and they use baseball to hit people instead of ball. ";
        minDMG = 216;
        maxDMG = 642;
        accuracy = 15;
        evasion = 15;
        value = 46656;
    }
}
