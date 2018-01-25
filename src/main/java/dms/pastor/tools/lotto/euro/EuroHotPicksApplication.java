package dms.pastor.tools.lotto.euro;

import dms.pastor.tools.lotto.euro.generators.EuroHotpickNumberToPlayGeneratorV1;

import java.util.List;

/**
 * PROTOTYPE!
 */
public class EuroHotPicksApplication {

    public static void main(String[] args) {
        assert (args.length == 1);
        final List drawList = new EuroFileUploader().loadDrawHistoryFile(args[0]).getDrawList();
        new EuroHotpickNumberToPlayGeneratorV1(drawList).generateNumbersToPlay();

    }
}
