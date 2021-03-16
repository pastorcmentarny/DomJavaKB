package dms.pastor.examples;

/**
 * Author Dominik Symonowicz
 * WWW:	https://dominiksymonowicz.com/
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
public class BooleanExample {

    private BooleanExample() {
    }

    //tag-null-boolean
    static String lookingForTruth(Boolean isItTruth) {
        return String.valueOf(Boolean.TRUE.equals(isItTruth));
    }

}
