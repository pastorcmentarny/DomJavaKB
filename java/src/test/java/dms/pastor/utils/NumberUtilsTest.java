package dms.pastor.utils;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.Random;

import static dms.pastor.TestConfig.EMPTY_INTEGER_ARRAY;
import static dms.pastor.utils.NumberUtils.*;
import static dms.pastor.utils.randoms.RandomDataGenerator.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Author Dominik Symonowicz
 * Created 09.10.2012
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
@SuppressWarnings("MagicNumber") // because there are specific numbers
public class NumberUtilsTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(NumberUtilsTest.class);

    private static final int MIN_VALUE = 5;
    private static final int MAX_VALUE = 20;


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
        // when
        final int result = getResultIn0to100Range(104);
        
        // then
        assertThat(result).isEqualTo(100);
    }

    @Test
    public void testShouldReturn0ForMinusTen() {
        // when
        final int result = getResultIn0to100Range(-10);

        // then
        assertThat(result).isZero();
    }

    @Test
    public void testShouldReturn20For20() {
        // when
        final int result = getResultIn0to100Range(20);

        // then
        assertThat(result).isEqualTo(20);
    }

    @Test
    public void getFibonacciForShouldReturnZeroForZero() {
        // when
        final long result = getFibonacciNumberFor(0);
        // then
        assertThat(result).isZero();
    }

    @Test
    public void getFibonacciForShouldReturnOneForOne() {
        // when
        final long result = getFibonacciNumberFor(1);

        // then
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void getFibonacciForShouldReturnOneForTwo() {
        // when
        final long result = getFibonacciNumberFor(2);

        // then
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void getFibonacciForShouldReturnTwoForThree() {
        // when
        final long result = getFibonacciNumberFor(3);
        // then
        assertThat(result).isEqualTo(2);
    }

    @Test
    public void getFibonacciForShouldReturnThreeForFour() {
        // when
        final long result = getFibonacciNumberFor(4);

        // then
        assertThat(result).isEqualTo(3);
    }

    @Test
    public void getFibonacciForShouldReturnFiveForFive() {
        // when
        final long result = getFibonacciNumberFor(5);

        // then
        assertThat(result).isEqualTo(5);
    }

    @Test
    public void getFibonacciForShouldReturnFiftyFiveForTen() {
        // when
        final long result = getFibonacciNumberFor(10);

        // then
        assertThat(result).isEqualTo(55);
    }

    @Test
    public void testShouldReturn120Factorial5() {
        // when
        final int result = factorial(5);

        // then
        assertThat(result).isEqualTo(120);
    }

    @Test
    public void testShouldReturnMinus120FactorialMinus5() {
        // when
        final int result = factorial(5);

        // then
        assertThat(result).isEqualTo(120);
    }

    @Test
    public void testShouldThrowExceptionFor20() {
        // when
        assertThrows(IllegalArgumentException.class, () -> factorial(20));
    }

    @Test
    public void testGetSmallestInt() {
        // when
        final int result = getSmallestInt(new int[]{15, 12, 22, 10, 14, 20});
        // then
        assertThat(result).isEqualTo(10);
    }

    @Test
    public void testGetSmallestIntForNegativeNumbers() {
        // when
        final int result = getSmallestInt(new int[]{-15, -12, -22, -10, -14, -20});

        // then
        assertThat(result).isEqualTo(-22);
    }

    @Test
    public void testGetSmallestIntForMixedNumbers() {
        // when
        final int result = getSmallestInt(new int[]{15, -12, 22, -10, 14, -20});

        // then
        assertThat(result).isEqualTo(-20);
    }


    @SuppressWarnings("ResultOfMethodCallIgnored")
    @Test
    public void testGetIllegalExceptionForNullInputForSmallestInt() {
        assertThrows(IllegalArgumentException.class, () -> getSmallestInt(null));
    }

    @SuppressWarnings("ResultOfMethodCallIgnored")
    @Test
    public void testGetIllegalExceptionForEmptyInputForSmallestInt() {
        assertThrows(IllegalArgumentException.class, () -> getSmallestInt(EMPTY_INTEGER_ARRAY));
    }

    @Test
    public void testGetLargestInt() {
        // when
        final int result = getLargestInt(new int[]{15, 12, 22, 10, 14, 20});

        // then
        assertThat(result).isEqualTo(22);
    }

    @Test
    public void testGetLargestNegativeInt() {
        // when
        final int result = getLargestInt(new int[]{-15, -12, -22, -10, -14, -20});

        // then
        assertThat(result).isEqualTo(-10);
    }

    @Test
    public void testGetLargestMixedInt() {
        // when
        final int result = getLargestInt(new int[]{15, -12, 22, -10, 14, -20});

        // then
        assertThat(result).isEqualTo(22);
    }


    @SuppressWarnings("ResultOfMethodCallIgnored")
    @Test
    public void testGetIllegalExceptionForNullInputForLargestInt() {
        assertThrows(IllegalArgumentException.class, () -> getLargestInt(null));
    }

    @SuppressWarnings("ResultOfMethodCallIgnored")
    @Test
    public void testGetIllegalExceptionForEmptyInputForLargestInt() {
        assertThrows(IllegalArgumentException.class, () -> getLargestInt(EMPTY_INTEGER_ARRAY));
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

        // then
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
        // then
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
        // when
        final String result = getShortAs8BitRepresentation(0);

        // then
        assertThat(result).isEqualTo("00000000");
    }

    @Test //done as part of learning of basic of TDD in 2012
    public void getShortAs8BitRepresentationFor1() {
        // when
        final String result = getShortAs8BitRepresentation(1);

        // then
        assertThat(result).isEqualTo("00000001");
    }

    @Test //done as part of learning of basic of TDD in 2012
    public void getShortAs8BitRepresentationFor2() {
        // when
        final String result = getShortAs8BitRepresentation(2);

        // then
        assertThat(result).isEqualTo("00000010");
    }

    @Test //done as part of learning of basic of TDD in 2012
    public void getShortAs8BitRepresentationFor3() {
        // when
        final String result = getShortAs8BitRepresentation(3);

        // then
        assertThat(result).isEqualTo("00000011");
    }

    @Test //done as part of learning of basic of TDD in 2012
    public void getShortAs8BitRepresentationFor4() {
        // when
        final String result = getShortAs8BitRepresentation(4);

        // then
        assertThat(result).isEqualTo("00000100");
    }

    @Test //done as part of learning of basic of TDD in 2012
    public void getShortAs8BitRepresentationFor5() {
        // when
        final String result = getShortAs8BitRepresentation(5);

        // then
        assertThat(result).isEqualTo("00000101");
    }

    @Test //done as part of learning of basic of TDD in 2012
    public void getShortAs8BitRepresentationFor7() {
        // when
        final String result = getShortAs8BitRepresentation(7);

        // then
        assertThat(result).isEqualTo("00000111");
    }

    @Test //done as part of learning of basic of TDD in 2012
    public void getShortAs8BitRepresentationFor8() {
        // when
        final String result = getShortAs8BitRepresentation(8);

        // then
        assertThat(result).isEqualTo("00001000");
    }

    @Test //done as part of learning of basic of TDD in 2012
    public void getShortAs8BitRepresentationFor13() {
        // when
        final String result = getShortAs8BitRepresentation(13);

        // then
        assertThat(result).isEqualTo("00001101");
    }

    @Test //done as part of learning of basic of TDD in 2012
    public void getShortAs8BitRepresentationFor15() {
        // when
        final String result = getShortAs8BitRepresentation(15);

        // then
        assertThat(result).isEqualTo("00001111");
    }

    @Test //done as part of learning of basic of TDD in 2012
    public void getShortAs8BitRepresentationFor16() {
        // when
        final String result = getShortAs8BitRepresentation(16);

        // then
        assertThat(result).isEqualTo("00010000");
    }

    @Test //done as part of learning of basic of TDD in 2012
    public void getShortAs8BitRepresentationFor17() {
        // when
        final String result = getShortAs8BitRepresentation(17);

        // then
        assertThat(result).isEqualTo("00010001");
    }

    @Test //done as part of learning of basic of TDD in 2012
    public void getShortAs8BitRepresentationFor32() {
        // when
        final String result = getShortAs8BitRepresentation(32);

        // then
        assertThat(result).isEqualTo("00100000");
    } //done as part of learning of basic of TDD in 2012

    @Test
    public void getShortAs8BitRepresentationFor64() {
        // when
        final String result = getShortAs8BitRepresentation(64);

        // then
        assertThat(result).isEqualTo("01000000");
    } //done as part of learning of basic of TDD in 2012

    @Test //done as part of learning of basic of TDD in 2012
    public void getShortAs8BitRepresentationFor100() {
        // when
        final String result = getShortAs8BitRepresentation(100);

        // then
        assertThat(result).isEqualTo("01100100");
    }

    @Test //done as part of learning of basic of TDD in 2012
    public void getShortAs8BitRepresentationFor128() {
        // when
        final String result = getShortAs8BitRepresentation(128);

        // then
        assertThat(result).isEqualTo("10000000");
    }

    @Test //done as part of learning of basic of TDD in 2012
    public void getShortAs8BitRepresentationFor200() {
        // when
        final String result = getShortAs8BitRepresentation(200);

        // then
        assertThat(result).isEqualTo("11001000");
    }

    @Test //done as part of learning of basic of TDD in 2012
    public void getShortAs8BitRepresentationFor250() {
        // when
        final String result = getShortAs8BitRepresentation(250);

        // then
        assertThat(result).isEqualTo("11111010");
    }

    @Test //done as part of learning of basic of TDD in 2012
    public void getShortAs8BitRepresentationFor255() {
        // when
        final String result = getShortAs8BitRepresentation(255);

        // then
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
        // then
        assertThat(result).isNotEqualTo(defaultValue);
    }

    @Test
    public void getPercentageShouldReturnZero() {
        // when
        final String result = getPercentage(0, 1);

        // then
        assertThat(result).isEqualTo("0");
    }

    @Test
    public void getPercentageShouldReturnTwentyFive() {
        // when
        final String result = getPercentage(1, 4);

        // then
        assertThat(result).isEqualTo("25");
    }

    @Test
    public void getPercentageShouldReturnOne() {
        // when
        final String result = getPercentage(1, 100);

        // then
        assertThat(result).isEqualTo("1");
    }

    @Test
    public void getPercentageShouldReturn13() {
        // when
        final String result = getPercentage(1, 8);

        // then
        assertThat(result).isEqualTo("12");
    }

    @Test
    public void getPercentageShouldReturnFifty() {
        // when
        final String result = getPercentage(50, 100);

        // then
        assertThat(result).isEqualTo("50");
    }

    @Test
    public void getPercentageShouldReturnEmptyStringIfTotalNumberIsZero() {
        // when
        final String result = getPercentage(1, 0);

        // then
        assertThat(result).isEmpty();
    }

    @Test
    public void getPercentageShouldReturnEmptyStringIfTotalNumberIsBelowZero() {
        // when
        final String result = getPercentage(1, -1);

        // then
        assertThat(result).isEmpty();
    }

    @Test
    public void toIntFromDoubleFor1AcceptanceTest() {
        // when
        final int result = toIntFromDouble(1.0d);

        // then
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void toIntFromDoubleShouldReturnOneForOneDotFortyNineAcceptanceTest() {
        // when
        final int result = toIntFromDouble(1.49d);

        // then
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void toIntFromDoubleShouldReturnTwoForOneAndHalfAcceptanceTest() {
        // when
        final int result = toIntFromDouble(1.5d);

        // then
        assertThat(result).isEqualTo(2);
    }

    @Test
    public void toIntFromDoubleShouldReturnTwoForOneDotNinetyNineAcceptanceTest() {
        // when
        final int result = toIntFromDouble(1.99d);

        // then
        assertThat(result).isEqualTo(2);
    }

    @Test
    public void increaseByPercentAcceptanceTest() {
        // when
        final int result = increaseByPercent(100d, 1d);

        // then
        assertThat(result).isEqualTo(101);
    }

    @Test
    public void increaseByPercentOfIncreaseNumberByLessThan1ThenAddOneToNumberTest() {
        // when
        final int result = increaseByPercent(0d, 10d);

        // then
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void increaseByPercentDoNotChangeValueForNegativeNumberTest() {
        // when
        final int result = increaseByPercent(-10d, 10d);

        // then
        assertThat(result).isEqualTo(-10);
    }

}
