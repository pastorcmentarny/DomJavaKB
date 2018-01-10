package dms.pastor.tools.tube;

import dms.pastor.domain.exception.NotFoundException;
import dms.pastor.tools.tube.station.Line;
import dms.pastor.tools.tube.station.Station;
import dms.pastor.tools.tube.station.Stations;
import dms.pastor.tools.tube.station.Status;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static dms.pastor.tools.tube.station.Line.noLine;
import static dms.pastor.tools.tube.station.Status.*;
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

    private static final Station WEMBLEY_PARK = new Station("Wembley Park", Status.VISITED, noLine(), PASSED_DATE, VISITED_DATE, THIS_YEAR_VISITED_DATE);
    private static final String STATION_NOT_FOUND_ERROR_MESSAGE = "Station was not found.";
    private static final String STATION_NAME = "Amersham";
    private final List<Line> lines = Collections.singletonList(new Line("none"));
    @Rule
    public final ExpectedException exception = ExpectedException.none();
    private final Stations stations = generateStations();

    @Test
    public void getStationByNameShouldReturnStation() {
        // given
        final String stationName = STATION_NAME;
        final Station amershamStaton = Station.notVisited(stationName, lines);
        Stations stations = new Stations(Collections.singletonList(amershamStaton));

        // when
        Station result = stations.getStationByName(stationName);

        // then
        assertThat(result).isEqualTo(amershamStaton);

    }

    @Test
    public void setPassedForShouldSetStatusToPassIfStationHasStatusNotVisited() {
        // given
        final String stationName = STATION_NAME;
        final Station amersham = Station.notVisited(stationName, lines);
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
        final Station amersham = new Station(stationName, VISITED, lines, today, today, today);
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
        final Station amersham = new Station(stationName, NOT_VISITED, lines, today, today, today);
        Stations stations = new Stations(Collections.singletonList(amersham));

        // when
        stations.setVisitedFor(amersham);

        // then
        assertThat(stations.getStationByName(stationName).getStatus()).isEqualTo(VISITED);
    }

    @Test
    public void setVisitedForShouldSetStatusToVisitedIfStationHasStatusPassed() {
        // given
        final Station amersham = Station.passed(STATION_NAME, lines, PASSED_DATE);
        Stations stations = new Stations(Collections.singletonList(amersham));

        // when
        stations.setVisitedFor(amersham);

        // then
        assertThat(stations.getStationByName(STATION_NAME).getStatus()).isEqualTo(VISITED);
    }

    @Test
    public void setVisitedForShouldSetBothPassedDateAndVisitedDateWhenIfStationHasPreviouslyStatusNotVisited() {
        // given
        final Station amersham = Station.passed(STATION_NAME, lines, PASSED_DATE);
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
        final Station amersham = Station.passed(STATION_NAME, lines, yesterday);
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
        assertThat(count).isEqualTo(1);
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
        // expect
        exception.expect(NotFoundException.class);
        exception.expectMessage(STATION_NOT_FOUND_ERROR_MESSAGE);

        // when
        stations.findStation(null);
    }

    @Test
    public void findStationShouldThrowNotFoundExceptionWhenSearchForIsEmpty() {
        // expect
        exception.expect(NotFoundException.class);
        exception.expectMessage(STATION_NOT_FOUND_ERROR_MESSAGE);

        // when
        stations.findStation(EMPTY_STRING);
    }

    @Test
    public void findStationShouldThrowNotFoundExceptionWhenSearchForDoNotMatchAnyStation() {
        // expect
        exception.expect(NotFoundException.class);
        exception.expectMessage(STATION_NOT_FOUND_ERROR_MESSAGE);

        // when
        stations.findStation(generateString());
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
        final Station expectedStation = new Station(STATION_NAME, PASSED, noLine(), PASSED_DATE, null, null);

        // when
        final Station result = Station.passed(STATION_NAME, noLine(), PASSED_DATE);

        // then
        assertThat(result).isEqualTo(expectedStation);
    }

    @Test
    public void notVisitedShouldReturnStationWithoutPassedAndOrVisitedDate() {
        // given
        final Station expectedStation = new Station(STATION_NAME, NOT_VISITED, noLine(), null, null, null);

        // when
        final Station result = Station.notVisited(STATION_NAME, noLine());

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
        stationList.add(Station.passed("Green Park", noLine(), LocalDate.now()));
        stationList.add(Station.notVisited("Elm Park", noLine()));
        return new Stations(stationList);
    }

}
