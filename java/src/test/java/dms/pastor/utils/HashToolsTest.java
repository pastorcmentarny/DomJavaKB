package dms.pastor.utils;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.HashMap;
import java.util.HashSet;

import static dms.pastor.utils.HashTools.stringToCharacterMap;
import static dms.pastor.utils.HashTools.stringToCharacterSet;
import static dms.pastor.utils.StringUtils.ALPHABET;
import static dms.pastor.utils.StringUtils.EMPTY_STRING;
import static dms.pastor.utils.randoms.RandomDataGenerator.generateString;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.sameInstance;

/**
 * Author Dominik Symonowicz
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class HashToolsTest {

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void shouldConvertStringToCharacterMapTest() {
        // when
        final HashMap<Character, Integer> characterIntegerHashMap = stringToCharacterMap(ALPHABET + ALPHABET);

        // then
        Assert.assertEquals(ALPHABET.length(), characterIntegerHashMap.size());
        characterIntegerHashMap.forEach((key, value) -> Assert.assertThat(value, sameInstance(2)));

    }

    @Test
    public void stringToCharacterSetThrowIllegalArgumentExceptionIfNull() {
        // expect
        exception.expect(IllegalArgumentException.class);

        // when
        stringToCharacterSet(null);
    }

    @Test
    public void stringToCharacterSetThrowIllegalArgumentExceptionIfEmpty() {
        // expect
        exception.expect(IllegalArgumentException.class);

        // when
        stringToCharacterSet(EMPTY_STRING);
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
        Assert.assertThat(characters, notNullValue());
        Assert.assertEquals(ALPHABET.length(), characters.size());

    }

}
