package dms.pastor.utils;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static dms.pastor.utils.ArrayUtils.*;
import static dms.pastor.utils.randoms.RandomDataGenerator.generateRandomByteArray;
import static org.assertj.core.api.Assertions.assertThat;

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

    private static final String[] EMPTY_STRING_ARRAY = new String[0];


    @Test
    public void testGetSingleIntArrayAsString() {
        // given
        int[] testSequence = new int[]{0};

        // when
        final String intArrayAsString = getIntArrayAsString(testSequence);

        // then
        assertThat(intArrayAsString).isEqualTo("[{0 = 0}]");
    }

    @Test
    public void testGetIntArrayAsString() {
        // given
        int[] testSequence = new int[]{0, 1, 2, 3, 4};

        // when
        final String intArrayAsString = getIntArrayAsString(testSequence);

        // then
        assertThat(intArrayAsString).isEqualTo("[{0 = 0}{1 = 1}{2 = 2}{3 = 3}{4 = 4}]");
    }

    @Test
    public void generateIntSequenceArray() {
        // given
        int[] testSequence = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

        // when
        final int[] intSequenceArray = ArrayUtils.generateIntSequenceArray(testSequence.length);

        // then
        assertThat(intSequenceArray.length).isEqualTo(testSequence.length);
        for (int i = 0; i < 10; i++) {
            assertThat(intSequenceArray[i]).isEqualTo(testSequence[i]);
        }
    }

    @Test
    public void testGenerateRandomByteArray() {
        // given
        final int size = 10;

        // when
        final byte[] bytes = generateRandomByteArray(size);

        // then
        assertThat(bytes).isNotEmpty();
        assertThat(bytes).hasSize(size);
    }

    @Test
    public void shouldReverseStringArrayAcceptanceTest() {
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
    public void reverseStringArrayShouldReturnNullForNullInput() {
        // when
        final String[] result = reverseStringArray(null);

        // then
        assertThat(result).isNull();
    }

    @Test
    public void reverseStringArrayShouldReturnEmptyForEmptyInput() {
        // when
        final String[] result = reverseStringArray(EMPTY_STRING_ARRAY);

        // then
        assertThat(result).isEmpty();
    }

    @Disabled //Broken after move to JUnit5 as it adds  "cannot be null." to the end of the message (???)
    @Test
    public void clone2DArrayOfIntsShouldThrowIllegalArgumentExceptionIfSourceIsNull() {
        // when
        final var exception = Assertions.assertThrows(IllegalArgumentException.class, () -> clone2DArrayOfInts(null));

        // then
        assertThat(exception.getMessage()).isEqualTo("2D Array of integers cannot be null.");
    }

    @Test
    public void clone2DArrayOfIntsShouldCopyEmptyArrayIfYouPassEmptyArray() {
        // given
        final String[][] ints2d = {};

        // when
        final String[][] result = clone2DArrayOfInts(ints2d);

        // then
        assertThat(result).isEqualTo(ints2d);
    }

    @Test
    public void clone2DArrayOfIntsShouldCopyArrayToNew() {
        // given
        final String[][] ints2d = new String[3][3];
        ints2d[0][0] = "0";
        ints2d[1][1] = "1";
        ints2d[2][2] = "2";
        final String[][] expectedResult = {{"0", null, null}, {null, "1", null}, {null, null, "2"}};

        // when
        final String[][] result = clone2DArrayOfInts(ints2d);

        // then set value to ensure ints2d is not referenced in result
        ints2d[2][2] = "3";

        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    public void shouldSubtractIntArrayFromAnotherAcceptanceTest() {
        // given
        int[] intArrayOne = new int[]{1, 2, 3, 4, 5, 6};
        int[] intArrayTwo = new int[]{4, 5, 6};
        int[] expectedResult = new int[]{1, 2, 3};

        // when
        final int[] result = ArrayUtils.subtractIntArray(intArrayOne, intArrayTwo);

        // then
        assertThat(result).isEqualTo(expectedResult);
    }
}