package dms.pastor.utils.converters;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author Dominik Symonowicz
 * Created 07.05.2020
 * WWW:	https://dominiksymonowicz.com/
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
public class StringListToStringArrayConverterTest {
    final StringListToStringArrayConverter converter = new StringListToStringArrayConverter();

    @Test
    public void convertToStringArrayShouldReturnEmptyStringArrayForNull() {
        // when
        final String[] result = converter.convert(null);

        // then
        assertThat(result).isEmpty();
    }

    @Test
    public void convertToStringArrayShouldReturnEmptyStringArrayIfListEmpty() {
        // when
        final String[] result = converter.convert(Collections.emptyList());

        // then
        assertThat(result).isEmpty();
    }

    @Test
    public void convertToStringArrayAcceptanceTest() {
        // given
        final List<String> example = List.of("one", "two", "three");
        final String[] expectedResult = new String[]{"one", "two", "three"};

        // when
        final String[] result = converter.convert(example);

        // then
        assertThat(result).isEqualTo(expectedResult);
    }
}