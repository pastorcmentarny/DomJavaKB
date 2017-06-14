package dms.pastor.domain;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static dms.pastor.domain.Message.error;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author Dominik Symonowicz
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 * <p>
 * Example of test of System.out
 * tag-system.out-test
 */
public class MessageTest {
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream original = System.err;

    @Before
    public void setUp() throws Exception {
        System.setErr(new PrintStream(outputStream));
    }

    @After
    public void tearDown() throws Exception {
        System.setErr(original);
    }

    @Test
    public void displayErrorTest() throws Exception {
        // given
        final String errorMessage = "Test";

        // when
        error(errorMessage);

        // then
        assertThat(outputStream.toString()).isEqualTo("ERROR: " + errorMessage);
    }
}