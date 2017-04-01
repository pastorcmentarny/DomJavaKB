package dms.pastor.tasks.exercises;

import dms.pastor.tasks.other.ArraysExercises;
import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;

/**
 * Author Dominik Symonowicz
 * Created 15/05/2015
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
public class ArraysExercisesTest {
    private static final int MIN_ANSWER = 4;
    private static final int MAX_ANSWER = 4096;
    private static final int[] numbers = new int[]{5, 6, 9, MAX_ANSWER, 1000, MIN_ANSWER, 2048};
    private final ArraysExercises exercise = new ArraysExercises();

    @Test
    public void testLargestAndSmallest() throws Exception {
        String answer = "Min:" + MIN_ANSWER + " Max:" + MAX_ANSWER;
        Assert.assertThat(exercise.findLargestAndSmallest(numbers), is(answer));
    }

    @Test
    public void shouldReplaceWithLargerNumber() throws Exception {
        Assert.assertThat(ArraysExercises.isMaximumValue(10, 12), is(12));
        Assert.assertThat(ArraysExercises.isMaximumValue(-2, 12), is(12));
        Assert.assertThat(ArraysExercises.isMaximumValue(-10, -2), is(-2));

    }

    @Test
    public void shouldNotReplaceWithNotLargerNumber() throws Exception {
        Assert.assertThat(ArraysExercises.isMaximumValue(12, 10), is(12));
        Assert.assertThat(ArraysExercises.isMaximumValue(12, -2), is(12));
        Assert.assertThat(ArraysExercises.isMaximumValue(-2, -10), is(-2));
    }

    @Test
    public void shouldReplaceWithSmallerNumber() throws Exception {
        Assert.assertThat(exercise.isMinimumValue(12, 10), is(10));
        Assert.assertThat(exercise.isMinimumValue(-10, 10), is(-10));
        Assert.assertThat(exercise.isMinimumValue(-12, -10), is(-12));
    }

    @Test
    public void shouldNotReplaceWithNotSmallerNumber() throws Exception {
        Assert.assertThat(exercise.isMinimumValue(12, 10), is(10));
        Assert.assertThat(exercise.isMinimumValue(-10, -12), is(-12));
    }


}