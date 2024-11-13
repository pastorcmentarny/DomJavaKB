package dms.pastor.tasks.manipulatedataapplication.data;

import static dms.pastor.utils.StringUtils.EMPTY_STRING;

/**
 * Author Dominik Symonowicz
 * Created 2013-07-23
 * WWW:	<a href="https://dominiksymonowicz.com/">HOME PAGE</a>
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 * <p>
 * Note: I could use boolean,but i just want show example of enum usage
 */
public enum Genre {
    MALE,
    FEMALE;

    private static final String SPECIAL_CHARACTERS = "\\s";

    public static Genre fromString(String genre) {
        return valueOf(genre.toUpperCase().replaceAll(SPECIAL_CHARACTERS, EMPTY_STRING));
    }
}
