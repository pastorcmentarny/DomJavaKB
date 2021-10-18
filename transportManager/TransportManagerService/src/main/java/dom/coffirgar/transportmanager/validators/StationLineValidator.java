package dom.coffirgar.transportmanager.validators;


import dom.coffirgar.transportmanager.domain.stations.Status;

import java.util.Objects;

import static dom.coffirgar.transportmanager.common.Utils.*;


/**
 * Author Dominik Symonowicz
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public final class StationLineValidator {
    private static final int COLUMNS_NUMBER = 5;

    private StationLineValidator() {
    }

    //TODO Rename to transfomer and extract validation to seperate class
    public static String[] validate(String stationAsString) {

        validateIfNotEmpty(stationAsString, "TubeStation as string");
        String[] columns = stationAsString.split(FIELD_SEPARATOR);
        if (columns.length != COLUMNS_NUMBER) {
            throw new IllegalArgumentException("Invalid number of columns. Expect " + COLUMNS_NUMBER + " but was " + columns.length + "Line:" + printArray(columns));
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
