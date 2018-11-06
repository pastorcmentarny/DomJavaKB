package dms.pastor.tools.trips.tube.station;

import dms.pastor.domain.exception.NotFoundException;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import static dms.pastor.tools.trips.tube.station.Status.PASSED;
import static dms.pastor.tools.trips.tube.station.Status.VISITED;
import static dms.pastor.utils.StringUtils.isStringEmpty;
import static java.util.Collections.unmodifiableList;

/**
 * Author Dominik Symonowicz
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class Stations {
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(Stations.class);

    private final List<TubeStation> tubeStationList;

    public Stations(List<TubeStation> tubeStationList) {
        this.tubeStationList = tubeStationList;
    }

    public List<TubeStation> getTubeStationList() {
        return unmodifiableList(tubeStationList);
    }

    public void setPassedFor(TubeStation tubeStation) {
        if (tubeStation.getStatus() != VISITED && tubeStation.getStatus() != PASSED) {
            tubeStation.setStatus(PASSED);
            tubeStation.setPassedDate(LocalDate.now());
        } else {
            LOGGER.info("You passed or visited this tubeStation already.");
        }
    }

    public TubeStation getStationByName(String name) {
        return tubeStationList.stream()
                .filter(station -> station.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new NotFoundException("TubeStation " + name));
    }

    public void setVisitedFor(TubeStation tubeStation) {
        if (tubeStation.getStatus() != VISITED) {
            tubeStation.setStatus(VISITED);
            if (tubeStation.getPassedDate() == null) {
                tubeStation.setPassedDate(LocalDate.now());
            }
            tubeStation.setVisitedDate(LocalDate.now());
            tubeStation.setVisitedStationThisYearToNow();
        } else {
            LOGGER.info("You visited this tubeStation already.");
            setVisitedThisYearFor(tubeStation);
        }
    }

    private void setVisitedThisYearFor(TubeStation tubeStation) {
        if (Objects.nonNull(tubeStation.getVisitedThisYearDate())) {
            LOGGER.info("You visited this tubeStation this year too.");
        } else {
            System.out.println("You updated " + tubeStation.getName() + " with info that you visited this year.");
            tubeStation.setVisitedStationThisYearToNow();
        }
    }

    public long countStationPassed() {
        return countStationThatHasStatusOf(PASSED.value()) + countStationVisited();
    }

    public long countStationVisited() {
        return countStationThatHasStatusOf(VISITED.value());
    }

    public long countStationVisitedThisYear() {
        return tubeStationList.stream()
                .filter(station -> station.getStatus().value().equalsIgnoreCase(VISITED.value()) && Objects.nonNull(station.getVisitedThisYearDate()))
                .count();
    }

    public boolean isStationWasPassed() {
        return tubeStationList.stream()
                .anyMatch(s -> s.getStatus().equals(PASSED) || s.getStatus().equals(VISITED));
    }

    private long countStationThatHasStatusOf(String statusValue) {
        return tubeStationList.stream()
                .filter(station -> station.getStatus().value().equalsIgnoreCase(statusValue))
                .count();
    }

    public long countStationsBlogged() {
        return tubeStationList.stream()
                .filter(TubeStation::isBlogged)
                .count();
    }

    public List<String> displayAllStationsBlogged() {
        return tubeStationList.stream()
                .filter(TubeStation::isBlogged)
                .map(TubeStation::getName)
                .collect(Collectors.toList());
    }

    public TubeStation findStation(String searchFor) {
        final NotFoundException notFoundException = new NotFoundException("TubeStation");
        if (isStringEmpty(searchFor)) {
            LOGGER.warn(String.format("Unable to find station as search query is invalid. User typed: %s", searchFor));
            throw notFoundException;
        }

        return tubeStationList.stream()
                .filter(station -> station.getName().equalsIgnoreCase(searchFor))
                .findFirst()
                .orElseThrow(() -> notFoundException);
    }

    public Optional<TubeStation> getStation(String searchFor) {
        final NotFoundException notFoundException = new NotFoundException("TubeStation");
        if (isStringEmpty(searchFor)) {
            LOGGER.warn(String.format("Unable to find station as search query is invalid. User typed: %s", searchFor));
            throw notFoundException;
        }

        return tubeStationList.stream()
                .filter(station -> station.getName().equalsIgnoreCase(searchFor))
                .findFirst();
    }


    public int totalNumber() {
        return tubeStationList.size();
    }

    public void setStationBloggedFor(TubeStation tubeStation) {
        tubeStation.setBlogged();
    }
}
