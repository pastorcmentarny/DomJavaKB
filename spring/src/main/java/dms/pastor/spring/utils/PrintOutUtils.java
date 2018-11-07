package dms.pastor.spring.utils;

import java.util.*;
import java.util.stream.IntStream;

import static java.lang.System.out;

/**
 * Author Dominik Symonowicz
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
class PrintOutUtils {

    private static final char SPACE = ' ';

    private static final String OPEN_ARRAY = "[ ";
    private static final char CLOSE_ARRAY = ']';

    private PrintOutUtils() {
    }

    public static void printIntArray(int[] values) {
        StringBuilder sb = new StringBuilder(OPEN_ARRAY);
        IntStream.of(values).forEach(i -> sb.append(i).append(SPACE));
        sb.append(CLOSE_ARRAY);
        out.println(sb.toString());
    }

    public static void printIntArray(Integer[] values) {
        StringBuilder sb = new StringBuilder(OPEN_ARRAY);
        Arrays.asList(values).forEach(integer -> sb.append(integer).append(SPACE));
        sb.append(CLOSE_ARRAY);
        out.println(sb.toString());
    }

    public static void printCharacterIntegerHashMap(HashMap<Character, Integer> hm) {
        Iterator<Map.Entry<Character, Integer>> it = hm.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Character, Integer> pairs = it.next();
            out.println("key: " + pairs.getKey() + " value: " + pairs.getValue());
            it.remove(); // avoids a ConcurrentModificationException
        }
    }

    public static void displayOddNumbers(int min, int max) {
        if (min > max) {
            throw new IllegalArgumentException("Minimum number is higher than maximum number");
        }
        for (int i = min; i <= max; i++) {
            if (i % 2 != 0) {
                out.print(i + SPACE);
            }
        }
    }

    public static String printArray(String[] array) {
        final StringBuilder stringBuilder = new StringBuilder(OPEN_ARRAY);
        for (String string : array) {
            stringBuilder.append(string).append(" , ");
        }
        stringBuilder.trimToSize();
        stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length());
        stringBuilder.append(CLOSE_ARRAY);
        return stringBuilder.toString();
    }

    public static void printArray(List<String> sourceAsArray) {
        if (sourceAsArray != null && !sourceAsArray.isEmpty()) {
            sourceAsArray.forEach(out::println);
        } else {
            throw new IllegalArgumentException("string array is empty");
        }
    }

    static void printArray(byte[] bytes) {
        StringBuilder stringBuilder = new StringBuilder(OPEN_ARRAY);
        if (bytes.length == 0) {
            throw new IllegalArgumentException("byte array is empty");
        }
        for (byte aByte : bytes) {
            stringBuilder.append(aByte).append(',');
        }
        final String result = stringBuilder.toString();
        final String substring = result.substring(0, result.length() - 1);

        out.print(substring + CLOSE_ARRAY);
    }

}

