package dms.pastor;

import static java.io.File.separator;

/**
 * Author Dominik Symonowicz
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
public class TestConfig {
    public static final int MAX_RANDOM_SIZE = 4096;
    public static final String[] EMPTY_STRING_ARRAY = new String[0];
    public static final int[] EMPTY_INTEGER_ARRAY = {};
    private static final String SRC = "src" + separator;
    private static final String RESOURCES = "resources" + separator;
    public static final String PATH = SRC + "test" + separator + RESOURCES;
    public static final String BASE_PATH = System.getProperty("user.dir") +
            separator + SRC + "main" +
            separator + RESOURCES;
}