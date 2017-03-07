package dms.pastor.tasks.sunspotanalyser.data;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Author Dominik Symonowicz
 * Created 2013-08-26
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 * <p>
 * Manages Results (creates,display,generate high scores).
 */
class Results {

    private final ArrayList<Score> highScores;

    public Results() {
        highScores = new ArrayList<>();
    }

    public void addScore(Score score) {
        highScores.add(score);
    }

    public String displayResults(int top) {
        Collections.sort(highScores);
        StringBuilder sb = new StringBuilder("");
        int no = top > highScores.size() ? highScores.size() : top;
        for (int i = 0; i < no; i++) {
            sb.append(highScores.get(i).displayScore());
        }
        return sb.toString();

    }

    public int getResultSize() {
        return highScores.size();
    }
}
