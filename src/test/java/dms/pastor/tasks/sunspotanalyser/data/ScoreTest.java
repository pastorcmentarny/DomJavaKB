/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dms.pastor.tasks.sunspotanalyser.data;


import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;

/**
 * Author Dominik Symonowicz
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class ScoreTest {

    /**
     * Test of getScore method, of class Score.
     */
    @Test
    public void testGetScore() {
        System.out.println("getScore");
        Score instance = new Score(0, 0, 0);
        int expResult = 0;
        int result = instance.getScore();
        Assert.assertThat(result, is(expResult));
    }

    /**
     * Test of displayScore method, of class Score.
     */
    @Test
    public void testDisplayScore() {
        System.out.println("displayScore");
        Score instance = new Score(0, 0, 0);
        String expResult = "(" + 0 + ',' + 0 + " score:" + 0 + ')';
        String result = instance.displayScore();
        Assert.assertThat(result, is(expResult));
    }
}
