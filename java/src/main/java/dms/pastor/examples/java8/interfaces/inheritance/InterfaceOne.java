package dms.pastor.examples.java8.interfaces.inheritance;

public interface InterfaceOne {

    default String method() {
        return "InterfaceOne";
    }
}

