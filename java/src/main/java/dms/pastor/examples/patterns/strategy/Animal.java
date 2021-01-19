package dms.pastor.examples.patterns.strategy;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Animal {
    private String name;
    private double height;
    private int weight;
    private String favFood;
    private String sound;
    private Fly flyingType = new CantFly();

    public Animal(String name) {
        this.name = name;
    }

    public void setWeight(int weight) {
        if (weight <= 0) {
            throw new IllegalArgumentException("Weight must be bigger than 0");
        }
        this.weight = weight;
    }

    public void displayFlyAbility() {
        System.out.println(name + " " + flyingType.info());
    }


}
