package dms.pastor.utils;

import dms.pastor.domain.Country;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.lang.Character;
import java.math.BigDecimal;
import java.util.List;
import java.util.Random;

import static dms.pastor.utils.RandomDataGenerator.*;
import static dms.pastor.utils.StringUtils.hasNonAlphabetCharactersOnly;
import static java.lang.Character.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;

/**
 * Author Dominik Symonowicz
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
public class RandomDataGeneratorTest {
    private static final int RANDOM_STRING_LENGTH = 1024;
    private static final String SPACE = " ";
    private final Random random = new Random();

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void testGenerateRandomIntValues() throws Exception {
        // given
        int size = 10;

        // when
        int[] intValues = generateRandomIntValues(size);

        // then
        Assert.assertThat(intValues.length, is(size));
    }

    @Test
    public void testGetRandomCharacter() throws Exception {
        // when
        Character randomCharacter = getRandomCharacterFromAlphabet();

        // then
        Assert.assertThat(isLetter(randomCharacter), is(true));
    }

    @Test
    public void testGetRandomCharacterAsString() throws Exception {
        // when
        String randomCharacterAsString = getRandomCharacterAsString();

        // then
        Assert.assertThat(isLetter(randomCharacterAsString.charAt(0)), is(true));
    }

    @Test
    public void testGetRandomTextWithoutMaxLength() throws Exception {
        // when
        final String text = getRandomText();

        // then
        Assert.assertThat("Text dictSize is out of range: " + text.length(), 1 <= text.length() && text.length() <= 1000, is(true));
    }

    @Test
    public void shouldGenerateRandomStringOfLengthBetween4And10Test() throws Exception {
        // when
        final String string = generateString(4, 10);

        // then
        assertThat(string.length()).isGreaterThanOrEqualTo(4);
        assertThat(string.length()).isLessThanOrEqualTo(10);
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionWhenMinValueIsHigherThanMinForGenerateStringTest() throws Exception {
        // except
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Value must be higher than zero and min value must be smaller is larger than max value");

        // when

        final int max = random.nextInt(RANDOM_STRING_LENGTH);
        final int min = random.nextInt(RANDOM_STRING_LENGTH) + max;

        generateString(min, max);
    }

    /*
    java.lang.AssertionError: Expected test to throw (an instance of java.lang.IllegalArgumentException and exception with message a string containing "Value must be higher than zero and min value must be smaller is larger than max value")

	at org.junit.Assert.fail(Assert.java:88)
	at org.junit.rules.ExpectedException.failDueToMissingException(ExpectedException.java:263)
	at org.junit.rules.ExpectedException.access$200(ExpectedException.java:106)
	at org.junit.rules.ExpectedException$ExpectedExceptionStatement.evaluate(ExpectedException.java:245)
	at org.junit.rules.RunRules.evaluate(RunRules.java:20)
	at org.junit.runners.ParentRunner.runLeaf(ParentRunner.java:325)
	at org.junit.runners.BlockJUnit4ClassRunner.runChild(BlockJUnit4ClassRunner.java:78)
	at org.junit.runners.BlockJUnit4ClassRunner.runChild(BlockJUnit4ClassRunner.java:57)
	at org.junit.runners.ParentRunner$3.run(ParentRunner.java:290)
	at org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:71)
	at org.junit.runners.ParentRunner.runChildren(ParentRunner.java:288)
	at org.junit.runners.ParentRunner.access$000(ParentRunner.java:58)
	at org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:268)
	at org.junit.runners.ParentRunner.run(ParentRunner.java:363)
	at org.junit.runners.Suite.runChild(Suite.java:128)
	at org.junit.runners.Suite.runChild(Suite.java:27)
	at org.junit.runners.ParentRunner$3.run(ParentRunner.java:290)
	at org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:71)
	at org.junit.runners.ParentRunner.runChildren(ParentRunner.java:288)
	at org.junit.runners.ParentRunner.access$000(ParentRunner.java:58)
	at org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:268)
	at org.junit.runners.ParentRunner.run(ParentRunner.java:363)
	at org.junit.runner.JUnitCore.run(JUnitCore.java:137)
	at com.intellij.junit4.JUnit4IdeaTestRunner.startRunnerWithArgs(JUnit4IdeaTestRunner.java:68)
	at com.intellij.rt.execution.junit.IdeaTestRunner$Repeater.startRunnerWithArgs(IdeaTestRunner.java:58)
	at com.intellij.rt.execution.junit.JUnitStarter.prepareStreamsAndStart(JUnitStarter.java:237)
	at com.intellij.rt.execution.junit.JUnitStarter.main(JUnitStarter.java:70)
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:497)
	at com.intellij.rt.execution.application.AppMain.main(AppMain.java:147)
     */
    @Test //TODO FIX IT
    public void shouldThrowIllegalArgumentExceptionForNegativeMinValueTest() throws Exception {
        // except
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Value must be higher than zero and min value must be smaller is larger than max value");

        // when
        final int negativeNumber = new BigDecimal(random.nextInt(RANDOM_STRING_LENGTH)).negate().intValue();
        generateString(negativeNumber, 4);
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionForNegativeMaxValueTest() throws Exception {
        // except
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Value must be higher than zero and min value must be smaller is larger than max value");

        // when
        final int negativeNumber = new BigDecimal(random.nextInt(RANDOM_STRING_LENGTH)).negate().intValue();
        generateString(4, negativeNumber);
    }

    @Test
    public void shouldGenerateIntArrayTest() throws Exception {
        // given
        int size = 10;

        // when
        final int[] intArray = generateIntArray(size, 10);
        // then
        Assert.assertThat(intArray.length, is(size));
        for (int i : intArray) {
            Assert.assertThat(i <= 10 && i >= 0, is(true));
        }
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionForNegativeSizeTest() throws Exception {
        // except
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Size must be bigger than zero!");

        // when
        generateStringList(-1);
    }

    @Test
    public void generateStringStringShouldReturnStringList() throws Exception {
        // given
        final int arraySize = 10;

        // when
        final List<String> stringList = generateStringList(arraySize);

        // then
        assertThat(stringList).hasSize(arraySize);
        for (String string : stringList) {
            assertThat(string).isNotEmpty();
        }
    }

    @Test //TODO improve it this rubbish
    public void generateStringListTest() throws Exception {

        // when
        final List<String> stringList = generateStringList(0);

        // then
        Assert.assertThat(stringList.isEmpty(), is(true));
    }

    @Test
    public void shouldGenerateRandomEmailTest() throws Exception {
        // given

        // when
        final String email = generateEmail();

        // then
        assertThat(email).isNotEmpty();
        assertThat(email).contains("@");
        assertThat(email).contains(".");
    }

    @Test
    public void generateStringArrayShouldThrowIllegalArgumentExceptionForNegativeTest() throws Exception {
        // except
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Size must be zero or higher in order to create an array.");

        // when
        generateArray(-1);
    }

    @Test
    public void generateStringArrayShouldReturnStringArray() throws Exception {
        // given
        final int arraySize = 10;

        // when
        final String[] strings = generateArray(arraySize);

        // then
        assertThat(strings).hasSize(arraySize);
        for (String string : strings) {
            assertThat(string).isNotEmpty();
        }
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionIfSizeIsBelowZeroTest() throws Exception {
        // except
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Size of string must be greater than zero");

        // when
        generateNonAlphanumericString(-1);

    }

    @Test
    public void shouldThrowIllegalArgumentExceptionIfSizeIsZeroTest() throws Exception {
        // except
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Size of string must be greater than zero");

        // when
        generateNonAlphanumericString(0);

    }

    @Test
    public void shouldReturnStringWithNonAlphanumericCharactersTest() throws Exception {
        // except
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Size of string must be greater than zero");

        // when
        final String string = generateNonAlphanumericString(-1);

        // then
        assertThat(string).isNotNull();
        assertThat(hasNonAlphabetCharactersOnly(string)).isFalse(); //bad testing
    }

    @Test
    public void shouldReturnIntArray() {
        // when
        final int size = 10;
        final int numberRange = 10;
        final int[] ints = generateIntArray(size, numberRange);

        // then
        assertThat(ints).hasSize(size);
    }

    @Test
    public void shouldGenerateStringListTest() throws Exception {
        // when
        final List<String> stringList = generateStringList();

        // then
        assertThat(stringList).isNotEmpty();
        assertThat(stringList.size()).isGreaterThanOrEqualTo(4);
    }

    @Test
    public void shouldReturnRandomCountryTest() throws Exception {
        // when
        Country country = getRandomCountry();

        // then
        Assert.assertThat(country, notNullValue());
    }

    @Test //TODO investigate as length was 6 that is not greater than 10
    public void shouldReturnParagraph() throws Exception {

        // when
        final String result = generateRandomParagraph();

        // then
        assertThat(result).isNotNull();
        assertThat(result.length()).isGreaterThan(10);
        System.out.println(result);

    }

    @Test
    public void shouldGenerateFirstNameAcceptanceTest() throws Exception {
        // when
        final String result = generateFirstName();

        // then
        assertThat(result).isNotEmpty();
    }

    @Test
    public void shouldGenerateSurnameAcceptanceTest() throws Exception {
        // when
        final String result = generateSurname();

        // then
        assertThat(result).isNotEmpty();
    }


    //TODO @Test public void randomIntegerExcludingShouldReturnUniqueNumber() throws Exception {


    @Test
    public void randomIntegerWithMinAndMaxValueShouldThrowExceptionWhenMinValueIsHigherThanMaxValue() throws Exception {
        // given
        int maxValue = randomInteger(MAX_SMALL_VALUE);
        int minValue = maxValue + randomInteger(1, MAX_SMALL_VALUE);

        // expect
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("MinValue (" + minValue + ") must be lower than MaxValue(" + maxValue + ")");

        // when
        randomInteger(minValue, maxValue);
    }

    @Test
    public void randomIntegerWithMinAndMaxValueShouldReturnValueInRange() throws Exception {
        // given
        int minValue = randomInteger(MAX_SMALL_VALUE);
        int maxValue = minValue + randomInteger(1, 1 + MAX_SMALL_VALUE);

        // when
        final int number = randomInteger(minValue, maxValue);

        // then
        assertThat(number).isBetween(minValue, maxValue);
    }

    @Test
    public void randomIntegerWithEqualMinAndMaxValueShouldReturnThatValue() throws Exception {
        // given
        int value = randomInteger(MAX_SMALL_VALUE);

        // when
        final int number = randomInteger(value, value);

        // then
        assertThat(number).isEqualTo(value);
    }

    @Test
    public void randomNegativeIntegerShouldReturnNegativeInteger() throws Exception {

        // when
        final int negativeInteger = randomNegativeInteger();

        // then
        assertThat(negativeInteger).isNegative();

    }

    @Test
    public void generateNonAlphanumericStringShouldGenerateString() throws Exception {
        // when
        final String nonAlphanumericString = generateNonAlphanumericString(2);

        // then
        final char[] chars = nonAlphanumericString.toCharArray();
        assertThat(isAlphabetic(chars[0])).isFalse();
        assertThat(isAlphabetic(chars[1])).isFalse();
        assertThat(isDigit(chars[0])).isFalse();
        assertThat(isDigit(chars[1])).isFalse();
    }

    @Test
    public void shouldGetRandomPositiveBigDecimal() throws Exception {
        // when
        final BigDecimal positiveBigDecimal = RandomDataGenerator.randomPositiveBigDecimal();

        // then
        assertThat(positiveBigDecimal).isPositive();
    }

    @Test
    public void shouldGetRandomNegativeBigDecimal() throws Exception {
        // when
        final BigDecimal negativeBigDecimal = RandomDataGenerator.randomNegativeBigDecimal();

        // then
        assertThat(negativeBigDecimal).isNegative();
    }

    @Test // TODO how to test it ?
    public void shouldReturnRandomInteger() throws Exception {

        // when
        final int integer = RandomDataGenerator.randomInteger();
    }

    @Test
    public void generateWordsShouldThrowIllegalArgumentExceptionIfValueIsNegative() throws Exception {
        // expect
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Value cannot be negative");
        
        // when
        generateWords(-1);
    }

    @Test
    public void generateWordsShouldReturnEmptyStringForSizeZero() throws Exception {
        // given
        final int zeroSize = 0;
        // when
        final String result = generateWords(zeroSize);

        //then
        assertThat(result).isEmpty();
    }

    @Test
    public void generateWordsShouldReturnEmptyStringForSizeOne() throws Exception {
        // given
        final int size = 1;

        // when
        final String result = generateWords(size);

        //then
        assertThat(result).isNotEmpty();
        assertThat(result).doesNotEndWith(SPACE);
    }

    @Test
    public void generateWordsShouldReturnEmptyStringForFiveWords() throws Exception {
        // given
        final int size = 5;

        // when
        final String result = generateWords(size);

        //then
        assertThat(result).isNotEmpty();
        assertThat(result).contains(SPACE);
        assertThat(result).doesNotEndWith(SPACE);
    }
}
