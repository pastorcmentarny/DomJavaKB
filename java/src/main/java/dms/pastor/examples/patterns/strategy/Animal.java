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

    public void displayFlyAbility() {
        System.out.println(name + " " + flyingType.info());
    }


}
