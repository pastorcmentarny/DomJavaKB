package dms.pastor.utils;

import org.junit.Test;

import static dms.pastor.utils.RegexUtils.countOccurrencesOf;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author Dominik Symonowicz
 * Created 15/07/2017
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
public class RegexUtilsTest {

    @Test
    public void countOccurrencesOfShouldReturnZeroIfSearchWordTIsNull() {
        // given
        final String text = "A text in the text.";

        // when
        final int result = countOccurrencesOf(null, text);

        // then
        assertThat(result).isZero();
    }

    @Test
    public void countOccurrencesOfShouldReturnZeroIfTextIsNull() {
        // given
        final String what = "text";

        // when
        final int result = countOccurrencesOf(what, null);

        // then
        assertThat(result).isZero();
    }

    @Test
    public void countOccurrencesOfShouldReturnOneIfSearchWordOccurredOnceInText() {
        // given
        final String what = "text";
        final String text = "A text in the String.";

        // when
        final int result = countOccurrencesOf(what, text);

        // then
        assertThat(result).isEqualTo(1);
    }


    @Test
    public void countOccurrencesOfShouldReturnTwoIfSearchWordOccurredTwiceInText() {
        // given
        final String what = "text";
        final String text = "A text in the text.";

        // when
        final int result = countOccurrencesOf(what, text);

        // then
        assertThat(result).isEqualTo(2);
    }

    @Test
    public void countOccurrencesOfShouldReturnOnceIfSearchWordOccurredTwiceButOneHasWrongCaseInText() {
        // given
        final String what = "text";
        final String text = "A text in the Text.";

        // when
        final int result = countOccurrencesOf(what, text);

        // then
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void countOccurrencesOfShouldReturnThreeIfSearchWordOccurredThreeTimesInText() {
        // given
        final String what = "text";
        final String text = "A text in the texttext.";

        // when
        final int result = countOccurrencesOf(what, text);

        // then
        assertThat(result).isEqualTo(3);
    }

    @Test
    public void shouldReturnTrueIfPhoneNumberHasOnlyNumbersAndPlusAndMinusSign() {
        // given

        // when
        final var validPhoneNumber = RegexUtils.hasOnlyNumbersAndPlusAndMinusSign("+447912345678");

        // then
        assertThat(validPhoneNumber).isTrue();
    }

    @Test
    public void shouldReturnFalseIfPhoneNumberHasInvalidCharacter() {
        // given

        // when
        final var validPhoneNumber = RegexUtils.hasOnlyNumbersAndPlusAndMinusSign("(00)447912345678");

        // then
        assertThat(validPhoneNumber).isFalse();
    }

}