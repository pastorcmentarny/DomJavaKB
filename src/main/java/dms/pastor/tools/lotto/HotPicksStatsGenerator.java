package dms.pastor.tools.lotto;

import dms.pastor.utils.PrintOutUtils;

import java.io.IOException;
import java.util.*;
import java.util.stream.IntStream;

import static dms.pastor.tools.lotto.BallCountOperations.*;
import static dms.pastor.tools.lotto.CoupleOperations.deleteDiscardedCouples;
import static dms.pastor.tools.lotto.LottoConstants.HOT_PICK_BALL_MAXIMUM_VALUE;
import static dms.pastor.tools.lotto.LottoConstants.HOT_PICK_BALL_MINIMUM_VALUE;
import static dms.pastor.utils.CollectionsUtils.convertListToIntArray;

/**
 * Author Dominik Symonowicz
 * Created 18/09/2016
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
class HotPicksStatsGenerator {

    private static final int[] HOT_PICK_NUMBER_RANGE = IntStream.rangeClosed(HOT_PICK_BALL_MINIMUM_VALUE, HOT_PICK_BALL_MAXIMUM_VALUE).toArray();
    private static final int NUMBER_OF_PREVIOUS_GAMES = 8;
    private final String filePath;

    HotPicksStatsGenerator(String filePath) {
        this.filePath = filePath;
    }

    private static void addOrUpdateValue(Map<Integer, Integer> topNumbers, Integer key) {
        if (topNumbers.containsKey(key)) {
            topNumbers.put(key, topNumbers.get(key) + 1);
        } else {
            topNumbers.put(key, 1);
        }
    }

    void generateNumbersToPlay() throws IOException {
        final List<HotPickDraw> hotPickDrawList = loadData();
        HotPicksAnalyser analyser = new HotPicksAnalyser(hotPickDrawList);
        HotPickLeastPlayedCoupleFinder leastPlayedCoupleFinder = new HotPickLeastPlayedCoupleFinder();

        displayStatistic(analyser);

        // generate all possible couples
        Set<Couple> remainingCouples = leastPlayedCoupleFinder.generateAllUniqueCombinationFor(HOT_PICK_NUMBER_RANGE);

        //generate all couples played
        final Set<Couple> playedCouples = leastPlayedCoupleFinder.generateCouplesFromDraws(hotPickDrawList);
        remainingCouples = deleteDiscardedCouples(remainingCouples, playedCouples);

        // remove all couples that contains top 2  played numbers
        Set<Couple> couplesWithMatchedBalls = findAllCouplesThatContainsThisBalls(remainingCouples, getTop2PlayedBalls(analyser.getBallsCountList()));
        remainingCouples = deleteDiscardedCouples(remainingCouples, couplesWithMatchedBalls);

        // remove all couples that contains least 2 played numbers
        couplesWithMatchedBalls = findAllCouplesThatContainsThisBalls(remainingCouples, BallCountOperations.getLeast2PlayedBalls(analyser.getBallsCountList()));
        remainingCouples = deleteDiscardedCouples(remainingCouples, couplesWithMatchedBalls);

        // remove all couples that contains least 2 played numbers
        couplesWithMatchedBalls = findAllCouplesThatContainsThisBalls(remainingCouples, analyser.removeNumbersFromGames(NUMBER_OF_PREVIOUS_GAMES));
        remainingCouples = deleteDiscardedCouples(remainingCouples, couplesWithMatchedBalls);

        //get final numbers to use to play
        final int[] finalNumbers = getFinalNumbers(remainingCouples);

        //TODO if more than 2 numbers choose 1 with most plays and 1 with least plays

        remainingCouples.forEach(System.out::println);
        System.out.println("Choose from these numbers:");
        PrintOutUtils.printIntArray(finalNumbers);
    }

    private int[] getFinalNumbers(Set<Couple> remainingCouples) {
        Map<Integer, Integer> ballsCounterInRemainingCouples = new HashMap<>();
        for (Couple couple : remainingCouples) {
            addOrUpdateValue(ballsCounterInRemainingCouples, couple.getSmallerNumber());
            addOrUpdateValue(ballsCounterInRemainingCouples, couple.getLargerNumber());
        }

        return getNumbersFromBallsCount(getLeast2PlayedBalls(ballsCounterInRemainingCouples));
    }

    private Set<Couple> findAllCouplesThatContainsThisBalls(Set<Couple> remainingCouples, BallCount[] top2PlayedBalls) {
        Set<Couple> couplesWithMatchedBalls = new HashSet<>();
        List<Integer> balls = new ArrayList<>();
        for (BallCount ballCount : top2PlayedBalls) {
            balls.addAll(ballCount.getBallNumbers());
        }

        for (Couple couple : remainingCouples) {
            if (couple.contains(convertListToIntArray(balls))) {
                couplesWithMatchedBalls.add(couple);
            }
        }
        return couplesWithMatchedBalls;
    }

    private Set<Couple> findAllCouplesThatContainsThisBalls(Set<Couple> remainingCouples, int[] balls) {
        Set<Couple> couplesWithMatchedBalls = new HashSet<>();

        for (Couple couple : remainingCouples) {
            if (couple.contains(balls)) {
                couplesWithMatchedBalls.add(couple);
            }
        }
        return couplesWithMatchedBalls;
    }

    private List<HotPickDraw> loadData() throws IOException {
        HotPicksFileUploader hotPicksFileUploader = new HotPicksFileUploader();
        return hotPicksFileUploader.loadHotPicksDrawHistoryFile(filePath);
    }

    private void displayStatistic(HotPicksAnalyser analyser) {
        final String result = analyser.countBallDrawn();
        System.out.println(result);
        final int mostDrawnNumber = analyser.findMostDrawnNumber();
        final String ballsDrawnMostTimes = analyser.findBallsThatWasDrawnTimes(mostDrawnNumber);
        System.out.println("Most drawn number is " + mostDrawnNumber + " and these number was drawn that times " + ballsDrawnMostTimes);

        final int leastDrawnNumber = analyser.findLeastDrawnNumber();
        final String ballsDrawnLeastTimes = analyser.findBallsThatWasDrawnTimes(leastDrawnNumber);
        System.out.println("Least drawn number is " + leastDrawnNumber + " and these number was drawn that times " + ballsDrawnLeastTimes);

        final Optional<HotPickDraw> throwNumbersPlayedTogether = analyser.find2TheSameNumberInRow(Integer.parseInt(ballsDrawnLeastTimes.split(",")[0]), Integer.parseInt(ballsDrawnMostTimes.split(",")[0]));
        System.out.println("Is most and least common number were played together ?" + throwNumbersPlayedTogether.isPresent());
        throwNumbersPlayedTogether.ifPresent(System.out::println);
    }
}
