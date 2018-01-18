package dms.pastor.tools.lotto.accuracy.check;


import dms.pastor.tools.lotto.common.NumberToPlayResult;
import dms.pastor.tools.lotto.hotpick.HotPickDraw;
import dms.pastor.tools.lotto.hotpick.HotPickDrawBuilder;
import org.junit.Test;

import static dms.pastor.tools.lotto.common.NumberToPlayResultBuilder.numberToPlayResultBuilder;
import static org.assertj.core.api.Assertions.assertThat;

public class AccuracyCounterTest {

    @Test
    public void updateCountShouldReturnTotalOf3IfBothNumberMatches() {

    }

    @Test
    public void updateCountShouldReturnTotalOf1IfFirstNumberMatches() {

    }

    @Test
    public void updateCountShouldReturnTotalOf1IfSecondNumberMatches() {

    }

    @Test
    public void getAccuracyShouldReturnZeroAfterInitAccuracyCounter() {
        // given
        final AccuracyCounter accuracyCounter = new AccuracyCounter();

        // when
        final double accuracy = accuracyCounter.getAccuracy();

        // then
        assertThat(accuracy).isZero();
    }


    @Test
    public void getAccuracyShouldReturnHundredIfAllBallsWasHitInAllDraws() {
        // given
        final AccuracyCounter counter = new AccuracyCounter();
        final HotPickDraw draw = HotPickDrawBuilder.hotPickDrawBuilder().build();
        final NumberToPlayResult numberToPlayResult = numberToPlayResultBuilder()
                .firstNumber(draw.getBall1())
                .secondNumber(draw.getBall2())
                .build();
        counter.updateCount(draw, numberToPlayResult);

        // when
        final double accuracy = counter.getAccuracy();

        // then
        assertThat(accuracy).isEqualTo(100);

    }

    @Test
    public void getAccuracyShouldReturnFiftyPercentIfHalfBallsWasHitInAllDraws() {
        // given
        final AccuracyCounter counter = new AccuracyCounter();
        final HotPickDraw draw = HotPickDrawBuilder.hotPickDrawBuilder()
                .ball1(1)
                .ball2(2)
                .ball3(3)
                .ball4(4)
                .ball5(5)
                .ball6(6)
                .build();
        final NumberToPlayResult numberToPlayResult = numberToPlayResultBuilder()
                .firstNumber(draw.getBall1())
                .secondNumber(draw.getBall2())
                .build();
        counter.updateCount(draw, numberToPlayResult);

        final HotPickDraw draw2 = HotPickDrawBuilder.hotPickDrawBuilder()
                .ball1(11)
                .ball2(12)
                .ball3(13)
                .ball4(14)
                .ball5(15)
                .ball6(16)
                .build();
        final NumberToPlayResult numberToPlayResult2 = numberToPlayResultBuilder()
                .firstNumber(draw2.getBall2())
                .secondNumber(17)
                .build();
        counter.updateCount(draw2, numberToPlayResult2);

        // when
        final double accuracy = counter.getAccuracy();

        // then
        assertThat(accuracy).isEqualTo(66);

    }

    @Test
    public void getAccuracyShouldReturn33PercentIfHalfBallsWasHitInAllDraws() {
        // given
        final AccuracyCounter counter = new AccuracyCounter();
        final HotPickDraw draw = HotPickDrawBuilder.hotPickDrawBuilder()
                .ball1(1)
                .ball2(2)
                .ball3(3)
                .ball4(4)
                .ball5(5)
                .ball6(6)
                .build();
        final NumberToPlayResult numberToPlayResult = numberToPlayResultBuilder()
                .firstNumber(draw.getBall1())
                .secondNumber(7)
                .build();
        counter.updateCount(draw, numberToPlayResult);

        final HotPickDraw draw2 = HotPickDrawBuilder.hotPickDrawBuilder()
                .ball1(11)
                .ball2(12)
                .ball3(13)
                .ball4(14)
                .ball5(15)
                .ball6(16)
                .build();
        final NumberToPlayResult numberToPlayResult2 = numberToPlayResultBuilder()
                .firstNumber(draw2.getBall2())
                .secondNumber(17)
                .build();
        counter.updateCount(draw2, numberToPlayResult2);

        // when
        final double accuracy = counter.getAccuracy();

        // then
        assertThat(accuracy).isEqualTo(33);

    }
}