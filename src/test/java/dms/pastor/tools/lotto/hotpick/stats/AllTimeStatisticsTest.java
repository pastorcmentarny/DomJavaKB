package dms.pastor.tools.lotto.hotpick.stats;


import dms.pastor.tools.lotto.hotpick.HotPicksFileUploader;
import org.junit.Test;

import java.io.File;

import static java.io.File.separator;

public class AllTimeStatisticsTest {
    private static final String SRC = "src" + separator;
    private static final String RESOURCES = "resources" + separator;
    private static final String PATH = SRC + "main" + separator + RESOURCES;

    @Test
    public void acceptanceTest() {
        // given
        final String filePath = PATH + "lotto" + File.separator + "lotto-hotpicks-draw-history-all.csv";
        AllTimeStatistics statistics = new AllTimeStatistics(filePath, new HotPicksFileUploader());

        //when
        statistics.displayAllStatistics();
    }
}