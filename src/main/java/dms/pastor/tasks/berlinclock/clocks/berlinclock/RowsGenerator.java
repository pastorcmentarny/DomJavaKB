package dms.pastor.tasks.berlinclock.clocks.berlinclock;

import dms.pastor.tasks.berlinclock.data.Light;
import dms.pastor.tasks.berlinclock.data.Time;

import static dms.pastor.tasks.berlinclock.data.Light.RED;
import static dms.pastor.tasks.berlinclock.data.Light.YELLOW;

/**
 * Author Dominik Symonowicz
 * Created 2013-07-24 at 21:36:16
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
class RowsGenerator {
    private static final String EMPTY = "";
    private final Time time;

    RowsGenerator(Time time) {
        this.time = time;
    }

    String generateRows() {
        final String newLine = "\n";
        return EMPTY + firstRow() + newLine +
                secondRow() + newLine +
                thirdRow() + newLine +
                fourthRow() + newLine +
                fifthRow() + newLine;
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
        StringBuilder row = new StringBuilder(EMPTY);
        for (int i = 0; i < lightsOn; i++) {
            row.append(on.getColor());
        }
        return generateRow(lightsOn, howMany, row);
    }

    private String generateRow(int lightsOn, int howMany, StringBuilder row) {
        for (int i = lightsOn; i < howMany; i++) {
            row.append(Light.OFF.getColor());
        }
        return row.toString();
    }
}
