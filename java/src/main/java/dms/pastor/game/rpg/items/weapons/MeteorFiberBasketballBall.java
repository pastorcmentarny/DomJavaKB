package dms.pastor.game.rpg.items.weapons;

/**
 * @author dominiksymonowicz
 */
public class MeteorFiberBasketballBall extends Weapon {
    public MeteorFiberBasketballBall() {
        super(Hands.RIGHT);
        name = "Meteor Baseball bat";
        description = "Most painful version of baseball bat";
        minDMG = 396;
        maxDMG = 828;
        accuracy = 50;
        evasion = 15;
        value = 139968;
    }
}
