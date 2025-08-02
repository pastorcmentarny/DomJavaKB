package dms.pastor.tools.chinese.topinyin;

import org.junit.jupiter.api.Test;

import static dms.pastor.tools.chinese.topinyin.PseudoPinyinType.displaySupportedType;
import static dms.pastor.utils.randoms.RandomDataGenerator.generateString;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author Dominik Symonowicz
 * Created 28/12/2016
* Website: <a href="https://dominiksymonowicz.com/">Home Page</a>
* LinkedIn: <a href="https://www.linkedin.com/in/dominik-symonowicz">LinkedIn</a>
* GitHub: <a href="https://github.com/pastorcmentarny">GitHub</a>
 */
public class PseudoPinyinTypeTest {

    @Test
    public void containsShouldReturnTrueIfPseudoTypeIsValid() {
        // given
        String type = PseudoPinyinType.CHARACTER.name();

        // when
        final boolean result = PseudoPinyinType.contains(type);

        // then
        assertThat(result).isTrue();
    }

    @Test
    public void containsShouldReturnTrueIfPseudoTypeIsNotValid() {
        // given
        String type = generateString();

        // when
        final boolean result = PseudoPinyinType.contains(type);

        // then
        assertThat(result).isFalse();
    }

    @Test
    public void notContainsShouldReturnFalseIfPseudoTypeIsValid() {
        // given
        String type = PseudoPinyinType.CHARACTER.name();

        // when
        final boolean result = PseudoPinyinType.isNotContain(type);

        // then
        assertThat(result).isFalse();
    }

    @Test
    public void notContainsShouldReturnTrueIfPseudoTypeIsNotValid() {
        // given
        String type = generateString();

        // when
        final boolean result = PseudoPinyinType.isNotContain(type);

        // then
        assertThat(result).isTrue();
    }

    @Test
    public void shouldDisplayAllTypes() {
        // given
        final String expectedResult = "number,character";

        // when
        final String supportedType = displaySupportedType();

        // then
        assertThat(supportedType).isEqualToIgnoringCase(expectedResult);
    }

    @Test
    public void getConverterForShouldReturnNumberConverterToNumber() {
        // when
        final Converter converter = PseudoPinyinType.getConverterFor("number");

        // then
        assertThat(converter).isInstanceOf(NumberConverter.class);
    }
}