package dms.pastor.tools.coder;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
public class DomCodecTest {


    private DomEncoder encoder;

    @BeforeEach
    public void setUp() {
        String data = "plainString#256";
        encoder = new DomEncoder(data);
    }

    @Test
    public void shouldThrowInvalidArgumentExceptionIfDataIsNull() {
        // given
        encoder = new DomEncoder(null);

        // when
        Assertions.assertThrows(IllegalArgumentException.class, () -> encoder.encode());

    }

    @SuppressWarnings("SpellCheckingInspection")
    @Test
    public void shouldEncodeData() {
        // given
        final String expectedEncodedData = "2uJmJCMBPjhDt5wAHXgC";

        // when
        String encodedData = encoder.encode();

        // then
        assertThat(encodedData).isEqualTo(expectedEncodedData);

    }
}