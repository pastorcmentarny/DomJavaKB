package dms.pastor.utils;

import org.junit.Test;

import static dms.pastor.utils.EnglishUtils.*;
import static dms.pastor.utils.StringUtils.EMPTY_STRING;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author Dominik Symonowicz
 * Created 09/01/2017
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class EnglishUtilsTest {

    @Test
    public void isVowelReturnForA() throws Exception {
        // given
        final char vowel = 'a';

        // when
        final boolean result = isLetterVowelIncludingY(vowel);
        // then
        assertThat(result).isTrue();
    }

    @Test
    public void isVowelReturnForB() throws Exception {
        // given
        final char vowel = 'b';

        // when
        final boolean result = isLetterVowelIncludingY(vowel);
        // then
        assertThat(result).isFalse();
    }

    @Test
    public void isVowelReturnFalseForCapitalC() throws Exception {
        // given
        final char vowel = 'C';

        // when
        final boolean result = isLetterVowelIncludingY(vowel);
        // then
        assertThat(result).isFalse();
    }

    @Test
    public void isVowelReturnTrueForCapitalE() throws Exception {
        // given
        final char vowel = 'E';

        // when
        final boolean result = isLetterVowelIncludingY(vowel);
        // then
        assertThat(result).isTrue();
    }

    @Test
    public void isVowelReturnFalseForNumber() throws Exception {
        // given
        final char vowel = '3';

        // when
        final boolean result = isLetterVowelIncludingY(vowel);

        // then
        assertThat(result).isFalse();
    }

    @Test
    public void isVowelReturnFalseForCharacter() throws Exception {
        // given
        final char vowel = '"';

        // when
        final boolean result = isLetterVowelIncludingY(vowel);

        // then
        assertThat(result).isFalse();
    }

    @Test
    public void isLetterVowelExcludingYReturnTrueForA() throws Exception {
        // given
        final char vowel = 'a';

        // when
        final boolean result = isLetterVowelExcludingY(vowel);
        // then
        assertThat(result).isTrue();
    }

    @Test
    public void isLetterVowelExcludingYReturnFalseForY() throws Exception {
        // given
        final char vowel = 'y';

        // when
        final boolean result = isLetterVowelExcludingY(vowel);
        // then
        assertThat(result).isFalse();
    }

    @Test
    public void isLetterConsonantReturnTrueForT() throws Exception {
        // given
        final char vowel = 't';

        // when
        final boolean result = isLetterConsonant(vowel);

        // then
        assertThat(result).isTrue();
    }

    @Test
    public void isLetterConsonantReturnFalseForU() throws Exception {
        // given
        final char vowel = 'u';

        // when
        final boolean result = isLetterConsonant(vowel);

        // then
        assertThat(result).isFalse();
    }

    @Test
    public void isLetterConsonantReturnTrueForCapitalN() throws Exception {
        // given
        final char vowel = 'N';

        // when
        final boolean result = isLetterConsonant(vowel);

        // then
        assertThat(result).isTrue();
    }

    @Test
    public void isLetterConsonantReturnFalseForCapitalO() throws Exception {
        // given
        final char vowel = 'O';

        // when
        final boolean result = isLetterConsonant(vowel);

        // then
        assertThat(result).isFalse();
    }

    @Test
    public void isLetterConsonantReturnFalseForNumber() throws Exception {
        // given
        final char vowel = '3';

        // when
        final boolean result = isLetterConsonant(vowel);

        // then
        assertThat(result).isFalse();
    }

    @Test
    public void isLetterConsonantReturnFalseForCharacter() throws Exception {
        // given
        final char vowel = '"';

        // when
        final boolean result = isLetterConsonant(vowel);

        // then
        assertThat(result).isFalse();
    }

    @Test
    public void isStopWordShouldReturnTrueForIs() throws Exception {
        // given
        final String stopWord = "is";

        // when
        final boolean word = isStopWord(stopWord);

        // then
        assertThat(word).isTrue();
    }

    @Test
    public void isStopWordShouldReturnFalseForDominik() throws Exception {
        // given
        final String notAStopWord = "Dominik";

        // when
        final boolean word = isStopWord(notAStopWord);

        // then
        assertThat(word).isFalse();
    }

    @Test
    public void isStopWordShouldReturnFalseForNull() throws Exception {

        // when
        final boolean word = isStopWord(null);

        // then
        assertThat(word).isFalse();
    }

    @SuppressWarnings("UnnecessaryLocalVariable")
    @Test
    public void isStopWordShouldReturnFalseForEmptyString() throws Exception {
        // given
        final String notAStopWord = EMPTY_STRING;

        // when
        final boolean word = isStopWord(notAStopWord);

        // then
        assertThat(word).isFalse();
    }

    @Test
    public void isNotStopWordShouldReturnFalseForAre() throws Exception {
        // given
        final String stopWord = "are";

        // when
        final boolean word = isNotStopWord(stopWord);

        // then
        assertThat(word).isFalse();
    }

    @Test
    public void isNotStopWordShouldReturnTrueForCheesecake() throws Exception {
        // given
        final String notAStopWord = "Cheesecake";

        // when
        final boolean word = isNotStopWord(notAStopWord);

        // then
        assertThat(word).isTrue();
    }

}
