package dms.pastor.tools.tube;

import dms.pastor.domain.exception.NotFoundException;

import java.util.List;

import static dms.pastor.tools.tube.Status.PASSED;
import static dms.pastor.tools.tube.Status.VISITED;
import static java.util.Collections.unmodifiableList;

public class Stations {
    private List<Station> stationList;

    public Stations(List<Station> stationList) {
        this.stationList = stationList;
    }

    public List<Station> getStationList() {
        return unmodifiableList(stationList);
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

    public long countStationPassed() {
        return countStationThatHasStatusOf(PASSED.value());
    }

    public long countStationVisited() {
        return countStationThatHasStatusOf(VISITED.value());
    }

    private long countStationThatHasStatusOf(String statusValue) {
        return stationList.stream()
                .filter(station -> station.getStatus().value().equalsIgnoreCase(statusValue))
                .count();
    }

}

