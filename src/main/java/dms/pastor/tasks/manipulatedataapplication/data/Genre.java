package dms.pastor.tasks.manipulatedataapplication.data;

/**
 * Author Dominik Symonowicz
 * Created 2013-07-23
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 * <p>
 * Note: I could use boolean,but i just want show example of enum usage
 */
public enum Genre {
    MALE,
    FEMALE;

    private static final String SPECIAL_CHARACTERS = "\\s";
    private static final String EMPTY_STRING = "";

    public static Genre fromString(String genre) {
        return valueOf(genre.toUpperCase().replaceAll(SPECIAL_CHARACTERS, EMPTY_STRING));
    }
}
