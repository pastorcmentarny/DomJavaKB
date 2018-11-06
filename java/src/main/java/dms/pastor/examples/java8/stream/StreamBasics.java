package dms.pastor.kb.java8.stream;

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
    private static boolean runAll = false;


    public static void main(String[] args) {
        tutorial();

        if (runAll) {
            hr(3);
            example();
            kindOfStreams();
            sketchMethod();
        }
    }

    private static void tutorial() {
        hr();
        final List<String> aList = Arrays.asList("a1", "a2", "c3", "c4", "b1", "c2", "c1");
        aList.stream().filter(s -> s.startsWith("c")).map(String::toUpperCase).forEach(System.out::println);
        hr();
        streamExamples();
        hr();
    }

    private static void streamExamples() {
        hr("find first and ifPresent");
        Arrays.asList("garlic", "lemon", "pepper").stream().findFirst().ifPresent(System.out::println);
        final int[] randomNumbers = getRandomNumbers();
        displayIntArray(randomNumbers);

        System.out.println(Arrays.stream(randomNumbers).map(n -> n + 1).average());


    }

    private static void displayIntArray(final int[] randomNumbers) {
        for (int i : randomNumbers) {
            System.out.println(i);
        }
    }


    private static final void example() {
        List<String> myList = Arrays.asList("af", "aa", "ba", "ac", "uu", "xa", "ab", "ad", "ae");
        myList.stream().filter(s -> s.startsWith("a")).map(String::toUpperCase).sorted().forEach(System.out::println);
    }

    private static void kindOfStreams() {

        hr();
        Arrays.asList("a", "bb", "ccc").stream().findFirst().ifPresent(System.out::println);

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


    public static void hr() {
        System.out.println();
        IntStream.range(1, 20).forEach(s -> System.out.print("--"));
        System.out.println();
    }

    private static void hr(String title) {
        System.out.println("-- -- --\n" + title);
        hr();
    }

    private static void hr(final int lines) {
        hr();
        for (int i = 0; i < lines; i++) {
            System.out.println();
        }
    }


    private static void sketchMethod() {
        hr();
        Arrays.asList("af", "aa", "ba", "ac", "uu", "xa", "ab", "ad", "ae").stream().map(s -> s = "?").forEach(System.out::print);

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
