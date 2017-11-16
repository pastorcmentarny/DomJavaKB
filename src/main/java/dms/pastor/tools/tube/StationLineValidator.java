package dms.pastor.tools.tube;

import java.util.Objects;

import static dms.pastor.tools.tube.Station.SEPARATOR;
import static dms.pastor.utils.ValidatorUtils.validateIfNotEmpty;

/**
 * Author Dominik Symonowicz
 * Created 08/11/2017
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */

class StationLineValidator {
    private static final int columnsNumber = 5;

    public static String[] validate(String stationAsString) {

        validateIfNotEmpty(stationAsString, "Station as string");
        String[] columns = stationAsString.split(SEPARATOR);
        if (columns.length != columnsNumber) {
            throw new IllegalArgumentException("Invalid number of columns. Expect " + columnsNumber + " but was " + columns.length);
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
