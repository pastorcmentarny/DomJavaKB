package dms.pastor.utils;

import static dms.pastor.utils.StringUtils.EMPTY_STRING;

public final class HtmlUtils {
    private HtmlUtils() {
    }

    public static String getNbsp(int times) {
        ValidatorUtils.validateIfPositiveNumber(times);
        StringBuilder nsbpBuilder = new StringBuilder(EMPTY_STRING);
        for (int i = 0; i < times; i++) {
            nsbpBuilder.append("&nbsp;");
        }
        return nsbpBuilder.toString();
    }
}
