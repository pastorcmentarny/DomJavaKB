package dms.pastor.tools.lotto.common;

import dms.pastor.tools.lotto.hotpick.HotPickDraw;
import dms.pastor.tools.lotto.hotpick.HotPicksFileUploader;

import java.util.List;
import java.util.Map;

/**
 * Author Dominik Symonowicz
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public abstract class NumbersToPlayGenerator implements Generator {

    protected List<HotPickDraw> loadData(String filePath) {
        HotPicksFileUploader hotPicksFileUploader = new HotPicksFileUploader();
        return hotPicksFileUploader.loadHotPicksDrawHistoryFile(filePath);
    }

    protected static void addOrUpdateValue(Map<Integer, Integer> topNumbers, Integer key) {
        if (topNumbers.containsKey(key)) {
            topNumbers.put(key, topNumbers.get(key) + 1);
        } else {
            topNumbers.put(key, 1);
        }
    }


}
