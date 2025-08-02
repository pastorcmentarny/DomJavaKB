package dms.pastor.tools.coder;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author Dominik Symonowicz
 * Created 08/10/2016
* Website: <a href="https://dominiksymonowicz.com/">Home Page</a>
* LinkedIn: <a href="https://www.linkedin.com/in/dominik-symonowicz">LinkedIn</a>
* GitHub: <a href="https://github.com/pastorcmentarny">GitHub</a>
 */
public class DomDecoderTest {


    private DomDecoder decoder;

    @SuppressWarnings("SpellCheckingInspection")
    @BeforeEach
    public void setUp() {
        String data = "2uJmJCMBPjhDt5wAHXgC";
        decoder = new DomDecoder(data);
    }

    @Test
    public void shouldThrowInvalidArgumentExceptionIfDataIsNull() {
        // given
        decoder = new DomDecoder(null);
        // when
        Assertions.assertThrows(IllegalArgumentException.class, () -> decoder.decode());

    }

    @Test
    public void shouldDecodeData() {
        // given
        final String expectedEncodedData = "plainString#256";

        // when
        String encodedData = decoder.decode();

        // then
        assertThat(encodedData).isEqualTo(expectedEncodedData);

    }

}