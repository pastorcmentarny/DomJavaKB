package dms.pastor.utils;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.util.List;

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
public final class ValidatorUtils {

    private static final String ERROR_MESSAGE_VALUE_CANNOT_BE_NEGATIVE = " cannot be negative.";
    private static final String DEFAULT_VALUE_NAME = "Value";

    private ValidatorUtils() {
    }

    static boolean isAnyOfPropertiesContainsNull(Object... properties) {
        for (Object property : properties) {
            if (property == null) {
                return false;
            }
        }
        return true;
    }

    static void validateNotNullPropertiesWithCustomMessage(Object[] properties, String errorMessage) {
        for (Object property : properties) {
            if (property == null) {
                throw new IllegalArgumentException(errorMessage);
            }
        }
    }

    static void validateNotNullPropertiesWithCustomMessagesPerProperty(Object[][] properties) {
        for (Object[] property : properties) {
            if (property[0] == null) {
                throw new IllegalArgumentException(property[1].toString());
            }
        }
    }

    public static boolean isObjectCanBeSerialized(Object object) {
        try (OutputStream sink = new ByteArrayOutputStream();
             ObjectOutputStream stream = new ObjectOutputStream(sink)) {
            stream.writeObject(object);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public static void validateIfPositiveNumber(int number) {
        validateIfPositiveNumber(number, DEFAULT_VALUE_NAME);
    }

    public static void validateIfPositiveNumber(int number, String valueName) {
        if (number < 0) {
            throw new IllegalArgumentException(valueName + ERROR_MESSAGE_VALUE_CANNOT_BE_NEGATIVE);
        }
    }

    public static void validateIfPositiveNumber(BigDecimal number) {
        validateIfNotNull(number);
        if (number.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException(DEFAULT_VALUE_NAME + ERROR_MESSAGE_VALUE_CANNOT_BE_NEGATIVE);
        }
    }

    public static void validateNegativeBigDecimal(BigDecimal value) {
        validateIfNotNull(value);
        if (value.compareTo(BigDecimal.ZERO) > 0) {
            throw new IllegalArgumentException("Value cannot be positive");
        }
    }

    public static void validateIfNotNull(Object value) {
        validateIfNotNull(value, "Value");
    }

    public static void validateIfNotNull(Object value, String valueName) {
        if (value == null) {
            throw new IllegalArgumentException(valueName + " cannot be null.");
        }
    }

    public static void validateTwoIntsNotEqual(int int1, int int2) {
        if (int1 == int2) {
            throw new IllegalArgumentException("Both numbers cannot be equals, but both numbers are " + int1 + " and " + int2 + ".");
        }
    }

    public static void validateMinValueIsSmallerThanMaxValue(int minValue, int maxValue) {
        if (minValue > maxValue) {
            throw new IllegalArgumentException(format("MinValue (%d) must be lower than MaxValue(%d)", minValue, maxValue));
        }
    }

    public static void validateIfNotEmpty(String value) {
        throwExceptionIfEmpty(value, "Value");
    }

    public static void validateIfNotEmpty(String object, String objectName) {
        throwExceptionIfEmpty(object, objectName);
    }

    private static void throwExceptionIfEmpty(String object, String objectName) {
        if (object == null || object.isEmpty()) {
            throw new IllegalArgumentException(getErrorMessage(objectName));
        }
    }

    public static void validateIfListIsNotEmpty(List<String> stringList, String listName) {
        if (stringList == null || stringList.isEmpty()) {
            throw new IllegalArgumentException(getErrorMessage(listName));
        }
    }

    public static void validateIfStringArrayIsNotEmpty(String[] strings) {
        if (strings == null || strings.length == 0) {
            throw new IllegalArgumentException(getErrorMessage("Input"));
        }
    }

    private static String getErrorMessage(String what) {
        return what + " cannot be null or empty.";
    }

    public static void validateIfValuesIsInRange(int min, int max, int[] numbers) {
        if (numbers.length == 0) {
            throw new IllegalArgumentException(getErrorMessage("Values array"));
        }
        for (int number : numbers) {
            if (!isValueInRange(min, max, number)) {
                throw new IllegalArgumentException("One of values is not in range.");
            }
        }
    }

    public static boolean isValueInRange(int min, int max, int number) {
        validateMinValueIsSmallerThanMaxValue(min, max);
        return number >= min && number <= max;
    }
}
