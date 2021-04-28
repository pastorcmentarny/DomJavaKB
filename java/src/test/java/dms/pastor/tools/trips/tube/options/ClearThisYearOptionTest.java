package dms.pastor.tools.trips.tube.options;

import dms.pastor.tools.trips.common.options.ClearThisYearOption;
import dms.pastor.tools.trips.common.station.Stations;
import dms.pastor.tools.trips.common.station.Station;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static dms.pastor.tools.trips.common.options.Status.VISITED;
import static dms.pastor.tools.trips.common.station.StationType.TUBE;
import static dms.pastor.tools.trips.tube.builders.StationBuilder.stationBuilder;
import static dms.pastor.tools.trips.common.station.StationName.VICTORIA;
import static dms.pastor.tools.trips.common.station.StationName.WEMBLEY_PARK;
import static org.assertj.core.api.Assertions.assertThat;

public class ClearThisYearOptionTest {

    @Test
    public void shouldClearThisYearFieldForAllStationAcceptanceTest() {
        // given
        ClearThisYearOption clearThisYearOption = new ClearThisYearOption();
        List<Station> stationList = new ArrayList<>();
        stationList.add(stationBuilder().name(WEMBLEY_PARK.getStationName()).status(VISITED).noLines().build());
        stationList.add(stationBuilder().name(VICTORIA.getStationName()).status(VISITED).noLines().build());
        final Stations stations = new Stations(stationList);

        // when
        clearThisYearOption.choose(stations,TUBE);

        // then
        stations.getStationList().forEach(station -> assertThat(station.getVisitedThisYearDate()).isNull());
    }
}