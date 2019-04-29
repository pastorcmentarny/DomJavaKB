package dms.pastor.tasks.berlinclock;

import dms.pastor.tasks.berlinclock.data.Light;
import dms.pastor.tasks.berlinclock.data.Time;

import static dms.pastor.tasks.berlinclock.data.Light.RED;
import static dms.pastor.tasks.berlinclock.data.Light.YELLOW;
import static dms.pastor.utils.StringUtils.EMPTY_STRING;
import static dms.pastor.utils.StringUtils.NEW_LINE;

/**
 * Author Dominik Symonowicz
 * Created 2013-07-24 at 21:36:16
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
class RowsGenerator {

    private final Time time;

    RowsGenerator(Time time) {
        this.time = time;
    }

    String generateRows() {
        return EMPTY_STRING + firstRow() + NEW_LINE +
            secondRow() + NEW_LINE +
            thirdRow() + NEW_LINE +
            fourthRow() + NEW_LINE +
            fifthRow() + NEW_LINE;
    }

    private String firstRow() {
        return time.getSeconds() % 2 == 0 ? YELLOW.getColor() : Light.OFF.getColor();
    }

    private String secondRow() {
        return rowMaker(time.getHours() / 5, RED, 4);
    }

    private String thirdRow() {
        return rowMaker(time.getHours() % 5, RED, 4);
    }

    private String fourthRow() {
        return rowMaker(time.getMinutes() / 5, RED, 11);
    }

    private String fifthRow() {
        return rowMaker(time.getMinutes() % 5, YELLOW, 4);
    }

    private String rowMaker(int lightsOn, Light on, int howMany) {
        StringBuilder row = new StringBuilder(EMPTY_STRING);
        row.append(String.valueOf(on.getColor()).repeat(Math.max(0, lightsOn)));
        return generateRow(lightsOn, howMany, row);
    }

    private String generateRow(int lightsOn, int howMany, StringBuilder row) {
        row.append(String.valueOf(Light.OFF.getColor()).repeat(Math.max(0, howMany - lightsOn)));
        return row.toString();
    }
}
