package dms.pastor.tools.tube.options;


import dms.pastor.tools.tube.station.Stations;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Scanner;

import static dms.pastor.tools.tube.builders.StationBuilder.stationBuilder;
import static dms.pastor.tools.tube.builders.StationsBuilder.stationsBuilder;
import static dms.pastor.tools.tube.station.Status.PASSED;
import static java.util.Collections.singletonList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

/**
 * Author Dominik Symonowicz
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
@RunWith(MockitoJUnitRunner.class)
public class UpdateStationStatusToPassedOptionTest {

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
        updateStationStatusToPassed.choose(stations);

        // then
        assertThat(stations.getStationList().get(0).getStatus()).isEqualTo(PASSED);
    }
}