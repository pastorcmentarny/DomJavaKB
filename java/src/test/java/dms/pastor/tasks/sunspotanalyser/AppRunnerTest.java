package dms.pastor.tasks.sunspotanalyser;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Author Dominik Symonowicz
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class AppRunnerTest {



    @Test
    public void shouldThrowIllegalArgumentExceptionWhenRunningAppWithoutArgumentsTest() {
        // when
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
        AppRunner.main(null);
        });

    }

    @Test
    public void shouldAppRunnerTest() {

        String[] stringList = new String[]{"a", "b"};
        // when
        Assertions.assertThrows(IllegalArgumentException.class, () -> {

        AppRunner.main(stringList);
        });


    }
}