package dms.pastor.tasks.sunspotanalyser.data;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.File;

import static org.assertj.core.api.Assertions.assertThat;

public class InputParserTest {

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void testGenerateGrid() {
        // given
        String testData = "1 5 5 3 1 2 0 4 1 1 3 2 2 3 2 4 3 0 2 3 3 2 1 0 2 4 3";
        InputParser inputParser = new InputParser(testData);

        // when
        Grid result = inputParser.generateGrid();

        // then
        assertThat(result).isNotNull();
    }

    @Test
    public void testParseInvalidData1() {
        // expect
        exception.expect(NullPointerException.class);

        // given
        final String testData = "A B C D";

        // when
        new InputParser(testData).validateData();
    }

    @Test
    public void shouldThrowInvalidArgumentExceptionForInvalidFileTest() {
        // expect
        exception.expect(IllegalArgumentException.class);

        // when
        new InputParser((File) null);

    }
}
