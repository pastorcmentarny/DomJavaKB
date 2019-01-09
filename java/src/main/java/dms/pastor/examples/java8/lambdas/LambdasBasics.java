package dms.pastor.examples.java8.lambdas;

import java.util.Arrays;
import java.util.List;

/*
    TODO compare scope of Lambdas and anonymous class


    parameter -> body
    Return , type declaration, parenthesis around parameter are optional
 */
final class LambdasBasics {

    private static final int CONST_MODIFIER = 1;

    public static void main(String[] args) {
        scopeBasics();
    }

    private static void scopeBasics() {
        final int adder = 3;
        List<Integer> numbers = Arrays.asList(1, 2, 3, 5, 8, 13);
        numbers.forEach((number) -> {
            number += adder;
            System.out.println(number);
            number -= CONST_MODIFIER;
        });

    }

}
