package dms.pastor.utils;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

import static dms.pastor.utils.StringUtils.WHITESPACE_CHAR;
import static dms.pastor.utils.ValidatorUtils.validateMinValueIsSmallerThanMaxValue;
import static java.lang.String.valueOf;
import static java.lang.System.out;

/**
 * Author Dominik Symonowicz
 * Created 2015-10-25
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public final class PrintOutUtils {

    private static final String COMMA = ",";
    private static final String OPEN_ARRAY = "[";
    private static final String OPEN_ARRAY_WITH_SPACE = OPEN_ARRAY + WHITESPACE_CHAR;
    private static final char CLOSE_ARRAY = ']';

    private PrintOutUtils() {
    }

    public static void printIntArray(int[] values) {
        StringBuilder stringBuilder = new StringBuilder(OPEN_ARRAY_WITH_SPACE);
        IntStream.of(values).forEach(integer -> stringBuilder.append(integer).append(WHITESPACE_CHAR));
        printInConsole(stringBuilder);
    }

    public static void printIntArray(Integer[] values) {
        StringBuilder stringBuilder = new StringBuilder(OPEN_ARRAY_WITH_SPACE);
        Arrays.asList(values).forEach(integer -> stringBuilder.append(integer).append(WHITESPACE_CHAR));
        printInConsole(stringBuilder);
    }

    private static void printInConsole(StringBuilder sb) {
        sb.append(CLOSE_ARRAY);
        out.println(sb.toString());
    }

    public static void printCharacterIntegerHashMap(Map<Character, Integer> hm) {
        Iterator<Map.Entry<Character, Integer>> it = hm.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Character, Integer> pairs = it.next();
            out.println("key: " + pairs.getKey() + " value: " + pairs.getValue());
            it.remove(); // avoids a ConcurrentModificationException
        }
    }

    public static void displayOddNumbers(int min, int max) {
        validateMinValueIsSmallerThanMaxValue(min, max);

        for (int i = min; i <= max; i++) {
            String text;
            if (i % 2 != 0) {
                text = valueOf(i) + WHITESPACE_CHAR;
                out.print(text);
            }
        }
    }

    public static String printArray(String[] array) {
        final StringBuilder stringBuilder = new StringBuilder(OPEN_ARRAY);
        for (String text : array) {
            stringBuilder.append(text).append(COMMA);
        }
        stringBuilder.trimToSize();
        stringBuilder.delete(stringBuilder.length() - 1, stringBuilder.length());
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
            stringBuilder.append(aByte).append(COMMA);
        }
        final String result = stringBuilder.toString();
        final String substring = result.substring(0, result.length() - 1);

        out.print(substring + CLOSE_ARRAY);
    }

}