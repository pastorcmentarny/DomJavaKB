package dms.pastor.utils.string;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;

import static dms.pastor.utils.StringUtils.*;

/**
 * Author Dominik Symonowicz
 * Created 06/11/2017
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public final class ToStringUtils {
    private ToStringUtils() {
    }

    public static String toString(int[] values, String delimiter) {
        if (values.length == 0) {
            return EMPTY_STRING;
        }
        StringBuilder sb = new StringBuilder("[ ");
        for (int value : values) {
            sb.append(value).append(delimiter);
        }
        sb.append(']');
        return sb.toString();
    }

    public static String toString(LinkedHashSet<String> lines) {
        if (Objects.isNull(lines) || lines.isEmpty()) {
            return EMPTY_STRING;
        }
        StringBuilder stringBuilder = new StringBuilder(EMPTY_STRING);
        lines.forEach(addToStringBuilder(stringBuilder, NEW_LINE));
        return stringBuilder.toString().substring(0, stringBuilder.length() - 1);
    }

    private static Consumer<String> addToStringBuilder(StringBuilder stringBuilder, String character) {
        return line -> stringBuilder.append(line).append(character);
    }

    public static String toString(List<String> stringList) {
        final StringBuilder stringBuilder = new StringBuilder(EMPTY_STRING);
        stringList.forEach(addToStringBuilder(stringBuilder, COMMA));
        return stringBuilder.toString().substring(0, stringBuilder.length() - 1);
    }

}
