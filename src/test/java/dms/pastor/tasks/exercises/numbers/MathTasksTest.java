package dms.pastor.tasks.exercises.numbers;

import dms.pastor.utils.NumberUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static dms.pastor.utils.PrintOutUtils.printIntArray;
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
    public void setUp() throws Exception {
        tasks = new MathTasks();
    }

    //TODO (It passed task acceptance requirement but it is a stupid test, I should improve it.
    @Test
    public void smokeTest() {
        int[] allItems = NumberUtils.generateNaturalSequenceIntArray(10);
        int[] itemsWithoutOneRandomNumber = tasks.removeRandomNumberFromArray(allItems);
        printIntArray(allItems);
        printIntArray(itemsWithoutOneRandomNumber);
        Assert.assertThat(allItems.length - itemsWithoutOneRandomNumber.length, is(1));
        int totalAll = NumberUtils.calcTotal(allItems);
        int almostAll = NumberUtils.calcTotal(itemsWithoutOneRandomNumber);
        Assert.assertThat(totalAll - almostAll, greaterThan(0));
    }

    @Test
    public void testRemoveRandomNumberFromArray() throws Exception {
        int[] numbers = new int[]{1, 2, 3, 4, 5};
        int[] numbersWithoutNumber2 = tasks.removeRandomNumberFromArray(numbers);
        printIntArray(numbers);
        printIntArray(numbersWithoutNumber2);
        Assert.assertThat(numbers.length - numbersWithoutNumber2.length, is(1));
    }

    @Test
    public void testFindMissingNumberInArrayWithoutDuplicates() throws Exception {
        int[] numbers = new int[]{1, 2, 3, 4, 5};
        int[] numbersWithoutNumber2 = new int[]{1, 3, 4, 5};
        Assert.assertThat(tasks.findMissingNumberInArrayWithoutDuplicates(NumberUtils.calcTotal(numbers), NumberUtils.calcTotal(numbersWithoutNumber2)), is(2));
    }
}
