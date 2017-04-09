package dms.pastor.utils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static dms.pastor.utils.StringUtils.EMPTY_STRING;
import static dms.pastor.utils.ValidatorUtils.validateIfPositiveNumber;

/**
 * Author Dominik Symonowicz
 * Created 2013-04-07 12.01
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
public final class NumberUtils {

    private NumberUtils(){}

    /**
     * *VERSION:        2
     * *LAST UPDAtED:   07.04.2013
     *
     * @param result a number  to check
     * @return a number in range between 0-100
     */
    static int getResultIn0to100Range(int result) {
        return getResultInRange(result, 0, 100);
    }

    /**
     * *VERSION:        2
     * *LAST UPDAtED:   07.04.2013
     *
     * @param min    a minimum value that must be returned
     * @param max    a minimum value that must be returned
     * @param result a number  to check
     * @return a number in range between min and max
     */
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
        if (a > 19 || a < -19) {
            throw new IllegalArgumentException("Number too big/small for integer");
        }
        int fact = 1;
        for (int i = 1; i <= a; i++) {
            fact *= i;
        }
        return fact;
    }

    public static int getSmallestInt(int[] values) {
        if (values == null || values.length == 0) {
            throw new IllegalArgumentException("Invalid input. It must be integer array");
        }
        int smallestInt = Integer.MAX_VALUE;
        for (int i : values) {
            if (i < smallestInt) {
                smallestInt = i;
            }
        }
        return smallestInt;
    }

    public static int getLargestInt(int[] values) {
        if (values == null || values.length == 0) {
            throw new IllegalArgumentException("Invalid input. It must be integer array");
        }
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

    public static int reverseANumber(int question) {
        int answer = 0, remainder;
        do {
            remainder = question % 10;
            answer = answer * 10 + remainder;
            question = question / 10;

        } while (question > 0);
        return answer;
    }

    //12345 -> 54321;

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

        for (int i = 3; i < number; i = i + 2) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    static boolean isNumberPalindrome(int number) {
        int reversedNumber = reverseANumber(number);
        return reversedNumber == number;
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

    //done as part of learning of basic of sorting in 2011
    static List<Integer> sortIntegersCollection(ArrayList<Integer> numbers) {
        if (numbers != null) {
            for (int i = 0; i < numbers.size() / 2; i++) {
                boolean swapped = false;
                for (int j = i; j < numbers.size() - i - 1; j++) {
                    if (numbers.get(j) < numbers.get(j + 1)) {
                        Integer tmp = numbers.get(j);
                        numbers.set(j, numbers.get(j + 1));
                        numbers.set(j + 1, tmp);
                        swapped = true;
                    }
                }
                for (int j = numbers.size() - 2 - i; j > i; j--) {
                    if (numbers.get(j) > numbers.get(j - 1)) {
                        Integer tmp = numbers.get(j);
                        numbers.set(j, numbers.get(j - 1));
                        numbers.set(j - 1, tmp);
                        swapped = true;
                    }
                }
                if (!swapped) break;
            }
        }
        return numbers;
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
        if (bitMaker.getLeftOver() == 1) {
            eightBit += "1";
        } else {
            eightBit += "0";
        }

        return eightBit;

    }

    public static boolean isBigDecimalAValidInteger(BigDecimal bigDecimal) {
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

    private static class BitMaker {
        private String eightBit;
        private int leftOver;

        public BitMaker(String eightBit, int leftOver) {
            this.eightBit = eightBit;
            this.leftOver = leftOver;
        }

        public String getEightBit() {
            return eightBit;
        }

        public int getLeftOver() {
            return leftOver;
        }

        public BitMaker invoke(int divider) {
            if (leftOver >= divider) {
                eightBit += "1";
                leftOver -= divider;
            } else {
                eightBit += "0";
            }
            return this;
        }
    }

}
