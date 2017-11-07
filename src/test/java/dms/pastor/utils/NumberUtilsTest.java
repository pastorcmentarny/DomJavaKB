package dms.pastor.utils;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static dms.pastor.TestConfig.EMPTY_INTEGER_ARRAY;
import static dms.pastor.utils.NumberUtils.*;
import static dms.pastor.utils.randoms.RandomDataGenerator.*;
import static dms.pastor.utils.string.ContainsInStringUtils.containsOnly;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author Dominik Symonowicz
 * Created 09.10.2012
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
@SuppressWarnings("MagicNumber") // because there are specific numbers
public class NumberUtilsTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(NumberUtilsTest.class);

    private static final int MIN_VALUE = 5;
    private static final int MAX_VALUE = 20;
    private final Random random = new Random();

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void getResultInRangeShouldReturn10For10InRangeBetween5And20() throws Exception {
        // given
        final int value = 10;

        // when
        final int result = getResultInRange(value, MIN_VALUE, MAX_VALUE);

        // then
        assertThat(result).isEqualTo(value);
    }

    @Test
    public void getResultInRangeShouldReturn5For5InRangeBetween5And20() throws Exception {
        // given
        final int value = MIN_VALUE;

        // when
        final int result = getResultInRange(value, MIN_VALUE, MAX_VALUE);

        // then
        assertThat(result).isEqualTo(value);
    }

    @Test
    public void getResultInRangeShouldReturn20For20InRangeBetween5And20() throws Exception {
        // given
        final int value = MAX_VALUE;

        // when
        final int result = getResultInRange(value, MIN_VALUE, MAX_VALUE);

        // then
        assertThat(result).isEqualTo(value);
    }

    @Test
    public void getResultInRangeShouldReturn5For0InRangeBetween5And20() throws Exception {
        // given
        final int value = 0;

        // when
        final int result = getResultInRange(value, MIN_VALUE, MAX_VALUE);

        // then
        assertThat(result).isEqualTo(MIN_VALUE);
    }

    @Test
    public void getResultInRangeShouldReturn25For0InRangeBetween5And20() throws Exception {
        // given
        final int value = 25;

        // when
        final int result = getResultInRange(value, MIN_VALUE, MAX_VALUE);

        // then
        assertThat(result).isEqualTo(MAX_VALUE);
    }

    @Test
    public void testShouldReturn100For104() throws Exception {
        final int result = getResultIn0to100Range(104);
        assertThat(result).isEqualTo(100);
    }

    @Test
    public void testShouldReturn0ForMinusTen() throws Exception {
        final int result = getResultIn0to100Range(-10);
        assertThat(result).isZero();
    }

    @Test
    public void testShouldReturn20For20() throws Exception {
        final int result = getResultIn0to100Range(20);
        assertThat(result).isEqualTo(20);
    }

    @Test
    public void getFibonacciForShouldReturnZeroForZero() throws Exception {
        final long result = getFibonacciNumberFor(0);
        assertThat(result).isZero();
    }

    @Test
    public void getFibonacciForShouldReturnOneForOne() throws Exception {
        final long result = getFibonacciNumberFor(1);
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void getFibonacciForShouldReturnOneForTwo() throws Exception {
        final long result = getFibonacciNumberFor(2);
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void getFibonacciForShouldReturnTwoForThree() throws Exception {
        final long result = getFibonacciNumberFor(3);
        assertThat(result).isEqualTo(2);
    }

    @Test
    public void getFibonacciForShouldReturnThreeForFour() throws Exception {
        final long result = getFibonacciNumberFor(4);
        assertThat(result).isEqualTo(3);
    }

    @Test
    public void getFibonacciForShouldReturnFiveForFive() throws Exception {
        final long result = getFibonacciNumberFor(5);
        assertThat(result).isEqualTo(5);
    }

    @Test
    public void getFibonacciForShouldReturnFiftyFiveForTen() throws Exception {
        final long result = getFibonacciNumberFor(10);
        assertThat(result).isEqualTo(55);
    }

    @Test
    public void testShouldReturn120Factorial5() throws Exception {
        final int result = factorial(5);
        assertThat(result).isEqualTo(120);
    }

    @Test
    public void testShouldReturnMinus120FactorialMinus5() throws Exception {
        final int result = factorial(5);
        assertThat(result).isEqualTo(120);
    }

    @SuppressWarnings("ResultOfMethodCallIgnored")// because result doesn't matter in this case
    @Test
    public void testShouldThrowExceptionFor20() throws Exception {
        //except
        exception.expect(IllegalArgumentException.class);

        // when
        factorial(20);
    }

    @Test
    public void testGetSmallestInt() throws Exception {
        final int result = getSmallestInt(new int[]{15, 12, 22, 10, 14, 20});
        assertThat(result).isEqualTo(10);
    }

    @Test
    public void testGetSmallestIntForNegativeNumbers() throws Exception {
        final int result = getSmallestInt(new int[]{-15, -12, -22, -10, -14, -20});
        assertThat(result).isEqualTo(-22);
    }

    @Test
    public void testGetSmallestIntForMixedNumbers() throws Exception {
        final int result = getSmallestInt(new int[]{15, -12, 22, -10, 14, -20});
        assertThat(result).isEqualTo(-20);
    }

    @SuppressWarnings("ConstantConditions") // part of the test
    @Test(expected = IllegalArgumentException.class)
    public void testGetIllegalExceptionForNullInputForSmallestInt() throws Exception {
        getSmallestInt(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetIllegalExceptionForEmptyInputForSmallestInt() throws Exception {
        getSmallestInt(EMPTY_INTEGER_ARRAY);
    }

    @Test
    public void testGetLargestInt() throws Exception {
        final int result = getLargestInt(new int[]{15, 12, 22, 10, 14, 20});
        assertThat(result).isEqualTo(22);
    }

    @Test
    public void testGetLargestNegativeInt() throws Exception {
        final int result = getLargestInt(new int[]{-15, -12, -22, -10, -14, -20});
        assertThat(result).isEqualTo(-10);
    }

    @Test
    public void testGetLargestMixedInt() throws Exception {
        final int result = getLargestInt(new int[]{15, -12, 22, -10, 14, -20});
        assertThat(result).isEqualTo(22);
    }

    @SuppressWarnings("ConstantConditions") // part of the test
    @Test(expected = IllegalArgumentException.class)
    public void testGetIllegalExceptionForNullInputForLargestInt() throws Exception {
        getLargestInt(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetIllegalExceptionForEmptyInputForLargestInt() throws Exception {
        getLargestInt(EMPTY_INTEGER_ARRAY);
    }

    @Test
    public void testReverseANumber() throws Exception {
        // given
        int question = 12345;
        int answer = 54321;

        // when
        final int result = reverseANumber(question);

        // then
        assertThat(result).isEqualTo(answer);
    }

    @Test //TODO improve it as I think looping and asserting is a bad thing
    public void testIsNumberPrime() throws Exception {
        // given
        int[] primes = new int[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97};

        for (int i : primes) {
            final boolean result = isPrime(i);
            assertThat(result).isTrue();
        }
    }

    @Test
    public void testIsNotNumberPrime() throws Exception {
        int[] notPrimes = new int[]{4, 6, 8, 10, 20, 50, 100};
        for (int i : notPrimes) {
            assertThat(isPrime(i)).isFalse();
        }
    }

    @Test
    public void testIsNotNumberWhenValueIsZeroPrime() throws Exception {
        final boolean result = isPrime(0);
        assertThat(result).isFalse();
    }

    @Test
    public void getNullIfValueIsBelow0() {
        final String result = getShortAs8BitRepresentation(-10);
        assertThat(result).isNull();
    }

    @Test
    public void getNullIfValueIsAbove255() {
        final int max8BitValue = 256;
        final int randomNumber = new Random().nextInt(Integer.MAX_VALUE - max8BitValue) + 255;
        final String result = getShortAs8BitRepresentation(randomNumber);
        assertThat(result).isNull();
    }

    @Test //done as part of learning of basic of TDD in 2012
    public void getShortAs8BitRepresentationFor0() {
        final String result = getShortAs8BitRepresentation(0);
        assertThat(result).isEqualTo("00000000");
    }

    @Test //done as part of learning of basic of TDD in 2012
    public void getShortAs8BitRepresentationFor1() {
        final String result = getShortAs8BitRepresentation(1);
        assertThat(result).isEqualTo("00000001");
    }

    @Test //done as part of learning of basic of TDD in 2012
    public void getShortAs8BitRepresentationFor2() {
        final String result = getShortAs8BitRepresentation(2);
        assertThat(result).isEqualTo("00000010");
    }

    @Test //done as part of learning of basic of TDD in 2012
    public void getShortAs8BitRepresentationFor3() {
        final String result = getShortAs8BitRepresentation(3);
        assertThat(result).isEqualTo("00000011");
    }

    @Test //done as part of learning of basic of TDD in 2012
    public void getShortAs8BitRepresentationFor4() {
        final String result = getShortAs8BitRepresentation(4);
        assertThat(result).isEqualTo("00000100");
    }

    @Test //done as part of learning of basic of TDD in 2012
    public void getShortAs8BitRepresentationFor5() {
        final String result = getShortAs8BitRepresentation(5);
        assertThat(result).isEqualTo("00000101");
    }

    @Test //done as part of learning of basic of TDD in 2012
    public void getShortAs8BitRepresentationFor7() {
        final String result = getShortAs8BitRepresentation(7);
        assertThat(result).isEqualTo("00000111");
    }

    @Test //done as part of learning of basic of TDD in 2012
    public void getShortAs8BitRepresentationFor8() {
        final String result = getShortAs8BitRepresentation(8);
        assertThat(result).isEqualTo("00001000");
    }

    @Test //done as part of learning of basic of TDD in 2012
    public void getShortAs8BitRepresentationFor13() {
        final String result = getShortAs8BitRepresentation(13);
        assertThat(result).isEqualTo("00001101");
    }

    @Test //done as part of learning of basic of TDD in 2012
    public void getShortAs8BitRepresentationFor15() {
        final String result = getShortAs8BitRepresentation(15);
        assertThat(result).isEqualTo("00001111");
    }

    @Test //done as part of learning of basic of TDD in 2012
    public void getShortAs8BitRepresentationFor16() {
        final String result = getShortAs8BitRepresentation(16);
        assertThat(result).isEqualTo("00010000");
    }

    @Test //done as part of learning of basic of TDD in 2012
    public void getShortAs8BitRepresentationFor17() {
        final String result = getShortAs8BitRepresentation(17);
        assertThat(result).isEqualTo("00010001");
    }

    @Test //done as part of learning of basic of TDD in 2012
    public void getShortAs8BitRepresentationFor32() {
        final String result = getShortAs8BitRepresentation(32);
        assertThat(result).isEqualTo("00100000");
    } //done as part of learning of basic of TDD in 2012

    @Test
    public void getShortAs8BitRepresentationFor64() {
        final String result = getShortAs8BitRepresentation(64);
        assertThat(result).isEqualTo("01000000");
    } //done as part of learning of basic of TDD in 2012

    @Test //done as part of learning of basic of TDD in 2012
    public void getShortAs8BitRepresentationFor100() {
        final String result = getShortAs8BitRepresentation(100);
        assertThat(result).isEqualTo("01100100");
    }

    @Test //done as part of learning of basic of TDD in 2012
    public void getShortAs8BitRepresentationFor128() {
        final String result = getShortAs8BitRepresentation(128);
        assertThat(result).isEqualTo("10000000");
    }

    @Test //done as part of learning of basic of TDD in 2012
    public void getShortAs8BitRepresentationFor200() {
        final String result = getShortAs8BitRepresentation(200);
        assertThat(result).isEqualTo("11001000");
    }

    @Test //done as part of learning of basic of TDD in 2012
    public void getShortAs8BitRepresentationFor250() {
        final String result = getShortAs8BitRepresentation(250);
        assertThat(result).isEqualTo("11111010");
    }

    @Test //done as part of learning of basic of TDD in 2012
    public void getShortAs8BitRepresentationFor255() {
        final String result = getShortAs8BitRepresentation(255);
        assertThat(result).isEqualTo("11111111");
    }

    //FIXME assertion part is done wrong. I think Uncle Bob will excommunicate me as developer for this test
    @Test //done as part of learning of basic of TDD in 2012
    public void getShortAs8BitRepresentationForRandomNumberBetween0And255() {
        final int randomValue = random.nextInt(255);
        final String bitRepresentation = getShortAs8BitRepresentation(randomValue);
        assertThat(bitRepresentation != null ? bitRepresentation.length() : 0).isEqualTo(8);
        assertThat(bitRepresentation).isNotNull();
        assertThat(containsOnly(bitRepresentation, new char[]{'0', '1'})).isTrue();
    }

    @Test
    public void shouldGetCurrentMaxValueTest() throws Exception {
        // given
        final float newValue = 10f;
        final float currentMaxValue = 12f;

        // when
        final float result = getMaxValue(newValue, currentMaxValue);

        // then
        assertThat(result).isEqualTo(12f);
    }

    @Test
    public void shouldGetNewValueAsMaxValueTest() throws Exception {
        // given
        final float newValue = 13f;
        final float currentMaxValue = 12f;

        // when
        final float result = getMaxValue(newValue, currentMaxValue);

        // then
        assertThat(result).isEqualTo(13f);
    }

    @Test
    public void shouldNotChangeMaxValueIfIsEqualToNewValueTest() throws Exception {
        // given
        final float newValue = 8f;
        final float currentMaxValue = 8f;

        // when
        final float result = getMaxValue(newValue, currentMaxValue);

        // then
        assertThat(result).isEqualTo(8f);
    }

    @Test
    public void shouldGetCurrentMinValueTest() throws Exception {
        // given
        final float newValue = 23f;
        final float currentMaxValue = 21f;

        // when
        final float result = getMinValue(newValue, currentMaxValue);

        // then
        assertThat(result).isEqualTo(21f);
    }

    @Test
    public void shouldGetNewValueAsMinValueTest() throws Exception {
        // given
        final float newValue = 3f;
        final float currentMaxValue = 5f;

        // when
        final float result = getMinValue(newValue, currentMaxValue);

        // then
        assertThat(result).isEqualTo(3f);
    }

    @Test
    public void shouldNotChangeMinValueIfIsEqualToNewValueTest() throws Exception {
        // given
        final float newValue = 6f;
        final float currentMaxValue = 6f;

        // when
        final float result = getMinValue(newValue, currentMaxValue);

        // then
        assertThat(result).isEqualTo(6f);
    }

    @Test
    public void shouldReturnTrueForPalindromeNumberTest() throws Exception {
        // when
        final boolean isNumberPalindrome = isNumberPalindrome(143797341);

        // then
        assertThat(isNumberPalindrome).isTrue();
    }

    @Test
    public void shouldReturnFalseForNonPalindromeNumberTest() throws Exception {
        // when
        final boolean isNumberPalindrome = isNumberPalindrome(987654321);

        // then
        assertThat(isNumberPalindrome).isFalse();
    }

    @Test
    public void sortIntegersCollectionExample() throws Exception {
        // given
        ArrayList<Integer> notSortedCollection = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            notSortedCollection.add(random.nextInt(Integer.MAX_VALUE));
        }

        // when
        final List<Integer> sortedIntegerList = sortIntegersCollection(notSortedCollection);

        // then
        Integer previousValue = Integer.MAX_VALUE;
        for (Integer integer : sortedIntegerList) {
            assertThat(previousValue).isGreaterThan(integer);
            previousValue = integer;
        }

    }

    @SuppressWarnings("ConstantConditions")
    @Test
    public void shouldReturnFalseIfBigDecimalIsNull() throws Exception {
        // when
        final boolean result = isBigDecimalAValidInteger(null);

        // then
        assertThat(result).isFalse();
    }

    @Test
    public void shouldReturnFalseIfBigDecimalIsNotInteger() throws Exception {
        // given
        BigDecimal bigDecimal = new BigDecimal("1.23");

        // when
        final boolean result = isBigDecimalAValidInteger(bigDecimal);

        // then
        assertThat(result).isFalse();
    }

    @Test
    public void shouldReturnTrueWhenBigDecimalIsInteger() throws Exception {
        // given

        // when
        final boolean result = isBigDecimalAValidInteger(BigDecimal.TEN);
        // then
        assertThat(result).isTrue();
    }

    @Test
    public void generateNaturalSequenceIntArrayShouldReturnIllegalArgumentExceptionIfValueIsNegative() throws Exception {
        // expect
        exception.expect(IllegalArgumentException.class);
        // given
        final int negativeValue = randomNegativeInteger();

        // when
        generateNaturalSequenceIntArray(negativeValue);

        // debug info
        LOGGER.warn("Value used in test:" + negativeValue);
    }

    @Test
    public void generateNaturalSequenceIntArrayShouldReturnIntArrayForSpecificSize() throws Exception {
        // given
        final int positiveInteger = randomPositiveInteger(10);

        // when
        generateNaturalSequenceIntArray(positiveInteger);

        // debug
        LOGGER.debug("Value used in test:" + positiveInteger);
    }

    @Test
    public void parseIntNullSafeShouldReturnDefaultValueIfValueIsNotValidNumber() throws Exception {
        // given
        final int defaultValue = randomPositiveInteger();
        final String invalidNumber = "Not A valid number";

        // debug
        LOGGER.debug("Default value: " + defaultValue);

        // when
        final int result = parseNullSafeIntegerAsString(invalidNumber, defaultValue);

        // then
        assertThat(result).isEqualTo(defaultValue);

    }

    @Test
    public void parseIntNullSafeShouldReturnValueForValidNumberAsString() throws Exception {
        // given
        final int defaultValue = randomNegativeInteger();
        final String validValue = generateRandomIntegerAsString(10);

        // debug
        LOGGER.debug("Default value: " + defaultValue + " Valid value: " + validValue);

        // when
        final int result = parseNullSafeIntegerAsString(validValue, defaultValue);

        // then

        assertThat(result).isEqualTo(Integer.parseInt(validValue));
        assertThat(result).isNotEqualTo(defaultValue);

    }
}
