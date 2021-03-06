package dms.pastor.tools.trips.tube.options;

import dms.pastor.tools.trips.common.options.UpdateStationStatusToVisitedOption;
import dms.pastor.tools.trips.common.station.Stations;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Scanner;

import static dms.pastor.tools.trips.common.options.Status.VISITED;
import static dms.pastor.tools.trips.common.station.StationType.TUBE;
import static dms.pastor.tools.trips.tube.builders.StationBuilder.stationBuilder;
import static dms.pastor.tools.trips.tube.builders.StationsBuilder.stationsBuilder;
import static java.util.Collections.singletonList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class UpdateOvergroundStationNameStatusToVisitedOptionTest {

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
        given(scanner.nextLine()).willReturn(stations.getStationList().get(0).getName());

        // when
        updateStationStatusToVisited.choose(stations, TUBE);

        // then
        assertThat(stations.getStationList().get(0).getStatus()).isEqualTo(VISITED);
    }
}