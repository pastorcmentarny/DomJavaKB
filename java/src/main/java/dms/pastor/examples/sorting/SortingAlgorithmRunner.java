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

        private static final String base = "B:\\GitHub\\DomJavaKB\\java\\src\\main\\resources\\sorting\\";
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
                "test6b.dat"

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

                Comparable<Integer>[] items = this.readData(base + filename);
                timeTaken =
                        this.testOne("sorting." + sortType, items);
                retLine.append(",").append(timeTaken);
            }
            retLine.append("\n");
        }
        return retLine.toString();

    }


}
