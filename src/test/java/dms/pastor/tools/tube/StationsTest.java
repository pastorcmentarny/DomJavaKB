package dms.pastor.tools.tube;

import dms.pastor.domain.exception.NotFoundException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static dms.pastor.tools.tube.Line.noLine;
import static dms.pastor.tools.tube.Status.*;
import static dms.pastor.utils.StringUtils.EMPTY_STRING;
import static dms.pastor.utils.randoms.RandomDataGenerator.generateString;
import static org.assertj.core.api.Assertions.assertThat;

public class StationsTest {
    private static final Station WEMBLEY_PARK = new Station("Wembley Park", Status.VISITED, noLine());
    private static final String STATION_NOT_FOUND_ERROR_MESSAGE = "Station was not found.";
    private final List<Line> lines = Collections.singletonList(new Line("none"));
    private Stations stations = generateStations();


    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void getStationByNameShouldReturnStation() {
        // given
        final String stationName = "Amersham";
        final Station amershamStaton = new Station(stationName, NOT_VISITED, lines);
        Stations stations = new Stations(Collections.singletonList(amershamStaton));

        // when
        Station result = stations.getStationByName(stationName);

        // then
        assertThat(result).isEqualTo(amershamStaton);

    }

    @Test
    public void setPassedForShouldSetStatusToPassIfStationHasStatusNotVisited() {
        // given
        final String stationName = "Amersham";
        final Station amersham = new Station(stationName, NOT_VISITED, lines);
        Stations stations = new Stations(Collections.singletonList(amersham));

        // when
        stations.setPassedFor(amersham);

        // then
        assertThat(stations.getStationByName(stationName).getStatus()).isEqualTo(PASSED);

    }

    @Test
    public void setPassedForShouldNotChangeStatusToPassedForVisited() {
        // given
        final String stationName = "Amersham";
        final Station amersham = new Station(stationName, VISITED, lines);
        Stations stations = new Stations(Collections.singletonList(amersham));

        // when
        stations.setPassedFor(amersham);

        // then
        assertThat(stations.getStationByName(stationName).getStatus()).isEqualTo(VISITED);
    }

    @Test
    public void setVisitedForShouldSetStatusToVisitedIfStationHasStatusNotVisited() {
        // given
        final String stationName = "Amersham";
        final Station amersham = new Station(stationName, NOT_VISITED, lines);
        Stations stations = new Stations(Collections.singletonList(amersham));

        // when
        stations.setVisitedFor(amersham);

        // then
        assertThat(stations.getStationByName(stationName).getStatus()).isEqualTo(VISITED);
    }

    @Test
    public void setVisitedForShouldSetStatusToVisitedIfStationHasStatusPassed() {
        // given
        final String stationName = "Amersham";
        final Station amersham = new Station(stationName, PASSED, lines);
        Stations stations = new Stations(Collections.singletonList(amersham));

        // when
        stations.setVisitedFor(amersham);

        // then
        assertThat(stations.getStationByName(stationName).getStatus()).isEqualTo(VISITED);

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

    private Stations generateStations() {
        List<Station> stationList = new ArrayList<>();
        stationList.add(WEMBLEY_PARK);
        stationList.add(new Station("Green Park", Status.PASSED, noLine()));
        stationList.add(new Station("Elm Park", Status.NOT_VISITED, noLine()));
        return new Stations(stationList);
    }

}
