package dms.pastor.tasks.sunspotanalyser;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Author Dominik Symonowicz
* Website: <a href="https://dominiksymonowicz.com/">Home Page</a>
* LinkedIn: <a href="https://www.linkedin.com/in/dominik-symonowicz">LinkedIn</a>
* GitHub: <a href="https://github.com/pastorcmentarny">GitHub</a>
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