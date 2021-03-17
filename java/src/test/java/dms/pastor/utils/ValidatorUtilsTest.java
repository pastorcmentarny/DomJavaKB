package dms.pastor.utils;

import dms.pastor.domain.ExampleObject;
import dms.pastor.domain.exception.SomethingWentTerribleWrongError;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static dms.pastor.TestConfig.BASE_PATH;
import static dms.pastor.utils.StringUtils.EMPTY_STRING;
import static dms.pastor.utils.ValidatorUtils.*;
import static dms.pastor.utils.randoms.RandomDataGenerator.*;
import static java.lang.String.format;
import static java.math.BigDecimal.ZERO;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Author Dominik Symonowicz
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
@SuppressWarnings("ConstantConditions")
public class ValidatorUtilsTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(ValidatorUtilsTest.class);
    private static final String UNUSED_OBJECT_NAME = null;
    private static final int START_RANGE = 0;
    private static final int END_RANGE = 10;
    private static final String PATH_TO_FILE_IS_INVALID_ERROR_MESSAGE = "Path to file is invalid, file doesn't exists or can't be read.";
    private static final String PATH_IS_NULL_OR_EMPTY = "path cannot be null or empty.";
    private static final String FIELD_NAME = "Wonderful parrots";


    private ExampleObject anObject;

    @BeforeEach
    public void setUp() {
        anObject = new ExampleObject();
    }

    @Test
    public void shouldValidateNotNullProperties() {
        // when
        final boolean actual = isAnyOfPropertiesContainsNull(anObject.getADouble(), anObject.getAnInteger());

        // then
        assertThat(actual).isTrue();
    }

    @Test
    public void validateNotNullPropertiesShouldNotValidateIfHasNullProperties() {
        // when
        final boolean actual = isAnyOfPropertiesContainsNull(anObject.getADouble(), null, anObject.getAnInteger());

        // then
        assertThat(actual).isFalse();
    }

    @Test
    public void shouldValidateForValidateNotNullPropertiesWithCustomMessage() {
        // given
        final Object[] objectsToValidate = {anObject.getADouble(), anObject.getAnInteger()};

        // when
        validateNotNullPropertiesWithCustomMessage(objectsToValidate, "parameter is invalid");

        // then if valid then no exception was thrown
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionWhenValidatingNotNullPropertiesWithCustomMessage() {

        // given
        final Object[] arrayWithSomeNulls = {null, anObject.getString(), anObject.getADouble(), null};

        // when
        final var exception = assertThrows(IllegalArgumentException.class, () -> validateNotNullPropertiesWithCustomMessage(arrayWithSomeNulls, "one of parameters is rubbish"));

        // then
        assertThat(exception.getMessage()).isEqualTo("one of parameters is rubbish");
    }

    @Test
    public void shouldValidateForValidateNotNullPropertiesWithCustomMessages() {
        // given
        final Object[] objectsToValidate = {anObject.getADouble(), anObject.getAnInteger(), anObject.getString()};

        // when
        validateNotNullPropertiesWithCustomMessagesPerProperty(new Object[][]{
                {objectsToValidate[0], "Invalid Double"},
                {objectsToValidate[1], "Invalid Integer"},
                {objectsToValidate[2], "Invalid Example Object"}
        });

        // then if valid then no exception was thrown
    }

    @SuppressWarnings("ConstantConditions") // used for test only
    @Test
    public void shouldThrowIllegalArgumentExceptionWhenForValidatingNotNullPropertiesWithCustomMessages() {
        // given
        final Object[] objectsToValidate = {null, anObject.getADouble(), anObject.getAnInteger(), anObject.getString(), null};

        // when
        final var exception = assertThrows(IllegalArgumentException.class, () -> validateNotNullPropertiesWithCustomMessagesPerProperty(new Object[][]{
                {objectsToValidate[0], "null :)"},
                {objectsToValidate[1], "Invalid Double"},
                {objectsToValidate[2], "Invalid Integer"},
                {objectsToValidate[3], "Invalid Example Object"},
                {objectsToValidate[4], "null :)"}
        }));


        // then
        assertThat(exception.getMessage()).isEqualTo("null :)");
    }

    @Test
    public void shouldReturnTrueWhenObjectCanBeSerializedTest() {
        // when
        final boolean result = isObjectCanBeSerialized(new SomethingWentTerribleWrongError(EMPTY_STRING));

        // then
        assertThat(result).isFalse();
    }

    @Test
    public void shouldReturnFalseWhenObjectCannotBeSerializedTest() {
        // when
        final boolean result = isObjectCanBeSerialized(new Exception());

        // then
        assertThat(result).isTrue();
    }

    @Test
    public void twoIntsNotEqualShouldThrowExceptionWhenBothIntsAreEqual() {
        // given
        int number1 = 1;
        int number2 = 1;

        // when
        final var exception = assertThrows(IllegalArgumentException.class, () -> validateTwoIntsNotEqual(number1, number2));

        // then
        assertThat(exception.getMessage()).isEqualTo("Both numbers cannot be equals, but both numbers are 1 and 1.");
    }

    @Test
    public void twoIntsNotEqualShouldPassWhenBothIntsAreNotEqual() {
        // given
        int number1 = randomPositiveInteger(9);
        int number2 = randomIntegerExcluding(0, 10, new int[]{number1});

        // debug info
        LOGGER.debug(String.format("Number1: %d and Number2: %d", number1, number2));

        // when
        validateTwoIntsNotEqual(number1, number2);

        // then pass if no exception thrown
    }

    @Test
    public void validateMinValueIsSmallerThanMaxValueShouldThrowExceptionWhenMinValueIsGreaterThanMaxValue() {

        // given
        int maxValue = randomPositiveInteger(MAX_SMALL_VALUE_RANGE);
        int minValue = MAX_SMALL_VALUE_RANGE + randomPositiveInteger(MAX_SMALL_VALUE_RANGE);

        // when
        final var exception = assertThrows(IllegalArgumentException.class, () -> validateMinValueIsSmallerThanMaxValue(minValue, maxValue));

        // then
        assertThat(exception.getMessage()).isEqualTo("MinValue (" + minValue + ") must be lower than MaxValue(" + maxValue + ")");
    }

    @Test
    public void validateMinValueIsSmallerThanMaxValueShouldThrowExceptionWhenMinValueIsEqualsThanMaxValue() {

        // given
        int value = randomPositiveInteger(MAX_SMALL_VALUE_RANGE);

        // when
        final var exception = assertThrows(IllegalArgumentException.class, () -> validateMinValueIsSmallerThanMaxValue(value, value));

        // then
        assertThat(exception.getMessage()).isEqualTo("MinValue (" + value + ") must be lower than MaxValue(" + value + ")");
    }

    @Test
    public void validateMinValueIsSmallerThanMaxValueShouldBeValidatedWhenMinValueIsSmallerThanMaxValue() {

        // given
        int minValue = randomPositiveInteger(MAX_SMALL_VALUE_RANGE);
        int maxValue = minValue + randomPositiveInteger(MAX_SMALL_VALUE_RANGE) + 1;

        // when
        validateMinValueIsSmallerThanMaxValue(minValue, maxValue);

        // then nothing happen, which means value are valid
    }

    @Test
    public void validateValueIsSmallerOrEqualsThatOtherValueShouldThrowExceptionWhenMinValueIsGreaterThanMaxValue() {

        // given
        int maxValue = randomPositiveInteger(MAX_SMALL_VALUE_RANGE);
        int minValue = MAX_SMALL_VALUE_RANGE + randomPositiveInteger(MAX_SMALL_VALUE_RANGE);

        // when
        final var exception = assertThrows(IllegalArgumentException.class, () -> validateValueIsSmallerOrEqualsThatOtherValue(minValue, maxValue));

        // then
        assertThat(exception.getMessage()).isEqualTo("Value (" + minValue + ") must be lower or equals to than Other Value(" + maxValue + ")");
    }

    @Test
    public void validateValueIsSmallerOrEqualsThatOtherValueShouldBeValidatedWhenValueIsEqualsToOtherValue() {

        // given
        int value = randomPositiveInteger(MAX_SMALL_VALUE_RANGE);

        // when
        validateValueIsSmallerOrEqualsThatOtherValue(value, value);

        // then nothing happen, which means value are valid
    }

    @Test
    public void validateValueIsSmallerOrEqualsThatOtherValueShouldBeValidatedWhenMinValueIsSmallerThanMaxValue() {

        // given
        int minValue = randomPositiveInteger(MAX_SMALL_VALUE_RANGE);
        int maxValue = minValue + randomPositiveInteger(MAX_SMALL_VALUE_RANGE);

        // when
        validateValueIsSmallerOrEqualsThatOtherValue(minValue, maxValue);

        // then nothing happen, which means value are valid
    }

    @Test
    public void validateIfNotNullShouldValidateIfObjectIsPassed() {
        // when
        validateIfObjectValueIsNotNull(ZERO);

        // then nothing happen, which means value are valid
    }

    @Test
    public void validateIfNotNullShouldThrowExceptionIfInputIsNull() {
        // when
        final var exception = assertThrows(IllegalArgumentException.class, () -> validateIfObjectValueIsNotNull(null));

        // then nothing happen, which means value are valid
        assertThat(exception.getMessage()).isEqualTo("Value cannot be null.");


    }

    @Test
    public void validateNegativeBigDecimalShouldThrowExceptionIfNull() {
        // when
        final var exception = assertThrows(IllegalArgumentException.class, () -> validateNegativeBigDecimal(null));

        // then
        assertThat(exception.getMessage()).isEqualTo("Value cannot be null.");
    }

    @Test
    public void validateNegativeBigDecimalShouldThrowExceptionIfValueIsPositive() {
        // given
        BigDecimal value = new BigDecimal(1 + new Random().nextInt(MAX_SMALL_VALUE_RANGE));

        // when
        final var exception = assertThrows(IllegalArgumentException.class, () -> validateNegativeBigDecimal(value));

        // then
        assertThat(exception.getMessage()).isEqualTo("Value cannot be positive");
    }

    @Test
    public void validateNegativeBigDecimalShouldPassWithoutExceptionForNegativeValue() {
        // given
        final BigDecimal value = new BigDecimal(1 + new Random().nextInt(MAX_SMALL_VALUE_RANGE)).negate();

        // when
        validateNegativeBigDecimal(value);

        // then nothing happen, which means value are valid
    }

    @Test
    public void validatePositiveBigDecimalShouldThrowExceptionIfNull() {
        // when
        final var exception = assertThrows(IllegalArgumentException.class, () -> validateIfPositiveNumber(null));

        // then
        assertThat(exception.getMessage()).isEqualTo("Value cannot be null.");

    }

    @Test
    public void validatePositiveBigDecimalShouldThrowExceptionIfValueIsNegative() {
        // given
        BigDecimal value = new BigDecimal(1 + new Random().nextInt(MAX_SMALL_VALUE_RANGE)).negate();

        // when
        final var exception = assertThrows(IllegalArgumentException.class, () -> validateIfPositiveNumber(value));

        // then
        assertThat(exception.getMessage()).isEqualTo("Value must be positive value.");

    }

    @Test
    public void validatePositiveBigDecimalShouldPassWithoutExceptionForPositiveValue() {
        // given
        final BigDecimal value = new BigDecimal(1 + new Random().nextInt(MAX_SMALL_VALUE_RANGE));

        // when
        validateIfPositiveNumber(value);

        // then nothing happen, which means value are valid
    }

    @Test
    public void validateIfPositiveNumberShouldThrowExceptionIfIntegerValueIsNegative() {
        // given
        final int negativeInteger = -1;

        // when
        final var exception = assertThrows(IllegalArgumentException.class, () -> validateIfPositiveNumber(negativeInteger));

        // then
        assertThat(exception.getMessage()).isEqualTo("Value {" + negativeInteger + "}  must be positive value.");
    }

    @Test
    public void validateIfPositiveNumberShouldPassWithoutExceptionForPositiveIntegerValue() {
        // given
        final int positiveInteger = new Random().nextInt(100) + 1;

        // when
        validateIfPositiveNumber(positiveInteger);

        // then nothing happen, which means value are valid
    }

    @Test
    public void validateIfPositiveNumberShouldThrowExceptionIfIntegerValueWithCustomValueNameIsNegative() {
        // given
        final int negativeInteger = -1;
        final String customName = "CustomValueName";

        // when
        final var exception = assertThrows(IllegalArgumentException.class, () -> validateIfPositiveNumber(negativeInteger, customName));

        // then
        assertThat(exception.getMessage()).isEqualTo("CustomValueName {" + negativeInteger + "}  must be positive value.");
    }

    @Test
    public void validateIfPositiveNumberWithCustomValueNameShouldPassWithoutExceptionForPositiveIntegerValue() {
        // given
        final int positiveInteger = new Random().nextInt(100) + 1;

        // when
        validateIfPositiveNumber(positiveInteger, generateString());

        // then nothing happen, which means value are valid
    }

    @Test
    public void validateIfNotEmptyShouldThrowIllegalArgumentExceptionIfNull() {
        // when
        assertThrows(IllegalArgumentException.class, () -> validateIfNotEmpty(null));

    }

    @Test
    public void validateIfNotEmptyShouldThrowIllegalArgumentExceptionIfEmpty() {
        // when
        assertThrows(IllegalArgumentException.class, () -> validateIfNotEmpty(EMPTY_STRING));
    }

    @Test
    public void validateIfNotEmptyShouldValidateForNonEmptyInput() {
        // given
        final String text = generateString();

        // when
        validateIfNotEmpty(text);

        // then nothing happen, which means value are valid
    }

    @Test
    public void validateIfNotEmptyShouldThrowIllegalArgumentExceptionIfNullWithCustomObjectName() {
        // given
        final String objectName = generateString(MAX_SMALL_VALUE_RANGE);

        // when
        final var exception = assertThrows(IllegalArgumentException.class, () -> validateIfNotEmpty((String) null, objectName));

        // then
        assertThat(exception.getMessage()).isEqualTo(objectName + " cannot be null or empty.");
    }

    @Test
    public void validateIfNotEmptyShouldThrowIllegalArgumentExceptionIfEmptyWithCustomObjectName() {
        // given
        final String objectName = generateString(MAX_SMALL_VALUE_RANGE);

        // when
        final var exception = assertThrows(IllegalArgumentException.class, () -> validateIfNotEmpty(EMPTY_STRING, objectName));

        // then
        assertThat(exception.getMessage()).isEqualTo(objectName + " cannot be null or empty.");
    }

    @Test
    public void validateIfNotEmptyShouldValidateForNonEmptyInputWithCustomObjectName() {
        // given
        final String text = generateString();

        // when
        validateIfNotEmpty(text, UNUSED_OBJECT_NAME);

        // then nothing happen, which means value are valid
    }

    @Test
    public void validateIfListIsNotEmptyShouldThrowIllegalArgumentExceptionIfNullWithCustomObjectName() {
        // given
        final String objectName = generateString(MAX_SMALL_VALUE_RANGE);

        // when
        final var exception = assertThrows(IllegalArgumentException.class, () -> validateIfListIsNotEmpty(null, objectName));

        // then
        assertThat(exception.getMessage()).isEqualTo(objectName + " cannot be null or empty.");
    }

    @Test //TODO figure out why is list.clear() exists
    public void validateIfListIsNotEmptyShouldThrowIllegalArgumentExceptionIfEmptyWithCustomObjectName() {
        // given
        final String objectName = generateString(MAX_SMALL_VALUE_RANGE);
        List<String> list = new ArrayList<>();
        //TODO remove me? list.clear();
        // when
        final var exception = assertThrows(IllegalArgumentException.class, () -> validateIfListIsNotEmpty(list, objectName));

        // then
        assertThat(exception.getMessage()).isEqualTo(objectName + " cannot be null or empty.");
    }

    @Test
    public void validateIfListIsNotEmptyShouldValidateForNonEmptyInputWithCustomObjectName() {
        // given
        List<String> list = new ArrayList<>();
        list.add(generateString(MAX_SMALL_VALUE_RANGE));

        // when
        validateIfListIsNotEmpty(list, UNUSED_OBJECT_NAME);

        // then nothing happen, which means value are valid
    }

    @Test
    public void validateIfStringArrayIsNotEmptyShouldThrowIllegalArgumentExceptionIfStringsIsNull() {
        // when
        final var exception = assertThrows(IllegalArgumentException.class, () -> validateIfStringArrayIsNotEmpty(null));

        // then
        assertThat(exception.getMessage()).isEqualTo("Input cannot be null or empty.");
    }

    @Test
    public void validateIfStringArrayIsNotEmptyShouldThrowIllegalArgumentExceptionIfStringsIsEmpty() {
        // when
        final var exception = assertThrows(IllegalArgumentException.class, () -> validateIfStringArrayIsNotEmpty(new String[0]));

        // then
        assertThat(exception.getMessage()).isEqualTo("Input cannot be null or empty.");
    }

    @Test
    public void validateIfStringArrayIsNotEmptyShouldValidateForNonEmptyStringArray() {
        // given
        final String[] stringArray = {generateString()};

        // when
        validateIfStringArrayIsNotEmpty(stringArray);

        // then nothing happen, which means value are valid

    }

    @Test
    public void validateIfPathExistsShouldThrowIllegalArgumentExceptionIfPathIsNull() {
        // when
        final var exception = assertThrows(IllegalArgumentException.class, () -> validateIfFileIsAccessible(null));

        // then
        assertThat(exception.getMessage()).isEqualTo(PATH_IS_NULL_OR_EMPTY);

    }

    @Test
    public void validateIfPathExistsShouldThrowIllegalArgumentExceptionIfPathIsEmpty() {
        // when
        final var exception = assertThrows(IllegalArgumentException.class, () -> validateIfFileIsAccessible(EMPTY_STRING));

        // then
        assertThat(exception.getMessage()).isEqualTo(PATH_IS_NULL_OR_EMPTY);
    }

    @Test
    public void validateIfPathExistsShouldThrowIllegalArgumentExceptionIfPathDoNotExists() {
        // when
        final var exception = assertThrows(IllegalArgumentException.class, () -> validateIfFileIsAccessible(generateString()));

        // then
        assertThat(exception.getMessage()).isEqualTo(PATH_TO_FILE_IS_INVALID_ERROR_MESSAGE);

    }

    @Test
    public void validateIfPathExistsShouldThrowIllegalArgumentExceptionIfPathIsDirectory() {
        // when
        final var exception = assertThrows(IllegalArgumentException.class, () -> validateIfFileIsAccessible(BASE_PATH));

        // then
        assertThat(exception.getMessage()).isEqualTo(PATH_TO_FILE_IS_INVALID_ERROR_MESSAGE);

    }

    @Test
    public void shouldValidateIfPathExists() {
        // given
        final String path = BASE_PATH + "example.txt";

        // debug
        System.out.println(Paths.get(".").toAbsolutePath().normalize().toString());
        System.out.println(BASE_PATH);
        System.out.println(path);

        // when
        validateIfFileIsAccessible(path);

        // then nothing happen, which means value are valid

    }

    @Test
    public void isValueInRangeShouldThrowExceptionIfMinValueIsHigherThanMaxValue() {
        // when
        assertThrows(IllegalArgumentException.class, () -> isValueInRange(10, 0, 3));

    }

    @Test
    public void isValueInRangeShouldReturnTrueIfIsInRange() {
        // given
        final int valueInRange = 3;

        // when
        final boolean result = isValueInRange(START_RANGE, END_RANGE, valueInRange);

        // then
        assertThat(result).isTrue();
    }

    @Test
    public void isValueInRangeShouldReturnFalseIfValueToSmall() {
        // given
        final int tooSmallValue = -1;

        // when
        final boolean result = isValueInRange(START_RANGE, END_RANGE, tooSmallValue);

        // then
        assertThat(result).isFalse();
    }

    @Test
    public void isValueInRangeShouldReturnFalseIfValueToBig() {
        // given
        final int tooBigValue = 11;

        // when
        final boolean result = isValueInRange(START_RANGE, END_RANGE, tooBigValue);

        // then
        assertThat(result).isFalse();
    }

    @Test
    public void shouldValidateIfValuesIsInRange() {
        // given
        final int min = 0;
        final int max = 10;
        int[] valuesInRange = {1, 2, 4, 9};

        // when
        validateIfValuesIsInRange(min, max, valuesInRange);

        // then nothing happen, which means value are valid
    }

    @Test
    public void validateIfValuesIsInRangeShouldThrowIllegalArgumentExceptionIfMinValueIsHigherThanMaxValue() {
        // given
        final int min = 10;
        final int max = 0;
        int[] valuesInRange = {1, 2, 4, 9};

        // when
        final var exception = assertThrows(IllegalArgumentException.class, () -> validateIfValuesIsInRange(min, max, valuesInRange));

        // then
        assertThat(exception.getMessage()).isEqualTo(format("MinValue (%d) must be lower than MaxValue(%d)", min, max));

    }

    @Test
    public void validateIfValuesIsInRangeShouldThrowIllegalArgumentExceptionIfOneOfValuesIsLowerThanMinValue() {
        // given
        final int min = 3;
        final int max = 10;
        int[] valuesInRange = {1, 2, 4, 9};

        // when
        final var exception = assertThrows(IllegalArgumentException.class, () -> validateIfValuesIsInRange(min, max, valuesInRange));

        // then
        assertThat(exception.getMessage()).isEqualTo("One of values is not in range.");

    }

    @Test
    public void validateIfValuesIsInRangeShouldThrowIllegalArgumentExceptionIfOneOfValuesIsHigherThanMaxValue() {
        // given
        final int min = 0;
        final int max = 5;
        int[] valuesInRange = {1, 2, 4, 9};

        // when
        final var exception = assertThrows(IllegalArgumentException.class, () -> validateIfValuesIsInRange(min, max, valuesInRange));

        // then
        assertThat(exception.getMessage()).isEqualTo("One of values is not in range.");
    }

    @Test
    public void validateIfValuesIsInRangeShouldThrowIllegalArgumentExceptionIfValuesSizeIsZero() {

        // given
        final int min = 0;
        final int max = 5;
        int[] valuesInRange = new int[0];

        // when
        final var exception = assertThrows(IllegalArgumentException.class, () -> validateIfValuesIsInRange(min, max, valuesInRange));


        // then
        assertThat(exception.getMessage()).isEqualTo("Values array cannot be null or empty.");
    }

    @Test
    public void validateIfSumOfIntegerIsInIntegerValueRangeShouldThrowIllegalArgumentException() {
        // when
        final var exception = assertThrows(IllegalArgumentException.class, () -> ValidatorUtils.validateIfSumOfIntegerIsInIntegerValueRange(Integer.MAX_VALUE, Integer.MAX_VALUE));

        // then
        assertThat(exception.getMessage()).isEqualTo("Range may produce number bigger than valid range for integer.");

    }

    @Test
    public void shouldValidateIfSumOfIntegerIsInIntegerValueRange() {
        // given
        final int min = 1;
        final int max = 5;

        // when
        ValidatorUtils.validateIfSumOfIntegerIsInIntegerValueRange(min, max);

        // then nothing happen if sum of 2 values in valid integer range.
    }

    @Test
    public void validateIfArrayHasSizeOfShouldThrowExceptionIfArrayIsNull() {
        // when
        assertThrows(IllegalArgumentException.class, () -> validateIfArrayHasSizeOf(randomPositiveInteger(), null, generateString()));

    }

    @Test
    public void validateIfArrayHasSizeOfShouldThrowExceptionIfSizeIsNegative() {
        // when
        assertThrows(IllegalArgumentException.class, () -> validateIfArrayHasSizeOf(randomNegativeInteger(), new String[]{generateString()}, generateString()));

    }

    @Test
    public void validateIfArrayHasSizeOfShouldNotThrowExceptionIfArrayLengthIsNotEqualsToSize() {
        // given
        final String what = generateString();

        // when
        final var exception = assertThrows(IllegalArgumentException.class, () -> validateIfArrayHasSizeOf(2, new String[]{generateString()}, what));

        // then
        assertThat(exception.getMessage()).isEqualTo(what + " has incorrect size. It should be 2 but was 1.");
    }

    @Test
    public void validateIfArrayHasSizeOfShouldNotThrowException() {

        // given
        final String[] array = {generateString()};
        final String what = generateString();

        // when
        validateIfArrayHasSizeOf(1, array, what);

        // then no exception is thrown
    }

    @Test
    public void shouldValidateIfNotBlank() {
        // when
        validateIfNotBlank("UFO", "alien");

        // then no exception is thrown

    }

    @Test
    public void shouldThrowExceptionIfStringIsBlankBecauseIsNull() {
        // when
        final var exception = assertThrows(IllegalArgumentException.class, () -> validateIfNotBlank(null, FIELD_NAME));

        // then
        assertThat(exception.getMessage()).isEqualTo(FIELD_NAME + " is blank because: String is null");

    }

    @Test
    public void shouldThrowExceptionIfStringIsBlankBecauseIsEmpty() {
        // when
        final var exception = assertThrows(IllegalArgumentException.class, () -> validateIfNotBlank(EMPTY_STRING, FIELD_NAME));

        // then
        assertThat(exception.getMessage()).isEqualTo(FIELD_NAME + " is blank because: String is empty");

    }

    @Test
    public void shouldThrowExceptionIfStringIsBlankBecauseHasSpacesOnly() {
        // when
        final var exception = assertThrows(IllegalArgumentException.class, () -> validateIfNotBlank("  ", FIELD_NAME));

        // then no exception is thrown
        assertThat(exception.getMessage()).isEqualTo(FIELD_NAME + " is blank because: String is blank");

    }

    @Test
    public void validateIfPathIsAccessibleShould() {
        // when
        assertThrows(IllegalArgumentException.class, () -> ValidatorUtils.validateIfPathIsAccessible(Path.of("X:/cosmos")));

    }

    @Test
    public void validateIfValueIsInRangeShouldThrowExceptionIfValueIsSmallerThanValue() {
        // given
        final int min = 0;
        final int max = 10;
        final int tooLowNumber = -1;

        // when
        assertThrows(IllegalArgumentException.class, () -> ValidatorUtils.validateIfValueIsInRange(min, max, tooLowNumber));

    }

    @Test
    public void validateIfValueIsInRangeShouldThrowExceptionIfValueIsLargerThanMaxValue() {
        // given
        final int min = 0;
        final int max = 10;
        final int tooHighNumber = 11;

        // when
        assertThrows(IllegalArgumentException.class, () -> ValidatorUtils.validateIfValueIsInRange(min, max, tooHighNumber));

    }

    @Test
    public void shouldValidateIfValueIsInRange() {
        // given
        final int min = 0;
        final int max = 10;
        final int inRangeNumber = 8;

        // when
        ValidatorUtils.validateIfValueIsInRange(min, max, inRangeNumber);
    }
}
