package dms.pastor.utils;

import dms.pastor.domain.exception.SomethingWentWrongException;
import dms.pastor.utils.randoms.RandomDataGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static dms.pastor.domain.Message.INPUT_CANNOT_BE_EMPTY;
import static dms.pastor.utils.StringUtils.ALPHABET;
import static dms.pastor.utils.StringUtils.getRandomText;
import static dms.pastor.utils.StringUtils.*;
import static dms.pastor.utils.randoms.RandomDataGenerator.*;
import static java.lang.Character.isLetter;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Author Dominik Symonowicz
 * Created 2015-10-31
 * WWW:	<a href="https://dominiksymonowicz.com/welcome">...</a>
 * IT BLOG:	<a href="https://dominiksymonowicz.blogspot.co.uk">...</a>
 * GitHub:	<a href="https://github.com/pastorcmentarny">...</a>
 * Google Play:	<a href="https://play.google.com/store/apps/developer?id=Dominik+Symonowicz">...</a>
 * LinkedIn: <a href="https://www.linkedin.com/in/dominik-symonowicz">...</a>
 */
@SuppressWarnings("QuestionableName") // because string is valid name
public class StringUtilsTest {

    public static final String WHITESPACES_ONLY_STRING = "                    ";
    private static final Logger LOGGER = LoggerFactory.getLogger(StringUtilsTest.class);
    private static final String NON_ALPHABETICAL_STRING = "&07";
    private static final String PALINDROME = "abcdcba";
    private static final String NOT_A_PALINDROME = "abcdef";
    private static final String PALINDROME_AFTER_PERMUTATION = "abcdabcd";


    @Test
    public void testGetRandomCharacter() {
        // given
        Character randomCharacter = getRandomCharacter();
        // when
        final boolean result = isLetter(randomCharacter);

        // then
        assertThat(result).isTrue();
    }

    @Test
    public void getUnknownWhenNullStringShouldReturnUnknownIfStringIsNull() {
        // when
        final String result = getUnknownWhenNullString(null);

        // then
        assertThat(result).isEqualTo("Unknown");
    }

    @Test
    public void getUnknownWhenNullStringShouldReturnStringIfStringIsNotNull() {
        // given
        final String string = generateString();
        // when
        final String result = getUnknownWhenNullString(string);

        // then
        assertThat(result).isEqualTo(string);
    }

    @Test
    public void testStringShouldBePalindrome() {
        // when
        final boolean result = isPalindromeString(PALINDROME);

        // then
        assertThat(result).isTrue();
    }

    @Test
    public void testStringShouldNotBePalindrome() {
        // when
        final boolean result = isPalindromeString(NOT_A_PALINDROME);

        // then
        assertThat(result).isFalse();
    }

    @Test
    public void testShouldBeAPalindromeForPermutableString() {
        // when
        final boolean result = isPalindromeOfAnyPermutationString(PALINDROME_AFTER_PERMUTATION);

        // then
        assertThat(result).isTrue();
    }

    @Test
    public void testShouldBePalindromeString() {
        // when
        final boolean result = isPalindromeOfAnyPermutationString(PALINDROME);

        // then
        assertThat(result).isTrue();
    }

    @Test
    public void testItIsNotAPermutableString() {
        // when
        final boolean result = isPalindromeOfAnyPermutationString(NOT_A_PALINDROME);

        // then
        assertThat(result).isFalse();
    }

    @Test
    public void testShouldBeLetterOnlyString() {
        // when
        final boolean result = isAlpha("ThisStringContainsLettersOnly");

        // then
        assertThat(result).isTrue();
    }

    @Test
    public void testShouldReturnFalseForStringWithNonLetterCharacters() {
        // when
        final boolean result = isAlpha("ThisStringHasNumbers1234567890asWell");

        // then
        assertThat(result).isFalse();
    }

    @Test
    public void testIsPangramsReturnTrue() {
        // given
        final String panagram = "The quick brown fox jumps over the lazy dog";
        // when
        final boolean result = isPangram(panagram);

        // then
        assertThat(result).isTrue();
    }

    @Test
    public void testIsPangramsReturnFalseForTextThatIsNotAPanagram() {
        // given
        String notPanagram = "We promptly judged antique ivory buckles for the prize";
        // when
        final boolean result = isPangram(notPanagram);

        // then
        assertThat(result).isFalse();
    }

    @Test
    public void testToStringArray() {
        // given
        String[] answer = new String[]{"London", "Tianjin", "Wrocław"};
        List<String> stringList = new ArrayList<>();
        stringList.add("London");
        stringList.add("Tianjin");
        stringList.add("Wrocław");
        // when
        final String[] stringArray = toStringArray(stringList);

        // then
        assertThat(stringArray).isEqualTo(answer);
    }

    //it is purpose of test
    @Test
    public void testToStringArrayReturnIllegalArgumentException() {
        // when
        Assertions.assertThrows(IllegalArgumentException.class, () -> toStringArray(null));
    }

    @SuppressWarnings("ConstantConditions")
    @Test
    public void isStringEmptyShouldReturnTrueForNull() {
        // when
        final boolean result = isStringBlank(null);

        // then
        assertThat(result).isTrue();
    }

    @Test
    public void isStringEmptyShouldReturnTrueForEmptyString() {
        // when
        final boolean result = isStringBlank(EMPTY_STRING);

        // then
        assertThat(result).isTrue();
    }

    @Test
    public void isStringEmptyShouldReturnTrueForOnlySpaceString() {
        // when
        final boolean result = isStringBlank("   ");
        // then
        assertThat(result).isTrue();

    }

    @Test
    public void shouldReturnFalseForValidString() {
        // when
        final boolean result = isStringBlank("String");

        // then
        assertThat(result).isFalse();
    }

    @Test
    public void shouldReturnFalseForRandomString() {

        final String randomText = RandomDataGenerator.getRandomText();

        //debug info
        LOGGER.debug("getRandomText() generate" + randomText);
        assertThat(randomText).isNotEmpty();
    }

    @Test
    public void shouldReturnTrueForNotEmptyStringTest() {
        // when
        final boolean result = StringUtils.isStringNotEmpty(generateString(128));

        // then
        assertThat(result).isTrue();
    }


    @Test
    public void getEmptyStringForNullStringExample() {
        // when
        final String nullSafeString = getNullSafeString(null);

        // then
        assertThat(nullSafeString).isEmpty();
    }

    @Test
    public void shouldReturnStringForNotNullStringExample() {
        // given
        final String string = "string";
        // when
        final String nullSafeString = getNullSafeString(string);

        // then
        assertThat(nullSafeString).isEqualTo(string);
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionWhenStringIsNullTest() {
        // when
        final var exception = Assertions.assertThrows(IllegalArgumentException.class, () -> splitContentIntoWords(null));

        // then
        assertThat(exception.getMessage()).isEqualTo(INPUT_CANNOT_BE_EMPTY);
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionWhenStringIsNullStringIsEmptyTest() {
        // when
        final var exception = Assertions.assertThrows(IllegalArgumentException.class, () -> splitContentIntoWords(EMPTY_STRING));

        // then
        assertThat(exception.getMessage()).isEqualTo(INPUT_CANNOT_BE_EMPTY);
    }

    @Test
    public void shouldReturn2WordsTest() {
        // given
        String content = "Two words";
        // when
        final String[] words = splitContentIntoWords(content);

        // then
        assertThat(words.length).isEqualTo(2);
    }

    @Test
    public void shouldValidateStringWithNonAlphanumericCharactersOnlyTest() {
        // when
        final boolean isAlphanumeric = hasNonAlphanumericCharactersOnly(NON_ALPHANUMERIC);

        // then
        assertThat(isAlphanumeric).isTrue();
    }

    @Test
    public void shouldReturnFalseForStringThatContainsSomeAlphanumericTest() {
        // given
        final String mixed = generateString(10) + generateNonAlphanumericString(5) + generateString(2, 10);
        // when
        final boolean isAlphanumeric = hasNonAlphanumericCharactersOnly(mixed);

        // then
        assertThat(isAlphanumeric).isFalse();
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionWhenStringIsEmptyForSwapCharactersTest() {
        // when
        final var result = swapCaseLettersInString(null);

        // then
        assertThat(result).isNull();
    }

    @Test
    public void shouldReturnEmptyStringIfYouPassEmptyStringIsEmptyForSwapCharactersTest() {
        // when
        final String actualResult = swapCaseLettersInString(EMPTY_STRING);

        // then
        assertThat(actualResult).isEmpty();
    }

    @SuppressWarnings("SpellCheckingInspection")
    @Test
    public void shouldSwapCharactersInString() {
        // given
        final String text = "lowerUPPERcase";
        final String expectedResult = "LOWERupperCASE";
        // when
        final String actualResult = swapCaseLettersInString(text);

        // then
        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @SuppressWarnings("SpellCheckingInspection")
    @Test
    public void shouldSwapCharactersAndDisplayRestOfNonAlphabeticalCharactersInString() {
        // given
        final String text = "plainTextExample#6688";
        final String expectedResult = "PLAINtEXTeXAMPLE#6688";
        // when
        final String actualResult = swapCaseLettersInString(text);

        // then
        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    public void shouldGetRandomTextTest() {
        // when
        final String randomText = getRandomText(128);

        // then
        assertThat(randomText).isNotEmpty();
    }

    @Test
    public void getRandomTextShouldReturnEmptyStringForZeroSize() {
        // when
        final String randomText = getRandomText(0);
        System.out.println(randomText);

        // then
        assertThat(randomText).isEmpty();
    }

    @Test
    public void removeAllNonAlphaNumericCharactersFromStringShouldReturnTheSameStringShouldReturnNullForNullString() {
        // when
        final String result = StringUtils.removeAllNonAlphaNumericCharactersFromString(null);

        // then
        assertThat(result).isNull();

    }

    @Test
    public void removeAllNonAlphaNumericCharactersFromStringShouldReturnTheSameString() {
        // given
        final String string = "An1Example!";
        final String expectedResult = "An1Example";
        // when
        final String result = StringUtils.removeAllNonAlphaNumericCharactersFromString(string);

        // then
        assertThat(result).isEqualToIgnoringCase(expectedResult);
    }

    @Test
    public void shouldRemoveAllNonAlphaNumericCharactersFromString() {
        // given
        final String string = "An1Example!\"\\£$%^&*()_+-={}[]@~:;'#<>?,./";
        final String expectedResult = "An1Example";
        // when
        final String result = StringUtils.removeAllNonAlphaNumericCharactersFromString(string);

        // then
        assertThat(result).isEqualToIgnoringCase(expectedResult);
    }

    @Test
    public void shouldBeDeleted() {
        // given
        LocalDate date = LocalDate.now();
        // when
        LocalDate dateNow = LocalDate.now();

        // then
        assertThat(dateNow).isAfter(date.minusDays(3));
    }

    @Test
    public void isStartWithUpperCaseShouldReturnTrueWhenIsTextStartsWithCapitalLetter() {
        // given
        final String string = "String";
        // when
        boolean result = StringUtils.startsWithUpperCase(string);
        // then
        assertThat(result).isTrue();
    }

    @Test
    public void isStartWithUpperCaseShouldReturnFalseWhenIsTextStartsWithLowerLetter() {
        // given
        final String string = "string";
        // when
        boolean result = StringUtils.startsWithUpperCase(string);
        // then
        assertThat(result).isFalse();
    }

    @Test
    public void isStartWithUpperCaseShouldReturnFalseWhenIsTextStartsWithNumber() {
        // given
        final String string = String.valueOf(randomPositiveInteger());
        // when
        boolean result = StringUtils.startsWithUpperCase(string);
        // then
        assertThat(result).isFalse();
    }

    @Test
    public void trimAllWhiteSpacesShouldNullForNullText() {
        // when
        final String result = trimAllWhiteSpaces(null);

        // then
        assertThat(result).isNull();
    }

    @Test
    public void trimAllWhiteSpacesShouldEmptyStringForEmptyText() {
        // when
        final String result = trimAllWhiteSpaces(EMPTY_STRING);

        // then
        assertThat(result).isEmpty();
    }

    @Test
    public void trimAllWhiteSpacesShouldEmptyStringForWhitespacesOnlyText() {
        // when
        final String result = trimAllWhiteSpaces(WHITESPACES_ONLY_STRING);

        // then
        assertThat(result).isEqualTo(WHITESPACES_ONLY_STRING);
    }

    @Test
    public void trimAllWhiteSpacesShouldRemoveAllWhitespaces() {
        // given
        final String text = "    Text With   Whitespaces.   ";
        final String expectedResult = "TextWithWhitespaces.";
        // when
        final String result = trimAllWhiteSpaces(text);

        // then
        assertThat(result).isEqualTo(expectedResult);
    }


    @Test
    public void shouldReturnTrueWhenTextHasNonAlphabetCharactersOnly() {
        // when
        final boolean result = StringUtils.hasNonAlphabetCharactersOnly(NON_ALPHABETICAL_STRING);

        // then
        assertThat(result).isTrue();
    }

    @Test
    public void hasNonAlphabetCharactersOnlyShouldReturnFalseIfStringContainAlphabetCharacter() {
        // when
        final boolean result = StringUtils.hasNonAlphabetCharactersOnly(NON_ALPHABETICAL_STRING);

        // then
        assertThat(result).isTrue();
    }


    @Test
    public void appendCharToCharArrayShouldReturnCharArrayWithAddedCharacter() {
        // given
        char character = 'z';
        char[] charArray = new char[]{'a', 'b', 'c'};
        char[] expectedResult = new char[]{'a', 'b', 'c', 'z'};
        // when
        final char[] result = StringUtils.addCharToCharArray(character, charArray);

        // then
        assertThat(result).isEqualTo(expectedResult);

    }

    @Test
    public void everythingIsEmptyShouldReturnTrueIfAllStringsAreEmptyAcceptanceTest() {
        // given
        final String string1 = generateString(MAX_SMALL_VALUE_RANGE);
        final String string2 = generateString(MAX_SMALL_VALUE_RANGE);
        final String string3 = generateString(MAX_SMALL_VALUE_RANGE);
        // when
        final boolean result = isAllStringsAreNotEmpty(string1, string2, string3);

        // then
        assertThat(result).isTrue();
    }

    @Test
    public void everythingIsEmptyShouldReturnFalseIfAnyOfStringsIsNotEmptyAcceptanceTest() {
        // given
        final String string1 = generateString(MAX_SMALL_VALUE_RANGE);
        final String string2 = generateString(MAX_SMALL_VALUE_RANGE);
        // when
        final boolean result = isAllStringsAreNotEmpty(string1, string2, EMPTY_STRING);

        // then
        assertThat(result).isFalse();
    }

    @Test
    public void everythingIsEmptyShouldReturnTrueIfNoArgumentProvided() {
        // when
        final boolean result = isAllStringsAreNotEmpty();

        // then
        assertThat(result).isTrue();
    }

    @Test
    public void countOccurrenceOfShouldReturn0ForOccurrenceThatIsNull() {
        // when
        int result = StringUtils.countOccurrenceOf(null, generateString());

        // then
        assertThat(result).isZero();
    }

    @Test
    public void countOccurrenceOfShouldReturn0ForWordThatIsNull() {
        // when
        int result = StringUtils.countOccurrenceOf(generateString(), null);

        // then
        assertThat(result).isZero();
    }

    @Test
    public void countOccurrenceOfShouldReturn0ForOccurrenceThatIsEmpty() {
        // when
        int result = StringUtils.countOccurrenceOf(EMPTY_STRING, generateString());

        // then
        assertThat(result).isZero();
    }

    @Test
    public void countOccurrenceOfShouldReturn0ForWordThatIsEmpty() {
        // when
        int result = StringUtils.countOccurrenceOf(generateString(), EMPTY_STRING);

        // then
        assertThat(result).isZero();
    }

    @Test
    public void countOccurrenceOfShouldReturn0IfOccurrenceWordIsLongerThanTextItself() {
        // given
        final String text = "text";
        // when
        int result = StringUtils.countOccurrenceOf(text + text, text);

        // then
        assertThat(result).isZero();
    }

    @Test
    public void countOccurrenceOfShouldReturn2ForOccurrenceOfLabInLabLab() {
        // given
        final String text = "LabLab";
        final String occurrence = "lab";
        // when
        int result = StringUtils.countOccurrenceOf(occurrence, text);

        // then
        assertThat(result).isEqualTo(2);
    }

    @Test
    public void countOccurrenceOfShouldReturn5ForOccurrenceOfSixInSentence() {
        // given
        final String text = "sixty-four sixty-five sixty-six sixty-seven";
        final String occurrence = "six";
        // when
        int result = StringUtils.countOccurrenceOf(occurrence, text);

        // then
        assertThat(result).isEqualTo(5);
    }

    @Test
    public void printCountryListShouldDisplayListOfCountries() {
        // when
        final List<String> countryList = getCountryList();

        //debug info
        LOGGER.debug(countryList.toString());

        // then
        assertThat(countryList).isNotEmpty();
        assertThat(countryList.size()).isEqualTo(861);


    }

    @Test
    public void toCamelCaseShouldReturnNullWhenInputIsNull() {
        // when
        final String result = getStringWithCapitalizedFirstCharacter(null);

        // then
        assertThat(result).isNull();
    }

    @Test
    public void capitalizeFirstCharacterShouldReturnEmptyStringWhenInputIsEmpty() {
        // when
        final String result = capitalizeFirstCharacter(EMPTY_STRING);

        // then
        assertThat(result).isEmpty();
    }

    @Test
    public void capitalizeFirstCharacterShouldReturnTheSameStringWhenInputHasCapitalCharacter() {
        // given
        final String string = "STRING";
        final String expectedResult = "S";
        // when
        final String result = capitalizeFirstCharacter(string);

        // then
        assertThat(result).isEqualTo(expectedResult);

    }

    @Test
    public void capitalizeFirstCharacterShouldReturnTheSameStringWhenInputHasFirstCapitalized() {
        // given
        final String string = "STRING";
        final String expectedResult = "S";
        // when
        final String result = capitalizeFirstCharacter(string);

        // then
        assertThat(result).isEqualTo(expectedResult);

    }


    @Test
    public void getStringWithCapitalizedFirstCharacterShouldReturnEmptyStringWhenInputIsEmpty() {
        // when
        final String result = getStringWithCapitalizedFirstCharacter(EMPTY_STRING);

        // then
        assertThat(result).isEmpty();
    }

    @Test
    public void getStringWithCapitalizedFirstCharacterShouldReturnTheSameStringWhenInputHasCapitalCharacterOnly() {
        // given
        final String string = "STRING";
        // when
        final String result = getStringWithCapitalizedFirstCharacter(string);

        // then
        assertThat(result).isEqualTo(string);

    }

    @Test
    public void getStringWithCapitalizedFirstCharacterShouldReturnTheSameStringWhenInputHasFirstCharacterCapitalized() {
        // given
        final String string = "String";
        // when
        final String result = getStringWithCapitalizedFirstCharacter(string);

        // then
        assertThat(result).isEqualTo(string);

    }

    @Test
    public void getStringWithCapitalizedFirstCharacterShouldReturnStringWithFirstCharacterCapitalized() {
        // given
        final String string = "string";
        final String expectedResult = "String";
        // when
        final String result = getStringWithCapitalizedFirstCharacter(string);

        // then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    public void shouldReturnNullIfStringIsNull() {
        // given
        final var characterToRemove = 'a';
        // when
        final var result = removeCharacterFromString(characterToRemove, null);

        // then
        assertThat(result).isNull();
    }

    @Test
    public void shouldReturnStringWithoutCharacter() {
        // given
        final var characterToRemove = 'a';
        final var expectedResult = "bcdefghijklmnopqrstuvwxyz";
        // when
        final var result = removeCharacterFromString(characterToRemove, ALPHABET);

        // then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    public void shouldReturnStringWithoutCharacterForStringWithManyCharacter() {
        // given
        final var characterToRemove = 'a';
        final var expectedResult = "dom";
        // when
        final var result = removeCharacterFromString(characterToRemove, "adaoamaa");

        // then
        assertThat(result).isEqualTo(expectedResult);
    }


    @Test
    public void shouldReplaceNewLinesFromVariousSystemWithSystemNewLine() {
        // given
        final String example = "Dominik\nis\r\nhungry!";
        final String expectedResult = "Dominik" + System.lineSeparator() + "is" + System.lineSeparator() + "hungry!";
        // when
        final var result = replaceWithSystemNewLine(example);
        // then
        assertThat(result).isEqualTo(expectedResult);

    }

    @Test
    public void shouldDescribeNullString() {
        // given
        final var expectedResult = "String is null";
        // when
        final var result = describeStringType(null);

        // then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    public void shouldDescribeEmptyString() {
        // given
        final var expectedResult = "String is empty";
        // when
        final var result = describeStringType(EMPTY_STRING);

        // then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    public void shouldDescribeBlankString() {
        // given
        final var expectedResult = "String is blank";
        // when
        final var result = describeStringType("   ");

        // then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    public void shouldDescribeString() {
        // given
        final var expectedResult = "String { content }";
        // when
        final var result = describeStringType("content");

        // then
        assertThat(result).isEqualTo(expectedResult);
    }


    @Test
    void notEqualsReturnFalseIfBothAreNull() {
        // when
        final boolean result = StringUtils.notEquals(null, null);

        // then
        org.assertj.core.api.Assertions.assertThat(result).isFalse();
    }

    @Test
    void notEqualsReturnFalseIfCurrentValueIsNull() {
        // when
        final boolean result = StringUtils.notEquals(null, generateString());

        // then
        org.assertj.core.api.Assertions.assertThat(result).isFalse();
    }

    @Test
    void notEqualsReturnFalseIfNewValueIsNull() {
        // when
        final boolean result = StringUtils.notEquals(generateString(), null);

        // then
        org.assertj.core.api.Assertions.assertThat(result).isFalse();
    }

    @Test
    void notEqualsReturnTrueIfNewAndCurrentValueAreDifferent() {

        // when
        final boolean result = StringUtils.notEquals(generateString(), generateString());

        // then
        org.assertj.core.api.Assertions.assertThat(result).isTrue();
    }

    @Test
    void notEqualsReturnTrueIfNewAndCurrentValueAreDifferent2() {
        // when
        final boolean result = StringUtils.notEquals("S", "s");

        // then
        org.assertj.core.api.Assertions.assertThat(result).isTrue();
    }

    @Test
    void notStartWithThrowsExceptionIfPrefixIsNullTest() {
        // given
        final String prefix_input = null;
        final String value_input = "Run every minute";

        // when
        final var exception = assertThrows(SomethingWentWrongException.class, () -> notStartWith(prefix_input, value_input));

        // then
        org.assertj.core.api.Assertions.assertThat(exception.getMessage()).isEqualTo("Whoops! Something went wrong. Invalid value and/or prefix data Prefix:'null' Value:'Run every minute'. I apologize for any inconvenience caused by your mistake.");
    }

    @Test
    void notStartWithThrowsExceptionIfValueIsNullTest() {
        // given
        final String prefix_input = "Run";
        final String value_input = null;

        // when
        final var exception = assertThrows(SomethingWentWrongException.class, () -> notStartWith(prefix_input, value_input));

        // then
        org.assertj.core.api.Assertions.assertThat(exception.getMessage()).isEqualTo("Whoops! Something went wrong. Invalid value and/or prefix data Prefix:'Run' Value:'null'. I apologize for any inconvenience caused by your mistake.");
    }

    @Test
    void notStartReturnsFalseTest() {
        // given
        final String prefix_input = "Run";
        final String value_input = "Run every minute";

        // when
        final boolean result = notStartWith(prefix_input, value_input);

        // then
        assertFalse(result);
    }

    @Test
    void notStartWithAcceptanceTest() {
        // given
        final String prefix_input = "Every";
        final String value_input = "Run every minute";

        // when
        final boolean result = notStartWith(prefix_input, value_input);

        // then
        assertTrue(result);
    }

    @Test
    void capitalizeWordWillReturnSameWord() {
        // given
        final String expectedResult = "MILK";

        // when
        final String result = capitalizeWord("MILK");

        // then
        assertEquals(expectedResult, result);
    }

    @Test
    void capitalizeWordReturnCapitalizedCharacter() {
        // given
        final String expectedResult = "X";

        // when
        final String result = capitalizeWord("x");

        // then
        assertEquals(expectedResult, result);
    }

    @Test
    void capitalizeWordAcceptanceTest() {
        // given
        final String expectedResult = "Garlic";

        // when
        final String result = capitalizeWord("garlic");

        // then
        assertEquals(expectedResult, result);
    }


}
