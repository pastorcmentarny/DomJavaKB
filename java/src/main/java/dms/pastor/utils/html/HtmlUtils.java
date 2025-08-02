package dms.pastor.utils.html;

import dms.pastor.utils.ValidatorUtils;

import static dms.pastor.utils.StringUtils.EMPTY_STRING;

/**
 * Author Dominik Symonowicz
* Website: <a href="https://dominiksymonowicz.com/">Home Page</a>
* LinkedIn: <a href="https://www.linkedin.com/in/dominik-symonowicz">LinkedIn</a>
* GitHub: <a href="https://github.com/pastorcmentarny">GitHub</a>
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
