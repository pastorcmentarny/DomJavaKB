package dms.pastor.tools.tube;

import dms.pastor.domain.exception.NotFoundException;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.util.List;

import static dms.pastor.tools.tube.Status.PASSED;
import static dms.pastor.tools.tube.Status.VISITED;
import static dms.pastor.utils.StringUtils.isStringEmpty;
import static java.util.Collections.unmodifiableList;

class Stations {
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(Stations.class);

    private final List<Station> stationList;

    Stations(List<Station> stationList) {
        this.stationList = stationList;
    }

    List<Station> getStationList() {
        return unmodifiableList(stationList);
    }

    void setPassedFor(Station station) {
        if (station.getStatus() != VISITED && station.getStatus() != PASSED) {
            station.setStatus(PASSED);
            station.setPassedDate(LocalDate.now());
        } else {
            LOGGER.info("You passed or visited this station already.");
        }
    }

    Station getStationByName(String name) {
        return stationList.stream()
                .filter(station -> station.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new NotFoundException("Station " + name));
    }

    void setVisitedFor(Station station) {
        if (station.getStatus() != VISITED) {
            station.setStatus(VISITED);
            if (station.getPassedDate() == null) {
                station.setPassedDate(LocalDate.now());
            }
            station.setVisitedDate(LocalDate.now());
        } else {
            LOGGER.info("You visited this station already.");
        }

    }

    long countStationPassed() {
        return countStationThatHasStatusOf(PASSED.value());
    }

    long countStationVisited() {
        return countStationThatHasStatusOf(VISITED.value());
    }

    private long countStationThatHasStatusOf(String statusValue) {
        return stationList.stream()
                .filter(station -> station.getStatus().value().equalsIgnoreCase(statusValue))
                .count();
    }

    Station findStation(String searchFor) {
        final NotFoundException notFoundException = new NotFoundException("Station");
        if (isStringEmpty(searchFor)) {
            LOGGER.warn(String.format("Unable to find station as search query is invalid. User typed: %s", searchFor));
            throw notFoundException;
        }
        return stationList.stream()
                .filter(station -> station.getName().equalsIgnoreCase(searchFor))
                .findFirst()
                .orElseThrow(() -> notFoundException);
    }

    int totalNumber() {
        return stationList.size();
    }
}
