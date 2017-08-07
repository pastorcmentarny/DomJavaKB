package dms.pastor.utils;

import dms.pastor.utils.randoms.RandomDataGenerator;
import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.Assert;
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
import static java.util.Collections.emptyList;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.hamcrest.CoreMatchers.is;

/**
 * Author Dominik Symonowicz
 * Created 2015-10-31
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class StringUtilsTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(StringUtilsTest.class);

    private static final String NON_ALPHABETICAL_STRING = "&07";
    private static final String EMPTY_STRING = "";
    private static final String PALINDROME = "abcdcba";
    private static final String NOT_PALINDROME = "abcdef";
    private static final String PALINDROME_AFTER_PERMUTATION = "abcdabcd";
    private static final String SPACE_CHARACTER = " ";
    private static final String WHITESPACES_ONLY_STRING = "                    ";

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void testGetRandomCharacter() throws Exception {
        Character randomCharacter = getRandomCharacter();
        Assert.assertThat("It is a random character", isLetter(randomCharacter), is(true));
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
        Assert.assertThat("It is a palindrome", isPalindromeString(PALINDROME), is(true));
    }

    @Test
    public void testStringShouldNotBePalindrome() throws Exception {
        Assert.assertFalse("It is NOT a palindrome", isPalindromeString(NOT_PALINDROME));
    }

    @Test
    public void testShouldBeAPalindromeForPermutableString() throws Exception {
        Assert.assertThat("It is a palindrome ", isPalindromeOfAnyPermutationString(PALINDROME_AFTER_PERMUTATION), is(true));
    }

    @Test
    public void testShouldBePalindromeString() throws Exception {
        Assert.assertThat("It is a palindrome", isPalindromeOfAnyPermutationString(PALINDROME), is(true));
    }

    @Test
    public void testItIsNotAPermutableString() {
        Assert.assertFalse("It is not a permutable palindrome string", isPalindromeOfAnyPermutationString(NOT_PALINDROME));
    }

    @Test
    public void testShouldBeLetterOnlyString() throws Exception {
        Assert.assertThat("String that contains letters only", isAlpha("ThisStringContainsLettersOnly"), is(true));
    }

    @Test
    public void testShouldReturnFalseForStringWithNonLetterCharacters() throws Exception {
        Assert.assertFalse("String contains non letters character", isAlpha("ThisStringHasNumbers1234567890asWell"));
    }

    @Test
    public void testIsPangramsReturnTrue() throws Exception {
        String panagram = "The quick brown fox jumps over the lazy dog";
        Assert.assertThat(StringUtils.isPangrams(panagram), is(true));
    }

    @Test
    public void testIsPangramsReturnFalseForTextThatIsNotAPanagram() throws Exception {
        String notPanagram = "We promptly judged antique ivory buckles for the prize";
        Assert.assertFalse(StringUtils.isPangrams(notPanagram));
    }

    @Test
    public void testToStringArray() throws Exception {
        String[] answer = new String[]{"London", "Tianjin", "Wrocław"};
        List<String> stringList = new ArrayList<>();
        stringList.add("London");
        stringList.add("Tianjin");
        stringList.add("Wrocław");
        Assert.assertThat(toStringArray(stringList), is(answer));
    }

    //it is purpose of test
    @Test
    public void testToStringArrayReturnIllegalArgumentException() throws Exception {
        // except
        exception.expect(IllegalArgumentException.class);

        //when
        toStringArray(null);
    }

    @Test
    public void shouldReturn1Nsbp() throws Exception {
        final String result = getNbsp(1);
        Assert.assertThat(result, is("&nbsp;"));
    }

    @Test
    public void shouldReturn3Nsbp() throws Exception {
        final String result = getNbsp(3);
        Assert.assertEquals("&nbsp;&nbsp;&nbsp;", result);
    }

    @Test
    public void shouldReturnTrueForContainsOnlyAInAAA() throws Exception {
        Assert.assertThat("A is in AAA", containsOnly("AAA", new char[]{'A'}), is(true));
    }

    @Test
    public void shouldReturnFalseForJonInJohn() throws Exception {
        Assert.assertFalse("Sara in Sarah", containsOnly("Sarah", new char[]{'S', 'a', 'r', 'a'}));
    }

    @Test
    public void shouldReturnFalseForNullInputString() throws Exception {
        Assert.assertFalse("Null", containsOnly(null, new char[]{'S', 'a', 'r', 'a'}));
    }

    @Test
    public void shouldReturnFalseForNullCharacterArray() throws Exception {
        Assert.assertFalse("Null", containsOnly("Word", null));
    }

    @Test
    public void isStringEmptyShouldReturnTrueForNull() throws Exception {
        Assert.assertThat("Null", isStringBlank(null), is(true));
    }

    @Test
    public void isStringEmptyShouldReturnTrueForEmptyString() throws Exception {
        Assert.assertThat("Empty", isStringBlank(""), is(true));
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
        Assert.assertFalse("Valid String", isStringBlank("String"));
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
        final boolean isNotEmpty = StringUtils.isStringNotEmpty(generateString(128));

        // then
        Assert.assertThat(isNotEmpty, is(true));
    }

    @Test
    public void stringCollectionToStringExample() throws Exception {
        // given
        LinkedHashSet<String> lines = new LinkedHashSet<>();
        final String garlic = "Garlic";
        final String squatToilet = "Squat toilet";
        lines.add(garlic);
        lines.add(squatToilet);

        // when
        final String linesAsString = StringUtils.toString(lines);

        // then
        Assert.assertEquals(garlic + '\n' + squatToilet + '\n', linesAsString);

    }

    @Test
    public void getEmptyStringForNullStringExample() throws Exception {

        // when
        final String nullSafeString = getNullSafeString(null);

        // then
        Assert.assertEquals("", nullSafeString);
    }

    @Test
    public void shouldReturnStringForNotNullStringExample() throws Exception {
        // given
        final String string = "string";

        // when
        final String nullSafeString = getNullSafeString(string);

        // then
        Assert.assertEquals("string", nullSafeString);
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
        splitContentIntoWords("");
    }

    @Test
    public void shouldReturn2WordsTest() throws Exception {
        // given
        String content = "Two words";

        // when
        final String[] words = splitContentIntoWords(content);

        // then
        Assert.assertEquals(2, words.length);
    }

    @Test
    public void shouldReturnTrueForSpaceCharacterOnlyInStringTest() throws Exception {
        // given

        // when
        final boolean hasSpaceOnly = isContainSpace(SPACE_CHARACTER);

        // then
        Assert.assertThat(hasSpaceOnly, is(true));
    }

    @Test
    public void shouldReturnTrueForSpaceCharactersOnlyInStringTest() throws Exception {
        // given

        // when
        final boolean hasSpaceOnly = isContainSpace(WHITESPACES_ONLY_STRING);

        // then
        Assert.assertThat(hasSpaceOnly, is(true));
    }

    @Test
    public void shouldReturnFalseIfYouPassNullToHasSpaceOnlyTest() throws Exception {
        // when
        final boolean hasSpaceOnly = isContainSpace(null);

        // then
        Assert.assertFalse(hasSpaceOnly);
    }

    @Test
    public void shouldReturnFalseIfYouPassEmptyStringToHasSpaceOnlyTest() throws Exception {
        // when
        final boolean hasSpaceOnly = isContainSpace("");

        // then
        Assert.assertFalse(hasSpaceOnly);
    }

    @Test
    public void shouldReturnFalseIfInputContainsNotOnlySpaceInHasSpaceOnlyTest() throws Exception {
        // given
        final String space = " A B  CC   Garlic ";

        // when
        final boolean hasSpaceOnly = isContainSpace(space);

        // then
        Assert.assertFalse(hasSpaceOnly);
    }

    @Test
    public void shouldValidateStringWithNonAlphanumericCharactersOnlyTest() throws Exception {
        // when
        final boolean isAlphanumeric = hasNonAlphanumericCharactersOnly(NON_ALPHANUMERIC);

        // then
        Assert.assertThat(isAlphanumeric, is(true));
    }

    @Test
    public void shouldReturnFalseForStringThatContainsSomeAlphanumericTest() throws Exception {
        // given
        final String mixed = generateString(10) + generateNonAlphanumericString(5) + generateString(2, 10);

        // when
        final boolean isAlphanumeric = hasNonAlphanumericCharactersOnly(mixed);

        // then
        Assert.assertFalse(isAlphanumeric);
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
        assertThat(exists).isTrue();
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
        final String actualResult = swapCaseLettersInString("");

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
        AssertionsForClassTypes.assertThat(result).isEqualTo(expectedString);

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
        final String string1 = generateString(MAX_SMALL_VALUE);
        final String string2 = generateString(MAX_SMALL_VALUE);
        final String string3 = generateString(MAX_SMALL_VALUE);

        // when
        final boolean result = isAllStringsAreNotEmpty(string1, string2, string3);

        // then
        assertThat(result).isTrue();
    }

    @Test
    public void everythingIsEmptyShouldReturnFalseIfAnyOfStringsIsNotEmptyAcceptanceTest() throws Exception {
        // given
        final String string1 = generateString(MAX_SMALL_VALUE);
        final String string2 = generateString(MAX_SMALL_VALUE);

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
    public void getStringWithCapitalizedFirstCharacterShouldReturnTheSameStringWhenInputHasCapitalCharacterdOnly() throws Exception {
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
