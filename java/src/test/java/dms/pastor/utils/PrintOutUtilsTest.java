package dms.pastor.utils;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;

import static dms.pastor.utils.PrintOutUtils.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Author Dominik Symonowicz
 * Created 21/04/2016
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class PrintOutUtilsTest {

    private static final byte[] BYTES = new byte[]{};

    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream original = System.out;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    public void cleanUpStreams() throws IOException {
        outputStream.close();
        System.setOut(original);
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionWhenMinimumValueIsHigherThanMaximumTest() {
        // when
        final var exception = assertThrows(IllegalArgumentException.class, () -> displayOddNumbers(10, 7));

        // then
        assertThat(exception.getMessage()).isEqualTo("MinValue (10) must be lower than MaxValue(7)");

    }

    @Test
    public void shouldThrowExceptionWhenByteArrayIsEmpty() {
        // when
        assertThrows(IllegalArgumentException.class, () -> printArray(BYTES));

    }

    @Test
    public void shouldDisplayByteArrayTest() {
        // given
        final String expected = "[1,2,3]";

        // when
        printArray(new byte[]{1, 2, 3});

        // then
        assertThat(outputStream.toString()).isEqualTo(expected);
    }

    @Test
    public void shouldThrowExceptionForEmptyStringArrayList() {
        // when
        assertThrows(IllegalArgumentException.class, () -> printArray(new ArrayList<>()));

    }

    @Test
    public void shouldDisplayStringArray() {
        // given
        String[] stringArray = new String[]{"garlic", "cheesecake", "armour"};

        // when
        final String result = printArray(stringArray);

        // then
        assertThat(result).isEqualTo("[garlic,cheesecake,armour]");
    }

    @Test
    public void shouldDisplayCharacterIntegerHashMapTest() {
        // given
        HashMap<Character, Integer> hashMap = new HashMap<>();
        hashMap.put('A', 1);
        hashMap.put('B', 10);

        // when
        printCharacterIntegerHashMap(hashMap);

        // then
        assertThat(outputStream.toString()).contains("key: A value: 1");
        assertThat(outputStream.toString()).contains("key: B value: 10");

    }

    @Test
    public void shouldDisplayOddNumbers() {
        // given
        final String expected = "1 3 5 7 9 ";
        outputStream.reset();

        // when
        displayOddNumbers(1, 10);

        // then
        assertThat(outputStream.toString()).isEqualTo(expected);
    }

    @Test
    public void printIntArrayShouldPrintIntegers() {
        // given
        Integer[] integers = new Integer[]{1, 2, 3, null};
        final String expected = "[ 1 2 3 null ]" + System.lineSeparator();

        // when
        printIntArray(integers);

        // then
        assertThat(outputStream.toString()).isEqualTo(expected);
    }

    @Test
    public void printTemporaryFolderLocation() throws Exception {
        // when
        printInfoAboutOfTemporaryFolder();
        var result = outputStream.toString();

        // debug
        System.out.println(result);

        // then
        assertThat(result).isNotBlank();

        // debug
        outputStream.close();
        System.setOut(original);


    }

}