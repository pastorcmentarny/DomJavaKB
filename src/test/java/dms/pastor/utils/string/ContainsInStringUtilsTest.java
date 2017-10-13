package dms.pastor.utils.string;

import dms.pastor.tools.chinese.pinyin.PinyinUtils;
import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Arrays;
import java.util.List;

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
    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void containsOnlyShouldReturnTrueIfAAAContainsOnlyA() throws Exception {
        // when
        final boolean hasSpaceOnly = containsOnly("AAA", new char[]{'A'});

        // then
        assertThat(hasSpaceOnly).isTrue();
    }

    @Test
    public void shouldReturnFalseForSaraInSarah() throws Exception {
        // when
        final boolean hasSpaceOnly = containsOnly("Sarah", new char[]{'S', 'a', 'r', 'a'});

        // then
        assertThat(hasSpaceOnly).isFalse();
    }

    @Test
    public void shouldReturnFalseForNullInputString() throws Exception {
        // when
        final boolean hasSpaceOnly = containsOnly(null, new char[]{'S', 'a', 'r', 'a'});

        // then
        assertThat(hasSpaceOnly).isFalse();

    }

    @Test
    public void shouldReturnFalseForNullCharacterArray() throws Exception {
        // when
        final boolean hasSpaceOnly = containsOnly("Word", null);

        // then
        assertThat(hasSpaceOnly).isFalse();
    }

    @Test
    public void shouldReturnTrueForSpaceCharacterOnlyInStringTest() throws Exception {
        // when
        final boolean hasSpaceOnly = isContainSpace(WHITESPACE);

        // then
        assertThat(hasSpaceOnly).isTrue();
    }

    @Test
    public void shouldReturnTrueForSpaceCharactersOnlyInStringTest() throws Exception {
        // when
        final boolean hasSpaceOnly = isContainSpace(WHITESPACES_ONLY_STRING);

        // then
        assertThat(hasSpaceOnly).isTrue();
    }

    @Test
    public void shouldReturnFalseIfYouPassNullToHasSpaceOnlyTest() throws Exception {
        // when
        final boolean hasSpaceOnly = isContainSpace(null);

        // then
        assertThat(hasSpaceOnly).isFalse();
    }

    @Test
    public void shouldReturnFalseIfYouPassEmptyStringToHasSpaceOnlyTest() throws Exception {
        // when
        final boolean hasSpaceOnly = isContainSpace(EMPTY_STRING);

        // then
        assertThat(hasSpaceOnly).isFalse();
    }

    @Test
    public void shouldReturnFalseIfInputContainsNotOnlySpaceInHasSpaceOnlyTest() throws Exception {
        // given
        final String space = " A B  CC   Garlic ";

        // when
        final boolean hasSpaceOnly = isContainSpace(space);

        // then
        assertThat(hasSpaceOnly).isFalse();
    }

    @Test
    public void containsPinyinCharacterShouldReturnFalseIfTextIsNull() throws Exception {
        // when
        final boolean result = containsPinyinCharacter(null);

        // then
        assertThat(result).isFalse();
    }

    @Test
    public void containsPinyinCharacterShouldReturnFalseIfTextIsEmpty() throws Exception {
        // when
        final boolean result = containsPinyinCharacter(EMPTY_STRING);

        // then
        assertThat(result).isFalse();
    }

    @Test
    public void containsPinyinCharacterShouldReturnTrueIfTextHasPinyinOnly() throws Exception {
        // given
        final String textWithPinyinOnly = PinyinUtils.getAllPinyinFromFirstToFourthToneWithoutNeutralTone();

        // when
        final boolean result = containsPinyinCharacter(textWithPinyinOnly);

        // then
        assertThat(result).isTrue();
    }

    @Test
    public void containsPinyinCharacterShouldReturnTrueIfTextHasPinyin() throws Exception {
        // given
        final String textWithPinyin = "dò字1";

        // when
        final boolean result = containsPinyinCharacter(textWithPinyin);

        // then
        assertThat(result).isTrue();
    }


    @Test
    public void containsAnyAlphanumericCharactersShouldReturnFalseIfStringIsNull() throws Exception {
        // when
        final boolean result = containsAnyAlphanumericCharacter(null);

        // then
        AssertionsForClassTypes.assertThat(result).isFalse();
    }

    @Test
    public void containsAnyAlphanumericCharactersShouldReturnFalseIfStringIsEmpty() throws Exception {
        // when
        final boolean result = containsAnyAlphanumericCharacter(EMPTY_STRING);

        // then
        AssertionsForClassTypes.assertThat(result).isFalse();
    }

    @Test
    public void shouldReturnFalseIfStringContainsAnyAlphanumericCharacters() throws Exception {
        // given
        final String characters = "字字字字字字";

        // when
        final boolean result = containsAnyAlphanumericCharacter(characters);

        // then
        AssertionsForClassTypes.assertThat(result).isFalse();
    }

    @Test
    public void containsAnyAlphanumericCharactersShouldReturnTrueIfStringContainNumber() throws Exception {
        // given
        final String characters = "字1字";

        // when
        final boolean result = containsAnyAlphanumericCharacter(characters);

        // then
        AssertionsForClassTypes.assertThat(result).isTrue();
    }

    @Test
    public void containsAnyAlphanumericCharactersShouldReturnTrueIfStringContainLetter() throws Exception {
        // given
        final String characters = "字a字B字";

        // when
        final boolean result = containsAnyAlphanumericCharacter(characters);

        // then
        AssertionsForClassTypes.assertThat(result).isTrue();
    }

    @SuppressWarnings("ConstantConditions") // part of the test
    @Test
    public void shouldThrowIllegalArgumentExceptionIfKeywordIsNullTest() throws Exception {
        // except
        exception.expect(IllegalArgumentException.class);

        // when
        isTextContainsAllKeywordsExists(null, generateString());

    }

    @Test
    public void shouldThrowIllegalArgumentExceptionIfTextIsNullTest() throws Exception {
        // except
        exception.expect(IllegalArgumentException.class);

        // when
        isTextContainsAllKeywordsExists(generateStringList(), null);
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionIfKeywordIsEmptyTest() throws Exception {
        // except
        exception.expect(IllegalArgumentException.class);

        // when
        isTextContainsAllKeywordsExists(emptyList(), generateString());

    }

    @Test
    public void shouldThrowIllegalArgumentExceptionIfTextIsEmptyTest() throws Exception {
        // except
        exception.expect(IllegalArgumentException.class);

        // when
        isTextContainsAllKeywordsExists(generateStringList(), EMPTY_STRING);
    }

    @Test
    public void shouldVerifyThatAllKeywordsExistsInTextTest() throws Exception {
        // given
        final List<String> keywords = Arrays.asList("brown", "fox", "dog", "panagram");
        final String text = "The quick brown fox jumps over a lazy dog.";

        //when
        final boolean exists = isTextContainsAllKeywordsExists(keywords, text);

        // then
        AssertionsForClassTypes.assertThat(exists).isTrue();
    }


    @Test
    public void containsUpperCaseShouldReturnFalseIfTextIsNull() throws Exception {
        // when
        final boolean result = containsUpperCase(null);

        // then
        assertThat(result).isFalse();
    }

    @Test
    public void containsUpperCaseShouldReturnFalseIfTextIsEmpty() throws Exception {
        // when
        final boolean result = containsUpperCase(EMPTY_STRING);

        // then
        assertThat(result).isFalse();
    }

    @Test
    public void containsUpperCaseShouldReturnFalseIfTextHasNumbersOnly() throws Exception {
        // when
        final boolean result = containsUpperCase(String.valueOf(randomInteger()));

        // then
        assertThat(result).isFalse();
    }

    @Test
    public void containsUpperCaseShouldReturnFalseIfTextHasLowerLetterOnly() throws Exception {
        // when
        final boolean result = containsUpperCase(ALPHABET);

        // then
        assertThat(result).isFalse();
    }

    @Test
    public void containsUpperCaseShouldReturnTrueIfTextHasUpperCaseLetter() throws Exception {
        // when
        final boolean result = containsUpperCase("Dominik");

        // then
        assertThat(result).isTrue();
    }

}
