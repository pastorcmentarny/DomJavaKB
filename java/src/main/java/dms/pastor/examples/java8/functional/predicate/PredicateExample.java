package dms.pastor.examples.java8.functional.predicate;

import dms.pastor.examples.java8.junk.Unit;
import dms.pastor.examples.java8.junk.UnitFactory;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateExample {
    private static List<String> getStringArray() {
        return Arrays.asList("Wroclaw", "Tianjin", "London", "Aberystwyth", "Bangor", "York", "Beijing");
    }

    private static void example() {
        System.out.println("OTHER STUFF...... ........");
        System.out.println("you can create a reference to the Unit constructor via Unit::new." +
            " The Java compiler automatically chooses the right constructor by matching the signature of PersonFactory.create.");
        UnitFactory unitFactory = Unit::new;
        final Unit dofutaly = unitFactory.create("Dofutaly", "Dofutaly is a fat and ugly Dominik", 34);
        System.out.println(dofutaly.toString());

        Predicate<String> predicate = (text) -> text.startsWith("B");
        for (String city : getStringArray()) {
            System.out.println("City: " + city + " is: " + predicate.test(city) + " and negation will be " + predicate.negate().test(city));
        }


    }
}
