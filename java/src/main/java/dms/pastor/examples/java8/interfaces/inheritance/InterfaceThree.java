package dms.pastor.examples.java8.interfaces.inheritance;

public interface InterfaceThree extends InterfaceTwo{
    default String method(){
        return "InterfaceThree";
    }
}
