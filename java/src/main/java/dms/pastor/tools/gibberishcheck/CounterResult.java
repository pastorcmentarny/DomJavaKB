package dms.pastor.tools.gibberishcheck;

import dms.pastor.utils.NumberUtils;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

@AllArgsConstructor
@EqualsAndHashCode
public class CounterResult {
    private final int count;
    private final int allWords;

    public String getPercentage() {
        return NumberUtils.getPercentage(count, allWords);
    }

    public static CounterResult noResult() {
        return new CounterResult(0, 0);
    }

}
