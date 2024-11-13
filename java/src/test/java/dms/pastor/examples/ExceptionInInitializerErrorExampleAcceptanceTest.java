package dms.pastor.examples;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Author Dominik Symonowicz
 * Created 30/12/2018
 * WWW:	<a href="https://dominiksymonowicz.com/">HOME PAGE</a>
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class ExceptionInInitializerErrorExampleAcceptanceTest {

    @Test
    public void exceptionInInitializerErrorExample() {
        // when
        Assertions.assertThrows(ExceptionInInitializerError.class, ExceptionInInitializerErrorExample::new);
    }

}