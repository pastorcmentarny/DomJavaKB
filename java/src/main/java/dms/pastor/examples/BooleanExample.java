package dms.pastor.examples;

/**
 * Author: Dominik Symonowicz
 * Website: <a href="https://dominiksymonowicz.com/">Home Page</a>
 * LinkedIn: <a href="https://www.linkedin.com/in/dominik-symonowicz">LinkedIn</a>
 * GitHub: <a href="https://github.com/pastorcmentarny">GitHub</a>
 */
public class BooleanExample {

    private BooleanExample() {
    }

    //tag-null-boolean
    static String lookingForTruth(Boolean isItTruth) {
        return String.valueOf(Boolean.TRUE.equals(isItTruth));
    }

}
