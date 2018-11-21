package dms.pastor.examples.java8;

import dms.pastor.kb.java8.interfaces.defaultmethod.Admin;
import dms.pastor.kb.java8.interfaces.defaultmethod.User;
import dms.pastor.kb.java8.interfaces.functional.Converter;
import dms.pastor.kb.java8.junk.Unit;
import dms.pastor.kb.java8.junk.UnitFactory;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

final class Scratchpad {

    public static void main(String[] args) {
        final Scratchpad scratchpad = new Scratchpad();
        scratchpad.runX();
//        scratchpad.runAll();
    }


    private void runAll() {
        interfaces();
        lambdas();
        methodReference();
        other();
    }

    private void interfaces() {
        System.out.println("we have an Interface Account that has getName and getId. User implements this interface.");
        User user = new User();
        System.out.println("User: " + user.getUsername() + " Id:" + user.getId());
        System.out.println("We discover we need ad isAdmin method to interface." +
                "In Java 7 it will be a disaster as we will need add implementation of this method to all class that implement this interface." +
                "In Java 8 we simply add a new default method for example default method implementation will be isAdmin is false." +
                "So if we check our User class we will see:");
        System.out.println("User: " + user.getUsername() + " Id:" + user.getId() + " Is Admin? : " + user.isAdmin());
        System.out.println("However Admin class override isAdmin method and set isAdmin to true");
        Admin admin = new Admin();
        System.out.println("Admin: " + admin.getUsername() + " Id:" + admin.getId() + " Is Admin? : " + admin.isAdmin());

        displayEndLine();

        System.out.println("@FunctionalInterface annotation example");
        Converter<String, Integer> converter = Integer::valueOf;
        Integer converted = converter.convert("250");
        System.out.println(converted);

        displayEndLine();

    }

    private void lambdas() {
        System.out.println("Simple example of lambdas:\n");
        final List<String> cities = getStringArray();
        cities.forEach(a -> System.out.println(a.substring(0, 3)));

        displayEndLine();
    }

    private void methodReference() {
        System.out.println("Example of Method reference\n");
        final List<String> cities = getStringArray();
        System.out.println("Before:");

        cities.forEach(System.out::println);

        Collections.sort(cities, String::compareTo);
        System.out.println("After:");
        cities.forEach(System.out::println);

        displayEndLine();
    }

    private List<String> getStringArray() {
        return Arrays.asList("Wroclaw", "Tianjin", "London", "Aberystwyth", "Bangor", "York", "Beijing");
    }

    private void displayEndLine() {
        System.out.println();
        for (int i = 0; i < 6; i++) {
            System.out.print(" [ ( { oO0Oo } ) ] ");
        }
        System.out.println();
    }

    private void displayEndLine(int times) {
        for (int i = 0; i < times; i++) {
            displayEndLine();
        }
    }


    private void other() {
        System.out.println("OTHER STUFF...... ........");
        System.out.println("you can create a reference to the Unit constructor via Unit::new." +
                " The Java compiler automatically chooses the right constructor by matching the signature of PersonFactory.create.");
        UnitFactory unitFactory = Unit::new;
        final Unit dofutaly = unitFactory.create("Dofutaly", "Dofutaly is a fat and ugly Dominik", 34);
        System.out.println(dofutaly.toString());

        displayEndLine();

        Predicate<String> predicate = (text) -> text.startsWith("B");
        for (String city : getStringArray()) {
            System.out.println("City: " + city + " is: " + predicate.test(city) + " and negation will be " + predicate.negate().test(city));
        }

        displayEndLine();


    }

    private void runX() {
        final List<String> stringList = Arrays.asList("Kefir", "Cheesecake", "Garlic", "Knysza", "Sichuan Hotpot", "Black Pepper", "Beer", "Cheese", "Pak Choi");

        //lambda example
        stringList.forEach(System.out::println);

        //lambda example with block (in general it should NOT be used that way
        stringList.forEach(s -> {
            char first = s.toLowerCase().charAt(0);
            System.out.println(first + s.toUpperCase().substring(1));
        });

        //lambda with 2 elements
        stringList.sort((s1, s2) -> s1.compareTo(s2));

        //using method reference instead of lambda
        stringList.sort(String::compareTo);


        displayEndLine(5);
    }

}
