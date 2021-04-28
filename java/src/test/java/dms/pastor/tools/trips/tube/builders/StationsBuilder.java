package dms.pastor.tools.trips.tube.builders;

import dms.pastor.tools.trips.common.station.StationName;
import dms.pastor.tools.trips.common.station.Stations;
import dms.pastor.tools.trips.common.station.Station;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static dms.pastor.tools.trips.common.options.Status.VISITED;
import static dms.pastor.tools.trips.tube.builders.StationBuilder.stationBuilder;

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
        stationList.add(stationBuilder().name(StationName.WEMBLEY_PARK.getStationName()).status(VISITED).noLines().build());
        stationList.add(Station.passed("Green Park", LocalDate.now()));
        stationList.add(Station.notVisited("Elm Park"));
        return stationList;
    }
}
