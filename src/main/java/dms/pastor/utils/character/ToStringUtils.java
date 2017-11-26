package dms.pastor.utils.character;

import java.util.LinkedHashSet;
import java.util.Objects;

import static dms.pastor.utils.StringUtils.EMPTY_STRING;

/**
 * Author Dominik Symonowicz
 * Created 06/11/2017
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 * To avoid problem with method has the same erasure as another method (String and Character) related
 */
public final class ToStringUtils {
    private ToStringUtils() {
    }

    public static String toString(LinkedHashSet<Character> lines) {
        if (Objects.isNull(lines)) {
            return EMPTY_STRING;
        }
        StringBuilder stringBuilder = new StringBuilder(EMPTY_STRING);
        for (Character line : lines) {
            stringBuilder.append(line);
        }
        return stringBuilder.toString();
    }

}
