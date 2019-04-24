package dms.pastor.tools.trips.tube.builders;

import dms.pastor.tools.trips.tube.station.Station;
import dms.pastor.tools.trips.tube.station.Stations;
import dms.pastor.tools.trips.tube.station.TubeStation;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static dms.pastor.tools.trips.common.options.Status.VISITED;
import static dms.pastor.tools.trips.tube.builders.StationBuilder.stationBuilder;

public final class StationsBuilder {
    private List<TubeStation> tubeStationList = generateStations();

    private StationsBuilder() {
    }

    public static StationsBuilder stationsBuilder() {
        return new StationsBuilder();
    }

    public Stations build() {
        return new Stations(tubeStationList);
    }

    public StationsBuilder stationList(List<TubeStation> tubeStationList) {
        this.tubeStationList = tubeStationList;
        return this;
    }

    private List<TubeStation> generateStations() {
        List<TubeStation> tubeStationList = new ArrayList<>();
        tubeStationList.add(stationBuilder().name(Station.WEMBLEY_PARK.getStationName()).status(VISITED).noLines().build());
        tubeStationList.add(TubeStation.passed("Green Park", LocalDate.now()));
        tubeStationList.add(TubeStation.notVisited("Elm Park"));
        return tubeStationList;
    }
}
