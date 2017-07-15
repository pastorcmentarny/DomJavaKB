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
    public void countOccurrencesOfShouldReturnZeroIfSearchWordTIsNull() throws Exception {
        // given
        final String text = "A text in the text.";

        // when
        final int result = countOccurrencesOf(null, text);

        // then
        assertThat(result).isZero();
    }

    @Test
    public void countOccurrencesOfShouldReturnZeroIfTextIsNull() throws Exception {
        // given
        final String what = "text";

        // when
        final int result = countOccurrencesOf(what, null);

        // then
        assertThat(result).isZero();
    }

    @Test
    public void countOccurrencesOfShouldReturnOneIfSearchWordOccurredOnceInText() throws Exception {
        // given
        final String what = "text";
        final String text = "A text in the String.";

        // when
        final int result = countOccurrencesOf(what, text);

        // then
        assertThat(result).isEqualTo(1);
    }


    @Test
    public void countOccurrencesOfShouldReturnTwoIfSearchWordOccurredTwiceInText() throws Exception {
        // given
        final String what = "text";
        final String text = "A text in the text.";

        // when
        final int result = countOccurrencesOf(what, text);

        // then
        assertThat(result).isEqualTo(2);
    }

    @Test
    public void countOccurrencesOfShouldReturnOnceIfSearchWordOccurredTwiceButOneHasWrongCaseInText() throws Exception {
        // given
        final String what = "text";
        final String text = "A text in the Text.";

        // when
        final int result = countOccurrencesOf(what, text);

        // then
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void countOccurrencesOfShouldReturnThreeIfSearchWordOccurredThreeTimesInText() throws Exception {
        // given
        final String what = "text";
        final String text = "A text in the texttext.";

        // when
        final int result = countOccurrencesOf(what, text);

        // then
        assertThat(result).isEqualTo(3);
    }
}