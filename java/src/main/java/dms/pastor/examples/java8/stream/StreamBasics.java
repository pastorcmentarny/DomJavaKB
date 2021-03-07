package dms.pastor.examples.java8.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;


/*
    Stream are like monad in functional programming. a monad is a structure that represents computations defined as sequences of step

    TODO list and practice Stream operations are either intermediate or terminal.
 */
final class StreamBasics {
    private static final boolean runAll = false;


    static void tutorial() {
        hr();
        final List<String> aList = Arrays.asList("a1", "a2", "c3", "c4", "b1", "c2", "c1");
        aList.stream().filter(s -> s.startsWith("c")).map(String::toUpperCase).forEach(System.out::println);
        hr();
        streamExamples();
        hr();
    }

    private static void streamExamples() {
        hr("find first and ifPresent");
        Stream.of("garlic", "lemon", "pepper").findFirst().ifPresent(System.out::println);
        final int[] randomNumbers = getRandomNumbers();
        displayIntArray(randomNumbers);

        System.out.println(Arrays.stream(randomNumbers).map(n -> n + 1).average());


    }

    private static void displayIntArray(final int[] randomNumbers) {
        for (int i : randomNumbers) {
            System.out.println(i);
        }
    }


    static void example() {
        List<String> myList = Arrays.asList("af", "aa", "ba", "ac", "uu", "xa", "ab", "ad", "ae");
        myList.stream().filter(s -> s.startsWith("a")).map(String::toUpperCase).sorted().forEach(System.out::println);
    }

    static void kindOfStreams() {

        hr();
        Stream.of("a", "bb", "ccc").findFirst().ifPresent(System.out::println);

        hr();
        final ArrayList<String> listOfString = new ArrayList<>();
        listOfString.add("Q4");
        listOfString.add("Q3");
        listOfString.add("Q2");
        listOfString.add("Q1");
        System.out.println("It should be 1 ,result is : " + listOfString.stream().filter(s -> s.endsWith("2")).count());
        listOfString.stream().findFirst().ifPresent(System.out::println);

        hr();
        listOfString.stream().sorted().forEach(s -> System.out.print(": " + s + " :"));

        hr();
        Stream.of("aa", "bb", "cc").findFirst().ifPresent(System.out::println);
    }


    private static void hr() {
        System.out.println();
        IntStream.range(1, 20).forEach(s -> System.out.print("--"));
        System.out.println();
    }

    private static void hr(String title) {
        System.out.println("-- -- --\n" + title);
        hr();
    }

    static void hr(final int lines) {
        hr();
        for (int index = 0; index < lines; index++) {
            System.out.println();
        }
    }


    static void sketchMethod() {
        hr();
        Stream.of("af", "aa", "ba", "ac", "uu", "xa", "ab", "ad", "ae").map(s -> s = "?").forEach(System.out::print);

    }


    private static List<String> getList() {
        return Arrays.asList("Acceptance criteria", "Daily Stand up", "Epic", "Grooming", "Impediment", "Kanban", "Scrum", "Product owner", "Retrospective", "Sprint", "Timeboxed", "User Story");
    }

    private static int[] getRandomNumbers() {
        System.out.println("Generating random numbers..");
        final IntStream ints = new Random().ints(10, 10, 100).distinct();
        return ints.toArray();
    }

}
