package dms.pastor.examples.java8.interfaces.defaultmethod;

public final class Admin implements Account {

    @Override
    public String getUsername() {
        return "An admin";
    }

    @Override
    public int getId() {
        return 2;
    }

    @Override
    public boolean isAdmin() {
        return true;
    }
}
