package dms.pastor.examples.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.DoubleStream;

public class DoubleStreamSnippets {
    public double doubleStreamExampleToUseAsManyMethodPart1Example() {
        return DoubleStream.of(0,0,0,-13.1, 1.9, 2.8, 2.79, 5.6, 3.5, 1.0, 1.0, -8.0, 0, 21, -1,0,0,0)
                .skip(3)
                .filter(number -> number >= -10)
                .distinct()
                .sorted()
                .peek(System.out::println)
                .limit(10)
                .boxed()
                .mapToLong(Math::round)
                .mapToDouble(Math::round)
                .peek(System.out::println)
                .sum();
    }


    public String doubleStreamExampleWithMinMaxAvgCountFindFirstAnyExample() {
        DoubleStream.of(0, 0, 0, -13.1, 1.9, 2.8, 2.79, 5.6, 3.5, 1.0, 1.0, -8.0, 0, 21, -1, 0, 0, 0)
                .forEachOrdered(System.out::println);

        var min = DoubleStream.of(0, 0, 0, -13.1, 1.9, 2.8, 2.79, 5.6, 3.5, 1.0, 1.0, -8.0, 0, 21, -1, 0, 0, 0)
                .min();

        var max = DoubleStream.of(0, 0, 0, -13.1, 1.9, 2.8, 2.79, 5.6, 3.5, 1.0, 1.0, -8.0, 0, 21, -1, 0, 0, 0)
                .max();

        var average = DoubleStream.of(0, 0, 0, -13.1, 1.9, 2.8, 2.79, 5.6, 3.5, 1.0, 1.0, -8.0, 0, 21, -1, 0, 0, 0)
                .average();

        var count = DoubleStream.of(0, 0, 0, -13.1, 1.9, 2.8, 2.79, 5.6, 3.5, 1.0, 1.0, -8.0, 0, 21, -1, 0, 0, 0)
                .count();

        var first = DoubleStream.of(0, 0, 0, -13.1, 1.9, 2.8, 2.79, 5.6, 3.5, 1.0, 1.0, -8.0, 0, 21, -1, 0, 0, 0)
                .findFirst();

        var any = DoubleStream.of(0, 0, 0, -13.1, 1.9, 2.8, 2.79, 5.6, 3.5, 1.0, 1.0, -8.0, 0, 21, -1, 0, 0, 0)
                .findAny();

        return "min: " + min + " max: " + max + " average: " + average + " count: " + count + " first: " + first + " any: " + any;

    }



    public boolean doubleStreamAnyMatchExample() {
        return DoubleStream.of(0, 0, 0, -13.1, 1.9, 2.8, 2.79, 5.6, 3.5, 1.0, 1.0, -8.0, 0, 21, -1, 0, 0, 0).anyMatch(number -> number >= -10);
    }

    public boolean doubleStreamAllMatchExample() {
        return DoubleStream.of(0, 0, 0, -13.1, 1.9, 2.8, 2.79, 5.6, 3.5, 1.0, 1.0, -8.0, 0, 21, -1, 0, 0, 0).allMatch(number -> number >= -10);
    }

    public boolean doubleStreamNoneMatchExample() {
        return DoubleStream.of(0, 0, 0, -13.1, 1.9, 2.8, 2.79, 5.6, 3.5, 1.0, 1.0, -8.0, 0, 21, -1, 0, 0, 0).noneMatch(number -> number >= 22);
    }

    public int[] doubleStreamMapToIntWithToArrayExample() {
        return DoubleStream.of(0, 0, 0, -13.1, 1.9, 2.8, 2.79, 5.6, 3.5, 1.0, 1.0, -8.0, 0, 21, -1, 0, 0, 0).mapToInt(number -> (int)Math.round(number)).distinct().toArray();
    }


    public double[] doubleStreamMapToIntWithToListExample() {
        final DoubleStream first = DoubleStream.of(0, 0, 0, -13.1, 1.9, 2.8, 2.79, 5.6);
        final DoubleStream second = DoubleStream.of(3.5, 1.0, 1.0, -8.0, 0, 21, -1, 0, 0, 0);

        final double[] result = DoubleStream.concat(first, second)
                .distinct()
                .peek(System.out::println).
                map(Math::abs).toArray();

        Arrays.stream(result).forEach(System.out::println);
        return result;
    }


    //TODO need normal example not some crazy combos :D
    public String doubleStreamWithGenerateTakeWhileDropWhileSummaryStatisticsExample(){

        return DoubleStream.generate(Math::random)
                .limit((262144))
                .parallel()
                .distinct()
                .sorted()
                .takeWhile(number -> number <= 0.1)
                .dropWhile(number -> number >= 0.5)
                .summaryStatistics().toString();
    }


    public List<String> doubleStreamMapToObjExample(){
        return DoubleStream.of(0, 0, 0, -13.1, 1.9, 2.8, 2.79, 5.6, 3.5, 1.0, 1.0, -8.0, 0, 21, -1, 0, 0, 0)
                .distinct()
                .sorted()
                .mapToObj(String::valueOf)
                .toList();
    }
}
