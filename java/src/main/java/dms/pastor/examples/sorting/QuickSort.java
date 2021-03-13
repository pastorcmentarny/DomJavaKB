package dms.pastor.examples.sorting;

/*
  @author Dominik Symonowicz dms6@aber.ac.uk
 * @since 13.03'2009
 * @version 1.42
 * 
 * About convetion of  version.build
 * 		version-main change of program
 * 		build - minor changes and usually bug fixes

 * This is classic Quick sort implementation without optimization
 * 
 * Quick sort was developed by Sir Charles Anthony
 * Richard Hoare in 1962. Its one of comparison
 * sorting algorithm which uses divide and conquer
 * strategy using Partitioning method. Quick Sort
 * characterize very good performance for o best
 * and average cases: O(n log n) but unfortunately
 * in worse case performance is degraded to o(n2).it
 * is unstable sort as well.
 */
public class QuickSort implements Sorter {

    /*
     * (non-Javadoc)
     *
     * @see sorting.Sorter#sort(java.lang.Comparable[])
     */
    @Override
    public void sort(Comparable[] c) {
        sort(c, 0, c.length - 1);
    }

    public void sort(Comparable[] c, int start, int end) {
        if (end <= start) {
            return;
        }
        Comparable comp = c[start];
        int i = start, j = end + 1;
        for (; ; ) {
            do {
                i++;
            } while (i < end && c[i].compareTo(comp) < 0);
            do {
                j--;
            } while (j > start && c[j].compareTo(comp) > 0);
            if (j <= i) {
                break;
            }
            Comparable tmp = c[i];
            c[i] = c[j];
            c[j] = tmp;
        }
        c[start] = c[j];
        c[j] = comp;
        sort(c, start, j - 1);
        sort(c, j + 1, end);
    }

    /**
     * Below method is used for testing QuickSort
     * Generate randomly 20 numbers and sort.After result you can see is quick sort working
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("\n\nQuickSort:\t test started ");
        QuickSort qs = new QuickSort();
        int i;
        Comparable[] arr = new Comparable[20];
        System.out.println("\nQuickSort:\t Generating 20 random numbers: ");
        for (i = 0; i < arr.length; i++) {
            arr[i] = Integer.valueOf((int) (Math.random() * 99));
            System.out.print(arr[i] + " ");
        }
        qs.sort(arr, 0, 19);
        System.out.println("\nQuickSort:\t numbers after sorting: ");
        for (i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("\nQuickSort:\t End of test");
    }

}
