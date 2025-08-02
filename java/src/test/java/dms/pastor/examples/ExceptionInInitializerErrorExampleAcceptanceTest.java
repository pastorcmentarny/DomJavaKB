package dms.pastor.examples;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Author Dominik Symonowicz
 * Created 30/12/2018
* Website: <a href="https://dominiksymonowicz.com/">Home Page</a>
* LinkedIn: <a href="https://www.linkedin.com/in/dominik-symonowicz">LinkedIn</a>
* GitHub: <a href="https://github.com/pastorcmentarny">GitHub</a>
 */
public class ExceptionInInitializerErrorExampleAcceptanceTest {

    @Test
    public void exceptionInInitializerErrorExample() {
        // when
        Assertions.assertThrows(ExceptionInInitializerError.class, ExceptionInInitializerErrorExample::new);
    }

}