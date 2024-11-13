package dms.pastor.utils.string;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;

import static dms.pastor.utils.StringUtils.EMPTY_STRING;
import static dms.pastor.utils.StringUtils.NEW_LINE;

/**
 * Author Dominik Symonowicz
 * WWW:	<a href="https://dominiksymonowicz.com/">HOME PAGE</a>
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
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
        StringBuilder stringBuilder = new StringBuilder("[ ");
        for (int value : values) {
            stringBuilder.append(value).append(delimiter);
        }
        stringBuilder.append(']');
        return stringBuilder.toString();
    }

    public static String toString(LinkedHashSet<String> lines) {
        if (Objects.isNull(lines) || lines.isEmpty()) {
            return EMPTY_STRING;
        }
        StringBuilder stringBuilder = new StringBuilder(EMPTY_STRING);
        lines.forEach(line -> stringBuilder.append(line).append(NEW_LINE));
        return stringBuilder.toString();
    }

    private static Consumer<String> addToStringBuilder(StringBuilder stringBuilder) {
        return line -> stringBuilder.append(line).append(dms.pastor.utils.StringUtils.COMMA);
    }

    public static String toString(List<String> stringList) {
        final StringBuilder stringBuilder = new StringBuilder(EMPTY_STRING);
        stringList.forEach(addToStringBuilder(stringBuilder));
        return stringBuilder.substring(0, stringBuilder.length() - 1);
    }

}
