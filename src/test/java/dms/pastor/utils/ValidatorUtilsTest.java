package dms.pastor.utils;

import dms.pastor.domain.ExampleObject;
import dms.pastor.domain.exception.SomethingWentTerribleWrongError;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.math.BigDecimal;
import java.util.Random;

import static dms.pastor.utils.RandomDataGenerator.*;
import static dms.pastor.utils.ValidatorUtils.*;
import static java.math.BigDecimal.ZERO;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author Dominik Symonowicz
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
public class ValidatorUtilsTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    private ExampleObject anObject;

    @Before
    public void setUp() throws Exception {
        anObject = new ExampleObject();
    }

    @Test
    public void shouldValidateNotNullProperties() {
        // when
        final boolean actual = validateNotNullProperties(anObject.getADouble(), anObject.getInteger());

        // then
        assertThat(actual).isTrue();
    }

    @Test
    public void validateNotNullPropertiesShouldNotValidateIfHasNullProperties() {
        // when
        final boolean actual = validateNotNullProperties(anObject.getADouble(), null, anObject.getInteger());

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
        final boolean result = validateThatObjectCanBeSerialized(new SomethingWentTerribleWrongError(""));

        // then
        assertThat(result).isFalse();
    }

    @Test
    public void shouldReturnFalseWhenObjectCannotBeSerializedTest() throws Exception {
        // when
        final boolean result = validateThatObjectCanBeSerialized(new Exception());

        // then
        assertThat(result).isTrue();
    }

    @Test
    public void twoIntsNotEqualShouldThrowExceptionWhenBothIntsAreEqual() throws Exception {
        // given
        int number1 = 1;
        int number2 = 1;

        // expectedException
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

        // expectedException
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
        BigDecimal value = new BigDecimal(1+new Random().nextInt(MAX_SMALL_VALUE));

        // when
        validateNegativeBigDecimal(value);

    }

    @Test
    public void validateNegativeBigDecimalShouldPassWithoutExceptionForNegativeValue() throws Exception {
        // given
        final BigDecimal value = new BigDecimal(1+new Random().nextInt(MAX_SMALL_VALUE)).negate();

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
        validatePositiveBigDecimal(null);
    }

    @Test
    public void validatePositiveBigDecimalShouldThrowExceptionIfValueIsNegative() throws Exception {
        // expect
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Value cannot be negative");

        // given
        BigDecimal value = new BigDecimal(1+new Random().nextInt(MAX_SMALL_VALUE)).negate();

        // when
        validatePositiveBigDecimal(value);

    }

    @Test
    public void validatePositiveBigDecimalShouldPassWithoutExceptionForPositiveValue() throws Exception {
        // given
        final BigDecimal value = new BigDecimal(1+new Random().nextInt(MAX_SMALL_VALUE));

        // when
        validatePositiveBigDecimal(value);

        // then nothing happen, which means value are valid
    }
}
