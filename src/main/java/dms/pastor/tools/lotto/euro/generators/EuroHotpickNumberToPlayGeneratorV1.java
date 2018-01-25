package dms.pastor.tools.lotto.euro.generators;

import dms.pastor.tools.lotto.common.NumberToPlayResult;
import dms.pastor.tools.lotto.common.NumbersToPlayGenerator;
import dms.pastor.tools.lotto.euro.EuroAnalyser;
import dms.pastor.tools.lotto.euro.EuroDraw;

import java.util.List;

/**
 * Author Dominik Symonowicz
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class EuroHotpickNumberToPlayGeneratorV1 extends NumbersToPlayGenerator {
    private final List<EuroDraw> euroDrawList;

    public EuroHotpickNumberToPlayGeneratorV1(List<EuroDraw> euroDrawList) {
        System.out.println("Running EURO HotPick 2018");
        this.euroDrawList = euroDrawList;
    }

    @Override
    public NumberToPlayResult generateNumbersToPlay() {
        EuroAnalyser analyser = new EuroAnalyser(euroDrawList);
        // stats
        System.out.println(analyser.countBallDrawn());
        System.out.println(analyser.countLuckyStarDrawn());

        // filter out all couples that ever played
        // find which balls played most
        // find couple that balls played most time but never together

        System.out.println(analyser.findLeastDrawnNumber());

        return null;
    }
}
