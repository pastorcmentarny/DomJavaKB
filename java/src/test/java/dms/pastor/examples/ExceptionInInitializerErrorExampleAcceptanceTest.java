package dms.pastor.examples;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * Author Dominik Symonowicz
 * Created 30/12/2018
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class ExceptionInInitializerErrorExampleAcceptanceTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void exceptionInInitializerErrorExample() {
        // expect
        exception.expect(ExceptionInInitializerError.class);

        // when
        ExceptionInInitializerErrorExample example = new ExceptionInInitializerErrorExample();


    }

}