package dms.pastor.examples.patterns.strategy;

public class CantFly implements Fly{
    @Override
    public boolean fly() {
        return false;
    }

    @Override
    public String info() {
        return "can't fly";
    }
}
