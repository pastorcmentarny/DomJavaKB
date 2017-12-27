package dms.pastor.tools.lotto.hotpick;

import java.util.Optional;

/**
 * Author Dominik Symonowicz
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public final class HotPickStats {
    private HotPickStats() {
    }

    public static void displayStatistic(HotPicksAnalyser analyser) {
        final String result = analyser.countBallDrawn();
        System.out.println(result);
        final int mostDrawnNumber = analyser.findMostDrawnNumber();
        final String ballsDrawnMostTimes = analyser.findBallsThatWasDrawnTimes(mostDrawnNumber);
        System.out.println("Most drawn number is " + mostDrawnNumber + " and these number was drawn that times " + ballsDrawnMostTimes);

        final int leastDrawnNumber = analyser.findLeastDrawnNumber();
        final String ballsDrawnLeastTimes = analyser.findBallsThatWasDrawnTimes(leastDrawnNumber);
        System.out.println("Least drawn number is " + leastDrawnNumber + " and these number was drawn that times " + ballsDrawnLeastTimes);

        final Optional<HotPickDraw> throwNumbersPlayedTogether = analyser.find2TheSameNumberInRow(Integer.parseInt(ballsDrawnLeastTimes.split(",")[0]), Integer.parseInt(ballsDrawnMostTimes.split(",")[0]));
        System.out.println("Is most and least common number were played together? " + throwNumbersPlayedTogether.isPresent());
        throwNumbersPlayedTogether.ifPresent(System.out::println);
    }
}
