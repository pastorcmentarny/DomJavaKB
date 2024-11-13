package dms.pastor.utils;

import dms.pastor.utils.converters.IntegerCollectionToIntArrayConverter;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static dms.pastor.utils.ValidatorUtils.validateIfObjectValueIsNotNull;

/**
 * Author Dominik Symonowicz
 * Created 2015-10-29
 * WWW:	<a href="https://dominiksymonowicz.com/">HOME PAGE</a>
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public final class ArrayUtils {
    private static final IntegerCollectionToIntArrayConverter converter = new IntegerCollectionToIntArrayConverter();
    public static final int FIRST_ELEMENT = 0;

    private ArrayUtils() {
    }

    public static String getIntArrayAsString(int[] anArray) {
        StringBuilder sb = new StringBuilder("[");
        for (int element = FIRST_ELEMENT; element < anArray.length; element++) {
            sb.append('{').append(element).append(" = ").append(anArray[element]).append('}');
        }
        sb.append(']');
        return sb.toString();
    }

    static int[] generateIntSequenceArray(int size) {
        int[] newArray = new int[size];
        for (int element = FIRST_ELEMENT; element < newArray.length; element++) {
            newArray[element] = element;
        }
        return newArray;
    }

    @SuppressWarnings("ReturnOfNull") // valid case as if you pass null , you should get null
    public static String[] reverseStringArray(String[] stringArray) {
        if (stringArray == null) {
            return null;
        }

        for (int element = FIRST_ELEMENT; element < stringArray.length / 2; element++) {
            final int oppositeElement = stringArray.length - 1 - element;

            String temp = stringArray[oppositeElement];
            stringArray[oppositeElement] = stringArray[element];
            stringArray[element] = temp;
        }
        return stringArray;
    }

    public static String[][] clone2DArrayOfInts(String[][] source) {
        validateIfObjectValueIsNotNull(source, "2D Array of integers cannot be null.");

        if (source.length == FIRST_ELEMENT) {
            return new String[][]{};
        }

        int length = source.length;
        String[][] destination = new String[length][source[FIRST_ELEMENT].length];
        for (int element = FIRST_ELEMENT; element < length; element++) {
            System.arraycopy(source[element], FIRST_ELEMENT, destination[element], FIRST_ELEMENT, source[element].length);
        }
        return destination;
    }

    public static int[] subtractIntArray(int[] intArray, int[] valuesToExtract) {
        Set<Integer> result = IntStream.of(intArray).boxed().collect(Collectors.toSet());
        for (int value : valuesToExtract) {
            result.remove(value);
        }
        return converter.convert(result);
    }

}
