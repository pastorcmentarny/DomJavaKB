package dms.pastor.tools.tube;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static dms.pastor.tools.tube.Line.noLine;
import static dms.pastor.tools.tube.Status.*;
import static org.assertj.core.api.Assertions.assertThat;

public class StationsTest {
    private final List<Line> lines = Collections.singletonList(new Line("none"));

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
        // given
        Stations stations = generateStations();

        // when
        final long count = stations.countStationPassed();

        // then
        assertThat(count).isEqualTo(1);
    }

    @Test
    public void countStationPassedShouldCountStationVisited() {
        // given
        Stations stations = generateStations();

        // when
        final long count = stations.countStationVisited();

        // then
        assertThat(count).isEqualTo(1);
    }

    private Stations generateStations() {
        List<Station> stationList = new ArrayList<>();
        stationList.add(new Station("Wembley Park", Status.VISITED, noLine()));
        stationList.add(new Station("Green Park", Status.PASSED, noLine()));
        stationList.add(new Station("Elm Park", Status.NOT_VISITED, noLine()));
        return new Stations(stationList);
    }

}
