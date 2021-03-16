package dms.pastor.blog.testprintout;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * Author Dominik Symonowicz
 * Created 23/02/2017
 * WWW:	https://dominiksymonowicz.com/
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 * <p>
 * Example for this blog entry: http://dominiksymonowicz.blogspot.co.uk/2016/09/how-to-test-method-that-uses.html
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
        //Given
        final String errorMessage = "Test";

        //When
        Message.error(errorMessage);

        //Then
        assertThat("ERROR: " + errorMessage).isEqualTo(outputStream.toString());

    }
}