package dms.pastor.tools.job.gibberishcheck;

import dms.pastor.utils.NumberUtils;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@AllArgsConstructor
@Getter
@EqualsAndHashCode
public class CounterResult {
    private final int count;
    private final int allWords;

    public static CounterResult noResult() {
        return new CounterResult(0, 0);
    }

    public String getPercentageAsString() {
        return NumberUtils.getPercentage(count, allWords);
    }

    public int getPercentage() {
        return Integer.parseInt(NumberUtils.getPercentage(count, allWords));
    }

}
