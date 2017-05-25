package dms.pastor.tasks.exercises;

import dms.pastor.tasks.other.ArraysExercises;
import org.junit.Test;

import static dms.pastor.tasks.other.ArraysExercises.isMaximumValue;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author Dominik Symonowicz
 * Created 15/05/2015
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 *
 * //TODO split into separated tests
 */
public class ArraysExercisesTest {

    private static final int MIN_POSITIVE_VALUE = 4;
    private static final int MAX_POSITIVE_VALUE = 4096;
    private static final int[] numbers = new int[]{5, 6, 9, MAX_POSITIVE_VALUE, 1000, MIN_POSITIVE_VALUE, 2048};
    private static final int MIN_NEGATIVE_VALUE = -2;
    private static final int MAX_NEGATIVE_VALUE = -10;
    private final ArraysExercises exercise = new ArraysExercises();

    @Test
    public void testLargestAndSmallest() throws Exception {
        String answer = "Min:" + MIN_POSITIVE_VALUE + " Max:" + MAX_POSITIVE_VALUE;
        assertThat(exercise.findLargestAndSmallest(numbers)).isEqualTo(answer);
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

        assertThat(isMaximumValue(MIN_POSITIVE_VALUE, MAX_POSITIVE_VALUE)).isEqualTo(MAX_POSITIVE_VALUE);
        assertThat(isMaximumValue(MIN_NEGATIVE_VALUE, MAX_POSITIVE_VALUE)).isEqualTo(MAX_POSITIVE_VALUE);
        assertThat(isMaximumValue(MAX_NEGATIVE_VALUE, MIN_NEGATIVE_VALUE)).isEqualTo(MIN_NEGATIVE_VALUE);

    }

    @Test
    public void shouldNotReplaceWithNotLargerNumber() throws Exception {
        assertThat(isMaximumValue(MAX_POSITIVE_VALUE, MIN_POSITIVE_VALUE)).isEqualTo(MAX_POSITIVE_VALUE);
        assertThat(isMaximumValue(MAX_POSITIVE_VALUE, MIN_NEGATIVE_VALUE)).isEqualTo(MAX_POSITIVE_VALUE);
        assertThat(isMaximumValue(MIN_NEGATIVE_VALUE, MAX_NEGATIVE_VALUE)).isEqualTo(MIN_NEGATIVE_VALUE);
    }

    @Test
    public void shouldReplaceWithSmallerNumber() throws Exception {
        assertThat(exercise.isMinimumValue(MAX_POSITIVE_VALUE, MIN_POSITIVE_VALUE)).isEqualTo(MIN_POSITIVE_VALUE);
        assertThat(exercise.isMinimumValue(MAX_NEGATIVE_VALUE, MIN_POSITIVE_VALUE)).isEqualTo(MAX_NEGATIVE_VALUE);
        assertThat(exercise.isMinimumValue(MAX_NEGATIVE_VALUE, MIN_NEGATIVE_VALUE)).isEqualTo(MAX_NEGATIVE_VALUE);
    }

    @Test
    public void shouldNotReplaceWithNotSmallerNumber() throws Exception {
        assertThat(exercise.isMinimumValue(MAX_POSITIVE_VALUE, MIN_POSITIVE_VALUE)).isEqualTo(MIN_POSITIVE_VALUE);
        assertThat(exercise.isMinimumValue(MIN_NEGATIVE_VALUE, MAX_NEGATIVE_VALUE)).isEqualTo(MAX_NEGATIVE_VALUE);
    }


}