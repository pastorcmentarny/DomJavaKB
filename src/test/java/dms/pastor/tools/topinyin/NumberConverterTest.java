package dms.pastor.tools.topinyin;

import org.junit.Test;

import static dms.pastor.utils.randoms.RandomDataGenerator.generateString;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author Dominik Symonowicz
 * Created 29/12/2016
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
public class NumberConverterTest {

    private final Converter numberConverter = new NumberConverter();

    @Test
    public void convertToPinyinShouldReturnEmptyIfInputIsNull() throws Exception {
        // when
        final String result = numberConverter.convertToPinyin(null);

        // then
        assertThat(result).isEmpty();
    }

    @Test
    public void convertToPinyinShouldReturnEmptyIfIsNotValidCharacterWithTone() throws Exception {
        // given
        final String text = generateString();

        // when
        final String result = numberConverter.convertToPinyin(text);

        // then
        assertThat(result).isEqualTo(text);
    }

    @Test
    public void shouldReturnPinyinWithNeutralTone() throws Exception {
        // given
        final String ma = "ma";

        // when
        final String result = numberConverter.convertToPinyin(ma);

        // then
        assertThat(result).isEqualTo(ma);
    }

    @Test
    public void shouldReturnPinyinWithFirstTone() throws Exception {
        // given
        final String ma = "ma(1)";
        final String expectedResult = "mā";

        // when
        final String result = numberConverter.convertToPinyin(ma);

        // then
        assertThat(result).isEqualTo(expectedResult);
    }

}