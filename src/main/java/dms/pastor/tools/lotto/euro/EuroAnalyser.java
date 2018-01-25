package dms.pastor.tools.lotto.euro;

import java.util.List;

import static dms.pastor.tools.lotto.LottoConstants.EURO_BALL_MAXIMUM_VALUE;
import static dms.pastor.utils.StringUtils.EMPTY_STRING;
import static dms.pastor.utils.StringUtils.NEW_LINE;

public class EuroAnalyser {

    private final List<EuroDraw> euroDrawList;

    private final int[] ballDrawnCounter = new int[EURO_BALL_MAXIMUM_VALUE + 1];

    public EuroAnalyser(List<EuroDraw> euroDrawList) {
        this.euroDrawList = euroDrawList;
    }

    public String countBallDrawn() {
        if (euroDrawList == null || euroDrawList.isEmpty()) {
            return "We successfully gather no result :)";
        }
        for (EuroDraw draw : euroDrawList) {
            addBall(draw.getBall1());
            addBall(draw.getBall2());
            addBall(draw.getBall3());
            addBall(draw.getBall4());
            addBall(draw.getBall5());
        }
        return displayBallDrawnCounterAsString();
    }

    private void addBall(int ball) {
        ballDrawnCounter[ball] += 1;
    }

    private String displayBallDrawnCounterAsString() {
        StringBuilder counter = new StringBuilder(EMPTY_STRING);
        for (int i = 1; i <= EURO_BALL_MAXIMUM_VALUE; i++) {
            if (ballDrawnCounter[i] > 0) {
                counter.append(i).append(": ").append(ballDrawnCounter[i]).append(NEW_LINE);
            }
        }
        return counter.toString();
    }

    public int findLeastDrawnNumber() {
        int minNumber = Integer.MAX_VALUE;
        for (int i = 1; i < ballDrawnCounter.length; i++) {
            if (minNumber > ballDrawnCounter[i]) {
                minNumber = ballDrawnCounter[i];
            }
        }
        return minNumber;
    }
}
