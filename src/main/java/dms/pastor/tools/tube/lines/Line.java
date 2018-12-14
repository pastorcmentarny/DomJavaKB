package dms.pastor.tools.tube.lines;

import dms.pastor.tools.tube.station.Station;
import dms.pastor.tools.tube.station.StationName;

import java.util.List;

public class Line {
    private String name;

    void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    boolean has(String name, List<StationName> stationList) {
        return stationList.stream().anyMatch(station -> station.name().equalsIgnoreCase(name));
    }

    public long getPercentageOfTravelledStation(List<Station> passedStation, List<StationName> stationList) {
        final long count = passedStation.stream().filter(station -> has(station.getName(), stationList)).count();
        return count / stationList.size() * 100;
    }
}
