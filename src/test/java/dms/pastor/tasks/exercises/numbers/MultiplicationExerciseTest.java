package dms.pastor.tasks.exercises.numbers;

import org.junit.Assert;
import org.junit.Test;

import static dms.pastor.tasks.exercises.numbers.MultiplicationExercise.generateMultiplicationSquareTable;
import static dms.pastor.utils.randoms.RandomDataGenerator.randomNegativeInteger;
import static org.hamcrest.CoreMatchers.is;

/**
 * Author Dominik Symonowicz
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class MultiplicationExerciseTest {

    @Test
    public void shouldReturnEmptyStringForNegativeNumberTest() throws Exception {
        // when
        final String result = generateMultiplicationSquareTable(randomNegativeInteger());

        // then
        Assert.assertThat(result.isEmpty(), is(true));
    }

    @Test
    public void shouldReturnMultiplicationSquareTableTest() throws Exception {
        // given
        final String expectedResult = "    1    2    3    4    5\n" +
                "    2    4    6    8   10\n" +
                "    3    6    9   12   15\n" +
                "    4    8   12   16   20\n" +
                "    5   10   15   20   25\n";
        // when
        final String result = generateMultiplicationSquareTable(5);

        // then
        Assert.assertEquals(expectedResult, result);
    }
}