package dms.pastor.utils.html;

import dms.pastor.utils.ValidatorUtils;

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
    public static final String BR_TAG = "<br/>";


    private HtmlUtils() {
    }

    public static String getNbsp(int times) {
        ValidatorUtils.validateIfPositiveNumber(times);
        return EMPTY_STRING + HTML_SPACE.repeat(Math.max(0, times));
    }
}
