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
public class MergeSort implements Sorter {

	/* (non-Javadoc)
	 * @see sorting.Sorter#sort(java.lang.Comparable[])
	 */
	public void sort(Comparable[] items) {
		Comparable[] temp = new Comparable[items.length];
		mergeSort(items,temp,0,items.length-1);
	}


	private void mergeSort(Comparable[] a, Comparable[] temp,
						  int left, int right )
	{
		// terminating condition for recursion.
		if (left < right)
		{
			int center = (left+right)/2;
			mergeSort(a,temp,left,center);
			mergeSort(a,temp,center+1,right);
			merge(a,temp,left,center+1,right);
		}
	}
	
	private void merge(Comparable[] a, Comparable[] temp,
					  int left,int center,int right)
	{
		int aptr=left;
		int bptr=center;
		int cptr=0;
		while (aptr<center || bptr<=right)
		{	
			if (aptr>=center && bptr <=right)
			{
				// we've finished all of the left side
				// so take an element from the right.
				temp[cptr]=a[bptr++];
			} else if (bptr>right && aptr <= center) {
				// we've finished all of the right side
				// so take an element from the left.
				temp[cptr]=a[aptr++];
			} else {
				// we need to take the smallest element
				// from the left or right and put it in
				// the temp scratch space.
				if (a[aptr].compareTo(a[bptr])<0)
				{
					temp[cptr]=a[aptr];
					aptr++;
				} else {
					temp[cptr]=a[bptr];
					bptr++;
				}
			}
			// we've put something in temp (scratch space) 
			// increment the counter to move on.
			cptr++;
		}

		// copy everything from the scratch space back into
		// the main array
		for (int i=left; i<=right; i++)
		{
			a[i]=temp[i-left];
		}
	}
	
	
	private void debugPrint(Comparable[]a,int left, int right)
	{
		for (int i=left; i<=right; i++)
		{
			System.out.print(a[i]+" ");
		}
		System.out.println();
	}
}