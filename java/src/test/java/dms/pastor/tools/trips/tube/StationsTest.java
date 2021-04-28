package dms.pastor.tools.trips.tube;

import dms.pastor.domain.exception.NotFoundException;
import dms.pastor.tools.trips.common.options.Status;
import dms.pastor.tools.trips.common.station.Stations;
import dms.pastor.tools.trips.common.station.Station;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static dms.pastor.tools.trips.common.options.Status.*;
import static dms.pastor.utils.StringUtils.EMPTY_STRING;
import static dms.pastor.utils.randoms.RandomDataGenerator.generateString;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author Dominik Symonowicz
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class StationsTest {
    private static final LocalDate PASSED_DATE = LocalDate.now();
    private static final LocalDate VISITED_DATE = LocalDate.now();

    private static final LocalDate THIS_YEAR_VISITED_DATE = LocalDate.now();

    private static final Station WEMBLEY_PARK = new Station("Wembley Park", Status.VISITED, PASSED_DATE, VISITED_DATE, THIS_YEAR_VISITED_DATE, true);
    private static final String STATION_NOT_FOUND_ERROR_MESSAGE = "TubeStation was not found.";
    private static final String STATION_NAME = "Amersham";
    private static final boolean BLOGGED = false;

    private final Stations stations = generateStations();

    @Test
    public void getStationByNameShouldReturnStation() {
        // given
        final String stationName = STATION_NAME;
        final Station amershamStation = Station.notVisited(stationName);
        Stations stations = new Stations(Collections.singletonList(amershamStation));

        // when
        Station result = stations.getStationByName(stationName);

        // then
        assertThat(result).isEqualTo(amershamStation);

    }

    @Test
    public void setPassedForShouldSetStatusToPassIfStationHasStatusNotVisited() {
        // given
        final String stationName = STATION_NAME;
        final Station amersham = Station.notVisited(stationName);
        Stations stations = new Stations(Collections.singletonList(amersham));

        // when
        stations.setPassedFor(amersham);

        // then
        assertThat(stations.getStationByName(stationName).getStatus()).isEqualTo(PASSED);

    }

    @Test
    public void setPassedForShouldNotChangeStatusToPassedForVisited() {
        // given
        final String stationName = STATION_NAME;
        final LocalDate today = LocalDate.now();
        final Station amersham = new Station(stationName, VISITED, today, today, today, false);
        Stations stations = new Stations(Collections.singletonList(amersham));

        // when
        stations.setPassedFor(amersham);

        // then
        assertThat(stations.getStationByName(stationName).getStatus()).isEqualTo(VISITED);
    }

    @Test
    public void setVisitedForShouldSetStatusToVisitedIfStationHasStatusNotVisited() {
        // given
        final String stationName = STATION_NAME;
        final LocalDate today = LocalDate.now();
        final Station amersham = new Station(stationName, NOT_VISITED, today, today, today, BLOGGED);
        Stations stations = new Stations(Collections.singletonList(amersham));

        // when
        stations.setVisitedFor(amersham);

        // then
        assertThat(stations.getStationByName(stationName).getStatus()).isEqualTo(VISITED);
    }

    @Test
    public void setVisitedForShouldSetStatusToVisitedIfStationHasStatusPassed() {
        // given
        final Station amersham = Station.passed(STATION_NAME, PASSED_DATE);
        Stations stations = new Stations(Collections.singletonList(amersham));

        // when
        stations.setVisitedFor(amersham);

        // then
        assertThat(stations.getStationByName(STATION_NAME).getStatus()).isEqualTo(VISITED);
    }

    @Test
    public void setVisitedForShouldSetBothPassedDateAndVisitedDateWhenIfStationHasPreviouslyStatusNotVisited() {
        // given
        final Station amersham = Station.passed(STATION_NAME, PASSED_DATE);
        Stations stations = new Stations(Collections.singletonList(amersham));

        // when
        stations.setVisitedFor(amersham);

        // then
        assertThat(stations.getStationByName(STATION_NAME).getPassedDate()).isEqualTo(LocalDate.now());
        assertThat(stations.getStationByName(STATION_NAME).getVisitedDate()).isEqualTo(LocalDate.now());
    }

    @Test
    public void setVisitedForShouldNotSetPassedDateIfStationHasPreviouslyStatusNotVisited() {
        // given
        final LocalDate yesterday = PASSED_DATE.minusDays(1);
        final Station amersham = Station.passed(STATION_NAME, yesterday);
        Stations stations = new Stations(Collections.singletonList(amersham));

        // when
        stations.setVisitedFor(amersham);

        // then
        assertThat(stations.getStationByName(STATION_NAME).getPassedDate()).isEqualTo(yesterday);
        assertThat(stations.getStationByName(STATION_NAME).getVisitedDate()).isEqualTo(LocalDate.now());
    }

    @Test
    public void countStationPassedShouldCountStationPassed() {
        // when
        final long count = stations.countStationPassed();

        // then
        assertThat(count).isEqualTo(2);
    }

    @Test
    public void countStationPassedShouldCountStationVisited() {
        // when
        final long count = stations.countStationVisited();

        // then
        assertThat(count).isEqualTo(1);
    }

    @Test
    public void findStationShouldThrowNotFoundExceptionWhenSearchForIsNull() {
        // when
        final var exception = Assertions.assertThrows(NotFoundException.class, () -> stations.findStation(null));
        assertThat(exception.getMessage()).isEqualTo(STATION_NOT_FOUND_ERROR_MESSAGE);
    }

    @Test
    public void findStationShouldThrowNotFoundExceptionWhenSearchForIsEmpty() {
        // when
        final var exception = Assertions.assertThrows(NotFoundException.class, () -> stations.findStation(EMPTY_STRING));

        // then
        assertThat(exception.getMessage()).isEqualTo(STATION_NOT_FOUND_ERROR_MESSAGE);
    }

    @Test
    public void findStationShouldThrowNotFoundExceptionWhenSearchForDoNotMatchAnyStation() {
        // when
        final var exception = Assertions.assertThrows(NotFoundException.class, () -> stations.findStation(generateString()));

        // then
        assertThat(exception.getMessage()).isEqualTo(STATION_NOT_FOUND_ERROR_MESSAGE);
    }


    @Test
    public void findStationShouldReturnWembleyParkStationWhenSearchForWembleyPark() {
        // when
        final Station station = stations.findStation(WEMBLEY_PARK.getName());

        // then
        assertThat(station).isEqualTo(WEMBLEY_PARK);
    }

    @Test
    public void passedShouldReturnStationWithPassedDateButWithoutVisitedDate() {
        // given
        final Station expectedStation = new Station(STATION_NAME, PASSED, PASSED_DATE, null, null, BLOGGED);

        // when
        final Station result = Station.passed(STATION_NAME, PASSED_DATE);

        // then
        assertThat(result).isEqualTo(expectedStation);
    }

    @Test
    public void notVisitedShouldReturnStationWithoutPassedAndOrVisitedDate() {
        // given
        final Station expectedStation = new Station(STATION_NAME, NOT_VISITED, null, null, null, BLOGGED);

        // when
        final Station result = Station.notVisited(STATION_NAME);

        // then
        assertThat(result).isEqualTo(expectedStation);

    }

    @Test //this test based on test data
    public void totalNumberShouldReturn3ForStationsCount() {
        // given
        final Stations stations = generateStations();

        // when
        final int result = stations.totalNumber();

        // then
        assertThat(result).isEqualTo(3);
    }

    private Stations generateStations() {
        List<Station> stationList = new ArrayList<>();
        stationList.add(WEMBLEY_PARK);
        stationList.add(Station.passed("Green Park", LocalDate.now()));
        stationList.add(Station.notVisited("Elm Park"));
        return new Stations(stationList);
    }

}
