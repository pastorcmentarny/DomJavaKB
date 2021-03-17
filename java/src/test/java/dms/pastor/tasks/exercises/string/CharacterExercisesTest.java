package dms.pastor.tasks.exercises.string;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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

    @BeforeEach
    public void setUp() {
        exercise = new CharacterExercises();
    }

    @Test
    public void testShouldFound1DInDominik() {
        // when
        final var result = exercise.countCharacterInString('D', "Dominik");

        // then
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void testShouldFound10LInLlanfairpwll() {
        // when
        final var result = exercise.countCharacterInString('L', LLANFARPWLL);

        // then
        assertThat(result).isEqualTo(11);
    }

    @Test
    public void runCountCharInStringExercise() {
        // given
        char charToCount = 'l';

        // when
        final var result = exercise.countCharacterInStringIgnoringCase(charToCount, LLANFARPWLL);

        // then
        assertThat(result).isEqualTo(11);
    }

    @Test
    public void testAlternatingCharacters() {
        // given
        String good = "ABABA";

        // when
        final var result = exercise.alternatingCharacters(good);

        // then
        assertThat(result).isEqualTo(0);
    }

    //because there is one duplicate of the same letter bb
    @Test
    public void testAlternatingCharactersWillReturn1() {
        // given
        String firstString = "BABB";

        // when
        final var result = exercise.alternatingCharacters(firstString);

        // then
        assertThat(result).isEqualTo(1);
    }

    //because there are 3 the same character one after another so is 2
    @SuppressWarnings("SpellCheckingInspection")
    @Test
    public void testAlteringCharactersWillReturn2() {
        // givem
        String secondString = "ABBBA";

        // when
        final var result = exercise.alternatingCharacters(secondString);

        // then
        assertThat(result).isEqualTo(2);
    }
}