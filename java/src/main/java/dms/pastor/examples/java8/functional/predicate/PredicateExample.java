package dms.pastor.examples.java8.functional.predicate;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

class PredicateExample {
    private static List<String> getStringArray() {
        return Arrays.asList("Wroclaw", "Tianjin", "London", "Aberystwyth", "Bangor", "York", "Beijing");
    }

    static String example() {

        StringBuilder stringBuilder = new StringBuilder();

        Predicate<String> predicate = (text) -> text.startsWith("B");
        getStringArray().forEach(city -> stringBuilder.append("City: ").append(city).append(" is: ").append(predicate.test(city)).append(" and negation will be ").append(predicate.negate().test(city)).append("\n"));

        return stringBuilder.toString();
    }
}
