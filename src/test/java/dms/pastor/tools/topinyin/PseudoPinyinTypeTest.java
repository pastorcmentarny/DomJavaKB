package dms.pastor.tools.topinyin;

import org.junit.Test;

import static dms.pastor.utils.RandomDataGenerator.generateString;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author Dominik Symonowicz
 * Created 28/12/2016
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
public class PseudoPinyinTypeTest {

    @Test
    public void containsShouldReturnTrueIfPseudoTypeIsValid() throws Exception {
        // given
        String type = PseudoPinyinType.CHARACTER.name();

        // when
        final boolean result = PseudoPinyinType.contains(type);

        // then
        assertThat(result).isTrue();
    }

    @Test
    public void containsShouldReturnTrueIfPseudoTypeIsNotValid() throws Exception {
        // given
        String type = generateString();

        // when
        final boolean result = PseudoPinyinType.contains(type);

        // then
        assertThat(result).isFalse();
    }

    @Test
    public void notContainsShouldReturnFalseIfPseudoTypeIsValid() throws Exception {
        // given
        String type = PseudoPinyinType.CHARACTER.name();

        // when
        final boolean result = PseudoPinyinType.isNotContain(type);

        // then
        assertThat(result).isFalse();
    }

    @Test
    public void notContainsShouldReturnTrueIfPseudoTypeIsNotValid() throws Exception {
        // given
        String type = generateString();

        // when
        final boolean result = PseudoPinyinType.isNotContain(type);

        // then
        assertThat(result).isTrue();
    }

    //TODO
    @Test
    public void shouldDisplayAllTypes() throws Exception {
        // given

        // when
        PseudoPinyinType.displaySupportedType();
        // then

    }

    @Test
    public void getConverterForShouldReturnNumberConverterToNumber() throws Exception {

        // when
        final Converter converter = PseudoPinyinType.getConverterFor("number");

        // then
        assertThat(converter).isInstanceOf(NumberConverter.class);
    }
}