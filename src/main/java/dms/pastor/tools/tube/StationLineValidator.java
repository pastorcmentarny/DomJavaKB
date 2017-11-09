package dms.pastor.tools.tube;

import static dms.pastor.tools.tube.Station.SEPARATOR;
import static dms.pastor.utils.ValidatorUtils.validateIfNotEmpty;

public class StationLineValidator {
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
