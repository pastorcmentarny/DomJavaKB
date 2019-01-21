package dms.pastor.utils;

import static dms.pastor.utils.StringUtils.EMPTY_STRING;

/**
 * Author Dominik Symonowicz
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public final class HtmlUtils {

    public static final String HTML_SPACE = "&nbsp;";

    private HtmlUtils() {
    }

    public static String getNbsp(int times) {
        ValidatorUtils.validateIfPositiveNumber(times);
        StringBuilder nsbpBuilder = new StringBuilder(EMPTY_STRING);
        for (int i = 0; i < times; i++) {
            nsbpBuilder.append(HTML_SPACE);
        }
        return nsbpBuilder.toString();
    }
}
