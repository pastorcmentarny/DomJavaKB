package dms.pastor.utils;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.nio.file.Path;
import java.util.List;
import java.util.Objects;

import static java.lang.String.format;
import static java.util.Objects.isNull;

/**
 * Author Dominik Symonowicz
 * WWW:	<a href="https://dominiksymonowicz.com/">HOME PAGE</a>
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 * <p>
 * Some utils to help you validate data
 */
public final class ValidatorUtils {

    private static final String ERROR_MESSAGE_VALUE_CANNOT_BE_NEGATIVE = " must be positive value.";
    private static final String DEFAULT_VALUE_NAME = "Value";
    private static final String INVALID_PATH = "Path to file is invalid, file doesn't exists or can't be read.";

    private ValidatorUtils() {
    }

    static boolean isAnyOfPropertiesContainsNull(Object... properties) {
        for (Object property : properties) {
            if (Objects.isNull(property)) {
                return false;
            }
        }
        return true;
    }

    static void validateNotNullPropertiesWithCustomMessage(Object[] properties, String errorMessage) {
        for (Object property : properties) {
            if (Objects.isNull(property)) {
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
        } catch (Exception exception) {
            return false;
        }
        return true;
    }

    public static void validateIfPositiveNumber(int number) {
        validateIfPositiveNumber(number, DEFAULT_VALUE_NAME);
    }

    @SuppressWarnings("ResultOfMethodCallIgnored")
    public static void validateIfSumOfIntegerIsInIntegerValueRange(int minValue, int maxValue) {
        try {
            Math.addExact(minValue, maxValue);
        } catch (ArithmeticException exception) {
            throw new IllegalArgumentException("Range may produce number bigger than valid range for integer.", exception);
        }
    }

    public static void validateIfPositiveNumber(int number, String valueName) {
        if (number <= 0) {
            throw new IllegalArgumentException(valueName + " {" + number + "} " + ERROR_MESSAGE_VALUE_CANNOT_BE_NEGATIVE);
        }
    }

    public static void validateIfPositiveNumber(BigDecimal number) {
        validateIfObjectValueIsNotNull(number);
        if (number.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException(DEFAULT_VALUE_NAME + ERROR_MESSAGE_VALUE_CANNOT_BE_NEGATIVE);
        }
    }

    public static void validateNegativeBigDecimal(BigDecimal value) {
        validateIfObjectValueIsNotNull(value);
        if (value.compareTo(BigDecimal.ZERO) > 0) {
            throw new IllegalArgumentException("Value cannot be positive");
        }
    }

    public static void validateIfObjectValueIsNotNull(Object value) {
        validateIfObjectValueIsNotNull(value, "Value");
    }

    public static void validateIfObjectValueIsNotNull(Object value, String valueName) {
        if (isNull(value)) {
            throw new IllegalArgumentException(valueName + " cannot be null.");
        }
    }

    public static void validateTwoIntsNotEqual(int firstInteger, int secondInteger) {
        if (firstInteger == secondInteger) {
            throw new IllegalArgumentException("Both numbers cannot be equals, but both numbers are " + firstInteger + " and " + secondInteger + ".");
        }
    }

    public static void validateMinValueIsSmallerThanMaxValue(int minValue, int maxValue) {
        if (minValue >= maxValue) {
            throw new IllegalArgumentException(format("MinValue (%d) must be lower than MaxValue(%d)", minValue, maxValue));
        }
    }

    public static void validateValueIsSmallerOrEqualsThatOtherValue(int value, int otherValue) {
        if (value > otherValue) {
            throw new IllegalArgumentException(format("Value (%d) must be lower or equals to than Other Value(%d)", value, otherValue));
        }
    }

    public static void validateIfNotEmpty(String value) {
        throwExceptionIfEmpty(value, DEFAULT_VALUE_NAME);
    }

    public static void validateIfNotEmpty(String string, String objectName) {
        throwExceptionIfEmpty(string, objectName);
    }

    public static void validateIfNotEmpty(int[] numberArray, String arrayName) {
        if (numberArray == null || numberArray.length == 0) {
            throw new IllegalArgumentException(arrayName);
        }
    }

    public static void validateIfNotBlank(String string, String fieldName) {
        if (string == null || string.isBlank()) {
            throw new IllegalArgumentException(fieldName + " is blank because: " + StringUtils.describeStringType(string));
        }
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

    public static void validateIfValueIsInRange(int min, int max, int number) {
        validateMinValueIsSmallerThanMaxValue(min, max);
        if (number < min || number > max) {
            throw new IllegalArgumentException(String.format("%d is not range. Range is between %d and %d.", number, min, max));

        }
    }

    public static void validateIfArrayHasSizeOf(int size, String[] array, String what) {
        validateIfObjectValueIsNotNull(array, what);
        if (size != array.length) {
            throw new IllegalArgumentException(String.format("%s has incorrect size. It should be %d but was %d.", what, size, array.length));
        }

    }

    public static void validateIfFileIsAccessible(String path) {
        validateIfNotEmpty(path, "path");
        throwExceptionIfFileIsNotAccessible(new File(path));

    }

    public static void validateIfPathIsAccessible(Path path) {
        validateIfObjectValueIsNotNull(path, "path");
        throwExceptionIfFileIsNotAccessible(path.toFile());
    }

    private static void throwExceptionIfFileIsNotAccessible(File file) {
        if (!file.exists() || !file.canRead() || file.isDirectory()) {
            throw new IllegalArgumentException(INVALID_PATH);
        }
    }
}
