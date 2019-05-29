package dms.pastor.utils;

import dms.pastor.domain.ExampleObject;
import dms.pastor.domain.exception.SomethingWentTerribleWrongError;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
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

/**
 * Author Dominik Symonowicz
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class ValidatorUtilsTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(ValidatorUtilsTest.class);
    private static final String UNUSED_OBJECT_NAME = null;
    private static final int START_RANGE = 0;
    private static final int END_RANGE = 10;
    private static final String PATH_TO_FILE_IS_INVALID_ERROR_MESSAGE = "Path to file is invalid.";

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    private ExampleObject anObject;

    @Before
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

        // except
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("one of parameters is rubbish");

        // when
        validateNotNullPropertiesWithCustomMessage(arrayWithSomeNulls, "one of parameters is rubbish");
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

        // except
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("null :)");

        // when
        validateNotNullPropertiesWithCustomMessagesPerProperty(new Object[][]{
                {objectsToValidate[0], "null :)"},
                {objectsToValidate[1], "Invalid Double"},
                {objectsToValidate[2], "Invalid Integer"},
                {objectsToValidate[3], "Invalid Example Object"},
                {objectsToValidate[4], "null :)"}
        });
    }

    @Test
    public void shouldReturnTrueWhenObjectCanBeSerializedTest() {

        // when
        final boolean result = isObjectCanBeSerialized(new SomethingWentTerribleWrongError(""));

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

        // exception
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Both numbers cannot be equals, but both numbers are 1 and 1.");

        // when
        validateTwoIntsNotEqual(number1, number2);
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

        // exception
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("MinValue (" + minValue + ") must be lower than MaxValue(" + maxValue + ")");

        // when
        validateMinValueIsSmallerThanMaxValue(minValue, maxValue);
    }

    @Test
    public void validateMinValueIsSmallerThanMaxValueShouldThrowExceptionWhenMinValueIsEqualsThanMaxValue() {

        // given
        int value = randomPositiveInteger(MAX_SMALL_VALUE_RANGE);

        // exception
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("MinValue (" + value + ") must be lower than MaxValue(" + value + ")");

        // when
        validateMinValueIsSmallerThanMaxValue(value, value);
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

        // exception
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Value (" + minValue + ") must be lower or equals to than Other Value(" + maxValue + ")");

        // when
        validateValueIsSmallerOrEqualsThatOtherValue(minValue, maxValue);
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

    @SuppressWarnings("ConstantConditions")
    @Test
    public void validateIfNotNullShouldThrowExceptionIfInputIsNull() {
        // expect
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Value cannot be null");

        // when
        validateIfObjectValueIsNotNull(null);

        // then nothing happen, which means value are valid
    }

    @Test
    public void validateNegativeBigDecimalShouldThrowExceptionIfNull() {
        // expect
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Value cannot be null");

        // when
        validateNegativeBigDecimal(null);
    }

    @Test
    public void validateNegativeBigDecimalShouldThrowExceptionIfValueIsPositive() {
        // expect
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Value cannot be positive");

        // given
        BigDecimal value = new BigDecimal(1 + new Random().nextInt(MAX_SMALL_VALUE_RANGE));

        // when
        validateNegativeBigDecimal(value);

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
        // expect
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Value cannot be null");

        // when
        ValidatorUtils.validateIfPositiveNumber(null);
    }

    @Test
    public void validatePositiveBigDecimalShouldThrowExceptionIfValueIsNegative() {
        // expect
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Value must be positive value.");

        // given
        BigDecimal value = new BigDecimal(1 + new Random().nextInt(MAX_SMALL_VALUE_RANGE)).negate();

        // when
        ValidatorUtils.validateIfPositiveNumber(value);

    }

    @Test
    public void validatePositiveBigDecimalShouldPassWithoutExceptionForPositiveValue() {
        // given
        final BigDecimal value = new BigDecimal(1 + new Random().nextInt(MAX_SMALL_VALUE_RANGE));

        // when
        ValidatorUtils.validateIfPositiveNumber(value);

        // then nothing happen, which means value are valid
    }

    @Test
    public void validateIfPositiveNumberShouldThrowExceptionIfIntegerValueIsNegative() {

        // given
        final int negativeInteger = -1;

        // expect
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Value {" + negativeInteger + "}  must be positive value.");


        // when
        ValidatorUtils.validateIfPositiveNumber(negativeInteger);

    }

    @Test
    public void validateIfPositiveNumberShouldPassWithoutExceptionForPositiveIntegerValue() {
        // given
        final int positiveInteger = new Random().nextInt(100);

        // when
        ValidatorUtils.validateIfPositiveNumber(positiveInteger);

        // then nothing happen, which means value are valid
    }

    @Test
    public void validateIfPositiveNumberShouldThrowExceptionIfIntegerValueWithCustomValueNameIsNegative() {
        // given
        final int negativeInteger = -1;
        final String customName = "CustomValueName";

        // expect
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("CustomValueName {" + negativeInteger + "}  must be positive value.");

        // when
        ValidatorUtils.validateIfPositiveNumber(negativeInteger, customName);
    }

    //FIXME flaky
    @Test
    public void validateIfPositiveNumberWithCustomValueNameShouldPassWithoutExceptionForPositiveIntegerValue() {
        // given
        final int positiveInteger = new Random().nextInt(100);

        // when
        ValidatorUtils.validateIfPositiveNumber(positiveInteger, generateString());

        // then nothing happen, which means value are valid
    }

    @SuppressWarnings("ConstantConditions") //as it is part of test
    @Test
    public void validateIfNotEmptyShouldThrowIllegalArgumentExceptionIfNull() {
        // expect
        exception.expect(IllegalArgumentException.class);

        // when
        validateIfNotEmpty(null);
    }

    @Test
    public void validateIfNotEmptyShouldThrowIllegalArgumentExceptionIfEmpty() {
        // expect
        exception.expect(IllegalArgumentException.class);

        // when
        validateIfNotEmpty(EMPTY_STRING);
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

        // expect
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage(objectName + " cannot be null or empty.");

        // when
        validateIfNotEmpty((String) null, objectName);
    }

    @Test
    public void validateIfNotEmptyShouldThrowIllegalArgumentExceptionIfEmptyWithCustomObjectName() {
        // given
        final String objectName = generateString(MAX_SMALL_VALUE_RANGE);

        // expect
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage(objectName + " cannot be null or empty.");
        // when
        validateIfNotEmpty(EMPTY_STRING, objectName);
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

        // expect
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage(objectName + " cannot be null or empty.");

        // when
        validateIfListIsNotEmpty(null, objectName);
    }

    @Test
    public void validateIfListIsNotEmptyShouldThrowIllegalArgumentExceptionIfEmptyWithCustomObjectName() {
        // given
        final String objectName = generateString(MAX_SMALL_VALUE_RANGE);
        List<String> list = new ArrayList<>();
        list.clear();

        // expect
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage(objectName + " cannot be null or empty.");

        // when
        validateIfListIsNotEmpty(list, objectName);
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
        // expect
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Input cannot be null or empty.");

        // when
        validateIfStringArrayIsNotEmpty(null);
    }

    @Test
    public void validateIfStringArrayIsNotEmptyShouldThrowIllegalArgumentExceptionIfStringsIsEmpty() {
        // expect
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Input cannot be null or empty.");

        // when
        validateIfStringArrayIsNotEmpty(new String[0]);
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
        // expect
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage(PATH_TO_FILE_IS_INVALID_ERROR_MESSAGE);

        // when
        validateIfPathExists(null);
    }

    @Test
    public void validateIfPathExistsShouldThrowIllegalArgumentExceptionIfPathIsEmpty() {
        // expect
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage(PATH_TO_FILE_IS_INVALID_ERROR_MESSAGE);

        // when
        validateIfPathExists(EMPTY_STRING);
    }

    @Test
    public void validateIfPathExistsShouldThrowIllegalArgumentExceptionIfPathDoNotExists() {
        // expect
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage(PATH_TO_FILE_IS_INVALID_ERROR_MESSAGE);

        // when
        validateIfPathExists(generateString());
    }

    @Test
    public void validateIfPathExistsShouldThrowIllegalArgumentExceptionIfPathIsDirectory() {
        // expect
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage(PATH_TO_FILE_IS_INVALID_ERROR_MESSAGE);

        // when
        validateIfPathExists(BASE_PATH);
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
        validateIfPathExists(path);

        // then nothing happen, which means value are valid

    }

    @Test
    public void isValueInRangeShouldThrowExceptionIfMinValueIsHigherThanMaxValue() {
        // expect
        exception.expect(IllegalArgumentException.class);

        // when
        isValueInRange(10, 0, 3);
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

        // expect
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage(format("MinValue (%d) must be lower than MaxValue(%d)", min, max));

        // when
        validateIfValuesIsInRange(min, max, valuesInRange);
    }

    @Test
    public void validateIfValuesIsInRangeShouldThrowIllegalArgumentExceptionIfOneOfValuesIsLowerThanMinValue() {
        // expect
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("One of values is not in range.");

        // given
        final int min = 3;
        final int max = 10;
        int[] valuesInRange = {1, 2, 4, 9};

        // when
        validateIfValuesIsInRange(min, max, valuesInRange);
    }

    @Test
    public void validateIfValuesIsInRangeShouldThrowIllegalArgumentExceptionIfOneOfValuesIsHigherThanMaxValue() {
        // expect
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("One of values is not in range.");

        // when
        final int min = 0;
        final int max = 5;
        int[] valuesInRange = {1, 2, 4, 9};

        // when
        validateIfValuesIsInRange(min, max, valuesInRange);
    }

    @Test
    public void validateIfValuesIsInRangeShouldThrowIllegalArgumentExceptionIfValuesSizeIsZero() {
        // expect
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Values array cannot be null or empty.");

        // given
        final int min = 0;
        final int max = 5;
        int[] valuesInRange = new int[0];

        // when
        validateIfValuesIsInRange(min, max, valuesInRange);
    }

    @Test
    public void validateIfSumOfIntegerIsInIntegerValueRangeShouldThrowIllegalArgumentException() {
        // expect
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Range may produce number bigger than valid range for integer.");

        // when
        ValidatorUtils.validateIfSumOfIntegerIsInIntegerValueRange(Integer.MAX_VALUE, Integer.MAX_VALUE);
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
        // expect
        exception.expect(IllegalArgumentException.class);

        // when
        ValidatorUtils.validateIfArrayHasSizeOf(randomPositiveInteger(), null, generateString());
    }

    @Test
    public void validateIfArrayHasSizeOfShouldThrowExceptionIfSizeIsNegative() {
        // expect
        exception.expect(IllegalArgumentException.class);

        // when
        ValidatorUtils.validateIfArrayHasSizeOf(randomNegativeInteger(), new String[]{generateString()}, generateString());
    }

    @Test
    public void validateIfArrayHasSizeOfShouldNotThrowExceptionIfArrayLengthIsNotEqualsToSize() {
        // given
        final String what = generateString();

        // expect
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage(what + " has incorrect size. It should be 2 but was 1");

        // when
        ValidatorUtils.validateIfArrayHasSizeOf(2, new String[]{generateString()}, what);
    }

    @Test
    public void validateIfArrayHasSizeOfShouldNotThrowException() {

        // given
        final String[] array = {generateString()};
        final String what = generateString();

        // when
        ValidatorUtils.validateIfArrayHasSizeOf(1, array, what);

        // then no exception is thrown
    }
}
