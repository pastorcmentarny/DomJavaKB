
package dms.pastor.examples.sorting;

import java.lang.reflect.Constructor;

public class SortFactory {

    //TODO "BubbleSort"?
    public static Sorter getSorter() {
        return getSorter("BubbleSort");
    }

    public static Sorter getSorter(String sorter) {
        Sorter sort = null;
        try {
            Class clas = Class.forName(sorter);
            Class[] parms = {};
            Constructor cons = clas.getConstructor(parms);
            Object obj = cons.newInstance(parms);
            if (obj instanceof Sorter) {
                sort = (Sorter) obj;
            }
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
        return sort;
    }

}
