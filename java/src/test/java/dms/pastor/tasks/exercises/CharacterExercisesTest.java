package dms.pastor.tasks.exercises;

import dms.pastor.tasks.exercises.string.CharacterExercises;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author Dominik Symonowicz
* Website: <a href="https://dominiksymonowicz.com/">Home Page</a>
* LinkedIn: <a href="https://www.linkedin.com/in/dominik-symonowicz">LinkedIn</a>
* GitHub: <a href="https://github.com/pastorcmentarny">GitHub</a>
 */
public class CharacterExercisesTest {

    @Test
    public void shouldBe10LInWordLlanfairpwllgwyngyllgogerychwyrndrobwllllantysiliogogogoch() {
        // given
        CharacterExercises test = new CharacterExercises();
        char character = 'l';
        final String word = "Llanfairpwllgwyngyllgogerychwyrndrobwllllantysiliogogogoch";
        final int result = 11;

        // when
        final int actual = test.countCharacterInString(character, word);


        // then
        assertThat(actual).isEqualTo(result);
    }
}