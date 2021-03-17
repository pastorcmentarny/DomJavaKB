package dms.pastor.tasks.sunspotanalyser;

import dms.pastor.tasks.sunspotanalyser.data.Analyser;
import dms.pastor.tasks.sunspotanalyser.data.Grid;
import dms.pastor.tasks.sunspotanalyser.data.InputParser;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Answers {

    @Test
    public void test1() {
        // given
        String testData = "1 5 5 3 1 2 0 4 1 1 3 2 2 3 2 4 3 0 2 3 3 2 1 0 2 4 3";
        InputParser parser = InputParser.getInputParserFromString(testData);
        Grid grid = parser.generateGrid();
        String expResult = "(3,3 score:26)";
        Analyser analyser = new Analyser(grid);

        // when
        analyser.analyse();

        // then
        assertEquals(expResult, analyser.getResults(parser.getResultsNo()));
    }

    @Test
    public void test2() {
        String testData = "3 4 2 3 2 1 4 4 2 0 3 4 1 1 2 3 4 4";
        InputParser parser = InputParser.getInputParserFromString(testData);
        Grid grid = parser.generateGrid();
        String expResult = "(1,2 score:27)(1,1 score:25)(2,2 score:23)";
        Analyser analyser = new Analyser(grid);

        // when
        analyser.analyse();

        // then
        assertEquals(expResult, analyser.getResults(parser.getResultsNo()));

    }
}
