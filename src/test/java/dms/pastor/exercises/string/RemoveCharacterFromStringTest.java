package dms.pastor.exercises.string;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author Dominik Symonowicz
 * Created 11/09/2016
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 * <p>
 * Info: Happy path only
 */
public class RemoveCharacterFromStringTest {
    private static final String TEST = "Test";
    private static final char CHARACTER_T = 't';
    private static final String EXPECTED_RESULT = "es";

    @Test
    public void shouldRemoveCharacterFromStringUsingIterativeTest() throws Exception {
        // when
        final String result = RemoveCharacterFromString.removeCharacterFromStringUsingIterative(TEST, CHARACTER_T);

        // then
        assertThat(result).isEqualTo(EXPECTED_RESULT);
    }

    @Test
    public void shouldRemoveCharacterFromStringUsingRecursiveTest() throws Exception {
        // when
        final String result = RemoveCharacterFromString.removeCharacterFromStringUsingRecursive(TEST, CHARACTER_T);

        // then
        assertThat(result).isEqualTo(EXPECTED_RESULT);
    }
}