/*
 * Created on Nov 28, 2003
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package dms.pastor.examples.sorting;

import java.io.*;
import java.util.Calendar;

/**
 * @author rcs
 * <p>
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class SortDemo {

    public Comparable[] readData(String fileName) {
        Comparable[] items;
        File file = new File(fileName);
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(
                    new FileReader(file));
        } catch (FileNotFoundException e) {
            System.out.println("File not found " + fileName);
            System.exit(0);
        }
        boolean eof = false;
        String inLine;
        int numLines = 0;
        while (!eof) {
            try {
                inLine = reader.readLine();
                if (inLine == null) {
                    eof = true;
                } else {
                    numLines++;
                }
            } catch (IOException exception) {
                System.out.println(exception.getMessage());
            }
        }
        try {
            reader.close();
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }

        items = new Comparable[numLines];

        try {
            reader = new BufferedReader(
                    new FileReader(file));
        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println("File not found " + fileName);
            System.exit(0);
        }
        eof = false;
        numLines = 0;
        while (!eof) {
            try {
                inLine = reader.readLine();
                if (inLine == null) {
                    eof = true;
                } else {
                    items[numLines] = inLine;
                    numLines++;
                }
            } catch (IOException exception) {
                System.out.println(exception.getMessage());
            }
        }
        try {
            reader.close();
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }

        return items;
    }

    public long testOne(String type, Comparable[] items) {
        long start;
        long finish;
        long timeTaken = 0;
        Sorter s = SortFactory.getSorter(type);
        if (s != null) {
            start = Calendar.getInstance().getTimeInMillis();
            s.sort(items);
            finish = Calendar.getInstance().getTimeInMillis();
            timeTaken = finish - start;
        }
        return timeTaken;
    }

    public void printSortedArray(Comparable[] items) {
        for (int i = 0; i < items.length; i++) {
            System.out.println(items[i]);
        }
    }

    public String testAll(String filename) {
        String[] sortTypes = {"MergeSort", "QuickSort"
                , "SelectionSort", "BubbleSort"};
        long[] timeTaken = new long[sortTypes.length];
        StringBuilder retLine = new StringBuilder();
        for (int i = 0; i < sortTypes.length; i++) {
            Comparable[] items = this.readData(filename);
            if (items.length > 10000 && i > 1) break;
            timeTaken[i] =
                    this.testOne("sorting." + sortTypes[i], items);
            retLine.append(sortTypes[i] + "\t" + timeTaken[i] + "\n");
        }
        return retLine.toString();
    }

    public String testEverything() {
        String[] filenames = {
                "test2.dat", "test3.dat",
//							  "test3a.dat","test3b.dat",
                "test4.dat",
//							  "test4a.dat",
//							  "test4b.dat",
//							  "test5.dat",
//							  "test5a.dat",
//							  "test5b.dat",
//							  "test6.dat",
//							  "test6a.dat",
//							  "test6b.dat",
//							  "test7.dat"
        };
        String[] sortTypes = {
                "MergeSort",
                "QuickSort",
                "InsertionSort",
//		                      "OptimisedQuickSort",
                "TreeSort",
//							 "SelectionSort","BubbleSort"
        };
        long timeTaken;
        StringBuffer retLine = new StringBuffer();
        for (int i = 0; i < sortTypes.length; i++) {
            retLine.append(sortTypes[i]);
            for (int j = 0; j < filenames.length; j++) {

                Comparable[] items = this.readData(filenames[j]);
//				if (items.length>10000 && i>3) break;
//				if (items.length>100000 && i>2) break;
                timeTaken =
                        this.testOne("sorting." + sortTypes[i], items);
                retLine.append(",").append(timeTaken);
            }
            retLine.append("\n");
        }
        return retLine.toString();

    }

    public static void main(String[] args) {
        SortDemo sd = new SortDemo();
//		Comparable[] items=sd.readData("test2.dat");
//		sd.testOne("sorting.RadixSort",items);
//		sd.printSortedArray(items);
//		System.out.println(sd.testAll("test6.dat"));
        System.out.println(sd.testEverything());
    }
}
