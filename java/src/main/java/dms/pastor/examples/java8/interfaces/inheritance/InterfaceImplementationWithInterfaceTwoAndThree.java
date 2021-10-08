package dms.pastor.examples.java8.interfaces.inheritance;

//Child Interfaces > Parent Interfaces:
public class InterfaceImplementationWithInterfaceTwoAndThree implements InterfaceTwo,InterfaceThree{
    public static void main(String[] args) {
        System.out.println(new InterfaceImplementationWithInterfaceTwoAndThree().method());
    }
}
