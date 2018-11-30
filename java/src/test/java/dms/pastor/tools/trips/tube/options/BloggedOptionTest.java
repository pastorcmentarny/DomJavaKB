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
import static java.util.Collections.singletonList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

/**
 * Author Dominik Symonowicz
 * Created 14/06/2018
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
@RunWith(MockitoJUnitRunner.class)
public class BloggedOptionTest {
    @Mock
    private Scanner scanner;

    @InjectMocks
    private BloggedOption bloggedOption;

    @Test
    public void shouldSetBloggedForStation() {
        // given
        final Stations stations = stationsBuilder()
                .stationList(singletonList(stationBuilder()
                        .blogged(false).build()
                ))
                .build();
        given(scanner.nextLine()).willReturn(stations.getTubeStationList().get(0).getName());

        // check
        assertThat(stations.getTubeStationList().get(0).isBlogged()).isFalse();

        // when
        bloggedOption.choose(stations);

        // then
        assertThat(stations.getTubeStationList().get(0).isBlogged()).isTrue();
    }
}