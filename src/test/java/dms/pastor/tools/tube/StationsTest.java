package dms.pastor.tools.tube;

import org.junit.Test;

import java.util.Collections;
import java.util.List;

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
}