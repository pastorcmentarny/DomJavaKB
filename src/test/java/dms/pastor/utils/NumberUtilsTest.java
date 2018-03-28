package dms.pastor.utils;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.Random;

import static dms.pastor.TestConfig.EMPTY_INTEGER_ARRAY;
import static dms.pastor.utils.NumberUtils.*;
import static dms.pastor.utils.randoms.RandomDataGenerator.*;
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

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void getResultInRangeShouldReturn10For10InRangeBetween5And20() {
        // given
        final int value = 10;

        // when
        final int result = getResultInRange(value, MIN_VALUE, MAX_VALUE);

        // then
        assertThat(result).isEqualTo(value);
    }

    @Test
    public void getResultInRangeShouldReturn5For5InRangeBetween5And20() {
        // given
        final int value = MIN_VALUE;

        // when
        final int result = getResultInRange(value, MIN_VALUE, MAX_VALUE);

        // then
        assertThat(result).isEqualTo(value);
    }

    @Test
    public void getResultInRangeShouldReturn20For20InRangeBetween5And20() {
        // given
        final int value = MAX_VALUE;

        // when
        final int result = getResultInRange(value, MIN_VALUE, MAX_VALUE);

        // then
        assertThat(result).isEqualTo(value);
    }

    @Test
    public void getResultInRangeShouldReturn5For0InRangeBetween5And20() {
        // given
        final int value = 0;

        // when
        final int result = getResultInRange(value, MIN_VALUE, MAX_VALUE);

        // then
        assertThat(result).isEqualTo(MIN_VALUE);
    }

    @Test
    public void getResultInRangeShouldReturn25For0InRangeBetween5And20() {
        // given
        final int value = 25;

        // when
        final int result = getResultInRange(value, MIN_VALUE, MAX_VALUE);

        // then
        assertThat(result).isEqualTo(MAX_VALUE);
    }

    @Test
    public void testShouldReturn100For104() {
        final int result = getResultIn0to100Range(104);
        assertThat(result).isEqualTo(100);
    }

    @Test
    public void testShouldReturn0ForMinusTen() {
        final int result = getResultIn0to100Range(-10);
        assertThat(result).isZero();
    }

    @Test
    public void testShouldReturn20For20() {
        final int result = getResultIn0to100Range(20);
        assertThat(result).isEqualTo(20);
    }

    @Test
    public void getFibonacciForShouldReturnZeroForZero() {
        final long result = getFibonacciNumberFor(0);
        assertThat(result).isZero();
    }

    @Test
    public void getFibonacciForShouldReturnOneForOne() {
        final long result = getFibonacciNumberFor(1);
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void getFibonacciForShouldReturnOneForTwo() {
        final long result = getFibonacciNumberFor(2);
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void getFibonacciForShouldReturnTwoForThree() {
        final long result = getFibonacciNumberFor(3);
        assertThat(result).isEqualTo(2);
    }

    @Test
    public void getFibonacciForShouldReturnThreeForFour() {
        final long result = getFibonacciNumberFor(4);
        assertThat(result).isEqualTo(3);
    }

    @Test
    public void getFibonacciForShouldReturnFiveForFive() {
        final long result = getFibonacciNumberFor(5);
        assertThat(result).isEqualTo(5);
    }

    @Test
    public void getFibonacciForShouldReturnFiftyFiveForTen() {
        final long result = getFibonacciNumberFor(10);
        assertThat(result).isEqualTo(55);
    }

    @Test
    public void testShouldReturn120Factorial5() {
        final int result = factorial(5);
        assertThat(result).isEqualTo(120);
    }

    @Test
    public void testShouldReturnMinus120FactorialMinus5() {
        final int result = factorial(5);
        assertThat(result).isEqualTo(120);
    }

    @SuppressWarnings("ResultOfMethodCallIgnored")// because result doesn't matter in this case
    @Test
    public void testShouldThrowExceptionFor20() {
        //except
        exception.expect(IllegalArgumentException.class);

        // when
        factorial(20);
    }

    @Test
    public void testGetSmallestInt() {
        final int result = getSmallestInt(new int[]{15, 12, 22, 10, 14, 20});
        assertThat(result).isEqualTo(10);
    }

    @Test
    public void testGetSmallestIntForNegativeNumbers() {
        final int result = getSmallestInt(new int[]{-15, -12, -22, -10, -14, -20});
        assertThat(result).isEqualTo(-22);
    }

    @Test
    public void testGetSmallestIntForMixedNumbers() {
        final int result = getSmallestInt(new int[]{15, -12, 22, -10, 14, -20});
        assertThat(result).isEqualTo(-20);
    }

    @SuppressWarnings("ConstantConditions") // part of the test
    @Test(expected = IllegalArgumentException.class)
    public void testGetIllegalExceptionForNullInputForSmallestInt() {
        getSmallestInt(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetIllegalExceptionForEmptyInputForSmallestInt() {
        getSmallestInt(EMPTY_INTEGER_ARRAY);
    }

    @Test
    public void testGetLargestInt() {
        final int result = getLargestInt(new int[]{15, 12, 22, 10, 14, 20});
        assertThat(result).isEqualTo(22);
    }

    @Test
    public void testGetLargestNegativeInt() {
        final int result = getLargestInt(new int[]{-15, -12, -22, -10, -14, -20});
        assertThat(result).isEqualTo(-10);
    }

    @Test
    public void testGetLargestMixedInt() {
        final int result = getLargestInt(new int[]{15, -12, 22, -10, 14, -20});
        assertThat(result).isEqualTo(22);
    }

    @SuppressWarnings("ConstantConditions") // part of the test
    @Test(expected = IllegalArgumentException.class)
    public void testGetIllegalExceptionForNullInputForLargestInt() {
        getLargestInt(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetIllegalExceptionForEmptyInputForLargestInt() {
        getLargestInt(EMPTY_INTEGER_ARRAY);
    }

    @Test
    public void testReverseANumber() {
        // given
        int question = 12345;
        int answer = 54321;

        // when
        final int result = reverseANumber(question);

        // then
        assertThat(result).isEqualTo(answer);
    }

    @Test //normally I will split loop into each test. This is just exception
    public void testIsNumberPrime() {
        // given
        int[] primes = new int[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97};

        // then check for few prime numbers
        for (int i : primes) {
            final boolean result = isPrime(i);
            assertThat(result).isTrue();
        }
    }

    @Test //normally I will split loop into each test. This is just exception
    public void testIsNotNumberPrime() {
        int[] notPrimes = new int[]{4, 6, 8, 10, 20, 50, 100};
        for (int i : notPrimes) {
            assertThat(isPrime(i)).isFalse();
        }
    }

    @Test
    public void testIsNotNumberWhenValueIsZeroPrime() {
        final boolean result = isPrime(0);
        assertThat(result).isFalse();
    }

    @Test
    public void getNullIfValueIsBelow0() {
        // when
        final String result = getShortAs8BitRepresentation(-10);

        // then
        assertThat(result).isEmpty();
    }

    @Test
    public void getNullIfValueIsAbove255() {
        // given
        final int max8BitValue = 256;
        final int randomNumber = new Random().nextInt(Integer.MAX_VALUE - max8BitValue) + 255;

        // when
        final String result = getShortAs8BitRepresentation(randomNumber);

        // then
        assertThat(result).isEmpty();
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

    @Test
    public void shouldGetCurrentMaxValueTest() {
        // given
        final float newValue = 10f;
        final float currentMaxValue = 12f;

        // when
        final float result = getMaxValue(newValue, currentMaxValue);

        // then
        assertThat(result).isEqualTo(12f);
    }

    @Test
    public void shouldGetNewValueAsMaxValueTest() {
        // given
        final float newValue = 13f;
        final float currentMaxValue = 12f;

        // when
        final float result = getMaxValue(newValue, currentMaxValue);

        // then
        assertThat(result).isEqualTo(13f);
    }

    @Test
    public void shouldNotChangeMaxValueIfIsEqualToNewValueTest() {
        // given
        final float newValue = 8f;
        final float currentMaxValue = 8f;

        // when
        final float result = getMaxValue(newValue, currentMaxValue);

        // then
        assertThat(result).isEqualTo(8f);
    }

    @Test
    public void shouldGetCurrentMinValueTest() {
        // given
        final float newValue = 23f;
        final float currentMaxValue = 21f;

        // when
        final float result = getMinValue(newValue, currentMaxValue);

        // then
        assertThat(result).isEqualTo(21f);
    }

    @Test
    public void shouldGetNewValueAsMinValueTest() {
        // given
        final float newValue = 3f;
        final float currentMaxValue = 5f;

        // when
        final float result = getMinValue(newValue, currentMaxValue);

        // then
        assertThat(result).isEqualTo(3f);
    }

    @Test
    public void shouldNotChangeMinValueIfIsEqualToNewValueTest() {
        // given
        final float newValue = 6f;
        final float currentMaxValue = 6f;

        // when
        final float result = getMinValue(newValue, currentMaxValue);

        // then
        assertThat(result).isEqualTo(6f);
    }

    @Test
    public void shouldReturnTrueForPalindromeNumberTest() {
        // when
        final boolean isNumberPalindrome = isNumberPalindrome(143797341);

        // then
        assertThat(isNumberPalindrome).isTrue();
    }

    @Test
    public void shouldReturnFalseForNonPalindromeNumberTest() {
        // when
        final boolean isNumberPalindrome = isNumberPalindrome(987654321);

        // then
        assertThat(isNumberPalindrome).isFalse();
    }

    @SuppressWarnings("ConstantConditions")
    @Test
    public void shouldReturnFalseIfBigDecimalIsNull() {
        // when
        final boolean result = isBigDecimalAValidInteger(null);

        // then
        assertThat(result).isFalse();
    }

    @Test
    public void shouldReturnFalseIfBigDecimalIsNotInteger() {
        // given
        BigDecimal bigDecimal = new BigDecimal("1.23");

        // when
        final boolean result = isBigDecimalAValidInteger(bigDecimal);

        // then
        assertThat(result).isFalse();
    }

    @Test
    public void shouldReturnTrueWhenBigDecimalIsInteger() {
        // given

        // when
        final boolean result = isBigDecimalAValidInteger(BigDecimal.TEN);
        // then
        assertThat(result).isTrue();
    }

    @Test
    public void parseIntNullSafeShouldReturnDefaultValueIfValueIsNotValidNumber() {
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
    public void parseIntNullSafeShouldReturnValueForValidNumberAsString() {
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
