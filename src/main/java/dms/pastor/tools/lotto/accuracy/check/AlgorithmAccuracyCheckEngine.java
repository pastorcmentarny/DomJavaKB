package dms.pastor.tools.lotto.accuracy.check;

import dms.pastor.tools.lotto.common.NumberToPlayResult;
import dms.pastor.tools.lotto.hotpick.FileUploader;
import dms.pastor.tools.lotto.hotpick.HotPickDraw;
import dms.pastor.tools.lotto.hotpick.generators.HotPicksNumberToPlay2018Generator;

import java.util.List;

import static dms.pastor.tools.lotto.accuracy.check.DrawListExtractor.getHotPickDrawListFromRange;

/**
 * Author Dominik Symonowicz
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 * <p>
 * //TODO make this generic as this one is for hotpicks only
 */
public class AlgorithmAccuracyCheckEngine {
    final List<HotPickDraw> hotPickDrawList;
    final AccuracyCounter counter;

    public AlgorithmAccuracyCheckEngine(String filePath, FileUploader fileUploader) {
        hotPickDrawList = fileUploader.loadDrawHistoryFile(filePath).getDrawList();
        counter = new AccuracyCounter();
    }

    /*run with specific generator with specific balldrawlist that will cam froem all htopicks draws
        Result will show accuracy for double  and will calculate money outcome with assumption I will play n1,n2 and n1+n2
    \*/
    public Result analyse() {
        System.out.println("Analysing...");
        List<HotPickDraw> draw;
        HotPicksNumberToPlay2018Generator generator;

        for (int i = getLast(hotPickDrawList); i > 1; i--) {
            System.out.println("Checking for draw nr." + i);
            draw = getHotPickDrawListFromRange(hotPickDrawList, 1, 52);
            generator = new HotPicksNumberToPlay2018Generator(draw);
            final NumberToPlayResult numberToPlayResult = generator.generateNumbersToPlay();
            final HotPickDraw currentDraw = getCurrentDraw(draw, i);
            counter.updateCount(currentDraw, numberToPlayResult);
            System.out.println(counter.toString());
        }

        // get oldest 52 hotpicks
        // run analyse
        // check if got it
        // move by 1 ,repeast
        System.out.println("Analyse complete.");
        return new Result(counter.getAccuracy(), Integer.MIN_VALUE);
    }

    private HotPickDraw getCurrentDraw(List<HotPickDraw> draw, int index) {
        return draw.get(index);
    }

    private int getLast(List<HotPickDraw> drawList) {
        return hotPickDrawList.size() - 1;
    }


    public int getAccuracyFor() {


        return -1;
    }
}