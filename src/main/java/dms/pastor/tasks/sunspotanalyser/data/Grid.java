package dms.pastor.tasks.sunspotanalyser.data;

import static dms.pastor.utils.StringUtils.EMPTY_STRING;
import static dms.pastor.utils.StringUtils.WHITESPACE_CHAR;

/**
 * Author Dominik Symonowicz
 * Created 2013-08-26
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
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
            cell = populateColumn(data, cell, row);
        }
    }

    private Integer populateColumn(String[] data, Integer cell, int row) {
        for (int column = 0; column < gridSize; column++) {
            grid[row][column] = Integer.parseInt(data[cell]);
            cell++;
        }
        return cell;
    }

    //used for debug mode // TODO improve it
    void displayGrid() {
        for (int row = 0; row < gridSize; row++) {
            for (int column = 0; column < gridSize; column++) {
                System.out.print(WHITESPACE_CHAR + grid[row][column]);
            }
            System.out.println(EMPTY_STRING);
        }
    }

    public int size() {
        return gridSize;
    }

    int getScore(int x, int y) {
        if (isInRange(x, y)) {
            return grid[x][y];
        } else {
            return 0;
        }
    }

    boolean isInRange(int x, int y) {
        return isInRangeFor(x) && isInRangeFor(y);
    }

    private boolean isInRangeFor(int coordinate) {
        return !(coordinate < 0 || coordinate >= gridSize);
    }
}
