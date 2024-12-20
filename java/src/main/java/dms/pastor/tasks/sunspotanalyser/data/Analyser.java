package dms.pastor.tasks.sunspotanalyser.data;

/**
 * Author Dominik Symonowicz
 * Created 2013-08-26
 * WWW:	<a href="https://dominiksymonowicz.com/">HOME PAGE</a>
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 * Analyzers data and produce results
 */
public class Analyser {

    private final Grid grid;
    private final Results results;

    public Analyser(Grid grid) {
        this.grid = grid;
        results = new Results();
    }

    public int calculateSolarActivityScore(int x, int y) {
        int score = 0;
        for (int i = x - 1; i <= x + 1; i++) {
            for (int j = y - 1; j <= y + 1; j++) {
                score += grid.getScore(i, j);

            }
        }
        return score;
    }

    private void addScoreToResult(int x, int y, int score) {
        results.addScore(new Score(x, y, score));
    }

    public String getResults(int no) {
        return results.displayResults(no);

    }

    public void analyse() {
        for (int i = 0; i < grid.size(); i++) {
            for (int j = 0; j < grid.size(); j++) {
                int score = calculateSolarActivityScore(i, j);
                addScoreToResult(i, j, score);
            }
        }
    }

}
