package dms.pastor.examples.streams;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DoubleStreamSnippetsTest {
    DoubleStreamSnippets doubleStreamExamples = new DoubleStreamSnippets();

    @Test
    void doubleStreamExampleToUseAsManyMethodPart1ExampleTest() {
        // given and when
        var result = doubleStreamExamples.doubleStreamExampleToUseAsManyMethodPart1Example();

        // then
        assertEquals(31.0, result);

    }


    @Test
    void doubleStreamExampleWithMinMaxAvgCountFindFirstAnyExampleTest() {
        // given
        String expectedResult = "min: OptionalDouble[-13.1] max: OptionalDouble[21.0] average: OptionalDouble[0.9716666666666668] count: 18 first: OptionalDouble[0.0] any: OptionalDouble[0.0]";
        // when
        var result = doubleStreamExamples.doubleStreamExampleWithMinMaxAvgCountFindFirstAnyExample();

        // then
        assertEquals(expectedResult, result);

    }

    @Test
    void doubleStreamAnyMatchExampleTest() {
        // when
        var result = doubleStreamExamples.doubleStreamAnyMatchExample();

        // then
        assertTrue(result);
    }

    @Test
    void doubleStreamAllMatchExampleTest() {
        // when
        var result = doubleStreamExamples.doubleStreamAllMatchExample();

        // then
        assertFalse(result);
    }

    @Test
    void doubleStreamNoneMatchExampleTest() {
        // when
        var result = doubleStreamExamples.doubleStreamNoneMatchExample();

        // then
        assertTrue(result);
    }

    @Test
    void doubleStreamMapToIntWithToArrayExampleTest() {
        // given
        var expectedResult = new int[]{0, -13, 2, 3, 6, 4, 1, -8, 21, -1};

        // when
        var result = doubleStreamExamples.doubleStreamMapToIntWithToArrayExample();

        // debug
        System.out.println(Arrays.toString(result));

        // then
        assertArrayEquals(expectedResult, result);
    }

    @Test
    void doubleStreamMapToIntWithToListExampleTest() {
        // given
        var expectedResult = new double[]{0.0, 13.1, 1.9, 2.8, 2.79, 5.6, 3.5, 1.0, 8.0, 21.0, 1.0};

        // when
        var result = doubleStreamExamples.doubleStreamMapToIntWithToListExample();

        // then
        assertArrayEquals(expectedResult, result);
    }

    @Test
    void doubleStreamWithGenerateTakeWhileDropWhileSummaryStatisticsExampleTest() {
        // when
        var result = doubleStreamExamples.doubleStreamWithGenerateTakeWhileDropWhileSummaryStatisticsExample();

        // debug
        System.out.println(result);

        // then
        assertFalse(result.isEmpty());
    }


    @Test
    void doubleStreamMapToObjExampleTest(){
        // given
        List<String> expectedResult = List.of("-13.1", "-8.0", "-1.0", "0.0", "1.0", "1.9", "2.79", "2.8", "3.5", "5.6", "21.0");
        // when
        var result = doubleStreamExamples.doubleStreamMapToObjExample();

        // then
       assertEquals(expectedResult, result);
    }
}