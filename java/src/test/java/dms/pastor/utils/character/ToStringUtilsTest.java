package dms.pastor.utils.character;

import org.junit.jupiter.api.Test;

import java.util.LinkedHashSet;

import static dms.pastor.utils.randoms.RandomDataGenerator.getRandomCharacterFromAlphabet;
import static dms.pastor.utils.randoms.RandomDataGenerator.getRandomCharacterFromAlphabetExcludingCharacter;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author Dominik Symonowicz
 * Created 06/11/2017
 * WWW:	<a href="https://dominiksymonowicz.com/">HOME PAGE</a>
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class ToStringUtilsTest {
    @Test
    public void linkedHashSetToStringShouldReturnEmptyStringForNullInput() {
        // when
        final String result = ToStringUtils.toString(null);

        // then
        assertThat(result).isEmpty();
    }

    @Test
    public void linkedHashSetToStringShouldReturnEmptyForEmptySet() {
        // given
        LinkedHashSet<Character> characterSet = new LinkedHashSet<>();

        // when
        final String result = ToStringUtils.toString(characterSet);

        // then
        assertThat(result).isEmpty();

    }

    @Test
    public void linkedHashSetToStringShouldReturnLinkedHashSetAsString() {
        // given
        final Character character = getRandomCharacterFromAlphabet();
        final Character character2 = getRandomCharacterFromAlphabetExcludingCharacter(character);
        LinkedHashSet<Character> characterSet = new LinkedHashSet<>();
        characterSet.add(character);
        characterSet.add(character2);

        // when
        final String result = ToStringUtils.toString(characterSet);

        // debug
        System.out.println(result);
        System.out.println(character);
        System.out.println(character2);

        // then
        assertThat(result).isEqualToIgnoringCase(String.valueOf(character) + character2);

    }
}