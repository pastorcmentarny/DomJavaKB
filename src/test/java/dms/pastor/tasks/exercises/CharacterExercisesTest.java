package dms.pastor.tasks.exercises;

import dms.pastor.tasks.exercises.string.CharacterExercises;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author Dominik Symonowicz
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class CharacterExercisesTest {

    @SuppressWarnings("InstanceMethodNamingConvention")
    @Test
    public void shouldBe10LInWordLlanfairpwllgwyngyllgogerychwyrndrobwllllantysiliogogogoch() throws Exception {
        CharacterExercises test = new CharacterExercises();
        char character = 'l';
        final String word = "Llanfairpwllgwyngyllgogerychwyrndrobwllllantysiliogogogoch";
        final int actual = test.countCharacterInString(character, word);
        assertThat(actual).isEqualTo(11);
    }
}