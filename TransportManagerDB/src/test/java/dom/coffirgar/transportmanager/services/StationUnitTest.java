package dom.coffirgar.transportmanager.services;

import dom.coffirgar.transportmanager.domain.stations.Station;
import dom.coffirgar.transportmanager.exceptions.NotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static dom.coffirgar.transportmanager.common.Utils.EMPTY_STRING;
import static dom.coffirgar.transportmanager.common.Utils.generateString;
import static dom.coffirgar.transportmanager.domain.stations.Status.*;
import static org.assertj.core.api.Assertions.assertThat;

public class StationUnitTest {
    private static final LocalDate PASSED_DATE = LocalDate.now();
    private static final LocalDate VISITED_DATE = LocalDate.now();

    private static final LocalDate THIS_YEAR_VISITED_DATE = LocalDate.now();

    private static final Station WEMBLEY_PARK = new Station("Wembley Park", VISITED, PASSED_DATE, VISITED_DATE, THIS_YEAR_VISITED_DATE);
    private static final String STATION_NAME = "Amersham";

    private final StationsService stationsService = generateStations();

    @Test
    public void getStationByNameShouldReturnStation() {
        // given
        final String stationName = STATION_NAME;
        final Station amershamStation = Station.notVisited(stationName);
        StationsService stationsService = new StationsService(Collections.singletonList(amershamStation));

        // when
        Station result = stationsService.getStationByName(stationName);

        // then
        assertThat(result).isEqualTo(amershamStation);

    }

    @Test
    public void setPassedForShouldSetStatusToPassIfStationHasStatusNotVisited() {
        // given
        final String stationName = STATION_NAME;
        final Station amersham = Station.notVisited(stationName);
        StationsService stationsService = new StationsService(Collections.singletonList(amersham));

        // when
        stationsService.setPassedFor(amersham);

        // then
        assertThat(stationsService.getStationByName(stationName).getStatus()).isEqualTo(PASSED);

    }

    @Test
    public void setPassedForShouldNotChangeStatusToPassedForVisited() {
        // given
        final String stationName = STATION_NAME;
        final LocalDate today = LocalDate.now();
        final Station amersham = new Station(stationName, VISITED, today, today, today);
        StationsService stationsService = new StationsService(Collections.singletonList(amersham));

        // when
        stationsService.setPassedFor(amersham);

        // then
        assertThat(stationsService.getStationByName(stationName).getStatus()).isEqualTo(VISITED);
    }

    @Test
    public void setVisitedForShouldSetStatusToVisitedIfStationHasStatusNotVisited() {
        // given
        final String stationName = STATION_NAME;
        final LocalDate today = LocalDate.now();
        final Station amersham = new Station(stationName, NOT_VISITED, today, today, today);
        StationsService stationsService = new StationsService(Collections.singletonList(amersham));

        // when
        stationsService.setVisitedFor(amersham);

        // then
        assertThat(stationsService.getStationByName(stationName).getStatus()).isEqualTo(VISITED);
    }

    @Test
    public void setVisitedForShouldSetStatusToVisitedIfStationHasStatusPassed() {
        // given
        final Station amersham = Station.passed(STATION_NAME, PASSED_DATE);
        StationsService stationsService = new StationsService(Collections.singletonList(amersham));

        // when
        stationsService.setVisitedFor(amersham);

        // then
        assertThat(stationsService.getStationByName(STATION_NAME).getStatus()).isEqualTo(VISITED);
    }

    @Test
    public void setVisitedForShouldSetBothPassedDateAndVisitedDateWhenIfStationHasPreviouslyStatusNotVisited() {
        // given
        final Station amersham = Station.passed(STATION_NAME, PASSED_DATE);
        StationsService stationsService = new StationsService(Collections.singletonList(amersham));

        // when
        stationsService.setVisitedFor(amersham);

        // then
        assertThat(stationsService.getStationByName(STATION_NAME).getPassedDate()).isEqualTo(LocalDate.now());
        assertThat(stationsService.getStationByName(STATION_NAME).getVisitedDate()).isEqualTo(LocalDate.now());
    }

    @Test
    public void setVisitedForShouldNotSetPassedDateIfStationHasPreviouslyStatusNotVisited() {
        // given
        final LocalDate yesterday = PASSED_DATE.minusDays(1);
        final Station amersham = Station.passed(STATION_NAME, yesterday);
        StationsService stationsService = new StationsService(Collections.singletonList(amersham));

        // when
        stationsService.setVisitedFor(amersham);

        // then
        assertThat(stationsService.getStationByName(STATION_NAME).getPassedDate()).isEqualTo(yesterday);
        assertThat(stationsService.getStationByName(STATION_NAME).getVisitedDate()).isEqualTo(LocalDate.now());
    }

    @Test
    public void countStationPassedShouldCountStationPassed() {
        // when
        final long count = stationsService.countStationPassed();

        // then
        assertThat(count).isEqualTo(2);
    }

    @Test
    public void countStationPassedShouldCountStationVisited() {
        // when
        final long count = stationsService.countStationVisited();

        // then
        assertThat(count).isEqualTo(1);
    }

    @Test
    public void findStationShouldThrowNotFoundExceptionWhenSearchForIsNull() {
        // when
        final var exception = Assertions.assertThrows(NotFoundException.class, () -> stationsService.findStation(null));
        assertThat(exception.getMessage()).isEqualTo("tube station null  was not found.");
    }

    @Test
    public void findStationShouldThrowNotFoundExceptionWhenSearchForIsEmpty() {
        // when
        final var exception = Assertions.assertThrows(NotFoundException.class, () -> stationsService.findStation(EMPTY_STRING));

        // then
        assertThat(exception.getMessage()).isEqualTo("tube station   was not found.");
    }

    @Test
    public void findStationShouldThrowNotFoundExceptionWhenSearchForDoNotMatchAnyStation() {
        // given
        var stationName = generateString();

        // when
        final var exception = Assertions.assertThrows(NotFoundException.class, () -> stationsService.findStation(stationName));

        // then
        assertThat(exception.getMessage()).isEqualTo("tube station " + stationName + "  was not found.");
    }


    @Test
    public void findStationShouldReturnWembleyParkStationWhenSearchForWembleyPark() {
        // when
        final Station station = stationsService.findStation(WEMBLEY_PARK.getName());

        // then
        assertThat(station).isEqualTo(WEMBLEY_PARK);
    }

    @Test
    public void passedShouldReturnStationWithPassedDateButWithoutVisitedDate() {
        // given
        final Station expectedStation = new Station(STATION_NAME, PASSED, PASSED_DATE, null, null);

        // when
        final Station result = Station.passed(STATION_NAME, PASSED_DATE);

        // then
        assertThat(result).isEqualTo(expectedStation);
    }

    @Test
    public void notVisitedShouldReturnStationWithoutPassedAndOrVisitedDate() {
        // given
        final Station expectedStation = new Station(STATION_NAME, NOT_VISITED, null, null, null);

        // when
        final Station result = Station.notVisited(STATION_NAME);

        // then
        assertThat(result).isEqualTo(expectedStation);

    }


    @Test //this test based on test data
    public void totalNumberShouldReturn3ForStationsCount() {
        // given
        final StationsService stationsService = generateStations();

        // when
        final int result = stationsService.totalNumber();

        // then
        assertThat(result).isEqualTo(3);
    }

    private StationsService generateStations() {
        List<Station> stationList = new ArrayList<>();
        stationList.add(WEMBLEY_PARK);
        stationList.add(Station.passed("Green Park", LocalDate.now()));
        stationList.add(Station.notVisited("Elm Park"));
        return new StationsService(stationList);
    }

}
