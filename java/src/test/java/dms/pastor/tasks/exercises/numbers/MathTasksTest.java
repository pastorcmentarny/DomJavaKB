package dms.pastor.tasks.exercises.numbers;

import dms.pastor.utils.NumberUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.stream.IntStream;

import static dms.pastor.utils.PrintOutUtils.printIntArray;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.number.OrderingComparison.greaterThan;

/**
 * Author Dominik Symonowicz
 * Created 2014-08-09
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class MathTasksTest {

    private MathTasks tasks;

    @Before
    public void setUp() {
        tasks = new MathTasks();
    }

    //TODO (It passed task acceptance requirement but it is a stupid test, I should improve it.
    @Ignore
    @Test //flaky test?
    public void smokeTest() {
        int[] allItems = IntStream.range(0, 10).toArray();
        int[] itemsWithoutOneRandomNumber = tasks.removeRandomNumberFromArray(allItems);
        printIntArray(allItems);
        printIntArray(itemsWithoutOneRandomNumber);
        Assert.assertThat(allItems.length - itemsWithoutOneRandomNumber.length, is(1));
        int totalAll = NumberUtils.calcTotal(allItems);
        int almostAll = NumberUtils.calcTotal(itemsWithoutOneRandomNumber);
        Assert.assertThat(totalAll - almostAll, greaterThan(0));
    }

    @Test
    public void testRemoveRandomNumberFromArray() {
        int[] numbers = new int[]{1, 2, 3, 4, 5};
        int[] numbersWithoutNumber2 = tasks.removeRandomNumberFromArray(numbers);
        printIntArray(numbers);
        printIntArray(numbersWithoutNumber2);
        Assert.assertThat(numbers.length - numbersWithoutNumber2.length, is(1));
    }

    @Test
    public void testFindMissingNumberInArrayWithoutDuplicates() {
        int[] numbers = new int[]{1, 2, 3, 4, 5};
        int[] numbersWithoutNumber2 = new int[]{1, 3, 4, 5};
        assertThat(tasks.findMissingNumberInArrayWithoutDuplicates(numbers, numbersWithoutNumber2)).isEqualTo(2);
    }
}