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

    public Comparable<Integer>[] readData(String fileName) {
        Comparable<Integer>[] items;
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
                    items[numLines] = Integer.valueOf(inLine);
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

    public long testOne(String type, Comparable<Integer>[] items) {
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

    public void printSortedArray(Comparable<Integer>[] items) {
        for (Comparable<Integer> item : items) {
            System.out.println(item);
        }
    }

    public String testAll(String filename) {
        String[] sortTypes = {"MergeSort", "QuickSort"
                , "SelectionSort", "BubbleSort"};
        long[] timeTaken = new long[sortTypes.length];
        StringBuilder retLine = new StringBuilder();
        for (int i = 0; i < sortTypes.length; i++) {
            Comparable<Integer>[] items = this.readData(filename);
            if (items.length > 10000 && i > 1) break;
            timeTaken[i] =
                    this.testOne("sorting." + sortTypes[i], items);
            retLine.append(sortTypes[i]).append("\t").append(timeTaken[i]).append("\n");
        }
        return retLine.toString();
    }

    public String testEverything() {
        String[] filenames = {
                "test2.dat", "test3.dat",
                "test3a.dat", "test3b.dat",
                "test4.dat",
                "test4a.dat",
                "test4b.dat",
                "test5.dat",
                "test5a.dat",
                "test5b.dat",
                "test6.dat",
                "test6a.dat",
                "test6b.dat",
                "test7.dat"
        };
        String[] sortTypes = {
                "QuickestSort",
                "MergeSort",
                "QuickSort",
                "InsertionSort",
                "OptimisedQuickSort",
                "TreeSort",
                "SelectionSort",
                "BubbleSort"
        };
        long timeTaken;
        StringBuilder retLine = new StringBuilder();
        for (String sortType : sortTypes) {
            retLine.append(sortType);
            for (String filename : filenames) {

                Comparable<Integer>[] items = this.readData(filename);
                timeTaken =
                        this.testOne("sorting." + sortType, items);
                retLine.append(",").append(timeTaken);
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

        /*
          Below is few methods for testing purpose only
          About test
           1.create 20 random numbers
           2.display on screen these numbers
           3.perform sorting
           4.display result

          About test methods
          They are few test methods
          	1) test all sorts made by Dominik Symonowicz
          	2) test quick sort
          	3) test optimised QuickSort
          	4) test InsertionSort

         */


        QuickSort adsQS = new QuickSort();
        QuickSort.main(args);
        InsertionSort adsIS = new InsertionSort();
        InsertionSort.main(args);


        System.out.println("Info:\n\tTask: Selftest:\n\tSort: QuickSort");
        System.out.println("\tData:  20 numbers [autogenerate,random numbers]");
        QuickSort testQS = new QuickSort();
        QuickSort.main(args);


        System.out.println("Info:\n\tTask: Selftest:\n\tSort: InsertionSort");
        System.out.println("\tData:  20 numbers [autogenerate,random numbers]");
        InsertionSort testIS = new InsertionSort();
        InsertionSort.main(args);
    }
}
