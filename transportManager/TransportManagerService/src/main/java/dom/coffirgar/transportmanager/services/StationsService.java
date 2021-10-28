package dom.coffirgar.transportmanager.services;

import dom.coffirgar.transportmanager.domain.stations.Station;
import dom.coffirgar.transportmanager.exceptions.NotFoundException;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static dom.coffirgar.transportmanager.common.Utils.isStringEmpty;
import static dom.coffirgar.transportmanager.domain.stations.Status.PASSED;
import static dom.coffirgar.transportmanager.domain.stations.Status.VISITED;
import static java.util.Collections.unmodifiableList;

/**
 * Author Dominik Symonowicz
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
@Service
public class StationsService {
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(StationsService.class);

    private final List<Station> stationList;

    public StationsService(List<Station> stationList) {
        this.stationList = stationList;
    }

    public List<Station> getStationList() {
        return unmodifiableList(stationList);
    }

    public void setPassedFor(Station station) {
        if (station.getStatus() != VISITED && station.getStatus() != PASSED) {
            station.setStatus(PASSED);
            station.setPassedDateToNow();
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
            station.setVisitedDateToNow();
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


    public Station findStation(String searchFor) {
        final NotFoundException notFoundException = new NotFoundException("tube station " + searchFor + " ");
        if (isStringEmpty(searchFor)) {
            LOGGER.warn(String.format("Unable to find station as search query is invalid. User typed: %s", searchFor));
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
            LOGGER.warn(String.format("Unable to find station as search query is invalid. User typed: %s", searchFor));
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
