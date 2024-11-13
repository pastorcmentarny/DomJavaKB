package dms.pastor.domain;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static dms.pastor.domain.Message.error;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author Dominik Symonowicz
 * WWW:	<a href="https://dominiksymonowicz.com/">HOME PAGE</a>
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 * <p>
 * Example of test of System.out
 * tag-system.out-test
 */
public class MessageTest {

    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream original = System.err;

    @BeforeEach
    public void setUp() {
        System.setErr(new PrintStream(outputStream));
    }

    @AfterEach
    public void tearDown() {
        System.setErr(original);
    }

    @Test
    public void displayErrorTest() {
        // given
        final String errorMessage = "Test";
        // when
        error(errorMessage);

        // then
        assertThat(outputStream.toString()).isEqualTo("ERROR: " + errorMessage);
    }
}