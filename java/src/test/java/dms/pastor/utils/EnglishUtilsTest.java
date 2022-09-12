package dms.pastor.utils;

import org.junit.jupiter.api.Test;

import static dms.pastor.utils.EnglishUtils.*;
import static dms.pastor.utils.StringUtils.EMPTY_STRING;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author Dominik Symonowicz
 * Created 09/01/2017
 * WWW:	<a href="https://dominiksymonowicz.com/welcome">...</a>
 * IT BLOG:	<a href="https://dominiksymonowicz.blogspot.co.uk">...</a>
 * GitHub:	<a href="https://github.com/pastorcmentarny">...</a>
 * Google Play:	<a href="https://play.google.com/store/apps/developer?id=Dominik+Symonowicz">...</a>
 * LinkedIn: <a href="https://www.linkedin.com/in/dominik-symonowicz">...</a>
 */
public class EnglishUtilsTest {

    @Test
    public void isVowelReturnForA() {
        // given
        final char vowel = 'a';

        // when
        final boolean result = isLetterVowelIncludingY(vowel);

        // then
        assertThat(result).isTrue();
    }

    @Test
    public void isVowelReturnForB() {
        // given
        final char vowel = 'b';

        // when
        final boolean result = isLetterVowelIncludingY(vowel);

        // then
        assertThat(result).isFalse();
    }

    @Test
    public void isVowelReturnFalseForCapitalC() {
        // given
        final char vowel = 'C';

        // when
        final boolean result = isLetterVowelIncludingY(vowel);

        // then
        assertThat(result).isFalse();
    }

    @Test
    public void isVowelReturnTrueForCapitalE() {
        // given
        final char vowel = 'E';

        // when
        final boolean result = isLetterVowelIncludingY(vowel);

        // then
        assertThat(result).isTrue();
    }

    @Test
    public void isVowelReturnFalseForNumber() {
        // given
        final char vowel = '3';

        // when
        final boolean result = isLetterVowelIncludingY(vowel);

        // then
        assertThat(result).isFalse();
    }

    @Test
    public void isVowelReturnFalseForCharacter() {
        // given
        final char vowel = '"';

        // when
        final boolean result = isLetterVowelIncludingY(vowel);

        // then
        assertThat(result).isFalse();
    }

    @Test
    public void isLetterVowelExcludingYReturnTrueForA() {
        // given
        final char vowel = 'a';

        // when
        final boolean result = isLetterVowelExcludingY(vowel);

        // then
        assertThat(result).isTrue();
    }

    @Test
    public void isLetterVowelExcludingYReturnFalseForY() {
        // given
        final char vowel = 'y';

        // when
        final boolean result = isLetterVowelExcludingY(vowel);

        // then
        assertThat(result).isFalse();
    }

    @Test
    public void isLetterConsonantReturnTrueForT() {
        // given
        final char vowel = 't';

        // when
        final boolean result = isLetterConsonant(vowel);

        // then
        assertThat(result).isTrue();
    }

    @Test
    public void isLetterConsonantReturnFalseForU() {
        // given
        final char vowel = 'u';

        // when
        final boolean result = isLetterConsonant(vowel);

        // then
        assertThat(result).isFalse();
    }

    @Test
    public void isLetterConsonantReturnTrueForCapitalN() {
        // given
        final char vowel = 'N';

        // when
        final boolean result = isLetterConsonant(vowel);

        // then
        assertThat(result).isTrue();
    }

    @Test
    public void isLetterConsonantReturnFalseForCapitalO() {
        // given
        final char vowel = 'O';

        // when
        final boolean result = isLetterConsonant(vowel);

        // then
        assertThat(result).isFalse();
    }

    @Test
    public void isLetterConsonantReturnFalseForNumber() {
        // given
        final char vowel = '3';

        // when
        final boolean result = isLetterConsonant(vowel);

        // then
        assertThat(result).isFalse();
    }

    @Test
    public void isLetterConsonantReturnFalseForCharacter() {
        // given
        final char vowel = '"';

        // when
        final boolean result = isLetterConsonant(vowel);

        // then
        assertThat(result).isFalse();
    }

    @Test
    public void isStopWordShouldReturnTrueForIs() {
        // given
        final String stopWord = "is";

        // when
        final boolean word = isStopWord(stopWord);

        // then
        assertThat(word).isTrue();
    }

    @Test
    public void isStopWordShouldReturnFalseForDominik() {
        // given
        final String notAStopWord = "Dominik";

        // when
        final boolean word = isStopWord(notAStopWord);

        // then
        assertThat(word).isFalse();
    }

    @Test
    public void isStopWordShouldReturnFalseForNull() {
        // when
        final boolean word = isStopWord(null);

        // then
        assertThat(word).isFalse();
    }

    @SuppressWarnings("UnnecessaryLocalVariable")
    @Test
    public void isStopWordShouldReturnFalseForEmptyString() {
        // given
        final String notAStopWord = EMPTY_STRING;

        // when
        final boolean word = isStopWord(notAStopWord);

        // then
        assertThat(word).isFalse();
    }

    @Test
    public void isNotStopWordShouldReturnFalseForAre() {
        // given
        final String stopWord = "are";

        // when
        final boolean word = isNotStopWord(stopWord);

        // then
        assertThat(word).isFalse();
    }

    @Test
    public void isNotStopWordShouldReturnTrueForCheesecake() {
        // given
        final String notAStopWord = "Cheesecake";

        // when
        final boolean word = isNotStopWord(notAStopWord);

        // then
        assertThat(word).isTrue();
    }

    @Test
    public void fromPolishReturnNullForNull() {

        // when
        final String result = fromPolish(null);

        // then
        assertThat(result).isNull();
    }

    @Test
    public void fromPolishReturnEmptyForEmpty() {

        // when
        final String result = fromPolish(EMPTY_STRING);

        // then
        assertThat(result).isEmpty();
    }

    @Test
    public void fromPolishOnlyPolishAcceptanceTest() {
        // given
        final String polishCharacter = "ąĄśŚćĆżŻźŹńŃęĘóÓ";
        final String englishCharacter = "aAsScCzZzZnNeEoO";

        // when
        final String result = fromPolish(polishCharacter);

        // then
        assertThat(englishCharacter).isEqualTo(result);
    }

    @Test
    public void fromPolishAcceptanceTest() {
        // given
        final String polishCharacter = "1ąAĄ-sśŚćĆżŻźŹńŃęĘóÓqQ";
        final String englishCharacter = "1aAA-ssScCzZzZnNeEoOqQ";

        // when
        final String result = fromPolish(polishCharacter);

        // then
        assertThat(englishCharacter).isEqualTo(result);
    }

    @Test
    public void fromPolishOConvertsToO() {
        // given
        final String polishCharacter = "óÓ";
        final String englishCharacter = "oO";

        // when
        final String result = fromPolish(polishCharacter);

        // then
        assertThat(englishCharacter).isEqualTo(result);
    }

    @Test
    public void fromPolishNConvertsToN() {
        // given
        final String polishCharacter = "ńŃ";
        final String englishCharacter = "nN";

        // when
        final String result = fromPolish(polishCharacter);

        // then
        assertThat(englishCharacter).isEqualTo(result);
    }

    @Test
    public void fromPolishCConvertsToC() {
        // given
        final String polishCharacter = "ćĆ";
        final String englishCharacter = "cC";

        // when
        final String result = fromPolish(polishCharacter);

        // then
        assertThat(englishCharacter).isEqualTo(result);
    }

    @Test
    public void fromPolishSConvertsToS() {
        // given
        final String polishCharacter = "śŚ";
        final String englishCharacter = "sS";

        // when
        final String result = fromPolish(polishCharacter);

        // then
        assertThat(result).isEqualTo(englishCharacter);
    }

    @Test
    public void fromPolishAConvertsToA() {
        // given
        final String polishCharacter = "ąĄ";
        final String englishCharacter = "aA";

        // when
        final String result = fromPolish(polishCharacter);

        // then
        assertThat(englishCharacter).isEqualTo(result);
    }

    @Test
    public void fromPolishEConvertsToE() {
        // given
        final String polishCharacter = "ęĘ";
        final String englishCharacter = "eE";

        // when
        final String result = fromPolish(polishCharacter);

        // then
        assertThat(englishCharacter).isEqualTo(result);
    }

    @Test
    public void fromPolishZConvertsToZ() {
        // given
        final String polishCharacter = "żŻźŹ";
        final String englishCharacter = "zZzZ";

        // when
        final String result = fromPolish(polishCharacter);

        // then
        assertThat(englishCharacter).isEqualTo(result);
    }
}
