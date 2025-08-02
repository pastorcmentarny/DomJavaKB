package dms.pastor.tasks.manipulatedataapplication.data;

import static dms.pastor.utils.StringUtils.EMPTY_STRING;

/**
 * Author Dominik Symonowicz
 * Created 2013-07-23
* Website: <a href="https://dominiksymonowicz.com/">Home Page</a>
* LinkedIn: <a href="https://www.linkedin.com/in/dominik-symonowicz">LinkedIn</a>
* GitHub: <a href="https://github.com/pastorcmentarny">GitHub</a>
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
