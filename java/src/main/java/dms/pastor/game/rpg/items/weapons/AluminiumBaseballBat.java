package dms.pastor.game.rpg.items.weapons;

/**
 * @author dominiksymonowicz
 */
public class AluminiumBaseballBat extends Weapon {
    public AluminiumBaseballBat() {
        super(Hands.RIGHT);
        name = "Aluminium Baseball bat";
        description = "It is a steal version of baseball bat.More heavier but it hurts more badly.Favorite tool for experienced knights of nylon ";
        minDMG = 48;
        maxDMG = 126;
        accuracy = -15;
        evasion = -15;
        value = 5990;
    }
}
