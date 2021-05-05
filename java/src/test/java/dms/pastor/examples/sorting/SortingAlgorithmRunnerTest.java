package dms.pastor.examples.sorting;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SortingAlgorithmRunnerTest {

    private static final int REPEAT_TEST_COUNT = 6; //5

    /**
     * Below is few methods for testing purpose only
     * About test
     * 1.create 20 random numbers
     * 2.display on screen these numbers
     * 3.perform sorting
     * 4.display result
     * <p>
     * About test methods
     * They are few test methods
     * 1) test all sorts made by Dominik Symonowicz
     * 2) test quick sort
     * 3) test optimised QuickSort
     * 4) test InsertionSort
     */
    @Test
    public void runAlgorithmsAcceptanceTest() {
        SortingAlgorithmRunner letsFunBegin = new SortingAlgorithmRunner();

        StringBuilder stringBuilder = new StringBuilder("");
        for (int test10 = 1; test10 < REPEAT_TEST_COUNT; test10++) {
            System.out.println(test10 + "\n");
            stringBuilder.append(letsFunBegin.testEverything());
        }
        assertThat(stringBuilder.toString()).isNotBlank();
    }

    @Test
    public void runQuickSortAcceptanceTest() {
        System.out.println("Info:\n\tTask: Selftest:\n\tSort: QuickSort");
        System.out.println("\tData:  20 numbers [autogenerate,random numbers]");
        QuickSort.main(null);
    }

    @Test
    public void runInsertionSortAcceptanceTest() {
        System.out.println("Info:\n\tTask: Selftest:\n\tSort: InsertionSort");
        System.out.println("\tData:  20 numbers [autogenerate,random numbers]");
        InsertionSort.main(null);
    }
}