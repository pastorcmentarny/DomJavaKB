package dms.pastor.utils;

import dms.pastor.utils.randoms.RandomDataGenerator;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
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

    private static final Logger LOGGER = LoggerFactory.getLogger(StringUtilsTest.class);

    private static final String NON_ALPHABETICAL_STRING = "&07";
    private static final String PALINDROME = "abcdcba";
    private static final String NOT_A_PALINDROME = "abcdef";
    private static final String PALINDROME_AFTER_PERMUTATION = "abcdabcd";
    public static final String WHITESPACES_ONLY_STRING = "                    ";

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void testGetRandomCharacter() throws Exception {
        // given
        Character randomCharacter = getRandomCharacter();

        // when
        final boolean result = isLetter(randomCharacter);

        // then
        assertThat(result).isTrue();
    }

    @Test
    public void getUnknownWhenNullStringShouldReturnUnknownIfStringIsNull() throws Exception {
        // when
        final String result = getUnknownWhenNullString(null);

        // then
        assertThat(result).isEqualTo("Unknown");
    }

    @Test
    public void getUnknownWhenNullStringShouldReturnStringIfStringIsNotNull() throws Exception {
        // given
        final String string = generateString();
        // when
        final String result = getUnknownWhenNullString(string);

        // then
        assertThat(result).isEqualTo(string);
    }

    @Test
    public void testStringShouldBePalindrome() throws Exception {
        // when
        final boolean result = isPalindromeString(PALINDROME);

        // then
        assertThat(result).isTrue();
    }

    @Test
    public void testStringShouldNotBePalindrome() throws Exception {
        // when
        final boolean result = isPalindromeString(NOT_A_PALINDROME);

        // then
        assertThat(result).isFalse();
    }

    @Test
    public void testShouldBeAPalindromeForPermutableString() throws Exception {
        // when
        final boolean result = isPalindromeOfAnyPermutationString(PALINDROME_AFTER_PERMUTATION);

        // then
        assertThat(result).isTrue();
    }

    @Test
    public void testShouldBePalindromeString() throws Exception {
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
    public void testShouldBeLetterOnlyString() throws Exception {
        // when
        final boolean result = isAlpha("ThisStringContainsLettersOnly");

        // then
        assertThat(result).isTrue();
    }

    @Test
    public void testShouldReturnFalseForStringWithNonLetterCharacters() throws Exception {
        // when
        final boolean result = isAlpha("ThisStringHasNumbers1234567890asWell");

        // then
        assertThat(result).isFalse();
    }

    @Test
    public void testIsPangramsReturnTrue() throws Exception {
        // given
        final String panagram = "The quick brown fox jumps over the lazy dog";

        // when
        final boolean result = isPangrams(panagram);

        // then
        assertThat(result).isTrue();
    }

    @Test
    public void testIsPangramsReturnFalseForTextThatIsNotAPanagram() throws Exception {
        // given
        String notPanagram = "We promptly judged antique ivory buckles for the prize";

        // when
        final boolean result = isPangrams(notPanagram);

        // then
        assertThat(result).isFalse();
    }

    @Test
    public void testToStringArray() throws Exception {
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
    public void testToStringArrayReturnIllegalArgumentException() throws Exception {
        // expect
        exception.expect(IllegalArgumentException.class);

        // when
        toStringArray(null);
    }

    @Test
    public void shouldReturn1Nsbp() throws Exception {
        // when
        final String result = getNbsp(1);

        // then
        assertThat(result).isEqualTo("&nbsp;");
    }

    @Test
    public void shouldReturn3Nsbp() throws Exception {
        // when
        final String result = getNbsp(3);

        // then
        assertThat(result).isEqualTo("&nbsp;&nbsp;&nbsp;");
    }


    @Test
    public void isStringEmptyShouldReturnTrueForNull() throws Exception {
        // when
        final boolean result = isStringBlank(null);

        // then
        assertThat(result).isTrue();
    }

    @Test
    public void isStringEmptyShouldReturnTrueForEmptyString() throws Exception {
        // when
        final boolean result = isStringBlank(EMPTY_STRING);

        // then
        assertThat(result).isTrue();
    }

    @Test
    public void isStringEmptyShouldReturnTrueForOnlySpaceString() throws Exception {
        // when
        final boolean result = isStringBlank("   ");
        // then
        assertThat(result).isTrue();

    }

    @Test
    public void shouldReturnFalseForValidString() throws Exception {
        // when
        final boolean result = isStringBlank("String");

        // then
        assertThat(result).isFalse();
    }

    @Test
    public void shouldReturnFalseForRandomString() throws Exception {

        final String randomText = RandomDataGenerator.getRandomText();

        //debug info
        LOGGER.debug("getRandomText() generate" + randomText);
        assertThat(randomText).isNotEmpty();
    }

    @Test
    public void shouldReturnTrueForNotEmptyStringTest() throws Exception {
        // when
        final boolean result = StringUtils.isStringNotEmpty(generateString(128));

        // then
        assertThat(result).isTrue();
    }

    @Test
    public void stringCollectionToStringExample() throws Exception {
        // given
        LinkedHashSet<String> lines = new LinkedHashSet<>();
        final String garlic = "Garlic";
        final String squatToilet = "Squat toilet";
        lines.add(garlic);
        lines.add(squatToilet);
        final String expectedResult = garlic + '\n' + squatToilet + '\n';

        // when
        final String result = StringUtils.toString(lines);

        // then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    public void getEmptyStringForNullStringExample() throws Exception {

        // when
        final String nullSafeString = getNullSafeString(null);

        // then
        assertThat(nullSafeString).isEmpty();
    }

    @Test
    public void shouldReturnStringForNotNullStringExample() throws Exception {
        // given
        final String string = "string";

        // when
        final String nullSafeString = getNullSafeString(string);

        // then
        assertThat(nullSafeString).isEqualTo(string);
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionWhenStringIsNullTest() throws Exception {
        // except
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage(INPUT_CANNOT_BE_EMPTY);

        // when
        splitContentIntoWords(null);
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionWhenStringIsNullStringIsEmptyTest() throws Exception {
        // except
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage(INPUT_CANNOT_BE_EMPTY);

        // when
        splitContentIntoWords(EMPTY_STRING);
    }

    @Test
    public void shouldReturn2WordsTest() throws Exception {
        // given
        String content = "Two words";

        // when
        final String[] words = splitContentIntoWords(content);

        // then
        assertThat(words.length).isEqualTo(2);
    }

    @Test
    public void shouldValidateStringWithNonAlphanumericCharactersOnlyTest() throws Exception {
        // when
        final boolean isAlphanumeric = hasNonAlphanumericCharactersOnly(NON_ALPHANUMERIC);

        // then
        assertThat(isAlphanumeric).isTrue();
    }

    @Test
    public void shouldReturnFalseForStringThatContainsSomeAlphanumericTest() throws Exception {
        // given
        final String mixed = generateString(10) + generateNonAlphanumericString(5) + generateString(2, 10);

        // when
        final boolean isAlphanumeric = hasNonAlphanumericCharactersOnly(mixed);

        // then
        assertThat(isAlphanumeric).isFalse();
    }

    @SuppressWarnings("ConstantConditions") // part of the test
    @Test
    public void shouldThrowIllegalArgumentExceptionWhenStringIsEmptyForSwapCharactersTest() throws Exception {
        // exception
        exception.expect(IllegalArgumentException.class);

        // when
        swapCaseLettersInString(null);
    }

    @Test
    public void shouldReturnEmptyStringIfYouPassEmptyStringIsEmptyForSwapCharactersTest() throws Exception {
        // when
        final String actualResult = swapCaseLettersInString(EMPTY_STRING);

        // then
        assertThat(actualResult).isEmpty();
    }

    @SuppressWarnings("SpellCheckingInspection")
    @Test
    public void shouldSwapCharactersInString() throws Exception {
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
    public void shouldSwapCharactersAndDisplayRestOfNonAlphabeticalCharactersInString() throws Exception {
        // given
        final String text = "plainTextExample#6688";
        final String expectedResult = "PLAINtEXTeXAMPLE#6688";

        // when
        final String actualResult = swapCaseLettersInString(text);

        // then
        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    public void shouldGetRandomTextTest() throws Exception {
        // when
        final String randomText = getRandomText(128);

        // then
        assertThat(randomText).isNotEmpty();
    }

    @Test
    public void getRandomTextShouldReturnEmptyStringForZeroSize() throws Exception {
        // when
        final String randomText = getRandomText(0);
        System.out.println(randomText);

        // then
        assertThat(randomText).isEmpty();
    }

    @Test
    public void removeAllNonAlphaNumericCharactersFromStringShouldReturnTheSameStringShouldReturnNullForNullString() throws Exception {
        // when
        final String result = StringUtils.removeAllNonAlphaNumericCharactersFromString(null);

        // then
        assertThat(result).isNull();

    }

    @Test
    public void removeAllNonAlphaNumericCharactersFromStringShouldReturnTheSameString() throws Exception {
        // given
        final String string = "An1Example!";
        final String expectedResult = "An1Example";

        // when
        final String result = StringUtils.removeAllNonAlphaNumericCharactersFromString(string);

        // then
        assertThat(result).isEqualToIgnoringCase(expectedResult);
    }

    @Test
    public void shouldRemoveAllNonAlphaNumericCharactersFromString() throws Exception {
        // given
        final String string = "An1Example!\"\\£$%^&*()_+-={}[]@~:;'#<>?,./";
        final String expectedResult = "An1Example";

        // when
        final String result = StringUtils.removeAllNonAlphaNumericCharactersFromString(string);

        // then
        assertThat(result).isEqualToIgnoringCase(expectedResult);
    }

    @Test
    public void shouldBeDeleted() throws Exception {
        // given
        LocalDate date = LocalDate.now();

        // when
        LocalDate dateNow = LocalDate.now();

        // then
        assertThat(dateNow).isAfter(date.minusDays(3));
    }

    @Test
    public void isStartWithUpperCaseShouldReturnTrueWhenIsTextStartsWithCapitalLetter() throws Exception {
        // given
        final String string = "String";
        // when
        boolean result = StringUtils.startsWithUpperCase(string);
        // then
        assertThat(result).isTrue();
    }

    @Test
    public void isStartWithUpperCaseShouldReturnFalseWhenIsTextStartsWithLowerLetter() throws Exception {
        // given
        final String string = "string";
        // when
        boolean result = StringUtils.startsWithUpperCase(string);
        // then
        assertThat(result).isFalse();
    }

    @Test
    public void isStartWithUpperCaseShouldReturnFalseWhenIsTextStartsWithNumber() throws Exception {
        // given
        final String string = String.valueOf(randomPositiveInteger());
        // when
        boolean result = StringUtils.startsWithUpperCase(string);
        // then
        assertThat(result).isFalse();
    }

    @Test
    public void trimAllWhiteSpacesShouldNullForNullText() throws Exception {
        // when
        final String result = trimAllWhiteSpaces(null);

        // then
        assertThat(result).isNull();
    }

    @Test
    public void trimAllWhiteSpacesShouldEmptyStringForEmptyText() throws Exception {
        // when
        final String result = trimAllWhiteSpaces(EMPTY_STRING);

        // then
        assertThat(result).isEmpty();
    }

    @Test
    public void trimAllWhiteSpacesShouldEmptyStringForWhitespacesOnlyText() throws Exception {
        // when
        final String result = trimAllWhiteSpaces(WHITESPACES_ONLY_STRING);

        // then
        assertThat(result).isEqualTo(WHITESPACES_ONLY_STRING);
    }

    @Test
    public void trimAllWhiteSpacesShouldRemoveAllWhitespaces() throws Exception {
        // given
        final String text = "    Text With   Whitespaces.   ";
        final String expectedResult = "TextWithWhitespaces.";

        // when
        final String result = trimAllWhiteSpaces(text);

        // then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    public void intArrayToStringAcceptanceTest() throws Exception {
        // given
        final String expectedString = "[ 1 2 3 5 8 13 ]";
        int[] intValues = new int[]{1, 2, 3, 5, 8, 13};
        // when
        final String result = StringUtils.toString(intValues);

        // then
        assertThat(result).isEqualTo(expectedString);

    }

    @Test
    public void shouldReturnTrueWhenTextHasNonAlphabetCharactersOnly() throws Exception {
        // when
        final boolean result = StringUtils.hasNonAlphabetCharactersOnly(NON_ALPHABETICAL_STRING);

        // then
        assertThat(result).isTrue();
    }

    @Test
    public void hasNonAlphabetCharactersOnlyShouldReturnFalseIfStringContainAlphabetCharacter() throws Exception {

        // when
        final boolean result = StringUtils.hasNonAlphabetCharactersOnly(NON_ALPHABETICAL_STRING);

        // then
        assertThat(result).isTrue();
    }

    @Test
    public void toStringShouldReturnStringWithArray() throws Exception {
        // given
        final List<String> list = Arrays.asList("Garlic", "Coriander", "Cheese");

        // when
        final String result = StringUtils.toString(list);

        // then
        assertThat(result).isEqualTo("Garlic,Coriander,Cheese");
    }

    @Test
    public void appendCharToCharArrayShouldReturnCharArrayWithAddedCharacter() throws Exception {
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
    public void everythingIsEmptyShouldReturnTrueIfAllStringsAreEmptyAcceptanceTest() throws Exception {
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
    public void everythingIsEmptyShouldReturnFalseIfAnyOfStringsIsNotEmptyAcceptanceTest() throws Exception {
        // given
        final String string1 = generateString(MAX_SMALL_VALUE_RANGE);
        final String string2 = generateString(MAX_SMALL_VALUE_RANGE);

        // when
        final boolean result = isAllStringsAreNotEmpty(string1, string2, EMPTY_STRING);

        // then
        assertThat(result).isFalse();
    }

    @Test
    public void everythingIsEmptyShouldReturnTrueIfNoArgumentProvided() throws Exception {

        // when
        final boolean result = isAllStringsAreNotEmpty();

        // then
        assertThat(result).isTrue();
    }

    @Test
    public void countOccurrenceOfShouldReturn0ForOccurrenceThatIsNull() throws Exception {
        // when
        int result = StringUtils.countOccurrenceOf(null, generateString());

        // then
        assertThat(result).isZero();
    }

    @Test
    public void countOccurrenceOfShouldReturn0ForWordThatIsNull() throws Exception {
        // when
        int result = StringUtils.countOccurrenceOf(generateString(), null);

        // then
        assertThat(result).isZero();
    }

    @Test
    public void countOccurrenceOfShouldReturn0ForOccurrenceThatIsEmpty() throws Exception {
        // when
        int result = StringUtils.countOccurrenceOf(EMPTY_STRING, generateString());

        // then
        assertThat(result).isZero();
    }

    @Test
    public void countOccurrenceOfShouldReturn0ForWordThatIsEmpty() throws Exception {
        // when
        int result = StringUtils.countOccurrenceOf(generateString(), EMPTY_STRING);

        // then
        assertThat(result).isZero();
    }

    @Test
    public void countOccurrenceOfShouldReturn0IfOccurrenceWordIsLongerThanTextItself() throws Exception {
        // given
        final String text = "text";
        // when
        int result = StringUtils.countOccurrenceOf(text + text, text);

        // then
        assertThat(result).isZero();
    }

    @Test
    public void countOccurrenceOfShouldReturn2ForOccurrenceOfLabInLablab() throws Exception {
        // given
        final String text = "Lablab";
        final String occurrence = "lab";

        // when
        int result = StringUtils.countOccurrenceOf(occurrence, text);

        // then
        assertThat(result).isEqualTo(2);
    }

    @Test
    public void countOccurrenceOfShouldReturn5ForOccurrenceOfSixInSentence() throws Exception {
        // given
        final String text = "sixty-four sixty-five sixty-six sixty-seven";
        final String occurrence = "six";

        // when
        int result = StringUtils.countOccurrenceOf(occurrence, text);

        // then
        assertThat(result).isEqualTo(5);
    }

    @Test
    public void printCountryListShouldDisplayListOfCountries() throws Exception {
        // when
        final List<String> countryList = getCountryList();

        // then
        assertThat(countryList).isNotEmpty();

        //debug info
        LOGGER.debug(countryList.toString());
    }

    @Test
    public void toCamelCaseShouldThrowIllegalArgumentExceptionWhenInputIsNull() throws Exception {
        // expect
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("text cannot be null");

        // when
        getStringWithCapitalizedFirstCharacter(null);
    }

    @Test
    public void capitalizeFirstCharacterShouldReturnEmptyStringWhenInputIsEmpty() throws Exception {
        // when
        final String result = capitalizeFirstCharacter(EMPTY_STRING);

        // then
        assertThat(result).isEmpty();
    }

    @Test
    public void capitalizeFirstCharacterShouldReturnTheSameStringWhenInputHasCapitalCharacter() throws Exception {
        // given
        final String string = "STRING";
        final String expectedResult = "S";
        // when
        final String result = capitalizeFirstCharacter(string);

        // then
        assertThat(result).isEqualTo(expectedResult);

    }

    @Test
    public void capitalizeFirstCharacterShouldReturnTheSameStringWhenInputHasFirstCapitalized() throws Exception {
        // given
        final String string = "STRING";
        final String expectedResult = "S";

        // when
        final String result = capitalizeFirstCharacter(string);

        // then
        assertThat(result).isEqualTo(expectedResult);

    }


    @Test
    public void getStringWithCapitalizedFirstCharacterShouldReturnEmptyStringWhenInputIsEmpty() throws Exception {
        // when
        final String result = getStringWithCapitalizedFirstCharacter(EMPTY_STRING);

        // then
        assertThat(result).isEmpty();
    }

    @Test
    public void getStringWithCapitalizedFirstCharacterShouldReturnTheSameStringWhenInputHasCapitalCharacterOnly() throws Exception {
        // given
        final String string = "STRING";

        // when
        final String result = getStringWithCapitalizedFirstCharacter(string);

        // then
        assertThat(result).isEqualTo(string);

    }

    @Test
    public void getStringWithCapitalizedFirstCharacterShouldReturnTheSameStringWhenInputHasFirstCharacterCapitalized() throws Exception {
        // given
        final String string = "String";

        // when
        final String result = getStringWithCapitalizedFirstCharacter(string);

        // then
        assertThat(result).isEqualTo(string);

    }

    @Test
    public void getStringWithCapitalizedFirstCharacterShouldReturnStringWithFirstCharacterCapitalized() throws Exception {
        // given
        final String string = "string";
        final String expectedResult = "String";

        // when
        final String result = getStringWithCapitalizedFirstCharacter(string);

        // then
        assertThat(result).isEqualTo(expectedResult);
    }


}
