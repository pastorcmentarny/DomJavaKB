package dms.pastor.tasks.sunspotanalyser.data;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;

/**
 * Author Dominik Symonowicz
 * * WWW:	http://pastor.ovh.org  * Github:	https://github.com/pastorcmentarny  * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz  * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
@SuppressWarnings("ConstantConditions") // part of the test
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
        Assert.assertThat(result, is(expResult));
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
        Assert.assertThat(result, is(expResult));
    }

    /**
     * Test of inRange method, of class Grid.
     */
    @Test
    public void testInRange() {
        System.out.println("inRange");
        String[] testData = {"3", "4", "2", "3", "2", "1", "4", "4", "2", "0", "3", "4", "1", "1", "2", "3", "4", "4"};
        Grid instance = new Grid(testData);
        int x = 1;
        int y = 1;
        boolean expResult = true;
        boolean result = instance.inRange(x, y);
        Assert.assertThat(result, is(expResult));
    }

    /**
     * Test of inRange method, of class Grid.
     */
    @Test
    public void testOutOfRange() {
        System.out.println("inRange");
        String[] testData = {"3", "4", "2", "3", "2", "1", "4", "4", "2", "0", "3", "4", "1", "1", "2", "3", "4", "4"};
        Grid instance = new Grid(testData);
        int x = 10;
        int y = 10;
        boolean expResult = false;
        boolean result = instance.inRange(x, y);
        Assert.assertThat(result, is(expResult));
    }


}
