package dms.pastor.tasks.sunspotanalyser.data;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author Dominik Symonowicz
 * * WWW:	http://pastor.ovh.org  * Github:	https://github.com/pastorcmentarny  * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz  * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
// part of the test
public class GridTest {

    /**
     * Test of displayGrid method, of class Grid.
     */
    @Test
    public void testDisplayGrid() {
        System.out.println("displayGrid");
        String[] testData = {"1", "1", "1"};
        Grid instance = new Grid(testData);
        instance.displayGrid();
    }

    /**
     * Test of dictSize method, of class Grid.
     */
    @Test
    public void testSize() {
        System.out.println("dictSize");
        String[] testData = {"3", "4", "2", "3", "2", "1", "4", "4", "2", "0", "3", "4", "1", "1", "2", "3", "4", "4"};
        Grid instance = new Grid(testData);
        int expResult = 4;
        int result = instance.size();
        assertThat(result).isEqualTo(expResult);
    }

    /**
     * Test of getScore method, of class Grid.
     */
    @Test
    public void testGetScore() {
        System.out.println("getScore");
        int x = 3;
        int y = 3;
        String[] testData = {"3", "4", "2", "3", "2", "1", "4", "4", "2", "0", "3", "4", "1", "1", "2", "3", "4", "4"};
        Grid instance = new Grid(testData);
        int expResult = 4;
        int result = instance.getScore(x, y);
        assertThat(result).isEqualTo(expResult);
    }

    @Test
    public void isInRangeShouldReturnTrueIfPointIsInRange() {
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
    public void isInRangeShouldReturnFalseIfPointIsOutOfRange() {
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
