package dms.pastor.utils;


import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;

import static dms.pastor.utils.HashTools.stringToCharacterMap;
import static dms.pastor.utils.StringUtils.ALPHABET;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.sameInstance;

/**
 * Author Dominik Symonowicz
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
public class HashToolsTest {

    @Test
    public void shouldConvertStringToCharacterMapTest() throws Exception {
        // when
        final HashMap<Character, Integer> characterIntegerHashMap = stringToCharacterMap(ALPHABET + ALPHABET);

        // then
        Assert.assertEquals(ALPHABET.length(), characterIntegerHashMap.size());
        characterIntegerHashMap.entrySet().forEach(entry -> Assert.assertThat(entry.getValue(), sameInstance(2)));

    }


    @Test
    public void shouldConvertStringToCharacterSetTest() throws Exception {
        // when
        final HashSet<Character> characters = HashTools.stringToCharacterSet(ALPHABET);

        // then
        Assert.assertThat(characters, notNullValue());
        Assert.assertEquals(ALPHABET.length(), characters.size());

    }

}