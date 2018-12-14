package dms.pastor.examples.java8.lambdas;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/*
    TODO compare scope of Lambdas and anonymous class


    parameter -> body
    Return , type declaration, parenthesis around parameter are optional
 */
final class LambdasBasics {

    private static int CONST_MODIFIER = 1;

    public static void main(String[] args) {
        basics();
        scopeBasics();
    }

    private static void scopeBasics() {
        final int adder = 3;
        List<Integer> numbers = Arrays.asList(1, 2, 3, 5, 8, 13);
        numbers.forEach((n) -> {
            n += adder;
            System.out.println(n);
            n -= CONST_MODIFIER;
        });

    }

    private static void basics() {
        List<String> names = Arrays.asList("dom", "xu", "bobo", "mama", "tata", "alek");
        names.sort(Comparator.reverseOrder());
        names.stream().forEach(System.out::println);
    }
}
