package dms.pastor.tasks.romanarabicconverter;

import org.junit.jupiter.api.Test;

import static dms.pastor.tasks.romanarabicconverter.RomanNumberValidator.isValidRomanNumber;
import static dms.pastor.utils.StringUtils.EMPTY_STRING;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author Dominik Symonowicz
 * Created 2015-06-23
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class RomanNumberValidatorTest {

    @Test
    public void testIfIWorks() {
        assertThat(isValidRomanNumber("I")).isTrue();
    }

    @Test
    public void testIfValidRomanNumberWorks() {
        assertThat(isValidRomanNumber("IV")).isTrue();
    }

    @Test
    public void testIfMDCLXIVWorks() {
        assertThat(isValidRomanNumber("MDCLXIV")).isTrue();//1664
    }

    @Test
    public void testIfNullStringProduceFalse() {
        assertThat(isValidRomanNumber(null)).isFalse();
    }

    @Test
    public void testIfEmptyStringProduceFalse() {
        assertThat(isValidRomanNumber(EMPTY_STRING)).isFalse();
    }

    @Test
    public void testIfNonRomanCharacterOnlyProduceFalse() {
        assertThat(isValidRomanNumber("UFO")).isFalse();
    }

    @Test
    public void testIFMixedRomanAndNonRomanCharactersProducesFalse() {
        assertThat(isValidRomanNumber("VIXEN")).isFalse();
    }

    @Test
    public void testIfNumberProducesFalse() {
        assertThat(isValidRomanNumber("100")).isFalse();
    }

    @Test
    public void testValidArabicNumber() {
        assertThat(RomanNumberValidator.isIntCanBeRomanNumber(256)).isTrue();
    }

    @Test
    public void testIfNegativeNumberProduceFail() {
        assertThat(RomanNumberValidator.isIntCanBeRomanNumber(-1)).isFalse();
    }

    @Test
    public void testIfZeroProduceFail() {
        assertThat(RomanNumberValidator.isIntCanBeRomanNumber(0)).isFalse();
    }

    @Test
    public void testIfTooBigNumberProduceFail() {
        assertThat(RomanNumberValidator.isIntCanBeRomanNumber(4000)).isFalse();
    }

}