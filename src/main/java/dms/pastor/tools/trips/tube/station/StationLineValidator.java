package dms.pastor.tools.trips.tube.station;

import java.util.Objects;

import static dms.pastor.tools.trips.tube.station.TubeStation.SEPARATOR;
import static dms.pastor.utils.ValidatorUtils.validateIfNotEmpty;

/**
 * Author Dominik Symonowicz
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public final class StationLineValidator {
    private static final int COLUMNS_NUMBER = 6;

    private StationLineValidator() {
    }

    public static String[] validate(String stationAsString) {

        validateIfNotEmpty(stationAsString, "TubeStation as string");
        String[] columns = stationAsString.split(SEPARATOR);
        if (columns.length != COLUMNS_NUMBER) {
            throw new IllegalArgumentException("Invalid number of columns. Expect " + COLUMNS_NUMBER + " but was " + columns.length);
        }
        final Status status = Status.fromValue(columns[1]);
        verifyPassedDate(columns, status);
        verifyVisitedDate(columns, status);

        return columns;
    }

    private static void verifyPassedDate(String[] columns, Status status) {
        if (status == Status.PASSED || status == Status.VISITED) {
            if (Objects.isNull(columns[3])) {
                throw new IllegalArgumentException("Status is passed/visited but there is date missing for passed date");
            }
        }
    }

    private static void verifyVisitedDate(String[] columns, Status status) {
        if (status == Status.VISITED) {
            if (Objects.isNull(columns[4])) {
                throw new IllegalArgumentException("Status is visited but there is date missing for visited date");
            }
        }
    }


}
