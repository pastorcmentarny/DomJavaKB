package dms.pastor.tools.lotto;

import org.junit.Test;

import static dms.pastor.tools.lotto.BallCount.dummyBall;
import static dms.pastor.tools.lotto.BallCount.isDummyBall;
import static dms.pastor.tools.lotto.BallCountBuilder.ballCountBuilder;
import static java.util.Collections.singletonList;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author Dominik Symonowicz
 * Created 12/03/2017
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
public class BallCountTest {

    @Test
    public void createForNumberShouldBallCountWithNumber1AndCount0() throws Exception {
        // given
        final BallCount expectedBallCount = new BallCount(singletonList(1),0);

        // when
        final BallCount ballCount = BallCount.createForNumber(1);

        // then
        assertThat(ballCount).isEqualTo(expectedBallCount);
    }

    @Test
    public void isDummyBallShouldReturnTrueForDummyBall() throws Exception {
        // when
        final boolean dummy = isDummyBall(dummyBall());

        // then
        assertThat(dummy).isTrue();
    }

    @Test
    public void isDummyBallShouldReturnFalseForNonDummyBall() throws Exception {
        // given
        final BallCount ballCount = ballCountBuilder().build();
        // when
        final boolean notDummy = isDummyBall(ballCount);

        // then
        assertThat(notDummy).isFalse();

    }
}