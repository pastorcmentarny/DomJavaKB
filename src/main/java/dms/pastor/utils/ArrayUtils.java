package dms.pastor.utils;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * Author Dominik Symonowicz
 * Created 2015-10-29
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public final class ArrayUtils {

    private ArrayUtils() {
    }

    public static String getIntArrayAsString(int[] anArray) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < anArray.length; i++) {
            sb.append('{').append(i).append(" = ").append(anArray[i]).append('}');
        }
        sb.append(']');
        return sb.toString();
    }

    public static int[] generateIntSequenceArray(int size) {
        int[] newArray = new int[size];
        for (int i = 0; i < newArray.length; i++) {
            newArray[i] = i;
        }
        return newArray;
    }

    public static byte[] generateRandomByteArray(int size) {
        byte[] bytes = new byte[size];
        new Random().nextBytes(bytes);
        PrintOutUtils.printArray(bytes);
        return bytes;
    }

    public static Set<Character> convertCharArrayToSet(char[] chars) {
        if (chars == null) {
            throw new IllegalArgumentException("Array is null!");
        }
        HashSet<Character> result = new HashSet<>();
        for (char aChar : chars) {
            result.add(aChar);
        }
        return result;
    }

    //TODO do generic version
    @SuppressWarnings("ReturnOfNull") // valid case as if you pass null , you should get null
    public static String[] reverseStringArray(String[] stringArray) {
        if (stringArray == null) {
            return null;
        }

        for (int i = 0; i < stringArray.length / 2; i++) {
            final int oppositeElement = stringArray.length - 1 - i;

            String temp = stringArray[oppositeElement];
            stringArray[oppositeElement] = stringArray[i];
            stringArray[i] = temp;
        }
        return stringArray;
    }

    public static String[][] clone2DArrayOfInts(String[][] source) {
        if (source == null) {
            throw new IllegalArgumentException("2D Array of integers cannot be null.");
        }

        if (source.length == 0) {
            return new String[][]{};
        }

        int length = source.length;
        String[][] destination = new String[length][source[0].length];
        for (int i = 0; i < length; i++) {
            System.arraycopy(source[i], 0, destination[i], 0, source[i].length);
        }
        return destination;
    }

}
