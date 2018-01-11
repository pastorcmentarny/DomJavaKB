package dms.pastor.tools.lotto.hotpick.stats;


import dms.pastor.tools.lotto.hotpick.HotPicksFileUploader;
import org.junit.Test;

public class AllTimeStatisticsTest {

    @Test
    public void acceptanceTest() {
        // given
        final String filePath = "/Users/symonowd/IdeaProjects/DomJavaKB/src/main/resources/lotto/lotto-hotpicks-draw-history-all.csv";
        AllTimeStatistics statistics = new AllTimeStatistics(filePath, new HotPicksFileUploader());

        //when
        statistics.displayAllStatistics();
    }
}