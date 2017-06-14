package dms.pastor.tasks.sunspotanalyser;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * Author Dominik Symonowicz
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class AppRunnerTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void shouldThrowIllegalArgumentExceptionWhenRunningAppWithoutArgumentsTest() throws Exception {
        // expect
        exception.expect(IllegalArgumentException.class);

        // when
        AppRunner.main(null);
    }

    @Test
    public void shouldAppRunnerTest() throws Exception {
        // expect
        exception.expect(IllegalArgumentException.class);
        String[] stringList = new String[]{"a", "b"};
        // when
        AppRunner.main(stringList);

    }
}