/*
 * Created on Nov 28, 2003
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package dms.pastor.examples.sorting;

/**
 * @author rcs
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class SelectionSort implements Sorter {

	/* (non-Javadoc)
	 * @see sorting.Sorter#sort(java.lang.Comparable[])
	 */
	public void sort(Comparable[] items) {
		int biggest;
		Comparable temp;
		for (int i=items.length-1; i>=0 ;i--)
		{
			biggest=0;
			for (int j=0; j<=i; j++)
			{
				if (items[biggest].compareTo(items[j])<0)
				{
					biggest=j;
				}
			}
			
			if (biggest!=i)
			{
				temp=items[i];
				items[i]=items[biggest];
				items[biggest]=temp;
			}
		}
	}
}
