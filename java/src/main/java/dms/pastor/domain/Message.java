package dms.pastor.domain;

/**
 * Author Dominik Symonowicz
 * Created 09/04/2016
* Website: <a href="https://dominiksymonowicz.com/">Home Page</a>
* LinkedIn: <a href="https://www.linkedin.com/in/dominik-symonowicz">LinkedIn</a>
* GitHub: <a href="https://github.com/pastorcmentarny">GitHub</a>
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
