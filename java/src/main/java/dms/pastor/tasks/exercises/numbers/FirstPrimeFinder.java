package dms.pastor.tasks.exercises.numbers;

import static dms.pastor.utils.NumberUtils.isPrime;
import static dms.pastor.utils.ValidatorUtils.validateIfPositiveNumber;

/**
 * Author Dominik Symonowicz
 * Created 14/04/2017
 * WWW:	<a href="https://dominiksymonowicz.com/">HOME PAGE</a>
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 * <p>
 * Write a function that takes a string representing a list of integers as a parameter
 * and prints the first prime number reached by summing the items in order.
 * <p>
 * Rules:
 * return 0 if no prime is found.
 * if list contains negative number throw exception
 */
class FirstPrimeFinder {

    private static final int NO_PRIME_NUMBER_FOUND = 0;

    int find(int... numbers) {
        validateInput(numbers);

        if (isSingleNumberAPrimeNumber(numbers)) {
            return numbers[0];
        }

        return findFirstSumOfNumbersInOrdersIsPrimeNumber(numbers);
    }

    private int findFirstSumOfNumbersInOrdersIsPrimeNumber(int[] numbers) {
        int number = numbers[0];

        for (int i = 1; i < numbers.length; i++) {
            number += numbers[i];
            if (isPrime(number)) {
                return number;
            }
        }
        return NO_PRIME_NUMBER_FOUND;
    }

    private boolean isSingleNumberAPrimeNumber(int[] numbers) {
        return isSizeOfOne(numbers) && isPrime(numbers[0]);
    }

    private boolean isSizeOfOne(int[] numbers) {
        return numbers.length == 1;
    }

    private void validateInput(int[] numbers) {
        for (int number : numbers) {
            validateIfPositiveNumber(number);
        }
    }
}
