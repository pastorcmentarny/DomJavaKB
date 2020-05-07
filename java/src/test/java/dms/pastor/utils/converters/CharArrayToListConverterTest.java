package dms.pastor.utils.converters;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CharArrayToListConverterTest {

    CharArrayToListConverter converter = new CharArrayToListConverter();

    @SuppressWarnings("ConstantConditions")
    @Test
    public void convertToStringArrayFromCharArrayShouldReturnNullIfCharArrayIsNull() {
        // when
        final List<String> stringArrayFromCharArray = converter.convert((char[]) null);

        // then
        assertThat(stringArrayFromCharArray).isNull();
    }

    @Test
    public void convertToStringArrayFromCharArrayShouldReturnEmptyIfCharArrayIsEmpty() {
        // when
        final List<String> stringArrayFromCharArray = converter.convert((new char[0]));

        // then
        assertThat(stringArrayFromCharArray).isEmpty();
    }

    @Test
    public void convertToStringArrayFromCharArrayAcceptanceTest() {
        // given
        char[] charArray = ": is a colon sign.".toCharArray();
        List<String> expectedResult = new ArrayList<>();
        expectedResult.add(":");
        expectedResult.add(" ");
        expectedResult.add("i");
        expectedResult.add("s");
        expectedResult.add(" ");
        expectedResult.add("a");
        expectedResult.add(" ");
        expectedResult.add("c");
        expectedResult.add("o");
        expectedResult.add("l");
        expectedResult.add("o");
        expectedResult.add("n");
        expectedResult.add(" ");
        expectedResult.add("s");
        expectedResult.add("i");
        expectedResult.add("g");
        expectedResult.add("n");
        expectedResult.add(".");

        // when
        final List<String> stringArrayFromCharArray = converter.convert(charArray);

        // then
        assertThat(stringArrayFromCharArray).isEqualTo(expectedResult);
    }


}
