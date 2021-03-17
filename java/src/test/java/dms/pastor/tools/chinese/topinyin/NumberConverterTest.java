package dms.pastor.tools.chinese.topinyin;

import org.junit.jupiter.api.Test;

import static dms.pastor.utils.randoms.RandomDataGenerator.generateString;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author Dominik Symonowicz
 * Created 29/12/2016
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class NumberConverterTest {

    private final Converter numberConverter = new NumberConverter();

    @Test
    public void convertToPinyinShouldReturnEmptyIfInputIsNull() {
        // when
        final String result = numberConverter.convertToPinyin(null);

        // then
        assertThat(result).isEmpty();
    }

    @Test
    public void convertToPinyinShouldReturnEmptyIfIsNotValidCharacterWithTone() {
        // given
        final String text = generateString();

        // when
        final String result = numberConverter.convertToPinyin(text);

        // then
        assertThat(result).isEqualTo(text);
    }

    @Test
    public void shouldReturnPinyinWithNeutralTone() {
        // given
        final String ma = "ma";

        // when
        final String result = numberConverter.convertToPinyin(ma);

        // then
        assertThat(result).isEqualTo(ma);
    }

    @Test
    public void shouldReturnPinyinWithFirstTone() {
        // given
        final String ma = "ma(1)";
        final String expectedResult = "mā";

        // when
        final String result = numberConverter.convertToPinyin(ma);

        // then
        assertThat(result).isEqualTo(expectedResult);
    }

}