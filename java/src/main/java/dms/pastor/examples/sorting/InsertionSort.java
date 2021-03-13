package dms.pastor.examples.sorting;

/**
 * @author Dominik Symonowicz dms6@aber.ac.uk
 * @version 1.1
 * <p>
 * About convetion of  version.build
 * version-main change of program
 * build - minor changes and usually bug fixes
 * @since 13.03'2009
 */
public class InsertionSort implements Sorter {

    /* (non-Javadoc)
     * @see sorting.Sorter#sort(java.lang.Comparable<Integer>[])
     */
    @Override
    public void sort(Comparable<Integer>[] items) {
        insertionSort(items);

    }


    public void insertionSort(Comparable<Integer>[] c) {
        for (int i = 1; i < c.length; i++) {
            int j = i;
            Comparable<Integer> o = c[i];
            while ((j > 0) && o.compareTo((Integer) c[j - 1]) < 0) {
                c[j] = c[j - 1];
                j--;
            }
            c[j] = o;
        }
    }

    public static void main(String[] args) {
        System.out.println("\n\nInsertionSort:\t test started ");
        InsertionSort is = new InsertionSort();
        int i;
        Comparable<Integer>[] arr = new Comparable[20];
        System.out.println("\nInsertionSort:\t Generating 20 random numbers: ");
        for (i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 99);
            System.out.print(arr[i] + " ");
        }
        is.sort(arr);
        System.out.println("\nInsertionSort:\t numbers after sorting: ");
        for (i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("\nInsertionSort:\t End of test");
    }

}