package dms.pastor.tasks.manipulatedataapplication.data;

/**
 * Author Dominik Symonowicz
 * Created 2013-07-23
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 * <p>
 * Note: I could use boolean,but i just want show example of enum usage
 */
public enum Genre {
    MALE,
    FEMALE;

    public static Genre fromString(String genre) {
        return valueOf(genre.toUpperCase().replaceAll("\\s", ""));
    }
}
