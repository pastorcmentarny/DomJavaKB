package dms.pastor.tools.tube;

import dms.pastor.domain.exception.NotFoundException;

import java.util.List;

import static dms.pastor.tools.tube.Status.PASSED;
import static dms.pastor.tools.tube.Status.VISITED;

public class Stations {
    List<Station> stationList;

    public Stations(List<Station> stationList) {
        this.stationList = stationList;
    }

    public void setPassedFor(Station station) {
        if (station.getStatus() != VISITED) {
            station.setStatus(PASSED);
        }
    }

    public Station getStationByName(String name) {
        return stationList.stream()
                .filter(station -> station.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new NotFoundException("Station " + name));
    }

    public void setVisitedFor(Station station) {
        station.setStatus(VISITED);
    }
}
