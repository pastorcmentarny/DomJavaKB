package dms.pastor.tools.lotto.hotpick.stats;

import dms.pastor.tools.lotto.BallCount;
import dms.pastor.tools.lotto.hotpick.HotPickDraw;
import dms.pastor.tools.lotto.hotpick.HotPicksAnalyser;
import dms.pastor.tools.lotto.hotpick.HotPicksFileUploader;

import java.util.Comparator;
import java.util.List;

public class AllTimeStatistics {
    private final String filePath;
    private final HotPicksFileUploader uploader;

    public AllTimeStatistics(String filePath, HotPicksFileUploader uploader) {
        this.filePath = filePath;
        this.uploader = uploader;
    }

    public void displayAllStatistics() {
        List<HotPickDraw> hotPickDrawList = uploader.loadHotPicksDrawHistoryFile(filePath).getDrawList();
        HotPicksAnalyser analyser = new HotPicksAnalyser(hotPickDrawList);
        System.out.println(analyser.countBallDrawn());
        analyser.getBallsCountList().stream().sorted(Comparator.comparing(BallCount::getCount).reversed()).forEach(System.out::println);
    }
}
