/*
 * Created on Nov 29, 2003
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package dms.pastor.examples.sorting;
import treeStructures.*;

/**
 * @author rcs
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class TreeSort implements Sorter {

	/* (non-Javadoc)
	 * @see sorting.Sorter#sort(java.lang.Comparable[])
	 */
	public void sort(Comparable[] items) {
		BinarySearchTree tree = new BinarySearchTree();
		for (int i=0;i<items.length;i++)
		{
			tree.insert(items[i]);
		}
		tree.inOrderTraverse(items);
	}

}
