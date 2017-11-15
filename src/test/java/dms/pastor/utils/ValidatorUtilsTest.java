package dms.pastor.utils;

import dms.pastor.domain.ExampleObject;
import dms.pastor.domain.exception.SomethingWentTerribleWrongError;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.rules.Timeout;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.math.BigDecimal;
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

    @Rule
    public Timeout globalTimeout = Timeout.seconds(3); // global time out for all tests

    private ExampleObject anObject;

    @Before
    public void setUp() throws Exception {
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
    public void shouldReturnTrueWhenObjectCanBeSerializedTest() throws Exception {

        // when
        final boolean result = isObjectCanBeSerialized(new SomethingWentTerribleWrongError(""));

        // then
        assertThat(result).isFalse();
    }

    @Test
    public void shouldReturnFalseWhenObjectCannotBeSerializedTest() throws Exception {
        // when
        final boolean result = isObjectCanBeSerialized(new Exception());

        // then
        assertThat(result).isTrue();
    }

    @Test
    public void twoIntsNotEqualShouldThrowExceptionWhenBothIntsAreEqual() throws Exception {
        // given
        int number1 = 1;
        int number2 = 1;

        // exception
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Both numbers cannot be equals, but both numbers are 1 and 1.");

        // when
        validateTwoIntsNotEqual(number1, number2);
    }

    @Test //TODO fix test hang up (infitive loop ?
    public void twoIntsNotEqualShouldPassWhenBothIntsAreNotEqual() throws Exception {
        // given
        int number1 = randomPositiveInteger(9);
        int number2 = randomIntegerExcluding(0, 10, new int[]{number1});

        // debug info
        LOGGER.debug(":) " + number1 + " and " + number2);

        // when
        validateTwoIntsNotEqual(number1, number2);

        // then pass if no exception thrown
    }

    @Test
    public void validateMinValueIsSmallerThanMaxValueShouldThrowExceptionWhenMinValueIsGreaterThanMaxValue() throws Exception {

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
    public void validateMinValueIsSmallerThanMaxValueShouldBeValidatedWhenMinValueIsSmallerThanMaxValue() throws Exception {

        // given
        int minValue = randomPositiveInteger(MAX_SMALL_VALUE_RANGE);
        int maxValue = minValue + randomPositiveInteger(MAX_SMALL_VALUE_RANGE);

        // when
        validateMinValueIsSmallerThanMaxValue(minValue, maxValue);

        // then nothing happen, which means value are valid
    }

    @Test
    public void validateIfNotNullShouldValidateIfObjectIsPassed() throws Exception {

        // when
        validateIfNotNull(ZERO);

        // then nothing happen, which means value are valid
    }

    @SuppressWarnings("ConstantConditions")
    @Test
    public void validateIfNotNullShouldThrowExceptionIfInputIsNull() throws Exception {
        // expect
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Value cannot be null");

        // when
        validateIfNotNull(null);

        // then nothing happen, which means value are valid
    }

    @Test
    public void validateNegativeBigDecimalShouldThrowExceptionIfNull() throws Exception {
        // expect
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Value cannot be null");

        // when
        validateNegativeBigDecimal(null);
    }

    @Test
    public void validateNegativeBigDecimalShouldThrowExceptionIfValueIsPositive() throws Exception {
        // expect
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Value cannot be positive");

        // given
        BigDecimal value = new BigDecimal(1 + new Random().nextInt(MAX_SMALL_VALUE_RANGE));

        // when
        validateNegativeBigDecimal(value);

    }

    @Test
    public void validateNegativeBigDecimalShouldPassWithoutExceptionForNegativeValue() throws Exception {
        // given
        final BigDecimal value = new BigDecimal(1 + new Random().nextInt(MAX_SMALL_VALUE_RANGE)).negate();

        // when
        validateNegativeBigDecimal(value);

        // then nothing happen, which means value are valid
    }

    @Test
    public void validatePositiveBigDecimalShouldThrowExceptionIfNull() throws Exception {
        // expect
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Value cannot be null");

        // when
        ValidatorUtils.validateIfPositiveNumber(null);
    }

    @Test
    public void validatePositiveBigDecimalShouldThrowExceptionIfValueIsNegative() throws Exception {
        // expect
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Value cannot be negative.");

        // given
        BigDecimal value = new BigDecimal(1 + new Random().nextInt(MAX_SMALL_VALUE_RANGE)).negate();

        // when
        ValidatorUtils.validateIfPositiveNumber(value);

    }

    @Test
    public void validatePositiveBigDecimalShouldPassWithoutExceptionForPositiveValue() throws Exception {
        // given
        final BigDecimal value = new BigDecimal(1 + new Random().nextInt(MAX_SMALL_VALUE_RANGE));

        // when
        ValidatorUtils.validateIfPositiveNumber(value);

        // then nothing happen, which means value are valid
    }

    @Test
    public void validateIfPositiveNumberShouldThrowExceptionIfIntegerValueIsNegative() throws Exception {
        // expect
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Value cannot be negative.");

        // given
        final int negativeInteger = -1;

        // when
        ValidatorUtils.validateIfPositiveNumber(negativeInteger);

    }

    @Test
    public void validateIfPositiveNumberShouldPassWithoutExceptionForPositiveIntegerValue() throws Exception {
        // given
        final int positiveInteger = new Random().nextInt(100);

        // when
        ValidatorUtils.validateIfPositiveNumber(positiveInteger);

        // then nothing happen, which means value are valid
    }

    @Test
    public void validateIfPositiveNumberShouldThrowExceptionIfIntegerValueWithCustomValueNameIsNegative() throws Exception {
        // expect
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("CustomValueName cannot be negative.");

        // given
        final int negativeInteger = -1;
        final String customName = "CustomValueName";

        // when
        ValidatorUtils.validateIfPositiveNumber(negativeInteger, customName);
    }

    @Test
    public void validateIfPositiveNumberWithCustomValueNameShouldPassWithoutExceptionForPositiveIntegerValue() throws Exception {
        // given
        final int positiveInteger = new Random().nextInt(100);

        // when
        ValidatorUtils.validateIfPositiveNumber(positiveInteger, generateString());

        // then nothing happen, which means value are valid
    }

    @SuppressWarnings("ConstantConditions") //as it is part of test
    @Test
    public void validateIfNotEmptyShouldThrowIllegalArgumentExceptionIfNull() throws Exception {
        // expect
        exception.expect(IllegalArgumentException.class);

        // when
        validateIfNotEmpty(null);
    }

    @Test
    public void validateIfNotEmptyShouldThrowIllegalArgumentExceptionIfEmpty() throws Exception {
        // expect
        exception.expect(IllegalArgumentException.class);

        // when
        validateIfNotEmpty(EMPTY_STRING);
    }

    @Test
    public void validateIfNotEmptyShouldValidateForNonEmptyInput() throws Exception {
        // given
        final String text = generateString();

        // when
        validateIfNotEmpty(text);

        // then nothing happen, which means value are valid
    }

    @Test
    public void validateIfNotEmptyShouldThrowIllegalArgumentExceptionIfNullWithCustomObjectName() throws Exception {
        // given
        final String objectName = generateString(MAX_SMALL_VALUE_RANGE);

        // expect
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage(objectName + " cannot be null or empty.");

        // when
        validateIfNotEmpty((String) null, objectName);
    }

    @Test
    public void validateIfNotEmptyShouldThrowIllegalArgumentExceptionIfEmptyWithCustomObjectName() throws Exception {
        // given
        final String objectName = generateString(MAX_SMALL_VALUE_RANGE);

        // expect
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage(objectName + " cannot be null or empty.");
        // when
        validateIfNotEmpty(EMPTY_STRING, objectName);
    }

    @Test
    public void validateIfNotEmptyShouldValidateForNonEmptyInputWithCustomObjectName() throws Exception {
        // given
        final String text = generateString();

        // when
        validateIfNotEmpty(text, UNUSED_OBJECT_NAME);

        // then nothing happen, which means value are valid
    }

    @Test
    public void validateIfListIsNotEmptyShouldThrowIllegalArgumentExceptionIfNullWithCustomObjectName() throws Exception {
        // given
        final String objectName = generateString(MAX_SMALL_VALUE_RANGE);

        // expect
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage(objectName + " cannot be null or empty.");

        // when
        validateIfListIsNotEmpty(null, objectName);
    }

    @Test
    public void validateIfListIsNotEmptyShouldThrowIllegalArgumentExceptionIfEmptyWithCustomObjectName() throws Exception {
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
    public void validateIfListIsNotEmptyShouldValidateForNonEmptyInputWithCustomObjectName() throws Exception {
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
        final String path = BASE_PATH + File.separator + "example.txt";

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

        // when
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

        // when
        final int min = 0;
        final int max = 5;
        int[] valuesInRange = new int[0];

        // when
        validateIfValuesIsInRange(min, max, valuesInRange);
    }

}
