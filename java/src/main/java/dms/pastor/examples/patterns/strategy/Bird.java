package dms.pastor.examples.patterns.strategy;

public class Bird extends Animal {
    public Bird() {
        super("Bird");
        setSound("Tweet");
        setFlyingType(new CanFly());
    }
}
