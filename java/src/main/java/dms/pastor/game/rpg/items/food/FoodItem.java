package dms.pastor.game.rpg.items.food;

import dms.pastor.game.rpg.items.Action;
import dms.pastor.game.rpg.items.Item;
import dms.pastor.game.rpg.units.Hero;


public abstract class FoodItem extends Item {
    private final int energy;
    int poisonChance;
    private final int value;


    FoodItem(int energy, int poisonChance, int value) {
        this.energy = energy;
        this.poisonChance = poisonChance;
        this.value = value;
        actions = Action.food;
    }


    public abstract void eat(Hero hero);

    public int getEnergy() {
        return energy;
    }

    public int getPoisonChance() {
        return poisonChance;
    }

    public int getValue() {
        return value;
    }


}
