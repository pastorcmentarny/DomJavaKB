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
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class DomDecoderTest {
    @Rule
    public ExpectedException exception = ExpectedException.none();

    private DomDecoder decoder;

    @SuppressWarnings("SpellCheckingInspection")
    @Before
    public void setUp() throws Exception {
        String data = "2uJmJCMBPjhDt5wAHXgC";
        decoder = new DomDecoder(data);
    }

    @Test
    public void shouldThrowInvalidArgumentExceptionIfDataIsNull() {
        // expect
        exception.expect(IllegalArgumentException.class);

        // given
        decoder = new DomDecoder(null);

        // when
        decoder.decode();
    }

    @Test
    public void shouldDecodeData() throws Exception {
        // given
        final String expectedEncodedData = "plainString#256";

        // when
        String encodedData = decoder.decode();

        // then
        assertThat(encodedData).isEqualTo(expectedEncodedData);

    }

}