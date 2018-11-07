package dms.pastor.spring.utils;

import java.util.ArrayList;
import java.util.LinkedHashSet;

/**
 * Author Dominik Symonowicz
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 * <p>
 * Yes, Apache commons is better, but this class was created to learn TDD.
 * Last updated 21.02'2017
 */ //TODO move to Java's StringUtils
final class StringUtils {

    static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    private static final String EMPTY_STRING = "";

    private StringUtils() {
    }

    public static String toString(int[] values) {
        StringBuilder sb = new StringBuilder("[ ");
        for (int i : values) {
            sb.append(i).append(' ');
        }
        sb.append(']');
        return sb.toString();
    }

    public static String toString(LinkedHashSet<String> lines) {
        StringBuilder stringBuilder = new StringBuilder(EMPTY_STRING);
        for (String line : lines) {
            stringBuilder.append(line).append('\n');
        }
        return stringBuilder.toString();
    }


    public static boolean isStringEmpty(String string) {
        return string == null || string.isEmpty();
    }

    public static String toString(ArrayList<String> stringArrayList) {
        StringBuilder stringBuilder = new StringBuilder(EMPTY_STRING);
        stringArrayList.forEach(stringBuilder::append);
        return stringBuilder.toString();
    }

}
