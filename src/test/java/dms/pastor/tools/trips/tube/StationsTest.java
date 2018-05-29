package dms.pastor.tools.trips.tube;

import dms.pastor.domain.exception.NotFoundException;
import dms.pastor.tools.trips.tube.station.Line;
import dms.pastor.tools.trips.tube.station.Stations;
import dms.pastor.tools.trips.tube.station.Status;
import dms.pastor.tools.trips.tube.station.TubeStation;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static dms.pastor.tools.trips.tube.station.Line.noLine;
import static dms.pastor.tools.trips.tube.station.Status.*;
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

    private static final TubeStation WEMBLEY_PARK = new TubeStation("Wembley Park", Status.VISITED, noLine(), PASSED_DATE, VISITED_DATE, THIS_YEAR_VISITED_DATE);
    private static final String STATION_NOT_FOUND_ERROR_MESSAGE = "TubeStation was not found.";
    private static final String STATION_NAME = "Amersham";
    private final List<Line> lines = Collections.singletonList(new Line("none"));
    @Rule
    public final ExpectedException exception = ExpectedException.none();
    private final Stations stations = generateStations();

    @Test
    public void getStationByNameShouldReturnStation() {
        // given
        final String stationName = STATION_NAME;
        final TubeStation amershamTubeStation = TubeStation.notVisited(stationName, lines);
        Stations stations = new Stations(Collections.singletonList(amershamTubeStation));

        // when
        TubeStation result = stations.getStationByName(stationName);

        // then
        assertThat(result).isEqualTo(amershamTubeStation);

    }

    @Test
    public void setPassedForShouldSetStatusToPassIfStationHasStatusNotVisited() {
        // given
        final String stationName = STATION_NAME;
        final TubeStation amersham = TubeStation.notVisited(stationName, lines);
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
        final TubeStation amersham = new TubeStation(stationName, VISITED, lines, today, today, today);
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
        final TubeStation amersham = new TubeStation(stationName, NOT_VISITED, lines, today, today, today);
        Stations stations = new Stations(Collections.singletonList(amersham));

        // when
        stations.setVisitedFor(amersham);

        // then
        assertThat(stations.getStationByName(stationName).getStatus()).isEqualTo(VISITED);
    }

    @Test
    public void setVisitedForShouldSetStatusToVisitedIfStationHasStatusPassed() {
        // given
        final TubeStation amersham = TubeStation.passed(STATION_NAME, lines, PASSED_DATE);
        Stations stations = new Stations(Collections.singletonList(amersham));

        // when
        stations.setVisitedFor(amersham);

        // then
        assertThat(stations.getStationByName(STATION_NAME).getStatus()).isEqualTo(VISITED);
    }

    @Test
    public void setVisitedForShouldSetBothPassedDateAndVisitedDateWhenIfStationHasPreviouslyStatusNotVisited() {
        // given
        final TubeStation amersham = TubeStation.passed(STATION_NAME, lines, PASSED_DATE);
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
        final TubeStation amersham = TubeStation.passed(STATION_NAME, lines, yesterday);
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
        final TubeStation tubeStation = stations.findStation(WEMBLEY_PARK.getName());

        // then
        assertThat(tubeStation).isEqualTo(WEMBLEY_PARK);
    }

    @Test
    public void passedShouldReturnStationWithPassedDateButWithoutVisitedDate() {
        // given
        final TubeStation expectedTubeStation = new TubeStation(STATION_NAME, PASSED, noLine(), PASSED_DATE, null, null);

        // when
        final TubeStation result = TubeStation.passed(STATION_NAME, noLine(), PASSED_DATE);

        // then
        assertThat(result).isEqualTo(expectedTubeStation);
    }

    @Test
    public void notVisitedShouldReturnStationWithoutPassedAndOrVisitedDate() {
        // given
        final TubeStation expectedTubeStation = new TubeStation(STATION_NAME, NOT_VISITED, noLine(), null, null, null);

        // when
        final TubeStation result = TubeStation.notVisited(STATION_NAME, noLine());

        // then
        assertThat(result).isEqualTo(expectedTubeStation);

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
        List<TubeStation> tubeStationList = new ArrayList<>();
        tubeStationList.add(WEMBLEY_PARK);
        tubeStationList.add(TubeStation.passed("Green Park", noLine(), LocalDate.now()));
        tubeStationList.add(TubeStation.notVisited("Elm Park", noLine()));
        return new Stations(tubeStationList);
    }

}
