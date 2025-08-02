package dms.pastor.tools.trips.common.station;

import dms.pastor.domain.exception.NotFoundException;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import static dms.pastor.tools.trips.common.options.Status.PASSED;
import static dms.pastor.tools.trips.common.options.Status.VISITED;
import static dms.pastor.utils.StringUtils.isStringEmpty;
import static java.util.Collections.unmodifiableList;

/**
 * Author Dominik Symonowicz
* Website: <a href="https://dominiksymonowicz.com/">Home Page</a>
* LinkedIn: <a href="https://www.linkedin.com/in/dominik-symonowicz">LinkedIn</a>
* GitHub: <a href="https://github.com/pastorcmentarny">GitHub</a>
 */
public record Stations(List<Station> stationList) {
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(Stations.class);

    @Override
    public List<Station> stationList() {
        return unmodifiableList(stationList);
    }

    public void setPassedFor(Station station) {
        if (station.getStatus() != VISITED && station.getStatus() != PASSED) {
            station.setStatus(PASSED);
            station.setPassedDate(LocalDate.now());
        } else {
            LOGGER.info("You passed or visited this tube station already.");
        }
    }

    public Station getStationByName(String name) {
        return stationList.stream()
                .filter(station -> station.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new NotFoundException("TubeStation " + name));
    }

    public void setVisitedFor(Station station) {
        if (station.getStatus() != VISITED) {
            station.setStatus(VISITED);
            if (station.getPassedDate() == null) {
                station.setPassedDate(LocalDate.now());
            }
            station.setVisitedDate(LocalDate.now());
            station.setVisitedStationThisYearToNow();
        } else {
            LOGGER.info("You visited this tube station already.");
            setVisitedThisYearFor(station);
        }
    }

    private void setVisitedThisYearFor(Station station) {
        if (Objects.nonNull(station.getVisitedThisYearDate())) {
            LOGGER.info("You visited this tube station this year too.");
        } else {
            System.out.println("You updated " + station.getName() + " with info that you visited this year.");
            station.setVisitedStationThisYearToNow();
        }
    }

    public long countStationPassed() {
        return countStationThatHasStatusOf(PASSED.value()) + countStationVisited();
    }

    public long countStationVisited() {
        return countStationThatHasStatusOf(VISITED.value());
    }

    public long countStationVisitedThisYear() {
        return stationList.stream()
                .filter(station -> station.getStatus().value().equalsIgnoreCase(VISITED.value()) && Objects.nonNull(station.getVisitedThisYearDate()))
                .count();
    }

    private long countStationThatHasStatusOf(String statusValue) {
        return stationList.stream()
                .filter(station -> station.getStatus().value().equalsIgnoreCase(statusValue))
                .count();
    }

    public long countStationsBlogged() {
        return stationList.stream()
                .filter(Station::isBlogged)
                .count();
    }

    public List<String> displayAllStationsBlogged() {
        return stationList.stream()
                .filter(Station::isBlogged)
                .map(Station::getName)
                .collect(Collectors.toList());
    }

    public Station findStation(String searchFor) {
        final NotFoundException notFoundException = new NotFoundException("tube station " + searchFor + " ");
        if (isStringEmpty(searchFor)) {
            LOGGER.warn("Unable to find station as search query is invalid (Empty). User typed: {}", searchFor);
            throw notFoundException;
        }

        return stationList.stream()
                .filter(station -> station.getName().equalsIgnoreCase(searchFor))
                .findFirst()
                .orElseThrow(() -> notFoundException);
    }

    public Optional<Station> getStation(String searchFor) {
        final NotFoundException notFoundException = new NotFoundException("TubeStation");
        if (isStringEmpty(searchFor)) {
            LOGGER.warn("Unable to get station as search query is invalid (empty). User typed: {}", searchFor);
            throw notFoundException;
        }

        return stationList.stream()
                .filter(station -> station.getName().equalsIgnoreCase(searchFor))
                .findFirst();
    }


    public int totalNumber() {
        return stationList.size();
    }

}
