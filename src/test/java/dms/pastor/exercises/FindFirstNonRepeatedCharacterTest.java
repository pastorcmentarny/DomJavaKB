package dms.pastor.exercises;

import dms.pastor.exercises.string.FindFirstNonRepeatedCharacter;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author Dominik Symonowicz
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
public class FindFirstNonRepeatedCharacterTest {

    private final FindFirstNonRepeatedCharacter findFirst = new FindFirstNonRepeatedCharacter();

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void shouldThrowIllegalArgumentExceptionWhenTextIsNullTest() throws Exception {

        // expect
        exception.expect(IllegalArgumentException.class);

        // when
        findFirst.findFirstNonRepeatedCharacter(null);

    }

    @Test
    @SuppressWarnings("SpellCheckingInspection")
    public void testFindFirstNonRepeatedCharacter() throws Exception {
        // when
        final Optional<Character> characters = findFirst.findFirstNonRepeatedCharacter("aabbcddefg");

        // then
        assertThat(characters.isPresent()).isTrue();
        assertThat(new Character('c')).isEqualTo(characters.orElse(null));

    }
}