package dms.pastor;

import static java.io.File.separator;

/**
 * Author Dominik Symonowicz
* Website: <a href="https://dominiksymonowicz.com/">Home Page</a>
* LinkedIn: <a href="https://www.linkedin.com/in/dominik-symonowicz">LinkedIn</a>
* GitHub: <a href="https://github.com/pastorcmentarny">GitHub</a>
 */
public final class TestConfig {

    public static final int MAX_RANDOM_SIZE = 4096;
    public static final String[] EMPTY_STRING_ARRAY = new String[0];
    public static final int[] EMPTY_INTEGER_ARRAY = {};
    private static final String SRC = "src" + separator;
    private static final String RESOURCES = "resources" + separator;
    public static final String PATH = SRC + "test" + separator + RESOURCES + separator;
    public static final String BASE_PATH = System.getProperty("user.dir") +
            separator + SRC + "main" +
            separator + RESOURCES;

    private TestConfig() {
    }
}