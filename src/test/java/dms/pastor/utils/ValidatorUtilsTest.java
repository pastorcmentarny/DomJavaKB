package dms.pastor.utils;

import dms.pastor.domain.ExampleObject;
import dms.pastor.domain.exception.SomethingWentTerribleWrongError;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static dms.pastor.utils.StringUtils.EMPTY_STRING;
import static dms.pastor.utils.ValidatorUtils.*;
import static dms.pastor.utils.randoms.RandomDataGenerator.*;
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

    private static final String UNUSED_OBJECT_NAME = null;

    @Rule
    public final ExpectedException expectedException = ExpectedException.none();

    private ExampleObject anObject;

    @Before
    public void setUp() throws Exception {
        anObject = new ExampleObject();
    }

    @Test
    public void shouldValidateNotNullProperties() {
        // when
        final boolean actual = isAnyOfPropertiesContainsNull(anObject.getADouble(), anObject.getInteger());

        // then
        assertThat(actual).isTrue();
    }

    @Test
    public void validateNotNullPropertiesShouldNotValidateIfHasNullProperties() {
        // when
        final boolean actual = isAnyOfPropertiesContainsNull(anObject.getADouble(), null, anObject.getInteger());

        // then
        assertThat(actual).isFalse();
    }

    @Test
    public void shouldValidateForValidateNotNullPropertiesWithCustomMessage() {
        // given
        final Object[] objectsToValidate = {anObject.getADouble(), anObject.getInteger()};
        // when
        validateNotNullPropertiesWithCustomMessage(objectsToValidate, "parameter is invalid");

        // then if valid then no exception was thrown
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionWhenValidatingNotNullPropertiesWithCustomMessage() {

        // given
        final Object[] arrayWithSomeNulls = {null, anObject.getString(), anObject.getADouble(), null};

        // except
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("one of parameters is rubbish");

        // when
        validateNotNullPropertiesWithCustomMessage(arrayWithSomeNulls, "one of parameters is rubbish");
    }

    @Test
    public void shouldValidateForValidateNotNullPropertiesWithCustomMessages() {
        // given
        final Object[] objectsToValidate = {anObject.getADouble(), anObject.getInteger(), anObject.getString()};

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
        final Object[] objectsToValidate = {null, anObject.getADouble(), anObject.getInteger(), anObject.getString(), null};

        // except
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("null :)");

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
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Both numbers cannot be equals, but both numbers are 1 and 1.");

        // when
        validateTwoIntsNotEqual(number1, number2);
    }

    @Test
    public void twoIntsNotEqualShouldPassWhenBothIntsAreNotEqual() throws Exception {
        // given
        int number1 = randomPositiveInteger();
        int number2 = number1 + 1;
        //TODO uncomment when method implement int number2 = randomIntegerExcluding(0,Integer.MAX_VALUE,number1);
        System.out.println(":) " + number1 + " and " + number2);

        // when
        validateTwoIntsNotEqual(number1, number2);

        // then pass if no exception thrown
    }

    //randomIntegerBiggerThan(int number)

    @Test
    public void validateMinValueIsSmallerThanMaxValueShouldThrowExceptionWhenMinValueIsGreaterThanMaxValue() throws Exception {

        // given
        int maxValue = randomInteger(MAX_SMALL_VALUE);
        int minValue = MAX_SMALL_VALUE + randomInteger(MAX_SMALL_VALUE);

        // exception
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("MinValue (" + minValue + ") must be lower than MaxValue(" + maxValue + ")");

        // when
        validateMinValueIsSmallerThanMaxValue(minValue, maxValue);
    }

    @Test
    public void validateMinValueIsSmallerThanMaxValueShouldBeValidatedWhenMinValueIsSmallerThanMaxValue() throws Exception {

        // given
        int minValue = randomInteger(MAX_SMALL_VALUE);
        int maxValue = minValue + randomInteger(MAX_SMALL_VALUE);

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
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Value cannot be null");

        // when
        validateIfNotNull(null);

        // then nothing happen, which means value are valid
    }

    @Test
    public void validateNegativeBigDecimalShouldThrowExceptionIfNull() throws Exception {
        // expect
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Value cannot be null");

        // when
        validateNegativeBigDecimal(null);
    }

    @Test
    public void validateNegativeBigDecimalShouldThrowExceptionIfValueIsPositive() throws Exception {
        // expect
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Value cannot be positive");

        // given
        BigDecimal value = new BigDecimal(1 + new Random().nextInt(MAX_SMALL_VALUE));

        // when
        validateNegativeBigDecimal(value);

    }

    @Test
    public void validateNegativeBigDecimalShouldPassWithoutExceptionForNegativeValue() throws Exception {
        // given
        final BigDecimal value = new BigDecimal(1 + new Random().nextInt(MAX_SMALL_VALUE)).negate();

        // when
        validateNegativeBigDecimal(value);

        // then nothing happen, which means value are valid
    }

    @Test
    public void validatePositiveBigDecimalShouldThrowExceptionIfNull() throws Exception {
        // expect
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Value cannot be null");

        // when
        ValidatorUtils.validateIfPositiveNumber(null);
    }

    @Test
    public void validatePositiveBigDecimalShouldThrowExceptionIfValueIsNegative() throws Exception {
        // expect
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Value cannot be negative.");

        // given
        BigDecimal value = new BigDecimal(1 + new Random().nextInt(MAX_SMALL_VALUE)).negate();

        // when
        ValidatorUtils.validateIfPositiveNumber(value);

    }

    @Test
    public void validatePositiveBigDecimalShouldPassWithoutExceptionForPositiveValue() throws Exception {
        // given
        final BigDecimal value = new BigDecimal(1 + new Random().nextInt(MAX_SMALL_VALUE));

        // when
        ValidatorUtils.validateIfPositiveNumber(value);

        // then nothing happen, which means value are valid
    }

    @Test
    public void validateIfPositiveNumberShouldThrowExceptionIfIntegerValueIsNegative() throws Exception {
        // expect
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Value cannot be negative.");

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
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("CustomValueName cannot be negative.");

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
        expectedException.expect(IllegalArgumentException.class);

        // when
        validateIfNotEmpty(null);
    }

    @Test
    public void validateIfNotEmptyShouldThrowIllegalArgumentExceptionIfEmpty() throws Exception {
        // expect
        expectedException.expect(IllegalArgumentException.class);

        // when
        validateIfNotEmpty("");
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
        final String objectName = generateString(MAX_SMALL_VALUE);

        // expect
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage(objectName + " cannot be null or empty.");

        // when
        validateIfNotEmpty(null, objectName);
    }

    @Test
    public void validateIfNotEmptyShouldThrowIllegalArgumentExceptionIfEmptyWithCustomObjectName() throws Exception {
        // given
        final String objectName = generateString(MAX_SMALL_VALUE);

        // expect
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage(objectName + " cannot be null or empty.");
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
        final String objectName = generateString(MAX_SMALL_VALUE);

        // expect
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage(objectName + " cannot be null or empty.");

        // when
        validateIfListIsNotEmpty(null, objectName);
    }

    @Test
    public void validateIfListIsNotEmptyShouldThrowIllegalArgumentExceptionIfEmptyWithCustomObjectName() throws Exception {
        // given
        final String objectName = generateString(MAX_SMALL_VALUE);
        List<String> list = new ArrayList<>();
        list.clear();

        // expect
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage(objectName + " cannot be null or empty.");

        // when
        validateIfListIsNotEmpty(list, objectName);
    }

    @Test
    public void validateIfListIsNotEmptyShouldValidateForNonEmptyInputWithCustomObjectName() throws Exception {
        // given
        List<String> list = new ArrayList<>();
        list.add(generateString(MAX_SMALL_VALUE));

        // when
        validateIfListIsNotEmpty(list, UNUSED_OBJECT_NAME);

        // then nothing happen, which means value are valid
    }

    @SuppressWarnings("ConstantConditions") // it is purpose of test
    @Test
    public void validateIfNotEmptyShouldReturnFalseIfNull() throws Exception {
        // when
        final boolean result = validateIfStringNotEmpty(null);

        // then
        assertThat(result).isFalse();
    }

    @Test
    public void validateIfNotEmptyShouldReturnFalseIfEmpty() throws Exception {
        // when
        final boolean result = validateIfStringNotEmpty(EMPTY_STRING);

        // then
        assertThat(result).isFalse();
    }

    @Test
    public void validateIfNotEmptyShouldReturnTrueForNonEmptyInput() throws Exception {
        // given
        final String text = "A String";

        // when
        final boolean result = validateIfStringNotEmpty(text);

        // then
        assertThat(result).isTrue();
    }

    @Test
    public void validateIfStringArrayIsNotEmptyShouldThrowIllegalArgumentExceptionIfStringsIsNull() {
        // expect
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Input cannot be null or empty.");

        // when
        validateIfStringArrayIsNotEmpty(null);
    }

    @Test
    public void validateIfStringArrayIsNotEmptyShouldThrowIllegalArgumentExceptionIfStringsIsEmpty() {
        // expect
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Input cannot be null or empty.");

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

}
