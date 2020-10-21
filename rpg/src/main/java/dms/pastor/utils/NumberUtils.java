package dms.pastor.utils;

import java.math.BigDecimal;

import static dms.pastor.utils.StringUtils.EMPTY_STRING;
import static dms.pastor.utils.ValidatorUtils.validateIfNotEmpty;
import static java.math.RoundingMode.HALF_UP;

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
    private static final int FACTORIAL_MAXIMUM_VALUE = 19;
    private static final int FACTORIAL_NEGATIVE_MAXIMUM_VALUE = -FACTORIAL_MAXIMUM_VALUE;

    private NumberUtils() {
    }

    public static int parseNullSafeIntegerAsString(String value, int defaultValue) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException nfe) {
            System.out.println("Unable to parse " + value + " as integer.");
            return defaultValue;
        }
    }

    public static int calculateTotal(int[] numbers) {
        var total = 0;
        for (int number : numbers) {
            total += number;
        }
        return total;
    }


    public static int getSmallestInt(int[] values) {
        validateIfNotEmpty(values, "values");
        var smallestInt = Integer.MAX_VALUE;
        for (int i : values) {
            if (i < smallestInt) {
                smallestInt = i;
            }
        }
        return smallestInt;
    }

    public static int getLargestInt(int[] values) {
        validateIfNotEmpty(values, "values");
        var largestInt = Integer.MIN_VALUE;
        for (int value : values) {
            if (value > largestInt) {
                largestInt = value;
            }
        }
        return largestInt;
    }

    public static long getFibonacciNumberFor(int n) {
        return n <= 1 ? n : getFibonacciNumberFor(n - 1) + getFibonacciNumberFor(n - 2);
    }

    public static int reverseANumber(int number) {
        int reversedNumber = 0, remainder; //tag-var var is not allowed in compound declaration
        do {
            remainder = number % 10;
            reversedNumber = reversedNumber * 10 + remainder;
            number /= 10;

        } while (number > 0);
        return reversedNumber;
    }

    public static String getPercentage(int number, int total) {
        if (total <= 0) {
            return EMPTY_STRING;
        }

        if (number == 0) {
            return "0";
        }

        return new BigDecimal(number * 100 / total).setScale(0, HALF_UP).toPlainString();
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

        for (int value = 3; value < number; value += 2) {
            if (number % value == 0) {
                return false;
            }
        }
        return true;
    }

    public static int increaseByPercent(double value, double percent) {
        if (value < 0) {
            return (int) Math.round(value);
        }
        double result = value + (value * (percent / 100));

        if (result - value < 1) {
            return (int) value + 1;
        }
        return (int) Math.round(result);
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
        int comparisonResult = Float.compare(currentValue, maxValue);
        return getResult(currentValue, maxValue, comparisonResult);
    }

    static float getMinValue(float currentValue, float minValue) {
        int comparisonResult = Float.compare(minValue, currentValue);
        return getResult(currentValue, minValue, comparisonResult);

    }

    static int factorial(int number) {
        if (isFactorialInRange(number)) {
            throw new IllegalArgumentException("Number too big/small for integer");
        }
        int factorial = 1;
        for (int currentValue = 1; currentValue <= number; currentValue++) {
            factorial *= currentValue;
        }
        return factorial;
    }

    static boolean isNumberPalindrome(int number) {
        int reversedNumber = reverseANumber(number);
        return reversedNumber == number;
    }


    private static boolean isFactorialInRange(int number) {
        return number > FACTORIAL_MAXIMUM_VALUE || number < FACTORIAL_NEGATIVE_MAXIMUM_VALUE;
    }

    private static int divideBy2(int divider) {
        return divider / 2;
    }

    private static boolean isNotInShortRange(int number) {
        return number > 255 || number < 0;
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
