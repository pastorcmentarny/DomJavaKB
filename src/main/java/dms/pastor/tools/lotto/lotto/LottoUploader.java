package dms.pastor.tools.lotto.lotto;

import dms.pastor.domain.exception.SomethingWentWrongException;
import dms.pastor.tools.lotto.hotpick.HotPickDraw;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static dms.pastor.tools.lotto.LottoFilePathValidator.validateFilePath;

/**
 * Author Dominik Symonowicz
 * Created 14/01/2018
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
class LottoUploader {
    private final List<LottoDraw> lottoDrawList;

    public LottoUploader() {
        lottoDrawList = new ArrayList<>();
    }

    public List<HotPickDraw> loadHotPicksDrawHistoryFile(String filePath) {
        validateFilePath(filePath);

        try (Stream<String> lines = Files.lines(Paths.get(filePath))) {
            lines.forEach(this::addIfLineValid);
        } catch (IOException e) {
            throw new SomethingWentWrongException("Getting lines from file", e);
        }
        return Collections.emptyList();
    }

    private void addIfLineValid(String line) {
        final String[] x = line.split("\"");
        final String[] nr = x[0].split(",");
        lottoDrawList.add(LottoDraw.getDrawWithNumbersOnly(Integer.parseInt(nr[1]), Integer.parseInt(nr[2]),
                Integer.parseInt(nr[3]), Integer.parseInt(nr[4]),
                Integer.parseInt(nr[5]), Integer.parseInt(nr[6])));
    }
}
