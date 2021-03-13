package dms.pastor.examples.sorting;

/*
  @author Dominik Symonowicz dms6@aber.ac.uk
 * @since 13.03'2009
 * @version 3.211
 * 
 * About convetion of  version.build
 * 		version-main change of program
 * 		build - minor changes and usually bug fixes
 */

/**
 * This is Optimized Quick Sort
 * where i used pivot,median and insert sort as inner sort
 */
public class OptimisedQuickSort implements Sorter {
    private int varyvalue;

    /*
     * (non-Javadoc)
     *
     * @see sorting.Sorter#sort(java.lang.Comparable[])
     */
    public void sort(Comparable[] c) {
        quicksort(c, 0, c.length - 1);
    }

    /**
     * main method of quicksort  (recursive version) with inner sort.
     * By default quicksort using Insertion sort as inner sort but you can use Selection sort
     * Simply uncomment innerSS() method (and switch off Insert sort by comment innerIS() method
     *
     * @param c     an array of object
     * @param start first element
     * @param end   last element
     */
    private void quicksort(Comparable[] c, int start, int end) {
        varyvalue = setVV(c);

        if (start + varyvalue > end)

            innerIS(c, start, end);
//	   	   innerSS( c, start, end );
        else {
            int median = (start + end) / 2;
            doMedian(c, start, median, varyvalue);
            swap(c, median, end - 1);
            Comparable pvt = c[end - 1];

            int i, j;
            for (i = start, j = end - 1; ; ) {
                while (c[++i].compareTo(pvt) < 0) ;
                while (pvt.compareTo(c[--j]) < 0) ;
                if (i >= j)
                    break;
                swap(c, i, j);
            }

            swap(c, i, end - 1);

            quicksort(c, start, i - 1);    // Sort small elements
            quicksort(c, i + 1, end);   // Sort large elements
        }
    }

    /**
     * swap method i used to swap 2 elements in an array.
     *
     * @param o an array of objects.
     * @param i the index of object[i].
     * @param j the index of object[j].
     */
    public static final void swap(Object[] o, int i, int j) {
        Object tmp = o[i];
        o[i] = o[j];
        o[j] = tmp;
    }

    /**
     * setVV method i used for set varyvalue .
     */
    public int setVV(Comparable[] c) {
        if (c.length >= 50000) {
            return 15;
        } else if (c.length >= 2000) {
            return 10;
        } else {
            return 5;
        }
    }

    /**
     * doMedian method i used for perform median process.
     */
    public void doMedian(Comparable[] c, int start, int median, int end) {
        if (c[end].compareTo(c[start]) < 0)
            swap(c, start, end);
        if (c[end].compareTo(c[median]) < 0)
            swap(c, median, end);
        if (c[median].compareTo(c[start]) < 0)
            swap(c, start, median);

    }

    /**
     * this is Insertion sort as inner sort for quick sort
     *
     * @param c     an array of object
     * @param start first element
     * @param end   last element
     */
    private static void innerIS(Comparable[] c, int start, int end) {
        for (int i = start + 1; i <= end; i++) {
            int j = i;
            Comparable o = c[i];
            while ((j > 0) && o.compareTo(c[j - 1]) < 0) {
                c[j] = c[j - 1];
                j--;
            }
            c[j] = o;
        }
    }

    /**
     * this is Selection sort as inner sort for quick sort
     *
     * @param c     an array of object
     * @param start first element
     * @param end   last element
     * @author Richard Shipman
     */
    private static void innerSS(Comparable[] c, int start, int end) {
        int biggest;
        Comparable temp;
        for (int i = c.length - 1; i >= 0; i--) {
            biggest = 0;
            for (int j = 0; j <= i; j++) {
                if (c[biggest].compareTo(c[j]) < 0) {
                    biggest = j;
                }
            }

            if (biggest != i) {
                temp = c[i];
                c[i] = c[biggest];
                c[biggest] = temp;
            }
        }
    }

    /**
     * Below method is used for testing Optimized QuickSort
     * Generate randomly 20 numbers and sort.After result you can see is quick sort working
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("\n\nOptimized QuickSort:\t test started ");
        QuickSort qs = new QuickSort();
        int i;
        Comparable[] arr = new Comparable[20];
        System.out.println("\nOptimized QuickSort:\t Generating 20 random numbers: ");
        for (i = 0; i < arr.length; i++) {
            arr[i] = Integer.valueOf((int) (Math.random() * 99));
            System.out.print(arr[i] + " ");
        }
        qs.sort(arr, 0, 19);
        System.out.println("\nOptimized QuickSort:\t numbers after sorting: ");
        for (i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("\nOptimized QuickSort:\t End of test");
    }
}