package dms.pastor.utils;

import dms.pastor.tools.chinese.validator.Word;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;

import static dms.pastor.utils.StringUtils.EMPTY_STRING;
import static dms.pastor.utils.ValidatorUtils.validateIfPositiveNumber;

/**
 * Author Dominik Symonowicz
 * Created 2013-04-07 12.01
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public final class NumberUtils {
    static final String BINARY_DIGIT_ONE = "1";
    static final String BINARY_DIGIT_ZERO = "0";
    private static final Logger LOGGER = LoggerFactory.getLogger(Word.class);
    private static final int FACTORIAL_MAXIMUM_VALUE = 19;
    private static final int FACTORIAL_NEGATIVE_MAXIMUM_VALUE = -FACTORIAL_MAXIMUM_VALUE;

    private NumberUtils() {
    }

    static int getResultIn0to100Range(int result) {
        return getResultInRange(result, 0, 100);
    }

    static int getResultInRange(int result, int min, int max) {
        if (result > max) {
            result = max;
        }
        if (result < min) {
            result = min;
        }
        return result;
    }

    static float getMaxValue(float currentValue, float maxValue) {

        int i1 = Float.compare(currentValue, maxValue);

        return getResult(currentValue, maxValue, i1);
    }

    public static int calcTotal(int[] items) {
        int total = 0;
        for (int i : items) {
            total += i;
        }
        return total;
    }

    static float getMinValue(float currentValue, float minValue) {

        int i1 = Float.compare(minValue, currentValue);

        return getResult(currentValue, minValue, i1);

    }

    static int factorial(int a) {
        if (a > FACTORIAL_MAXIMUM_VALUE || a < FACTORIAL_NEGATIVE_MAXIMUM_VALUE) {
            throw new IllegalArgumentException("Number too big/small for integer");
        }
        int fact = 1;
        for (int i = 1; i <= a; i++) {
            fact *= i;
        }
        return fact;
    }

    public static int getSmallestInt(int[] values) {
        ValidatorUtils.validateIfNotEmpty(values, "values");
        int smallestInt = Integer.MAX_VALUE;
        for (int i : values) {
            if (i < smallestInt) {
                smallestInt = i;
            }
        }
        return smallestInt;
    }

    public static int getLargestInt(int[] values) {
        ValidatorUtils.validateIfNotEmpty(values, "values");
        int largestInt = Integer.MIN_VALUE;
        for (int i : values) {
            if (i > largestInt) {
                largestInt = i;
            }
        }
        return largestInt;
    }

    public static long getFibonacciNumberFor(int n) {
        return n <= 1 ? n : getFibonacciNumberFor(n - 1) + getFibonacciNumberFor(n - 2);
    }

    public static int reverseANumber(int number) {
        int reversedNumber = 0, remainder;
        do {
            remainder = number % 10;
            reversedNumber = reversedNumber * 10 + remainder;
            number /= 10;

        } while (number > 0);
        return reversedNumber;
    }

    public static boolean isPrime(int number) {
        if (number <= 1) { //it includes all negatives because  By the usual definition of prime for integers, negative integers can not be prime.
            return false;
        }
        if (number == 2) {
            return true;
        }
        if (number % 2 == 0) {
            return false;
        }

        for (int i = 3; i < number; i += 2) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    //Since Java8, I use IntStream for that, but I left here for nostalgic reasons :)
    public static int[] generateNaturalSequenceIntArray(int size) {
        validateIfPositiveNumber(size);

        int[] array = new int[size];
        for (int i = 1; i <= size; i++) {
            array[i - 1] = i;
        }
        return array;
    }

    public static int parseNullSafeIntegerAsString(String value, int defaultValue) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException nfe) {
            LOGGER.warn("Unable to parse " + value + " as integer.");
            return defaultValue;
        }
    }

    static boolean isNumberPalindrome(int number) {
        int reversedNumber = reverseANumber(number);
        return reversedNumber == number;
    }

    //done as part of learning of basic of TDD in 2012
    static String getShortAs8BitRepresentation(int number) {
        String eightBit = EMPTY_STRING;
        int divider = 128;

        if (number > 255 || number < 0) {
            return null;
        }

        BitMaker bitMaker = new BitMaker(eightBit, number).invoke(divider);
        divider /= 2;

        while (divider != 1) {
            bitMaker = new BitMaker(bitMaker.getEightBit(), bitMaker.getLeftOver()).invoke(divider);
            divider /= 2;
        }

        eightBit = bitMaker.getEightBit();
        eightBit = addLeftOverBit(eightBit, bitMaker);

        return eightBit;
    }

    private static String addLeftOverBit(String eightBit, BitMaker bitMaker) {
        if (bitMaker.getLeftOver() == 1) {
            eightBit += BINARY_DIGIT_ONE;
        } else {
            eightBit += BINARY_DIGIT_ZERO;
        }
        return eightBit;
    }

    static boolean isBigDecimalAValidInteger(BigDecimal bigDecimal) {
        return bigDecimal != null && bigDecimal.scale() == 0;
    }

    private static float getResult(float currentValue, float value, int comparisonResult) {
        if (comparisonResult > 0) {
            return currentValue;
        } else if (comparisonResult < 0) {
            return value;
        } else {
            return value;
        }
    }

}
