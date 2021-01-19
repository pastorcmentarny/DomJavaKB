package dms.pastor.examples.sorting;

/**
 * @author Dominik Symonowicz dms6@aber.ac.uk
 * @since 13.03'2009
 * @version 1.1
 * 
 * About convetion of  version.build
 * 		version-main change of program
 * 		build - minor changes and usually bug fixes
 */
public class InsertionSort implements Sorter {

	/* (non-Javadoc)
	 * @see sorting.Sorter#sort(java.lang.Comparable[])
	 */
	@Override
	public void sort(Comparable[] items) {
		InsertionSort( items);

	}


   public  void InsertionSort(Comparable[] c) {
       for(int i = 1; i < c.length; i++){
           int j = i;
           Comparable o = c[i];
           while((j > 0) && o.compareTo(c[j-1]) < 0){
               c[j] = c[j-1];
               j--;
           }
           c[j] = o;
       }
   }

	public static void main(String[] args) {
	    System.out.println("\n\nInsertionSort:\t test started ");
		InsertionSort is = new InsertionSort();
	    int i;
	    Comparable[] arr = new Comparable[20];
	    System.out.println("\nInsertionSort:\t Generating 20 random numbers: ");
	    for (i = 0; i < arr.length; i++) {
	        arr[i] = new Integer((int) (Math.random() * 99));
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