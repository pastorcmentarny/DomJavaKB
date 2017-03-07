package dms.pastor.utils;

import dms.pastor.domain.ExampleObject;
import dms.pastor.domain.exception.SomethingWentTerribleWrongError;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static dms.pastor.utils.ValidatorUtils.*;
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
}
