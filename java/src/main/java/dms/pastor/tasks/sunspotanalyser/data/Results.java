package dms.pastor.tasks.sunspotanalyser.data;

import java.util.ArrayList;
import java.util.Collections;

import static dms.pastor.utils.StringUtils.EMPTY_STRING;

/**
 * Author Dominik Symonowicz
 * Created 2013-08-26
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 * <p>
 * Manages Results (creates,display,generate high scores).
 */
class Results {

    private final ArrayList<Score> highScores;

    Results() {
        highScores = new ArrayList<>();
    }

    void addScore(Score score) {
        highScores.add(score);
    }

    String displayResults(int top) {
        Collections.sort(highScores);
        StringBuilder sb = new StringBuilder(EMPTY_STRING);
        int no = Math.min(top, highScores.size());
        for (int i = 0; i < no; i++) {
            sb.append(highScores.get(i).displayScore());
        }
        return sb.toString();
    }

    public int getResultSize() {
        return highScores.size();
    }
}
