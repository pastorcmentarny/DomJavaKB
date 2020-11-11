package dms.pastor.tasks.exercises.string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static dms.pastor.tasks.exercises.string.ReverseStringInManyWaysExercise.*;
import static dms.pastor.utils.StringUtils.EMPTY_STRING;
import static dms.pastor.utils.randoms.RandomDataGenerator.getRandomCharacterAsString;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author Dominik Symonowicz
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
@SuppressWarnings("QuestionableName") // because string is valid name
public class ReverseStringInManyWaysExerciseTest {

    private static final String TEST_STRING = "top";
    private static final String REVERSED_TEST_STRING = "pot";



    @Test
    public void shouldThrowIllegalArgumentExceptionIfInputIsNullForReverseViaStringBuilderTest() {
        // when
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
        reversStringViaStringBuilder(null);
        });

    }

    @Test
    public void shouldReversStringViaStringBuilderTest() {
        // when
        final String result = reversStringViaStringBuilder(TEST_STRING);

        // then
        assertThat(result).isEqualTo(REVERSED_TEST_STRING);
    }

    @Test
    public void shouldReturnNullIfInputIsNullForReverseViaStringBufferTest() {
        // when
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
        reversStringViaStringBuffer(null);
        });

    }

    @Test
    public void shouldReversStringViaStringBufferTest() {
        // when
        final String result = reversStringViaStringBuffer(TEST_STRING);

        // then
        assertThat(result).isEqualTo(REVERSED_TEST_STRING);
    }

    @Test
    public void shouldReturnNullIfInputIsNullForReverseViaNoLibraryImplementationTest() {
        // when
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
        reverseStringWithoutLibraries(null);
        });

    }

    @Test
    public void reverseStringWithoutLibrariesShouldReturnEmptyStringIfInputIsEmpty() {
        // when
        final String result = reverseStringWithoutLibraries(EMPTY_STRING);

        // then
        assertThat(result).isEmpty();
    }

    @Test
    public void reverseStringWithoutLibrariesShouldReturnSameStringIfLengthIsOne() {
        // given
        final String oneCharacterString = getRandomCharacterAsString();
        // when
        final String result = reverseStringWithoutLibraries(oneCharacterString);

        // then
        assertThat(result).isEqualTo(oneCharacterString);
    }

    @Test
    public void reverseStringWithoutLibrariesShouldReturnPotIfInputIsTop() {
        // when
        final String result = reverseStringWithoutLibraries(TEST_STRING);

        // then
        assertThat(result).isEqualTo(REVERSED_TEST_STRING);
    }

    @Test
    public void shouldThrowExceptionIfInputIsNullTest() {
        // when
        Assertions.assertThrows(IllegalArgumentException.class, () -> {

        reversStringViaChar(null);
        });

    }

    @Test
    public void shouldReversStringViaCharTest() {
        // given
        final String string = "dOg";
        final String reversedString = "gOd";
        // when
        final String result = reversStringViaChar(string);

        // then
        assertThat(result).isEqualTo(reversedString);
    }
}