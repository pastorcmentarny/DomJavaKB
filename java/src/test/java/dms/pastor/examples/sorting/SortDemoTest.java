package dms.pastor.examples.sorting;

import org.junit.jupiter.api.Test;

class SortDemoTest {
    //FIXME move to config
    private static final String base = "B:\\GitHub\\DomKB\\java\\src\\main\\resources\\sorting\\";

    @Test //TODO merge with String Algorithm runner
    public void sortDemoTestOneAcceptanceTest() {
        SortDemo sd = new SortDemo();
        Comparable<Integer>[] items = sd.readData(base + "test2.dat");
        sd.testOne("TestSort", items);
        sd.testEverything();
        sd.testAll(base + "test2.dat");
        sd.printSortedArray(items);
    }

    @Test //TODO merge with String Algorithm runner
    public void sortDemoTestEverythingAcceptanceTest() {
        SortDemo sd = new SortDemo();
        Comparable<Integer>[] items = sd.readData(base + "test2.dat");
        sd.testEverything();
        sd.printSortedArray(items);
    }

    @Test //TODO merge with String Algorithm runner
    public void sortDemoTestAllAcceptanceTest() {
        SortDemo sd = new SortDemo();
        Comparable<Integer>[] items = sd.readData(base + "test2.dat");
        sd.testAll(base + "test2.dat");
        sd.printSortedArray(items);
    }
}