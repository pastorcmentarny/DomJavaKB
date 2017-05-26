package dms.pastor.tools.lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static dms.pastor.tools.lotto.LottoConstants.HOT_PICK_BALL_MAXIMUM_VALUE;
import static dms.pastor.tools.lotto.LottoConstants.HOT_PICK_BALL_MINIMUM_VALUE;
import static dms.pastor.utils.CollectionsUtils.convertSetToIntArray;
import static dms.pastor.utils.StringUtils.EMPTY_STRING;
import static dms.pastor.utils.StringUtils.NEW_LINE;

/**
 * Author Dominik Symonowicz
 * Created 18/09/2016
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
class HotPicksAnalyser {

    private static final String SEPARATOR = ",";
    private final List<HotPickDraw> hotPickDrawList;

    private final int[] ballDrawnCounter = new int[HOT_PICK_BALL_MAXIMUM_VALUE + 1];

    HotPicksAnalyser(List<HotPickDraw> hotPickDrawList) {
        this.hotPickDrawList = hotPickDrawList;
    }


    String countBallDrawn() {
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
        StringBuilder counter = new StringBuilder(EMPTY_STRING);
        for (int i = 1; i <= HOT_PICK_BALL_MAXIMUM_VALUE; i++) {
            if (ballDrawnCounter[i] > 0) {
                counter.append(i).append(": ").append(ballDrawnCounter[i]).append(NEW_LINE);
            }
        }
        return counter.toString();
    }

    //TODO as JSON

    private void addBall(int ball) {
        validateBall(ball);
        ballDrawnCounter[ball] = ballDrawnCounter[ball] + 1;
    }

    int findMostDrawnNumber() {
        int maxNumber = 0;
        for (int i = 1; i < ballDrawnCounter.length; i++) {
            if (ballDrawnCounter[i] > maxNumber) {
                maxNumber = ballDrawnCounter[i];
            }
        }
        return maxNumber;
    }

    String findBallsThatWasDrawnTimes(int times) {
        StringBuilder stringBuilder = new StringBuilder(EMPTY_STRING);
        for (int i = 1; i < ballDrawnCounter.length; i++) {
            if (ballDrawnCounter[i] == times) {
                stringBuilder.append(i).append(SEPARATOR);
            }
        }
        return getResultWithoutLastSeparator(stringBuilder);
    }


    int findLeastDrawnNumber() {
        int minNumber = Integer.MAX_VALUE;
        for (int i = 1; i < ballDrawnCounter.length; i++) {
            if (minNumber > ballDrawnCounter[i]) {
                minNumber = ballDrawnCounter[i];
            }
        }
        return minNumber;
    }

    //should be varargs up to 6 numbers
    Optional<HotPickDraw> find2TheSameNumberInRow(int number1, int number2) {
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
            result = result.substring(0, getLastElement(result));
        }
        return result;
    }

    private int getLastElement(String string) {
        return string.length() - 1;
    }

    private void validateBall(int... balls) {
        for (int ball : balls) {
            if (ball > HOT_PICK_BALL_MAXIMUM_VALUE || ball < HOT_PICK_BALL_MINIMUM_VALUE) {
                throw new IllegalArgumentException("Data is corrupted. Number " + ball + " is not in range (" + HOT_PICK_BALL_MINIMUM_VALUE + '=' + HOT_PICK_BALL_MAXIMUM_VALUE + ')');
            }
        }
    }

    List<BallCount> getBallsCountList() {
        final List<BallCount> ballCountList = generateBallCountList();
        for (HotPickDraw hotPickDraw : hotPickDrawList) {
            ballCountList.get(hotPickDraw.getBall1() - 1).addCount();
            ballCountList.get(hotPickDraw.getBall2() - 1).addCount();
            ballCountList.get(hotPickDraw.getBall3() - 1).addCount();
            ballCountList.get(hotPickDraw.getBall4() - 1).addCount();
            ballCountList.get(hotPickDraw.getBall5() - 1).addCount();
            ballCountList.get(hotPickDraw.getBall6() - 1).addCount();
        }
        return ballCountList;
    }

    private List<BallCount> generateBallCountList() {
        return IntStream.rangeClosed(HOT_PICK_BALL_MINIMUM_VALUE, HOT_PICK_BALL_MAXIMUM_VALUE)
                .mapToObj(BallCount::createForNumber)
                .collect(Collectors.toList());
    }

    int[] removeNumbersFromGames(int previousGamesNumber) {
        previousGamesNumber = setMaximumGameNumber(previousGamesNumber);

        Set<Integer> numbers = new HashSet<>();
        for (int i = 0; i < previousGamesNumber; i++) {
            for (int numberToAdd : hotPickDrawList.get(i).getAllBalls()) {
                numbers.add(numberToAdd);
            }
        }
        return convertSetToIntArray(numbers);
    }

    private int setMaximumGameNumber(int howMany) {
        if (howMany > hotPickDrawList.size()) {
            howMany = hotPickDrawList.size();
        }
        return howMany;
    }
}
