package dms.pastor.tools.trips.common;

import dms.pastor.tools.trips.common.station.StationType;

import java.time.LocalDate;

public class Constants {
    public static final int ALL_TUBE_STATIONS = 270;
    public static final int ALL_OVERGROUND_STATIONS = 112;

    public static String getDateAsStringOrNone(LocalDate date) {
        return date == null ? "none" : date.toString();
    }


    public static int getAllStationsNumberFor(StationType type) {

        return switch (type) {
            case TUBE -> ALL_TUBE_STATIONS;
            case OVERGROUND -> ALL_OVERGROUND_STATIONS;
            default -> throw new IllegalStateException("Not supported type:" + type);
        };

    }
}
