package dms.pastor.tasks.sunspotanalyser.data;

import java.util.Objects;

/**
 * Author Dominik Symonowicz
 * Created 2013-08-26
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 * <p>
 * A score model.
 */
class Score implements Comparable<Score> {

    private final int x;
    private final int y;
    private final int score;

    public Score(int x, int y, int score) {
        this.x = x;
        this.y = y;
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    String displayScore() {
        return "(" + y + ',' + x + " score:" + score + ')';
    }

    @Override
    public int compareTo(Score o) {
        return o.getScore() - this.score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Score score1 = (Score) o;
        return x == score1.x &&
                y == score1.y &&
                getScore() == score1.getScore();
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, getScore());
    }
}
