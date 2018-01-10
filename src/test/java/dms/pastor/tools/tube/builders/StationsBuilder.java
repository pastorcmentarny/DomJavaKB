package dms.pastor.tools.tube.builders;

import dms.pastor.tools.tube.station.Station;
import dms.pastor.tools.tube.station.Stations;
import dms.pastor.tools.tube.station.Status;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static dms.pastor.tools.tube.station.Line.noLine;

public final class StationsBuilder {
    private List<Station> stationList = generateStations();

    private StationsBuilder() {
    }

    public static StationsBuilder stationsBuilder() {
        return new StationsBuilder();
    }

    public Stations build() {
        return new Stations(stationList);
    }

    public StationsBuilder stationList(List<Station> stationList) {
        this.stationList = stationList;
        return this;
    }

    private List<Station> generateStations() {
        List<Station> stationList = new ArrayList<>();
        stationList.add(new Station("Wembley Park", Status.VISITED, noLine(), LocalDate.now(), LocalDate.now(), LocalDate.now()));
        stationList.add(Station.passed("Green Park", noLine(), LocalDate.now()));
        stationList.add(Station.notVisited("Elm Park", noLine()));
        return stationList;
    }
}
