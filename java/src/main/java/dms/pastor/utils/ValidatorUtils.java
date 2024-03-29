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
 * WWW:	<a href="https://dominiksymonowicz.com/welcome">...</a>
 * IT BLOG:	<a href="https://dominiksymonowicz.blogspot.co.uk">...</a>
 * GitHub:	<a href="https://github.com/pastorcmentarny">...</a>
 * Google Play:	<a href="https://play.google.com/store/apps/developer?id=Dominik+Symonowicz">...</a>
 * LinkedIn: <a href="https://www.linkedin.com/in/dominik-symonowicz">...</a>
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
            if (Objects.isNull(property[0])) {
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
            throw new IllegalArgumentException("%s {%d} %s".formatted(valueName, number, ERROR_MESSAGE_VALUE_CANNOT_BE_NEGATIVE));
        }
    }

    public static void validateIfPositiveNumber(long number, String valueName) {
        if (number <= 0) {
            throw new IllegalArgumentException("%s {%d} %s".formatted(valueName, number, ERROR_MESSAGE_VALUE_CANNOT_BE_NEGATIVE));
        }
    }

    public static void validateIfPositiveNumber(BigDecimal number) {
        validateIfObjectValueIsNotNull(number);
        if (number.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("%s%s".formatted(DEFAULT_VALUE_NAME, ERROR_MESSAGE_VALUE_CANNOT_BE_NEGATIVE));
        }
    }

    public static void validateNegativeBigDecimal(BigDecimal value) {
        validateIfObjectValueIsNotNull(value);
        if (value.compareTo(BigDecimal.ZERO) > 0) {
            throw new IllegalArgumentException("Value cannot be positive. Value: %s".formatted(value));
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
            throw new IllegalArgumentException("Both numbers cannot be equals, but both numbers are %d and %d.".formatted(firstInteger, secondInteger));
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
            throw new IllegalArgumentException("%s is blank because: %s".formatted(fieldName, StringUtils.describeStringType(string)));
        }
    }

    private static void throwExceptionIfEmpty(String object, String objectName) {
        if (object == null || object.isEmpty()) {
            throw new IllegalArgumentException(getErrorMessage(objectName));
        }
    }


    public static void validateIfListIsNotEmpty(List<String> strings, String withMessage) {
        if (strings == null || strings.size() == 0) {
            throw new IllegalArgumentException(getErrorMessage(withMessage));
        }
    }

    public static void validateIfListIsNotEmpty(String[] strings, String withMessage) {
        if (strings == null || strings.length == 0) {
            throw new IllegalArgumentException(getErrorMessage(withMessage));
        }
    }


    public static void validateIfStringArrayIsNotEmpty(String[] strings) {
        validateIfListIsNotEmpty(strings, "Input");
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
            throw new IllegalArgumentException(format("%d is not range. Range is between %d and %d.", number, min, max));

        }
    }

    public static void validateIfArrayHasSizeOf(int size, String[] array, String what) {
        validateIfObjectValueIsNotNull(array, what);
        if (size != array.length) {
            throw new IllegalArgumentException(format("%s has incorrect size. It should be %d but was %d.", what, size, array.length));
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

    public static void validateIfListHasIntegersOnly(List<String> integerAsStringList) {
        validateIfListIsNotEmpty(integerAsStringList, "List with numbers");
        for (String item : integerAsStringList) {
            try {
                Integer.valueOf(item);
            } catch (
                    NumberFormatException numberFormatException) {
                throw new IllegalArgumentException("At least one element in the list is not a number");
            }
        }
    }

    private static void throwExceptionIfFileIsNotAccessible(File file) {
        if (!file.exists() || !file.canRead() || file.isDirectory()) {
            throw new IllegalArgumentException(INVALID_PATH);
        }
    }
/*
 *
 public static ImageName of(String value) {
 Assert.hasText(value, "Value must not be empty");
 Matcher matcher = PATTERN.matcher(value);
 Assert.isTrue(matcher.matches(),
 String domain = parseDomain(value);
 String path = (domain != null) ? value.substring(domain.length() + 1) : value;
 Assert.isTrue(Regex.PATH.matcher(path).matches(),
 () -> "Unable to parse name \"" + value + "\". "
 + "Image name must be in the form '[domainHost:port/][path/]name', "
 + "with 'path' and 'name' containing only [a-z0-9][.][_][-]");
 return new ImageName(matcher.group("domain"), matcher.group("path"));
 return new ImageName(domain, path);
 }

 static String parseDomain(String value) {
 int firstSlash = value.indexOf('/');
 String candidate = (firstSlash != -1) ? value.substring(0, firstSlash) : null;
 if (candidate != null && Regex.DOMAIN.matcher(candidate).matches()) {
 return candidate;
 }
 return null;
 }


 static final Pattern DIGEST = Regex.of("^[A-Za-z][A-Za-z0-9]*(?:[-_+.][A-Za-z][A-Za-z0-9]*)*[:][[A-Fa-f0-9]]{32,}")
 .compile();

 */
}
