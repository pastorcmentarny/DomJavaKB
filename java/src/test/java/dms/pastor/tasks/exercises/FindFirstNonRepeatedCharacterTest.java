package dms.pastor.tasks.exercises;

import dms.pastor.tasks.exercises.string.FindFirstNonRepeatedCharacter;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Author Dominik Symonowicz
* Website: <a href="https://dominiksymonowicz.com/">Home Page</a>
* LinkedIn: <a href="https://www.linkedin.com/in/dominik-symonowicz">LinkedIn</a>
* GitHub: <a href="https://github.com/pastorcmentarny">GitHub</a>
 */
public class FindFirstNonRepeatedCharacterTest {

    private final FindFirstNonRepeatedCharacter findFirst = new FindFirstNonRepeatedCharacter();

    @Test
    public void shouldThrowIllegalArgumentExceptionWhenTextIsNullTest() {
        // when
        assertThrows(IllegalArgumentException.class, () -> findFirst.findFirstNonRepeatedCharacter(null));

    }

    @Test
    @SuppressWarnings("SpellCheckingInspection")
    public void testFindFirstNonRepeatedCharacter() {
        // when
        final Optional<Character> characters = findFirst.findFirstNonRepeatedCharacter("aabbcddefg");

        // then
        assertThat(characters.isPresent()).isTrue();
        assertThat(Character.valueOf('c')).isEqualTo(characters.orElse(null));

    }
}