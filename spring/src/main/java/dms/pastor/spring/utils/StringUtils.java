package dms.pastor.spring.utils;

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

    private static final String EMPTY_STRING = "";

    private StringUtils() {
    }


    public static boolean isStringEmpty(String string) {
        return string == null || string.isEmpty();
    }

}
