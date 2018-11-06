package dms.pastor.game.rpg.items.weapons;

/**
 * @author dominiksymonowicz
 */
public class BaseballBat extends Weapon {
    public BaseballBat() {
        super(Hands.RIGHT);
        name = "Wooden Baseball bat";
        description = "It is a smooth wooden  club used in the sport of baseball to hit the ball.However Nylon Knights change rules of game and they use baseball to hit people instead of ball. ";
        minDMG = 24;
        maxDMG = 42;
        accuracy = -10;
        evasion = -10;
        value = 2160;
    }
}
