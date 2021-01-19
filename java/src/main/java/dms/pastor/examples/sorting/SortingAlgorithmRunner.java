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
 * @author Dominik Symonowicz
 * 2008 assignment
 */
public class SortingAlgorithmRunner {

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
        String inLine = null;
        int numLines = 0;
        while (!eof) {
            try {
                inLine = reader.readLine();
                if (inLine == null) {
                    eof = true;
                } else {
                    numLines++;
                }
            } catch (IOException e) {
            }
        }
        try {
            reader.close();
        } catch (IOException e) {
        }

        items = new Comparable[numLines];

        try {
            reader = new BufferedReader(
                    new FileReader(file));
        } catch (FileNotFoundException e) {
            System.out.println("File not found " + fileName);
            System.exit(0);
        }
        eof = false;
        inLine = null;
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
            } catch (IOException e) {
            }
        }
        try {
            reader.close();
        } catch (IOException e) {
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
        String sortTypes[] = {"MergeSort", "QuickSort"
                , "SelectionSort", "BubbleSort"};
        long timeTaken[] = new long[sortTypes.length];
        StringBuffer retLine = new StringBuffer();
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
        String filenames[] = {
//								"test2.dat","test3.dat",
//							  "test3a.dat","test3b.dat",
//							  "test4.dat",
//							  "test4a.dat",
//							  "test4b.dat",
                "test5.dat",
                "test5a.dat",
                "test5b.dat",
//							  "test6.dat",
//							  "test6a.dat",
//							  "test6b.dat",
//							  "test7.dat"
        };
        String sortTypes[] = {
                "QuickestSort",
//							 "MergeSort",
                "QuickSort",
//							 "InsertionSort",
                "OptimisedQuickSort",
//							 "TreeSort",		
//							 "SelectionSort",
//							 "BubbleSort"
        };
        long timeTaken = 99999999;
        StringBuffer retLine = new StringBuffer();
        for (int i = 0; i < sortTypes.length; i++) {
            retLine.append(sortTypes[i]);
            for (int j = 0; j < filenames.length; j++) {

                Comparable[] items = this.readData(filenames[j]);
//				if (items.length>10000 && i>3) break;
//				if (items.length>100000 && i>2) break;
                timeTaken =
                        this.testOne("sorting." + sortTypes[i], items);
                retLine.append("," + timeTaken);
            }
            retLine.append("\n");
        }
        return retLine.toString();

    }

    public static void main(String[] args) {
        SortingAlgorithmRunner letsFunBegin = new SortingAlgorithmRunner();
        //Complete set of tests
        System.out.println("Info:\n\tTask:Completle set of sortings");
        System.out.println("\n\tSort: BubbleSort,InsertionSort,MergeSort,QuickSort,TreeSort,OptimisedQuickSort\n\n");
        for (int test10 = 1; test10 < 11; test10++) {
            System.out.println(test10 + "\n");
            System.out.println(letsFunBegin.testEverything());
        }

        /**
         * Below is few methods for testing purpose only
         * About test
         *  1.create 20 random numbers
         *  2.display on screen these numbers
         *  3.perform sorting
         *  4.display result
         *
         * About test methods
         * They are few test methods
         * 	1) test all sorts made by Dominik Symonowicz
         * 	2) test quick sort
         * 	3) test optimised QuickSort
         * 	4) test InsertionSort
         *
         */


        QuickSort adsQS = new QuickSort();
        adsQS.main(args);
        OptimisedQuickSort adsOQS = new OptimisedQuickSort();
        adsOQS.main(args);
        InsertionSort adsIS = new InsertionSort();
        adsIS.main(args);

        //QuickSort self test
        System.out.println("Info:\n\tTask: Selftest:\n\tSort: QuickSort");
        System.out.println("\tData:  20 numbers [autogenerate,random numbers]");
        QuickSort testQS = new QuickSort();
        testQS.main(args);

        //OptimisedQuickSort self test
        System.out.println("Info:\n\tTask: Selftest:\n\tSort: Optimized QuickSort");
        System.out.println("\tData:  20 numbers [autogenerate,random numbers]");
        OptimisedQuickSort testOQS = new OptimisedQuickSort();
        testOQS.main(args);

        //InsertionSort self test
        System.out.println("Info:\n\tTask: Selftest:\n\tSort: InsertionSort");
        System.out.println("\tData:  20 numbers [autogenerate,random numbers]");
        InsertionSort testIS = new InsertionSort();
        testIS.main(args);
    }
}
