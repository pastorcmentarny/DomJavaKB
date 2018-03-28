package dms.pastor.tools.lotto;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static dms.pastor.tools.lotto.BallCount.createForSingleNumberWithCount;
import static dms.pastor.tools.lotto.BallCountBuilder.ballCountBuilder;
import static dms.pastor.tools.lotto.BallCountOperations.*;
import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author Dominik Symonowicz
 * Created 12/03/2017
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class BallCountOperationsTest {

    @Test
    public void getTopPlayedBallsShould3Balls() {
        // given
        List<BallCount> ballCountList = new ArrayList<>();
        ballCountList.add(createForSingleNumberWithCount(1, 5));
        ballCountList.add(createForSingleNumberWithCount(3, 6));
        ballCountList.add(createForSingleNumberWithCount(4, 1));
        ballCountList.add(createForSingleNumberWithCount(5, 6));

        // when
        final BallCount[] top2PlayedBalls = getTop2PlayedBalls(ballCountList);

        // then
        assertThat(top2PlayedBalls).hasSize(2);
        assertThat(top2PlayedBalls[0].getBallNumbers().size() + top2PlayedBalls[1].getBallNumbers().size()).isEqualTo(3);
        assertThat(top2PlayedBalls[0].getBallNumbers().get(0)).isEqualTo(3);
        assertThat(top2PlayedBalls[0].getBallNumbers().get(1)).isEqualTo(5);
        assertThat(top2PlayedBalls[1].getBallNumbers().get(0)).isEqualTo(1);
    }

    @Test
    public void getLeastPlayedBallsShould3Balls() {
        // given
        List<BallCount> ballCountList = new ArrayList<>();
        ballCountList.add(createForSingleNumberWithCount(1, 5));
        ballCountList.add(createForSingleNumberWithCount(2, 0));
        ballCountList.add(createForSingleNumberWithCount(3, 6));
        ballCountList.add(createForSingleNumberWithCount(4, 1));
        ballCountList.add(createForSingleNumberWithCount(5, 6));
        ballCountList.add(createForSingleNumberWithCount(6, 0));

        // when
        final BallCount[] top2PlayedBalls = getLeast2PlayedBalls(ballCountList);

        // then
        assertThat(top2PlayedBalls).hasSize(2);
        assertThat(top2PlayedBalls[0].getBallNumbers().size() + top2PlayedBalls[1].getBallNumbers().size()).isEqualTo(3);
        assertThat(top2PlayedBalls[0].getBallNumbers().get(0)).isEqualTo(2);
        assertThat(top2PlayedBalls[0].getBallNumbers().get(1)).isEqualTo(6);
        assertThat(top2PlayedBalls[1].getBallNumbers().get(0)).isEqualTo(4);
    }

    @Test
    public void getNumbersFromBallsCountShouldGet5NumbersWithoutDuplicates() {
        // given
        final BallCount ballCount1 = ballCountBuilder().ballNumbers(asList(1, 3, 7)).build();
        final BallCount ballCount2 = ballCountBuilder().ballNumbers(asList(3, 4, 5)).build();
        final BallCount[] ballCountArray = new BallCount[]{ballCount1, ballCount2};
        int[] expected = new int[]{1, 3, 4, 5, 7};

        // when
        final int[] numbersFromBallsCount = getNumbersFromBallsCount(ballCountArray);

        // then
        assertThat(numbersFromBallsCount).isEqualTo(expected);
    }

}