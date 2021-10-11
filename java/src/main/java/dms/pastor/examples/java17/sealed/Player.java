package dms.pastor.examples.java17.sealed;

public record Player(String name) implements Unit{
    @Override
    public String name() {
        return name;
    }
}
