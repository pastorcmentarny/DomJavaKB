/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dms.pastor.tasks.sunspotanalyser.data;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author Dominik Symonowicz
* Website: <a href="https://dominiksymonowicz.com/">Home Page</a>
* LinkedIn: <a href="https://www.linkedin.com/in/dominik-symonowicz">LinkedIn</a>
* GitHub: <a href="https://github.com/pastorcmentarny">GitHub</a>
 */
public class ScoreTest {

    @Test
    public void getScoreShouldRetrunZeroTest() {
        Score instance = new Score(0, 0, 0);
        int expResult = 0;
        int result = instance.getScore();
        assertThat(result).isEqualTo(expResult);
    }

    @Test
    public void shouldDisplayScoreTest() {
        Score instance = new Score(0, 0, 0);
        String expResult = "(" + 0 + ',' + 0 + " score:" + 0 + ')';
        String result = instance.displayScore();
        assertThat(result).isEqualTo(expResult);
    }
}
