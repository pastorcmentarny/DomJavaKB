package dms.pastor.kb.java8.interfaces.defaultmethod;

interface Account {
    //original interface methods
    String getUsername();

    int getId();

    //You need add
    default boolean isAdmin() {
        return false;
    }
}
