package dms.pastor.tools.lotto;

import java.io.IOException;
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
public class HotPicksStatsGenerator {

    public static void main(String[] args) throws IOException {

        HotPicksFileUploader hotPicksFileUploader = new HotPicksFileUploader();
        final List<HotPickDraw> hotPickDrawList = hotPicksFileUploader.loadHotPicksDrawHistoryFile("C:\\lotto-hotpicks-draw-history.csv");
        hotPickDrawList.forEach(System.out::println);
        HotPicksAnalyser analyser = new HotPicksAnalyser(hotPickDrawList);

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

        //TODO this weekend
//        int[] numbers = analyser.getNumbersThatHaveNotBeenPlayTimes(10);

        System.out.println("End of program. Goodbye!");
    }

}
