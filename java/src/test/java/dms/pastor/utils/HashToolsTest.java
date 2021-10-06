package dms.pastor.utils;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;

import static dms.pastor.utils.HashTools.stringToCharacterMap;
import static dms.pastor.utils.HashTools.stringToCharacterSet;
import static dms.pastor.utils.StringUtils.ALPHABET;
import static dms.pastor.utils.StringUtils.EMPTY_STRING;
import static dms.pastor.utils.randoms.RandomDataGenerator.generateString;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author Dominik Symonowicz
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class HashToolsTest {


    @Test
    public void shouldConvertStringToCharacterMapTest() {
        // when
        final HashMap<Character, Integer> characterIntegerHashMap = stringToCharacterMap(ALPHABET + ALPHABET);

        // then
        assertThat(ALPHABET.length()).isEqualTo(characterIntegerHashMap.size());
        characterIntegerHashMap.forEach((key, value) -> assertThat(value).isEqualTo(2));

    }

    @Test
    public void stringToCharacterSetThrowIllegalArgumentExceptionIfNull() {
        // when
        Assertions.assertThrows(IllegalArgumentException.class, () -> stringToCharacterSet(null));
    }

    @Test
    public void stringToCharacterSetThrowIllegalArgumentExceptionIfEmpty() {
        // when
        Assertions.assertThrows(IllegalArgumentException.class, () -> stringToCharacterSet(EMPTY_STRING));
    }

    @SuppressWarnings({"ResultOfMethodCallIgnored", "QuestionableName"})
    @Test // because result doesn't matter in this case
    public void stringToCharacterSetShouldConvertTextToListOfCharacters() {
        // given
        final String string = generateString(10);
        // when
        final HashSet<Character> result = stringToCharacterSet(string);

        // then
        for (int i = 0; i < string.length(); i++) {
            result.contains(string.charAt(i));
        }
    }

    @Test
    public void shouldConvertStringToCharacterSetTest() {
        // when
        final HashSet<Character> characters = stringToCharacterSet(ALPHABET);

        // then
        assertThat(characters).isNotNull();
        assertThat(ALPHABET.length()).isEqualTo(characters.size());

    }

}
