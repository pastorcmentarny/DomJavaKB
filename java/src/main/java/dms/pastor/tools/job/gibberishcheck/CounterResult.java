package dms.pastor.tools.job.gibberishcheck;

import dms.pastor.utils.NumberUtils;

/**
 * Author: Dominik Symonowicz
 * Website: <a href="https://dominiksymonowicz.com/">Home Page</a>
 * LinkedIn: <a href="https://www.linkedin.com/in/dominik-symonowicz">LinkedIn</a>
 * GitHub: <a href="https://github.com/pastorcmentarny">GitHub</a>
 */
public record CounterResult(int count, int allWords) {
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
