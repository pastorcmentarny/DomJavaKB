package dms.pastor.tools.lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static dms.pastor.tools.lotto.BallCount.createForSingleNumberWithCount;
import static dms.pastor.utils.CollectionsUtils.convertSetToIntArray;

/**
 * Author Dominik Symonowicz
 * Created 12/03/2017
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class BallCountOperations {

    public static BallCount[] getTop2PlayedBalls(List<BallCount> ballCounts) {
        BallCount[] top2 = getNewTop2List();

        for (BallCount ballCount : ballCounts) {
            if (ballCount.getCount() > top2[0].getCount()) {
                top2[1] = top2[0];
                top2[0] = ballCount;
            } else if (ballCount.getCount() == top2[0].getCount()) {
                top2[0].addBallNumbers(ballCount.getBallNumbers());
            } else if (ballCount.getCount() > top2[1].getCount()) {
                top2[1] = ballCount;
            } else if (ballCount.getCount() == top2[1].getCount()) {
                top2[1].addBallNumbers(ballCount.getBallNumbers());
            }
        }

        return top2;
    }

    public static BallCount[] getLeast2PlayedBalls(List<BallCount> ballCounts) {
        BallCount[] top2 = getNewTop2List();
        top2[0].setCount(Integer.MAX_VALUE - 1);
        top2[1].setCount(Integer.MAX_VALUE - 1);

        for (BallCount ballCount : ballCounts) {
            if (ballCount.getCount() < top2[0].getCount()) {
                top2[1] = top2[0];
                top2[0] = ballCount;
            } else if (ballCount.getCount() == top2[0].getCount()) {
                top2[0].addBallNumbers(ballCount.getBallNumbers());
            } else if (ballCount.getCount() < top2[1].getCount()) {
                top2[1] = ballCount;
            } else if (ballCount.getCount() == top2[1].getCount()) {
                top2[1].addBallNumbers(ballCount.getBallNumbers());
            }
        }
        return top2;
    }

    private static BallCount[] getNewTop2List() {
        return new BallCount[]{BallCount.dummyBall(), BallCount.dummyBall()};
    }

    public static int[] getNumbersFromBallsCount(BallCount[] topBalls) {
        Set<Integer> integers = new HashSet<>();
        for (BallCount ballCount : topBalls) {
            integers.addAll(ballCount.getBallNumbers());
        }
        return convertSetToIntArray(integers);
    }

    public static BallCount[] getLeast2PlayedBalls(Map<Integer, Integer> ballCounts) {
        BallCount[] top2 = getNewTop2List();
        top2[0].setCount(Integer.MAX_VALUE - 1);
        top2[1].setCount(Integer.MAX_VALUE - 1);

        for (Map.Entry<Integer, Integer> ball : ballCounts.entrySet()) {
            if (ball.getValue() < top2[0].getCount()) {
                top2[1] = top2[0];
                top2[0] = createForSingleNumberWithCount(ball.getKey(), ball.getValue());
            } else if (ball.getValue() == top2[0].getCount()) {
                top2[0].addBallNumber(ball.getKey());
            } else if (ball.getValue() < top2[1].getCount()) {
                top2[1] = createForSingleNumberWithCount(ball.getKey(), ball.getValue());
            } else if (ball.getValue() == top2[1].getCount()) {
                top2[1].addBallNumber(ball.getKey());
            }
        }
        return top2;
    }

}
