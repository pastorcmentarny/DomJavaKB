package dms.pastor.examples.j11to17;

import java.text.NumberFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.stream.Collectors;

public class Java17PresentationRunner {

    private static void java12(){
        System.out.println("Dominik".indent(10));

        final Locale locale = Locale.UK;
        List<Integer> numbers = List.of(1000, 1000000);
        final var stringBuilder = new StringBuilder();
        numbers.forEach((integer) -> {
            NumberFormat shortNumberFormat = NumberFormat.getCompactNumberInstance(locale, NumberFormat.Style.SHORT);
            NumberFormat longNumberFormat = NumberFormat.getCompactNumberInstance(locale, NumberFormat.Style.LONG);

            String formattedShortNumber = shortNumberFormat.format(integer);
            String formattedLongNumber = longNumberFormat.format(integer);

            stringBuilder.append("short: ").append(formattedShortNumber).append(" long: ").append(formattedLongNumber).append("\n");
        });
        System.out.println(stringBuilder);

    }
    public static void main(String[] args) {
        java12();
        java13();
        java14();
        java15();
        java16();
        java17();
    }

    private static void java17() {
        //a lot of mac specific upgrade releateds to changes in OS and new ARM cpu. Too boring to read for me.
        // nhanced Pseudo-Random Number Generators
        // Pattern Matching for switch is still in Preview
        //Support for Unicode 13.0, an important update for emoji lovers

    }

    private static void java16() {
        //Strongly Encapsulate JDK Internals are ON by default except sun.misc.Unsafe ,so we may have some issues with ancient libraries

        //NEW fancy addtition to time
        LocalTime date = LocalTime.parse("20:25:08.000002");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("h B");
        System.out.println(date.format(formatter));

        //Add Stream.toList Method
        List<String> integersAsString = Arrays.asList("1", "2", "3");
        List<Integer> ints = integersAsString.stream().map(Integer::parseInt).toList();
        System.out.println(ints);

        //some improvements to Record


    }

    private static void java15() {
        //CharSequence has new method isEmpty
        CharSequence chars = new StringBuilder("UFO");
        System.out.println(chars.isEmpty());

        //record , it is a stolen version of  you use lombok then record will be a familiar
        var me = new Person("Dominik",21);
        System.out.println(me.age());

        //text block
        var multiLine = """
            <xml>
                <OrderNumber>
                    10000
                </OrderNumber>
                </xml>
            """;
        System.out.println(multiLine);
        //Sealed Classes allows control access over the inheritance, what can and cannot be extended, useful for libraries we don't write libraries.. so
        //Hidden Classes. Another useful feature for people who write libraries and frameworks as it allows creation of classes  at  runtime are not discoverable by reflection
        //JavaScript engine was removed
    }


    public static String getDayType(String day) {
        if (Objects.isNull(day)) {
            return "Can't determined day type as day is not provided";
        }
        return switch (day) {
            case "Monday", "Tuesday", "Wednesday", "Thursday", "Friday" -> "Weekday";
            case "Saturday", "Sunday" -> "Weekend";
            default -> {
                if (day.isEmpty()) {
                    yield "Can't determined day type as day is not provided";
                } else {
                    yield "Can't determined day type as input was invalid (input :" + day + ").";
                }
            }

        };
    }

    private static String cutTo3Char(String str) {
        try {
            return str.substring(0,3);
        } catch (Exception exception) {
            return exception.getMessage();
        }

    }

    private static void java14() {
        //Helpful NullPointerExceptions
            String input = null;
            String result = cutTo3Char(input);
            System.out.println(result);


        // Switch State
        System.out.println(getDayType("Monday"));
        System.out.println(getDayType("Sunday"));
        System.out.println(getDayType("MOONday"));


        // there is a lot of preview featurs added

    }

    private static void java13() {
        //NOTHING EXCITING apart of ... Improvement to Z Garbage Collector (a low-latency garbage collection) with  return Unused Memory to OS by default
        //https://www.oracle.com/java/technologies/javase/13-relnote-issues.html
    }


    private record Person(String name, int age) {
    }
}
