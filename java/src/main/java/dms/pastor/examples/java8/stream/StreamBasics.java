package dms.pastor.examples.java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


/*
    Stream are like monad in functional programming. a monad is a structure that represents computations defined as sequences of step

    TODO list and practice Stream operations are either intermediate or terminal.
 */
final class StreamBasics {


    static void printIfFindFirstIfPresent() {
        Stream.of("garlic", "lemon", "pepper").findFirst().ifPresent(System.out::println);
    }

    static List<String> streamFilterMapSortedExample() {
        List<String> myList = Arrays.asList("af", "aa", "ba", "ac", "uu", "xa", "ab", "ad", "ae");
        return myList.stream().filter(s -> s.startsWith("a")).map(String::toUpperCase).sorted().collect(Collectors.toList());
    }


    static int[] getRandomNumbersUsingIntStream() {
        final IntStream ints = new Random().ints(10, 10, 100).distinct();
        return ints.toArray();
    }

}
