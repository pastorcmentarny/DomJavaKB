package dms.pastor.tasks.exercises.numbers;

import org.junit.jupiter.api.Test;

import static dms.pastor.tasks.exercises.numbers.MultiplicationExercise.generateMultiplicationSquareTable;
import static dms.pastor.utils.randoms.RandomDataGenerator.randomNegativeInteger;
import static java.lang.System.lineSeparator;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author Dominik Symonowicz
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class MultiplicationExerciseTest {

    @Test
    public void shouldReturnEmptyStringForNegativeNumberTest() {
        // when
        final String result = generateMultiplicationSquareTable(randomNegativeInteger());

        // then
        assertThat(result).isEmpty();
    }

    @Test
    public void shouldReturnMultiplicationSquareTableTest() {
        // given
        final String expectedResult = "    1    2    3    4    5" + lineSeparator() +
                "    2    4    6    8   10" + lineSeparator() +
                "    3    6    9   12   15" + lineSeparator() +
                "    4    8   12   16   20" + lineSeparator() +
                "    5   10   15   20   25" + lineSeparator();

        // when
        final String result = generateMultiplicationSquareTable(5);

        // then
        assertThat(result).isEqualTo(expectedResult);
    }
}