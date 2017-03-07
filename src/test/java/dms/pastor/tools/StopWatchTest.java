package dms.pastor.tools;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;

/**
 * Author Dominik Symonowicz
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
public class StopWatchTest {
    private StopWatch stopWatch;

    @Before
    public void setUp() throws Exception {
        stopWatch = new StopWatch();
    }

    @After
    public void tearDown() throws Exception {
        stopWatch.resetTimer();
    }

    @Test
    public void testCalcTotalTime() throws Exception {
        stopWatch.setStart(200);
        stopWatch.setFinish(400);
        Assert.assertThat(stopWatch.calcTotalTime(), is(200L));
    }

    @Test
    public void testDisplayTime() throws Exception {
        stopWatch.setStart(1000);
        stopWatch.setFinish(4000);
        Assert.assertThat(stopWatch.displayTime(), is("Time needed: 0 days, 0 hours, 0 minutes and 3 seconds."));
    }

    @Test
    public void testGetResultTimeString() throws Exception {
        stopWatch.setStart(2000);
        stopWatch.setFinish(5000);
        Assert.assertThat(stopWatch.getResultTimeString(), is("3.0s."));
    }
}