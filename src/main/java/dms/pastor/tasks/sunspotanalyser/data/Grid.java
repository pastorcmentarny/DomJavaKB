package dms.pastor.tasks.sunspotanalyser.data;

/**
 * Author Dominik Symonowicz
 * Created 2013-08-26
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 * <p>
 * A grid of data
 */
public class Grid {

    private Integer grid[][];
    private int gridSize;

    Grid(String[] data) {
        populateGrid(data);
    }

    private void populateGrid(String[] data) {
        gridSize = Integer.valueOf(data[1]);
        grid = new Integer[gridSize][gridSize];
        Integer cell = 2;
        for (int row = 0; row < gridSize; row++) {
            for (int column = 0; column < gridSize; column++) {
                grid[row][column] = Integer.parseInt(data[cell]);
                cell++;
            }
        }
    }

    //used for debug mode // TODO improve it
    void displayGrid() {
        for (int row = 0; row < gridSize; row++) {
            for (int column = 0; column < gridSize; column++) {
                System.out.print(" " + grid[row][column]);
            }
            System.out.println("");
        }
    }

    public int size() {
        return gridSize;
    }

    public int getScore(int x, int y) {
        if (isInRange(x, y)) {
            return grid[x][y];
        } else {
            return 0;
        }
    }

    public boolean isInRange(int x, int y) {
        return isInRangeFor(x) && isInRangeFor(y);
    }

    private boolean isInRangeFor(int coordinate) {
        return !(coordinate < 0 || coordinate >= gridSize);
    }
}
