package dms.pastor.tools;

import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.CountDownLatch;

import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static java.util.concurrent.TimeUnit.SECONDS;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author Dominik Symonowicz
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 *
 * tag-thread-wait tag-countDownLatch
 */
public class StopWatchTest {
    private StopWatch stopWatch;
    private final CountDownLatch latch = new CountDownLatch(1);

    @Before
    public void setUp() throws Exception {
        stopWatch = new StopWatch();
    }

    /*
     * I used Thread.wait(1000) in the past,but it produce some flaky test method seems caused
     *  This test is experiment is this approach is better.
     */
    @Test
    public void shouldStartStopwatch() throws Exception {
        // when
        stopWatch.start();
        latch.await(1, SECONDS);
        final long time = stopWatch.calcCurrentTime();

        // then
        assertThat(time).isGreaterThan(0);
    }

    @Test
    public void shouldStopStopwatch() throws Exception {
        // given
        stopWatch.start();
        latch.await(250, MILLISECONDS);

        // when
        stopWatch.stop();

        // then
        assertThat(stopWatch.calcTotalTime()).isGreaterThan(250);

        // when
        latch.await(100, MILLISECONDS);

        // then
        assertThat(stopWatch.calcTotalTime()).isLessThan(400);
    }

    @Test
    public void calcTotalTimeShouldReturnCalculatedTime() throws Exception {
        // given
        stopWatch.setStart(200);
        stopWatch.setFinish(400);

        // when
        final long time = stopWatch.calcTotalTime();

        // then
        assertThat(time).isEqualTo(200L);
    }

    @Test
    public void shouldDisplayTime() throws Exception {
        // given
        stopWatch.setStart(1000);
        stopWatch.setFinish(4000);

        // when
        final String time = stopWatch.displayTime();

        // then
        assertThat(time).isEqualTo("Time needed: 0 days, 0 hours, 0 minutes and 3 seconds.");
    }

    @Test
    public void shouldResultTimeAsString() throws Exception {
        // given
        stopWatch.setStart(2000);
        stopWatch.setFinish(5000);

        // when
        final String timeString = stopWatch.getResultTimeAsString();

        // then
        assertThat(timeString).isEqualTo("3.0s.");
    }

    @Test
    public void shouldResetTimer() throws Exception {
        // given
        stopWatch.setStart(2000);
        stopWatch.setFinish(5000);

        // when
        stopWatch.resetTimer();

        // then
        assertThat(stopWatch.getStart()).isZero();
        assertThat(stopWatch.getFinish()).isZero();
    }
}
