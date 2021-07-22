package dms.pastor.utils.converters;

import org.junit.jupiter.api.Test;

import static dms.pastor.utils.StringUtils.EMPTY_STRING;
import static org.assertj.core.api.Assertions.assertThat;

class TextToSha1ConverterTest {


    TextToSha1Converter converter = new TextToSha1Converter();

    @Test
    public void convertShouldReturnNullForNull() {
        // when
        final var result = converter.convert(null);

        // then
        assertThat(result).isNull();
    }

    @Test
    public void convertShouldReturnda39a3ee5e6b4b0d3255bfef95601890afd80709ForEmptyString() {
        // given
        final var expectedResult = "da39a3ee5e6b4b0d3255bfef95601890afd80709";

        // when
        final var result = converter.convert(EMPTY_STRING);

        // debug
        System.out.println(result);

        // then
        assertThat(result).isEqualTo(expectedResult);

    }

    @Test
    public void convertShouldReturn52c47f4e700e5e53dadc79e1d90f4a938f028a88ForUFO() {
        // given
        final var expectedResult = "52c47f4e700e5e53dadc79e1d90f4a938f028a88";

        // when
        final var result = converter.convert("UFO");

        // debug
        System.out.println(result);

        // then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    public void convertShouldReturn9578f951955d37f20b601c26591e260c1e5389bfForStringSizeOf50() {
        // given
        final var expectedResult = "9578f951955d37f20b601c26591e260c1e5389bf";

        // when
        final var result = converter.convert("01234567890123456789012345678901234567890123456789");

        // debug
        System.out.println(result);

        // then
        assertThat(result).isEqualTo(expectedResult);
    }

}