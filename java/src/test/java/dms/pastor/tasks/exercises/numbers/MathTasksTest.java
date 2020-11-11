package dms.pastor.tasks.exercises.numbers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static dms.pastor.utils.PrintOutUtils.printIntArray;
import static org.assertj.core.api.Assertions.assertThat;

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

    @BeforeEach
    public void setUp() {
        tasks = new MathTasks();
    }


    @Test
    public void testRemoveRandomNumberFromArray() {
        int[] numbers = new int[]{1, 2, 3, 4, 5};
        int[] numbersWithoutNumber2 = tasks.removeRandomNumberFromArray(numbers);
        printIntArray(numbers);
        printIntArray(numbersWithoutNumber2);
        assertThat(numbers.length - numbersWithoutNumber2.length).isEqualTo(1);
    }

    @Test
    public void testFindMissingNumberInArrayWithoutDuplicates() {
        int[] numbers = new int[]{1, 2, 3, 4, 5};
        int[] numbersWithoutNumber2 = new int[]{1, 3, 4, 5};
        assertThat(tasks.findMissingNumberInArrayWithoutDuplicates(numbers, numbersWithoutNumber2)).isEqualTo(2);
    }
}
