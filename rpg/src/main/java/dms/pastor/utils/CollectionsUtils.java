package dms.pastor.utils;

import java.util.*;

import static dms.pastor.utils.ValidatorUtils.validateIfObjectValueIsNotNull;

/**
 * Author Dominik Symonowicz
 * Created 2015-10-25
 * WWW:	<a href="https://dominiksymonowicz.com/">HOME PAGE</a>
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public final class CollectionsUtils {

    private CollectionsUtils() {
    }


    public static <E extends Enum<E>> List<E> toList(E[] enums) {
        validateIfObjectValueIsNotNull(enums, "Enum values");
        return Arrays.asList(enums);
    }

    static boolean isCharInCharArray(char[] charArray, char character) {
        for (char charElement : charArray) {
            if (Character.toLowerCase(character) == charElement) {
                return true;
            }
        }
        return false;

    }
}
