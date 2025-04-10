package dms.pastor.tools.trips.tube.options;


import dms.pastor.tools.trips.common.options.UpdateStationStatusToPassedOption;
import dms.pastor.tools.trips.common.station.Stations;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Scanner;

import static dms.pastor.tools.trips.common.options.Status.PASSED;
import static dms.pastor.tools.trips.common.station.StationType.TUBE;
import static dms.pastor.tools.trips.tube.builders.StationBuilder.stationBuilder;
import static dms.pastor.tools.trips.tube.builders.StationsBuilder.stationsBuilder;
import static java.util.Collections.singletonList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

/**
 * Author Dominik Symonowicz
 * WWW:	<a href="https://dominiksymonowicz.com/">HOME PAGE</a>
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
@ExtendWith(MockitoExtension.class)
public class UpdateOvergroundStationNameStatusToPassedOptionTest {

    @Mock
    private Scanner scanner;

    @InjectMocks
    private UpdateStationStatusToPassedOption updateStationStatusToPassed;

    @Test
    public void shouldUpdateStationStatusToPassed() {
        // given
        final Stations stations = stationsBuilder()
                .stationList(singletonList(stationBuilder()
                        .buildNotVisitedStation()))
                .build();
        given(scanner.nextLine()).willReturn(stations.getStationList().get(0).getName());

        // when
        updateStationStatusToPassed.choose(stations, TUBE);

        // then
        assertThat(stations.getStationList().get(0).getStatus()).isEqualTo(PASSED);
    }
}