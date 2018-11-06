package dms.pastor.tasks.exercises;

import dms.pastor.tasks.exercises.string.FindFirstNonRepeatedCharacter;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author Dominik Symonowicz
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class FindFirstNonRepeatedCharacterTest {

    private final FindFirstNonRepeatedCharacter findFirst = new FindFirstNonRepeatedCharacter();

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void shouldThrowIllegalArgumentExceptionWhenTextIsNullTest() {

        // expect
        exception.expect(IllegalArgumentException.class);

        // when
        findFirst.findFirstNonRepeatedCharacter(null);

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