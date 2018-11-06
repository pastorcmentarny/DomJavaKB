package dms.pastor.utils;

import dms.pastor.utils.randoms.RandomDataGenerator;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static dms.pastor.domain.Message.INPUT_CANNOT_BE_EMPTY;
import static dms.pastor.utils.StringUtils.*;
import static dms.pastor.utils.StringUtils.getRandomText;
import static dms.pastor.utils.randoms.RandomDataGenerator.*;
import static java.lang.Character.isLetter;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

/**
 * Author Dominik Symonowicz
 * Created 2015-10-31
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
@SuppressWarnings("QuestionableName") // because string is valid name
public class StringUtilsTest {

    public static final String WHITESPACES_ONLY_STRING = "                    ";
    private static final Logger LOGGER = LoggerFactory.getLogger(StringUtilsTest.class);
    private static final String NON_ALPHABETICAL_STRING = "&07";
    @SuppressWarnings("SpellCheckingInspection")
    private static final String PALINDROME = "abcdcba";
    @SuppressWarnings("SpellCheckingInspection")
    private static final String NOT_A_PALINDROME = "abcdef";
    @SuppressWarnings("SpellCheckingInspection")
    private static final String PALINDROME_AFTER_PERMUTATION = "abcdabcd";
    @Rule
    public final ExpectedException exception = ExpectedException.none();

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
        final boolean result = isPangrams(panagram);

        // then
        assertThat(result).isTrue();
    }

    @Test
    public void testIsPangramsReturnFalseForTextThatIsNotAPanagram() {
        // given
        String notPanagram = "We promptly judged antique ivory buckles for the prize";

        // when
        final boolean result = isPangrams(notPanagram);

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
        // expect
        exception.expect(IllegalArgumentException.class);

        // when
        toStringArray(null);
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
        // except
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage(INPUT_CANNOT_BE_EMPTY);

        // when
        splitContentIntoWords(null);
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionWhenStringIsNullStringIsEmptyTest() {
        // except
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage(INPUT_CANNOT_BE_EMPTY);

        // when
        splitContentIntoWords(EMPTY_STRING);
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

    @SuppressWarnings("ConstantConditions") // part of the test
    @Test
    public void shouldThrowIllegalArgumentExceptionWhenStringIsEmptyForSwapCharactersTest() {
        // exception
        exception.expect(IllegalArgumentException.class);

        // when
        swapCaseLettersInString(null);
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

        // then
        assertThat(countryList).isNotEmpty();

        //debug info
        LOGGER.debug(countryList.toString());
    }

    @Test
    public void toCamelCaseShouldThrowIllegalArgumentExceptionWhenInputIsNull() {
        // expect
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("text cannot be null");

        // when
        getStringWithCapitalizedFirstCharacter(null);
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


}
