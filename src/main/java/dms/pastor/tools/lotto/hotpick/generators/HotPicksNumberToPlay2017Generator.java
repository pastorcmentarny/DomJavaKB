package dms.pastor.tools.lotto.hotpick.generators;

import dms.pastor.tools.lotto.BallCountOperations;
import dms.pastor.tools.lotto.common.NumbersToPlayGenerator;
import dms.pastor.tools.lotto.hotpick.Couple;
import dms.pastor.tools.lotto.hotpick.HotPickDraw;
import dms.pastor.tools.lotto.hotpick.HotPickLeastPlayedCoupleFinder;
import dms.pastor.tools.lotto.hotpick.HotPicksAnalyser;
import dms.pastor.utils.PrintOutUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static dms.pastor.tools.lotto.BallCountOperations.*;
import static dms.pastor.tools.lotto.LottoConstants.HOT_PICK_NUMBER_RANGE;
import static dms.pastor.tools.lotto.hotpick.CoupleOperations.deleteDiscardedCouples;
import static dms.pastor.tools.lotto.hotpick.CoupleOperations.findAllCouplesThatContainsThisBalls;
import static dms.pastor.tools.lotto.hotpick.HotPickStats.displayStatistic;

/**
 * Author Dominik Symonowicz
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class HotPicksNumberToPlay2017Generator extends NumbersToPlayGenerator {

    static final int NUMBER_OF_PREVIOUS_GAMES = 8;
    private final String filePath;

    public HotPicksNumberToPlay2017Generator(String filePath) {
        this.filePath = filePath;
    }

    public void generateNumbersToPlay() {
        final List<HotPickDraw> hotPickDrawList = loadData(filePath);
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

}
