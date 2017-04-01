package dms.pastor.tasks.exercises.string;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;

/**
 * Author Dominik Symonowicz
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
public class CharacterExercisesTest {
    private CharacterExercises exercise;

    @Before
    public void setUp() throws Exception {
        exercise = new CharacterExercises();
    }

    @Test
    public void testShouldFound1DInDominik() throws Exception {
        Assert.assertThat(exercise.countCharacterInString('D', "Dominik"), is(1));
    }

    @Test
    public void testShouldFound10LInLlanfairpwll() throws Exception {
        Assert.assertThat(exercise.countCharacterInString('L', "Llanfairpwllgwyngyllgogerychwyrndrobwllllantysiliogogogoch"), is(11));
    }

    @Test
    public void runCountCharInStringExercise() {
        char charToCount = 'l';
        String word = "Llanfairpwllgwyngyllgogerychwyrndrobwllllantysiliogogogoch";
        Assert.assertThat(exercise.countCharacterInStringIgnoringCase(charToCount, word), is(11));
    }

    @SuppressWarnings("SpellCheckingInspection")
    @Test
    public void testAlternatingCharacters() throws Exception {
        String good = "ABABA";
        Assert.assertThat(exercise.alternatingCharacters(good), is(0));
    }

    //because there is one duplicate of the same letter bb
    @Test
    public void testAlternatingCharactersWillReturn1() throws Exception {
        String one = "BABB";
        Assert.assertThat(exercise.alternatingCharacters(one), is(1));
    }

    //because there are 3 the same character one after another so is 2
    @SuppressWarnings("SpellCheckingInspection")
    @Test
    public void testAlteringCharactersWillReturn2() throws Exception {
        String two = "ABBBA";
        Assert.assertThat(exercise.alternatingCharacters(two), is(2));
    }
}