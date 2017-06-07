package dms.pastor.tools.coder;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author Dominik Symonowicz
 * Created 08/10/2016
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
public class DomEncoderTest {
    @Rule
    public ExpectedException exception = ExpectedException.none();
    private DomEncoder encoder;

    @Before
    public void setUp() throws Exception {
        String data = "plainString#256";
        encoder = new DomEncoder(data);
    }

    @Test
    public void shouldThrowInvalidArgumentExceptionIfDataIsNull() {
        // expect
        exception.expect(IllegalArgumentException.class);

        // given
        encoder = new DomEncoder(null);

        // when
        encoder.encode();
    }

    @SuppressWarnings("SpellCheckingInspection")
    @Test
    public void shouldEncodeData() throws Exception {
        // given
        final String expectedEncodedData = "2uJmJCMBPjhDt5wAHXgC";

        // when
        String encodedData = encoder.encode();

        // then
        assertThat(encodedData).isEqualTo(expectedEncodedData);

    }
}