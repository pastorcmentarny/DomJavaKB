package dms.pastor.tasks.sunspotanalyser.data;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class InputParserTest {


    @Test
    public void testGenerateGrid() {
        // given
        String testData = "1 5 5 3 1 2 0 4 1 1 3 2 2 3 2 4 3 0 2 3 3 2 1 0 2 4 3";
        InputParser inputParser = InputParser.getInputParserFromString(testData);
        // when
        Grid result = inputParser.generateGrid();

        // then
        assertThat(result).isNotNull();
    }

    @Test
    public void testParseInvalidData1() {
        // given
        final String testData = "A B C D";
        // when
        Assertions.assertThrows(IllegalArgumentException.class, () -> new InputParser(testData).validateData());
    }

    @Test
    public void shouldThrowInvalidArgumentExceptionForInvalidFileTest() {
        // when
        Assertions.assertThrows(IllegalArgumentException.class, () -> new InputParser(null));


    }
}
