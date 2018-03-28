package dms.pastor.tasks.other;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author Dominik Symonowicz
 * Created 15/05/2015
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class ArraysExercisesTest {

    private static final int MIN_POSITIVE_VALUE = 4;
    private static final int MAX_POSITIVE_VALUE = 4096;
    private static final int[] NUMBERS = new int[]{5, 6, 9, MAX_POSITIVE_VALUE, 1000, MIN_POSITIVE_VALUE, 2048};
    private static final int MIN_NEGATIVE_VALUE = -2;
    private static final int MAX_NEGATIVE_VALUE = -10;
    private final ArraysExercises exercise = new ArraysExercises();

    @Test
    public void testLargestAndSmallest() {
        String answer = "Min:" + MIN_POSITIVE_VALUE + " Max:" + MAX_POSITIVE_VALUE;
        assertThat(exercise.findLargestAndSmallest(NUMBERS)).isEqualTo(answer);
    }

    @Test
    public void findLargestAndSmallestShouldReturnTheSameNumberIfArrayContainsOneNumber() {
        // given
        final int answerNumber = 6;
        final int[] oneNumberArray = new int[]{answerNumber};
        final String expectedAnswer = "Min:" + answerNumber + " Max:" + answerNumber;

        // when
        final String answer = exercise.findLargestAndSmallest(oneNumberArray);

        // then
        assertThat(answer).isEqualTo(expectedAnswer);
    }

    @Test
    public void getMaximumValueShouldReturnLargerPositiveValueWhenSmallerPositiveValueIsComparedToLargerPositiveValue() {
        // when
        final int result = exercise.getMaximumValue(MIN_POSITIVE_VALUE, MAX_POSITIVE_VALUE);

        // then
        assertThat(result).isEqualTo(MAX_POSITIVE_VALUE);
    }

    @Test
    public void getMaximumValueShouldReturnLargerPositiveValueWhenSmallerNegativeValueIsComparedToLargerPositiveValue() {
        // when
        final int result = exercise.getMaximumValue(MIN_NEGATIVE_VALUE, MAX_POSITIVE_VALUE);

        // then
        assertThat(result).isEqualTo(MAX_POSITIVE_VALUE);

    }

    @Test
    public void getMaximumValueShouldReturnSmallerNegativeValueWhenLargerNegativeValueIsComparedToSmallerNegativeValue() {
        // when
        final int result = exercise.getMaximumValue(MAX_NEGATIVE_VALUE, MIN_NEGATIVE_VALUE);

        // then
        assertThat(result).isEqualTo(MIN_NEGATIVE_VALUE);

    }

    @Test
    public void getMaximumValueShouldReturnLargerPositiveValueWhenLargerPositiveValueIsComparedToSmallerPositiveValue() {
        // when
        final int result = exercise.getMaximumValue(MAX_POSITIVE_VALUE, MIN_POSITIVE_VALUE);

        // then
        assertThat(result).isEqualTo(MAX_POSITIVE_VALUE);
    }

    @Test
    public void getMaximumValueShouldReturnLargerPositiveValueWhenComparedToSmallerNegativeValue() {
        // when
        final int result = exercise.getMaximumValue(MAX_POSITIVE_VALUE, MIN_NEGATIVE_VALUE);

        // then
        assertThat(result).isEqualTo(MAX_POSITIVE_VALUE);
    }

    @Test
    public void getMaximumValueShouldReturnSmallerNegativeValueWhenSmallerNegativeValueIsComparedToLargerNegativeValue() {
        // when
        final int result = exercise.getMaximumValue(MIN_NEGATIVE_VALUE, MAX_NEGATIVE_VALUE);

        // then
        assertThat(result).isEqualTo(MIN_NEGATIVE_VALUE);
    }

    @Test
    public void getMinimumValueShouldReturnSmallerPositiveValueWhenYouCompareLargerPositiveValueToSmallerPositiveValue() {
        // when
        final int result = exercise.getMinimumValue(MAX_POSITIVE_VALUE, MIN_POSITIVE_VALUE);

        // then
        assertThat(result).isEqualTo(MIN_POSITIVE_VALUE);
    }

    @Test
    public void getMinimumValueShouldReturnLargerNegativeValueWhenLargerNegativeValueIsComparedToSmallerPositiveValue() {
        // when
        final int result = exercise.getMinimumValue(MAX_NEGATIVE_VALUE, MIN_POSITIVE_VALUE);

        // then
        assertThat(result).isEqualTo(MAX_NEGATIVE_VALUE);
    }

    @Test
    public void getMinimumValueShouldReturnLargerNegativeValueWhenLargerNegativeValueIsComparedToSmallerNegativeValue() {
        // when
        final int result = exercise.getMinimumValue(MAX_NEGATIVE_VALUE, MIN_NEGATIVE_VALUE);

        // then
        assertThat(result).isEqualTo(MAX_NEGATIVE_VALUE);
    }

    @Test
    public void getMinimumValueShouldReturnSmallerPositiveValueWhenLargerPositiveValueIsComparedToSmallerPositiveValue() {
        // when
        final int result = exercise.getMinimumValue(MAX_POSITIVE_VALUE, MIN_POSITIVE_VALUE);

        // then
        assertThat(result).isEqualTo(MIN_POSITIVE_VALUE);
    }

    @Test
    public void getMinimumValueShouldReturnLargerNegativeValueWhenSmallerNegativeValueIsComparedToLargerNegativeValue() {
        // when
        final int result = exercise.getMinimumValue(MIN_NEGATIVE_VALUE, MAX_NEGATIVE_VALUE);

        // then
        assertThat(result).isEqualTo(MAX_NEGATIVE_VALUE);
    }

}