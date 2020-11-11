package dms.pastor.tools.chinese.pinyin;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author Dominik Symonowicz
 * Created 08/01/2017
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class PinyinTableTest {

    private static final int NEUTRAL_TONE = 0;
    private static final int FIRST_TONE = 1;
    private static final int SECOND_TONE = 2;
    private static final int THIRD_TONE = 3;
    private static final int FOURTH_TONE = 4;

    @Test
    public void getPinyinCharacterFromLetterWithToneShouldReturnAWithNoToneWhenInputWasLetterAWithZero() {
        // given
        final String letter = "a";
        // when
        final String pinyinCharacter = PinyinTable.getPinyinCharacterFromLetterWithTone(letter, NEUTRAL_TONE);

        // then
        assertThat(pinyinCharacter).isEqualTo(letter);
    }

    @Test
    public void getPinyinCharacterFromLetterWithToneShouldReturnEWithFirstToneWhenInputWasLetterEWithOne() {
        // given
        final String letter = "e";
        final String expectedPinyinCharacter = "ē";
        // when
        final String pinyinCharacter = PinyinTable.getPinyinCharacterFromLetterWithTone(letter, FIRST_TONE);

        // then
        assertThat(pinyinCharacter).isEqualTo(expectedPinyinCharacter);
    }

    @Test
    public void getPinyinCharacterFromLetterWithToneShouldReturnOWithSecondToneWhenInputWasLetterOWithTwo() {
        // given
        final String letter = "o";
        final String expectedPinyinCharacter = "ó";
        // when
        final String pinyinCharacter = PinyinTable.getPinyinCharacterFromLetterWithTone(letter, SECOND_TONE);

        // then
        assertThat(pinyinCharacter).isEqualTo(expectedPinyinCharacter);
    }

    @Test
    public void getPinyinCharacterFromLetterWithToneShouldReturnIWithThirdToneWhenInputWasLetterIWithThree() {
        // given
        final String letter = "i";
        final String expectedPinyinCharacter = "ǐ";
        // when
        final String pinyinCharacter = PinyinTable.getPinyinCharacterFromLetterWithTone(letter, THIRD_TONE);

        // then
        assertThat(pinyinCharacter).isEqualTo(expectedPinyinCharacter);
    }

    @Test
    public void getPinyinCharacterFromLetterWithToneShouldReturnUWithFourthToneWhenInputWasLetterUWithFourth() {
        // given
        final String letter = "u";
        final String expectedPinyinCharacter = "ù";
        // when
        final String pinyinCharacter = PinyinTable.getPinyinCharacterFromLetterWithTone(letter, FOURTH_TONE);

        // then
        assertThat(pinyinCharacter).isEqualTo(expectedPinyinCharacter);
    }

    @Test
    public void getPinyinCharacterFromLetterWithToneShouldReturnEmptyStringWhenInputHasInvalidLetterWithValidThirdTone() {
        // given
        final String letter = "ą";
        // when
        final String pinyinCharacter = PinyinTable.getPinyinCharacterFromLetterWithTone(letter, THIRD_TONE);

        // then
        assertThat(pinyinCharacter).isEmpty();
    }

}