package dms.pastor.examples.patterns.strategy;

public class Dog extends Animal {

    public Dog() {
        super("Doggy");
        setSound("Bark");
    }

    public void digHole() {
        System.out.println("Digging a hole");
    }
}
