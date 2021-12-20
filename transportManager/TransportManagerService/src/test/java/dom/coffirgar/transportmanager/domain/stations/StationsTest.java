package dom.coffirgar.transportmanager.domain.stations;


import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class StationsTest {


    @Test
    void countStationPassedShouldReturnSixForStationsPassedAndVisitedInTheListTest() {
        // given
        Stations stations = generateStations();
        // when
        final int result = stations.countStationPassed();
        // then
        assertThat(result).isEqualTo(6);
    }

    @Test
    void countStationVisitedShouldReturnOneForOnePassedStationInTheListTest() {
        // given
        Stations stations = generateStations();
        // when
        final int result = stations.countStationPassed();
        // then
        assertThat(result).isEqualTo(6);
    }


    private Stations generateStations() {
        var stationList = List.of(Station.passed("Amersham", LocalDate.now().minusDays(1)),
                Station.passed("Bank", LocalDate.now().minusDays(2)),
                Station.notVisited("Chesham"),
                Station.notVisited("Debden"),
                Station.notVisited("Epping"),
                Station.notVisited("Finchley Road"),
                Station.visited("Great Portland Street", LocalDate.now().minusYears(2)),
                Station.visitedThisYear("Hammersmith", LocalDate.now().minusYears(1), LocalDate.now()),
                Station.visitedThisYear("Ickenham", LocalDate.now().minusYears(1), LocalDate.now()),
                Station.visitedThisYear("Kilburn", LocalDate.now().minusYears(1), LocalDate.now()));
        return new Stations(stationList);
    }


}