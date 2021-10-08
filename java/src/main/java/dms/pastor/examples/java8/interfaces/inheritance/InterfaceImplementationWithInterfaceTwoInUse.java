package dms.pastor.examples.java8.interfaces.inheritance;

public class InterfaceImplementationWithInterfaceTwoInUse implements InterfaceOne,InterfaceTwo{
    @Override
    public String method() {
        return InterfaceTwo.super.method();
    }
}
