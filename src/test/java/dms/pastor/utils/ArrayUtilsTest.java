package dms.pastor.utils;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static dms.pastor.utils.ArrayUtils.generateRandomByteArray;
import static dms.pastor.utils.ArrayUtils.reverseStringArray;
import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;

/**
 * Author Dominik Symonowicz
 * Created 2015-10-25
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class ArrayUtilsTest {

    private static final char[] CHARS_ARRAY = {};
    private static final String[] EMPTY_STRING_ARRAY = new String[0];

    @Test
    public void testGetSingleIntArrayAsString() throws Exception {
        int[] testSequence = new int[]{0};
        final String intArrayAsString = ArrayUtils.getIntArrayAsString(testSequence);
        Assert.assertThat("int as array", intArrayAsString, is("[{0 = 0}]"));
    }

    @Test
    public void testGetIntArrayAsString() throws Exception {
        int[] testSequence = new int[]{0, 1, 2, 3, 4};
        final String intArrayAsString = ArrayUtils.getIntArrayAsString(testSequence);
        Assert.assertThat("int as array", intArrayAsString, is("[{0 = 0}{1 = 1}{2 = 2}{3 = 3}{4 = 4}]"));
    }

    @Test
    public void generateIntSequenceArray() throws Exception {
        int[] testSequence = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        final int[] intSequenceArray = ArrayUtils.generateIntSequenceArray(testSequence.length);

        Assert.assertThat("compare dictSize", intSequenceArray.length, is(testSequence.length));
        for (int i = 0; i < 10; i++) {
            Assert.assertThat("i:" + i, intSequenceArray[i], is(testSequence[i]));
        }
    }

    @SuppressWarnings("ConstantConditions") // it tests if fails
    @Test(expected = IllegalArgumentException.class)
    public void testThrowExceptionIfYouConvertNullToSet() throws Exception {
        final Set<Character> testSet = ArrayUtils.convertCharArrayToSet(null);
        Assert.assertThat("dictSize", testSet.size(), is(0));
    }

    @Test
    public void testConvertEmptyArrayToSet() throws Exception {
        int size = CollectionsUtils.emptyHashSet().size();
        final Set<Character> testSet = ArrayUtils.convertCharArrayToSet(CHARS_ARRAY);
        Assert.assertThat("dictSize", testSet.size(), is(size));
        Assert.assertThat(testSet.size(), is(size));
    }

    @Test
    public void testConvertCharArrayToSet() throws Exception {
        char[] chars = new char[]{'a', 'b', 'c'};
        Set<Character> characterSet = new HashSet<>();
        characterSet.add(chars[0]);
        characterSet.add(chars[1]);
        characterSet.add(chars[2]);
        final Set<Character> testSet = ArrayUtils.convertCharArrayToSet(chars);
        Assert.assertThat("dictSize", testSet.size(), is(characterSet.size()));
        Assert.assertThat(testSet.size(), is(characterSet.size()));
    }

    @Test
    public void testGenerateRandomByteArray() throws Exception {
        final int size = 10;
        final byte[] bytes = generateRandomByteArray(size);
        assertThat(bytes).isNotEmpty();
        assertThat(bytes).hasSize(size);
    }

    @Test
    public void shouldReverseStringArrayAcceptanceTest() throws Exception {
        // given
        final String firstWord = "Dominik";
        final String secondWord = "Sarcastic";
        final String middleWord = "Software";
        final String fourthWord = "Developer";
        final String lastWord = "Chinese";

        final String[] stringArray = {firstWord, secondWord, middleWord, fourthWord, lastWord};
        final String[] expectedStringArray = {lastWord, fourthWord, middleWord, secondWord, firstWord};
        // when
        final String[] result = reverseStringArray(stringArray);

        // then
        assertThat(result).isEqualTo(expectedStringArray);
    }

    @SuppressWarnings("ConstantConditions") //part of the test
    @Test
    public void reverseStringArrayShouldReturnNullForNullInput() throws Exception {
        // when
        final String[] result = reverseStringArray(null);

        // then
        assertThat(result).isNull();
    }

    @Test
    public void reverseStringArrayShouldReturnEmptyForEmptyInput() throws Exception {
        // when
        final String[] result = reverseStringArray(EMPTY_STRING_ARRAY);

        // then
        assertThat(result).isEmpty();
    }
}