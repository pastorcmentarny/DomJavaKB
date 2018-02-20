package dms.pastor.tools.lotto.hotpick.generators;

import dms.pastor.tools.lotto.hotpick.HotPickDraw;
import dms.pastor.tools.lotto.hotpick.HotPicksFileUploader;
import org.junit.Test;

import java.util.List;

import static dms.pastor.TestConfig.PATH;

public class HotPicksNumberToPlay2018GeneratorTest {
    private static final String FILE_PATH = PATH + "lotto-hotpicks-52-draws-history.csv";

    @Test
    public void test() {
        final List<HotPickDraw> hotPickDrawList = new HotPicksFileUploader().loadDrawHistoryFile(FILE_PATH).getDrawList();
        final HotPicksNumberToPlay2018Generator generator = new HotPicksNumberToPlay2018Generator(hotPickDrawList);

        generator.generateNumbersToPlay();
    }

}