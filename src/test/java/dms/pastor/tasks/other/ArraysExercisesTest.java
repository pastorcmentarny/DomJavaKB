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
 * <p>
 * //TODO split into separated tests
 */
public class ArraysExercisesTest {

    private static final int MIN_POSITIVE_VALUE = 4;
    private static final int MAX_POSITIVE_VALUE = 4096;
    private static final int[] NUMBERS = new int[]{5, 6, 9, MAX_POSITIVE_VALUE, 1000, MIN_POSITIVE_VALUE, 2048};
    private static final int MIN_NEGATIVE_VALUE = -2;
    private static final int MAX_NEGATIVE_VALUE = -10;
    private final ArraysExercises exercise = new ArraysExercises();

    @Test
    public void testLargestAndSmallest() throws Exception {
        String answer = "Min:" + MIN_POSITIVE_VALUE + " Max:" + MAX_POSITIVE_VALUE;
        assertThat(exercise.findLargestAndSmallest(NUMBERS)).isEqualTo(answer);
    }

    @Test
    public void findLargestAndSmallestShouldReturnTheSameNumberIfArrayContainsOneNumber() throws Exception {
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
    public void shouldReplaceWithLargerNumber() throws Exception {

        assertThat(exercise.getMaximumValue(MIN_POSITIVE_VALUE, MAX_POSITIVE_VALUE)).isEqualTo(MAX_POSITIVE_VALUE);
        assertThat(exercise.getMaximumValue(MIN_NEGATIVE_VALUE, MAX_POSITIVE_VALUE)).isEqualTo(MAX_POSITIVE_VALUE);
        assertThat(exercise.getMaximumValue(MAX_NEGATIVE_VALUE, MIN_NEGATIVE_VALUE)).isEqualTo(MIN_NEGATIVE_VALUE);

    }

    @Test
    public void shouldNotReplaceWithNotLargerNumber() throws Exception {
        assertThat(exercise.getMaximumValue(MAX_POSITIVE_VALUE, MIN_POSITIVE_VALUE)).isEqualTo(MAX_POSITIVE_VALUE);
        assertThat(exercise.getMaximumValue(MAX_POSITIVE_VALUE, MIN_NEGATIVE_VALUE)).isEqualTo(MAX_POSITIVE_VALUE);
        assertThat(exercise.getMaximumValue(MIN_NEGATIVE_VALUE, MAX_NEGATIVE_VALUE)).isEqualTo(MIN_NEGATIVE_VALUE);
    }

    @Test
    public void shouldReplaceWithSmallerNumber() throws Exception {
        assertThat(exercise.getMinimumValue(MAX_POSITIVE_VALUE, MIN_POSITIVE_VALUE)).isEqualTo(MIN_POSITIVE_VALUE);
        assertThat(exercise.getMinimumValue(MAX_NEGATIVE_VALUE, MIN_POSITIVE_VALUE)).isEqualTo(MAX_NEGATIVE_VALUE);
        assertThat(exercise.getMinimumValue(MAX_NEGATIVE_VALUE, MIN_NEGATIVE_VALUE)).isEqualTo(MAX_NEGATIVE_VALUE);
    }

    @Test
    public void shouldNotReplaceWithNotSmallerNumber() throws Exception {
        assertThat(exercise.getMinimumValue(MAX_POSITIVE_VALUE, MIN_POSITIVE_VALUE)).isEqualTo(MIN_POSITIVE_VALUE);
        assertThat(exercise.getMinimumValue(MIN_NEGATIVE_VALUE, MAX_NEGATIVE_VALUE)).isEqualTo(MAX_NEGATIVE_VALUE);
    }

}