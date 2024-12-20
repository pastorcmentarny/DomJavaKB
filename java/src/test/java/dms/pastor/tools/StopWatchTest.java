package dms.pastor.tools;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.CountDownLatch;

import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static java.util.concurrent.TimeUnit.SECONDS;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author Dominik Symonowicz
 * WWW:	<a href="https://dominiksymonowicz.com/">HOME PAGE</a>
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 * <p>
 * tag-thread-wait tag-countDownLatch
 */
public class StopWatchTest {

    private static final int TW0_SECOND = 2000;
    private static final int FIVE_SECONDS = 5000;
    private final CountDownLatch latch = new CountDownLatch(1);
    private StopWatch stopWatch;

    @BeforeEach
    public void setUp() {
        stopWatch = new StopWatch();
    }

    /*
     * I used Thread.wait(1000) in the past,but it produce some flaky test method seems caused
     *  This test is experiment is this approach is better.
     */
    @SuppressWarnings("ResultOfMethodCallIgnored")
    @Test
    public void shouldStartStopwatch() throws Exception {
        // when
        stopWatch.start();
        latch.await(1, SECONDS);
        final long time = stopWatch.calcCurrentTime();

        // then
        assertThat(time).isGreaterThan(0);
    }

    @SuppressWarnings("ResultOfMethodCallIgnored")
    @Test
    public void shouldStopStopwatch() throws Exception {
        // given
        stopWatch.start();
        latch.await(250L, MILLISECONDS);

        // when
        stopWatch.stop();

        // then
        assertThat(stopWatch.calcTotalTime()).isGreaterThanOrEqualTo(250L);

        // when
        latch.await(100, MILLISECONDS);

        // then
        assertThat(stopWatch.calcTotalTime()).isLessThan(400);
    }

    @Test
    public void calcTotalTimeShouldReturnCalculatedTime() {
        // given
        stopWatch.setStart(200);
        stopWatch.setFinish(400);

        // when
        final long time = stopWatch.calcTotalTime();

        // then
        assertThat(time).isEqualTo(200L);
    }

    @Test
    public void shouldDisplayTime() {
        // given
        stopWatch.setStart(TW0_SECOND);
        stopWatch.setFinish(FIVE_SECONDS);

        // when
        final String time = stopWatch.displayTime();

        // then
        assertThat(time).isEqualTo("Time needed: 0 days, 0 hours, 0 minutes and 3 seconds.");
    }

    @Test
    public void shouldResultTimeAsString() {
        // given
        stopWatch.setStart(TW0_SECOND);
        stopWatch.setFinish(FIVE_SECONDS);

        // when
        final String timeString = stopWatch.getResultTimeAsString();

        // then
        assertThat(timeString).isEqualTo("3.0s.");
    }

    @Test
    public void shouldResetTimer() {
        // given
        stopWatch.setStart(TW0_SECOND);
        stopWatch.setFinish(FIVE_SECONDS);

        // when
        stopWatch.resetTimer();

        // then
        assertThat(stopWatch.getStart()).isZero();
        assertThat(stopWatch.getFinish()).isZero();
    }
}
