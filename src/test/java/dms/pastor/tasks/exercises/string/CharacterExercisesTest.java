package dms.pastor.tasks.exercises.string;

import org.junit.Before;
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
    private CharacterExercises exercise;

    @Before
    public void setUp() throws Exception {
        exercise = new CharacterExercises();
    }

    @Test
    public void testShouldFound1DInDominik() throws Exception {
        assertThat(exercise.countCharacterInString('D', "Dominik")).isEqualTo(1);
    }

    @Test
    public void testShouldFound10LInLlanfairpwll() throws Exception {
        assertThat(exercise.countCharacterInString('L', "Llanfairpwllgwyngyllgogerychwyrndrobwllllantysiliogogogoch")).isEqualTo(11);
    }

    @Test
    public void runCountCharInStringExercise() {
        char charToCount = 'l';
        String word = "Llanfairpwllgwyngyllgogerychwyrndrobwllllantysiliogogogoch";
        assertThat(exercise.countCharacterInStringIgnoringCase(charToCount, word)).isEqualTo(11);
    }

    @SuppressWarnings("SpellCheckingInspection")
    @Test
    public void testAlternatingCharacters() throws Exception {
        String good = "ABABA";
        assertThat(exercise.alternatingCharacters(good)).isEqualTo(0);
    }

    //because there is one duplicate of the same letter bb
    @Test
    public void testAlternatingCharactersWillReturn1() throws Exception {
        String one = "BABB";
        assertThat(exercise.alternatingCharacters(one)).isEqualTo(1);
    }

    //because there are 3 the same character one after another so is 2
    @SuppressWarnings("SpellCheckingInspection")
    @Test
    public void testAlteringCharactersWillReturn2() throws Exception {
        String two = "ABBBA";
        assertThat(exercise.alternatingCharacters(two)).isEqualTo(2);
    }
}