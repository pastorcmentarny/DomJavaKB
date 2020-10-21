package dms.pastor.utils;

import java.util.regex.Pattern;

/**
 * Author Dominik Symonowicz
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public final class RegexUtils {

    private static final String NUMBERS_WITH_PLUS_AND_MINUS = "[\\d +-]+";

    private RegexUtils() {
    }

    public static boolean hasOnlyNumbersAndPlusAndMinusSign(String text) {
        return Pattern.matches(NUMBERS_WITH_PLUS_AND_MINUS, text);
    }
}
