package dms.pastor.examples.java8.interfaces.inheritance;

/*
    An order of precedence for default methods
        1. classes > interfaces
        2. children > parent
        3. select or override implementation
 */
public class MultipleInheritanceExample {
    public static void main(String[] args) {
        final var interfaceImplementation = new InterfaceImplementation();
        System.out.println(interfaceImplementation.method());
        final var interfaceImplementationWithInterfaceTwoInUse = new InterfaceImplementationWithInterfaceTwoInUse();
        System.out.println(interfaceImplementationWithInterfaceTwoInUse.method());
    }
}
