package dms.pastor.tools.tube;

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
    private static final int columnsNumber = 3;

    public static void validate(String stationAsString) {

        validateIfNotEmpty(stationAsString, "Station as string");
        String[] columns = stationAsString.split(SEPARATOR);
        if (columns.length != columnsNumber) {
            throw new IllegalArgumentException("Invalid number of columns. Expect " + columnsNumber + " but was " + columns.length);
        }
        Status.fromValue(columns[1]);
    }
}
