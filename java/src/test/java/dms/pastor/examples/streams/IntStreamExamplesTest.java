package dms.pastor.examples.streams;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class IntStreamExamplesTest {
    IntStreamSnippets intStreamSnippets = new IntStreamSnippets();

    @Test
    void intStreamCountExampleTest() {
        //given and when
        final long result = intStreamSnippets.intStreamCountExample();

        // then
        assertEquals(10, result);
    }

    @Test
    void intStreamSumExampleTest() {
        //given and when
        final long result = intStreamSnippets.intStreamSumExample();

        // then
        assertEquals(53, result);
    }


    @Test
    void intStreamDistinctExampleTest() {
        // given and when
        final long result = intStreamSnippets.intStreamDistinctExample();

        // then
        assertEquals(9, result);
    }

    @Test
    void intStreamMaxAndOptionalIntExampleTest() {
        // given and when
        final long result = intStreamSnippets.intStreamMaxAndOptionalIntExample();

        // then
        assertEquals(21, result);
    }

    @Test
    void intStreamMinExampleTest() {
        // given and when
        final long result = intStreamSnippets.intStreamMinExample();

        // then
        assertEquals(-1, result);
    }

    @Test
    void intStreamFilterExampleTest() {
        // given and when
        final long result = intStreamSnippets.intStreamFilterExample();

        // then
        assertEquals(3, result);
    }

    @Test
    void intStreamMapExampleTest() {
        // given
        int[] expectedResult = new int[]{26, 2, 4, 10, 6, 2, 16, 0, 42, -2};
        // when
        var result = intStreamSnippets.intStreamMapExample();

        // debug
        System.out.println(Arrays.toString(result));

        // then
        assertArrayEquals(expectedResult, result);
    }

    @Test
    void intStreamMapToObjExampleTest() {
        // given
        List<String> expectedResult = List.of("13", "1", "2", "5", "3", "1", "8", "0", "21", "-1");

        // when
        var result = intStreamSnippets.intStreamMapToObjExample();

        assertEquals(expectedResult, result);

    }

    @Test
    void intStreamMapToDoubleExampleTest() {
        // given and when
        var result = intStreamSnippets.intStreamMapToDoubleExample();

        // then
        assertEquals(5300.0, result);
    }

    @Test
    void intStreamMapToLongExampleTest() {
        // given and when
        var result = intStreamSnippets.intStreamMapToLongExample();

        // then
        assertEquals(53000, result);

    }

    @Test
    void intStreamSortedExampleTest() {
        // given
        int[] expectedResult = new int[]{-1, 0, 1, 1, 2, 3, 5, 8, 13, 21};

        // when
        var result = intStreamSnippets.intStreamSortedExample();


        // debug
        System.out.println(Arrays.toString(result));

        // then
        assertArrayEquals(expectedResult, result);
    }

    @Test
    void intStreamSortedWithComparatorExampleTest() {
        // given
        List<Integer> expectedResult = List.of(21, 13, 8, 5, 3, 2, 1, 1, 0, -1);

        // when
        var result = intStreamSnippets.intStreamSortedWithComparatorExample();

        // then
        assertEquals(expectedResult, result);
    }


    @Test
    void intStreamPeekWithLimitExampleTest() {
        // given
        var expectedResult = new int[]{13, 1};

        // when
        var result = intStreamSnippets.intStreamPeekWithLimitExample();

        // debug
        assertArrayEquals(expectedResult, result);

    }

    @Test
    void intStreamFindFirstExampleTest() {
        // given and when
        var result = intStreamSnippets.intStreamFindFirstExample();

        // then
        assertTrue(result.isPresent());
        assertEquals(13, result.getAsInt());
    }


    @Test
    void intStreamFindAnyExampleTest() {
        // given and when
        var result = intStreamSnippets.intStreamFindAnyExample();

        // then
        assertTrue(result.isPresent());
        assertEquals(13, result.getAsInt());
    }

    @Test
    void intStreamAllExampleTest() {
        // given and when
        var result = intStreamSnippets.intStreamAllMatchExample();

        // then
        assertFalse(result);
    }


    @Test
    void intStreamAnyExampleTest() {
        // given and when
        var result = intStreamSnippets.intStreamAnyMatchExample();

        // then
        assertTrue(result);
    }

    @Test
    void intStreamNoneMatchSortExampleTest() {
        // given and when
        var result = intStreamSnippets.intStreamNoneMatchExample();

        // then
        assertFalse(result);
    }

    @Test
    void intStreamAverageExampleTest() {
        // given and when
        var result = intStreamSnippets.intStreamAverageExample();

        // then
        assertEquals(5.3, result);
    }

    @Test
    void intStreamRangeAndTakeWhileExampleTest() {
        // given
        int[] expectedResult = new int[]{0, 1, 2, 3};
        // when
        var result = intStreamSnippets.intStreamRangeAndTakeWhileExample();

        // then
        assertEquals(4, result.length);
        assertArrayEquals(expectedResult, result);

    }

    @Test
    void intStreamEmptyAndBuilderExampleReturnEmptyIntStreamCountTest() {
        // given and when
        var result = intStreamSnippets.intStreamEmptyAndBuilderExample(true);
        assertEquals(0, result);
    }

    @Test
    void intStreamMaxAndOptionalIntExampleReturnBuilderCountTest() {
        // given and when
        var result = intStreamSnippets.intStreamEmptyAndBuilderExample(false);

        //
        assertEquals(3, result);
    }


    @Test
    void intStreamDropWhileOrderedExampleTest() {
        // given
        int[] expectedResult = new int[]{5, 8, 13, 21};

        // when
        var result = intStreamSnippets.intStreamDropWhileOrderedExample();

        // then
        assertArrayEquals(expectedResult, result);
    }

    @Test
    void intStreamDropWhileUnorderedExampleTest() {
        // given
        int[] expectedResult = new int[]{1, 2, 5, 3, 1, 8, 0, 21, -1};

        // when
        var result = intStreamSnippets.intStreamDropWhileUnorderedExample();

        // then
        assertArrayEquals(expectedResult, result);
    }

    @Test
    void intStreamIterateLimitBodedAndCollectedExampleTest() {
        // given
        List<Integer> expectedResult = List.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);

        // when
        var result = intStreamSnippets.intStreamIterateLimitBodedAndCollectedExample();

        // then
        assertEquals(expectedResult, result);
    }


    @Test
    void intStreamForEachOrderedExampleTest() {
        // given
        long expectedResult = 2396745;

        // when
        final long result = intStreamSnippets.intStreamForEachOrderedExample();

        // then
        assertEquals(expectedResult, result);
    }

    @Test
    void intStreamSummaryStatisticsExampleTest() {
        // given
        var expectedCount = 100;
        var expectedSum = 5050;
        var expectedMin = 1;
        var expectedAverage = 50.5;
        var expectedMax = 100;
        // when
        final var result = intStreamSnippets.intStreamSummaryStatisticsExample();

        // then
        assertEquals(expectedCount, result.getCount());
        assertEquals(expectedSum, result.getSum());
        assertEquals(expectedMin, result.getMin());
        assertEquals(expectedMax, result.getMax());
        assertEquals(expectedAverage, result.getAverage());
    }


    @Test
    void intStreamIterateWithSeedPredicateAndUnaryOperatorExampleTest() {
        // given
        var expectedResult = new int[]{5, 10, 15, 20, 25, 30, 35, 40, 45, 50, 55, 60, 65, 70, 75, 80, 85, 90, 95, 100};

        // when
        var result = intStreamSnippets.intStreamIterateWithSeedPredicateAndUnaryOperatorExample();

        // debug
        System.out.println(Arrays.toString(result));
        // then
        assertArrayEquals(expectedResult, result);
    }


    @Test
        //tag-double-precision-test
    void intStreamAsLongStreamAndAsDoubleStreamExampleTest() {
        // given
        var expectedResult = 5.3;
        // when
        var result = intStreamSnippets.intStreamAsLongStreamAndAsDoubleStreamExample();

        // then
        assertEquals(expectedResult, result, 0.1);
    }

    @Test
    void intStreamSkipExampleTest() {
        // given
        var expectedResult = new int[]{5, 3, 1, 8, 0, 21, -1};
        // when
        var result = intStreamSnippets.intStreamSkipExample();


        // then
        assertArrayEquals(expectedResult, result);
    }

    @Test
    void intStreamReduceExampleTest() {

        // given & when
        var result = intStreamSnippets.intStreamReduceExample();

        // then
        assertEquals(106, result);
    }

    @Test
    void intStreamFlatMapToIntExampleTest() {
        // given
        int[] expectedResult = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};

        //when
        var result = intStreamSnippets.intStreamFlatMapExample();

        // then
        assertArrayEquals(expectedResult, result);
    }

    @Test
    void intStreamGenerateExampleTest() {

        // given & when
        var result = intStreamSnippets.intStreamGenerateExample();

        // debug
        System.out.println(Arrays.toString(result));

        // then
        assertEquals(10, result.length);

    }

    @Test
    void intStreamConcatExampleTest() {

        // when
        var result = intStreamSnippets.intStreamConcatExample();

        // then
        assertEquals(98, result);
    }


    @Test
    void intStreamSequentialParallelExampleTest() {
        // when
        var result = intStreamSnippets.intStreamSequentialParallelExample();

        // debug
        System.out.println(result);
    }

    @Test
    void intStreamIteratorExampleTest() {
        // given
        var input = "BritishClass221 ( SuperVoyager )";
        var expectedTrainClassName = "BritishClass221";
        var expectedTrainName = "SuperVoyager";
        // when
        var result = intStreamSnippets.intStreamIteratorExample(input);

        // then
        assertEquals(expectedTrainClassName, result.getLeft());
        assertEquals(expectedTrainName, result.getRight());
    }

}