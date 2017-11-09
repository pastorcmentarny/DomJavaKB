package dms.pastor.tools.tube;

import static dms.pastor.tools.tube.Status.NOT_VISITED;

final class ToStationConverter {

    private ToStationConverter() {
    }

    public static Station convert(String stationAsString) {
        StationLineValidator.validate(stationAsString);
        return new Station(stationAsString, NOT_VISITED, Line.noLine());
    }
}
