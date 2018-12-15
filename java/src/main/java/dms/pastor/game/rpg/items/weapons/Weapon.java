package dms.pastor.game.rpg.items.weapons;

import dms.pastor.game.rpg.characteristics.Attribute;
import dms.pastor.game.rpg.characteristics.Stats;
import dms.pastor.game.rpg.items.Action;
import dms.pastor.game.rpg.items.Item;

import java.util.ArrayList;

/**
 * //TODO make it abstract
 *
 * @author domhome
 */
public class Weapon extends Item {

    protected int minDMG;
    protected int maxDMG;
    protected int accuracy;
    protected int evasion;
    private int criticalChance;
    protected ArrayList<Attribute> attributes;
    public Hands hand = Hands.RIGHT;

    protected Weapon(Hands hand) {
        attributes = new ArrayList<>();
        attributes.add(Attribute.WEAPON);
        actions = Action.weapon;
        this.hand = hand;
    }

    public Weapon(int minDMG, int maxDMG, int accuracy, int evasion, int criticalChance, ArrayList<Attribute> attributes) {
        this.minDMG = minDMG;
        this.maxDMG = maxDMG;
        this.accuracy = accuracy;
        this.evasion = evasion;
        this.attributes = attributes;
        this.criticalChance = criticalChance;
        this.attributes.add(Attribute.WEAPON);
        actions = Action.weapon;
    }

    public Stats addToStats(Stats stats) {
        stats.addMinDMG(minDMG);
        stats.addMaxDMG(maxDMG);
        stats.addAccuracy(accuracy);
        stats.addEvasion(evasion);
        return stats;
    }

    @Override
    public String toString() {
        return "Weapon{" + "minDMG=" + minDMG + ", maxDMG=" + maxDMG + ", accuracy=" + accuracy + ", evasion=" + evasion + ", attributes=" + attributes + '}';
    }


}
