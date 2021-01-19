package dms.pastor.examples.sorting;

public class BubbleSort implements Sorter {


	public void sort(Comparable[] items) {
		Comparable temp;
		for (int i=0; i<items.length-1; i++)
		{
			for (int j=0; j<items.length-1-i; j++)
			{
				if (items[j].compareTo(items[j+1])<0)
				{
					temp=items[j+1];
					items[j+1]=items[j];
					items[j]=temp;
				}
			}
		}
	}
}
