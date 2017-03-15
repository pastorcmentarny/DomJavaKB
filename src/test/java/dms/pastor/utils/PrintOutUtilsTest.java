package dms.pastor.utils;

import org.junit.*;
import org.junit.rules.ExpectedException;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;

import static dms.pastor.utils.PrintOutUtils.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.containsString;

/**
 * Author Dominik Symonowicz
 * Created 21/04/2016
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
public class PrintOutUtilsTest {

    private static final byte[] BYTES = new byte[]{};

    @SuppressWarnings("resource")
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream original = System.out;

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outputStream));
    }

    @After
    public void cleanUpStreams() throws IOException {
        outputStream.close();
        System.setOut(original);
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionWhenMinimumValueIsHigherThanMaximumTest() throws Exception {
        // except
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("MinValue (10) must be lower than MaxValue(7)");

        // when
        displayOddNumbers(10, 7);
    }

    @Test
    public void shouldThrowExceptionWhenByteArrayIsEmpty() throws Exception {
        // exception
        exception.expect(IllegalArgumentException.class);

        // when
        printArray(BYTES);
    }

    @Test
    public void shouldDisplayByteArrayTest() throws Exception {
        // given
        final String expected = "[1,2,3]";

        // when
        printArray(new byte[]{1, 2, 3});

        // then
        assertThat(outputStream.toString()).isEqualTo(expected);
    }

    @Test
    public void shouldThrowExceptionForEmptyStringArrayList() {
        // except
        exception.expect(IllegalArgumentException.class);

        // when
        printArray(new ArrayList<>());
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
    public void shouldDisplayCharacterIntegerHashMapTest() throws Exception {
        // given
        HashMap<Character, Integer> hashMap = new HashMap<>();
        hashMap.put('A', 1);
        hashMap.put('B', 10);
        // when
        printCharacterIntegerHashMap(hashMap);
        // then
        Assert.assertThat(outputStream.toString(), containsString("key: A value: 1"));
        Assert.assertThat(outputStream.toString(), containsString("key: B value: 10"));

    }

    @Test
    public void shouldDisplayOddNumbers() throws Exception {
        // given
        final String expected = "1 3 5 7 9 ";
        outputStream.reset();
        // when
        displayOddNumbers(1, 10);

        // then
        assertThat(outputStream.toString()).isEqualTo(expected);
    }

    @Test
    public void printIntArrayShouldPrintIntegers() throws Exception {
        // given
        Integer[] integers = new Integer[]{1,2,3,null};
        final String expected = "[ 1 2 3 null ]\r\n";

        // when
        printIntArray(integers);

        // then
        assertThat(outputStream.toString()).isEqualTo(expected);
    }

}