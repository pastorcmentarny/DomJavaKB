package dms.pastor.tools.trips.tube.builders;

import dms.pastor.tools.trips.tube.station.Stations;
import dms.pastor.tools.trips.tube.station.Status;
import dms.pastor.tools.trips.tube.station.TubeStation;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static dms.pastor.tools.trips.tube.station.Line.noLine;

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
        tubeStationList.add(new TubeStation("Wembley Park", Status.VISITED, noLine(), LocalDate.now(), LocalDate.now(), LocalDate.now()));
        tubeStationList.add(TubeStation.passed("Green Park", noLine(), LocalDate.now()));
        tubeStationList.add(TubeStation.notVisited("Elm Park", noLine()));
        return tubeStationList;
    }
}
