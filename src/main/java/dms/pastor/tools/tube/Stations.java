package dms.pastor.tools.tube;

import dms.pastor.domain.exception.NotFoundException;
import dms.pastor.utils.StringUtils;
import org.slf4j.LoggerFactory;

import java.util.List;

import static dms.pastor.tools.tube.Status.PASSED;
import static dms.pastor.tools.tube.Status.VISITED;
import static java.util.Collections.unmodifiableList;

public class Stations {
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(Stations.class);

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

    public Station findStation(String searchFor) {
        final NotFoundException notFoundException = new NotFoundException("Station");
        if (StringUtils.isStringEmpty(searchFor)) {
            LOGGER.warn(String.format("Unable to find station as search query is invalid. User typed: %s", searchFor));
            throw notFoundException;
        }
        return stationList.stream()
                .filter(station -> station.getName().equalsIgnoreCase(searchFor))
                .findFirst()
                .orElseThrow(() -> notFoundException);
    }

}
