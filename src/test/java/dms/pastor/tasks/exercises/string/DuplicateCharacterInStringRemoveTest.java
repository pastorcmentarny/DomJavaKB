package dms.pastor.tasks.exercises.string;

import org.junit.Test;

import static dms.pastor.tasks.exercises.string.DuplicateCharacterInStringRemove.removeDuplicateCharacterFromString;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author Dominik Symonowicz
 * Created 12/02/2017
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class DuplicateCharacterInStringRemoveTest {

    private static final String EMPTY_STRING = "";

    @Test
    public void shouldGetAFromStringWithACharactersOnlyAcceptanceCriteriaTest() throws Exception {
        // given
        final String stringWithACharacterOnly = "aaaa";

        // when
        final String result = removeDuplicateCharacterFromString(stringWithACharacterOnly);

        // then
        assertThat(result).isEqualToIgnoringCase("a");
    }

    @Test
    public void shouldGetABFromStringWithABCharactersOnlyAcceptanceCriteriaTest() throws Exception {
        // given
        final String stringWithACharacterOnly = "aabb";

        // when
        final String result = removeDuplicateCharacterFromString(stringWithACharacterOnly);

        // then
        assertThat(result).isEqualToIgnoringCase("ab");
    }

    @Test
    public void shouldGetABCFromStringWithContainsManyABCAcceptanceCriteriaTest() throws Exception {
        // given
        final String stringWithACharacterOnly = "abcabcacbcab";

        // when
        final String result = removeDuplicateCharacterFromString(stringWithACharacterOnly);

        // then
        assertThat(result).isEqualToIgnoringCase("abc");
    }

    @Test
    @SuppressWarnings("ConstantConditions") //because this is purpose of test
    public void shouldReturnNullWhenStringIsNull() throws Exception {
        // when
        final String result = removeDuplicateCharacterFromString(null);

        // then
        assertThat(result).isNull();
    }

    @Test
    public void shouldReturnEmptyStringWhenStringIsEmpty() throws Exception {
        // when
        final String result = removeDuplicateCharacterFromString(EMPTY_STRING);

        // then
        assertThat(result).isEmpty();
    }
}