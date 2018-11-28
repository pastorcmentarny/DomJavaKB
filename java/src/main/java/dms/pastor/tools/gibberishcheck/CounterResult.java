package dms.pastor.tools.gibberishcheck;

import dms.pastor.utils.NumberUtils;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CounterResult {
    private final int count;
    private final int allWords;

    public String getPercentage() {
        return NumberUtils.getPercentage(count, allWords);
    }

}
