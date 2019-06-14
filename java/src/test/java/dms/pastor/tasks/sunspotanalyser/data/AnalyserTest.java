package dms.pastor.tasks.sunspotanalyser.data;

import org.junit.Assert;
import org.junit.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;

public class AnalyserTest {

    @Test
    public void testCalculateSolarActivityScore() {
        System.out.println("calculateSolarActivityScore");
        int x = 3;
        int y = 3;
        String testData = "1 5 5 3 1 2 0 4 1 1 3 2 2 3 2 4 3 0 2 3 3 2 1 0 2 4 3";
        InputParser parser = InputParser.getInputParserFromString(testData);
        Grid grid = parser.generateGrid();
        Analyser analyser = new Analyser(grid);
        int expResult = 26;
        int result = analyser.calculateSolarActivityScore(x, y);
        Assert.assertThat(result, is(expResult));
    }

    @Test
    public void testGetResults() {
        int no = 3;
        String testData = "3 4 2 3 2 1 4 4 2 0 3 4 1 1 2 3 4 4";
        InputParser parser = InputParser.getInputParserFromString(testData);
        Grid grid = parser.generateGrid();
        Analyser analyser = new Analyser(grid);
        analyser.analyse();
        String expResult = "(1,2 score:27)(1,1 score:25)(2,2 score:23)";
        String result = analyser.getResults(no);
        Assert.assertThat(result, is(expResult));
    }

    @Test
    public void testAnalyse() {
        String testData = "3 4 2 3 2 1 4 4 2 0 3 4 1 1 2 3 4 4";
        InputParser parser = InputParser.getInputParserFromString(testData);
        Grid grid = parser.generateGrid();
        grid.displayGrid();
        Analyser analyser = new Analyser(grid);
        analyser.analyse();
        String expResult = "(1,2 score:27)(1,1 score:25)(2,2 score:23)";
        assertThat(analyser.getResults(parser.getResultsNo())).isEqualTo(expResult);
    }
}
