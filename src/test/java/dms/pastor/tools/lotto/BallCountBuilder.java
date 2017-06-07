package dms.pastor.tools.lotto;

import java.util.List;

import static dms.pastor.tools.lotto.LottoConstants.HOT_PICK_BALL_MAXIMUM_VALUE;
import static dms.pastor.tools.lotto.LottoConstants.HOT_PICK_BALL_MINIMUM_VALUE;
import static dms.pastor.utils.randoms.RandomDataGenerator.randomInteger;
import static java.util.Collections.singletonList;

/**
 * Author Dominik Symonowicz
 * Created 12/03/2017
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
public class BallCountBuilder {

    private List<Integer> ballNumbers = singletonList(randomInteger(HOT_PICK_BALL_MINIMUM_VALUE, HOT_PICK_BALL_MAXIMUM_VALUE));
    private int count = randomInteger(10);

    private BallCountBuilder() {
    }

    static BallCountBuilder ballCountBuilder() {
        return new BallCountBuilder();
    }

    public BallCount build() {
        return new BallCount(ballNumbers, count);
    }

    public BallCountBuilder ballNumber(int ballNumber) {
        this.ballNumbers = singletonList(ballNumber);
        return this;
    }

    BallCountBuilder ballNumbers(List<Integer> ballNumbers) {
        this.ballNumbers = ballNumbers;
        return this;
    }

    public BallCountBuilder count(int count) {
        this.count = count;
        return this;
    }
}
