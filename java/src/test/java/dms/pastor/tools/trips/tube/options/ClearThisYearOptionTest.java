package dms.pastor.tools.trips.tube.options;

import dms.pastor.tools.trips.tube.station.Station;
import dms.pastor.tools.trips.tube.station.Stations;
import dms.pastor.tools.trips.tube.station.TubeStation;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static dms.pastor.tools.trips.tube.builders.StationBuilder.stationBuilder;
import static dms.pastor.tools.trips.common.options.Status.VISITED;
import static org.assertj.core.api.Assertions.assertThat;

public class ClearThisYearOptionTest {

    @Test
    public void shouldClearThisYearFieldForAllStationAcceptanceTest() {
        // given
        ClearThisYearOption clearThisYearOption = new ClearThisYearOption();
        List<TubeStation> tubeStationList = new ArrayList<>();
        tubeStationList.add(stationBuilder().name(Station.WEMBLEY_PARK.getStationName()).status(VISITED).noLines().build());
        tubeStationList.add(stationBuilder().name(Station.VICTORIA.getStationName()).status(VISITED).noLines().build());
        final Stations stations = new Stations(tubeStationList);

        // when
        clearThisYearOption.choose(stations);

        // then

        stations.getTubeStationList().forEach(station -> assertThat(station.getVisitedThisYearDate()).isNull());
    }
}