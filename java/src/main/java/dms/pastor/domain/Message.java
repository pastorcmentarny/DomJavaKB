package dms.pastor.domain;

/**
 * Author Dominik Symonowicz
 * Created 09/04/2016
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 * <p>
 * Example of test of System.out
 * <p>
 * tag-test-system.out
 */
public final class Message {

    public static final String INPUT_CANNOT_BE_EMPTY = "Input can not be null or empty.";

    private Message() {
    }

    public static void error(String errorMessage) {
        System.err.print("ERROR: " + errorMessage);
    }

}
