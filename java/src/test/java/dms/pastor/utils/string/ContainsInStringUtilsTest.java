package dms.pastor.utils.string;

import dms.pastor.tools.chinese.pinyin.PinyinUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static dms.pastor.utils.StringUtils.ALPHABET;
import static dms.pastor.utils.StringUtils.*;
import static dms.pastor.utils.StringUtilsTest.WHITESPACES_ONLY_STRING;
import static dms.pastor.utils.randoms.RandomDataGenerator.*;
import static dms.pastor.utils.string.ContainsInStringUtils.*;
import static java.util.Collections.emptyList;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author Dominik Symonowicz
 * Created 08/10/2017
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class ContainsInStringUtilsTest {


    @Test
    public void containsOnlyShouldReturnTrueIfAAAContainsOnlyA() {
        // when
        final boolean hasSpaceOnly = containsOnly("AAA", new char[]{'A'});

        // then
        assertThat(hasSpaceOnly).isTrue();
    }

    @Test
    public void shouldReturnFalseForSaraInSarah() {
        // when
        final boolean hasSpaceOnly = containsOnly("Sarah", new char[]{'S', 'a', 'r', 'a'});

        // then
        assertThat(hasSpaceOnly).isFalse();
    }

    @Test
    public void shouldReturnFalseForNullInputString() {
        // when
        final boolean hasSpaceOnly = containsOnly(null, new char[]{'S', 'a', 'r', 'a'});

        // then
        assertThat(hasSpaceOnly).isFalse();

    }

    @Test
    public void shouldReturnFalseForNullCharacterArray() {
        // when
        final boolean hasSpaceOnly = containsOnly("Word", null);

        // then
        assertThat(hasSpaceOnly).isFalse();
    }

    @Test
    public void shouldReturnTrueForSpaceCharacterOnlyInStringTest() {
        // when
        final boolean hasSpaceOnly = isContainSpace(WHITESPACE);

        // then
        assertThat(hasSpaceOnly).isTrue();
    }

    @Test
    public void shouldReturnTrueForSpaceCharactersOnlyInStringTest() {
        // when
        final boolean hasSpaceOnly = isContainSpace(WHITESPACES_ONLY_STRING);

        // then
        assertThat(hasSpaceOnly).isTrue();
    }

    @Test
    public void shouldReturnFalseIfYouPassNullToHasSpaceOnlyTest() {
        // when
        final boolean hasSpaceOnly = isContainSpace(null);

        // then
        assertThat(hasSpaceOnly).isFalse();
    }

    @Test
    public void shouldReturnFalseIfYouPassEmptyStringToHasSpaceOnlyTest() {
        // when
        final boolean hasSpaceOnly = isContainSpace(EMPTY_STRING);

        // then
        assertThat(hasSpaceOnly).isFalse();
    }

    @Test
    public void shouldReturnFalseIfInputContainsNotOnlySpaceInHasSpaceOnlyTest() {
        // given
        final String space = " A B  CC   Garlic ";
        // when
        final boolean hasSpaceOnly = isContainSpace(space);

        // then
        assertThat(hasSpaceOnly).isFalse();
    }

    @Test
    public void containsPinyinCharacterShouldReturnFalseIfTextIsNull() {
        // when
        final boolean result = containsPinyinCharacter(null);

        // then
        assertThat(result).isFalse();
    }

    @Test
    public void containsPinyinCharacterShouldReturnFalseIfTextIsEmpty() {
        // when
        final boolean result = containsPinyinCharacter(EMPTY_STRING);

        // then
        assertThat(result).isFalse();
    }

    @Test
    public void containsPinyinCharacterShouldReturnTrueIfTextHasPinyinOnly() {
        // given
        final String textWithPinyinOnly = PinyinUtils.getAllPinyinFromFirstToFourthToneWithoutNeutralTone();
        // when
        final boolean result = containsPinyinCharacter(textWithPinyinOnly);

        // then
        assertThat(result).isTrue();
    }

    @Test
    public void containsPinyinCharacterShouldReturnTrueIfTextHasPinyin() {
        // given
        final String textWithPinyin = "dò字1";
        // when
        final boolean result = containsPinyinCharacter(textWithPinyin);

        // then
        assertThat(result).isTrue();
    }


    @Test
    public void containsAnyAlphanumericCharactersShouldReturnFalseIfStringIsNull() {
        // when
        final boolean result = containsAnyAlphanumericCharacter(null);

        // then
        assertThat(result).isFalse();
    }

    @Test
    public void containsAnyAlphanumericCharactersShouldReturnFalseIfStringIsEmpty() {
        // when
        final boolean result = containsAnyAlphanumericCharacter(EMPTY_STRING);

        // then
        assertThat(result).isFalse();
    }

    @Test
    public void shouldReturnFalseIfStringContainsAnyAlphanumericCharacters() {
        // given
        final String characters = "字字字字字字";
        // when
        final boolean result = containsAnyAlphanumericCharacter(characters);

        // then
        assertThat(result).isFalse();
    }

    @Test
    public void containsAnyAlphanumericCharactersShouldReturnTrueIfStringContainNumber() {
        // given
        final String characters = "字1字";
        // when
        final boolean result = containsAnyAlphanumericCharacter(characters);

        // then
        assertThat(result).isTrue();
    }

    @Test
    public void containsAnyAlphanumericCharactersShouldReturnTrueIfStringContainLetter() {
        // given
        final String characters = "字a字B字";
        // when
        final boolean result = containsAnyAlphanumericCharacter(characters);

        // then
        assertThat(result).isTrue();
    }

    // part of the test
    @Test
    public void shouldThrowIllegalArgumentExceptionIfKeywordIsNullTest() {
// when
        Assertions.assertThrows(IllegalArgumentException.class, () -> isTextContainsAllKeywordsExists(null, generateString()));


    }

    @Test
    public void shouldThrowIllegalArgumentExceptionIfTextIsNullTest() {
// when
        Assertions.assertThrows(IllegalArgumentException.class, () -> isTextContainsAllKeywordsExists(generateStringList(), null));


    }

    @Test
    public void shouldThrowIllegalArgumentExceptionIfKeywordIsEmptyTest() {
        // when
        Assertions.assertThrows(IllegalArgumentException.class, () -> isTextContainsAllKeywordsExists(emptyList(), generateString()));

    }

    @Test
    public void shouldThrowIllegalArgumentExceptionIfTextIsEmptyTest() {
        // when
        Assertions.assertThrows(IllegalArgumentException.class, () -> isTextContainsAllKeywordsExists(generateStringList(), EMPTY_STRING));

    }

    @Test
    public void shouldVerifyThatAllKeywordsExistsInTextTest() {
        // given
        final List<String> keywords = Arrays.asList("brown", "fox", "dog", "panagram");
        final String text = "The quick brown fox jumps over a lazy dog.";
        // when
        final boolean exists = isTextContainsAllKeywordsExists(keywords, text);

        // then
        assertThat(exists).isTrue();
    }


    @Test
    public void containsUpperCaseShouldReturnFalseIfTextIsNull() {
        // when
        final boolean result = containsUpperCase(null);

        // then
        assertThat(result).isFalse();
    }

    @Test
    public void containsUpperCaseShouldReturnFalseIfTextIsEmpty() {
        // when
        final boolean result = containsUpperCase(EMPTY_STRING);

        // then
        assertThat(result).isFalse();
    }

    @Test
    public void containsUpperCaseShouldReturnFalseIfTextHasNumbersOnly() {
        // when
        final boolean result = containsUpperCase(String.valueOf(randomInteger()));

        // then
        assertThat(result).isFalse();
    }

    @Test
    public void containsUpperCaseShouldReturnFalseIfTextHasLowerLetterOnly() {
        // when
        final boolean result = containsUpperCase(ALPHABET);

        // then
        assertThat(result).isFalse();
    }

    @Test
    public void containsUpperCaseShouldReturnTrueIfTextHasUpperCaseLetter() {
        // when
        final boolean result = containsUpperCase("Dominik");

        // then
        assertThat(result).isTrue();
    }

}
