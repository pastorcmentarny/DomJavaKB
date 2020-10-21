package dms.pastor.utils.converters;

import java.util.Collection;

public class IntegerCollectionToIntArrayConverter implements Converter<Collection<Integer>, int[]> {

    @Override
    public int[] convert(Collection<Integer> from) {
        int[] intArray = new int[from.size()];
        int index = 0;
        for (Integer integer : from) {
            intArray[index++] = integer;
        }
        return intArray;
    }
}
