package dms.pastor.tasks.exercises.string;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static dms.pastor.tasks.exercises.string.ReverseStringInManyWaysExercise.*;
import static dms.pastor.utils.StringUtils.EMPTY_STRING;
import static dms.pastor.utils.randoms.RandomDataGenerator.getRandomCharacterAsString;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author Dominik Symonowicz
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
public class ReverseStringInManyWaysExerciseTest {

    private static final String TEST_STRING = "top";
    private static final String REVERSED_TEST_STRING = "pot";

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void shouldThrowIllegalArgumentExceptionIfInputIsNullForReverseViaStringBuilderTest() throws Exception {
        // expect
        exception.expect(IllegalArgumentException.class);

        // when
        reversStringViaStringBuilder(null);
    }

    @Test
    public void shouldReversStringViaStringBuilderTest() throws Exception {

        // when
        final String result = reversStringViaStringBuilder(TEST_STRING);

        // then
        assertThat(result).isEqualTo(REVERSED_TEST_STRING);
    }

    @Test
    public void shouldReturnNullIfInputIsNullForReverseViaStringBufferTest() throws Exception {
        // expect
        exception.expect(IllegalArgumentException.class);

        // when
        reversStringViaStringBuffer(null);
    }

    @Test
    public void shouldReversStringViaStringBufferTest() throws Exception {

        // when
        final String result = reversStringViaStringBuffer(TEST_STRING);

        // then
        assertThat(result).isEqualTo(REVERSED_TEST_STRING);
    }

    @Test
    public void shouldReturnNullIfInputIsNullForReverseViaNoLibraryImplementationTest() throws Exception {
        // expect
        exception.expect(IllegalArgumentException.class);

        // when
        reverseStringWithoutLibraries(null);
    }

    @Test
    public void reverseStringWithoutLibrariesShouldReturnEmptyStringIfInputIsEmpty() throws Exception {
        // when
        final String result = reverseStringWithoutLibraries(EMPTY_STRING);

        // then
        assertThat(result).isEmpty();
    }

    @Test
    public void reverseStringWithoutLibrariesShouldReturnSameStringIfLengthIsOne() throws Exception {
        // given
        final String oneCharacterString = getRandomCharacterAsString();

        // when
        final String result = reverseStringWithoutLibraries(oneCharacterString);

        // then
        assertThat(result).isEqualTo(oneCharacterString);
    }

    @Test
    public void reverseStringWithoutLibrariesShouldReturnPotIfInputIsTop() throws Exception {
        // when
        final String result = reverseStringWithoutLibraries(TEST_STRING);

        // then
        assertThat(result).isEqualTo(REVERSED_TEST_STRING);
    }

    @Test
    public void shouldThrowExceptionIfInputIsNullTest() throws Exception {
        // except
        exception.expect(IllegalArgumentException.class);

        // when
        reversStringViaChar(null);
    }

    @Test
    public void shouldReversStringViaCharTest() throws Exception {
        // given
        final String string = "dOg";
        final String reversedString = "gOd";

        // when
        final String result = reversStringViaChar(string);

        // then
        assertThat(result).isEqualTo(reversedString);
    }
}