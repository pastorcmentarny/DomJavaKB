package dms.pastor.tasks.sunspotanalyser;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Author Dominik Symonowicz
 * WWW:	<a href="https://dominiksymonowicz.com/">HOME PAGE</a>
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class AppRunnerTest {


    @Test
    public void shouldThrowIllegalArgumentExceptionWhenRunningAppWithoutArgumentsTest() {
        // when
        assertThrows(IllegalArgumentException.class, () -> AppRunner.main(null));

    }

    @Test
    public void shouldAppRunnerTest() {

        String[] stringList = new String[]{"a", "b"};
        // when
        assertThrows(IllegalArgumentException.class, () -> AppRunner.main(stringList));


    }
}