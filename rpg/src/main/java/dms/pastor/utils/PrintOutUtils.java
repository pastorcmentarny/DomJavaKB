package dms.pastor.utils;

import java.util.Arrays;
import java.util.stream.IntStream;

import static dms.pastor.utils.StringUtils.WHITESPACE_CHAR;
import static java.lang.System.out;

/**
 * Author Dominik Symonowicz
 * Created 2015-10-25
 * WWW:	<a href="https://dominiksymonowicz.com/">HOME PAGE</a>
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
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
        out.println(sb);
    }


    public static void printArray(byte[] bytes) {
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
