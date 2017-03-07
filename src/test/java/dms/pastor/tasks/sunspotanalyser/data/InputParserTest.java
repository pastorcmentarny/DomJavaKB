package dms.pastor.tasks.sunspotanalyser.data;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.File;

import static org.hamcrest.CoreMatchers.notNullValue;

/**
 * @author Pastor
 */
public class InputParserTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void testGenerateGrid() {
        String testData = "1 5 5 3 1 2 0 4 1 1 3 2 2 3 2 4 3 0 2 3 3 2 1 0 2 4 3";
        InputParser instance = new InputParser(testData);
        Grid result = instance.generateGrid();
        Assert.assertThat(result, notNullValue());
    }

    @Test
    public void testParseValidData() {

        String testData = "1 5 5 3 1 2 0 4 1 1 3 2 2 3 2 4 3 0 2 3 3 2 1 0 2 4 3";
        InputParser instance = new InputParser(testData);
        Grid result = instance.generateGrid();
        instance.validateData();
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
    public void shouldThrowInvalidArgumentExceptionForInvalidFileTest() throws Exception {
        // expect
        exception.expect(IllegalArgumentException.class);

        // when
        new InputParser((File) null);

    }
}
