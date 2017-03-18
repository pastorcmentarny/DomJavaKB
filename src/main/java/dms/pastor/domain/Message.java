package dms.pastor.domain;

/**
 * Author Dominik Symonowicz
 * Created 09/04/2016
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 *
 * Example of test of System.out
 */
public class Message {
    public static final String INPUT_CANNOT_BE_EMPTY = "Input can not be null or empty.";

    private Message() {
    }

    public static void error(String errorMessage) {
        System.err.print("ERROR: " + errorMessage);
    }

}
