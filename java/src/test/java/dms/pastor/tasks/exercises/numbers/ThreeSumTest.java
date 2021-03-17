package dms.pastor.tasks.exercises.numbers;

import dms.pastor.tools.StopWatch;
import dms.pastor.utils.ArrayUtils;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author Dominik Symonowicz
 * Created 10/04/2017
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class ThreeSumTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(ThreeSumTest.class);
    private final ThreeSum threeSum = new ThreeSum();
    private final int[] testValues = {30, -40, -20, -10, 40, 0, 10, 5};

    @Test
    public void threeSumAcceptanceTest() {
        // given
        final StopWatch timer = new StopWatch();
        timer.start();

        // when
        int answer = threeSum.brutalForceCounter(testValues);
        timer.stop();

        // debug
        LOGGER.info("\nValues:\t " + ArrayUtils.getIntArrayAsString(testValues) +
                "\nAnswer " + answer + " triples sum that equals zero." +
                "\nIt took " + timer.calcTotalTime() + "ms.");

        // then
        assertThat(answer).isEqualTo(4);
    }

}
