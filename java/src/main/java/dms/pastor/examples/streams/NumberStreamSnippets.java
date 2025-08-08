package dms.pastor.examples.streams;

import dms.pastor.domain.exception.NotImplementYetException;
import org.apache.commons.lang3.tuple.Pair;

import java.time.Duration;
import java.time.Instant;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;


/**
 * Author: Dominik Symonowicz
 * Website: <a href="https://dominiksymonowicz.com/">Home Page</a>
 * LinkedIn: <a href="https://www.linkedin.com/in/dominik-symonowicz">LinkedIn</a>
 * GitHub: <a href="https://github.com/pastorcmentarny">GitHub</a>
 */
public class NumberStreamSnippets {


    public long intStreamCountExample() {
        return IntStream.of(13, 1, 2, 5, 3, 1, 8, 0, 21, -1).count();
    }

    public long intStreamSumExample() {
        return IntStream.of(13, 1, 2, 5, 3, 1, 8, 0, 21, -1).sum();
    }

    public long intStreamDistinctExample() {
        return IntStream.of(13, 1, 2, 5, 3, 1, 8, 0, 21, -1).distinct().count();
    }

    public long intStreamMaxAndOptionalIntExample() {
        return IntStream.of(13, 1, 2, 5, 3, 1, 8, 0, 21, -1).max().getAsInt();
    }

    public long intStreamMinExample() {
        return IntStream.of(13, 1, 2, 5, 3, 1, 8, 0, 21, -1).min().getAsInt();
    }

    public long intStreamFilterExample() {
        return IntStream.of(13, 1, 2, 5, 3, 1, 8, 0, 21, -1).filter(number -> number > 5).count();
    }


    public int[] intStreamMapExample() {
        return IntStream.of(13, 1, 2, 5, 3, 1, 8, 0, 21, -1)
                .map(i -> i * 2)
                .toArray();
    }

    public List<String> intStreamMapToObjExample() {
        return IntStream.of(13, 1, 2, 5, 3, 1, 8, 0, 21, -1).mapToObj(String::valueOf).toList();
    }

    public double intStreamMapToDoubleExample() {
        return IntStream.of(13, 1, 2, 5, 3, 1, 8, 0, 21, -1).mapToDouble(integer -> integer / 0.01).sum();
    }

    public long intStreamMapToLongExample() {
        return IntStream.of(13, 1, 2, 5, 3, 1, 8, 0, 21, -1).mapToLong(integer -> integer * 1000).sum();
    }

    public int[] intStreamSortedExample() {
        return IntStream.of(13, 1, 2, 5, 3, 1, 8, 0, 21, -1).sorted().toArray();
    }


    public List<Integer> intStreamSortedWithComparatorExample() {
        return Stream.of(13, 1, 2, 5, 3, 1, 8, 0, 21, -1).sorted(Comparator.reverseOrder()).toList();
    }

    public int[] intStreamPeekWithLimitExample() {
        return IntStream.of(13, 1, 2, 5, 3, 1, 8, 0, 21, -1).peek(System.out::println).limit(2).toArray();
    }

    public OptionalInt intStreamFindFirstExample() {
        return IntStream.of(13, 1, 2, 5, 3, 1, 8, 0, 21, -1).findFirst();
    }

    public OptionalInt intStreamFindAnyExample() {
        return IntStream.of(13, 1, 2, 5, 3, 1, 8, 0, 21, -1).findAny();
    }

    public boolean intStreamAllMatchExample() {
        return IntStream.of(13, 1, 2, 5, 3, 1, 8, 0, 21, -1).allMatch(integer -> integer > 1);
    }

    public boolean intStreamAnyMatchExample() {
        return IntStream.of(13, 1, 2, 5, 3, 1, 8, 0, 21, -1).anyMatch(integer -> integer > 1);
    }

    public boolean intStreamNoneMatchExample() {
        return IntStream.of(13, 1, 2, 5, 3, 1, 8, 0, 21, -1).noneMatch(integer -> integer > 1);
    }

    public double intStreamAverageExample() {
        return IntStream.of(13, 1, 2, 5, 3, 1, 8, 0, 21, -1).average().orElseThrow();
    }


    public int[] intStreamRangeAndTakeWhileExample() {
        return IntStream.range(0, 10).takeWhile(integer -> integer < 4).toArray();
    }

    //It is very unclever example,  is it ?Sometimes, I just don't bother with meaningful idea, when I just explore class
    public long intStreamEmptyAndBuilderExample(boolean empty) {
        return empty ? IntStream.empty().count() : IntStream.builder().add(1).add(2).add(3).build().count();
    }

    //It stops skipping once the first element fails the predicate test.
    public int[] intStreamDropWhileOrderedExample() {
        return IntStream.of(13, 1, 2, 5, 3, 1, 8, 0, 21, -1).sorted().dropWhile(integer -> integer < 5).toArray();
    }

    public int[] intStreamDropWhileUnorderedExample() {
        return IntStream.of(13, 1, 2, 5, 3, 1, 8, 0, 21, -1).dropWhile(integer -> integer > 5).toArray();
    }

    public List<Integer> intStreamIterateLimitBodedAndCollectedExample() {
        return IntStream.iterate(0, integer -> integer + 1)
                .limit(10)
                .boxed()
                .collect(toList());
    }

    public long intStreamForEachOrderedExample() {
        List<Integer> dividableBySeven = new ArrayList<>();

        IntStream.range(1, 16777216)
                .forEachOrdered(integer -> {
                            if (integer % 7 == 0) {
                                dividableBySeven.add(integer);
                            }

                        }
                );

        return dividableBySeven.size();

    }

    public IntSummaryStatistics intStreamSummaryStatisticsExample() {
        return IntStream.rangeClosed(1, 100).summaryStatistics();
    }


    public int[] intStreamIterateWithSeedPredicateAndUnaryOperatorExample() {
        return IntStream.iterate(5,
                i -> i <= 100, i -> i + 5).toArray();
    }

    public double intStreamAsLongStreamAndAsDoubleStreamExample() {
        return IntStream.of(13, 1, 2, 5, 3, 1, 8, 0, 21, -1).asLongStream()
                .map(longNumber -> longNumber * 2147483647)
                .asDoubleStream().
                map(doubleNumber -> doubleNumber / 2147483647 / 10)
                .sum();
    }

    public int[] intStreamSkipExample() {
        return IntStream.of(13, 1, 2, 5, 3, 1, 8, 0, 21, -1).skip(3).toArray();
    }

    public int intStreamReduceExample() {
        return IntStream.of(13, 1, 2, 5, 3, 1, 8, 0, 21, -1).reduce(0, (subtotal, element) -> subtotal + element * 2);
    }

    public int[] intStreamFlatMapExample() {
        var list1 = new int[]{7, 8, 9};
        var list2 = new int[]{1, 2, 3};
        var list3 = new int[]{4, 5, 6};
        List<int[]> list = Arrays.asList(list1, list2, list3);

        return list.stream().flatMapToInt(Arrays::stream).sorted().toArray();
    }

    public int[] intStreamGenerateExample() {
        return IntStream.generate(() -> (int) (Math.random() * 100))
                .limit(10)
                .toArray();

    }

    public int intStreamConcatExample() {
        final IntStream intStreamOne = IntStream.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        final IntStream intStreamTwo = IntStream.of(13, 1, 2, 5, 3, 1, 8, 0, 21, -1);

        return IntStream.concat(intStreamOne, intStreamTwo).sum();
    }

    public void intStreamMapMultiExample() {
        throw new NotImplementYetException("mapMulti");
    }

    //TODO better example
    public long intStreamSequentialParallelExample() {
        final int[] randomlyGeneratedArray = IntStream.generate(() -> (int) (Math.random() * 262144))
                .limit(262144)
                .toArray();

        System.out.println("Array size2:" + randomlyGeneratedArray.length);
        final int[] seqArray = randomlyGeneratedArray.clone();
        final int[] parArray = randomlyGeneratedArray.clone();

        Instant seqStart = Instant.now();
        final OptionalDouble seqAverage = IntStream.of(seqArray).sequential().average();
        Instant seqFinish = Instant.now();
        long seqTimeElapsed = Duration.between(seqStart, seqFinish).toMillis();
        System.out.println("seqAverage: " + seqAverage + " done in " + seqTimeElapsed + " ms.");

        Instant parStart = Instant.now();
        final OptionalDouble parAverage = IntStream.of(parArray).parallel().average();
        Instant parFinish = Instant.now();
        long parTimeElapsed = Duration.between(parStart, parFinish).toMillis();
        System.out.println("parAverage: " + parAverage + " done in " + parTimeElapsed + " ms.");

        return parTimeElapsed - seqTimeElapsed;
    }

    public Pair<String, String> intStreamIteratorExample(String input) {
        StringBuilder trainClass = new StringBuilder();
        StringBuilder trainName = new StringBuilder();
        IntStream intStream = input.chars();
        PrimitiveIterator.OfInt iterator = intStream.iterator();
        boolean inWord = false;
        while (iterator.hasNext()) {
            char c = (char) iterator.nextInt();
            if (c == '(') {
                inWord = true;
            } else if (c == ')') {
                inWord = false;
                trainName.append(" ");
            } else {
                if (inWord) {
                    trainName.append(c);
                } else {
                    trainClass.append(c);
                }
            }
        }
        if (trainName.charAt(trainName.length() - 1) == ' ') {
            trainName = new StringBuilder(trainName.substring(0, trainName.length() - 1));

        }
        return Pair.of(trainClass.toString().trim(), trainName.toString().trim());
    }

}
