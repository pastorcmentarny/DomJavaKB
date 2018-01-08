package dms.pastor.tools.lotto.hotpick.generators;

import dms.pastor.tools.lotto.common.NumbersToPlayGenerator;
import dms.pastor.tools.lotto.hotpick.Couple;
import dms.pastor.tools.lotto.hotpick.HotPickDraw;
import dms.pastor.tools.lotto.hotpick.HotPickLeastPlayedCoupleFinder;
import dms.pastor.tools.lotto.hotpick.HotPicksAnalyser;
import dms.pastor.utils.ArrayUtils;
import dms.pastor.utils.PrintOutUtils;
import dms.pastor.utils.string.ToStringUtils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static dms.pastor.tools.lotto.LottoConstants.HOT_PICK_NUMBER_RANGE;
import static dms.pastor.tools.lotto.hotpick.CoupleOperations.deleteDiscardedCouples;
import static dms.pastor.tools.lotto.hotpick.CoupleOperations.removeAllCouplesThatDoNotContainsNumbers;

/**
 * Author Dominik Symonowicz
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class HotPicksNumberToPlay2018Generator extends NumbersToPlayGenerator {

    private static final int NUMBER_OF_PREVIOUS_GAMES = 10;
    private final String filePath;

    public HotPicksNumberToPlay2018Generator(String filePath) {
        System.out.println("Running HotPick 2018");
        this.filePath = filePath;
    }

    @Override
    public void generateNumbersToPlay() {
        final List<HotPickDraw> hotPickDrawList = loadData(filePath);

        HotPicksAnalyser analyser = new HotPicksAnalyser(hotPickDrawList);
        analyser.countBallDrawn(); //TODO fix it as now this line is required to make analyser work
        int leastDrawnNumber = analyser.findLeastDrawnNumber();
        int[] ballsDrawnLeastTimes = analyser.getBallsThatWasDrawn(leastDrawnNumber);
        System.out.println("Least drawn number is " + leastDrawnNumber + " and these number was drawn that times " + ToStringUtils.toString(ballsDrawnLeastTimes, " "));

        int[] numbersPlayed = analyser.removeNumbersFromGames(NUMBER_OF_PREVIOUS_GAMES);

        HotPickLeastPlayedCoupleFinder leastPlayedCoupleFinder = new HotPickLeastPlayedCoupleFinder();

        // generate all possible couples
        Set<Couple> remainingCouples = leastPlayedCoupleFinder.generateAllUniqueCombinationFor(HOT_PICK_NUMBER_RANGE);

        //generate all couples played
        Set<Couple> playedCouples = leastPlayedCoupleFinder.generateCouplesFromDraws(hotPickDrawList);
        remainingCouples = deleteDiscardedCouples(remainingCouples, playedCouples);

        //remove all couples that do not contain remainingNumbers
        remainingCouples = removeAllCouplesThatDoNotContainsNumbers(remainingCouples, ballsDrawnLeastTimes);
        remainingCouples = removeAllCouplesThatDoNotContainsNumbers(remainingCouples, numbersPlayed);

        int[] ints = ArrayUtils.subtractIntArray(ballsDrawnLeastTimes, numbersPlayed);

        PrintOutUtils.printIntArray(ints);
        int previousGamesCounter = NUMBER_OF_PREVIOUS_GAMES + 1;
        ints = new int[]{9, 26, 33, 48};
        while (ints.length > 3 && previousGamesCounter < 20) {
            System.out.println("Running for: " + previousGamesCounter);
            int[] x = analyser.removeNumbersFromGames(previousGamesCounter);
            ints = ArrayUtils.subtractIntArray(ballsDrawnLeastTimes, x);
            previousGamesCounter++;
            System.out.println("Status:");
            PrintOutUtils.printIntArray(ints);
            System.out.println("----------");
        }

        System.out.println("\n\n::>> You should choose:");
        PrintOutUtils.printIntArray(ints);
    }

    private boolean uniqueBallCount(Set<Couple> remainingCouples) {
        Set<Integer> balls = new HashSet<>();
        for (Couple couple : remainingCouples) {
            balls.add(couple.getSmallerNumber());
            balls.add(couple.getLargerNumber());
        }
        return balls.size() > 3;
    }

}
