package dms.pastor.tools.lotto;

import org.apache.log4j.Logger;

import java.util.List;
import java.util.Optional;

/**
 * Author Dominik Symonowicz
 * Created 18/09/2016
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
class HotPicksAnalyser {
    private static final int[] EMPTY_INTEGER_ARRAY = new int[0];
    private static final Logger LOG = Logger.getLogger(HotPicksAnalyser.class);
    private static final int MINIMUM_BALL_VALUE = 1;
    private static final int MAXIMUM_BALL_VALUE = 59;
    private static final String SEPARATOR = ",";
    private final List<HotPickDraw> hotPickDrawList;
    private final int[] ballDrawnCounter = new int[MAXIMUM_BALL_VALUE + 1];

    public HotPicksAnalyser(List<HotPickDraw> hotPickDrawList) {
        this.hotPickDrawList = hotPickDrawList;
    }


    public String countBallDrawn() {
        if (hotPickDrawList == null || hotPickDrawList.isEmpty()) {
            return "We successfully gather no result :)";
        }
        for (HotPickDraw draw : hotPickDrawList) {
            addBall(draw.getBall1());
            addBall(draw.getBall2());
            addBall(draw.getBall3());
            addBall(draw.getBall4());
            addBall(draw.getBall5());
            addBall(draw.getBall6());

        }
        return displayBallDrawnCounterAsString();
    }

    private String displayBallDrawnCounterAsString() {
        StringBuilder counter = new StringBuilder("");
        for (int i = 1; i <= MAXIMUM_BALL_VALUE; i++) {
            if (ballDrawnCounter[i] > 0) {
                counter.append(i).append(": ").append(ballDrawnCounter[i]).append('\n');
            }
        }
        return counter.toString();
    }

    //TODO as JSON

    private void addBall(int ball) {
        validateBall(ball);
        ballDrawnCounter[ball] = ballDrawnCounter[ball] + 1;
    }

    public int findMostDrawnNumber() {
        int maxNumber = 0;
        for (int i = 1; i < ballDrawnCounter.length; i++) {
            if (ballDrawnCounter[i] > maxNumber) {
                maxNumber = ballDrawnCounter[i];
            }
        }
        return maxNumber;
    }

    public String findBallsThatWasDrawnTimes(int times) {
        StringBuilder stringBuilder = new StringBuilder("");
        for (int i = 1; i < ballDrawnCounter.length; i++) {
            if (ballDrawnCounter[i] == times) {
                stringBuilder.append(i).append(SEPARATOR);
            }
        }
        return getResultWithoutLastSeparator(stringBuilder);
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

    //should be varargs up to 6 numbers
    public Optional<HotPickDraw> find2TheSameNumberInRow(int number1, int number2) {
        validateBall(number1, number2);
        for (HotPickDraw draw : hotPickDrawList) {
            if (draw.containsBalls(number1, number2)) {
                return Optional.of(draw);
            }
        }
        return Optional.empty();
    }

    private String getResultWithoutLastSeparator(StringBuilder stringBuilder) {
        String result = stringBuilder.toString();
        if (result.contains(SEPARATOR)) {
            result = result.substring(0, result.length() - 1);
        }
        return result;
    }

    private void validateBall(int... balls) {
        for (int ball : balls) {
            if (ball > MAXIMUM_BALL_VALUE || ball < MINIMUM_BALL_VALUE) {
                throw new IllegalArgumentException("Data is corrupted. Number " + ball + " is not in range (" + MINIMUM_BALL_VALUE + '=' + MAXIMUM_BALL_VALUE + ')');
            }
        }
    }

/*    //TODO implement it
    public int[] getNumbersThatHaveNotBeenPlayTimes(int times) {
        if (times <= 0) {
            LOG.error(String.format("numbers of games should be a positive number but was : %d", times));
            return EMPTY_INTEGER_ARRAY;
        }
        throw new NotImplementYetException();
    }*/
}
