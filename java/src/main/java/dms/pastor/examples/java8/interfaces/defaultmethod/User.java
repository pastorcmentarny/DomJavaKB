package dms.pastor.examples.java8.interfaces.defaultmethod;

public final class User implements Account {

    @Override
    public String getUsername() {
        return "An User";
    }

    @Override
    public int getId() {
        return 1;
    }
}
