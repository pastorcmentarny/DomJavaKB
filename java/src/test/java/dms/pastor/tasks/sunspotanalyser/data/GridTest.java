package dms.pastor.tasks.sunspotanalyser.data;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author Dominik Symonowicz
 * WWW:	https://dominiksymonowicz.com/
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class GridTest {


    @Test
    public void displayGridTest() {
        String[] testData = {"1", "1", "1"};
        Grid instance = new Grid(testData);
        instance.displayGrid();
    }

    @Test
    public void getSizeForGridShouldReturn4Test() {
        // given
        String[] testData = {"3", "4", "2", "3", "2", "1", "4", "4", "2", "0", "3", "4", "1", "1", "2", "3", "4", "4"};
        Grid instance = new Grid(testData);
        int expResult = 4;

        // when
        int result = instance.size();

        // then
        assertThat(result).isEqualTo(expResult);
    }

    @Test
    public void getScoreShouldReturn4Test() {
        // given
        int x = 3;
        int y = 3;
        String[] testData = {"3", "4", "2", "3", "2", "1", "4", "4", "2", "0", "3", "4", "1", "1", "2", "3", "4", "4"};
        Grid instance = new Grid(testData);
        int expResult = 4;

        // when
        int result = instance.getScore(x, y);

        // then
        assertThat(result).isEqualTo(expResult);
    }

    @Test
    public void isInRangeShouldReturnTrueIfPointIsInRangeTest() {
        // given
        String[] testData = {"3", "4", "2", "3", "2", "1", "4", "4", "2", "0", "3", "4", "1", "1", "2", "3", "4", "4"};
        Grid instance = new Grid(testData);
        int x = 1;
        int y = 1;

        // when
        boolean result = instance.isInRange(x, y);

        // then
        assertThat(result).isTrue();
    }

    @Test
    public void isInRangeShouldReturnFalseIfPointIsOutOfRangeTest() {
        // given
        String[] testData = {"3", "4", "2", "3", "2", "1", "4", "4", "2", "0", "3", "4", "1", "1", "2", "3", "4", "4"};
        Grid instance = new Grid(testData);
        final int x = 10;
        final int y = 10;

        // when
        boolean result = instance.isInRange(x, y);

        // then
        assertThat(result).isFalse();
    }

}
