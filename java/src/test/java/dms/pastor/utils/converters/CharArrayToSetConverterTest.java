package dms.pastor.utils.converters;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * Author Dominik Symonowicz
 * Created 07.05.2020
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
public class CharArrayToSetConverterTest {

    @Test
    public void shouldConvertCharArrayToSetAcceptanceTest() {
        // given
        char[] chars = new char[]{'a', 'b', 'c'};
        final var charArrayToSetConverter = new CharArrayToSetConverter();
        final var expectedResult = Set.of('a', 'b', 'c');
        // when
        final var result = charArrayToSetConverter.convert(chars);

        assertThat(result).isEqualTo(expectedResult);
    }

}