package dms.pastor.tasks.exercises.string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static dms.pastor.tasks.exercises.string.RemoveCharacterFromString.removeCharacterFromStringUsingIterative;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author Dominik Symonowicz
 * Created 11/09/2016
* Website: <a href="https://dominiksymonowicz.com/">Home Page</a>
* LinkedIn: <a href="https://www.linkedin.com/in/dominik-symonowicz">LinkedIn</a>
* GitHub: <a href="https://github.com/pastorcmentarny">GitHub</a>
 * <p>
 * Info: Happy path only
 */
public class RemoveCharacterFromStringTest {

    private static final String TEST = "Test";
    private static final char CHARACTER_T = 't';
    private static final String EXPECTED_RESULT = "es";


    @Test
    public void shouldRemoveCharacterFromStringUsingIterativeTest() {
        // when
        final String result = removeCharacterFromStringUsingIterative(TEST);

        // then
        assertThat(result).isEqualTo(EXPECTED_RESULT);
    }

    @Test
    public void removeCharacterFromStringUsingIterativeShouldThrowExceptionWhenTextIsNullTest() {
        // when
        Assertions.assertThrows(IllegalArgumentException.class, () -> removeCharacterFromStringUsingIterative(null));


    }

    @Test
    public void shouldRemoveCharacterFromStringUsingRecursiveTest() {
        // when
        final String result = RemoveCharacterFromString.removeCharacterFromStringUsingRecursive(TEST, CHARACTER_T);

        // then
        assertThat(result).isEqualTo(EXPECTED_RESULT);
    }
}