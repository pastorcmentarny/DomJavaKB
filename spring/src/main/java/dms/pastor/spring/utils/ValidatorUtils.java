package dms.pastor.spring.utils;

import static java.lang.String.format;

/**
 * Author Dominik Symonowicz
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 * <p>
 * Some utils to help you validate data
 */
final class ValidatorUtils {

    private static final String ERROR_MESSAGE_VALUE_CANNOT_BE_NEGATIVE = " must be positive value.";
    private static final String DEFAULT_VALUE_NAME = "Value";
    private static final String INVALID_PATH = "Path to file is invalid.";

    private ValidatorUtils() {
    }

    private static void validateIfPositiveNumber(int number, String valueName) {
        if (number <= 0) {
            throw new IllegalArgumentException(valueName + ERROR_MESSAGE_VALUE_CANNOT_BE_NEGATIVE);
        }
    }

    private static void validateIfNotNull(Object value) {
        validateIfNotNull(value, "Value");
    }

    private static void validateIfNotNull(Object value, String valueName) {
        if (value == null) {
            throw new IllegalArgumentException(valueName + " cannot be null.");
        }
    }

    private static void validateMinValueIsSmallerThanMaxValue(int minValue, int maxValue) {
        if (minValue >= maxValue) {
            throw new IllegalArgumentException(format("MinValue (%d) must be lower than MaxValue(%d)", minValue, maxValue));
        }
    }

    private static void throwExceptionIfEmpty(String object, String objectName) {
        if (object == null || object.isEmpty()) {
            throw new IllegalArgumentException(getErrorMessage(objectName));
        }
    }

    private static String getErrorMessage(String what) {
        return what + " cannot be null or empty.";
    }

    private static boolean isValueInRange(int min, int max, int number) {
        validateMinValueIsSmallerThanMaxValue(min, max);
        return number >= min && number <= max;
    }

}
