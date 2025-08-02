package dms.pastor.tasks.sunspotanalyser.data;

/**
 * Author Dominik Symonowicz
 * Created 2013-08-26
* Website: <a href="https://dominiksymonowicz.com/">Home Page</a>
* LinkedIn: <a href="https://www.linkedin.com/in/dominik-symonowicz">LinkedIn</a>
* GitHub: <a href="https://github.com/pastorcmentarny">GitHub</a>
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
