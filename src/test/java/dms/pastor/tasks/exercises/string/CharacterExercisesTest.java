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

    private static final String LLANFARPWLL = "Llanfairpwllgwyngyllgogerychwyrndrobwllllantysiliogogogoch";
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
        assertThat(exercise.countCharacterInString('L', LLANFARPWLL)).isEqualTo(11);
    }

    @Test
    public void runCountCharInStringExercise() {
        char charToCount = 'l';
        assertThat(exercise.countCharacterInStringIgnoringCase(charToCount, LLANFARPWLL)).isEqualTo(11);
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
        String firstString = "BABB";
        assertThat(exercise.alternatingCharacters(firstString)).isEqualTo(1);
    }

    //because there are 3 the same character one after another so is 2
    @SuppressWarnings("SpellCheckingInspection")
    @Test
    public void testAlteringCharactersWillReturn2() throws Exception {
        String secondString = "ABBBA";
        assertThat(exercise.alternatingCharacters(secondString)).isEqualTo(2);
    }
}