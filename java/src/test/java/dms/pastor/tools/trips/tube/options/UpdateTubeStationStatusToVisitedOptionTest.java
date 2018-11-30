package dms.pastor.tools.trips.tube.options;

import dms.pastor.tools.trips.tube.station.Stations;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Scanner;

import static dms.pastor.tools.trips.tube.builders.StationBuilder.stationBuilder;
import static dms.pastor.tools.trips.tube.builders.StationsBuilder.stationsBuilder;
import static dms.pastor.tools.trips.tube.station.Status.VISITED;
import static java.util.Collections.singletonList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class UpdateTubeStationStatusToVisitedOptionTest {
    @Mock
    private Scanner scanner;

    @InjectMocks
    private UpdateStationStatusToVisitedOption updateStationStatusToVisited;

    @Test
    public void shouldUpdateStationStatusToPassed() {
        // given
        final Stations stations = stationsBuilder()
                .stationList(singletonList(stationBuilder()
                        .buildNotVisitedStation()))
                .build();
        given(scanner.nextLine()).willReturn(stations.getTubeStationList().get(0).getName());

        // when
        updateStationStatusToVisited.choose(stations);

        // then
        assertThat(stations.getTubeStationList().get(0).getStatus()).isEqualTo(VISITED);
    }
}