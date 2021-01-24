package dms.pastor.examples.patterns.strategy;

public class CanFly implements Fly{

    @Override
    public boolean fly() {
        return true;
    }

    @Override
    public String info() {
        return "can fly";
    }
}